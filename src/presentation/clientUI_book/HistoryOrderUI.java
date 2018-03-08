package presentation.clientUI_book;


/*
 * 
 * 客户进行订单预订——查看酒店详情界面原型
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.accountUI;
import presentation.help.HotelPicture;
import vo.HotelVO;
import vo.OrderVO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HistoryOrderUI extends JFrame
{

	private JPanel contentPane;
	private JButton lastPageButton;
	private JButton nextPageButton;

	private JButton backButton;
	private JLabel pageLabel;
	private JTextArea date_1 = new JTextArea();
	private JLabel status_1 = new JLabel();
	private JLabel price_1 = new JLabel();
	
	private JLabel price_2 = new JLabel();
	private BackgroundPanel backgroundPanel;
	private Image room;
	private Image background4;

	private int index =0;
	
	private BackgroundPanel backgroundPanel_2;
	private JPanel backgroundPanel_1;
	private BackgroundPanel backgroundPanel_3;
	private BackgroundPanel backgroundPanel_4;
	private BackgroundPanel backgroundPanel_5;
	
	private JLabel price_3 = new JLabel();

	private JTextArea date_4 = new JTextArea();
	private JLabel price_4 = new JLabel();

	private JTextArea date_5 = new JTextArea();
	private JLabel status_5 = new JLabel();
	
	private JButton detail_5;
	private JLabel price_5 = new JLabel();
	private JLabel id_5 = new JLabel();
	
	private int current;
	private int total;
	
	private HotelVO vo;
	private List<OrderVO> orders;
	
	private JLabel id_1 = new JLabel();
	private JButton detail_1;
	private JLabel status_4 = new JLabel();
	private JLabel id_4 = new JLabel();
	private JButton detail_4;
	private JTextArea date_3 = new JTextArea();
	private JLabel status_3 = new JLabel();
	private JLabel id_3 = new JLabel();
	private JButton detail_3;
	private JTextArea date_2 = new JTextArea();
	private JLabel status_2 = new JLabel();
	private JLabel id_2 = new JLabel();
	private JButton detail_2;
	
	private hotelDetailUI ui;
	private JLabel titleLbl;
	
	private Map<String,Image> orderState;
	private BackgroundPanel roomPanel_5;
	private BackgroundPanel roomPanel_1;
	private BackgroundPanel roomPanel_4;
	private BackgroundPanel roomPanel_3;
	private BackgroundPanel roomPanel_2;
	/**
	 * Create the frame.
	 */
	public HistoryOrderUI(List<OrderVO> orders,HotelVO vo)
	{
	
		this.orders = orders;
		this.vo = vo;
		//roomTypes = vo.getRoomTypeAndPrice().split("/");//所有的房间类型
		
		orderState = new HashMap<String,Image>();
		Image i1 = new ImageIcon("room_exe.jpg").getImage();
		orderState.put("已执行", i1);
		Image i2 = new ImageIcon("room_wit.jpg").getImage();
		orderState.put("已撤销", i2);
		Image i3 = new ImageIcon("room_une.jpg").getImage();
		orderState.put("未执行", i3);
		Image i4 = new ImageIcon("room_abn.jpg").getImage();
		orderState.put("异常", i4);
		
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
		backgroundPanel = new BackgroundPanel(new ImageIcon("background6.jpg").getImage());
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		backgroundPanel.add(closeLabel);
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.BLACK);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
		minLabel.setBounds(1097, 18, 26, 30);
		backgroundPanel.add(minLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1146, 13, 40, 40);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		backgroundPanel.add(closeBT);
		
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
		
		MouseEventListener mouseListener = new MouseEventListener(this);
		
		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1069, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		//上一页按钮
		lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(240, 710, 170, 60);
		lastPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				lastPageButtonClicked();
			}
			
		});
		backgroundPanel.add(lastPageButton);
		
		//下一页按钮
		nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(799, 710, 170, 60);
		nextPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			     nextPageButtonClicked();
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
		hotelName.setBounds(167, 42, 350, 50);
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
		hotelAddress.setBounds(167, 88, 350, 40);
		backgroundPanel.add(hotelAddress);
		
		//显示在页面上的“订单状态”字样
		JLabel orderStatusLabel = new JLabel("订单状态");
		orderStatusLabel.setForeground(new Color(255, 255, 255));
		orderStatusLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		orderStatusLabel.setBounds(397, 177, 100, 30);
		backgroundPanel.add(orderStatusLabel);
		
		//显示在页面上的“订单编号”字样
		JLabel orderIDLabel = new JLabel("订单编号");
		orderIDLabel.setForeground(Color.WHITE);
		orderIDLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		orderIDLabel.setBounds(589, 177, 100, 30);
		backgroundPanel.add(orderIDLabel);
		
		background4 = new ImageIcon("background4.jpg").getImage();
		
		//房间照片
		room = new ImageIcon("room.jpg").getImage();
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		String hotelID = vo.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//在本地存在酒店图片的话
			hotel = HotelPicture.getLocalPicture(hotelID);
		}
		BackgroundPanel hotelPanel = new BackgroundPanel(hotel);
		hotelPanel.setBounds(43, 45, 120, 120);
		backgroundPanel.add(hotelPanel);
		
		//返回上一层的按钮
		backButton = new JButton(new ImageIcon("return2.jpg"));
		backButton.setBounds(973, 78, 165, 50);
		backButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				HistoryOrderUI.this.dispose();
				ui.setVisible(true);
			}
			
		});
		backgroundPanel.add(backButton);
		
		JLabel createdDateLabel = new JLabel("生成日期");
		createdDateLabel.setForeground(new Color(255, 255, 255));
		createdDateLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		createdDateLabel.setBounds(210, 177, 100, 30);
		backgroundPanel.add(createdDateLabel);
		
		JLabel orderPriceLabel = new JLabel("订单价格");
		orderPriceLabel.setForeground(new Color(255, 255, 255));
		orderPriceLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		orderPriceLabel.setBounds(799, 177, 100, 30);
		backgroundPanel.add(orderPriceLabel);
		
		initFinePanels();
		
		initPageLabel();
		
		//initCreateOrderPanel();
		
	}
	
	public void setLastView(hotelDetailUI ui){
		
		this.ui = ui;
	}
	
	/**
	 *初始化显示的五个panel 
	 * */
	private void initFinePanels() {
		
		int total = orders.size();
		switch(total){
		case 0:
		{
			initPanel1();
			initPanel2();
			initPanel3();
			initPanel4();
			initPanel5();
			
			backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		case 1:
		{
			initPanel1(orders.get(index++));
			initPanel2();
			initPanel3();
			initPanel4();
			initPanel5();
			
			//backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:
		{
			initPanel1(orders.get(index++));
			initPanel2(orders.get(index++));
			initPanel3();
			initPanel4();
			initPanel5();
			
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 3:
		{
			initPanel1(orders.get(index++));
			initPanel2(orders.get(index++));
			initPanel3(orders.get(index++));
			initPanel4();
			initPanel5();
			
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 4:
		{
			initPanel1(orders.get(index++));
			initPanel2(orders.get(index++));
			initPanel3(orders.get(index++));
			initPanel4(orders.get(index++));
			initPanel5();

			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		default:
		{
			initPanel1(orders.get(index++));
			initPanel2(orders.get(index++));
			initPanel3(orders.get(index++));
			initPanel4(orders.get(index++));
			initPanel5(orders.get(index++));

			break;
		}
		
	}
	}

	private void initPageLabel() {
		
		int size = orders.size();
		current = index%5==0?index/5:index/5+1;
		total = size%5==0?size/5:size/5+1;
		if(current == 0)
			current = 1;
		if(total == 0)
			total = 1;
		
		
		pageLabel = new JLabel("第"+current+"页 共"+total+"页");
		pageLabel.setFont(new Font("仿宋", Font.BOLD, 15));
		pageLabel.setBounds(543, 722, 120, 29);
		backgroundPanel.add(pageLabel);
	}

	private void initDateArea(JTextArea dateArea,String orderCreatedDate){
		
		String createdDate[] = orderCreatedDate.split(" ");
		String date = "";
		if(createdDate.length==2){
		    date = createdDate[0]+"\n"+" "+createdDate[1];
		}
		 
		//dateArea = new JTextArea();
		dateArea.setEditable(false);
		dateArea.setText(date);
		dateArea.setOpaque(false);
		dateArea.setForeground(new Color(0, 0, 128));
		dateArea.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		dateArea.setBounds(154, 26, 200, 60);
	}
	
	private void initStatusLabel(JLabel statusLabel,String orderStatus){
		
		//statusLabel = new JLabel();
		statusLabel.setText(orderStatus);
		statusLabel.setForeground(new Color(0, 0, 128));
		statusLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		statusLabel.setBounds(360, 26, 100, 30);
	}
	
	private void initIDLabel(JLabel idLabel,String orderID){
		
		//idLabel = new JLabel();
		idLabel.setText(orderID);
		idLabel.setForeground(new Color(0, 0, 128));
		idLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		idLabel.setBounds(530,26,200,30);
	}
	
	private void initPriceLabel(JLabel priceLabel,double price){
		
		String p = "";
		if(price !=0){
			p = String.valueOf(price);
		}
		
		//priceLabel = new JLabel();
		priceLabel.setText(p);
		priceLabel.setForeground(new Color(255, 69, 0));
		priceLabel.setFont(new Font("宋体", Font.BOLD, 20));
		priceLabel.setBounds(770, 26, 63, 30);
		
	}
	
	private void initDetailButton(JButton bt){
		
		bt.setBounds(880, 15, 200, 60);
	}
	
	private void initPanel5(){
		
		backgroundPanel_5 = new BackgroundPanel(background4);
		backgroundPanel_5.setLayout(null);
		backgroundPanel_5.setBounds(43, 611, 1100, 90);
		backgroundPanel.add(backgroundPanel_5);
		
		roomPanel_5 = new BackgroundPanel(room);
		roomPanel_5.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(roomPanel_5);
		
		//date_5 = new JTextArea();
		initDateArea(date_5,"");
		backgroundPanel_5.add(date_5);
		
		//status_5 = new JLabel();
	    initStatusLabel(status_5,"");
		backgroundPanel_5.add(status_5);
		
		//price_5 = new JLabel();
		initPriceLabel(price_5,0);
		backgroundPanel_5.add(price_5);
		
		detail_5 = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_5);
		backgroundPanel_5.add(detail_5);
	}

	private void initPanel5(OrderVO vo) {
		
		backgroundPanel_5 = new BackgroundPanel(background4);
		backgroundPanel_5.setLayout(null);
		backgroundPanel_5.setBounds(43, 611, 1100, 90);
		backgroundPanel.add(backgroundPanel_5);
	
		String state = vo.getOrderStatus();
		roomPanel_5 = new BackgroundPanel(orderState.get(state));
		//BackgroundPanel roomPanel_5 = new BackgroundPanel(room);
		roomPanel_5.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(roomPanel_5);
		
		//显示的订单生成日期
		initDateArea(date_5,vo.getOrderCreatedDate());
		backgroundPanel_5.add(date_5);
		
		//显示的订单状态
		initStatusLabel(status_5,vo.getOrderStatus());
		backgroundPanel_5.add(status_5);
		
		//显示的订单编号
		initIDLabel(id_5,vo.getOrderID());
		backgroundPanel_5.add(id_5);
		
		//显示的订单价格
		initPriceLabel(price_5,vo.getPrice());
		backgroundPanel_5.add(price_5);
		
		detail_5 = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_5);
		detail_5.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderDetailUI detailUI = new OrderDetailUI(vo);
				detailUI.setLastView(HistoryOrderUI.this);
				detailUI.setVisible(true);
				HistoryOrderUI.this.dispose();
			}
			
		});
		backgroundPanel_5.add(detail_5);
	}

	private void initPanel1(OrderVO vo) {
	
		backgroundPanel_1 = new BackgroundPanel(background4);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(43, 211, 1100, 90);
		backgroundPanel.add(backgroundPanel_1);
		
		String state = vo.getOrderStatus();
		roomPanel_1 = new BackgroundPanel(orderState.get(state));
		roomPanel_1.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(roomPanel_1);//设置图片
		
		//订单生成日期 需要进行设置的
		initDateArea(date_1,vo.getOrderCreatedDate());
		backgroundPanel_1.add(date_1);
		
	    //订单状态
		initStatusLabel(status_1,vo.getOrderStatus());
		backgroundPanel_1.add(status_1);
		
		//订单编号
		initIDLabel(id_1,vo.getOrderID());
		backgroundPanel_1.add(id_1);
		
		//房间价格 需要进行设置
		initPriceLabel(price_1,vo.getPrice());
		backgroundPanel_1.add(price_1);
		
		
		//预订按钮 需要进行设置
		detail_1  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_1);
		detail_1.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderDetailUI detailUI = new OrderDetailUI(vo);
				detailUI.setLastView(HistoryOrderUI.this);
				detailUI.setVisible(true);
				HistoryOrderUI.this.dispose();
			}
			
		});
		backgroundPanel_1.add(detail_1);
	}

	private void initPanel4(){

		backgroundPanel_4 = new BackgroundPanel(background4);
		backgroundPanel_4.setLayout(null);
		backgroundPanel_4.setBounds(43, 511, 1100, 90);
		backgroundPanel.add(backgroundPanel_4);
		
		roomPanel_4 = new BackgroundPanel(room);
		roomPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_4.add(roomPanel_4);
		
		initDateArea(date_4,"");
		backgroundPanel_4.add(date_4);
		
		initStatusLabel(status_4,"");
		backgroundPanel_4.add(status_4);
		
		initIDLabel(id_4,"");
		backgroundPanel_4.add(id_4);
		
		initPriceLabel(price_4,0);
		backgroundPanel_4.add(price_4);
		
		detail_4  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_4);
		backgroundPanel_4.add(detail_4);
	
	}
	
	private void initPanel4(OrderVO vo) {
		
		backgroundPanel_4 = new BackgroundPanel(background4);
		backgroundPanel_4.setLayout(null);
		backgroundPanel_4.setBounds(43, 511, 1100, 90);
		backgroundPanel.add(backgroundPanel_4);
		
		//BackgroundPanel roomPanel_4 = new BackgroundPanel(room);

		String state = vo.getOrderStatus();
		roomPanel_4 = new BackgroundPanel(orderState.get(state));
		roomPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_4.add(roomPanel_4);
		
		initDateArea(date_4,vo.getOrderCreatedDate());
		backgroundPanel_4.add(date_4);
		
		initStatusLabel(status_4,vo.getOrderStatus());
		backgroundPanel_4.add(status_4);
		
		initIDLabel(id_4,vo.getOrderID());
		backgroundPanel_4.add(id_4);
		
		initPriceLabel(price_4,vo.getPrice());
		backgroundPanel_4.add(price_4);
		
		detail_4  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_4);
		detail_4.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderDetailUI detailUI = new OrderDetailUI(vo);
				detailUI.setLastView(HistoryOrderUI.this);
				detailUI.setVisible(true);
				HistoryOrderUI.this.dispose();
			}
			
		});
		backgroundPanel_4.add(detail_4);
	}

	private void initPanel3(){

		backgroundPanel_3 = new BackgroundPanel(background4);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(43, 411, 1100, 90);
		backgroundPanel.add(backgroundPanel_3);
		
		roomPanel_3 = new BackgroundPanel(room);
		roomPanel_3.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(roomPanel_3);
		
		initDateArea(date_3,"");
		backgroundPanel_3.add(date_3);
		
		initStatusLabel(status_3,"");
		backgroundPanel_3.add(status_3);
		
		initIDLabel(id_3,"");
		backgroundPanel_3.add(id_3);
		
		initPriceLabel(price_3,0);
		backgroundPanel_3.add(price_3);
		
		detail_3  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_3);
		backgroundPanel_3.add(detail_3);
	
	}
	
	private void initPanel3(OrderVO vo) {
		
		backgroundPanel_3 = new BackgroundPanel(background4);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(43, 411, 1100, 90);
		backgroundPanel.add(backgroundPanel_3);
		
		//BackgroundPanel roomPanel_3 = new BackgroundPanel(room);
		String state = vo.getOrderStatus();
		roomPanel_3 = new BackgroundPanel(orderState.get(state));
		roomPanel_3.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(roomPanel_3);
		
		initDateArea(date_3,vo.getOrderCreatedDate());
		backgroundPanel_3.add(date_3);
		
		initStatusLabel(status_3,vo.getOrderStatus());
		backgroundPanel_3.add(status_3);
		
		initIDLabel(id_3,vo.getOrderID());
		backgroundPanel_3.add(id_3);
		
		initPriceLabel(price_3,vo.getPrice());
		backgroundPanel_3.add(price_3);
		
		detail_3  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_3);
		detail_3.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderDetailUI detailUI = new OrderDetailUI(vo);
				detailUI.setLastView(HistoryOrderUI.this);
				detailUI.setVisible(true);
				HistoryOrderUI.this.dispose();
			}
			
		});
		backgroundPanel_3.add(detail_3);
	}

	private void initPanel2(){
		
		backgroundPanel_2 = new BackgroundPanel(background4);
		backgroundPanel_2.setLayout(null);
		backgroundPanel_2.setBounds(43, 311, 1100, 90);
		backgroundPanel.add(backgroundPanel_2);
		
		roomPanel_2 = new BackgroundPanel(room);
		roomPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_2.add(roomPanel_2);
		
		initDateArea(date_2,"");
		backgroundPanel_2.add(date_2);
		
		initStatusLabel(status_2,"");
		backgroundPanel_2.add(status_2);
		
		initIDLabel(id_2,"");
		backgroundPanel_2.add(id_2);
		
		initPriceLabel(price_2,0);
		backgroundPanel_2.add(price_2);
		
		detail_2  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_2);
		detail_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		backgroundPanel_2.add(detail_2);
	}
	private void initPanel2(OrderVO vo) {
		
		backgroundPanel_2 = new BackgroundPanel(background4);
		backgroundPanel_2.setLayout(null);
		backgroundPanel_2.setBounds(43, 311, 1100, 90);
		backgroundPanel.add(backgroundPanel_2);
		
		//BackgroundPanel roomPanel_2 = new BackgroundPanel(room);
		String state = vo.getOrderStatus();
		roomPanel_2 = new BackgroundPanel(orderState.get(state));
		roomPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_2.add(roomPanel_2);
		
		initDateArea(date_2,vo.getOrderCreatedDate());
		backgroundPanel_2.add(date_2);
		
		initStatusLabel(status_2,vo.getOrderStatus());
		backgroundPanel_2.add(status_2);
		
		initIDLabel(id_2,vo.getOrderID());
		backgroundPanel_2.add(id_2);
		
		initPriceLabel(price_2,vo.getPrice());
		backgroundPanel_2.add(price_2);
		
		detail_2  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_2);
		detail_2.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				OrderDetailUI detailUI = new OrderDetailUI(vo);
				detailUI.setLastView(HistoryOrderUI.this);
				detailUI.setVisible(true);
				HistoryOrderUI.this.dispose();
			}
			
		});
		backgroundPanel_2.add(detail_2);
	}

	private void initPanel1(){
	
		backgroundPanel_1 = new BackgroundPanel(background4);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(43, 211, 1100, 90);
		backgroundPanel.add(backgroundPanel_1);
		
		roomPanel_1 = new BackgroundPanel(room);
		roomPanel_1.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(roomPanel_1);//设置房间图片
		
		initDateArea(date_1,"");
		backgroundPanel_1.add(date_1);
		
		initStatusLabel(status_1,"");
		backgroundPanel_1.add(status_1);
		
		initIDLabel(id_1,"");
		backgroundPanel_1.add(id_1);
		
		initPriceLabel(price_1,0);
		backgroundPanel_1.add(price_1);
		
		detail_1  = new JButton(new ImageIcon("check_Detail.jpg"));
		initDetailButton(detail_1);
		detail_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		backgroundPanel_1.add(detail_1);
	}

	/*private int formatPrice (double d){
		
		return (int) Math.round(d);
	}*/

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
		
		changePanel1(orders.get(index-5));
		changePanel2(orders.get(index-4));
		changePanel3(orders.get(index-3));
		changePanel4(orders.get(index-2));
		changePanel5(orders.get(index-1));
		
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

	private void changePanel5(OrderVO vo) {
		
		String state = vo.getOrderStatus();
		backgroundPanel_5.remove(roomPanel_5);
		roomPanel_5 = new BackgroundPanel(orderState.get(state));
		roomPanel_5.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(roomPanel_5);//设置房间图片
		backgroundPanel_5.repaint();
		
		initDateArea(date_5,vo.getOrderCreatedDate());
		
		initStatusLabel(status_5,vo.getOrderStatus());
		
		initIDLabel(id_5,vo.getOrderID());
		
		initPriceLabel(price_5,vo.getPrice());
		
		if(detail_5.getActionListeners().length!=0){
			detail_5.removeActionListener(detail_5.getActionListeners()[0]);
		}

		detail_5.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			OrderDetailUI detailUI = new OrderDetailUI(vo);
			detailUI.setLastView(HistoryOrderUI.this);
			detailUI.setVisible(true);
			HistoryOrderUI.this.dispose();
		}
		
	});
	
	}

	private void changePanel4(OrderVO vo) {
		
		String state = vo.getOrderStatus();
		backgroundPanel_4.remove(roomPanel_4);
		roomPanel_4 = new BackgroundPanel(orderState.get(state));
		roomPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_4.add(roomPanel_4);//设置房间图片
		backgroundPanel_4.repaint();
		
		initDateArea(date_4,vo.getOrderCreatedDate());
		
		initStatusLabel(status_4,vo.getOrderStatus());
		
		initIDLabel(id_4,vo.getOrderID());
		
		initPriceLabel(price_4,vo.getPrice());
		
		if(detail_4.getActionListeners().length!=0){
			detail_4.removeActionListener(detail_4.getActionListeners()[0]);
		}

		detail_4.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			OrderDetailUI detailUI = new OrderDetailUI(vo);
			detailUI.setLastView(HistoryOrderUI.this);
			detailUI.setVisible(true);
			HistoryOrderUI.this.dispose();
		}
		
	});
	}

	private void changePanel3(OrderVO vo) {
		
		String state = vo.getOrderStatus();
		backgroundPanel_3.remove(roomPanel_3);
		roomPanel_3 = new BackgroundPanel(orderState.get(state));
		roomPanel_3.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(roomPanel_3);//设置房间图片
		backgroundPanel_3.repaint();
		
		initDateArea(date_3,vo.getOrderCreatedDate());
		
		initStatusLabel(status_3,vo.getOrderStatus());
		
		initIDLabel(id_3,vo.getOrderID());
		
		initPriceLabel(price_3,vo.getPrice());
		
		if(detail_3.getActionListeners().length!=0){
			detail_3.removeActionListener(detail_3.getActionListeners()[0]);
		}

		detail_3.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			OrderDetailUI detailUI = new OrderDetailUI(vo);
			detailUI.setLastView(HistoryOrderUI.this);
			detailUI.setVisible(true);
			HistoryOrderUI.this.dispose();
		}
		
	});
	}

	private void changePanel2(OrderVO vo) {
		
		String state = vo.getOrderStatus();
		backgroundPanel_2.remove(roomPanel_2);
		roomPanel_2 = new BackgroundPanel(orderState.get(state));
		roomPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_2.add(roomPanel_2);//设置房间图片
		backgroundPanel_2.repaint();
		
		initDateArea(date_2,vo.getOrderCreatedDate());
		
		initStatusLabel(status_2,vo.getOrderStatus());
		
		initIDLabel(id_2,vo.getOrderID());
		
		initPriceLabel(price_2,vo.getPrice());
		
		if(detail_2.getActionListeners().length!=0){
			detail_2.removeActionListener(detail_2.getActionListeners()[0]);
		}

		detail_2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			OrderDetailUI detailUI = new OrderDetailUI(vo);
			detailUI.setLastView(HistoryOrderUI.this);
			detailUI.setVisible(true);
			HistoryOrderUI.this.dispose();
		}
		
	});
	}

	private void changePanel1(OrderVO vo) {
		
		String state = vo.getOrderStatus();
		
		backgroundPanel_1.remove(roomPanel_1);
		roomPanel_1 = new BackgroundPanel(orderState.get(state));
		roomPanel_1.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(roomPanel_1);//设置房间图片
		backgroundPanel_1.repaint();
		//backgroundPanel_1.add(roomPanel_1);
		
		initDateArea(date_1,vo.getOrderCreatedDate());
		
		initStatusLabel(status_1,vo.getOrderStatus());
		
		initIDLabel(id_1,vo.getOrderID());
		
		initPriceLabel(price_1,vo.getPrice());
		
		
		if(detail_1.getActionListeners().length!=0){
			detail_1.removeActionListener(detail_1.getActionListeners()[0]);
		}

		detail_1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
			OrderDetailUI detailUI = new OrderDetailUI(vo);
			detailUI.setLastView(HistoryOrderUI.this);
			detailUI.setVisible(true);
			HistoryOrderUI.this.dispose();
		}
		
		
		
	});
	}

	/**
	 * 下一页按钮按下的实际事件响应
	 * */
	public void nextPageButtonClicked() {
		
		int size = orders.size();
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
			changePanel1(orders.get(index++));
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:{
			changePanel1(orders.get(index++));
			changePanel2(orders.get(index++));
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 3:{
			changePanel1(orders.get(index++));
			changePanel2(orders.get(index++));
			changePanel3(orders.get(index++));
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 4:{
			changePanel1(orders.get(index++));
			changePanel2(orders.get(index++));
			changePanel3(orders.get(index++));
			changePanel4(orders.get(index++));
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 5:{
			changePanel1(orders.get(index++));
			changePanel2(orders.get(index++));
			changePanel3(orders.get(index++));
			changePanel4(orders.get(index++));
			changePanel5(orders.get(index++));
			break;
		}
		}
		
		changePageLabel();
	}

	/**
	 * 改变页码
	 * */
	private void changePageLabel() {
		
		int size = orders.size();
		current = index%5==0?index/5:index/5+1;
		total = size%5==0?size/5:size/5+1;
		String str = "第"+current+"页 共"+total+"页";
		pageLabel.setText(str);
	}

}

class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
    HistoryOrderUI frame;
     
    public MouseEventListener(HistoryOrderUI frame) {
      this.frame = frame;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * 鼠标在标题栏拖拽时，设置窗口的坐标位置
    * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
    */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point p = this.frame.getLocation();
      this.frame.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }


