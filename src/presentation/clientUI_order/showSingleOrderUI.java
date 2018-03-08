package presentation.clientUI_order;

import java.awt.EventQueue;


import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_account.accountUI;
import presentation.clientUI_credit.CheckPersonalCreditUIController;
import presentation.clientUI_credit.creditUI;
import presentation.clientUI_hotel.CheckHistoryHotelUIController;
import presentation.clientUI_hotel.showAllHotelsUI;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import runner.ClientRunner;
import vo.OrderVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class showSingleOrderUI extends JFrame
{
	private ManagePersonalOrder_clientControllerService controller;
	
	private String clientID;
	
	private OrderVO orderVO;
	
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
	private JTextField txtHasChild;
	private JTextField ChildAmount;
	private JTextField txtHotelAddress;
	private JTextField txtHotelCBD;
	private JTextField HotelAddress;
	private JTextField HotelCBD;
	private JLabel label;
	private JTextField txtOrderID;
	private JTextField txtBeginTime;
	private JTextArea Comment;
	
	private String orderDate;
	private String orderPrice;
	private String beginTime;
	private String endTime;
	private String checkOutTime;
	private String roomType;
	private String roomAmount;
	private String roomID;
	private String peopleAmount;
	private String childAmount;
	private String orderStatement;
	private String hotelAddress;
	private String hotelCBD;
	private String hotelName;
	private String comment;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	public showSingleOrderUI(ManagePersonalOrder_clientControllerService controller,String orderID)
	{
		this.controller = controller;
		clientID = controller.getClientID();
		try
		{
			orderVO = controller.getOrderVO(orderID);
			orderDate = orderVO.getOrderCreatedDate();
			orderPrice = String.valueOf(orderVO.getPrice());
			beginTime = orderVO.getOrderBeginDate();
			endTime = orderVO.getOrderLastDate();
			checkOutTime = orderVO.getOrderEndDate();
			roomType = orderVO.getRoomType();
			roomAmount = String.valueOf(orderVO.getRoomTotal());
			roomID = orderVO.getRoomNumber();
			peopleAmount = orderVO.getPeopleNumber();
			childAmount = orderVO.getHasChild();
			orderStatement = orderVO.getOrderStatus();
			hotelAddress = orderVO.getHotelAddress();
			hotelCBD = orderVO.getHotelCBD();
			hotelName = orderVO.getHotelName();
			comment = orderVO.getComment();
			
			/*
			OrderID.setText(orderID);
			OrderDate.setText(orderDate);
			OrderPrice.setText(orderPrice);
			BeginTime.setText(beginTime);
			ExecuteTime.setText(endTime);
			CheckOutTime.setText(checkOutTime);
			RoomType.setText(roomType);
			RoomAmount.setText(roomAmount);
			RoomID.setText(roomID);
			Amount.setText(peopleAmount);
			ChildAmount.setText(childAmount);
			OrderStatement.setText(orderStatement);
			HotelAddress.setText(hotelAddress);
			HotelCBD.setText(hotelCBD);
			HotelName.setText(hotelName);
			Comment.setText(comment);
			*/
			
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image head = new ImageIcon("client.jpg").getImage();
		
		/*
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		contentPane.add(headPanel);
		*/
		
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
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
		
		JLabel headPicture = new JLabel();
		headPicture.setBorder(BorderFactory.createEtchedBorder());
		headPicture.setBounds(71, 90, 170, 170);
		
		Icon icon = controller.getHeadIcon();
		headPicture.setIcon(icon);
		backgroundPanel.add(headPicture);
		
		
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
		txtRoomType.setBounds(900, 202, 120, 50);
		txtRoomType.setMargin(new Insets(0, 20, 0, 0));
		txtRoomType.setEditable(false);
		txtRoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRoomType);
		
		txtAmount = new JTextField();
		txtAmount.setForeground(Color.WHITE);
		txtAmount.setBackground(SystemColor.activeCaption);
		txtAmount.setText("入住人数");
		txtAmount.setColumns(10);
		txtAmount.setBounds(700, 152, 120, 50);
		txtAmount.setMargin(new Insets(0, 20, 0, 0));
		txtAmount.setEditable(false);
		txtAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtAmount);
		
		txtOrderStatement = new JTextField();
		txtOrderStatement.setForeground(Color.WHITE);
		txtOrderStatement.setBackground(SystemColor.activeCaption);
		txtOrderStatement.setText("订单状态");
		txtOrderStatement.setColumns(10);
		txtOrderStatement.setBounds(900, 152, 120, 50);
		txtOrderStatement.setMargin(new Insets(0, 20, 0, 0));
		txtOrderStatement.setEditable(false);
		txtOrderStatement.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderStatement);
		
		txtHotelName = new JTextField();
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setText("酒店名称");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(900, 302, 120, 50);
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
		OrderID.setFont(new Font("宋体", Font.BOLD, 16));
		OrderID.setBackground(Color.WHITE);
		OrderID.setEditable(false);
		OrderID.setBounds(520, 152, 180, 50);
		OrderID.setMargin(new Insets(0, 10, 0, 0));
		backgroundPanel.add(OrderID);
		OrderID.setColumns(10);
		
		BeginTime = new JTextField();
		BeginTime.setFont(new Font("宋体", Font.BOLD, 14));
		BeginTime.setBackground(Color.WHITE);
		BeginTime.setEditable(false);
		BeginTime.setColumns(10);
		BeginTime.setBounds(520, 252, 180, 50);
		BeginTime.setMargin(new Insets(0, 10, 0, 0));
		backgroundPanel.add(BeginTime);
		
		RoomType = new JTextField();
		RoomType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		RoomType.setBackground(Color.WHITE);
		RoomType.setEditable(false);
		RoomType.setColumns(10);
		RoomType.setBounds(1020, 202, 130, 50);
		RoomType.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(RoomType);
		
		Amount = new JTextField();
		Amount.setFont(new Font("宋体", Font.BOLD, 16));
		Amount.setBackground(Color.WHITE);
		Amount.setEditable(false);
		Amount.setColumns(10);
		Amount.setBounds(820, 152, 80, 50);
		Amount.setMargin(new Insets(0, 10, 0, 0));
		backgroundPanel.add(Amount);
		
		OrderStatement = new JTextField();
		OrderStatement.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		OrderStatement.setBackground(Color.WHITE);
		OrderStatement.setEditable(false);
		OrderStatement.setColumns(10);
		OrderStatement.setBounds(1020, 152, 130, 50);
		OrderStatement.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderStatement);
		
		HotelName = new JTextField();
		HotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		HotelName.setBackground(Color.WHITE);
		HotelName.setEditable(false);
		HotelName.setColumns(10);
		HotelName.setBounds(1020, 302, 130, 50);
		HotelName.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(HotelName);
		
		JButton returnButton = new JButton(new ImageIcon("returnButton.jpg"));
		returnButton.setBounds(985, 690, 165, 50);
		backgroundPanel.add(returnButton);
		returnButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnButtonClicked();
			}
		});
		
		txtOrderDate = new JTextField();
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setText("订单日期");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(400, 202, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		OrderDate = new JTextField();
		OrderDate.setFont(new Font("宋体", Font.BOLD, 14));
		OrderDate.setBackground(Color.WHITE);
		OrderDate.setEditable(false);
		OrderDate.setMargin(new Insets(0, 10, 0, 0));
		OrderDate.setColumns(10);
		OrderDate.setBounds(520, 202, 180, 50);
		backgroundPanel.add(OrderDate);
		
		txtOrderPrice = new JTextField();
		txtOrderPrice.setForeground(Color.WHITE);
		txtOrderPrice.setBackground(SystemColor.activeCaption);
		txtOrderPrice.setText("订单价格");
		txtOrderPrice.setMargin(new Insets(0, 20, 0, 0));
		txtOrderPrice.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderPrice.setEditable(false);
		txtOrderPrice.setColumns(10);
		txtOrderPrice.setBounds(700, 202, 120, 50);
		backgroundPanel.add(txtOrderPrice);
		
		OrderPrice = new JTextField();
		OrderPrice.setFont(new Font("宋体", Font.BOLD, 16));
		OrderPrice.setBackground(Color.WHITE);
		OrderPrice.setEditable(false);
		OrderPrice.setMargin(new Insets(0, 10, 0, 0));
		OrderPrice.setColumns(10);
		OrderPrice.setBounds(820, 202, 80, 50);
		backgroundPanel.add(OrderPrice);
		
		txtExecuteTime = new JTextField();
		txtExecuteTime.setForeground(Color.WHITE);
		txtExecuteTime.setBackground(SystemColor.activeCaption);
		txtExecuteTime.setText("最晚执行时间");
		txtExecuteTime.setMargin(new Insets(0, 10, 0, 0));
		txtExecuteTime.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		txtExecuteTime.setEditable(false);
		txtExecuteTime.setColumns(10);
		txtExecuteTime.setBounds(400, 302, 120, 50);
		backgroundPanel.add(txtExecuteTime);
		
		ExecuteTime = new JTextField();
		ExecuteTime.setFont(new Font("宋体", Font.BOLD, 14));
		ExecuteTime.setBackground(Color.WHITE);
		ExecuteTime.setEditable(false);
		ExecuteTime.setMargin(new Insets(0, 10, 0, 0));
		ExecuteTime.setColumns(10);
		ExecuteTime.setBounds(520, 302, 180, 50);
		backgroundPanel.add(ExecuteTime);
		
		txtCheckOutTime = new JTextField();
		txtCheckOutTime.setForeground(Color.WHITE);
		txtCheckOutTime.setBackground(SystemColor.activeCaption);
		txtCheckOutTime.setText("退房时间");
		txtCheckOutTime.setMargin(new Insets(0, 20, 0, 0));
		txtCheckOutTime.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtCheckOutTime.setEditable(false);
		txtCheckOutTime.setColumns(10);
		txtCheckOutTime.setBounds(400, 352, 120, 50);
		backgroundPanel.add(txtCheckOutTime);
		
		CheckOutTime = new JTextField();
		CheckOutTime.setFont(new Font("宋体", Font.BOLD, 14));
		CheckOutTime.setBackground(Color.WHITE);
		CheckOutTime.setEditable(false);
		CheckOutTime.setMargin(new Insets(0, 10, 0, 0));
		CheckOutTime.setColumns(10);
		CheckOutTime.setBounds(520, 352, 180, 50);
		backgroundPanel.add(CheckOutTime);
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setForeground(Color.WHITE);
		txtRoomAmount.setBackground(SystemColor.activeCaption);
		txtRoomAmount.setText("房间数目");
		txtRoomAmount.setMargin(new Insets(0, 20, 0, 0));
		txtRoomAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtRoomAmount.setEditable(false);
		txtRoomAmount.setColumns(10);
		txtRoomAmount.setBounds(700, 252, 120, 50);
		backgroundPanel.add(txtRoomAmount);
		
		RoomAmount = new JTextField();
		RoomAmount.setFont(new Font("宋体", Font.BOLD, 16));
		RoomAmount.setBackground(Color.WHITE);
		RoomAmount.setEditable(false);
		RoomAmount.setMargin(new Insets(0, 10, 0, 0));
		RoomAmount.setColumns(10);
		RoomAmount.setBounds(820, 252, 80, 50);
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
		RoomID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		RoomID.setBackground(Color.WHITE);
		RoomID.setEditable(false);
		RoomID.setMargin(new Insets(0, 20, 0, 0));
		RoomID.setColumns(10);
		RoomID.setBounds(1020, 252, 130, 50);
		backgroundPanel.add(RoomID);
		
		txtHasChild = new JTextField();
		txtHasChild.setForeground(Color.WHITE);
		txtHasChild.setBackground(SystemColor.activeCaption);
		txtHasChild.setText("\u6709\u65E0\u513F\u7AE5");
		txtHasChild.setMargin(new Insets(0, 20, 0, 0));
		txtHasChild.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHasChild.setEditable(false);
		txtHasChild.setColumns(10);
		txtHasChild.setBounds(700, 302, 120, 50);
		backgroundPanel.add(txtHasChild);
		
		ChildAmount = new JTextField();
		ChildAmount.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		ChildAmount.setBackground(Color.WHITE);
		ChildAmount.setEditable(false);
		ChildAmount.setMargin(new Insets(0, 10, 0, 0));
		ChildAmount.setColumns(10);
		ChildAmount.setBounds(820, 302, 80, 50);
		backgroundPanel.add(ChildAmount);
		
		txtHotelAddress = new JTextField();
		txtHotelAddress.setForeground(Color.WHITE);
		txtHotelAddress.setBackground(SystemColor.activeCaption);
		txtHotelAddress.setText("酒店地址");
		txtHotelAddress.setMargin(new Insets(0, 20, 0, 0));
		txtHotelAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelAddress.setEditable(false);
		txtHotelAddress.setColumns(10);
		txtHotelAddress.setBounds(700, 402, 120, 50);
		backgroundPanel.add(txtHotelAddress);
		
		txtHotelCBD = new JTextField();
		txtHotelCBD.setForeground(Color.WHITE);
		txtHotelCBD.setBackground(SystemColor.activeCaption);
		txtHotelCBD.setText("酒店商圈");
		txtHotelCBD.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCBD.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelCBD.setEditable(false);
		txtHotelCBD.setColumns(10);
		txtHotelCBD.setBounds(400, 402, 120, 50);
		backgroundPanel.add(txtHotelCBD);
		
		HotelAddress = new JTextField();
		HotelAddress.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		HotelAddress.setBackground(Color.WHITE);
		HotelAddress.setEditable(false);
		HotelAddress.setMargin(new Insets(0, 20, 0, 0));
		HotelAddress.setColumns(10);
		HotelAddress.setBounds(820, 402, 330, 50);
		backgroundPanel.add(HotelAddress);
		
		HotelCBD = new JTextField();
		HotelCBD.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		HotelCBD.setBackground(Color.WHITE);
		HotelCBD.setEditable(false);
		HotelCBD.setMargin(new Insets(0, 10, 0, 0));
		HotelCBD.setColumns(10);
		HotelCBD.setBounds(520, 402, 180, 50);
		backgroundPanel.add(HotelCBD);
		
		label = new JLabel();
		label.setForeground(Color.WHITE);
		String labelstr = "欢迎您，"+clientID;
		label.setText(labelstr);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		accountButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.accountButtonClicked_single();
			}
		});
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(71, 470, 170, 60);
		backgroundPanel.add(orderButton);
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(71, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		hotelButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.hotelButtonClicked_single();
			}
		});
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		creditButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.creditButtonClicked_single();
			}
		});
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		memberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.memberButtonClicked_single();
			}
		});
		
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
		txtBeginTime.setBounds(400, 252, 120, 50);
		backgroundPanel.add(txtBeginTime);
		
		Comment = new JTextArea();
		Comment.setBackground(Color.WHITE);
		Comment.setEditable(false);
		Comment.setMargin(new Insets(30, 20, 30, 20));
		Comment.setLineWrap(true);
		Comment.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 23));
		Comment.setBounds(520, 452, 630, 190);
		backgroundPanel.add(Comment);
		
		
		if(childAmount.equals("null"))
		{
			childAmount = "";
		}
		else
		{
			childAmount = childAmount.replace("false", "无");
			childAmount = childAmount.replace("true", "有");
		}

		OrderID.setText(orderID);
		OrderDate.setText(orderDate);
		OrderPrice.setText(orderPrice);
		BeginTime.setText(beginTime);
		ExecuteTime.setText(endTime);
		CheckOutTime.setText(checkOutTime);
		RoomType.setText(roomType);
		RoomAmount.setText(roomAmount);
		RoomID.setText(roomID);
		Amount.setText(peopleAmount);
		ChildAmount.setText(childAmount);
		OrderStatement.setText(orderStatement);
		HotelAddress.setText(hotelAddress);
		HotelCBD.setText(hotelCBD);
		HotelName.setText(hotelName);
		Comment.setText(comment);
		
		returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(71, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnMainUIButtonClicked_single();
			}
		});
	}
	
	public void returnButtonClicked()
	{
		showAllOrdersUI showAllOrdersView = new showAllOrdersUI(controller);
		controller.setView(showAllOrdersView);
		this.dispose();
	}
	
	public void accountButtonClicked()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		manageClientMessageUIController.setView(accountView);
		this.dispose();
	}
	
	public void creditButtonClicked()
	{
		CheckPersonalCreditUIController checkPersonalCreditUIController =new CheckPersonalCreditUIController(clientID);
		creditUI creditView = new creditUI(checkPersonalCreditUIController);
		checkPersonalCreditUIController.setView(creditView);
		this.dispose();
	}
	
	public void hotelButtonClicked()
	{
		CheckHistoryHotelUIController checkHistoryHotelUIController = new CheckHistoryHotelUIController(clientID);
		showAllHotelsUI hotelView = new showAllHotelsUI(checkHistoryHotelUIController);
		checkHistoryHotelUIController.setView(hotelView);
		this.dispose();
	}
	
	public void memberButtonClicked()
	{
		ApplyforMemberUIController applyforMemberUIController = new ApplyforMemberUIController(clientID);
		memberUI memberView = new memberUI(applyforMemberUIController);
		applyforMemberUIController.setView(memberView);
		this.dispose();
	}
	
	public void returnMainUIButtonClicked()
	{
		MainUIController mainUIController = new MainUIController(clientID);
		mainUI mainUI = new mainUI(mainUIController);
		mainUIController.setView(mainUI);
		this.dispose();
	}
}


