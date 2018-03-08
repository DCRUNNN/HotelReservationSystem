package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.ClientVO;
import vo.OrderVO;
import vo.RoomVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ProcessOrderView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private HotelOrderControllerService controller;
	
	private DetailedOrderTable myTable;
	
	private JTable orderTable;
	
	private JTextField begindateField;
	
	private String hotelId;
	
	private String clientId;
	
	private String orderId;
	
	private OrderVO order;
	
	private ClientVO client;
	
	private int roomTotal;
	
	private String[] roomNumbers;
	
	private String[] roomTypes;
	
	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
	 */
	public ProcessOrderView(HotelOrderControllerService controller) {
		this.controller=controller;
		this.clientId=controller.getClientId();
		this.hotelId=controller.getHotelId();
		this.orderId=controller.getOrderId();
		init();
	}
	
	public void init(){
		//获得一个ordervo控制相关信息
		order=controller.getOrder(orderId);

		//初始化界面
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		  
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setBounds(24, 15, 1150, 776);
	    bottomPanel.setBackground(Color.CYAN);
	    bottomPanel.setLayout(null);
		
		//设置界面组件
		//最小化与关闭按钮
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		contentPane.add(closeLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1146, 13, 40, 40);
		contentPane.add(closeBT);		
		closeBT.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.BLACK);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
		minLabel.setBounds(1097, 18, 26, 30);
		contentPane.add(minLabel);
		
		JButton minBT=new CircleButton_min("");
		minBT.setBackground(Color.WHITE);
		minBT.setBounds(1083, 13, 40, 40);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setExtendedState(ICONIFIED);
			}
		});
		contentPane.add(minBT);
		
		//可自由拖拽的label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		contentPane.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
				
		JLabel label = new JLabel("\u5BA2\u6237\u4FE1\u606F");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		label.setBounds(37, 31, 112, 33);
		bottomPanel.add(label);
		
		JLabel nameLabel = new JLabel("\u4E3B\u5BA2\u59D3\u540D");
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		nameLabel.setBounds(67, 91, 93, 21);
		bottomPanel.add(nameLabel);
		
		JLabel nameField = new JLabel();
		nameField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nameField.setBounds(175, 92, 144, 21);
		nameField.setText(order.getClientName());
		bottomPanel.add(nameField);
		
		JLabel phoneLabel = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		phoneLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		phoneLabel.setBounds(273, 91, 93, 21);
		bottomPanel.add(phoneLabel);
		
		JLabel phoneField = new JLabel();
		phoneField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		phoneField.setBounds(363, 92, 170, 21);
		phoneField.setText(order.getPhoneNumber());
		bottomPanel.add(phoneField);
		
		JLabel creditLabel = new JLabel("\u4FE1\u7528\u503C");
		creditLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		creditLabel.setBounds(531, 91, 74, 21);
		bottomPanel.add(creditLabel);
		
		JLabel creditField = new JLabel();
		creditField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		creditField.setBounds(620, 91, 81, 21);
		creditField.setText(order.getCredit()+"");
		bottomPanel.add(creditField);
		
		JLabel vipLabel = new JLabel("\u4F1A\u5458\u7C7B\u578B");
		vipLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		vipLabel.setBounds(67, 145, 93, 21);
		bottomPanel.add(vipLabel);
		
		JLabel vipField = new JLabel();
		vipField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		vipField.setBounds(165, 145, 134, 21);
		vipField.setText(order.getVipInfo());
		bottomPanel.add(vipField);
		
		JLabel clientIdentityLabel = new JLabel("身份证");
		clientIdentityLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		clientIdentityLabel.setBounds(747, 91, 83, 21);
		bottomPanel.add(clientIdentityLabel);
		
		JLabel clientIdentityField = new JLabel();
		clientIdentityField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		clientIdentityField.setBounds(834, 92, 296, 21);
		clientIdentityField.setText(order.getIdentityID());
		bottomPanel.add(clientIdentityField);
		
		JLabel label_1 = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		label_1.setBounds(37, 189, 105, 27);
		bottomPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BA2\u5355\u53F7");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_2.setBounds(67, 253, 81, 21);
		bottomPanel.add(label_2);
		
		JLabel orderIdField = new JLabel();
		orderIdField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		orderIdField.setBounds(151, 253, 148, 21);
		orderIdField.setText(order.getOrderID());
		bottomPanel.add(orderIdField);
		
		JLabel label_4 = new JLabel("\u8BA2\u5355\u72B6\u6001");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_4.setBounds(328, 253, 93, 21);
		bottomPanel.add(label_4);
		
		JLabel orderStateField = new JLabel("\u672A\u6267\u884C");
		orderStateField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		orderStateField.setBounds(437, 254, 81, 21);
		orderStateField.setText(order.getOrderStatus());
		
		bottomPanel.add(orderStateField);
		
		JLabel label_6 = new JLabel("\u8BA2\u5355\u603B\u4EF7");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_6.setBounds(531, 253, 105, 21);
		bottomPanel.add(label_6);
		
		JLabel priceField = new JLabel();
		priceField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		priceField.setBounds(630, 254, 81, 21);
		priceField.setText(order.getPrice()+"");
		bottomPanel.add(priceField);
		
		JLabel label_8 = new JLabel("\u9884\u5B9A\u65F6\u95F4");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_8.setBounds(727, 253, 98, 21);
		bottomPanel.add(label_8);
		
		JLabel bookdateField = new JLabel();
		bookdateField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bookdateField.setBounds(834, 253, 228, 21);
		bookdateField.setText(order.getOrderCreatedDate());
		bottomPanel.add(bookdateField);
		
		JLabel lblNewLabel = new JLabel("\u4FDD\u7559\u65F6\u95F4");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		lblNewLabel.setBounds(52, 301, 93, 21);
		bottomPanel.add(lblNewLabel);
		
		JLabel keepdateField = new JLabel();
		keepdateField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		keepdateField.setBounds(151, 302, 215, 21);
		keepdateField.setText(order.getOrderLastDate());
		bottomPanel.add(keepdateField);
		
		JLabel lblNewLabel_2 = new JLabel("\u5165\u4F4F\u65F6\u95F4");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(384, 301, 93, 21);
		bottomPanel.add(lblNewLabel_2);
		
		begindateField = new JTextField();
		begindateField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		begindateField.setBounds(490, 302, 209, 25);
		begindateField.setText(order.getOrderBeginDate());
		bottomPanel.add(begindateField);
		
		JLabel label_10 = new JLabel("\u79BB\u5E97\u65F6\u95F4");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_10.setBounds(727, 301, 93, 21);
		bottomPanel.add(label_10);
		
		JTextField enddateField = new JTextField();
		enddateField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		enddateField.setBounds(835, 302, 202, 25);
		enddateField.setEditable(false);
		enddateField.setText(order.getOrderEndDate());
		bottomPanel.add(enddateField);
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u95F4\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(37, 386, 105, 27);
		bottomPanel.add(lblNewLabel_1);
				
		//创建表格
		String[] titleName={"房间号","房间类型","房间单价","有无儿童","房间人数"};
		
