package presentation.clientUI_book;

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
import vo.OrderVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OrderDetailUI extends JFrame
{
	
	private OrderVO orderVO;
	private HistoryOrderUI ui;
	
	private JPanel contentPane;
	private JTextField OrderID;
	private JTextField txtComment;
	private JTextField txtOrderDate;
	private JTextField createdDate;
	private JTextField txtOrderID;
	private JTextArea Comment;

	private JTextField textField;
	private JTextField orderStatus;
	private JTextField textField_2;
	private JTextField price;
	private JTextField textField_4;
	private JTextField beginDate;
	private JTextField textField_6;
	private JTextField endDate;
	private JTextField textField_8;
	private JTextField lastDate;
	private JTextField textField_10;
	private JTextField roomTotal;
	private JTextField textField_12;
	private JTextField roomType;
	private JTextField textField_14;
	private JTextField roomNumber;
	private JTextField textField_16;
	private JTextField roomPeople;
	private JTextField textField_18;
	private JTextField hasChild;
	private JTextField textField_20;
	private JTextField hotelCBD;
	private JTextField textField_22;
	private JTextField hotelAddress;
	private JTextField textField_24;
	private JTextField hotelName;
	private JTextField textField_26;
	private JTextField clientName;
	private JTextField textField_28;
	private JTextField clientID;
	private JTextField textField_30;
	private JTextField clientPhone;
	
	/**
	 * Create the frame.
	 */
	public OrderDetailUI(OrderVO vo)
	{
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		this.orderVO = vo;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Image head = new ImageIcon("client.jpg").getImage();
		
		Image background3 = new ImageIcon("background6.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		//×îÐ¡»¯Óë¹Ø±Õ°´Å¥
		JLabel closeLabel = new JLabel("¡Á");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("ËÎÌå", Font.BOLD, 25));
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
		minLabel.setFont(new Font("ËÎÌå", Font.BOLD, 25));
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
		
		//¿É×ÔÓÉÍÏ×§µÄlabel
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		JLabel accountLabel = new JLabel("¶©µ¥ÐÅÏ¢");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(115, 73, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtComment = new JTextField();
		txtComment.setForeground(Color.WHITE);
		txtComment.setBackground(SystemColor.activeCaption);
		txtComment.setText("Èë×¡ÆÀ¼Û");
		txtComment.setColumns(10);
		txtComment.setBounds(98, 610, 139, 147);
		txtComment.setMargin(new Insets(0, 20, 0, 0));
		txtComment.setEditable(false);
		txtComment.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtComment);
		
		OrderID = new JTextField(vo.getOrderID());
		OrderID.setForeground(new Color(0, 0, 0));
		OrderID.setHorizontalAlignment(SwingConstants.LEFT);
		OrderID.setOpaque(false);
		
		OrderID.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		OrderID.setBackground(Color.WHITE);
		OrderID.setEditable(false);
		OrderID.setBounds(237, 152, 361, 50);
		OrderID.setMargin(new Insets(0, 10, 0, 0));
		backgroundPanel.add(OrderID);
		OrderID.setColumns(10);
		
		JButton returnButton = new JButton(new ImageIcon("returnButton.jpg"));
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ui.setVisible(true);
				OrderDetailUI.this.dispose();
			}
		});
		returnButton.setBounds(974, 73, 165, 50);
		backgroundPanel.add(returnButton);
		
		txtOrderDate = new JTextField();
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setText("\u751F\u6210\u65E5\u671F\uFF1A");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(98, 202, 139, 50);
		backgroundPanel.add(txtOrderDate);
		
		createdDate = new JTextField(vo.getOrderCreatedDate());
		createdDate.setHorizontalAlignment(SwingConstants.LEFT);
		createdDate.setOpaque(false);
		createdDate.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		createdDate.setBackground(Color.WHITE);
		createdDate.setEditable(false);
		createdDate.setMargin(new Insets(0, 10, 0, 0));
		createdDate.setColumns(10);
		createdDate.setBounds(236, 202, 362, 50);
		createdDate.setForeground(new Color(0, 0, 0));
		backgroundPanel.add(createdDate);
		
		
		txtOrderID = new JTextField();
		txtOrderID.setText("\u8BA2\u5355\u7F16\u53F7\uFF1A");
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtOrderID.setEditable(false);
		txtOrderID.setColumns(10);
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setBounds(98, 152, 139, 50);
		backgroundPanel.add(txtOrderID);
		
		
		String text = "";
		String comment = vo.getComment();
		if("".equals(comment)){
			text = "ÔÝÊ±»¹Ã»ÓÐÆÀÂÛ£¡";
		}else{
			String com[] = comment.split("[|]");
			if(com.length==2){
				text = com[0]+"\n"+com[1];
			}else{
				text = com[0];
			}
		}
		Comment = new JTextArea(text);
		Comment.setBackground(Color.WHITE);
		Comment.setEditable(false);
		Comment.setMargin(new Insets(30, 20, 30, 20));
		Comment.setOpaque(false);
		Comment.setLineWrap(true);
		Comment.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 24));
		Comment.setBounds(237, 610, 902, 147);
		
		backgroundPanel.add(Comment);
		
		textField = new JTextField();
		textField.setText("\u8BA2\u5355\u72B6\u6001\uFF1A");
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(639, 152, 139, 50);
		backgroundPanel.add(textField);
		
		orderStatus = new JTextField(vo.getOrderStatus());
		orderStatus.setMargin(new Insets(0, 10, 0, 0));
		orderStatus.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		orderStatus.setEditable(false);
		orderStatus.setColumns(10);
		orderStatus.setBackground(Color.WHITE);
		orderStatus.setBounds(778, 152, 361, 50);
		orderStatus.setOpaque(false);
		backgroundPanel.add(orderStatus);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8BA2\u5355\u4EF7\u683C\uFF1A");
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(639, 202, 139, 50);
		backgroundPanel.add(textField_2);
		
		price = new JTextField(String.valueOf(vo.getPrice()));
		price.setMargin(new Insets(0, 10, 0, 0));
		price.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		price.setEditable(false);
		price.setColumns(10);
		price.setBackground(Color.WHITE);
		price.setBounds(778, 202, 361, 50);
		price.setOpaque(false);
		backgroundPanel.add(price);
		
		textField_4 = new JTextField();
		textField_4.setText("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		textField_4.setMargin(new Insets(0, 20, 0, 0));
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.activeCaption);
		textField_4.setBounds(98, 252, 139, 50);
		backgroundPanel.add(textField_4);
		
		beginDate = new JTextField(vo.getOrderBeginDate());
		beginDate.setMargin(new Insets(0, 10, 0, 0));
		beginDate.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		beginDate.setEditable(false);
		beginDate.setColumns(10);
		beginDate.setBackground(Color.WHITE);
		beginDate.setBounds(237, 252, 361, 50);
		beginDate.setOpaque(false);
		backgroundPanel.add(beginDate);
		
		textField_6 = new JTextField();
		textField_6.setText("\u9000\u623F\u65F6\u95F4\uFF1A");
		textField_6.setMargin(new Insets(0, 20, 0, 0));
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.activeCaption);
		textField_6.setBounds(98, 302, 139, 50);
		backgroundPanel.add(textField_6);
		
		endDate = new JTextField(vo.getOrderEndDate());
		endDate.setMargin(new Insets(0, 10, 0, 0));
		endDate.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		endDate.setEditable(false);
		endDate.setColumns(10);
		endDate.setBackground(Color.WHITE);
		endDate.setBounds(237, 302, 361, 50);
		endDate.setOpaque(false);
		backgroundPanel.add(endDate);
		
		textField_8 = new JTextField();
		textField_8.setText("\u6700\u665A\u6267\u884C\u65F6\u95F4\uFF1A");
		textField_8.setMargin(new Insets(0, 20, 0, 0));
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBackground(SystemColor.activeCaption);
		textField_8.setBounds(98, 352, 139, 50);
		backgroundPanel.add(textField_8);
		
		lastDate = new JTextField(vo.getOrderLastDate());
		lastDate.setMargin(new Insets(0, 10, 0, 0));
		lastDate.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		lastDate.setEditable(false);
		lastDate.setColumns(10);
		lastDate.setBackground(Color.WHITE);
		lastDate.setBounds(237, 352, 361, 50);
		lastDate.setOpaque(false);
		backgroundPanel.add(lastDate);
		
		textField_10 = new JTextField();
		textField_10.setText("\u623F\u95F4\u6570\u76EE\uFF1A");
		textField_10.setMargin(new Insets(0, 20, 0, 0));
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBackground(SystemColor.activeCaption);
		textField_10.setBounds(639, 252, 139, 50);
		backgroundPanel.add(textField_10);
		
		roomTotal = new JTextField(String.valueOf(vo.getRoomTotal()));
		roomTotal.setMargin(new Insets(0, 10, 0, 0));
		roomTotal.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		roomTotal.setEditable(false);
		roomTotal.setColumns(10);
		roomTotal.setBackground(Color.WHITE);
		roomTotal.setBounds(778, 252, 361, 50);
		roomTotal.setOpaque(false);
		backgroundPanel.add(roomTotal);
		
		textField_12 = new JTextField();
		textField_12.setText("\u623F\u95F4\u7C7B\u578B\uFF1A");
		textField_12.setMargin(new Insets(0, 20, 0, 0));
		textField_12.setForeground(Color.WHITE);
		textField_12.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBackground(SystemColor.activeCaption);
		textField_12.setBounds(639, 302, 139, 50);
		backgroundPanel.add(textField_12);
		
		roomType = new JTextField(vo.getRoomType());
		roomType.setMargin(new Insets(0, 10, 0, 0));
		roomType.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		roomType.setEditable(false);
		roomType.setColumns(10);
		roomType.setBackground(Color.WHITE);
		roomType.setBounds(778, 302, 361, 50);
		roomType.setOpaque(false);
		backgroundPanel.add(roomType);
		
		textField_14 = new JTextField();
		textField_14.setText("\u623F\u95F4\u53F7\u7801\uFF1A");
		textField_14.setMargin(new Insets(0, 20, 0, 0));
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBackground(SystemColor.activeCaption);
		textField_14.setBounds(639, 351, 139, 50);
		backgroundPanel.add(textField_14);
		
		roomNumber = new JTextField(vo.getRoomNumber());
		roomNumber.setMargin(new Insets(0, 10, 0, 0));
		roomNumber.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		roomNumber.setEditable(false);
		roomNumber.setColumns(10);
		roomNumber.setBackground(Color.WHITE);
		roomNumber.setBounds(778, 352, 361, 50);
		roomNumber.setOpaque(false);
		backgroundPanel.add(roomNumber);
		
		textField_16 = new JTextField();
		textField_16.setText("\u5165\u4F4F\u4EBA\u6570\uFF1A");
		textField_16.setMargin(new Insets(0, 20, 0, 0));
		textField_16.setForeground(Color.WHITE);
		textField_16.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBackground(SystemColor.activeCaption);
		textField_16.setBounds(639, 401, 139, 50);
		backgroundPanel.add(textField_16);
		
		roomPeople = new JTextField(vo.getPeopleNumber());
		roomPeople.setMargin(new Insets(0, 10, 0, 0));
		roomPeople.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		roomPeople.setEditable(false);
		roomPeople.setColumns(10);
		roomPeople.setBackground(Color.WHITE);
		roomPeople.setBounds(778, 402, 361, 50);
		roomPeople.setOpaque(false);
		backgroundPanel.add(roomPeople);
		
		textField_18 = new JTextField();
		textField_18.setText("\u6709\u65E0\u513F\u7AE5\uFF1A");
		textField_18.setMargin(new Insets(0, 20, 0, 0));
		textField_18.setForeground(Color.WHITE);
		textField_18.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBackground(SystemColor.activeCaption);
		textField_18.setBounds(639, 451, 139, 50);
		backgroundPanel.add(textField_18);
		
		String strHasChild = vo.getHasChild();
		strHasChild = strHasChild.replaceAll("false", "ÎÞ");
		strHasChild = strHasChild.replaceAll("true", "ÓÐ");
		
		hasChild = new JTextField(strHasChild);
		hasChild.setMargin(new Insets(0, 10, 0, 0));
		hasChild.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hasChild.setEditable(false);
		hasChild.setColumns(10);
		hasChild.setBackground(Color.WHITE);
		hasChild.setBounds(778, 452, 361, 50);
		hasChild.setOpaque(false);
		backgroundPanel.add(hasChild);
		
		textField_20 = new JTextField();
		textField_20.setText("\u9152\u5E97\u5546\u5708\uFF1A");
		textField_20.setMargin(new Insets(0, 20, 0, 0));
		textField_20.setForeground(Color.WHITE);
		textField_20.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBackground(SystemColor.activeCaption);
		textField_20.setBounds(98, 402, 139, 50);
		backgroundPanel.add(textField_20);
		
		hotelCBD = new JTextField(vo.getHotelProvince()+vo.getHotelCity()+vo.getHotelCBD());
		hotelCBD.setMargin(new Insets(0, 10, 0, 0));
		hotelCBD.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelCBD.setEditable(false);
		hotelCBD.setColumns(10);
		hotelCBD.setBackground(Color.WHITE);
		hotelCBD.setBounds(237, 402, 361, 50);
		hotelCBD.setOpaque(false);
		
		backgroundPanel.add(hotelCBD);
		
		textField_22 = new JTextField();
		textField_22.setText("\u9152\u5E97\u5730\u5740\uFF1A");
		textField_22.setMargin(new Insets(0, 20, 0, 0));
		textField_22.setForeground(Color.WHITE);
		textField_22.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBackground(SystemColor.activeCaption);
		textField_22.setBounds(98, 451, 139, 50);
		backgroundPanel.add(textField_22);
		
		hotelAddress = new JTextField(vo.getHotelAddress());
		hotelAddress.setMargin(new Insets(0, 10, 0, 0));
		hotelAddress.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelAddress.setEditable(false);
		hotelAddress.setColumns(10);
		hotelAddress.setBackground(Color.WHITE);
		hotelAddress.setBounds(237, 452, 361, 50);
		hotelAddress.setOpaque(false);
		backgroundPanel.add(hotelAddress);
		
		textField_24 = new JTextField();
		textField_24.setText("\u9152\u5E97\u540D\u79F0\uFF1A");
		textField_24.setMargin(new Insets(0, 20, 0, 0));
		textField_24.setForeground(Color.WHITE);
		textField_24.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBackground(SystemColor.activeCaption);
		textField_24.setBounds(98, 501, 139, 50);
		backgroundPanel.add(textField_24);
		
		hotelName = new JTextField(vo.getHotelName());
		hotelName.setMargin(new Insets(0, 10, 0, 0));
		hotelName.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelName.setEditable(false);
		hotelName.setColumns(10);
		hotelName.setBackground(Color.WHITE);
		hotelName.setBounds(237, 502, 361, 50);
		hotelName.setOpaque(false);
		backgroundPanel.add(hotelName);
		
		textField_26 = new JTextField();
		textField_26.setText("\u5BA2\u6237\u59D3\u540D\uFF1A");
		textField_26.setMargin(new Insets(0, 20, 0, 0));
		textField_26.setForeground(Color.WHITE);
		textField_26.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_26.setEditable(false);
		textField_26.setColumns(10);
		textField_26.setBackground(SystemColor.activeCaption);
		textField_26.setBounds(98, 550, 139, 50);
		backgroundPanel.add(textField_26);
		
		clientName = new JTextField(vo.getClientName());
		clientName.setMargin(new Insets(0, 10, 0, 0));
		clientName.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		clientName.setEditable(false);
		clientName.setColumns(10);
		clientName.setBackground(Color.WHITE);
		clientName.setBounds(237, 552, 361, 50);
		clientName.setOpaque(false);
		backgroundPanel.add(clientName);
		
		textField_28 = new JTextField();
		textField_28.setText("\u5BA2\u6237\u7F16\u53F7\uFF1A");
		textField_28.setMargin(new Insets(0, 20, 0, 0));
		textField_28.setForeground(Color.WHITE);
		textField_28.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBackground(SystemColor.activeCaption);
		textField_28.setBounds(639, 501, 139, 50);
		backgroundPanel.add(textField_28);
		
		clientID = new JTextField(vo.getClientID());
		clientID.setMargin(new Insets(0, 10, 0, 0));
		clientID.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		clientID.setEditable(false);
		clientID.setColumns(10);
		clientID.setBackground(Color.WHITE);
		clientID.setBounds(778, 502, 361, 50);
		clientID.setOpaque(false);
		backgroundPanel.add(clientID);
		
		textField_30 = new JTextField();
		textField_30.setText("\u5BA2\u6237\u7535\u8BDD\uFF1A");
		textField_30.setMargin(new Insets(0, 20, 0, 0));
		textField_30.setForeground(Color.WHITE);
		textField_30.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_30.setEditable(false);
		textField_30.setColumns(10);
		textField_30.setBackground(SystemColor.activeCaption);
		textField_30.setBounds(639, 550, 139, 50);
		backgroundPanel.add(textField_30);
		
		clientPhone = new JTextField(vo.getPeopleNumber());
		clientPhone.setMargin(new Insets(0, 10, 0, 0));
		clientPhone.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		clientPhone.setEditable(false);
		clientPhone.setColumns(10);
		clientPhone.setBackground(Color.WHITE);
		clientPhone.setBounds(778, 552, 361, 50);
		clientPhone.setOpaque(false);
		backgroundPanel.add(clientPhone);
		
	}
	
	public void setLastView(HistoryOrderUI ui){
		
		this.ui = ui;
	}
}


