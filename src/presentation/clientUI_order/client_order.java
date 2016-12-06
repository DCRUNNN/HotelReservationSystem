package presentation.clientUI_order;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class client_order extends JFrame
{

	private JPanel contentPane;
	private JTextField OrderID;
	private JTextField BeginTime;
	private JTextField txtRoomType;
	private JTextField txtAmount;
	private JTextField txtOrderStatement;
	private JTextField txtHotelName;
	private JTextField txtComment;
	private JTextField RoomType;
	private JTextField Amount;
	private JTextField OrderStatement;
	private JTextField HotelName;
	private JTextField txtOrderDate;
	private JTextField OrderDate;
	private JTextField txtOrderPrice;
	private JTextField OrderPrice;
	private JTextField txtExecuteTime;
	private JTextField ExecuteTime;
	private JTextField txtCheckOutTime;
	private JTextField CheckOutTime;
	private JTextField txtRoomAmount;
	private JTextField RoomAmount;
	private JTextField txtRoomID;
	private JTextField RoomID;
	private JTextField txtChildAmount;
	private JTextField txtAdultAmount;
	private JTextField ChildAmount;
	private JTextField AdultAmount;
	private JTextField txtHotelAddress;
	private JTextField txtHotelCBD;
	private JTextField HotelAddress;
	private JTextField HotelCBD;
	private JTextField txtHotelLevel;
	private JTextField HotelLevel;
	private JTextField txtHotelScore;
	private JTextField HotelScore;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel label;
	private JTextField txtOrderID;
	private JTextField txtBeginTime;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					client_order frame = new client_order();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public client_order()
	{
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background = new ImageIcon("background.jpg").getImage();
		Image head = new ImageIcon("client.jpg").getImage();
		
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		contentPane.add(headPanel);
		
		Image background2 = new ImageIcon("background2.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("订单信息");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtRoomType = new JTextField();
		txtRoomType.setForeground(Color.WHITE);
		txtRoomType.setBackground(SystemColor.activeCaption);
		txtRoomType.setText("房间类型");
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(400, 252, 120, 50);
		txtRoomType.setMargin(new Insets(0, 20, 0, 0));
		txtRoomType.setEditable(false);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRoomType);
		
		txtAmount = new JTextField();
		txtAmount.setForeground(Color.WHITE);
		txtAmount.setBackground(SystemColor.activeCaption);
		txtAmount.setText("入住人数");
		txtAmount.setColumns(10);
		txtAmount.setBounds(400, 302, 120, 50);
		txtAmount.setMargin(new Insets(0, 20, 0, 0));
		txtAmount.setEditable(false);
		txtAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtAmount);
		
		txtOrderStatement = new JTextField();
		txtOrderStatement.setForeground(Color.WHITE);
		txtOrderStatement.setBackground(SystemColor.activeCaption);
		txtOrderStatement.setText("订单状态");
		txtOrderStatement.setColumns(10);
		txtOrderStatement.setBounds(400, 352, 120, 50);
		txtOrderStatement.setMargin(new Insets(0, 20, 0, 0));
		txtOrderStatement.setEditable(false);
		txtOrderStatement.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderStatement);
		
		txtHotelName = new JTextField();
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setText("酒店名称");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(400, 402, 120, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		txtComment = new JTextField();
		txtComment.setForeground(Color.WHITE);
		txtComment.setBackground(SystemColor.activeCaption);
		txtComment.setText("入住评价");
		txtComment.setColumns(10);
		txtComment.setBounds(400, 452, 120, 190);
		txtComment.setMargin(new Insets(0, 20, 0, 0));
		txtComment.setEditable(false);
		txtComment.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtComment);
		
		OrderID = new JTextField();
		OrderID.setBounds(520, 152, 130, 50);
		OrderID.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderID);
		OrderID.setColumns(10);
		
		BeginTime = new JTextField();
		BeginTime.setColumns(10);
		BeginTime.setBounds(520, 202, 130, 50);
		BeginTime.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(BeginTime);
		
		RoomType = new JTextField();
		RoomType.setColumns(10);
		RoomType.setBounds(520, 252, 130, 50);
		RoomType.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(RoomType);
		
		Amount = new JTextField();
		Amount.setColumns(10);
		Amount.setBounds(520, 302, 130, 50);
		Amount.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(Amount);
		
		OrderStatement = new JTextField();
		OrderStatement.setColumns(10);
		OrderStatement.setBounds(520, 352, 130, 50);
		OrderStatement.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderStatement);
		
		HotelName = new JTextField();
		HotelName.setColumns(10);
		HotelName.setBounds(520, 402, 130, 50);
		HotelName.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(HotelName);
		
		JButton modifyButton = new JButton(new ImageIcon("returnButton.jpg"));
		modifyButton.setBounds(400, 702, 165, 50);
		backgroundPanel.add(modifyButton);
		
		txtOrderDate = new JTextField();
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setText("订单日期");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(650, 152, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		OrderDate = new JTextField();
		OrderDate.setMargin(new Insets(0, 20, 0, 0));
		OrderDate.setColumns(10);
		OrderDate.setBounds(770, 152, 130, 50);
		backgroundPanel.add(OrderDate);
		
		txtOrderPrice = new JTextField();
		txtOrderPrice.setForeground(Color.WHITE);
		txtOrderPrice.setBackground(SystemColor.activeCaption);
		txtOrderPrice.setText("订单价格");
		txtOrderPrice.setMargin(new Insets(0, 20, 0, 0));
		txtOrderPrice.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderPrice.setEditable(false);
		txtOrderPrice.setColumns(10);
		txtOrderPrice.setBounds(900, 152, 120, 50);
		backgroundPanel.add(txtOrderPrice);
		
		OrderPrice = new JTextField();
		OrderPrice.setMargin(new Insets(0, 20, 0, 0));
		OrderPrice.setColumns(10);
		OrderPrice.setBounds(1020, 152, 130, 50);
		backgroundPanel.add(OrderPrice);
		
		txtExecuteTime = new JTextField();
		txtExecuteTime.setForeground(Color.WHITE);
		txtExecuteTime.setBackground(SystemColor.activeCaption);
		txtExecuteTime.setText("最晚执行时间");
		txtExecuteTime.setMargin(new Insets(0, 10, 0, 0));
		txtExecuteTime.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		txtExecuteTime.setEditable(false);
		txtExecuteTime.setColumns(10);
		txtExecuteTime.setBounds(650, 202, 120, 50);
		backgroundPanel.add(txtExecuteTime);
		
		ExecuteTime = new JTextField();
		ExecuteTime.setMargin(new Insets(0, 20, 0, 0));
		ExecuteTime.setColumns(10);
		ExecuteTime.setBounds(770, 202, 130, 50);
		backgroundPanel.add(ExecuteTime);
		
		txtCheckOutTime = new JTextField();
		txtCheckOutTime.setForeground(Color.WHITE);
		txtCheckOutTime.setBackground(SystemColor.activeCaption);
		txtCheckOutTime.setText("退房时间");
		txtCheckOutTime.setMargin(new Insets(0, 20, 0, 0));
		txtCheckOutTime.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtCheckOutTime.setEditable(false);
		txtCheckOutTime.setColumns(10);
		txtCheckOutTime.setBounds(900, 202, 120, 50);
		backgroundPanel.add(txtCheckOutTime);
		
		CheckOutTime = new JTextField();
		CheckOutTime.setMargin(new Insets(0, 20, 0, 0));
		CheckOutTime.setColumns(10);
		CheckOutTime.setBounds(1020, 202, 130, 50);
		backgroundPanel.add(CheckOutTime);
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setForeground(Color.WHITE);
		txtRoomAmount.setBackground(SystemColor.activeCaption);
		txtRoomAmount.setText("房间数目");
		txtRoomAmount.setMargin(new Insets(0, 20, 0, 0));
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomAmount.setEditable(false);
		txtRoomAmount.setColumns(10);
		txtRoomAmount.setBounds(650, 252, 120, 50);
		backgroundPanel.add(txtRoomAmount);
		
		RoomAmount = new JTextField();
		RoomAmount.setMargin(new Insets(0, 20, 0, 0));
		RoomAmount.setColumns(10);
		RoomAmount.setBounds(770, 252, 130, 50);
		backgroundPanel.add(RoomAmount);
		
		txtRoomID = new JTextField();
		txtRoomID.setForeground(Color.WHITE);
		txtRoomID.setBackground(SystemColor.activeCaption);
		txtRoomID.setText("房间号码");
		txtRoomID.setMargin(new Insets(0, 20, 0, 0));
		txtRoomID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomID.setEditable(false);
		txtRoomID.setColumns(10);
		txtRoomID.setBounds(900, 252, 120, 50);
		backgroundPanel.add(txtRoomID);
		
		RoomID = new JTextField();
		RoomID.setMargin(new Insets(0, 20, 0, 0));
		RoomID.setColumns(10);
		RoomID.setBounds(1020, 252, 130, 50);
		backgroundPanel.add(RoomID);
		
		txtChildAmount = new JTextField();
		txtChildAmount.setForeground(Color.WHITE);
		txtChildAmount.setBackground(SystemColor.activeCaption);
		txtChildAmount.setText("儿童个数");
		txtChildAmount.setMargin(new Insets(0, 20, 0, 0));
		txtChildAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtChildAmount.setEditable(false);
		txtChildAmount.setColumns(10);
		txtChildAmount.setBounds(650, 302, 120, 50);
		backgroundPanel.add(txtChildAmount);
		
		txtAdultAmount = new JTextField();
		txtAdultAmount.setForeground(Color.WHITE);
		txtAdultAmount.setBackground(SystemColor.activeCaption);
		txtAdultAmount.setText("成人个数");
		txtAdultAmount.setMargin(new Insets(0, 20, 0, 0));
		txtAdultAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtAdultAmount.setEditable(false);
		txtAdultAmount.setColumns(10);
		txtAdultAmount.setBounds(900, 302, 120, 50);
		backgroundPanel.add(txtAdultAmount);
		
		ChildAmount = new JTextField();
		ChildAmount.setMargin(new Insets(0, 20, 0, 0));
		ChildAmount.setColumns(10);
		ChildAmount.setBounds(770, 302, 130, 50);
		backgroundPanel.add(ChildAmount);
		
		AdultAmount = new JTextField();
		AdultAmount.setMargin(new Insets(0, 20, 0, 0));
		AdultAmount.setColumns(10);
		AdultAmount.setBounds(1020, 302, 130, 50);
		backgroundPanel.add(AdultAmount);
		
		txtHotelAddress = new JTextField();
		txtHotelAddress.setForeground(Color.WHITE);
		txtHotelAddress.setBackground(SystemColor.activeCaption);
		txtHotelAddress.setText("酒店地址");
		txtHotelAddress.setMargin(new Insets(0, 20, 0, 0));
		txtHotelAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelAddress.setEditable(false);
		txtHotelAddress.setColumns(10);
		txtHotelAddress.setBounds(650, 352, 120, 50);
		backgroundPanel.add(txtHotelAddress);
		
		txtHotelCBD = new JTextField();
		txtHotelCBD.setForeground(Color.WHITE);
		txtHotelCBD.setBackground(SystemColor.activeCaption);
		txtHotelCBD.setText("酒店商圈");
		txtHotelCBD.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCBD.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelCBD.setEditable(false);
		txtHotelCBD.setColumns(10);
		txtHotelCBD.setBounds(900, 352, 120, 50);
		backgroundPanel.add(txtHotelCBD);
		
		HotelAddress = new JTextField();
		HotelAddress.setMargin(new Insets(0, 20, 0, 0));
		HotelAddress.setColumns(10);
		HotelAddress.setBounds(770, 352, 130, 50);
		backgroundPanel.add(HotelAddress);
		
		HotelCBD = new JTextField();
		HotelCBD.setMargin(new Insets(0, 20, 0, 0));
		HotelCBD.setColumns(10);
		HotelCBD.setBounds(1020, 352, 130, 50);
		backgroundPanel.add(HotelCBD);
		
		txtHotelLevel = new JTextField();
		txtHotelLevel.setForeground(Color.WHITE);
		txtHotelLevel.setBackground(SystemColor.activeCaption);
		txtHotelLevel.setText("酒店星级");
		txtHotelLevel.setMargin(new Insets(0, 20, 0, 0));
		txtHotelLevel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelLevel.setEditable(false);
		txtHotelLevel.setColumns(10);
		txtHotelLevel.setBounds(650, 402, 120, 50);
		backgroundPanel.add(txtHotelLevel);
		
		HotelLevel = new JTextField();
		HotelLevel.setMargin(new Insets(0, 20, 0, 0));
		HotelLevel.setColumns(10);
		HotelLevel.setBounds(770, 402, 130, 50);
		backgroundPanel.add(HotelLevel);
		
		txtHotelScore = new JTextField();
		txtHotelScore.setForeground(Color.WHITE);
		txtHotelScore.setBackground(SystemColor.activeCaption);
		txtHotelScore.setText("综合评分");
		txtHotelScore.setMargin(new Insets(0, 20, 0, 0));
		txtHotelScore.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelScore.setEditable(false);
		txtHotelScore.setColumns(10);
		txtHotelScore.setBounds(900, 402, 120, 50);
		backgroundPanel.add(txtHotelScore);
		
		HotelScore = new JTextField();
		HotelScore.setMargin(new Insets(0, 20, 0, 0));
		HotelScore.setColumns(10);
		HotelScore.setBounds(1020, 402, 130, 50);
		backgroundPanel.add(HotelScore);
		
		button = new JButton(new ImageIcon("button2.jpg"));
		button.setBounds(985, 702, 165, 50);
		backgroundPanel.add(button);
		
		button_1 = new JButton(new ImageIcon("ordercomment.jpg"));
		button_1.setBounds(1020, 87, 130, 50);
		backgroundPanel.add(button_1);
		
		button_2 = new JButton(new ImageIcon("orderInfo.jpg"));
		button_2.setBounds(890, 87, 130, 50);
		backgroundPanel.add(button_2);
		
		button_3 = new JButton(new ImageIcon("myOrder.jpg"));
		button_3.setBounds(760, 87, 130, 50);
		backgroundPanel.add(button_3);
		
		label = new JLabel("\u6B22\u8FCE\u60A8\uFF0C\u5F20\u4E09");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(71, 470, 170, 60);
		backgroundPanel.add(orderButton);
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(71, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		
		txtOrderID = new JTextField();
		txtOrderID.setText("订单编号");
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderID.setEditable(false);
		txtOrderID.setColumns(10);
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setBounds(400, 152, 120, 50);
		backgroundPanel.add(txtOrderID);
		
		txtBeginTime = new JTextField();
		txtBeginTime.setText("开始时间");
		txtBeginTime.setMargin(new Insets(0, 20, 0, 0));
		txtBeginTime.setForeground(Color.WHITE);
		txtBeginTime.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtBeginTime.setEditable(false);
		txtBeginTime.setColumns(10);
		txtBeginTime.setBackground(SystemColor.activeCaption);
		txtBeginTime.setBounds(400, 201, 120, 50);
		backgroundPanel.add(txtBeginTime);
		
		textArea = new JTextArea();
		textArea.setMargin(new Insets(30, 20, 30, 20));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 20));
		textArea.setBounds(520, 452, 630, 190);
		backgroundPanel.add(textArea);
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


