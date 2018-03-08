package presentation.clientUI_book;

/*
 * 
 * 客户进行预订订单——查看酒店界面原型
 */

import java.awt.Color;



import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.help.HotelPicture;
import vo.HotelVO;
import vo.SearchVO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class bookUI extends JFrame
{

	private bookUIControllerService controller;
	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextArea txtHotelName_1;
	private JTextArea score_1;
	private JButton detailButton_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextArea txtHotelName;
	private JTextArea txtRoomType;
	private JTextArea txtRoomAmount;
	
	private String defaultHotelName = "(选填)酒店名";
	private String defaultRoomType = "(选填)房间类型";
	private JTextArea txtTel_1;
	private JTextArea txtTel_2;
	private JTextArea txtTel_3;
	private JTextArea txtAddress_1;
	private JTextArea star_1;
	private JTextArea price_1;
	private JPanel picture_1;
	private JTextArea txtHotelName_2;
	private JButton detailButton_2;
	private JTextArea score_2;
	private BackgroundPanel picture_2;
	private JTextArea txtAddress_2;
	private JTextArea star_2;
	private JTextArea price_2;
	private JTextArea txtHotelName_3;
	private JButton detailButton_3;
	private JTextArea score_3;
	private JTextArea txtAddress_3;
	private JTextArea star_3;
	private BackgroundPanel picture_3;
	private JTextArea price_3;
	
	private JPanel backgroundPanel;
	private Image background2;
	private Image background3;
	private Image hotel;
	
	private JLabel pageLabel;
	private JButton returnButton;
	private JButton search;
	
	private JComboBox<String> comboBox_HotelGrade;
	//private String scoreOfFirstHotel ;
	private String clientID;
	/**
	 * Create the frame.
	 */

	public bookUI(String hotelProvince, String hotelCity, String hotelCBD, String clientID, SearchVO searchvo) {
		
		this.clientID = clientID;
		controller = new bookUIController(clientID);
		controller.initAllHotel(hotelProvince,hotelCity,hotelCBD);
		controller.search(searchvo);
		initUI(hotelProvince,hotelCity,hotelCBD,searchvo);
		
	}

	private void initUI(String hotelProvince, String hotelCity, String hotelCBD, SearchVO searchvo) {
	
		//设置JFrame的一些属性
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		//设置contentPane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//设置背景图片
		background2 = new ImageIcon("background2_1.jpg").getImage();
		background3 = new ImageIcon("background3.jpg").getImage();
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
		
		//查看详情按钮的初始化
		detailButton_1 = new JButton(new ImageIcon("view.jpg"));
		detailButton_2 = new JButton(new ImageIcon("view.jpg"));
		detailButton_3 = new JButton(new ImageIcon("view.jpg"));
		
		//JLabel "搜索条件"的设置
		JLabel searchLabel = new JLabel("搜索条件");
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setBounds(71, 149, 202, 50);
		searchLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(searchLabel);
		
		//显示的目的地 JLabel
		txtDestination = new JTextField();
		txtDestination.setEditable(false);
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(71, 200, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		//显示的入住日期JLabel
		txtCheckInDate = new JTextField();
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(71, 300, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		//显示的关键词JLabel
		txtKeyWord = new JTextField();
		txtKeyWord.setEditable(false);
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(71, 500, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		//显示的省市
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		destination.setColumns(10);
		destination.setBounds(71, 240, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		destination.setText(hotelCity+"/"+hotelCBD);//这里可能长度不够
		backgroundPanel.add(destination);
		
		//显示上一个页面搜索的入住日期
		checkInDate = new JTextField();
		checkInDate.setEditable(true);
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText(searchvo.getOrderBeginDate());
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(71, 340, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(checkInDate);
		
		//显示在页面的酒店界别label
		txtHotelGrade = new JTextField();
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(71, 400, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		//输入的hotelName 酒店名称
		txtHotelName = new JTextArea();
		txtHotelName.setForeground(Color.BLACK);
		txtHotelName.setBackground(new Color(245, 255, 250));
		txtHotelName.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName.setLineWrap(true);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelName.setBounds(71, 540, 170, 50);
		//输入的搜索酒店名称为空时候设置默认，否则就是搜索的酒店名称
		if(searchvo.getHotelName().equals("")||searchvo.getHotelName()==null){
			txtHotelName.setText(defaultHotelName);
		}else{
			txtHotelName.setText(searchvo.getHotelName());
			txtHotelName.setForeground(Color.black);
		}		
		backgroundPanel.add(txtHotelName);
		
		//酒店星级的下拉列表框
		comboBox_HotelGrade = new JComboBox<String>();
		comboBox_HotelGrade.setBackground(new Color(245, 255, 250));
		comboBox_HotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		String grades[] = {
				"    不限","五星级/豪华","四星级/高档","三星级/舒适","两星级及以下/经济"
		};
		comboBox_HotelGrade.setModel(new DefaultComboBoxModel<String>(grades));
		comboBox_HotelGrade.setBounds(71, 440, 170, 50);
		backgroundPanel.add(comboBox_HotelGrade);
		int minHotelStar = searchvo.getMinstar();
		int maxHotelStar = searchvo.getMaxstar();
		if(minHotelStar!=maxHotelStar){
			comboBox_HotelGrade.setSelectedIndex(4);
		}else{
			if(minHotelStar==maxHotelStar&&minHotelStar==-1){
				comboBox_HotelGrade.setSelectedIndex(0);
			}else{
				comboBox_HotelGrade.setSelectedIndex(6-minHotelStar);
			}
		}
		
		//输入的房间类型 
		txtRoomType = new JTextArea();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(10, 10, 10, 10));
		txtRoomType.setLineWrap(true);
		txtRoomType.setForeground(Color.BLACK);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomType.setBackground(new Color(245, 255, 250));
		txtRoomType.setBounds(71, 590, 170, 50);
		if(!"".equals(searchvo.getRoomType())&&searchvo.getRoomType()!=null){
			//输入了房间类型
			txtRoomType.setText(searchvo.getRoomType());
			txtRoomType.setForeground(Color.BLACK);
		}
		backgroundPanel.add(txtRoomType);
		
		//输入的房间数目
		txtRoomAmount = new JTextArea();
		int total = searchvo.getRoomTotal();
		String roomtotal = "房间数目:"+total;
		txtRoomAmount.setText(roomtotal);
		txtRoomAmount.setMargin(new Insets(10, 10, 10, 10));
		txtRoomAmount.setLineWrap(true);
		txtRoomAmount.setForeground(Color.black);
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomAmount.setBackground(new Color(245, 255, 250));
		txtRoomAmount.setBounds(71, 640, 170, 50);
		backgroundPanel.add(txtRoomAmount);
		
		//酒店图片
		hotel = new ImageIcon("hotel.jpg").getImage();
		
		//提示信息 “排序方式”
		JTextArea sortLabel = new JTextArea();
		sortLabel.setEditable(false);
		sortLabel.setText("\u6392\u5E8F\u65B9\u5F0F");
		sortLabel.setOpaque(false);
		sortLabel.setMargin(new Insets(10, 10, 10, 10));
		sortLabel.setForeground(Color.WHITE);
		sortLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		sortLabel.setColumns(10);
		sortLabel.setBounds(360, 24, 99, 40);
		backgroundPanel.add(sortLabel);
		
		List<HotelVO> volist = controller.getThreeHotels();
	    initThreeHotelPanel(volist);
		//上一页按钮
		JButton lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(360, 710, 170, 60);
		lastPageButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//上一页按钮的监听
				List<HotelVO> volist = controller.getLastThreeHotels();
				changeThreeHotelPanel(volist);//更改三个酒店label
				
				changePageLabel();//改变下方的页码
			}
			
		});
		backgroundPanel.add(lastPageButton);
		
		//下一页按钮
		JButton nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(975, 710, 170, 60);
		nextPageButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//下一页按钮的监听
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);//更改显示的三个酒店label
				
				changePageLabel();
			}		
		});
		backgroundPanel.add(nextPageButton);
		
		returnButton = new JButton(new ImageIcon("return2.jpg"));
		returnButton.setBounds(71, 64, 170, 60);
		returnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				returnButtonClicked();
			}
			
		});
		backgroundPanel.add(returnButton);
		
		//按价格排序按钮
		JButton priceButton = new JButton(new ImageIcon("price.jpg"));
		priceButton.setBounds(360, 64, 170, 60);
		priceButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.showByprice();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(priceButton);
		
		//按综合评分排序按钮
		JButton scoreButton = new JButton(new ImageIcon("score.jpg"));
		scoreButton.setBounds(565, 64, 170, 60);
		scoreButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				controller.showByPoint();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(scoreButton);
		
		//按星级进行排序按钮
		JButton starButton = new JButton(new ImageIcon("star.jpg"));
		starButton.setBounds(770, 64, 170, 60);
		starButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.showByStar();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
				
			}
			
		});
		backgroundPanel.add(starButton);
		
		//按是否曾经预订进行排序
		JButton historyButton = new JButton(new ImageIcon("hotelButton.jpg"));
		historyButton.setBounds(975, 64, 170, 60);
		historyButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("history button clicked!");
				controller.showHotelOrdered();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(historyButton);
		
		//下方的页面总数和显示
		int currentPage = controller.getCurrentPage();
		int allPage = controller.getAllPages();
		initPageLabel(currentPage,allPage);		
	  
		search = new JButton(new ImageIcon("search.jpg"));
		search.setBounds(71, 703, 170, 60);
		search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			    String date = checkInDate.getText().trim();
			    if(!checkDate(date)){
			    	JOptionPane.showMessageDialog(null, "请按照正确的格式输入日期！","不好意思",JOptionPane.INFORMATION_MESSAGE);
			        return;
			    }//得到输入的入住日期
			    
			    int index_grade = comboBox_HotelGrade.getSelectedIndex();
				int minstar = -1;
				int maxstar = -1;
				if(1<=index_grade&&index_grade<=3){
					//选择的是五，四，或者三星级
					minstar = maxstar = 5-index_grade+1;
				}else if(index_grade==4){
					//选择的是两星级及其以下
					minstar = 1;
					maxstar = 2;
				}//得到选择的酒店星级
				
				String hotelName = txtHotelName.getText().trim();
				if(hotelName.equals(defaultHotelName)){
					//客户没有进行输入酒店名称
					hotelName = "";
				}//得到酒店名称
				
				String roomType = txtRoomType.getText().trim();
				if(roomType.equals(defaultRoomType)){
					//没有输入房间类型
					roomType="";
				}//得到输入的房间类型
				
				int roomAmount = 1;
				String amount = txtRoomAmount.getText().trim();
				if(amount.matches("[0-9]*")){
					//输入了数字
					if(!"".equals(amount)){
						roomAmount = Integer.valueOf(txtRoomAmount.getText());
					}
				}else if(!"".equals(amount)&&!roomtotal.equals(amount)){
					JOptionPane.showMessageDialog(null, "请输入数字格式的房间数目！", "不好意思",  JOptionPane.INFORMATION_MESSAGE);
				    return;
				}//得到输入的房间数目
				
				SearchVO vo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
			    controller.search(vo);
			    
			    List<HotelVO> volist = controller.getThreeHotels();
			    changeThreeHotelPanel(volist);
			    changePageLabel();
			    
			}
		});
		backgroundPanel.add(search);
	}

	/**
	 * 酒店信息初始化
	 * @param threeHotels 三个酒店信息vo
	 * */
	private void initThreeHotelPanel(List<HotelVO> threeHotels) {
		
		HotelVO vo = new HotelVO("", "", "", "", "", 1, "", "", "单人间|20","","");
		if(threeHotels.size()==1){
			initPanel1(threeHotels.get(0));
			initPanel2(vo);
			panel_2.setVisible(false);
			initPanel3(vo);
			panel_3.setVisible(false);
		}else if(threeHotels.size()==2){
			initPanel1(threeHotels.get(0));
			initPanel2(threeHotels.get(1));
			initPanel3(vo);
			panel_3.setVisible(false);
		}else if(threeHotels.size()==3){
			initPanel1(threeHotels.get(0));
			initPanel2(threeHotels.get(1));
			initPanel3(threeHotels.get(2));
		}else if(threeHotels.size()==0){
			if(panel_1==null){
				initPanel1(vo);
				panel_1.setVisible(false);
			}
			if(panel_2==null){
				initPanel2(vo);
				panel_2.setVisible(false);
			}
			if(panel_3==null){
				initPanel3(vo);
				panel_3.setVisible(false);
			}
		}
	}

	/**
	 * 用酒店信息初始化 第一个酒店panel
	 * @param hotelVO 酒店信息
	 * */
	private void initPanel1(HotelVO hotelVO) {
		
		//第一个酒店
		panel_1 = new BackgroundPanel(background2);
		panel_1.setBounds(360, 155, 785, 155);
		backgroundPanel.add(panel_1);
		panel_1.setLayout(null);
		
		//第一个酒店的电话
		txtTel_1 = new JTextArea();
		txtTel_1.setBounds(228, 99, 220, 43);
		panel_1.add(txtTel_1);
		txtTel_1.setForeground(new Color(25, 25, 112));
		txtTel_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtTel_1.setMargin(new Insets(10, 10, 10, 10));
		txtTel_1.setText(hotelVO.getTelephone());
		txtTel_1.setOpaque(false);
		txtTel_1.setColumns(10);
		
		//显示的“预订热线” 字样
		JTextArea textField = new JTextArea();
		textField.setEditable(false);
		textField.setBounds(135, 103, 98, 40);
		panel_1.add(textField);
		textField.setForeground(new Color(25, 25, 112));
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		textField.setMargin(new Insets(10, 10, 10, 10));
		textField.setText("\u9884\u8BA2\u70ED\u7EBF");
		textField.setOpaque(false);
		textField.setColumns(10);
		
		//第一个酒店的地址
		txtAddress_1 = new JTextArea();
		txtAddress_1.setBounds(135, 70, 350, 40);
		panel_1.add(txtAddress_1);
		txtAddress_1.setForeground(new Color(25, 25, 112));
		txtAddress_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		txtAddress_1.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_1.setText(hotelVO.getHotelAddress());
		txtAddress_1.setOpaque(false);
		txtAddress_1.setColumns(10);
		
		//这个是显示的label “综合评分”
		JLabel label = new JLabel();
		label.setBounds(425, 17, 98, 40);
		panel_1.add(label);
		label.setText("综合评分");
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		
		//第一个酒店的星级显示
		star_1 = new JTextArea();
		star_1.setText(hotelVO.getHotelStar()+"星级");
		star_1.setOpaque(false);
		star_1.setMargin(new Insets(10, 10, 10, 10));
		star_1.setForeground(new Color(25, 25, 112));
		star_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		star_1.setEditable(false);
		star_1.setColumns(10);
		star_1.setBounds(463, 103, 98, 40);
		panel_1.add(star_1);
		
		//第一个酒店的最低价格
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_1 = new JTextArea();
		price_1.setText("￥"+String.valueOf(price)+"起");
		price_1.setOpaque(false);
		price_1.setMargin(new Insets(10, 10, 10, 10));
		price_1.setForeground(new Color(25, 25, 112));
		price_1.setFont(new Font("宋体", Font.BOLD, 20));
		price_1.setEditable(false);
		price_1.setColumns(10);
		price_1.setBounds(540, 99, 98, 43);
		panel_1.add(price_1);
		
		//设置酒店的名称
		txtHotelName_1 = new JTextArea();
		txtHotelName_1.setBounds(135, 17, 280, 40);
		panel_1.add(txtHotelName_1);
		txtHotelName_1.setOpaque(false);
		txtHotelName_1.setBackground(new Color(176, 224, 230));
		txtHotelName_1.setForeground(new Color(25, 25, 112));
		txtHotelName_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		txtHotelName_1.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_1.setText(hotelVO.getHotelName());
		txtHotelName_1.setColumns(10);
		
		//把查看详情按钮添加到panel1上
		detailButton_1 = new JButton(new ImageIcon("view.jpg"));
		detailButton_1.setBounds(636, 17, 135, 120);
		detailButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_1.add(detailButton_1);
		
		//第一个酒店的得分的初始化
		score_1 = new JTextArea();
		score_1.setBounds(512, 17, 126, 90);
		panel_1.add(score_1);
		score_1.setForeground(new Color(255, 99, 71));
		score_1.setOpaque(false);
		score_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD | Font.ITALIC, 60));
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		
		score_1.setText(formatPoint(average_point));
		
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_1 = new BackgroundPanel(i);
			}else{
		         picture_1 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_1 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_1 = new BackgroundPanel(i);
			}
		}
		
		picture_1.setBounds(14, 17, 120, 120);
		panel_1.add(picture_1);		
		
	}

	/**
	 * 用酒店信息初始化第二个酒店信息panel
	 * @param hotelVO 酒店信息
	 * */
	private void initPanel2(HotelVO hotelVO) {
		
		panel_2 = new BackgroundPanel(background2);
		panel_2.setLayout(null);
		panel_2.setBounds(360, 330, 785, 155);
		backgroundPanel.add(panel_2);
		
		//第二个酒店的酒店名称
		txtHotelName_2 = new JTextArea();
		txtHotelName_2.setBounds(135, 17, 280, 40);
		panel_2.add(txtHotelName_2);
		txtHotelName_2.setText(hotelVO.getHotelName());
		txtHotelName_2.setOpaque(false);
		txtHotelName_2.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_2.setForeground(new Color(25, 25, 112));
		txtHotelName_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		txtHotelName_2.setColumns(10);
		txtHotelName_2.setBackground(new Color(176, 224, 230));
		
		//第二个酒店的查看详情按钮
		detailButton_2 = new JButton(new ImageIcon("view.jpg"));
		detailButton_2.setBounds(636, 17, 135, 120);
		detailButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_2.add(detailButton_2);
		
		//第二个酒店的评分
		score_2 = new JTextArea();
		score_2.setBounds(512, 17, 126, 90);  
		panel_2.add(score_2);
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		score_2.setText(formatPoint(average_point));
		score_2.setOpaque(false);
		score_2.setForeground(new Color(255, 99, 71));
		score_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD | Font.ITALIC, 60));
		
		//第二个酒店的酒店图片
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_2 = new BackgroundPanel(i);
			}else{
		         picture_2 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_2 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_2 = new BackgroundPanel(i);
			}
		}
		picture_2.setBounds(14, 17, 120, 120);
		panel_2.add(picture_2);
		
		//第二个酒店的电话号码
		txtTel_2 = new JTextArea();
		txtTel_2.setText(hotelVO.getTelephone());
		txtTel_2.setOpaque(false);
		txtTel_2.setMargin(new Insets(10, 10, 10, 10));
		txtTel_2.setForeground(new Color(25, 25, 112));
		txtTel_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtTel_2.setColumns(10);
		txtTel_2.setBounds(228, 99, 220, 43);
		panel_2.add(txtTel_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_3.setOpaque(false);
		textArea_3.setMargin(new Insets(10, 10, 10, 10));
		textArea_3.setForeground(new Color(25, 25, 112));
		textArea_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		textArea_3.setEditable(false);
		textArea_3.setColumns(10);
		textArea_3.setBounds(135, 103, 98, 40);
		panel_2.add(textArea_3);
		
		//第二个酒店的详细地址
		txtAddress_2 = new JTextArea();
		txtAddress_2.setText(hotelVO.getHotelAddress());
		txtAddress_2.setOpaque(false);
		txtAddress_2.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_2.setForeground(new Color(25, 25, 112));
		txtAddress_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		txtAddress_2.setColumns(10);
		txtAddress_2.setBounds(135, 70, 350, 40);
		panel_2.add(txtAddress_2);
		
		JLabel label_1 = new JLabel();
		label_1.setText("\u7EFC\u5408\u8BC4\u5206");
		label_1.setOpaque(false);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_1.setBounds(425, 17, 98, 40);
		panel_2.add(label_1);
		
		//第二个酒店的星级
		star_2 = new JTextArea();
		star_2.setText(hotelVO.getHotelStar()+"星级");
		star_2.setOpaque(false);
		star_2.setMargin(new Insets(10, 10, 10, 10));
		star_2.setForeground(new Color(25, 25, 112));
		star_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		star_2.setEditable(false);
		star_2.setColumns(10);
		star_2.setBounds(463, 102, 98, 40);
		panel_2.add(star_2);
		
		//第二个酒店的价格
		price_2 = new JTextArea();
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_2.setText("￥"+String.valueOf(price)+"起");
		price_2.setOpaque(false);
		price_2.setMargin(new Insets(10, 10, 10, 10));
		price_2.setForeground(new Color(25, 25, 112));
		price_2.setFont(new Font("宋体", Font.BOLD, 20));
		price_2.setEditable(false);
		price_2.setColumns(10);
		price_2.setBounds(540, 98, 98, 43);
		panel_2.add(price_2);	
		
	}

	/**
	 * 用hotelVO 初始化第三个酒店信息label
	 * @param hotelVO 酒店信息
	 * */
	private void initPanel3(HotelVO hotelVO) {
		
		panel_3 = new BackgroundPanel(background2);
		panel_3.setLayout(null);
		panel_3.setBounds(360, 510, 785, 155);
		backgroundPanel.add(panel_3);
		
		//第三个酒店的电话
		txtTel_3 = new JTextArea();
		txtTel_3.setText(hotelVO.getTelephone());
		txtTel_3.setOpaque(false);
		txtTel_3.setMargin(new Insets(10, 10, 10, 10));
		txtTel_3.setForeground(new Color(25, 25, 112));
		txtTel_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtTel_3.setColumns(10);
		txtTel_3.setBounds(228, 99, 220, 43);
		panel_3.add(txtTel_3);
		
		//第三个酒店的酒店名称
		txtHotelName_3 = new JTextArea();
		txtHotelName_3.setBounds(135, 17, 280, 40);
		panel_3.add(txtHotelName_3);
		txtHotelName_3.setText(hotelVO.getHotelName());
		txtHotelName_3.setOpaque(false);
		txtHotelName_3.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_3.setForeground(new Color(25, 25, 112));
		txtHotelName_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		txtHotelName_3.setColumns(10);
		txtHotelName_3.setBackground(new Color(176, 224, 230));
		
		//第三个酒店的查看详情按钮
		detailButton_3 = new JButton(new ImageIcon("view.jpg"));
		detailButton_3.setBounds(636, 17, 135, 120);
		detailButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_3.add(detailButton_3);
		
		//第三个酒店的评分
		score_3 = new JTextArea();
		score_3.setBounds(512, 17, 126, 90);
		panel_3.add(score_3);
		
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		score_3.setText(formatPoint(average_point));
		score_3.setOpaque(false);
		score_3.setForeground(new Color(255, 99, 71));
		score_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD | Font.ITALIC, 60));
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_8.setOpaque(false);
		textArea_8.setMargin(new Insets(10, 10, 10, 10));
		textArea_8.setForeground(new Color(25, 25, 112));
		textArea_8.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		textArea_8.setEditable(false);
		textArea_8.setColumns(10);
		textArea_8.setBounds(135, 103, 98, 40);
		panel_3.add(textArea_8);
		
		//第三个酒店的详细地址
		txtAddress_3 = new JTextArea();
		txtAddress_3.setText(hotelVO.getHotelAddress());
		txtAddress_3.setOpaque(false);
		txtAddress_3.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_3.setForeground(new Color(25, 25, 112));
		txtAddress_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		txtAddress_3.setColumns(10);
		txtAddress_3.setBounds(135, 70, 350, 40);
		panel_3.add(txtAddress_3);
		
		JLabel label_2 = new JLabel();
		label_2.setText("\u7EFC\u5408\u8BC4\u5206");
		label_2.setOpaque(false);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_2.setBounds(425, 17, 98, 40);
		panel_3.add(label_2);
		
		//第三个酒店的星级
		star_3 = new JTextArea();
		star_3.setText(hotelVO.getHotelStar()+"星级");
		star_3.setOpaque(false);
		star_3.setMargin(new Insets(10, 10, 10, 10));
		star_3.setForeground(new Color(25, 25, 112));
		star_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		star_3.setEditable(false);
		star_3.setColumns(10);
		star_3.setBounds(462, 103, 98, 40);
		panel_3.add(star_3);
		
		//第三个酒店的图片
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_3 = new BackgroundPanel(i);
			}else{
		         picture_3 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_3 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_3 = new BackgroundPanel(i);
			}
		}
		picture_3.setBounds(14, 17, 120, 120);
		panel_3.add(picture_3);
		
		//第三个酒店的价格
		price_3 = new JTextArea();
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_3.setText("￥"+String.valueOf(price)+"起");
		price_3.setOpaque(false);
		price_3.setMargin(new Insets(10, 10, 10, 10));
		price_3.setForeground(new Color(25, 25, 112));
		price_3.setFont(new Font("宋体", Font.BOLD, 20));
		price_3.setEditable(false);
		price_3.setColumns(10);
		price_3.setBounds(539, 99, 98, 43);
		panel_3.add(price_3);	
	}

	/**
	 * 利用三个酒店vo来初始化显示的酒店信息界面
	 * @param threeHotels 三个酒店vo
	 * */
	private void changeThreeHotelPanel(List<HotelVO> threeHotels) {
		
		if(threeHotels.size()==1){
			changePanel1(threeHotels.get(0));
			hidePanel2();
			hidePanel3();
		}else if(threeHotels.size()==2){
			changePanel1(threeHotels.get(0));
			changePanel2(threeHotels.get(1));
			hidePanel3();
		}else if(threeHotels.size()==3){
			changePanel1(threeHotels.get(0));
			changePanel2(threeHotels.get(1));
			changePanel3(threeHotels.get(2));
		}/*else{
			//酒店信息的数目为0
			hidePanel1();
			hidePanel2();
			hidePanel3();
		}*/
	}

	private void changePanel1(HotelVO hotelVO) {
		
		if(panel_1==null){
			initPanel1(hotelVO);
		}
		if(!panel_1.isVisible()){
			panel_1.setVisible(true);
		}
		txtHotelName_1.setText(hotelVO.getHotelName());
		txtTel_1.setText(hotelVO.getTelephone());
		txtAddress_1.setText(hotelVO.getHotelAddress());
		
		star_1.setText(hotelVO.getHotelStar()+"星级");
		price_1.setText("￥"+findMin(hotelVO.getRoomTypeAndPrice())+"起");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_1.setText(formatPoint(point));
	    detailButton_1.removeActionListener(detailButton_1.getActionListeners()[0]);
	    detailButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//酒店图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_1.remove(picture_1);
			picture_1 = new BackgroundPanel(i);
			picture_1.setBounds(14, 17, 120, 120);
			panel_1.add(picture_1);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//不存在图片的话，用默认的酒店图片
				panel_1.remove(picture_1);
				picture_1 = new BackgroundPanel(hotel);
				picture_1.setBounds(14, 17, 120, 120);
				panel_1.add(picture_1);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_1.remove(picture_1);
				picture_1 = new BackgroundPanel(i);
				picture_1.setBounds(14, 17, 120, 120);
				panel_1.add(picture_1);	
			}
		}
		panel_1.repaint();
	}

	private void changePanel2(HotelVO hotelVO) {
		
		if(panel_2==null){
			initPanel2(hotelVO);
		}
		if(!panel_2.isVisible()){
			panel_2.setVisible(true);
		}
		txtHotelName_2.setText(hotelVO.getHotelName());
		txtTel_2.setText(hotelVO.getTelephone());
		txtAddress_2.setText(hotelVO.getHotelAddress());
		//picture_1 这个更改图片的没有实现
		star_2.setText(hotelVO.getHotelStar()+"星级");
		price_2.setText("￥"+findMin(hotelVO.getRoomTypeAndPrice())+"起");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_2.setText(formatPoint(point));
	    detailButton_2.removeActionListener(detailButton_2.getActionListeners()[0]);
	    detailButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//酒店图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_2.remove(picture_2);
			picture_2 = new BackgroundPanel(i);
			picture_2.setBounds(14, 17, 120, 120);
			panel_2.add(picture_2);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//不存在图片的话，用默认的酒店图片
				panel_2.remove(picture_2);
				picture_2 = new BackgroundPanel(hotel);
				picture_2.setBounds(14, 17, 120, 120);
				panel_2.add(picture_2);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_2.remove(picture_2);
				picture_2 = new BackgroundPanel(i);
				picture_2.setBounds(14, 17, 120, 120);
				panel_2.add(picture_2);	
			}
		}
		panel_2.repaint();
	}

	private void changePanel3(HotelVO hotelVO) {
		
		if(panel_3==null){
			initPanel3(hotelVO);
		}
		if(!panel_3.isVisible()){
			panel_3.setVisible(true);
		}
		txtHotelName_3.setText(hotelVO.getHotelName());
		txtTel_3.setText(hotelVO.getTelephone());
		txtAddress_3.setText(hotelVO.getHotelAddress());

		star_3.setText(hotelVO.getHotelStar()+"星级");
		price_3.setText("￥"+findMin(hotelVO.getRoomTypeAndPrice())+"起");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_3.setText(formatPoint(point));
	    detailButton_3.removeActionListener(detailButton_3.getActionListeners()[0]);
	    detailButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//酒店图片已经存在
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_3.remove(picture_3);
			picture_3 = new BackgroundPanel(i);
			picture_3.setBounds(14, 17, 120, 120);
			panel_3.add(picture_3);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//不存在图片的话，用默认的酒店图片
				panel_3.remove(picture_3);
				picture_3 = new BackgroundPanel(hotel);
				picture_3.setBounds(14, 17, 120, 120);
				panel_3.add(picture_3);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_3.remove(picture_3);
				picture_3 = new BackgroundPanel(i);
				picture_3.setBounds(14, 17, 120, 120);
				panel_3.add(picture_3);	
			}
		}
		panel_3.repaint();
	}

	private void hidePanel2() {
	
		if(panel_2!=null){
			panel_2.setVisible(false);
		}
	}

	private void hidePanel3() {
		
		//backgroundPanel.remove(panel_3);
		if(panel_3!=null){
			panel_3.setVisible(false);
		}
		
	}

	/**
	 * 对界面下方的页数label进行初始化
	 * @param currentPage 当前页数
	 * @param allPage 总页数
	 * */
	private void initPageLabel(int currentPage, int allPage) {
		
		if(currentPage == 0)
		{ 
			currentPage = 1;
		}
		if(allPage == 0)
		{
			allPage = 1;
		}
		
		
		String page_before = "第"+currentPage+"页";
		String page_behind = "总"+allPage+"页";
		pageLabel = new JLabel(page_before+" "+page_behind);
		pageLabel.setFont(new Font("仿宋", Font.BOLD, 15));
		pageLabel.setBounds(704, 716, 120, 29);
		backgroundPanel.add(pageLabel);	
		
	}

	private void changePageLabel(){
		
		int currentPage = controller.getCurrentPage();
		int allPage = controller.getAllPages();
		String page = "第"+currentPage+"页 共"+allPage+"页";
		pageLabel.setText(page);
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

	/**
	 * 将评分保留两位小数进行显示
	 * @param d 评分
	 * */
	private String formatPoint(double d){
		
		if(d==0){
			return "0.0";
		}else{
			DecimalFormat dec = new DecimalFormat("#.0");
			return dec.format(d);
		
		}
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
	
	private void returnButtonClicked(){

		String clientID = controller.getClientID();
		MainUIController controller = new MainUIController(clientID);
		mainUI ui = new mainUI(controller);
		controller.setUI(ui);
		ui.setVisible(true);
		this.dispose();
	}
	
	private void detailButtonClicked(HotelVO vo,String clientID){
		
		hotelDetailUI ui = new hotelDetailUI(vo,clientID);
		ui.setLastUI(this);
		ui.setVisible(true);
		this.dispose();
	}
}


