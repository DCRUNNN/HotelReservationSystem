package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.controller.HotelRoomControllerImpl;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.RoomVO;

public class ShowClientExecutedOrderView extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private OrderTable myTable;
	
	private JTable orderTable;
	
	private HotelOrderControllerService controller;
	
	private String hotelId;
	
	private String clientId;
	
	private String roomNumber;
	
	public ShowClientExecutedOrderView(HotelOrderControllerService controller){
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.clientId=controller.getClientId();
		init();
	}

	public void init(){
		//客户可能预定了多个房间
		List<RoomVO> clientRoomList=controller.getAllRooms(clientId, hotelId);
		
		int clientRooms=clientRoomList.size();
		if(clientRooms==0){
			JOptionPane.showMessageDialog(null, "该客户尚未有订单！","操作失败",JOptionPane.WARNING_MESSAGE);	
			return;
		}else{
			//若客户有预订房间 有订单 则建立界面
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(200, 300, 1300, 500);
//			setUndecorated(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.setOpaque(false);
			setContentPane(contentPane);
	
			//建立表格
			String[] titleName={"客户ID","房间号","房间类型","房间价格","房间预订时间"};
			String[][] data=new String[clientRooms][];
			for(int i=0;i<clientRooms;i++){
				RoomVO temp=clientRoomList.get(i);
				data[i]=new String[titleName.length];
				String[] s=new String[]{clientId,temp.getRoomNumber(),temp.getRoomType(),
							temp.getPrice()+"",temp.getBookDate()};
				
				for(int j=0;j<s.length;j++){
					data[i][j]=s[j];
				}//end for
			}//end for

			//表格模型
			myTable=new OrderTable(data, titleName);
			orderTable=new JTable(myTable);
			orderTable.setBorder(BorderFactory.createEtchedBorder());
			orderTable.setFillsViewportHeight(true);
			orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
			orderTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
			orderTable.setRowHeight(25);	
			
			JScrollPane scrollPane=new JScrollPane(orderTable);
			scrollPane.setBounds(0, 0, 1300, 350);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			//设置表格
		    // 设置table表头居中
		    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
		    thRenderer.setHorizontalAlignment(JLabel.CENTER);
		    orderTable.getTableHeader().setDefaultRenderer(thRenderer);
		    // 设置table内容居中
		    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
		    tcRender.setHorizontalAlignment(JLabel.CENTER);
		    orderTable.setDefaultRenderer(Object.class, tcRender);
		    
		    for(int i=0;i<orderTable.getColumnCount();i++){
		    	if(i==0||i==1||i==2){
		    		orderTable.getColumnModel().getColumn(i).setPreferredWidth(0);
		    	}
		    }
		    
			contentPane.add(scrollPane);
			
			JButton checkoutBT=new JButton("办理退房");
			checkoutBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
			checkoutBT.setBounds(400,380,150,40);
			checkoutBT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					controller.confirmCheckOutButtonClicked();
				}
			});
			contentPane.add(checkoutBT);
			
			JButton cancelBT=new JButton("取消");
			cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
			cancelBT.setBounds(700, 380, 150, 40);
			cancelBT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			contentPane.add(cancelBT);
			
		}//end else			
		
	}//end method

	public void confirmButtonClicked(){
		int index=orderTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(null, "选择有误","操作失败",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		roomNumber=(String)orderTable.getValueAt(index, 1);
		boolean flag=controller.checkOutRoom(clientId, hotelId, roomNumber);
		if(flag==true){
			JOptionPane.showMessageDialog(this, "退房成功！","操作成功",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			HotelRoomControllerService controllerService=new HotelRoomControllerImpl(hotelId);
			InitManageRoomView view=new InitManageRoomView(controllerService);
			controllerService.setInitManageRoomView(view);
			view.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "退房失败","操作失败",JOptionPane.ERROR_MESSAGE);
		}
	}	
	
}
