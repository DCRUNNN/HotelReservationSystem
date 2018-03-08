package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.HotelStrategyControllerImpl;
import presentation.controller.InitHotelViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.OrderVO;
import vo.RoomVO;

public class ManageOrderView extends JFrame {

	private JPanel contentPane;

	private JButton detailedBT;
	
	private JButton executeBT;
	
	private JButton delayBT;
	
	private JButton backBT;
	
	private JTextField orderIdField;
	
	private JPanel orderPanel;
	
	private JTable orderTable;
	
	private OrderTable myTable;
	
	private DetailedOrderTable myTable2;
		
	private JComboBox<String> typeBox;
	
	private HotelOrderControllerService controller;
	
	private String orderId;
	
	private String hotelId;
	
	private String clientId;
	
	private JTextField delayTextField;
	
	private String[] roomNumbers;
	
	private String[] roomTypes;
	
	private int roomTotal;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new HotelWorkerRunner();
//					HotelOrderControllerService controller=new HotelOrderControllerImpl("00001", "", "");
//					ManageOrderView frame = new ManageOrderView(controller);
//					controller.setManageOrderView(frame);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ManageOrderView(HotelOrderControllerService controller) {
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		initFrame();
		fillComboBox();
		initOrderTable();
	}
	
	public void initFrame(){
		//设置窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background.jpg").getImage();
		contentPane = new BackgroundPanel(new ImageIcon("background6.jpg").getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
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

		JButton headButton=new JButton();
		headButton.setBounds(54, 29, 170, 170);
		headButton.setIcon(new ImageIcon("hotelPersonnel.jpg"));
		headButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageInfoButtonClicked();
			}
		});
		contentPane.add(headButton);
		
		JLabel label = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label.setBounds(70, 228, 143, 48);
		label.setFont(new Font("微软雅黑", Font.BOLD, 24));
		contentPane.add(label);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageHotelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageHotelButtonClicked();
			}
		});
		contentPane.add(manageHotelBT);
		
		JButton manageRoomBT = new JButton(new ImageIcon("manageRoom.jpg"));
		manageRoomBT.setBounds(54, 381, 170, 60);
		manageRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageRoomButtonClicked();
			}
		});
		contentPane.add(manageRoomBT);
		
		JButton manageStrategyBT = new JButton(new ImageIcon("manageStrategy.jpg"));
		manageStrategyBT.setBounds(53, 466, 170, 60);
		manageStrategyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageStrategyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageStrategyButtonClicked();
			}
		});
		contentPane.add(manageStrategyBT);
		
		JButton manageOrderBT = new JButton(new ImageIcon("manageOrder.jpg"));
		manageOrderBT.setBounds(54, 555, 170, 60);
		manageOrderBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageOrderBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageOrderButtonClicked();
			}
		});
		contentPane.add(manageOrderBT);
		
		JButton manageCompanyBT = new JButton(new ImageIcon("companyCooperation.jpg"));
		manageCompanyBT.setBounds(54, 644, 170, 60);
		manageCompanyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked();
			}
		});
		contentPane.add(manageCompanyBT);
		
		JLabel label_1 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_1.setBounds(331, 40, 91, 21);
		contentPane.add(label_1);
		
		orderIdField = new JTextField();
		orderIdField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		orderIdField.setBounds(441, 40, 186, 27);
		contentPane.add(orderIdField);
		orderIdField.setColumns(10);
		
		JButton searchBT = new JButton(new ImageIcon("findOrder.jpg"));
		searchBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		searchBT.setBounds(659, 40, 123, 29);
		searchBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.searchButtonClicked();
			}
		});
		contentPane.add(searchBT);
		
		detailedBT = new JButton(new ImageIcon("checkDetail_hotel.jpg"));
		detailedBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		detailedBT.setBounds(419, 680, 123, 29);
		detailedBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.detailedButtonClicked();
			}
		});
		contentPane.add(detailedBT);
		
		executeBT = new JButton(new ImageIcon("executeOrder.jpg"));
		executeBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		executeBT.setBounds(597, 680, 123, 29);
		executeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.entryButtonClicked();
			}
		});
		contentPane.add(executeBT);
		
		delayBT = new JButton(new ImageIcon("delayCheckIn.jpg"));
		delayBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		delayBT.setBounds(763, 680, 123, 29);
		delayBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.delayButtonClicked();
			}
		});
		contentPane.add(delayBT);
		
		backBT = new JButton(new ImageIcon("return2_hotel.jpg"));
		backBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		backBT.setBounds(931, 680, 123, 29);
		backBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageHotelButtonClicked();
			}
		});
		contentPane.add(backBT);
		
		JLabel typeLabel = new JLabel("\u8BA2\u5355\u7C7B\u578B");
		typeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		typeLabel.setBounds(886, 65, 91, 21);
		contentPane.add(typeLabel);
	}
	
	public void fillComboBox(){
		
		typeBox = new JComboBox<String>();
		typeBox.setBounds(992, 65, 137, 27);
		typeBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		contentPane.add(typeBox);
		
		List<String> orderTypeList=new ArrayList<String>();
		orderTypeList.add("所有类型");
		orderTypeList.add("未执行订单");
		orderTypeList.add("已执行订单");
		orderTypeList.add("异常订单");
		orderTypeList.add("已撤回订单");
		
		//初始化comboBox
		for(String str:orderTypeList){
			typeBox.addItem(str);
		}
		
		typeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
			
				if(evt.getStateChange() == ItemEvent.SELECTED){
					
					String selected=(String)typeBox.getSelectedItem();
					
					//更换数据源
					controller.updateTable(selected);
				}
			}

		});
	}
	
	public void initOrderTable(){
		//初始化订单表格
		String[] titleName={"客户ID","客户姓名","联系方式","订单ID","预定房间号","订单最晚执行时间","订单状态","总价"};
		
		//数据
		List<OrderVO> list=controller.getAllOrders(hotelId);
		int numOfOrder=list.size();
		String[][] data=new String[numOfOrder][];
		for(int i=0;i<numOfOrder;i++){
			//得到一个ordervo来获取要显示在表格里的信息
			OrderVO temp=list.get(i);
			
			data[i]=new String[titleName.length];
			String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
					temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
								
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}	
		
		//模型
		myTable=new OrderTable(data, titleName);
		
		//表格
		orderTable=new JTable();
		orderTable.setModel(myTable);
		orderTable.setBorder(BorderFactory.createEtchedBorder());
		orderTable.setFillsViewportHeight(true);
		orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		orderTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		orderTable.setRowHeight(25);
		orderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(orderTable);
		scrollPane.setBounds(295, 110, 880, 538);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
				
	    adjustTable(orderTable);
		
	   contentPane.add(scrollPane);
	}
	
	public void entryButtonClicked(){
		//查看订单详细信息
		int index = orderTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String state=(String) orderTable.getValueAt(index, 6);
		if(state.equals("已执行")){
			JOptionPane.showMessageDialog(null, "该订单已执行","",JOptionPane.ERROR_MESSAGE);
		}else if(state.equals("异常")){
			
		}else if(state.equals("已撤回")){
			
		}else{
			dispose();
			orderId=(String)orderTable.getValueAt(index, 3);
			clientId=(String)orderTable.getValueAt(index, 0);
			HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientId, orderId);
			ProcessOrderView view=new ProcessOrderView(controllerService);
			controllerService.setProcessOrderView(view);
			view.setVisible(true);
		}

	}
	
	public void updateTable(String selected){
		//选择框选择不同类型的订单后更新表格的数据
		String[] titleName={"客户ID","客户姓名","联系方式","订单ID","预定房间号","订单最晚执行时间","订单状态","总价"};
		if(selected.equals("所有类型")){
			//数据
			List<OrderVO> list=controller.getAllOrders(hotelId);
			int numOfOrder=list.size();
			if(numOfOrder==0){
				String[][] data=new String[0][];
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);
				adjustTable(orderTable);
			}else{
				String[][] data=new String[numOfOrder][];
				for(int i=0;i<numOfOrder;i++){
					OrderVO temp=list.get(i);
					data[i]=new String[titleName.length];
					String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
							temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
										
					for(int j=0;j<s.length;j++){
						data[i][j]=s[j];
					}
				}	
				//模型
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);	
				adjustTable(orderTable);
				delayBT.setEnabled(true);
			}
		}else if(selected.equals("已执行订单")){
			delayBT.setEnabled(false);
			
			//数据
			List<OrderVO> list=controller.getExecutedOrders(hotelId);
			int numOfOrder=list.size();
			if(numOfOrder==0){
				String[][] data=new String[0][];
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);
				adjustTable(orderTable);
			}else{
				String[][] data=new String[numOfOrder][];
				for(int i=0;i<numOfOrder;i++){
					OrderVO temp=list.get(i);
					data[i]=new String[titleName.length];
					String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
							temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
										
					for(int j=0;j<s.length;j++){
						data[i][j]=s[j];
					}
				}	
				//模型
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);	
				adjustTable(orderTable);
			}
		}else if(selected.equals("未执行订单")){
			delayBT.setEnabled(false);
			//数据
			List<OrderVO> list=controller.getUnexecutedOrders(hotelId);
			int numOfOrder=list.size();
			if(numOfOrder==0){
				String[][] data=new String[0][];
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);
				adjustTable(orderTable);
			}else{
				String[][] data=new String[numOfOrder][];
				for(int i=0;i<numOfOrder;i++){
					OrderVO temp=list.get(i);
					data[i]=new String[titleName.length];
					String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
							temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
										
					for(int j=0;j<s.length;j++){
						data[i][j]=s[j];
					}
				}	
				//模型
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);	
				adjustTable(orderTable);
			}
		}else if(selected.equals("异常订单")){
			delayBT.setEnabled(true);
			//数据
			List<OrderVO> list=controller.getAbnormalOrders(hotelId);
			int numOfOrder=list.size();
			if(numOfOrder==0){
				String[][] data=new String[0][];
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);
				adjustTable(orderTable);
			}else{
				String[][] data=new String[numOfOrder][];
				for(int i=0;i<numOfOrder;i++){
					OrderVO temp=list.get(i);
					data[i]=new String[titleName.length];
					String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
							temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
										
					for(int j=0;j<s.length;j++){
						data[i][j]=s[j];
					}
				}	
				//模型
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);	
				adjustTable(orderTable);
			}
		}else if(selected.equals("已撤回订单")){
			delayBT.setEnabled(false);
			//数据
			List<OrderVO> list=controller.getWithdrawnOrders(hotelId);
			int numOfOrder=list.size();
			if(numOfOrder==0){
				String[][] data=new String[0][];
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);
				adjustTable(orderTable);
			}else{
				String[][] data=new String[numOfOrder][];
				for(int i=0;i<numOfOrder;i++){
					OrderVO temp=list.get(i);
					data[i]=new String[titleName.length];
					String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getPhoneNumber(),
							temp.getOrderID(),temp.getRoomNumber(),temp.getOrderLastDate(),temp.getOrderStatus(),temp.getPrice()+""};
										
					for(int j=0;j<s.length;j++){
						data[i][j]=s[j];
					}
				}	
				//模型
				myTable=new OrderTable(data, titleName);
				orderTable.setModel(myTable);	
				adjustTable(orderTable);
			}
			
		}
	}
	
	public void searchButtonClicked(){
		//搜索订单
		String orderID=orderIdField.getText();
		if(orderID.equals("")||orderID.equals(null)){
			JOptionPane.showMessageDialog(this, "请输入订单号","查询失败",JOptionPane.ERROR_MESSAGE);
		}else{
			OrderVO orderVO=controller.getOrder(orderID);
			String clientID=orderVO.getClientID();
			HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientID, orderID);
			ProcessOrderView view=new ProcessOrderView(controllerService);
			controllerService.setProcessOrderView(view);
			view.setVisible(true);
			dispose();
		}
	}
	
	public void detailedButtonClicked(){
		//查看订单详情
		int index = orderTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		dispose();
		String orderid=(String)orderTable.getValueAt(index, 3);
		String clientid=(String)orderTable.getValueAt(index, 0);
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientid, orderid);
		ProcessOrderView view=new ProcessOrderView(controllerService);
		controllerService.setProcessOrderView(view);
		view.setVisible(true);
	}
	
	public void adjustTable(JTable table){
		// 设置table表头居中
		DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
		thRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getTableHeader().setDefaultRenderer(thRenderer);
		// 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    table.setDefaultRenderer(Object.class, tcRender);
			    
	    //设置列宽度
	    for(int i=0;i<table.getColumnCount();i++){
	    	if(i==0||i==1||i==6||i==7){
	    		table.getColumnModel().getColumn(i).setPreferredWidth(45);
	    	}else if(i==2){
	    		table.getColumnModel().getColumn(i).setPreferredWidth(100);	    		
	    	}else if(i==3){
	    		table.getColumnModel().getColumn(i).setPreferredWidth(110);	    		
	    	}else if(i==4){
	    		table.getColumnModel().getColumn(i).setPreferredWidth(90);	    		
	    	}else if(i==5){
	    		table.getColumnModel().getColumn(i).setPreferredWidth(160);	    		
	    	}
	    }
	}

	public void delayButtonClicked(){
		//延迟入住
		int index = orderTable.getSelectedRow();
		
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String state=(String)orderTable.getValueAt(index, 6);
		if(!state.equals("异常")){
			JOptionPane.showMessageDialog(this, "该订单无法办理延迟入住,请选择异常订单","操作失败",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		orderId=(String)orderTable.getValueAt(index, 3);
		clientId=(String)orderTable.getValueAt(index, 0);
		String temp=controller.getDelayRoomNumber(orderId,hotelId);
		if(temp.contains("无空闲房间")){
			JOptionPane.showMessageDialog(this, "无空闲房间！办理延迟入住失败","无法办理延迟入住",JOptionPane.ERROR_MESSAGE);
			return;
		}
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientId, orderId);
		ShowClientAbnormalOrderView view=new ShowClientAbnormalOrderView(controllerService);
		controllerService.setShowClientAbnormalOrderView(view);
		view.setVisible(true);
	}
	
	public void backButtonClicked(){
		dispose();
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
	}
	
	public void manageHotelButtonClicked(){
		controller.backButtonClicked();
	}
	
	public void manageRoomButtonClicked(){
		HotelRoomControllerService controllerService=new HotelRoomControllerImpl(hotelId);
		InitManageRoomView newFrame=new InitManageRoomView(controllerService);
		controllerService.setInitManageRoomView(newFrame);
		newFrame.setVisible(true);
		dispose();
	}
	
	public void manageOrderButtonClicked(){
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, "", "");
		ManageOrderView view=new ManageOrderView(controllerService);
		controllerService.setManageOrderView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageStrategyButtonClicked(){
		HotelStrategyControllerService controllerService=new HotelStrategyControllerImpl(hotelId,"");
		InitManageStrategyView ui=new InitManageStrategyView(controllerService);
		controllerService.setInitManageStrategyView(ui);
		ui.setVisible(true);
		dispose();
	}
	
	public void manageInfoButtonClicked(){
		MyInfoControllerService controllerService=new MyInfoControllerImpl(hotelId);
		MyInfoView view=new MyInfoView(controllerService);
		controllerService.setInfoView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageCompanyButtonClicked(){
		HotelCoCompanyControllerService controllerService=new HotelCoCompanyControllerImpl(hotelId);
		InitManageCompanyView view=new InitManageCompanyView(controllerService);
		controllerService.setInitManageCompanyView(view);
		view.setVisible(true);
		dispose();	
	}
	
}
