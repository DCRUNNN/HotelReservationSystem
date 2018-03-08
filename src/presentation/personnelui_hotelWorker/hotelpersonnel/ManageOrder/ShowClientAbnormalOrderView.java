package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.controller.HotelOrderControllerImpl;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.OrderVO;
import vo.RoomVO;

public class ShowClientAbnormalOrderView extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private DetailedOrderTable myTable;
	
	private JTable orderTable;
	
	private HotelOrderControllerService controller;
	
	private String hotelId;
	
	private String clientId;
	
	private String orderId;
		
	private String[] roomNumbers;
	
	private String[] roomTypes;
	
	private int roomTotal;
	
	public ShowClientAbnormalOrderView(HotelOrderControllerService controller){
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.orderId=controller.getOrderId();
		this.clientId=controller.getClientId();
		init();
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(580, 300, 800, 340);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		setContentPane(contentPane);
				
		String temp=controller.getDelayRoomNumber(orderId,hotelId);
		if(temp.contains("无空闲房间")){
			JOptionPane.showMessageDialog(this, "无空闲房间！办理延迟入住失败","无法办理延迟入住",JOptionPane.ERROR_MESSAGE);
			return;
		}
		roomNumbers=controller.getDelayRoomNumber(orderId, hotelId).split("/");
		roomTotal=roomNumbers.length;

		//建立表格
		String[] titleName={"房间号","房间类型","房间单价","有无儿童","房间人数"};
		
		String price="";
		String type="";
		for(int i=0;i<roomTotal;i++){
			RoomVO vo=controller.getRoomByNum(hotelId, roomNumbers[i]);
			type+=vo.getRoomType()+"/";
			price+=String.valueOf(vo.getPrice())+"/";
		}
		
		String[] roomPrices=price.split("/");//保存房间价格
		roomTypes=type.split("/");//房间类别
		
		//数据
		String[][] data=new String[roomTotal][];
		for(int i=0;i<roomTotal;i++){
			data[i]=new String[titleName.length];
			String[] s=new String[]{roomNumbers[i],roomTypes[i],roomPrices[i],"",""};
			
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		//模型
		myTable=new DetailedOrderTable(data, titleName);
		orderTable=new JTable(myTable);
		orderTable.setBorder(BorderFactory.createEtchedBorder());
		orderTable.setFillsViewportHeight(true);
		
		JComboBox<String> childBox=new JComboBox<String>();
		childBox.addItem("有");
		childBox.addItem("无");
		
		orderTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(childBox));
		orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		orderTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		orderTable.setRowHeight(25);	
		
		JScrollPane scrollPane=new JScrollPane(orderTable);
		scrollPane.setBounds(0, 0,800, 200);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	    // 设置table表头居中
	    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
	    thRenderer.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.getTableHeader().setDefaultRenderer(thRenderer);
	    // 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.setDefaultRenderer(Object.class, tcRender);
	    
	    contentPane.add(scrollPane);
	    
	    JButton confirmDelayButton=new JButton("确认办理延迟入住");
	    confirmDelayButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
	    confirmDelayButton.setBounds(140,215,190,50);
	    confirmDelayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.confirmDelayButtonClicked();
			}
		});
	    contentPane.add(confirmDelayButton);
	    
	    JButton cancelBT=new JButton("取消");
	    cancelBT.setFont(new Font("微软雅黑",Font.PLAIN,18));
	    cancelBT.setBounds(465,215,150,50);
	    contentPane.add(cancelBT);
	    
	    setVisible(true);
		
	}
	
	public void executeOrderButtonClicked(){
		int index=orderTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(null, "请选择订单！","操作失败",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		boolean flag=false;
		
		for(int i=0;i<roomTotal;i++){
			flag=!(orderTable.getValueAt(i, 3).equals("")||orderTable.getValueAt(i, 4).equals(""));
			//若没有输入有无儿童和房间人数 则flag为false
		}	
		
		if(flag==false){
			JOptionPane.showMessageDialog(null, "请输入每间房有无儿童和每间房的人数","信息填写不完整",JOptionPane.WARNING_MESSAGE);
		}else{
			boolean check=false;
			for(int i=0;i<roomTotal;i++){
				//设置房间人数以及有无儿童
				controller.setRoomChild(roomNumbers[i], transform((String)orderTable.getValueAt(i,3)));
				controller.setRoomPeople(roomNumbers[i], Integer.parseInt((String)orderTable.getValueAt(i, 4)));
			}
			check=controller.executeOrder();
			if(check==true){
				JOptionPane.showMessageDialog(null, "成功执行订单！","操作成功",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				ManageOrderView view=new ManageOrderView(controller);
				controller.setManageOrderView(view);
				view.setVisible(true);
				//更新订单列表
				
			}else{
				JOptionPane.showMessageDialog(null, "执行订单失败","操作失败",JOptionPane.WARNING_MESSAGE);
				ManageOrderView view=new ManageOrderView(controller);
				controller.setManageOrderView(view);
				view.setVisible(true);
			}
		}	
	}
	
	public boolean transform(String str){
		if(str.equals("无")){
			return false;
		}
		return true;
	}

}
