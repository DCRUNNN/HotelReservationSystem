package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.sun.corba.se.spi.orb.StringPair;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.InitHotelViewControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.temp;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientExecutedOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientOrderView;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.HotelVO;
import vo.RoomVO;

public class InitManageRoomView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private String hotelId;
//	private List<String> allRoomType;
//	private List<String> allRoomState;
	
	private String[] roomType={};
	private String[] roomPrice={};
	
	private int numOfRoomtype;
	private int numOfRoomstate;
	private JTextField typeField;
	private JTextField priceField;
	private RoomTypePriceTable myTable;
	private JTable roomTable;
	
	
	private HotelRoomControllerService controller;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new HotelWorkerRunner();
//					HotelRoomControllerService controller=new HotelRoomControllerImpl("00002");
//					InitManageRoomView view=new InitManageRoomView(controller);
//					controller.setInitManageRoomView(view);
//					view.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public InitManageRoomView(HotelRoomControllerService controller) {
//		new HotelWorkerRunner();
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		try {
			if(controller.getAllRoomList(hotelId).equals(null)){
				numOfRoomtype=0;
				numOfRoomstate=0;
			}else{
//				allRoomType=controller.getRoomType(hotelId);
//				numOfRoomtype=allRoomType.size();
//				allRoomState=controller.getRoomState(hotelId);
//				numOfRoomstate=allRoomState.size();
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		initLeft();
		buildMainPane();
	}
	
	public void initLeft(){
		//初始化左边的表格
		String[] titleName={"房间类型","单价","空闲间数","共有间数"};
		
		//数据
		HotelVO hotelVO=controller.getHotelVO(hotelId);
		String temp=hotelVO.getRoomTypeAndPrice();
		
		String[] typeAndPrice={};
		
//		String[] roomType={};
//		String[] roomPrice={};
		
		if(temp.equals("")||temp.equals(null)){
			//do nothing
		}else{
			if(temp.startsWith("/")){
				temp=temp.substring(1);
			}
			typeAndPrice=temp.split("/");
			roomType=new String[typeAndPrice.length];
			roomPrice=new String[typeAndPrice.length];
			
			numOfRoomtype=roomType.length;
			
			if(typeAndPrice.length==1&&typeAndPrice[0].equals("")){
				//typeandprice为空
			}
			
			for(int i=0;i<typeAndPrice.length;i++){
				int poi=typeAndPrice[i].indexOf("|");
				if(poi==-1){//没有找到"|" 可能只有一种类型
					//要处理一下
					roomType[i]="";
					roomPrice[i]="";
				}else{
					roomType[i]=typeAndPrice[i].substring(0, poi);
					roomPrice[i]=typeAndPrice[i].substring(poi+1);
				}
			}
		}
		String[][] data=new String[typeAndPrice.length][];
		for(int i=0;i<typeAndPrice.length;i++){
			data[i]=new String[titleName.length];
			int all=controller.getRoomByType(hotelId, roomType[i]).size();
			String[] s=new String[]{roomType[i],roomPrice[i],controller.getAvailableRoom(hotelId, roomType[i])+"",all+""};
		
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		//模型
		myTable=new RoomTypePriceTable(data, titleName);
		
		//表格
		roomTable=new JTable();
		roomTable.setModel(myTable);
		roomTable.setBorder(BorderFactory.createEtchedBorder());
		roomTable.setFillsViewportHeight(true);
		roomTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		roomTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		roomTable.setRowHeight(25);
		roomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//调整表格
		// 设置table表头居中
		DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
		thRenderer.setHorizontalAlignment(JLabel.CENTER);
		roomTable.getTableHeader().setDefaultRenderer(thRenderer);
		// 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    roomTable.setDefaultRenderer(Object.class, tcRender);
			    
	    //设置列宽度
	    for(int i=0;i<roomTable.getColumnCount();i++){
	    	if(i==0){
	    		roomTable.getColumnModel().getColumn(i).setPreferredWidth(90);
	    	}else if(i==1){
	    		roomTable.getColumnModel().getColumn(i).setPreferredWidth(50);	    		
	    	}else if(i==2||i==3){
	    		roomTable.getColumnModel().getColumn(i).setPreferredWidth(70);	    		
	    	}
	    }
		
		JScrollPane scrollPane = new JScrollPane(roomTable);
		scrollPane.setBounds(12, 170, 310, 400);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		 
		contentPane.add(scrollPane);

		JButton addBT=new JButton(new ImageIcon("addRoomType.jpg"));
		addBT.setFont(new Font("微软雅黑",Font.PLAIN,20));
		addBT.setBounds(40,600,123,35);
		addBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.addRoomTypePriceButtonClicked();
			}
		});
		contentPane.add(addBT);
		
		JButton modifyBT=new JButton(new ImageIcon("modifyRoomType.jpg"));
		modifyBT.setFont(new Font("微软雅黑",Font.PLAIN,20));
		modifyBT.setBounds(190,600,123,35);
		modifyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.modifyRoomTypePriceButtonClicked();
			}
		});
		contentPane.add(modifyBT);
		
	}
	
	public void buildMainPane(){
		//设置房间主界面
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		tabbedPane.setBounds(340, 123, 826, 539);
		//如果选项卡太多 设置滚动显示
	    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane);

		if(numOfRoomtype==0){
			JOptionPane.showMessageDialog(this, "酒店现在还没有房间,请录入住房!","",JOptionPane.INFORMATION_MESSAGE);
			JPanel help=new BackgroundPanel(new ImageIcon("hotelPersonnel.jpg").getImage());
			help.setBounds(550, 200, 426, 339);
			contentPane.add(help);
			return;
		}
		
		GridBagLayout gbLayout=new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill=GridBagConstraints.NONE;
		s.weightx=1;
		s.weighty=1;
		for(int i=0;i<numOfRoomtype;i++){
			JPanel p=new JPanel(gbLayout);
			p.setLayout(new FlowLayout());
			p.setOpaque(false);
			List<RoomVO> room;
			
			try {
				room=controller.getRoomByType(hotelId,roomType[i]);
				if(room.size()!=0){
					for(int j=0;j<room.size();j++){
						s.gridx=2;
						s.gridy=2;
						s.insets=new Insets(20, 30, 0, 5);
						JButton button=new JButton(room.get(j).getRoomNumber());
						button.setVerticalTextPosition(JButton.BOTTOM);  
						button.setHorizontalTextPosition(JButton.CENTER);
						String picName=room.get(j).getRoomState()+".jpg";
						button.setIcon(new ImageIcon(picName));
						p.add(button,s);
					}
				}else{
//					tabbedPane.addTab(roomType[i], p);
				}
				tabbedPane.addTab(roomType[i],p);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}//end for
	
	}
	
	public void init(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton checkinBT = new JButton(new ImageIcon("checkIn.jpg"));
		checkinBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		checkinBT.setBounds(414, 54, 123, 40);
		checkinBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.checkinButtonClicked();
			}
		});
		contentPane.add(checkinBT);
		
		JButton checkoutBT = new JButton(new ImageIcon("checkOut.jpg"));
		checkoutBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		checkoutBT.setBounds(571, 54, 123, 40);
		checkoutBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.checkoutButtonClicked();
			}
		});
		contentPane.add(checkoutBT);
		
		JButton modifyRoomBT = new JButton(new ImageIcon("modifyRoom.jpg"));
		modifyRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		modifyRoomBT.setBounds(726, 54, 123, 40);
		modifyRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.modifyRoomButtonClicked_InitManageRoomView();
			}
		});
		contentPane.add(modifyRoomBT);
		
		JButton backBT = new JButton(new ImageIcon("return2_hotel.jpg"));
		backBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		backBT.setBounds(881, 54, 123, 40);
		backBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.backButtonClicked(4);
			}
		});
		contentPane.add(backBT);
		
		JButton deleteRoomBT = new JButton(new ImageIcon("deleteRoom.jpg"));
		deleteRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deleteRoomBT.setBounds(430, 733, 123, 40);
		deleteRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.deleteRoomButtonClicked_InitManageRoomView();
			}
		});
		contentPane.add(deleteRoomBT);
		
		JButton changeRoomStateBT = new JButton(new ImageIcon("modifyRoomStatement.jpg"));
		changeRoomStateBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		changeRoomStateBT.setBounds(598, 733, 165, 40);
		changeRoomStateBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.changeRoomStateButtonClicked_InitManageRoomView();
			}
		});
		contentPane.add(changeRoomStateBT);
		
		JButton addRoomBT=new JButton(new ImageIcon("addRoom.jpg"));
		addRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		addRoomBT.setBounds(808,733,123,40);
		addRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.addRoomButtonClicked_InitManageRoomView();
			}
		});
		contentPane.add(addRoomBT);
		
	}
	
	
	public void backButtonClicker(){
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void checkinButtonClicked(){
		JFrame tempFrame=new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(600, 300, 450, 300);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel lblid = new JLabel("请输入客户ID");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblid.setBounds(31, 43, 189, 27);
		tempPanel.add(lblid);		
		
		JTextField IdField = new JTextField();
		IdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		IdField.setBounds(72, 112, 275, 29);
		tempPanel.add(IdField);
		IdField.setColumns(10);
		
		JButton confirmBT = new JButton("确认");
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmBT.setBounds(72, 189, 111, 29);
		confirmBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String clientID=IdField.getText();
				if(clientID.equals("")||clientID.equals(null)){
					JOptionPane.showMessageDialog(tempFrame, "请输入客户ID！","信息输入不完整",JOptionPane.WARNING_MESSAGE);
				}else{
					HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId,clientID,"");
					ShowClientOrderView view=new ShowClientOrderView(controllerService);
					controllerService.setShowClientOrderView(view);
					view.setVisible(true);
					tempFrame.dispose();
				}
			}
		});
		tempPanel.add(confirmBT);
		
		JButton cancelBT = new JButton("取消");
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(236, 189, 111, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
	
		
		tempFrame.setVisible(true);
	}
	
	public void checkoutButtonClicked(){
		JFrame tempFrame=new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(600, 300, 450, 300);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel lblid = new JLabel("请输入客户ID");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblid.setBounds(31, 43, 189, 27);
		tempPanel.add(lblid);		
		
		JTextField IdField = new JTextField();
		IdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		IdField.setBounds(72, 112, 275, 29);
		tempPanel.add(IdField);
		IdField.setColumns(10);
		
		JButton confirmBT = new JButton("确认");
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmBT.setBounds(72, 189, 111, 29);
		confirmBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String clientID=IdField.getText();
				if(clientID.equals("")||clientID.equals(null)){
					JOptionPane.showMessageDialog(tempFrame, "请输入客户ID！","信息输入不完整",JOptionPane.WARNING_MESSAGE);
				}else{
					HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientID, "");
					ShowClientExecutedOrderView view=new ShowClientExecutedOrderView(controllerService);
					controllerService.setShowClientExecutedOrderView(view);
					view.setVisible(true);
					tempFrame.dispose();
					dispose();
				}
			}
		});
		tempPanel.add(confirmBT);
		
		JButton cancelBT = new JButton("取消");
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(236, 189, 111, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
	
		
		tempFrame.setVisible(true);
	}
	
	
	public void modifyRoomButtonClicked(){
		
		JFrame tempFrame = new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempFrame.setBounds(600, 300, 450, 300);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setUndecorated(true);
		panel.setLayout(null);
		
		//Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		panel = new JPanel();
		panel.setOpaque(true);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("请选择修改方式");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		label.setBounds(31, 43, 189, 27);
		panel.add(label);
		
		JRadioButton changeByNumBT = new JRadioButton("按房间号修改",true);
		changeByNumBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		changeByNumBT.setOpaque(false);
		changeByNumBT.setBounds(38, 129, 174, 29);
		panel.add(changeByNumBT);
		
		JRadioButton changeByTypeBT = new JRadioButton("按房间类型修改");
		changeByTypeBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		changeByTypeBT.setOpaque(false);
		changeByTypeBT.setBounds(221, 129, 189, 29);
		panel.add(changeByTypeBT);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(changeByNumBT);
		bGroup.add(changeByTypeBT);
					
		JButton confirmBT = new JButton("确认");
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmBT.setBounds(72, 220, 111, 29);
		confirmBT.setOpaque(false);
		confirmBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(changeByNumBT.isSelected()){
					tempFrame.dispose();
					dispose();
					
					ModifyRoomView view=new ModifyRoomView(controller);
					controller.setModifyRoomView(view);
					view.setVisible(true);
				}else{
					tempFrame.dispose();
					dispose();
					ModifyRoomWithTypeView view=new ModifyRoomWithTypeView(controller);
					controller.setModifyRoomTypeView(view);
					view.setVisible(true);
				}
			}
		});
		panel.add(confirmBT);
		
		JButton cancelBT = new JButton("取消");
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(223, 220, 111, 29);
		cancelBT.setOpaque(false);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		panel.add(cancelBT);
		
		tempFrame.setVisible(true);
	}
	
	public void addRoomButtonClicked(){
		CreateRoomView view=new CreateRoomView(controller);
		controller.setCreateRoomView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void deleteRoomButtonClicked(){
		//删除房间要执行的代码
		JFrame tempFrame=new JFrame();
		JPanel panel=new JPanel();
		tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempFrame.setBounds(100, 100, 450, 300);
		tempFrame.setLocation(600, 300);
		tempFrame.setUndecorated(true);

		//Image backgroundImage=new ImageIcon("background.jpg").getImage();
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel roomIdLabel = new JLabel("请输入房间号");
		roomIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		roomIdLabel.setBounds(56, 96, 131, 21);
		panel.add(roomIdLabel);
		
		JTextField roomIdField = new JTextField();
		roomIdField.setBounds(202, 96, 161, 27);
		roomIdField.setText("");
		roomIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel.add(roomIdField);
		roomIdField.setColumns(10);
		
		JButton button = new JButton("删除");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		button.setBounds(79, 224, 123, 29);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roomid=roomIdField.getText();
				boolean flag=false;
				if(roomid.equals("")||roomid.equals(null)){
					JOptionPane.showMessageDialog(null, "请输入要删除的房间号","删除房间失败",JOptionPane.WARNING_MESSAGE);
				}else{
					try{
						flag=controller.deleteRoom(hotelId, roomid);
						if(flag==true){
							JOptionPane.showMessageDialog(tempFrame, "删除"+roomid+"房间成功！","删除房间成功",JOptionPane.INFORMATION_MESSAGE);
							tempFrame.dispose();
							dispose();
							InitManageRoomView newFrame=new InitManageRoomView(controller);
							controller.setInitManageRoomView(newFrame);
							newFrame.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(tempFrame, "无法删除房间，请检查房间号是否正确","删除房间失败",JOptionPane.WARNING_MESSAGE);
							tempFrame.dispose();
						}
						
					}catch(Exception exception){
						exception.printStackTrace();
					}
				}
			}
		});
		panel.add(button);
		
		JButton button2=new JButton("取消");
		button2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button2.setBounds(239, 224, 123, 29);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		
		panel.add(button2);
		tempFrame.setVisible(true);
	}
	
	public void changeRoomStateButtonClicked(){
		//有客户线下来办理入住
		JFrame tempFrame=new JFrame();
		JPanel panel=new JPanel();
		tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tempFrame.setBounds(100, 100, 450, 300);
		tempFrame.setLocation(600, 300);
		tempFrame.setUndecorated(true);

		//Image backgroundImage=new ImageIcon("background.jpg").getImage();
		panel = new BackgroundPanel(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel roomIdLabel = new JLabel("请输入房间号");
		roomIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		roomIdLabel.setBounds(56, 66, 131, 21);
		panel.add(roomIdLabel);
		
		JTextField roomIdField = new JTextField();
		roomIdField.setBounds(202, 66, 161, 27);
		roomIdField.setText("");
		panel.add(roomIdField);
		roomIdField.setColumns(10);
		
		JLabel stateLabel = new JLabel("请选择房间状态");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateLabel.setBounds(41, 141, 141, 21);
		panel.add(stateLabel);
		
		String[] stateOfRoom={"空闲","已预订","已入住"};
		JComboBox<String> comboBox = new JComboBox<String>(stateOfRoom);
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		comboBox.setBounds(202, 141, 161, 27);
		panel.add(comboBox);
		
		JButton button = new JButton("更新");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		button.setBounds(79, 224, 123, 29);
		button.addActionListener(
				new ActionListener() {
					String roomId;
					String roomState;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						roomId=roomIdField.getText();
						roomState=(String)comboBox.getSelectedItem();
						boolean flag=false;
						if(roomId.equals("")||roomId.equals(null)||roomState.equals("")||roomState.equals(null)){
							JOptionPane.showMessageDialog(tempFrame, "请输入相关信息","信息不完整",JOptionPane.WARNING_MESSAGE);
						}else{
							try{
								flag=controller.changeRoomState(hotelId, roomId, roomState);
								if(true==flag){
									JOptionPane.showMessageDialog(tempFrame,roomId+"房状态已被修改为"+roomState,"修改房间状态成功！",JOptionPane.INFORMATION_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(tempFrame,"修改房间状态失败！请检查输入是否正确","修改房间状态失败",JOptionPane.INFORMATION_MESSAGE);
								}
								tempFrame.dispose();
								dispose();
								InitManageRoomView newFrame=new InitManageRoomView(controller);
								controller.setInitManageRoomView(newFrame);
								newFrame.setVisible(true);
								
							}catch(Exception e){
								e.printStackTrace();
							}
							
						}
					}
				});
		
		panel.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_1.setBounds(239, 224, 123, 29);
		button_1.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						tempFrame.dispose();
					}
				});
		panel.add(button_1);
		
		tempFrame.setVisible(true);
	}
	
	public void addRoomTypePriceButtonClicked(){
		//增加房间类型和价格
		JFrame tempFrame=new JFrame("新增房型");
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(370, 300, 558, 379);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label.setBounds(49, 54, 89, 34);
		tempPanel.add(label);
		
		typeField = new JTextField();
		typeField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		typeField.setBounds(151, 56, 273, 35);
		tempPanel.add(typeField);
		typeField.setColumns(20);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_1.setBounds(49, 147, 89, 28);
		tempPanel.add(label_1);
		
		priceField = new JTextField();
		priceField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		priceField.setBounds(151, 147, 273, 35);
		tempPanel.add(priceField);
		priceField.setColumns(20);
		
		JButton saveBT = new JButton("\u4FDD\u5B58");
		saveBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		saveBT.setBounds(107, 247, 123, 29);
		saveBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String roomType=typeField.getText();
				String price=priceField.getText();
				if(roomType.equals("")||price.equals("")){
					JOptionPane.showMessageDialog(tempFrame, "信息输入不完整","新增失败",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				boolean flag=controller.addRoomTypeAndPrice(hotelId, roomType, Double.parseDouble(price));
				if(flag==true){
					JOptionPane.showMessageDialog(tempFrame, "新增成功！","",JOptionPane.INFORMATION_MESSAGE);
					tempFrame.dispose();
					dispose();
					InitManageRoomView view=new InitManageRoomView(controller);
					controller.setInitManageRoomView(view);
					view.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(tempFrame, "新增失败","",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tempPanel.add(saveBT);
		
		JButton cancelBT = new JButton("\u53D6\u6D88");
		cancelBT.setFont(new Font("宋体", Font.PLAIN, 21));
		cancelBT.setBounds(319, 248, 123, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
		
		tempFrame.setVisible(true);
	}
	
	public void modifyRoomTypePriceButtonClicked(){
		//修改房间类型和价格
		int index=roomTable.getSelectedRow();
		
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择要修改的房间类型！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String type=(String)roomTable.getValueAt(index, 0);
		
		JFrame tempFrame=new JFrame("修改房型");
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(370, 300, 558, 379);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label.setBounds(49, 54, 89, 34);
		tempPanel.add(label);
		
		typeField = new JTextField();
		typeField.setText(type);
		typeField.setEditable(false);
		typeField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		typeField.setBounds(151, 56, 273, 35);
		tempPanel.add(typeField);
		typeField.setColumns(20);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		label_1.setBounds(49, 147, 89, 28);
		tempPanel.add(label_1);
		
		priceField = new JTextField();
		priceField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		priceField.setBounds(151, 147, 273, 35);
		tempPanel.add(priceField);
		priceField.setColumns(20);
		
		JButton saveBT = new JButton("\u4FDD\u5B58");
		saveBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		saveBT.setBounds(107, 247, 123, 29);
		saveBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String roomType=typeField.getText();
				String price=priceField.getText();
				if(roomType.equals("")||price.equals("")){
					JOptionPane.showMessageDialog(tempFrame, "信息输入不完整","新增失败",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				boolean flag=controller.changeRoomPrice(hotelId, type, Double.parseDouble(price));
				if(flag==true){
					JOptionPane.showMessageDialog(tempFrame, "修改成功！","",JOptionPane.INFORMATION_MESSAGE);
					tempFrame.dispose();
					dispose();
					InitManageRoomView view=new InitManageRoomView(controller);
					controller.setInitManageRoomView(view);
					view.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(tempFrame, "修改失败","",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tempPanel.add(saveBT);
		
		JButton cancelBT = new JButton("\u53D6\u6D88");
		cancelBT.setFont(new Font("宋体", Font.PLAIN, 21));
		cancelBT.setBounds(319, 248, 123, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
		
		tempFrame.setVisible(true);
		
	}
}
