package presentation.clientUI_book;


/*
 * 
 * 客户进行订单预订——查看酒店详情界面原型
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.help.HotelPicture;
import vo.HotelVO;
import vo.SearchVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class bookDetailUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextArea txtHotelName;
	
	private JButton searchButton;
	private JComboBox<String> comboBox_hotelGrade;
	private JButton lastPageButton;
	private JButton nextPageButton;

	private bookUI ui;
	private JTextComponent lowestPrice;
	private JButton otherButton;
	private JTextArea txtRoomAmount;
	private JTextArea txtRoomType;
	private JLabel pageLabel;
	private JLabel type_1;
	private JLabel client_1;
	private JLabel price_1;
	private JButton book_1;
	private JLabel type_2;
	private Component client_2;
	private JLabel price_2;
	private BackgroundPanel backgroundPanel;
	private Image room;
	private Image background4;
	
	private bookDetailUIControllerService controller;
	private HotelVO vo;
	private String clientID;
	
	private String[] roomTypes ;
	private int index =0;
	
	private String defaultHotelName = "(选填)酒店名称";
	private String defaultRoomType = "(选填)房间类型";
	private String defaultRoomAmount = "(选填)房间数目";
	private BackgroundPanel backgroundPanel_2;
	private BackgroundPanel backgroundPanel_1;
	private BackgroundPanel backgroundPanel_3;
	private BackgroundPanel backgroundPanel_4;
	private BackgroundPanel backgroundPanel_5;
	private JLabel type_3;
	private JLabel price_3;
	private JButton book_3;
	private JLabel type_4;
	private JLabel price_4;
	private JButton book_4;
	private JLabel type_5;
	private JLabel client_5;
	private JButton book_5;
	private JLabel price_5;
	
	private int current;
	private int total;
	private JPanel createOrderPanel;
	private JLabel totalPrice;
	private JLabel txtChosenRoom;
	private JPanel searchPanel;
	private JTextArea rooms;
	private JScrollPane scrollPane;
	private JButton resetButton;
	private JButton createButton;
	private JButton book_2;
	private JButton closeButton;
	
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public bookDetailUI(HotelVO vo,String clientID)
	{
		controller = new bookDetailUIController(vo.getHotelID(),clientID);
		controller.setView(this);
		this.clientID = clientID;
		this.vo = vo;
		roomTypes = vo.getRoomTypeAndPrice().split("/");//所有的房间类型
		
		//设置JFrame的一些属性
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
	
		//JPanel 的设置
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//设置背景
		Image background3 = new ImageIcon("background3.jpg").getImage();
		backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		//最小化与关闭按钮
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		backgroundPanel.add(closeLabel);
		
		JButton close = new CircleButton("");
		close.setBackground(new Color(135, 206, 235));
		close.setBounds(1146, 13, 40, 40);
		backgroundPanel.add(close);		
		close.addActionListener(new ActionListener()
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
		backgroundPanel.add(minLabel);
		
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
		backgroundPanel.add(minBT);
		
		//可自由拖拽的label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		
		searchPanel = new JPanel();
		//searchPanel = new BackgroundPanel(new ImageIcon("backgroundLabel.jpg").getImage());
		searchPanel.setOpaque(false);
		//searchPanel.setBackground(null);
		//searchPanel.setForeground(new Color(0, 191, 255));
		searchPanel.setLayout(null);
		searchPanel.setBounds(71, 90, 202, 680);
		
		//com.sun.awt.AWTUtilities.setWindowOpaque(searchPanel, 0.3f);
		
		backgroundPanel.add(searchPanel);
		
		//显示在界面的搜索条件 JLabel
		JLabel searchLabel = new JLabel("搜索条件");
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setBounds(0, 0, 202, 50);
		searchLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		searchPanel.add(searchLabel);
		
		//显示在界面的“目的地”字样
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(0, 80, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		searchPanel.add(txtDestination);
		
		//显示在页面上的“入住日期”字样
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(0, 195, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		searchPanel.add(txtCheckInDate);
		
		//显示在页面上的“关键词”字样
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(0, 404, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		searchPanel.add(txtKeyWord);
		
		//
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		destination.setColumns(10);
		destination.setBounds(0, 120, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		destination.setText(vo.getHotelCity()+"/"+vo.getHotelCBD());
		searchPanel.add(destination);
		
		checkInDate = new JTextField();
		checkInDate.setEditable(true);
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText("2016-12-02");
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(0, 235, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		searchPanel.add(checkInDate);
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(0, 298, 170, 40);
		searchPanel.add(txtHotelGrade);
		
		//酒店星级下拉框
		comboBox_hotelGrade = new JComboBox<String>();
		comboBox_hotelGrade.setBackground(new Color(245, 255, 250));
		comboBox_hotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		String grades[] = {
				"    不限","五星级/豪华","四星级/高档","三星级/舒适","两星级及以下/经济"
		};
		comboBox_hotelGrade.setModel(new DefaultComboBoxModel(grades));
		comboBox_hotelGrade.setBounds(0, 338, 170, 50);
		searchPanel.add(comboBox_hotelGrade);
		
		Color defaultcolor = new Color(192,192,192,192);
		//待输入的酒店名称
		txtHotelName = new JTextArea();
		txtHotelName.setForeground(new Color(192, 192, 192));
		txtHotelName.setBackground(new Color(245, 255, 250));
		txtHotelName.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName.setLineWrap(true);
		txtHotelName.setText(defaultHotelName);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelName.setBounds(0, 444, 170, 50);
		txtHotelName.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			    String roomType = txtRoomType.getText();
			    if("".equals(roomType)||roomType==null){
			    	//没有输入有效的房间类型
			    	txtRoomType.setText(defaultRoomType);
			    	txtRoomType.setForeground(defaultcolor);
			    }
			    if("".equals(txtRoomAmount.getText())||txtRoomAmount.getText()==null){
					//没有输入有效的房间数目
					txtRoomAmount.setText(defaultRoomAmount);
					txtRoomAmount.setForeground(defaultcolor);
				}
				txtHotelName.setText("");	
				txtHotelName.setForeground(Color.BLACK);
			}		
		});
		searchPanel.add(txtHotelName);
		
		//上一页按钮
		lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(360, 710, 170, 60);
		lastPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.lastPageButtonClicked();
			}
			
		});
		backgroundPanel.add(lastPageButton);
		
		//下一页按钮
		nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(975, 710, 170, 60);
		nextPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.nextPageButtonClicked();
			}
			
		});
		backgroundPanel.add(nextPageButton);
		
		//这个是显示在页面上的酒店名称 需要进行设置
		JTextArea hotelName = new JTextArea();
		hotelName.setEditable(false);
		hotelName.setText(vo.getHotelName());
		hotelName.setOpaque(false);
		hotelName.setMargin(new Insets(10, 10, 10, 10));
		hotelName.setForeground(new Color(25, 25, 112));
		hotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 35));
		hotelName.setColumns(10);
		hotelName.setBackground(new Color(176, 224, 230));
		hotelName.setBounds(483, 50, 350, 50);
		backgroundPanel.add(hotelName);
		
		//显示在页面上的酒店地址 需要进行设置
		JTextArea hotelAddress = new JTextArea();
		hotelAddress.setEditable(false);
		hotelAddress.setText(vo.getHotelAddress());
		hotelAddress.setOpaque(false);
		hotelAddress.setMargin(new Insets(10, 10, 10, 10));
		hotelAddress.setForeground(new Color(0, 0, 128));
		hotelAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		hotelAddress.setColumns(10);
		hotelAddress.setBounds(490, 101, 350, 40);
		backgroundPanel.add(hotelAddress);
		
		//显示在页面上的“房型”字样
		JLabel lblNewLabel = new JLabel("房型");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		lblNewLabel.setBounds(490, 181, 100, 30);
		backgroundPanel.add(lblNewLabel);
		
		background4 = new ImageIcon("background4.jpg").getImage();
		
		//房间照片
		room = new ImageIcon("room.jpg").getImage();
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		String hotelID = vo.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			hotel = HotelPicture.getLocalPicture(hotelID);
		}
		//不存在酒店图片的话  就使用默认的图片了
		
		BackgroundPanel hotelPanel = new BackgroundPanel(hotel);
		hotelPanel.setBounds(360, 60, 120, 120);
		backgroundPanel.add(hotelPanel);
		
		//最低价格 这个是需要进行设置的
		lowestPrice = new JTextArea();
		lowestPrice.setEditable(false);
		lowestPrice.setText("￥"+String.valueOf(findMin(vo.getRoomTypeAndPrice())));
		lowestPrice.setOpaque(false);
		lowestPrice.setForeground(new Color(255, 99, 71));
		lowestPrice.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 40));
		lowestPrice.setBounds(975, 69, 144, 50);
		backgroundPanel.add(lowestPrice);
		
		//这个是"起"字样，不需要进行设置
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setEditable(false);
		textArea_14.setText("起");
		textArea_14.setOpaque(false);
		textArea_14.setMargin(new Insets(10, 10, 10, 10));
		textArea_14.setForeground(new Color(255, 69, 0));
		textArea_14.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		textArea_14.setColumns(10);
		textArea_14.setBounds(1105, 84, 40, 40);
		backgroundPanel.add(textArea_14);
		
		//需要进行输入的房间类型
		txtRoomType = new JTextArea();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(10, 10, 10, 10));
		txtRoomType.setLineWrap(true);
		txtRoomType.setForeground(Color.LIGHT_GRAY);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomType.setBackground(new Color(245, 255, 250));
		txtRoomType.setBounds(0, 494, 170, 50);
		txtRoomType.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if("".equals(txtHotelName.getText())||txtHotelName.getText()==null){
					//没有输入有效的酒店名称
					txtHotelName.setText(defaultHotelName);
					txtHotelName.setForeground(defaultcolor);
				}
				if("".equals(txtRoomAmount.getText())||txtRoomAmount.getText()==null){
					//没有输入有效的房间数目
					txtRoomAmount.setText(defaultRoomAmount);
					txtRoomAmount.setForeground(defaultcolor);
				}
				txtRoomType.setText("");
				txtRoomType.setForeground(Color.BLACK);
			}
		});
		searchPanel.add(txtRoomType);
		
		//需要进行输入的房间数目
		txtRoomAmount = new JTextArea();
		txtRoomAmount.setText(defaultRoomAmount);
		txtRoomAmount.setMargin(new Insets(10, 10, 10, 10));
		txtRoomAmount.setLineWrap(true);
		txtRoomAmount.setForeground(Color.LIGHT_GRAY);
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomAmount.setBackground(new Color(245, 255, 250));
		txtRoomAmount.setBounds(0, 545, 170, 50);
		txtRoomAmount.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if("".equals(txtHotelName.getText())||txtHotelName.getText()==null){
					//没有输入有效的酒店名称
					txtHotelName.setText(defaultHotelName);
					txtHotelName.setForeground(defaultcolor);
				}
				if("".equals(txtRoomType.getText())||txtRoomType.getText()==null){
			    	//没有输入有效的房间类型
			    	txtRoomType.setText(defaultRoomType);
			    	txtRoomType.setForeground(defaultcolor);
			    }
				txtRoomAmount.setText("");
				txtRoomAmount.setForeground(Color.BLACK);
			}
		});
		searchPanel.add(txtRoomAmount);
		
		//搜索按钮
		searchButton = new JButton(new ImageIcon("search.jpg"));
		searchButton.setBounds(0, 620, 170, 60);
		searchPanel.add(searchButton);
		
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.searchButtonClicked();
			}
			
		});
		
		//其他酒店的按钮
		otherButton = new JButton(new ImageIcon("search2.jpg"));
		otherButton.setBounds(975, 120, 170, 60);
		otherButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				bookDetailUI.this.dispose();
				ui.setVisible(true);
			}
			
		});
		backgroundPanel.add(otherButton);
		
		JLabel label = new JLabel("适用客户");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label.setBounds(670, 181, 100, 30);
		backgroundPanel.add(label);
		
		JLabel label_3 = new JLabel("价格");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_3.setBounds(900, 181, 100, 30);
		backgroundPanel.add(label_3);
		
		initFinePanels();
		
		initPageLabel();
		
		initCreateOrderPanel();
		
	}
	
	private void initCreateOrderPanel() {
		
		//设置生成订单的panel
		//createOrderPanel = new JPanel();
		createOrderPanel = new BackgroundPanel(new ImageIcon("backgroundLabel.jpg").getImage());
		createOrderPanel.setBounds(0, 0, 317, 800);
		createOrderPanel.setForeground(Color.WHITE);
		createOrderPanel.setBackground(Color.WHITE);
		createOrderPanel.setVisible(false);
		
		//searchPanel.setVisible(false);
		backgroundPanel.add(createOrderPanel);
		createOrderPanel.setLayout(null);
		
		JLabel txtTotalPrice = new JLabel("\u5F53\u524D\u603B\u4EF7\u683C:");
		txtTotalPrice.setForeground(Color.black);
		txtTotalPrice.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtTotalPrice.setBounds(55, 70, 128, 38);
		createOrderPanel.add(txtTotalPrice);
		
		totalPrice = new JLabel();
		totalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		totalPrice.setForeground(new Color(255, 99, 71));
		totalPrice.setBackground(new Color(255, 0, 0));
		totalPrice.setFont(new Font("宋体", Font.BOLD, 52));
		totalPrice.setBounds(55, 100, 250, 111);
		createOrderPanel.add(totalPrice);
		
		txtChosenRoom = new JLabel("已选房间:");
		txtChosenRoom.setForeground(Color.black);
		txtChosenRoom.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtChosenRoom.setBounds(55, 299, 128, 38);
		createOrderPanel.add(txtChosenRoom);
		
		rooms = new JTextArea();
		rooms.setForeground(new Color(255, 165, 0));
		rooms.setFont(new Font("楷体", Font.BOLD, 23));
		rooms.setEditable(false);
		rooms.setBounds(0,300,202,200);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(rooms);
		scrollPane.setAutoscrolls(true);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(55,350,220,200);
		
		createOrderPanel.add(scrollPane);
		
		
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(270, 18, 26, 30);
		createOrderPanel.add(closeLabel);
		
		closeButton = new CircleButton("");
		closeButton.setBackground(new Color(135, 206, 235));
		closeButton.setBounds(263, 13, 40, 40);
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				totalPrice.setText("");
				rooms.setText("");
				createOrderPanel.setVisible(false);
				searchPanel.setVisible(true);
			}
			
		});
		createOrderPanel.add(closeButton);
		
		//重新选择按钮
		resetButton = new JButton(new ImageIcon("rechoose.jpg"));
		resetButton.setBounds(75, 600, 170, 60);
		createOrderPanel.add(resetButton);
		
		//生成订单按钮
		createButton = new JButton(new ImageIcon("createOrder.jpg"));
		createButton.setBounds(75, 700, 170, 60);
		createOrderPanel.add(createButton);
		createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.ceateButtonClicked();
			}
			
		});
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				totalPrice.setText("");
				rooms.setText("");
				//重置一下controller
				controller = new bookDetailUIController(vo.getHotelID(),clientID);
				controller.setView(bookDetailUI.this);
			}
			
		});
	}

	/**
	 *初始化显示的五个panel 
	 * */
	private void initFinePanels() {
		
		int total = roomTypes.length;
		switch(total){
		case 0:
		{
			initPanel1("");
			initPanel2("");
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		case 1:
		{
			initPanel1(roomTypes[index++]);
			initPanel2("");
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			//backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 3:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 4:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4(roomTypes[index++]);
			initPanel5("");

			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		default:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4(roomTypes[index++]);
			initPanel5(roomTypes[index++]);

			break;
		}
		
	}
	}

	/**
	 * 找出酒店的最低房间类型的价格
	 * @param roomTypeAndPrice 房间类型和价格
	 * */
	private double findMin(String roomTypeAndPrice) {
		
		String types[] = roomTypeAndPrice.split("/");//房间类型和价格的数组
		if(types.length==0){
			//长度为0
			return 0;
		}else{
			double min = Double.valueOf(types[0].split("[|]")[1]);
			for(String str:types){
				if(Double.valueOf(str.split("[|]")[1])<=min){
					//遍历数组 找出最小值
					min = Double.valueOf(str.split("[|]")[1]);
				}
			}
			return min;
		}
	}
	private void initPageLabel() {
		
		current = index%5==0?index/5:index/5+1;
		total = roomTypes.length%5==0?roomTypes.length/5:roomTypes.length/5+1;
		
		if(current == 0)
		{
			current = 1;
		}
		if(total == 0)
		{
			total = 1;
		}
		
		pageLabel = new JLabel("第"+current+"页 共"+total+"页");
		pageLabel.setFont(new Font("仿宋", Font.BOLD, 15));
		pageLabel.setBounds(704, 716, 120, 29);
		backgroundPanel.add(pageLabel);
	}

	private void initPanel5(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_5 = new BackgroundPanel(background4);
		backgroundPanel_5.setLayout(null);
		backgroundPanel_5.setBounds(360, 611, 785, 90);
		backgroundPanel.add(backgroundPanel_5);
		
		BackgroundPanel roomPanel_5 = new BackgroundPanel(room);
		roomPanel_5.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(roomPanel_5);
		
		type_5 = new JLabel(type);
		type_5.setForeground(new Color(0, 0, 128));
		type_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		type_5.setBounds(104, 26, 118, 30);
		backgroundPanel_5.add(type_5);
		
		client_5 = new JLabel("所有客户");
		client_5.setForeground(new Color(0, 0, 128));
		client_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		client_5.setBounds(310, 26, 100, 30);
		backgroundPanel_5.add(client_5);
		
		price_5 = new JLabel("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_5.setForeground(new Color(255, 69, 0));
		price_5.setFont(new Font("宋体", Font.BOLD, 20));
		price_5.setBounds(540, 26, 63, 30);
		backgroundPanel_5.add(price_5);
		
		book_5 = new JButton(new ImageIcon("book.jpg"));
		book_5.setBounds(660, 23, 100, 45);
		book_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_5.add(book_5);
	}

	private void initPanel4(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_4 = new BackgroundPanel(background4);
		backgroundPanel_4.setLayout(null);
		backgroundPanel_4.setBounds(360, 511, 785, 90);
		backgroundPanel.add(backgroundPanel_4);
		
		BackgroundPanel roomPanel_4 = new BackgroundPanel(room);
		roomPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_4.add(roomPanel_4);
		
		type_4 = new JLabel(type);
		type_4.setForeground(new Color(0, 0, 128));
		type_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		type_4.setBounds(104, 26, 118, 30);
		backgroundPanel_4.add(type_4);
		
		JLabel client_4 = new JLabel("所有客户");
		client_4.setForeground(new Color(0, 0, 128));
		client_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		client_4.setBounds(310, 26, 100, 30);
		backgroundPanel_4.add(client_4);
		
		price_4 = new JLabel("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_4.setForeground(new Color(255, 69, 0));
		price_4.setFont(new Font("宋体", Font.BOLD, 20));
		price_4.setBounds(540, 26, 63, 30);
		backgroundPanel_4.add(price_4);
		
		book_4 = new JButton(new ImageIcon("book.jpg"));
		book_4.setBounds(660, 23, 100, 45);
		book_4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_4.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_4.add(book_4);
	}

	private void initPanel3(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_3 = new BackgroundPanel(background4);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(360, 411, 785, 90);
		backgroundPanel.add(backgroundPanel_3);
		
		BackgroundPanel roomPanel_3 = new BackgroundPanel(room);
		roomPanel_3.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(roomPanel_3);
		
		type_3 = new JLabel(type);
		type_3.setForeground(new Color(0, 0, 128));
		type_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		type_3.setBounds(104, 26, 118, 30);
		backgroundPanel_3.add(type_3);
		
		JLabel client_3 = new JLabel("所有客户");
		client_3.setForeground(new Color(0, 0, 128));
		client_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		client_3.setBounds(310, 26, 100, 30);
		backgroundPanel_3.add(client_3);
		
		price_3 = new JLabel("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_3.setForeground(new Color(255, 69, 0));
		price_3.setFont(new Font("宋体", Font.BOLD, 20));
		price_3.setBounds(540, 26, 63, 30);
		backgroundPanel_3.add(price_3);
		
		book_3 = new JButton(new ImageIcon("book.jpg"));
		book_3.setBounds(660, 23, 100, 45);
		book_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				checkPanel();
				
				String roomType = type_3.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			
				
			}
			
		});
		backgroundPanel_3.add(book_3);
	}

	private void initPanel2(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_2 = new BackgroundPanel(background4);
		backgroundPanel_2.setLayout(null);
		backgroundPanel_2.setBounds(360, 311, 785, 90);
		backgroundPanel.add(backgroundPanel_2);
		
		BackgroundPanel roomPanel_2 = new BackgroundPanel(room);
		roomPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_2.add(roomPanel_2);
		
		//房间类型 需要进行设置
		type_2 = new JLabel(type);
		type_2.setForeground(new Color(0, 0, 128));
		type_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		type_2.setBounds(104, 26, 118, 30);
		backgroundPanel_2.add(type_2);
		
		//客户类型
		client_2 = new JLabel("所有客户");
		client_2.setForeground(new Color(0, 0, 128));
		client_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		client_2.setBounds(310, 26, 100, 30);
		backgroundPanel_2.add(client_2);
		
		//价格
	    price_2 = new JLabel("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_2.setForeground(new Color(255, 69, 0));
		price_2.setFont(new Font("宋体", Font.BOLD, 20));
		price_2.setBounds(540, 26, 63, 30);
		backgroundPanel_2.add(price_2);
		
		book_2 = new JButton(new ImageIcon("book.jpg"));
		book_2.setBounds(660, 23, 100, 45);
		book_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_2.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			
			}
			
		});
		backgroundPanel_2.add(book_2);
	}

	private void initPanel1(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_1 = new BackgroundPanel(background4);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(360, 211, 785, 90);
		backgroundPanel.add(backgroundPanel_1);
		BackgroundPanel roomPanel_1 = new BackgroundPanel(room);
		roomPanel_1.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(roomPanel_1);//设置房间图片
		
		//房间类型 需要进行设置的
		type_1 = new JLabel(type);
		type_1.setForeground(new Color(0, 0, 128));
		type_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		type_1.setBounds(104, 26, 118, 30);
		backgroundPanel_1.add(type_1);
		
	    //适用客户 
		client_1 = new JLabel("所有客户");
		client_1.setForeground(new Color(0, 0, 128));
		client_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		client_1.setBounds(310, 26, 100, 30);
		backgroundPanel_1.add(client_1);
		
		//房间价格 需要进行设置
		price_1 = new JLabel("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_1.setForeground(new Color(255, 69, 0));
		price_1.setFont(new Font("宋体", Font.BOLD, 20));
		price_1.setBounds(540, 26, 63, 30);
		backgroundPanel_1.add(price_1);
		
		//预订按钮 需要进行设置
		book_1 = new JButton(new ImageIcon("book.jpg"));
		book_1.setBounds(660, 23, 100, 45);
		book_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_1.add(book_1);
	}

	public void setBookUI(bookUI ui){
		this.ui = ui;
	}
	
	/**
	 * 检查生成订单的JPanel是否可见
	 * */
	public void checkPanel(){
		
		if(!createOrderPanel.isVisible()){
			createOrderPanel.setVisible(true);
			searchPanel.setVisible(false);
		}
	}

	/**
	 * 得到所选类型的房间的号码
	 * @param roomType 所选房间类型
	 * */
	public String getRoomNumber(String roomType){
		
		String chosenTypes[] = rooms.getText().split("\n");//已选的所有房间类型
		ArrayList<String> a = new ArrayList<String>();
		for(String str:chosenTypes){
			//遍历已选的所有房间
			if(str.split(":")[0].equals(roomType)){
				//把和当前类型一样的房间号码加入a中
				a.add(str.split(":")[1]);
			}
		}
		
		String roomNumber = "";
		if(a.size()==0){
			//没有选过同一类型房间
			roomNumber = controller.getRoomNumber(roomType);//没有房间返回的是""
		}else{
			String lastRoomNumber = a.get(a.size()-1);//得到上一个这样的房间
			roomNumber = controller.getNextRoomNumber(roomType,lastRoomNumber);
		}
		
		return roomNumber;
	}
	
	/**
	 * 计算已选房间的最优价格
	 * */
	public void setPrice(){

	    String allRooms[] = rooms.getText().split("\n");//已选的所有房间
	    
	    String numbers ="";
	    for(int i=0;i<allRooms.length;i++){
	    	numbers = numbers+allRooms[i].split(":")[1]+"/";
	    }
	    
	    double price = controller.getPrice(numbers.substring(0, numbers.length()-1));//计算最优价格
	    totalPrice.setText("￥"+String.valueOf(price));

	}
	
	public void searchButtonClicked() {
		
		String date = checkInDate.getText();
		if(!checkDate(date)){
			//对输入的日期进行格式检查
			JOptionPane.showMessageDialog(null, "请输入符合格式的日期!","不好意思",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		int index_grade = comboBox_hotelGrade.getSelectedIndex();
		int minstar = -1;
		int maxstar = -1;
		if(1<=index_grade&&index_grade<=3){
			//选择的是五，四，或者三星级
			minstar = maxstar = 5-index_grade+1;
		}else if(index_grade==4){
			//选择的是两星级及其以下
			minstar = 1;
			maxstar = 2;
		}
		
		String hotelName = txtHotelName.getText().trim();
		if(hotelName.equals(defaultHotelName)){
			//客户没有进行输入酒店名称
			hotelName = "";
		}
		
		String roomType = txtRoomType.getText().trim();
		if(roomType.equals(defaultRoomType)){
			//没有输入房间类型
			roomType="";
		}
		
		int roomAmount = 1;
		String amount = txtRoomAmount.getText().trim();
		if(amount.matches("[0-9]*")){
			//输入了数字
			if(!"".equals(amount)){
				roomAmount = Integer.valueOf(txtRoomAmount.getText());
			}
		}else if(!"".equals(amount)&&!defaultRoomAmount.equals(amount)){
			JOptionPane.showMessageDialog(null, "请输入数字格式的房间数目！", "不好意思",  JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		String hotelProvince = vo.getHotelProvince();
		String hotelCity = vo.getHotelCity();
		String hotelCBD = vo.getHotelCBD();
		
       SearchVO searchvo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
	    
	    bookUI ui = new bookUI(hotelProvince,hotelCity,hotelCBD,clientID,searchvo);
	    ui.setVisible(true);
	    this.dispose();
	}
	
	/**
	 * 判断输入的日期是否符合格式
	 * @param date 日期
	 * @return 符合格式返回true，否则为false
	 * */
	private boolean checkDate (String date){
		
		String reg_yyyy_MM_dd = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))" +
                "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		if(date.matches(reg_yyyy_MM_dd)){
			return true;
		}
		return false;
	}
	
	private int formatPrice (double d){
		
		return (int) Math.round(d);
	}

	public void lastPageButtonClicked() {
	
		if(index>5){
			
			int end = 0; //end是上一页的结束的酒店序号
			if(index%5==0){
				end = (index/5-1)*5;
			}else{
				end = (index/5)*5;
			}
			index = end;//把当前页码置为结束序号
			
			changePageLabel();
			changeFinePanel();
	
		}
	}

	private void changeFinePanel() {
		
		changePanel1(roomTypes[index-5]);
		changePanel2(roomTypes[index-4]);
		changePanel3(roomTypes[index-3]);
		changePanel4(roomTypes[index-2]);
		changePanel5(roomTypes[index-1]);
		
		if(!backgroundPanel_1.isVisible()){
			backgroundPanel_1.setVisible(true);
		}
		
		if(!backgroundPanel_2.isVisible()){
			backgroundPanel_2.setVisible(true);
		}
		
		if(!backgroundPanel_3.isVisible()){
			backgroundPanel_3.setVisible(true);
		}
		
		if(!backgroundPanel_4.isVisible()){
			backgroundPanel_4.setVisible(true);
		}
		
		if(!backgroundPanel_5.isVisible()){
			backgroundPanel_5.setVisible(true);
		}
	}

	private void changePanel5(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_5.setText(type);
		price_5.setText("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_5.removeActionListener(book_5.getActionListeners()[0]);
		book_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_5.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel4(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_4.setText(type);
		price_4.setText("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_4.removeActionListener(book_4.getActionListeners()[0]);
		book_4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_4.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel3(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_3.setText(type);
		price_3.setText("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_3.removeActionListener(book_3.getActionListeners()[0]);
		book_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_3.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel2(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_2.setText(type);
		price_2.setText("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_2.removeActionListener(book_2.getActionListeners()[0]);
		book_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_2.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
	}

	private void changePanel1(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_1.setText(type);
		price_1.setText("￥"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_1.removeActionListener(book_1.getActionListeners()[0]);
		book_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "很抱歉，该类型的空房暂时没有了!","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	/**
	 * 下一页按钮按下的实际事件响应
	 * */
	public void nextPageButtonClicked() {
		
		int size = roomTypes.length;
		if(index+5>size){
			if(index<size){
				int left = size - index;
				changeNextFinePanel(left);
			}
		}else{
			changeNextFinePanel(5);
		}
	}

	/**
	 * 改变显示的内容
	 * @param left 剩下的房间类型的总数
	 * */
	private void changeNextFinePanel(int left) {
		
		switch(left){
		case 1:{
			changePanel1(roomTypes[index++]);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 3:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 4:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			changePanel4(roomTypes[index++]);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 5:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			changePanel4(roomTypes[index++]);
			changePanel5(roomTypes[index++]);
			break;
		}
		}
		
		changePageLabel();
	}

	/**
	 * 改变页码
	 * */
	private void changePageLabel() {
		
		current = index%5==0?index/5:index/5+1;
		total = roomTypes.length%5==0?roomTypes.length/5:roomTypes.length/5+1;
		String str = "第"+current+"页 共"+total+"页";
		pageLabel.setText(str);
	}

	public void createButtonClicked() {
		
		if("".equals(rooms.getText())){
			JOptionPane.showMessageDialog(null, "请选择房间！","消息",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(!controller.checkCredit(clientID)){
			//客户信用点为负数
			JOptionPane.showMessageDialog(null, "客户信用点不足，请先进行充值！","提示",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		String chosenRooms[] = rooms.getText().split("\n");
		//用List roomNumbers 来得到所有的房间信息
		ArrayList<String> roomNumbers = new ArrayList<String>();
		ArrayList<String> roomTypes = new ArrayList<String>();
		
		String types = "";
		String numbers = "";
		
		for(String str: chosenRooms){
			roomTypes.add(str.split(":")[0]);
			types = types+str.split(":")[0]+"/";
			roomNumbers.add(str.split(":")[1]);
			numbers = numbers+str.split(":")[1]+"/";
		}
		
		for(String str:roomNumbers){
			
			if(!controller.checkRoom(vo.getHotelID(),str)){
				
				int index =roomNumbers.indexOf(str);
				String roomType = roomTypes.get(index);
				JOptionPane.showMessageDialog(null,roomType+":"+str+" 在您下单时被预定了，下次不要犹豫太久哦","提示消息",JOptionPane.INFORMATION_MESSAGE);
			    return ;
			}
		}
		
		types = types.substring(0,types.length()-1);
		numbers = numbers.substring(0,numbers.length()-1);
		
		boolean q = controller.createOrder(vo.getHotelID(),clientID,types,numbers);
		if(q == true){
			
			JOptionPane.showMessageDialog(null, "生成订单成功！");
			closeButton.doClick();
		}else{
			JOptionPane.showMessageDialog(null, "出现了未知的错误！","不好意思",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
	}
}