//		roomNumbers=order.getRoomNumber().split("/");
		roomTypes=order.getRoomType().split("/");
		roomNumbers=controller.getAllRoomNumber(orderId).split("/");
//		roomTypes=controller.getAllRoomType(orderId).split("/");  //wrong!!!
		roomTotal=roomNumbers.length;
		
		//数据
		String[][] data=new String[roomTotal][];
	
		String price="";
		for(int i=0;i<roomTotal;i++){
			RoomVO tempRoom=controller.getRoomByNum(hotelId, roomNumbers[i]);
			price+=String.valueOf(tempRoom.getPrice())+"/";
		}
		String[] roomPrices=price.split("/");
		
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
		
		if(order.getPeopleNumber().equals("")||order.getPeopleNumber()==null
				||order.getHasChild().equals("")||order.getHasChild()==null){
			for(int i=0;i<roomTotal;i++){
				orderTable.setValueAt("0", i, 4);
				orderTable.setValueAt("请选择", i, 3);
			}
		}else{
			String[] peopleNum=order.getPeopleNumber().split("/");
			String[] check=order.getHasChild().split("/");
			for(int i=0;i<roomTotal;i++){
				orderTable.setValueAt(peopleNum[i], i, 4);
				if(check[i].equals("true")){
					orderTable.setValueAt("有", i, 3);
				}else{
					orderTable.setValueAt("无", i, 3);
				}
			}
		}
		
		orderTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(childBox));
		orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		orderTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		orderTable.setRowHeight(25);	
		
		JScrollPane scrollPane=new JScrollPane(orderTable);
		scrollPane.setBounds(67, 428, 1032, 255);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//调整表格
	    // 设置table表头居中
	    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
	    thRenderer.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.getTableHeader().setDefaultRenderer(thRenderer);
	    // 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.setDefaultRenderer(Object.class, tcRender);
	    
	    bottomPanel.add(scrollPane);
	    
	    JButton getTimeBT1 = new JButton("\u8F93\u5165\u65F6\u95F4");
	    getTimeBT1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		Date current = new Date();
	    		String orderCreatedDate = formatter.format(current);
	    		begindateField.setText(orderCreatedDate);
	    	}
	    });
	    getTimeBT1.setFont(new Font("微软雅黑", Font.PLAIN, 19));
	    getTimeBT1.setBounds(370, 337, 116, 24);
	    bottomPanel.add(getTimeBT1);
	    
	    JButton executeBT = new JButton("\u6267\u884C\u8BA2\u5355");
	    executeBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
	    executeBT.setBounds(312, 730, 123, 29);
	    executeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.confirmButtonClicked();
			}
		});
	    
	    if(order.getOrderStatus().equals("已执行")){
			executeBT.setEnabled(false);
			begindateField.setEditable(false);
		}
	    
	    bottomPanel.add(executeBT);
	    
	    JButton backBT = new JButton("\u8FD4\u56DE");
	    backBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
	    backBT.setBounds(681, 730, 123, 29);
	    backBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int response=JOptionPane.showConfirmDialog(contentPane, "确定要离开此页面吗？","提示",JOptionPane.YES_NO_OPTION);
				if(response==0){
					ManageOrderView view=new ManageOrderView(controller);
					controller.setManageOrderView(view);
					view.setVisible(true);
					dispose();
				}
			}
		});
	    bottomPanel.add(backBT);
	    bottomPanel.setOpaque(false);
	    
	    contentPane.add(bottomPanel);
	   
	}
	
	public void confirmButtonClicked(){
		boolean flag=false;
		
		for(int i=0;i<roomTotal;i++){
			//第三列是有无儿童 第四列是房间人数(从0开始算)
			flag=!(orderTable.getValueAt(i, 3).equals("")||orderTable.getValueAt(i, 3).equals("请选择")
					||orderTable.getValueAt(i, 4).equals("")
					||orderTable.getValueAt(i, 4).equals("0"));
			//若没有输入有无儿童和房间人数 则flag为false
		}
		
		if(begindateField.getText().equals("")||begindateField.getText().equals(null)){
			flag=false;  //若没有输入入住时间 则flag为false
		}
		
		if(flag==false){
			JOptionPane.showMessageDialog(null, "请输入每间房有无儿童和每间房的人数以及入住时间","信息填写不完整",JOptionPane.WARNING_MESSAGE);
			begindateField.setText("");
		}else{
			boolean check=false;
			for(int i=0;i<roomTotal;i++){
				//设置房间有无儿童和每间房的人数
				controller.setRoomChild(roomNumbers[i], transform((String)orderTable.getValueAt(i,3)));
				controller.setRoomPeople(roomNumbers[i], Integer.parseInt((String)orderTable.getValueAt(i, 4)));
			}
			check=controller.executeOrder();
			if(check==true){
				JOptionPane.showMessageDialog(null, "成功执行订单！","操作成功",JOptionPane.INFORMATION_MESSAGE);
				begindateField.setText("");
				dispose();
				ManageOrderView view=new ManageOrderView(controller);
				controller.setManageOrderView(view);
				view.setVisible(true);
				//更新订单列表
				
			}else{
				JOptionPane.showMessageDialog(null, "执行订单失败","操作失败",JOptionPane.WARNING_MESSAGE);
				begindateField.setText("");
				dispose();
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
