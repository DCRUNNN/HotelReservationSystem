package presentation.clientUI_book;


/*
 * 
 * 客户进行订单预订——查看酒店详细信息界面原型
 */

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.BackgroundPanel;
import vo.HotelVO;
import vo.SearchVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class hotelDetailUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtCBD;
	private JTextField txtStar;
	private JTextField txtFacility;
	private JTextField txtScore;
	private JTextField txtAddress;
	private JTextArea txtHotelName;
	private JButton historyButton;
	private JButton searchbutton;
	private JTextArea hotelName;

	private bookUI lastUI;
	
	private String [] comments;
	private int index =0 ;
	private JTextArea txtComment;
	
	private String defaultHotelName = "( 选填 ) 酒店名称";
	private String defaultRoomType = "( 选填 ) 房间类型";
	private String defaultRoomAmount = "( 选填 ) 房间数目";
	private JTextArea txtRoomType;
	private JTextArea txtRoomAmount;
	private JComboBox comboBox_hotelGrade;
	
	private HotelVO vo;
	/**
	 * Create the frame.
	 * @param clientID 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public hotelDetailUI(HotelVO vo, String clientID)
	{
		this.vo = vo;
		comments = vo.getCommentList().split("%");
		//设置JFrame
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		//设置JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//设置背景
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("\u641C\u7D22\u6761\u4EF6");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(71, 90, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		//显示的字样“目的地”
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(71, 170, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		//显示的字样“入住日期”
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(71, 270, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		//显示的字样“关键词”
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(71, 470, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		//这个是显示市和商圈的 JLabel 需要进行设置
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		destination.setColumns(10);
		destination.setBounds(71, 210, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		destination.setText(vo.getHotelCity()+"/"+vo.getHotelCBD());//设置显示为“市+商圈”
		backgroundPanel.add(destination);
		
		//输入的入住日期
		checkInDate = new JTextField();
		checkInDate.setEditable(true);
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText("2016-12-02");
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(71, 310, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		checkInDate.addMouseListener(new MouseAdapter(){
			public void mouseExited(MouseEvent e){
				
				String date = checkInDate.getText();
				if(!checkDate(date)){
					JOptionPane.showMessageDialog(null, "输入日期格式不正确","错误",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		backgroundPanel.add(checkInDate);
		
		//显示的字样“酒店级别”
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(71, 370, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		//搜索按钮
		searchbutton = new JButton(new ImageIcon("search.jpg"));
		searchbutton.setBounds(71, 710, 170, 60);
		searchbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
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
			    hotelDetailUI.this.dispose();
			}
			
		});
		backgroundPanel.add(searchbutton);
		
		//酒店星级的下拉框
		comboBox_hotelGrade = new JComboBox();
		comboBox_hotelGrade.setBackground(new Color(245, 255, 250));
		comboBox_hotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));

		String grades[] = {
				"    不限","五星级/豪华","四星级/高档","三星级/舒适","两星级及以下/经济"
		};
		comboBox_hotelGrade.setModel(new DefaultComboBoxModel(grades));
		comboBox_hotelGrade.setBounds(71, 410, 170, 50);
		backgroundPanel.add(comboBox_hotelGrade);
		
		//显示的酒店图片
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		
		BackgroundPanel hotelPicturePanel = new BackgroundPanel(hotel);
		hotelPicturePanel.setBounds(435, 77, 350, 150);
		backgroundPanel.add(hotelPicturePanel);
		hotelPicturePanel.setLayout(null);
		
		//这个是需要设置的酒店名称
		hotelName = new JTextArea();
		hotelName.setBounds(0, 97, 330, 53);
		hotelPicturePanel.add(hotelName);
		hotelName.setEditable(false);
		hotelName.setText(vo.getHotelName());
		hotelName.setOpaque(false);
		hotelName.setMargin(new Insets(10, 10, 10, 10));
		hotelName.setForeground(new Color(255, 255, 255));
		hotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		hotelName.setColumns(10);
		hotelName.setBackground(new Color(176, 224, 230));
		
		//预订房间的按钮
		JButton roomBookButton = new JButton(new ImageIcon("orderBook.jpg"));
		roomBookButton.setBounds(690, 710, 170, 60);
		roomBookButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			    
			    bookButtonClicked();
			}
			
		});
		backgroundPanel.add(roomBookButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(0, 0, 139));
		textField.setBackground(SystemColor.activeCaption);
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setMargin(new Insets(2, 20, 2, 2));
		textField.setText("\u8BE6\u7EC6\u5730\u5740");
		textField.setBounds(435, 227, 120, 50);
		backgroundPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("\u9152\u5E97\u5546\u5708");
		textField_1.setMargin(new Insets(2, 20, 2, 2));
		textField_1.setForeground(new Color(0, 0, 139));
		textField_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(785, 177, 120, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("\u9152\u5E97\u661F\u7EA7");
		textField_2.setMargin(new Insets(2, 20, 2, 2));
		textField_2.setForeground(new Color(0, 0, 139));
		textField_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(785, 127, 120, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("\u9152\u5E97\u8BBE\u65BD");
		textField_3.setMargin(new Insets(2, 20, 2, 2));
		textField_3.setForeground(new Color(0, 0, 139));
		textField_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.activeCaption);
		textField_3.setBounds(435, 277, 120, 50);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("\u9152\u5E97\u7B80\u4ECB");
		textField_4.setMargin(new Insets(2, 20, 2, 2));
		textField_4.setForeground(new Color(0, 0, 139));
		textField_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.activeCaption);
		textField_4.setBounds(435, 327, 120, 150);
		backgroundPanel.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("\u7EFC\u5408\u8BC4\u5206");
		textField_6.setMargin(new Insets(2, 20, 2, 2));
		textField_6.setForeground(new Color(0, 0, 139));
		textField_6.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.activeCaption);
		textField_6.setBounds(785, 77, 120, 50);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("\u7EFC\u5408\u8BC4\u4EF7");
		textField_7.setMargin(new Insets(2, 20, 2, 2));
		textField_7.setForeground(new Color(0, 0, 139));
		textField_7.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_7.setColumns(10);
		textField_7.setBackground(SystemColor.activeCaption);
		textField_7.setBounds(435, 477, 120, 220);
		backgroundPanel.add(textField_7);
		
		//需要设置的商圈
		txtCBD = new JTextField();
		txtCBD.setBackground(new Color(245, 255, 250));
		txtCBD.setEditable(false);
		txtCBD.setMargin(new Insets(0, 20, 0, 0));
		txtCBD.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtCBD.setColumns(10);
		txtCBD.setBounds(905, 177, 195, 50);
		txtCBD.setText(vo.getHotelCBD());
		backgroundPanel.add(txtCBD);
		
		txtStar = new JTextField();
		txtStar.setBackground(new Color(245, 255, 250));
		txtStar.setEditable(false);
		txtStar.setMargin(new Insets(0, 20, 0, 0));
		txtStar.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtStar.setColumns(10);
		txtStar.setBounds(905, 127, 195, 50);
		txtStar.setText(vo.getHotelStar()+"星级");
		backgroundPanel.add(txtStar);
		
		txtFacility = new JTextField();
		txtFacility.setBackground(new Color(245, 255, 250));
		txtFacility.setEditable(false);
		txtFacility.setMargin(new Insets(0, 20, 0, 0));
		txtFacility.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtFacility.setColumns(10);
		txtFacility.setBounds(555, 277, 545, 50);
		txtFacility.setText(vo.getFacilities());
		backgroundPanel.add(txtFacility);
		
		txtScore = new JTextField();
		txtScore.setBackground(new Color(245, 255, 250));
		txtScore.setEditable(false);
		txtScore.setMargin(new Insets(0, 20, 0, 0));
		txtScore.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtScore.setColumns(10);
		txtScore.setBounds(905, 77, 195, 50);
		double d = (vo.getPoint_facilities()+vo.getPoint_service()+vo.getPoint_surroundings())/3;
		txtScore.setText(formatPoint(d));
		backgroundPanel.add(txtScore);
		
		txtAddress = new JTextField();
		txtAddress.setBackground(new Color(245, 255, 250));
		txtAddress.setEditable(false);
		txtAddress.setMargin(new Insets(0, 20, 0, 0));
		txtAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtAddress.setColumns(10);
		txtAddress.setBounds(555, 227, 545, 50);
		txtAddress.setText(vo.getHotelAddress());
		backgroundPanel.add(txtAddress);
		
		//其他酒店的按钮
		JButton otherButton = new JButton(new ImageIcon("search2.jpg"));
		otherButton.setBounds(400, 710, 170, 60);
		otherButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				lastUI.setVisible(true);
				hotelDetailUI.this.dispose();
			}
			
		});
		backgroundPanel.add(otherButton);
		
		//酒店的简介
		JTextArea txtIntroduction = new JTextArea();
		txtIntroduction.setBackground(new Color(245, 255, 250));
		txtIntroduction.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtIntroduction.setLineWrap(true);
		txtIntroduction.setEditable(false);
		txtIntroduction.setMargin(new Insets(20, 30, 20, 30));
		txtIntroduction.setBounds(555, 327, 545, 150);
		txtIntroduction.setText(vo.getIntroduction());
		backgroundPanel.add(txtIntroduction);
		
		Image background5 = new ImageIcon("background7.jpg").getImage();
		JPanel panel = new BackgroundPanel(background5);
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(555, 477, 545, 220);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		
		//显示的是客户的评论
		txtComment = new JTextArea();
		txtComment.setEditable(false);
		txtComment.setOpaque(false);
		String comment = getAComment();
		if(comment==null){
			txtComment.setText("暂时没有用户评论！");
		}else{
			txtComment.setText(comment);
		}
		
		txtComment.setLineWrap(true);
		txtComment.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtComment.setBackground(Color.WHITE);
		txtComment.setMargin(new Insets(20, 30, 20, 30));
		txtComment.setBounds(63, 30, 420, 160);
		panel.add(txtComment);
		
		//上一个评论的按钮
		
		JButton lastButton = new JButton(new ImageIcon("last.jpg"));
		lastButton.setBounds(14, 92, 40, 40);
		lastButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String comment = getLastComment();
				if(comment==null){
					JOptionPane.showMessageDialog(null, "上一页没有更多评论了！");
					return;
				}else{
					txtComment.setText(comment);
				}
			}
			
		});
		panel.add(lastButton);
		
		//下一个评论的按钮
		JButton nextButton = new JButton(new ImageIcon("next.jpg"));
		nextButton.setBounds(491, 92, 40, 40);
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String comment = getAComment();
				if(comment==null){
					JOptionPane.showMessageDialog(null, "下一页没有更多评论了！");
					return;
				}else{
					txtComment.setText(comment);
				}
			}
			
		});
		panel.add(nextButton);
		
		//查看历史订单的按钮
		historyButton = new JButton(new ImageIcon("history.jpg"));
		historyButton.setBounds(977, 710, 170, 60);
		backgroundPanel.add(historyButton);
		
		Color defaultcolor = new Color(192,192,192);
		
		//待输入的酒店名称
		txtHotelName = new JTextArea();
		txtHotelName.setForeground(new Color(192, 192, 192));
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		txtHotelName.setLineWrap(true);
		txtHotelName.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName.setText(defaultHotelName);
		txtHotelName.setBounds(71, 510, 170, 50);
		txtHotelName.setBackground(new Color(245, 255, 250));
		//加上点击监听
		txtHotelName.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			    String roomType = txtRoomType.getText();
			    if("".equals(roomType)||roomType==null){
			    	//没有输入有效的房间类型
			    	txtRoomType.setText(defaultRoomType);
			    	txtRoomType.setForeground(Color.GRAY);
			    }
			    if("".equals(txtRoomAmount.getText())||txtRoomAmount.getText()==null){
					//没有输入有效的房间数目
					txtRoomAmount.setText(defaultRoomAmount);
					txtRoomAmount.setForeground(defaultcolor);
				}
				txtHotelName.setText("");	
				txtHotelName.setForeground(defaultcolor);
			}		
		});		
		backgroundPanel.add(txtHotelName);
		
		//待输入的房间类型
		txtRoomType = new JTextArea();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(10, 10, 10, 10));
		txtRoomType.setLineWrap(true);
		txtRoomType.setForeground(Color.LIGHT_GRAY);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		txtRoomType.setBackground(new Color(245, 255, 250));
		txtRoomType.setBounds(71, 560, 170, 50);
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
		
		//这个是待输入的搜索条件
		txtRoomAmount = new JTextArea();
		txtRoomAmount.setText(defaultRoomAmount);
		txtRoomAmount.setMargin(new Insets(10, 10, 10, 10));
		txtRoomAmount.setLineWrap(true);
		txtRoomAmount.setForeground(Color.LIGHT_GRAY);
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		txtRoomAmount.setBackground(new Color(245, 255, 250));
		txtRoomAmount.setBounds(71, 610, 170, 50);
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
		
	}
	
	protected void bookButtonClicked() {
		
		bookDetailUI ui = new bookDetailUI(vo);
		ui.setBookUI(lastUI);
		ui.setVisible(true);
		this.dispose();
	}

	public void setLastUI(bookUI ui){
		this.lastUI = ui;
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
	
	private String getAComment(){
		
		String comment = "";
		if(index!=comments.length){
			comment = comments[index++];
		}else{
			return null;
		}
		if(comment.split("[|]").length>=2){
			
			String comment0[] = comment.split("[|]")[0].split(":");
			if(comment0.length==3){
				String orderID = comment0[0];
				String clientID = comment0[1];
				String comment1 = comment0[2];
				comment = "订单编号: "+orderID+"\n"+"客户编号: "+clientID+"\n"+"评论： "+comment1+"\n追加评论: "+comment.split("[|]")[1];
			}
			
		}else{
            String comment0[] = comment.split("[|]")[0].split(":");
			if(comment0.length==3){
				String orderID = comment0[0];
				String clientID = comment0[1];
				String comment1 = comment0[2];
				comment = "订单编号: "+orderID+"\n"+"客户编号: "+clientID+"\n"+"评论： "+comment1;
			}
		}
		return comment;
	}
	
	private String getLastComment(){
		
		String comment = "";
		if(index!=1){
			comment = comments[index-2];
			index--;
		}else{
			return null;
		}

		if(comment.split("[|]").length>=2){
			
			String comment0[] = comment.split("[|]")[0].split(":");
			if(comment0.length==3){
				String orderID = comment0[0];
				String clientID = comment0[1];
				String comment1 = comment0[2];
				comment = "订单编号: "+orderID+"\n"+"客户编号: "+clientID+"\n"+"评论： "+comment1+"\n追加评论: "+comment.split("[|]")[1];
			}
			
		}else{
            String comment0[] = comment.split("[|]")[0].split(":");
			if(comment0.length==3){
				String orderID = comment0[0];
				String clientID = comment0[1];
				String comment1 = comment0[2];
				comment = "订单编号: "+orderID+"\n"+"客户编号: "+clientID+"\n"+"评论： "+comment1;
			}
		}
		return comment;
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
}


