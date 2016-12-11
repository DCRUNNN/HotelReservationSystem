package presentation.clientUI_mainui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_book.bookUI;
import runner.ClientRunner;
import vo.SearchVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class mainUI extends JFrame
{

	private MainUIControllerService controller;
	
	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField checkInDate;
	private JTextField txtHotelName;
	private JTextField txtHotelGrade;
	private JTextField textField;
	private JTextField txtRoomType;
	private JTextField textField_2;
	private JTextField txtRoomAmount;

	private JComboBox<String> comboBox_province;
	private DefaultComboBoxModel<String> province_model;
	
	private JComboBox<String> comboBox_city;
	private DefaultComboBoxModel<String> city_model;
	
	private JComboBox<String> comboBox_CBD;
	private DefaultComboBoxModel<String> cbd_model;
	
	private JComboBox<String> comboBox_hotelGrade;
	private DefaultComboBoxModel<String> grade_model;

	private JButton accountButton;
	private JButton orderButton;
	private JButton hotelButton;
	private JButton creditButton;
	private JButton memberButton;
	private JButton searchButton;
	private JLabel welcomeLabel;
	
	private String welcomeStr;
	private String defaultHotelName = "(选填)酒店名称";
	private String defaultRoomType = "(选填)房间类型";
	private String defaultRoomAmount = "(选填)房间数目";
	/**
	 * Create the frame.
	 */
	
	public mainUI(MainUIControllerService controller)
	{
		
		this.controller = controller;
		this.initial();
	}
	
	public void initial()
	{
		//设置关于frame的一些属性
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		//设置Jpanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setLayout(null);
		
		//背景图片
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);				
		
		//客户的头像
		Image head = new ImageIcon("client.jpg").getImage();
		
		//账户信息button初始化
		accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		contentPane.add(accountButton);
		
		//我的订单button初始化
		orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(70, 470, 170, 60);
		contentPane.add(orderButton);
		
		//我的酒店button初始化
		hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(70, 540, 170, 60);
		contentPane.add(hotelButton);
		
		//信用记录button初始化
		creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(70, 610, 170, 60);
		contentPane.add(creditButton);
		
		//会员信息button初始化
		memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		contentPane.add(memberButton);
		
		//搜索button初始化
		searchButton = new JButton(new ImageIcon("search.jpg"));
		searchButton.setBounds(980, 676, 170, 60);
		searchButton.addActionListener(new SearchListener());
		backgroundPanel.add(searchButton);
		
		//显示在页面的label “酒店预订”
		JLabel accountLabel = new JLabel("酒店预订");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);	
		
		//显示在页面的textfield “目的地”
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(400, 210, 200, 50);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		//显示在页面的textfiled“入住日期”
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(400, 290, 200, 50);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		//显示在页面的textfield“关键词”
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(400, 450, 200, 50);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		//显示在页面的textfield“酒店级别”
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(400, 370, 200, 50);
		backgroundPanel.add(txtHotelGrade);
		
		//显示在页面的textfield“房间类型”
		textField = new JTextField();
		textField.setText("\u5173\u952E\u8BCD");
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(400, 530, 200, 50);
		backgroundPanel.add(textField);
		
		//显示在页面的textfield“房间数目”
		textField_2 = new JTextField();
		textField_2.setText("\u5173\u952E\u8BCD");
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(402, 610, 200, 50);
		backgroundPanel.add(textField_2);
		
		//背景图片初始化
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		backgroundPanel.add(headPanel);
		headPanel.setBorder(null);
		
		//欢迎label初始化 
		initWelcomeStr();
		welcomeLabel = new JLabel(welcomeStr);
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		
		//待输入的textfield 入住日期
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//得到当前的日期
		checkInDate = new JTextField();
		checkInDate.setText(currentDate);
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(600, 290, 280, 50);
		checkInDate.addMouseListener(new MouseAdapter(){
			public void mouseExited(MouseEvent e){
				
				String date = checkInDate.getText();
				if(!checkDate(date)){
					JOptionPane.showMessageDialog(null, "输入日期格式不正确","错误",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		checkInDate.setMargin(new Insets(0, 60, 0, 20));
		
		backgroundPanel.add(checkInDate);
		
		//待输入的textfield 酒店名称
		txtHotelName = new JTextField();
		Color defaultcolor = new Color(169,169,169);
		txtHotelName.setForeground(defaultcolor);
		txtHotelName.setText(defaultHotelName);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(600, 450, 280, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 20));
		//加上点击监听
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
		backgroundPanel.add(txtHotelName);
		
		//待输入的textfield 房间类型
		txtRoomType = new JTextField();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(0, 20, 0, 20));
		txtRoomType.setForeground(defaultcolor);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(600, 530, 280, 50);
		//加上点击监听
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
		backgroundPanel.add(txtRoomType);
		
		//待输入的textfield 房间数目
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setText(defaultRoomAmount);
		txtRoomAmount.setMargin(new Insets(0, 20, 0, 20));
		txtRoomAmount.setForeground(defaultcolor);
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomAmount.setColumns(10);
		txtRoomAmount.setBounds(600, 610, 280, 50);
		//加上点击监听
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
		backgroundPanel.add(txtRoomAmount);
		
		//省份下拉框初始化 
		initProvince_model();//初始化省份model
		comboBox_province = new JComboBox<String>(province_model);
		comboBox_province.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox_province.setBackground(Color.WHITE);
		comboBox_province.setBounds(600, 210, 140, 50);
		comboBox_province.addItemListener(new ProvinceListener());
		backgroundPanel.add(comboBox_province);
		
		String city[] = {"城市"};
		city_model = new DefaultComboBoxModel<String>(city);//初始化city_model
		
		//城市下拉框初始化
		comboBox_city = new JComboBox<String>(city_model);
		comboBox_city.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox_city.setBackground(Color.WHITE);
		comboBox_city.setBounds(740, 210, 140, 50);
		comboBox_city.addItemListener(new CityListener());
		backgroundPanel.add(comboBox_city);
		
		String cbd[] = {"商圈"};
		cbd_model = new DefaultComboBoxModel<String>(cbd);//初始化cbd_model
		
		//商圈下拉框初始化
		comboBox_CBD = new JComboBox<String>(cbd_model);
		comboBox_CBD.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox_CBD.setBackground(Color.WHITE);
		comboBox_CBD.setBounds(880, 210, 270, 50);
		backgroundPanel.add(comboBox_CBD);
		
		String grades[] = {
				"    不限","五星级/豪华","四星级/高档","三星级/舒适","两星级及以下/经济"
		};
		grade_model = new DefaultComboBoxModel<String>(grades);//grade_model初始化
		comboBox_hotelGrade = new JComboBox<String>(grade_model);
		comboBox_hotelGrade.setBackground(new Color(255, 255, 255));
		comboBox_hotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox_hotelGrade.setBounds(600, 370, 280, 50);
		backgroundPanel.add(comboBox_hotelGrade);
			
	}

	/**
	 * 初始化省份下拉框
	 * */
	private void initProvince_model() {
		
		String provinces = controller.getProvinces();
		String show = "省份"+"/"+provinces;
		String allProvinces[] = show.split("/");
		province_model = new DefaultComboBoxModel<String>(allProvinces);
	}

	/**
	 * 初始化欢迎字符串
	 * */
	private void initWelcomeStr() {
		
		String name = controller.getClientName();
		welcomeStr = "欢迎你! "+name;
	}

	public static void main(String args[]){
		
		new ClientRunner();
    	String clientID = "0000001";
    	MainUIController controller = new MainUIController(clientID);
    	mainUI ui = new mainUI(controller);	
    	controller.setUI(ui);
    	ui.setVisible(true);
	}
	
	/**
	 * 省份下拉框对应的事件监听的内部类
	 * */
	private class ProvinceListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			controller.selectProvince();
		}
		
	}

	/**
	 * 在界面内部的选中省份事件的实现
	 * */
	public void selectProvince() {
	    
		//选中事件的监听
		int index = comboBox_province.getSelectedIndex();
		if(index!=0){
			//不是默认选中值的话
			String province = (String) comboBox_province.getSelectedItem();
			initCity_model(province);
		}
	
	}
	
	/**
	 * 对city_model进行修改
	 * */
	public void initCity_model(String province){
		
		String allCities = controller.getCities(province);
		String show = "城市"+"/"+allCities;
		String city [] = show.split("/");
		city_model = new DefaultComboBoxModel<String>(city);
		comboBox_city.setModel(city_model);
	}
	
	/**
	 * 城市下拉框对应事件对应的内部类
	 * */
	private class CityListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
	
			controller.selectCity();
		}
		
	}

	/**
	 * 界面内部的选中城市的方法的实现
	 * */
	public void selectCity() {
		
		int index = comboBox_city.getSelectedIndex();
		if(index!=0){
			//不是选中默认值
			String province = (String) comboBox_province.getSelectedItem();
			String city = (String)comboBox_city.getSelectedItem();
			initCBD_model(province,city);
		}
	}
	
	/**
	 * 改变商圈下拉框的方法
	 * */
	public void initCBD_model(String province,String city){
		
		String cbds ="商圈"+"/"+ controller.getCBDs(province,city);
	    cbd_model = new DefaultComboBoxModel<String>(cbds.split("/"));
	    comboBox_CBD.setModel(cbd_model);
	}
	
	/**
	 * 判断输入的日期是否符合格式
	 * @param date 日期
	 * @return 符合格式返回true，否则为false
	 * */
	public boolean checkDate (String date){
		
		String reg_yyyy_MM_dd = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))" +
                "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		if(date.matches(reg_yyyy_MM_dd)){
			return true;
		}
		return false;
	}
	
	/**
	 * 搜索按钮对应的事件监听内部类
	 * */
	private class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.searchButtonClicked();
		}
		
	}

	/**
	 * 实际上搜索按钮的监听
	 * */
	public void searchButtonClicked() {
	   
		int index_pro = comboBox_province.getSelectedIndex();
		int index_city = comboBox_city.getSelectedIndex();
		int index_cbd = comboBox_CBD.getSelectedIndex();
		if(index_pro==0){
			//没有选择省份
			JOptionPane.showMessageDialog(null, "请选择预订酒店的省份!","不好意思",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		if(index_city==0){
			//没有选择城市
			JOptionPane.showMessageDialog(null, "请选择预订酒店的城市!","不好意思",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		if(index_cbd==0){
			//没有选择商圈
			JOptionPane.showMessageDialog(null, "请选择预订酒店的商圈!","不好意思",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
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
		
		String hotelProvince = comboBox_province.getItemAt(index_pro);
		String hotelCity = comboBox_city.getItemAt(index_city);
		String hotelCBD = comboBox_CBD.getItemAt(index_cbd);
		
		SearchVO searchvo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
	    
	    bookUI ui = new bookUI(hotelProvince,hotelCity,hotelCBD,controller.getClientID(),searchvo);
	    ui.setVisible(true);
	    this.dispose();
	}
}


