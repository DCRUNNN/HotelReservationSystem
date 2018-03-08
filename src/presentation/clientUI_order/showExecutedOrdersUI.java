package presentation.clientUI_order;

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
import vo.ClientVO;
import vo.OrderVO;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class showExecutedOrdersUI extends JFrame
{
	ManagePersonalOrder_clientControllerService controller;
	
	private String clientID;
	
	private List<OrderVO> list_unexecutedorderVO;
	private List<OrderVO> list_executedorderVO;
	private List<OrderVO> list_withdrawnorderVO;
	private List<OrderVO> list_abnormalorderVO;
	
	private OrderVO orderVO;
	
	private JPanel contentPane;
	private JTextField orderID_1;
	private JTextField txtOrderDate;
	private JTextField hotelName_1;
	private JTextField orderDate_1;
	private JTextField orderPrice_1;
	private JTextField orderStatement_1;
	private JButton nextPageButton;
	private JButton allOrderButton;
	private JLabel label;
	private JTextField txtOrderID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField orderID_2;
	private JTextField orderID_3;
	private JTextField orderID_4;
	private JTextField orderID_5;
	private JTextField orderID_6;
	private JTextField orderID_7;
	private JTextField orderID_8;
	private JTextField orderID_9;
	private JTextField hotelName_2;
	private JTextField hotelName_3;
	private JTextField hotelName_4;
	private JTextField hotelName_5;
	private JTextField hotelName_6;
	private JTextField hotelName_7;
	private JTextField hotelName_8;
	private JTextField hotelName_9;
	private JTextField orderDate_2;
	private JTextField orderDate_3;
	private JTextField orderDate_4;
	private JTextField orderDate_5;
	private JTextField orderDate_6;
	private JTextField orderDate_7;
	private JTextField orderDate_8;
	private JTextField orderDate_9;
	private JTextField orderPrice_2;
	private JTextField orderPrice_3;
	private JTextField orderPrice_4;
	private JTextField orderPrice_5;
	private JTextField orderPrice_6;
	private JTextField orderPrice_7;
	private JTextField orderPrice_8;
	private JTextField orderPrice_9;
	private JTextField orderStatement_2;
	private JTextField orderStatement_3;
	private JTextField orderStatement_4;
	private JTextField orderStatement_5;
	private JTextField orderStatement_6;
	private JTextField orderStatement_7;
	private JTextField orderStatement_8;
	private JTextField orderStatement_9;
	private JButton check_1;
	private JButton check_2;
	private JButton check_3;
	private JButton check_4;
	private JButton check_5;
	private JButton check_6;
	private JButton check_7;
	private JButton check_8;
	private JButton check_9;
	
	private JButton comment_1;
	private JButton comment_2;
	private JButton comment_3;
	private JButton comment_4;
	private JButton comment_5;
	private JButton comment_6;
	private JButton comment_7;
	private JButton comment_8;
	private JButton comment_9;
	private JButton abnormalOrdersButton;
	private JButton withdrawnOrdersButton;
	private JButton unexecutedOrdersButton;
	private JButton executedOrdersButton;
	
	private int currentPage;
	
	private int totalPage;
	
	private String strArray[];
	
	private JLabel pageLabel;
	
	private String id_order1;
	private String id_order2;
	private String id_order3;
	private String id_order4;
	private String id_order5;
	private String id_order6;
	private String id_order7;
	private String id_order8;
	private String id_order9;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	public showExecutedOrdersUI(ManagePersonalOrder_clientControllerService controller)
	{
		this.controller = controller;
		this.clientID = controller.getClientID();
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		try
		{
			//list_unexecutedorderVO = controller.getUnexecutedOrders(clientID);
			list_executedorderVO = controller.getExecutedOrders(clientID);
			//list_withdrawnorderVO = controller.getWithdrawnOrders(clientID);
			//list_abnormalorderVO = controller.getAbnormalOrders(clientID);
			
			int exe_orders = list_executedorderVO.size();
			//int unexe_orders = list_unexecutedorderVO.size();
			//int withdr_orders = list_withdrawnorderVO.size();
			//int abn_orders = list_abnormalorderVO.size();
			
			currentPage = 1;
			totalPage=exe_orders%9==0?exe_orders/9:exe_orders/9+1;
			if(totalPage == 0)
			{
				totalPage = 1;
			}
			
			String orderID = "";
			int count = 0;
			
			for(int i=0;i<exe_orders;i++)
			{
				orderVO = list_executedorderVO.get(i);
				String id = orderVO.getOrderID()+"/";
				orderID += id;
				count += 1;
			}
			
			int strAmount = totalPage*9;
			strArray = new String[strAmount];
			for(int i=0;i<strAmount;i++)
			{
				strArray[i] = "";
			}
			for(int i=count;i<strAmount;i++)
			{
				orderID+=" /";
			}
			
			strArray = orderID.split("/");
			
			
		} catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		
		orderID_1 = new JTextField();
		orderID_1.setBackground(Color.WHITE);
		orderID_1.setEditable(false);
		orderID_1.setColumns(10);
		orderID_1.setBounds(400, 202, 120, 50);
		orderID_1.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(orderID_1);
		
		JButton lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(400, 690, 165, 50);
		backgroundPanel.add(lastPageButton);
		lastPageButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.lastPageButtonClicked_exe();
			}
		});
		
		txtOrderDate = new JTextField();
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setText("订单日期");
		txtOrderDate.setMargin(new Insets(0, 30, 0, 0));
		txtOrderDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(670, 152, 145, 50);
		backgroundPanel.add(txtOrderDate);
		
		hotelName_1 = new JTextField();
		hotelName_1.setBackground(Color.WHITE);
		hotelName_1.setEditable(false);
		hotelName_1.setMargin(new Insets(0, 20, 0, 0));
		hotelName_1.setColumns(10);
		hotelName_1.setBounds(520, 202, 150, 50);
		backgroundPanel.add(hotelName_1);
		
		orderDate_1 = new JTextField();
		orderDate_1.setBackground(Color.WHITE);
		orderDate_1.setEditable(false);
		orderDate_1.setMargin(new Insets(0, 10, 0, 0));
		orderDate_1.setColumns(10);
		orderDate_1.setBounds(670, 202, 145, 50);
		backgroundPanel.add(orderDate_1);
		
		orderPrice_1 = new JTextField();
		orderPrice_1.setBackground(Color.WHITE);
		orderPrice_1.setEditable(false);
		orderPrice_1.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_1.setColumns(10);
		orderPrice_1.setBounds(815, 202, 105, 50);
		backgroundPanel.add(orderPrice_1);
		
		orderStatement_1 = new JTextField();
		orderStatement_1.setBackground(Color.WHITE);
		orderStatement_1.setEditable(false);
		orderStatement_1.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_1.setColumns(10);
		orderStatement_1.setBounds(920, 202, 110, 50);
		backgroundPanel.add(orderStatement_1);
		
		nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(985, 690, 165, 50);
		backgroundPanel.add(nextPageButton);
		nextPageButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.nextPageButtonClicked_exe();
			}
		});
		
		allOrderButton = new JButton(new ImageIcon("myOrder.jpg"));
		allOrderButton.setBounds(610, 100, 100, 30);
		backgroundPanel.add(allOrderButton);
		allOrderButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.allOrdersButtonClicked_executed();
			}
		});
		
		label = new JLabel();
		String labelstr = "欢迎您，"+clientID;
		label.setText(labelstr);
		label.setForeground(Color.WHITE);
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
				controller.accountButtonClicked_exe();
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
				controller.hotelButtonClicked_exe();
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
				controller.creditButtonClicked_exe();
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
				controller.memberButtonClicked_exe();
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
		
		textField = new JTextField();
		textField.setText("\u9152\u5E97\u540D\u79F0");
		textField.setMargin(new Insets(0, 35, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(520, 152, 150, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8BA2\u5355\u4EF7\u683C");
		textField_1.setMargin(new Insets(0, 10, 0, 0));
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(815, 152, 105, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8BA2\u5355\u72B6\u6001");
		textField_2.setMargin(new Insets(0, 10, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(920, 152, 110, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("操作");
		textField_3.setMargin(new Insets(0, 40, 0, 0));
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.activeCaption);
		textField_3.setBounds(1030, 152, 120, 50);
		backgroundPanel.add(textField_3);
		
		orderID_2 = new JTextField();
		orderID_2.setBackground(Color.WHITE);
		orderID_2.setEditable(false);
		orderID_2.setMargin(new Insets(0, 20, 0, 0));
		orderID_2.setColumns(10);
		orderID_2.setBounds(400, 252, 120, 50);
		backgroundPanel.add(orderID_2);
		
		orderID_3 = new JTextField();
		orderID_3.setBackground(Color.WHITE);
		orderID_3.setEditable(false);
		orderID_3.setMargin(new Insets(0, 20, 0, 0));
		orderID_3.setColumns(10);
		orderID_3.setBounds(400, 302, 120, 50);
		backgroundPanel.add(orderID_3);
		
		orderID_4 = new JTextField();
		orderID_4.setBackground(Color.WHITE);
		orderID_4.setEditable(false);
		orderID_4.setMargin(new Insets(0, 20, 0, 0));
		orderID_4.setColumns(10);
		orderID_4.setBounds(400, 352, 120, 50);
		backgroundPanel.add(orderID_4);
		
		orderID_5 = new JTextField();
		orderID_5.setBackground(Color.WHITE);
		orderID_5.setEditable(false);
		orderID_5.setMargin(new Insets(0, 20, 0, 0));
		orderID_5.setColumns(10);
		orderID_5.setBounds(400, 402, 120, 50);
		backgroundPanel.add(orderID_5);
		
		orderID_6 = new JTextField();
		orderID_6.setBackground(Color.WHITE);
		orderID_6.setEditable(false);
		orderID_6.setMargin(new Insets(0, 20, 0, 0));
		orderID_6.setColumns(10);
		orderID_6.setBounds(400, 452, 120, 50);
		backgroundPanel.add(orderID_6);
		
		orderID_7 = new JTextField();
		orderID_7.setBackground(Color.WHITE);
		orderID_7.setEditable(false);
		orderID_7.setMargin(new Insets(0, 20, 0, 0));
		orderID_7.setColumns(10);
		orderID_7.setBounds(400, 502, 120, 50);
		backgroundPanel.add(orderID_7);
		
		orderID_8 = new JTextField();
		orderID_8.setBackground(Color.WHITE);
		orderID_8.setEditable(false);
		orderID_8.setMargin(new Insets(0, 20, 0, 0));
		orderID_8.setColumns(10);
		orderID_8.setBounds(400, 552, 120, 50);
		backgroundPanel.add(orderID_8);
		
		orderID_9 = new JTextField();
		orderID_9.setBackground(Color.WHITE);
		orderID_9.setEditable(false);
		orderID_9.setMargin(new Insets(0, 20, 0, 0));
		orderID_9.setColumns(10);
		orderID_9.setBounds(400, 602, 120, 50);
		backgroundPanel.add(orderID_9);
		
		hotelName_2 = new JTextField();
		hotelName_2.setBackground(Color.WHITE);
		hotelName_2.setEditable(false);
		hotelName_2.setMargin(new Insets(0, 20, 0, 0));
		hotelName_2.setColumns(10);
		hotelName_2.setBounds(520, 252, 150, 50);
		backgroundPanel.add(hotelName_2);
		
		hotelName_3 = new JTextField();
		hotelName_3.setBackground(Color.WHITE);
		hotelName_3.setEditable(false);
		hotelName_3.setMargin(new Insets(0, 20, 0, 0));
		hotelName_3.setColumns(10);
		hotelName_3.setBounds(520, 302, 150, 50);
		backgroundPanel.add(hotelName_3);
		
		hotelName_4 = new JTextField();
		hotelName_4.setBackground(Color.WHITE);
		hotelName_4.setEditable(false);
		hotelName_4.setMargin(new Insets(0, 20, 0, 0));
		hotelName_4.setColumns(10);
		hotelName_4.setBounds(520, 352, 150, 50);
		backgroundPanel.add(hotelName_4);
		
		hotelName_5 = new JTextField();
		hotelName_5.setBackground(Color.WHITE);
		hotelName_5.setEditable(false);
		hotelName_5.setMargin(new Insets(0, 20, 0, 0));
		hotelName_5.setColumns(10);
		hotelName_5.setBounds(520, 402, 150, 50);
		backgroundPanel.add(hotelName_5);
		
		hotelName_6 = new JTextField();
		hotelName_6.setBackground(Color.WHITE);
		hotelName_6.setEditable(false);
		hotelName_6.setMargin(new Insets(0, 20, 0, 0));
		hotelName_6.setColumns(10);
		hotelName_6.setBounds(520, 452, 150, 50);
		backgroundPanel.add(hotelName_6);
		
		hotelName_7 = new JTextField();
		hotelName_7.setBackground(Color.WHITE);
		hotelName_7.setEditable(false);
		hotelName_7.setMargin(new Insets(0, 20, 0, 0));
		hotelName_7.setColumns(10);
		hotelName_7.setBounds(520, 502, 150, 50);
		backgroundPanel.add(hotelName_7);
		
		hotelName_8 = new JTextField();
		hotelName_8.setBackground(Color.WHITE);
		hotelName_8.setEditable(false);
		hotelName_8.setMargin(new Insets(0, 20, 0, 0));
		hotelName_8.setColumns(10);
		hotelName_8.setBounds(520, 552, 150, 50);
		backgroundPanel.add(hotelName_8);
		
		hotelName_9 = new JTextField();
		hotelName_9.setBackground(Color.WHITE);
		hotelName_9.setEditable(false);
		hotelName_9.setMargin(new Insets(0, 20, 0, 0));
		hotelName_9.setColumns(10);
		hotelName_9.setBounds(520, 602, 150, 50);
		backgroundPanel.add(hotelName_9);
		
		orderDate_2 = new JTextField();
		orderDate_2.setBackground(Color.WHITE);
		orderDate_2.setEditable(false);
		orderDate_2.setMargin(new Insets(0, 10, 0, 0));
		orderDate_2.setColumns(10);
		orderDate_2.setBounds(670, 252, 145, 50);
		backgroundPanel.add(orderDate_2);
		
		orderDate_3 = new JTextField();
		orderDate_3.setBackground(Color.WHITE);
		orderDate_3.setEditable(false);
		orderDate_3.setMargin(new Insets(0, 10, 0, 0));
		orderDate_3.setColumns(10);
		orderDate_3.setBounds(670, 302, 145, 50);
		backgroundPanel.add(orderDate_3);
		
		orderDate_4 = new JTextField();
		orderDate_4.setBackground(Color.WHITE);
		orderDate_4.setEditable(false);
		orderDate_4.setMargin(new Insets(0, 10, 0, 0));
		orderDate_4.setColumns(10);
		orderDate_4.setBounds(670, 352, 145, 50);
		backgroundPanel.add(orderDate_4);
		
		orderDate_5 = new JTextField();
		orderDate_5.setBackground(Color.WHITE);
		orderDate_5.setEditable(false);
		orderDate_5.setMargin(new Insets(0, 10, 0, 0));
		orderDate_5.setColumns(10);
		orderDate_5.setBounds(670, 402, 145, 50);
		backgroundPanel.add(orderDate_5);
		
		orderDate_6 = new JTextField();
		orderDate_6.setBackground(Color.WHITE);
		orderDate_6.setEditable(false);
		orderDate_6.setMargin(new Insets(0, 10, 0, 0));
		orderDate_6.setColumns(10);
		orderDate_6.setBounds(670, 452, 145, 50);
		backgroundPanel.add(orderDate_6);
		
		orderDate_7 = new JTextField();
		orderDate_7.setBackground(Color.WHITE);
		orderDate_7.setEditable(false);
		orderDate_7.setMargin(new Insets(0, 10, 0, 0));
		orderDate_7.setColumns(10);
		orderDate_7.setBounds(670, 502, 145, 50);
		backgroundPanel.add(orderDate_7);
		
		orderDate_8 = new JTextField();
		orderDate_8.setBackground(Color.WHITE);
		orderDate_8.setEditable(false);
		orderDate_8.setMargin(new Insets(0, 10, 0, 0));
		orderDate_8.setColumns(10);
		orderDate_8.setBounds(670, 552, 145, 50);
		backgroundPanel.add(orderDate_8);
		
		orderDate_9 = new JTextField();
		orderDate_9.setBackground(Color.WHITE);
		orderDate_9.setEditable(false);
		orderDate_9.setMargin(new Insets(0, 10, 0, 0));
		orderDate_9.setColumns(10);
		orderDate_9.setBounds(670, 602, 145, 50);
		backgroundPanel.add(orderDate_9);
		
		orderPrice_2 = new JTextField();
		orderPrice_2.setBackground(Color.WHITE);
		orderPrice_2.setEditable(false);
		orderPrice_2.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_2.setColumns(10);
		orderPrice_2.setBounds(815, 252, 105, 50);
		backgroundPanel.add(orderPrice_2);
		
		orderPrice_3 = new JTextField();
		orderPrice_3.setBackground(Color.WHITE);
		orderPrice_3.setEditable(false);
		orderPrice_3.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_3.setColumns(10);
		orderPrice_3.setBounds(815, 302, 105, 50);
		backgroundPanel.add(orderPrice_3);
		
		orderPrice_4 = new JTextField();
		orderPrice_4.setBackground(Color.WHITE);
		orderPrice_4.setEditable(false);
		orderPrice_4.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_4.setColumns(10);
		orderPrice_4.setBounds(815, 352, 105, 50);
		backgroundPanel.add(orderPrice_4);
		
		orderPrice_5 = new JTextField();
		orderPrice_5.setBackground(Color.WHITE);
		orderPrice_5.setEditable(false);
		orderPrice_5.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_5.setColumns(10);
		orderPrice_5.setBounds(815, 402, 105, 50);
		backgroundPanel.add(orderPrice_5);
		
		orderPrice_6 = new JTextField();
		orderPrice_6.setBackground(Color.WHITE);
		orderPrice_6.setEditable(false);
		orderPrice_6.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_6.setColumns(10);
		orderPrice_6.setBounds(815, 452, 105, 50);
		backgroundPanel.add(orderPrice_6);
		
		orderPrice_7 = new JTextField();
		orderPrice_7.setBackground(Color.WHITE);
		orderPrice_7.setEditable(false);
		orderPrice_7.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_7.setColumns(10);
		orderPrice_7.setBounds(815, 502, 105, 50);
		backgroundPanel.add(orderPrice_7);
		
		orderPrice_8 = new JTextField();
		orderPrice_8.setBackground(Color.WHITE);
		orderPrice_8.setEditable(false);
		orderPrice_8.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_8.setColumns(10);
		orderPrice_8.setBounds(815, 552, 105, 50);
		backgroundPanel.add(orderPrice_8);
		
		orderPrice_9 = new JTextField();
		orderPrice_9.setBackground(Color.WHITE);
		orderPrice_9.setEditable(false);
		orderPrice_9.setMargin(new Insets(0, 20, 0, 0));
		orderPrice_9.setColumns(10);
		orderPrice_9.setBounds(815, 602, 105, 50);
		backgroundPanel.add(orderPrice_9);
		
		orderStatement_2 = new JTextField();
		orderStatement_2.setBackground(Color.WHITE);
		orderStatement_2.setEditable(false);
		orderStatement_2.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_2.setColumns(10);
		orderStatement_2.setBounds(920, 252, 110, 50);
		backgroundPanel.add(orderStatement_2);
		
		orderStatement_3 = new JTextField();
		orderStatement_3.setBackground(Color.WHITE);
		orderStatement_3.setEditable(false);
		orderStatement_3.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_3.setColumns(10);
		orderStatement_3.setBounds(920, 302, 110, 50);
		backgroundPanel.add(orderStatement_3);
		
		orderStatement_4 = new JTextField();
		orderStatement_4.setBackground(Color.WHITE);
		orderStatement_4.setEditable(false);
		orderStatement_4.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_4.setColumns(10);
		orderStatement_4.setBounds(920, 352, 110, 50);
		backgroundPanel.add(orderStatement_4);
		
		orderStatement_5 = new JTextField();
		orderStatement_5.setBackground(Color.WHITE);
		orderStatement_5.setEditable(false);
		orderStatement_5.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_5.setColumns(10);
		orderStatement_5.setBounds(920, 402, 110, 50);
		backgroundPanel.add(orderStatement_5);
		
		orderStatement_6 = new JTextField();
		orderStatement_6.setBackground(Color.WHITE);
		orderStatement_6.setEditable(false);
		orderStatement_6.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_6.setColumns(10);
		orderStatement_6.setBounds(920, 452, 110, 50);
		backgroundPanel.add(orderStatement_6);
		
		orderStatement_7 = new JTextField();
		orderStatement_7.setBackground(Color.WHITE);
		orderStatement_7.setEditable(false);
		orderStatement_7.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_7.setColumns(10);
		orderStatement_7.setBounds(920, 502, 110, 50);
		backgroundPanel.add(orderStatement_7);
		
		orderStatement_8 = new JTextField();
		orderStatement_8.setBackground(Color.WHITE);
		orderStatement_8.setEditable(false);
		orderStatement_8.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_8.setColumns(10);
		orderStatement_8.setBounds(920, 552, 110, 50);
		backgroundPanel.add(orderStatement_8);
		
		orderStatement_9 = new JTextField();
		orderStatement_9.setBackground(Color.WHITE);
		orderStatement_9.setEditable(false);
		orderStatement_9.setMargin(new Insets(0, 20, 0, 0));
		orderStatement_9.setColumns(10);
		orderStatement_9.setBounds(920, 602, 110, 50);
		backgroundPanel.add(orderStatement_9);
		
		check_1 = new JButton(new ImageIcon("view3.jpg"));
		check_1.setBounds(1040, 205, 55, 45);
		backgroundPanel.add(check_1);
		
		check_2 = new JButton(new ImageIcon("view3.jpg"));
		check_2.setBounds(1040, 255, 55, 45);
		backgroundPanel.add(check_2);
		
		check_3 = new JButton(new ImageIcon("view3.jpg"));
		check_3.setBounds(1040, 305, 55, 45);
		backgroundPanel.add(check_3);
		
		check_4 = new JButton(new ImageIcon("view3.jpg"));
		check_4.setBounds(1040, 355, 55, 45);
		backgroundPanel.add(check_4);
		
		check_5 = new JButton(new ImageIcon("view3.jpg"));
		check_5.setBounds(1040, 405, 55, 45);
		backgroundPanel.add(check_5);
		
		check_6 = new JButton(new ImageIcon("view3.jpg"));
		check_6.setBounds(1040, 455, 55, 45);
		backgroundPanel.add(check_6);
		
		check_7 = new JButton(new ImageIcon("view3.jpg"));
		check_7.setBounds(1040, 505, 55, 45);
		backgroundPanel.add(check_7);
		
		check_8 = new JButton(new ImageIcon("view3.jpg"));
		check_8.setBounds(1040, 555, 55, 45);
		backgroundPanel.add(check_8);
		
		check_9 = new JButton(new ImageIcon("view3.jpg"));
		check_9.setBounds(1040, 605, 55, 45);
		backgroundPanel.add(check_9);
		
		abnormalOrdersButton = new JButton(new ImageIcon("abn.jpg"));
		abnormalOrdersButton.setBounds(1050, 100, 100, 30);
		backgroundPanel.add(abnormalOrdersButton);
		abnormalOrdersButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.abnormalOrdersButtonClicked_executed();
			}
		});
		
		withdrawnOrdersButton = new JButton(new ImageIcon("wit.jpg"));
		withdrawnOrdersButton.setBounds(940, 100, 100, 30);
		backgroundPanel.add(withdrawnOrdersButton);
		withdrawnOrdersButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.withdrawnOrdersButtonClicked_executed();
			}
		});
		
		unexecutedOrdersButton = new JButton(new ImageIcon("une.jpg"));
		unexecutedOrdersButton.setBounds(830, 100, 100, 30);
		backgroundPanel.add(unexecutedOrdersButton);
		unexecutedOrdersButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.unexecutedOrdersButtonClicked_executed();
			}
		});
		
		executedOrdersButton = new JButton(new ImageIcon("exe.jpg"));
		executedOrdersButton.setBounds(720, 100, 100, 30);
		backgroundPanel.add(executedOrdersButton);
		
		pageLabel = new JLabel();
		String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
		pageLabel.setText(str_page);
		pageLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		pageLabel.setBounds(714, 705, 150, 18);
		backgroundPanel.add(pageLabel);
		
		
		
		
		
		//设置"表格"
		
		orderID_1.setText(strArray[0]);
		orderID_2.setText(strArray[1]);
		orderID_3.setText(strArray[2]);
		orderID_4.setText(strArray[3]);
		orderID_5.setText(strArray[4]);
		orderID_6.setText(strArray[5]);
		orderID_7.setText(strArray[6]);
		orderID_8.setText(strArray[7]);
		orderID_9.setText(strArray[8]);
		
		comment_1 = new JButton(new ImageIcon("comment.jpg"));
		comment_1.setBounds(1095, 205, 55, 45);
		backgroundPanel.add(comment_1);
		
		comment_2 = new JButton(new ImageIcon("comment.jpg"));
		comment_2.setBounds(1095, 255, 55, 45);
		backgroundPanel.add(comment_2);
		
		comment_3 = new JButton(new ImageIcon("comment.jpg"));
		comment_3.setBounds(1095, 305, 55, 45);
		backgroundPanel.add(comment_3);
		
		comment_4 = new JButton(new ImageIcon("comment.jpg"));
		comment_4.setBounds(1095, 355, 55, 45);
		backgroundPanel.add(comment_4);
		
		comment_5 = new JButton(new ImageIcon("comment.jpg"));
		comment_5.setBounds(1095, 405, 55, 45);
		backgroundPanel.add(comment_5);
		
		comment_6 = new JButton(new ImageIcon("comment.jpg"));
		comment_6.setBounds(1095, 455, 55, 45);
		backgroundPanel.add(comment_6);
		
		comment_7 = new JButton(new ImageIcon("comment.jpg"));
		comment_7.setBounds(1095, 505, 55, 45);
		backgroundPanel.add(comment_7);
		
		comment_8 = new JButton(new ImageIcon("comment.jpg"));
		comment_8.setBounds(1095, 555, 55, 45);
		backgroundPanel.add(comment_8);
		
		comment_9 = new JButton(new ImageIcon("comment.jpg"));
		comment_9.setBounds(1095, 605, 55, 45);
		backgroundPanel.add(comment_9);
		
		returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(71, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnMainUIButtonClicked_exe();
			}
		});
		
		fillin();
	}
	
	public void fillin()
	{
		id_order1 = orderID_1.getText().trim();
		id_order2 = orderID_2.getText().trim();
		id_order3 = orderID_3.getText().trim();
		id_order4 = orderID_4.getText().trim();
		id_order5 = orderID_5.getText().trim();
		id_order6 = orderID_6.getText().trim();
		id_order7 = orderID_7.getText().trim();
		id_order8 = orderID_8.getText().trim();
		id_order9 = orderID_9.getText().trim();
		
		try
		{
			if(!id_order1.equals(""))
			{
				orderVO = controller.getOrderVO(id_order1);
				hotelName_1.setText(orderVO.getHotelName());
				orderDate_1.setText(orderVO.getOrderCreatedDate());
				orderPrice_1.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_1.setText(orderVO.getOrderStatus());
				check_1.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton1Clicked_exe();
					}
				});
				comment_1.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton1Clicked();
					}
				});
			}
			else
			{
				hotelName_1.setText("");
				orderDate_1.setText("");
				orderPrice_1.setText("");
				orderStatement_1.setText("");
			}
			
			if(!id_order2.equals(""))
			{
				orderVO = controller.getOrderVO(id_order2);
				hotelName_2.setText(orderVO.getHotelName());
				orderDate_2.setText(orderVO.getOrderCreatedDate());
				orderPrice_2.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_2.setText(orderVO.getOrderStatus());
				check_2.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton2Clicked_exe();
					}
				});
				comment_2.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton2Clicked();
					}
				});
			}
			else
			{
				hotelName_2.setText("");
				orderDate_2.setText("");
				orderPrice_2.setText("");
				orderStatement_2.setText("");
			}
			
			if(!id_order3.equals(""))
			{
				orderVO = controller.getOrderVO(id_order3);
				hotelName_3.setText(orderVO.getHotelName());
				orderDate_3.setText(orderVO.getOrderCreatedDate());
				orderPrice_3.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_3.setText(orderVO.getOrderStatus());
				check_3.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton3Clicked_exe();
					}
				});
				comment_3.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton3Clicked();
					}
				});
			}
			else
			{
				hotelName_3.setText("");
				orderDate_3.setText("");
				orderPrice_3.setText("");
				orderStatement_3.setText("");
			}
			
			if(!id_order4.equals(""))
			{
				orderVO = controller.getOrderVO(id_order4);
				hotelName_4.setText(orderVO.getHotelName());
				orderDate_4.setText(orderVO.getOrderCreatedDate());
				orderPrice_4.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_4.setText(orderVO.getOrderStatus());
				check_4.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton4Clicked_exe();
					}
				});
				comment_4.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton4Clicked();
					}
				});
			}
			else
			{
				hotelName_4.setText("");
				orderDate_4.setText("");
				orderPrice_4.setText("");
				orderStatement_4.setText("");
			}
			
			if(!id_order5.equals(""))
			{
				orderVO = controller.getOrderVO(id_order5);
				hotelName_5.setText(orderVO.getHotelName());
				orderDate_5.setText(orderVO.getOrderCreatedDate());
				orderPrice_5.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_5.setText(orderVO.getOrderStatus());
				check_5.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton5Clicked_exe();
					}
				});
				comment_5.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton5Clicked();
					}
				});
			}
			else
			{
				hotelName_5.setText("");
				orderDate_5.setText("");
				orderPrice_5.setText("");
				orderStatement_5.setText("");
			}
			
			if(!id_order6.equals(""))
			{
				orderVO = controller.getOrderVO(id_order6);
				hotelName_6.setText(orderVO.getHotelName());
				orderDate_6.setText(orderVO.getOrderCreatedDate());
				orderPrice_6.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_6.setText(orderVO.getOrderStatus());
				check_6.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton6Clicked_exe();
					}
				});
				comment_6.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton6Clicked();
					}
				});
			}
			else
			{
				hotelName_6.setText("");
				orderDate_6.setText("");
				orderPrice_6.setText("");
				orderStatement_6.setText("");
			}
			
			if(!id_order7.equals(""))
			{
				orderVO = controller.getOrderVO(id_order7);
				hotelName_7.setText(orderVO.getHotelName());
				orderDate_7.setText(orderVO.getOrderCreatedDate());
				orderPrice_7.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_7.setText(orderVO.getOrderStatus());
				check_7.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton7Clicked_exe();
					}
				});
				comment_7.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton7Clicked();
					}
				});
			}
			else
			{
				hotelName_7.setText("");
				orderDate_7.setText("");
				orderPrice_7.setText("");
				orderStatement_7.setText("");
			}
			
			if(!id_order8.equals(""))
			{
				orderVO = controller.getOrderVO(id_order8);
				hotelName_8.setText(orderVO.getHotelName());
				orderDate_8.setText(orderVO.getOrderCreatedDate());
				orderPrice_8.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_8.setText(orderVO.getOrderStatus());
				check_8.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton8Clicked_exe();
					}
				});
				comment_8.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton8Clicked();
					}
				});
			}
			else
			{
				hotelName_8.setText("");
				orderDate_8.setText("");
				orderPrice_8.setText("");
				orderStatement_8.setText("");
			}
			
			if(!id_order9.equals(""))
			{
				orderVO = controller.getOrderVO(id_order9);
				hotelName_9.setText(orderVO.getHotelName());
				orderDate_9.setText(orderVO.getOrderCreatedDate());
				orderPrice_9.setText(String.valueOf(orderVO.getPrice()));
				orderStatement_9.setText(orderVO.getOrderStatus());
				check_9.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton9Clicked_exe();
					}
				});
				comment_9.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						controller.commentButton9Clicked();
					}
				});
			}
			else
			{
				hotelName_9.setText("");
				orderDate_9.setText("");
				orderPrice_9.setText("");
				orderStatement_9.setText("");
			}
			
		} catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
	public void lastPageButtonCliecked()
	{
		if(currentPage==1)
		{
			JOptionPane.showMessageDialog(null, "当前已是第一页！","", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			currentPage -= 1;
			int currentHead = (currentPage-1)*9;
			orderID_1.setText(strArray[currentHead]);
			orderID_2.setText(strArray[currentHead+1]);
			orderID_3.setText(strArray[currentHead+2]);
			orderID_4.setText(strArray[currentHead+3]);
			orderID_5.setText(strArray[currentHead+4]);
			orderID_6.setText(strArray[currentHead+5]);
			orderID_7.setText(strArray[currentHead+6]);
			orderID_8.setText(strArray[currentHead+7]);
			orderID_9.setText(strArray[currentHead+8]);
			String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
			pageLabel.setText(str_page);
			fillin();
		}
	}
	
	public void nextPageButtonClicked()
	{
		if(currentPage==totalPage)
		{
			JOptionPane.showMessageDialog(null, "当前已是最后一页！","", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			currentPage += 1;
			int currentHead = (currentPage-1)*9;
			orderID_1.setText(strArray[currentHead]);
			orderID_2.setText(strArray[currentHead+1]);
			orderID_3.setText(strArray[currentHead+2]);
			orderID_4.setText(strArray[currentHead+3]);
			orderID_5.setText(strArray[currentHead+4]);
			orderID_6.setText(strArray[currentHead+5]);
			orderID_7.setText(strArray[currentHead+6]);
			orderID_8.setText(strArray[currentHead+7]);
			orderID_9.setText(strArray[currentHead+8]);
			String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
			pageLabel.setText(str_page);
			fillin();
		}
	}

	public void allOrdersButtonClicked()
	{
		showAllOrdersUI showAllOrdersView = new showAllOrdersUI(controller);
		controller.setView(showAllOrdersView);
		this.dispose();
	}

	public void unExecutedOrdersButtonClicked()
	{
		showUnexecutedOrdersUI showUnexecutedOrdersView = new showUnexecutedOrdersUI(controller);
		controller.setView(showUnexecutedOrdersView);
		this.dispose();
	}

	public void abnormalOrdersButtonClicked()
	{
		showAbnormalOrdersUI showAbnormalOrdersView = new showAbnormalOrdersUI(controller);
		controller.setView(showAbnormalOrdersView);
		this.dispose();
	}

	public void withdrawnOrdersButtonClicked()
	{
		showWithdrawnOrdersUI showWithdrawnOrdersView  = new showWithdrawnOrdersUI(controller);
		controller.setView(showWithdrawnOrdersView);
		this.dispose();
	}
	
	public void checkButton1Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order1);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton2Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order2);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton3Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order3);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton4Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order4);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton5Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order5);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton6Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order6);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton7Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order7);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton8Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order8);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void checkButton9Clicked_exe()
	{
		showSingleOrderUI showSingleOrderView = new showSingleOrderUI(controller, id_order9);
		controller.setView(showSingleOrderView);
		this.dispose();
	}
	
	public void commentButton1Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order1);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton2Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order2);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton3Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order3);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton4Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order4);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton5Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order5);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton6Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order6);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton7Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order7);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton8Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order8);
		controller.setView(evaluateView);
		this.dispose();
	}
	
	public void commentButton9Clicked()
	{
		evaluateUI evaluateView = new evaluateUI(controller, id_order9);
		controller.setView(evaluateView);
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


