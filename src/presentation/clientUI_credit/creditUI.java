package presentation.clientUI_credit;

/*
 * 客户查看个人信用界面原型
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_account.accountUI;
import presentation.clientUI_hotel.CheckHistoryHotelUIController;
import presentation.clientUI_hotel.showAllHotelsUI;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.clientUI_order.ManagePersonalOrderUIController;
import presentation.clientUI_order.showAllOrdersUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import vo.CreditVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class creditUI extends JFrame
{
	CheckPersonalCredit_clientControllerService controller;
	
	private String clientID;
	
	private JPanel contentPane;
	
	private JTextField credit;
	private JTextField txtCredit;
	private JTextField txtRecord;
	private JTextField txtTimechange;
	private JTextField txtOrderID;
	private JTextField txtClientType;
	private JTextField txtCompanyName;
	private JTextField TimeChange_1;
	private JTextField OrderID_1;
	private JTextField Cause_1;
	private JTextField Amount_1;
	private JTextField TimeChange_2;
	private JTextField OrderID_2;
	private JTextField Cause_2;
	private JTextField Amount_2;
	private JTextField TimeChange_3;
	private JTextField OrderID_3;
	private JTextField Cause_3;
	private JTextField Amount_3;
	private JTextField TimeChange_4;
	private JTextField OrderID_4;
	private JTextField Cause_4;
	private JTextField Amount_4;
	private JTextField TimeChange_5;
	private JTextField OrderID_5;
	private JTextField Cause_5;
	private JTextField Amount_5;
	
	private JLabel label;
	private JLabel pageLabel;
	
	private int currentPage;
	private int totalPage;
	
	private List<CreditVO> list_creditVO;
	
	private CreditVO creditVO;

	private String strArray[];
	
	private String creditstr;
	
	private double creditAmount;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	public creditUI(CheckPersonalCredit_clientControllerService controller)
	{
		this.controller = controller;
		clientID = controller.getClientID();
		
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
		
		JLabel accountLabel = new JLabel("我的信用");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtCredit = new JTextField();
		txtCredit.setBackground(SystemColor.activeCaption);
		txtCredit.setForeground(Color.WHITE);
		txtCredit.setText("剩余信用");
		txtCredit.setBounds(400, 202, 140, 50);
		txtCredit.setColumns(10);
		txtCredit.setMargin(new Insets(0, 20, 0, 0));
		txtCredit.setEditable(false);
		txtCredit.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCredit);
		
		txtRecord = new JTextField();
		txtRecord.setBackground(SystemColor.activeCaption);
		txtRecord.setForeground(Color.WHITE);
		txtRecord.setText("信用记录");
		txtRecord.setColumns(10);
		txtRecord.setBounds(400, 252, 140, 300);
		txtRecord.setMargin(new Insets(0, 20, 0, 0));
		txtRecord.setEditable(false);
		txtRecord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRecord);
		
		txtTimechange = new JTextField();
		txtTimechange.setBackground(SystemColor.activeCaption);
		txtTimechange.setForeground(Color.WHITE);
		txtTimechange.setText("变化时间");
		txtTimechange.setColumns(10);
		txtTimechange.setBounds(540, 252, 140, 50);
		txtTimechange.setMargin(new Insets(0, 25, 0, 0));
		txtTimechange.setEditable(false);
		txtTimechange.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtTimechange);
		
		txtOrderID = new JTextField();
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setText("订单编号");
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(680, 252, 165, 50);
		txtOrderID.setMargin(new Insets(0, 40, 0, 0));
		txtOrderID.setEditable(false);
		txtOrderID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderID);
		
		txtClientType = new JTextField();
		txtClientType.setBackground(SystemColor.activeCaption);
		txtClientType.setForeground(Color.WHITE);
		txtClientType.setText("变化操作");
		txtClientType.setColumns(10);
		txtClientType.setBounds(845, 252, 165, 50);
		txtClientType.setMargin(new Insets(0, 40, 0, 0));
		txtClientType.setEditable(false);
		txtClientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtClientType);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBackground(SystemColor.activeCaption);
		txtCompanyName.setForeground(Color.WHITE);
		txtCompanyName.setText("变化额度");
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(1010, 252, 140, 50);
		txtCompanyName.setMargin(new Insets(0, 25, 0, 0));
		txtCompanyName.setEditable(false);
		txtCompanyName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCompanyName);
		
		credit = new JTextField();
		credit.setBackground(Color.WHITE);
		credit.setEditable(false);
		credit.setFont(new Font("宋体", Font.PLAIN, 28));
		credit.setBounds(540, 202, 610, 50);
		credit.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(credit);
		credit.setColumns(10);
		credit.setText(creditstr);
		
		TimeChange_1 = new JTextField();
		TimeChange_1.setBackground(Color.WHITE);
		TimeChange_1.setEditable(false);
		TimeChange_1.setFont(new Font("宋体", Font.PLAIN, 12));
		TimeChange_1.setColumns(10);
		TimeChange_1.setBounds(540, 302, 140, 50);
		TimeChange_1.setMargin(new Insets(0, 10, 0, 0));
		backgroundPanel.add(TimeChange_1);
		
		OrderID_1 = new JTextField();
		OrderID_1.setBackground(Color.WHITE);
		OrderID_1.setEditable(false);
		OrderID_1.setFont(new Font("宋体", Font.PLAIN, 18));
		OrderID_1.setMargin(new Insets(0, 20, 0, 0));
		OrderID_1.setColumns(10);
		OrderID_1.setBounds(680, 302, 165, 50);
		backgroundPanel.add(OrderID_1);
		
		Cause_1 = new JTextField();
		Cause_1.setBackground(Color.WHITE);
		Cause_1.setEditable(false);
		Cause_1.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		Cause_1.setMargin(new Insets(0, 30, 0, 0));
		Cause_1.setColumns(10);
		Cause_1.setBounds(845, 302, 165, 50);
		backgroundPanel.add(Cause_1);
		
		Amount_1 = new JTextField();
		Amount_1.setBackground(Color.WHITE);
		Amount_1.setEditable(false);
		Amount_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		Amount_1.setMargin(new Insets(0, 20, 0, 0));
		Amount_1.setColumns(10);
		Amount_1.setBounds(1010, 302, 140, 50);
		backgroundPanel.add(Amount_1);
		
		TimeChange_2 = new JTextField();
		TimeChange_2.setBackground(Color.WHITE);
		TimeChange_2.setEditable(false);
		TimeChange_2.setFont(new Font("宋体", Font.PLAIN, 12));
		TimeChange_2.setMargin(new Insets(0, 10, 0, 0));
		TimeChange_2.setColumns(10);
		TimeChange_2.setBounds(540, 352, 140, 50);
		backgroundPanel.add(TimeChange_2);
		
		OrderID_2 = new JTextField();
		OrderID_2.setBackground(Color.WHITE);
		OrderID_2.setEditable(false);
		OrderID_2.setFont(new Font("宋体", Font.PLAIN, 18));
		OrderID_2.setMargin(new Insets(0, 20, 0, 0));
		OrderID_2.setColumns(10);
		OrderID_2.setBounds(680, 352, 165, 50);
		backgroundPanel.add(OrderID_2);
		
		Cause_2 = new JTextField();
		Cause_2.setBackground(Color.WHITE);
		Cause_2.setEditable(false);
		Cause_2.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		Cause_2.setMargin(new Insets(0, 30, 0, 0));
		Cause_2.setColumns(10);
		Cause_2.setBounds(845, 352, 165, 50);
		backgroundPanel.add(Cause_2);
		
		Amount_2 = new JTextField();
		Amount_2.setBackground(Color.WHITE);
		Amount_2.setEditable(false);
		Amount_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		Amount_2.setMargin(new Insets(0, 20, 0, 0));
		Amount_2.setColumns(10);
		Amount_2.setBounds(1010, 352, 140, 50);
		backgroundPanel.add(Amount_2);
		
		TimeChange_3 = new JTextField();
		TimeChange_3.setBackground(Color.WHITE);
		TimeChange_3.setEditable(false);
		TimeChange_3.setFont(new Font("宋体", Font.PLAIN, 12));
		TimeChange_3.setMargin(new Insets(0, 10, 0, 0));
		TimeChange_3.setColumns(10);
		TimeChange_3.setBounds(540, 402, 140, 50);
		backgroundPanel.add(TimeChange_3);
		
		OrderID_3 = new JTextField();
		OrderID_3.setBackground(Color.WHITE);
		OrderID_3.setEditable(false);
		OrderID_3.setFont(new Font("宋体", Font.PLAIN, 18));
		OrderID_3.setMargin(new Insets(0, 20, 0, 0));
		OrderID_3.setColumns(10);
		OrderID_3.setBounds(680, 402, 165, 50);
		backgroundPanel.add(OrderID_3);
		
		Cause_3 = new JTextField();
		Cause_3.setBackground(Color.WHITE);
		Cause_3.setEditable(false);
		Cause_3.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		Cause_3.setMargin(new Insets(0, 30, 0, 0));
		Cause_3.setColumns(10);
		Cause_3.setBounds(845, 402, 165, 50);
		backgroundPanel.add(Cause_3);
		
		Amount_3 = new JTextField();
		Amount_3.setBackground(Color.WHITE);
		Amount_3.setEditable(false);
		Amount_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		Amount_3.setMargin(new Insets(0, 20, 0, 0));
		Amount_3.setColumns(10);
		Amount_3.setBounds(1010, 402, 140, 50);
		backgroundPanel.add(Amount_3);
		
		TimeChange_4 = new JTextField();
		TimeChange_4.setBackground(Color.WHITE);
		TimeChange_4.setEditable(false);
		TimeChange_4.setFont(new Font("宋体", Font.PLAIN, 12));
		TimeChange_4.setMargin(new Insets(0, 10, 0, 0));
		TimeChange_4.setColumns(10);
		TimeChange_4.setBounds(540, 452, 140, 50);
		backgroundPanel.add(TimeChange_4);
		
		OrderID_4 = new JTextField();
		OrderID_4.setBackground(Color.WHITE);
		OrderID_4.setEditable(false);
		OrderID_4.setFont(new Font("宋体", Font.PLAIN, 18));
		OrderID_4.setMargin(new Insets(0, 20, 0, 0));
		OrderID_4.setColumns(10);
		OrderID_4.setBounds(680, 452, 165, 50);
		backgroundPanel.add(OrderID_4);
		
		Cause_4 = new JTextField();
		Cause_4.setBackground(Color.WHITE);
		Cause_4.setEditable(false);
		Cause_4.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		Cause_4.setMargin(new Insets(0, 30, 0, 0));
		Cause_4.setColumns(10);
		Cause_4.setBounds(845, 452, 165, 50);
		backgroundPanel.add(Cause_4);
		
		Amount_4 = new JTextField();
		Amount_4.setBackground(Color.WHITE);
		Amount_4.setEditable(false);
		Amount_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		Amount_4.setMargin(new Insets(0, 20, 0, 0));
		Amount_4.setColumns(10);
		Amount_4.setBounds(1010, 452, 140, 50);
		backgroundPanel.add(Amount_4);
		
		TimeChange_5 = new JTextField();
		TimeChange_5.setBackground(Color.WHITE);
		TimeChange_5.setEditable(false);
		TimeChange_5.setFont(new Font("宋体", Font.PLAIN, 12));
		TimeChange_5.setMargin(new Insets(0, 10, 0, 0));
		TimeChange_5.setColumns(10);
		TimeChange_5.setBounds(540, 502, 140, 50);
		backgroundPanel.add(TimeChange_5);
		
		OrderID_5 = new JTextField();
		OrderID_5.setBackground(Color.WHITE);
		OrderID_5.setEditable(false);
		OrderID_5.setFont(new Font("宋体", Font.PLAIN, 18));
		OrderID_5.setMargin(new Insets(0, 20, 0, 0));
		OrderID_5.setColumns(10);
		OrderID_5.setBounds(680, 502, 165, 50);
		backgroundPanel.add(OrderID_5);
		
		Cause_5 = new JTextField();
		Cause_5.setBackground(Color.WHITE);
		Cause_5.setEditable(false);
		Cause_5.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 18));
		Cause_5.setMargin(new Insets(0, 30, 0, 0));
		Cause_5.setColumns(10);
		Cause_5.setBounds(845, 502, 165, 50);
		backgroundPanel.add(Cause_5);
		
		Amount_5 = new JTextField();
		Amount_5.setBackground(Color.WHITE);
		Amount_5.setEditable(false);
		Amount_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		Amount_5.setMargin(new Insets(0, 20, 0, 0));
		Amount_5.setColumns(10);
		Amount_5.setBounds(1010, 502, 140, 50);
		backgroundPanel.add(Amount_5);
		
		label = new JLabel();
		String labelstr = "欢迎您，"+clientID;
		label.setText(labelstr);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(400, 620, 140, 50);
		backgroundPanel.add(lastPageButton);
		lastPageButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.lastPageButtonClicked();
			}
		});
		
		JButton nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(1010, 620, 140, 50);
		backgroundPanel.add(nextPageButton);
		nextPageButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.nextPageButtonClicked();
			}
		});
		
		
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		accountButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.accountButtonClicked();
			}
		});
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(71, 470, 170, 60);
		backgroundPanel.add(orderButton);
		orderButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.orderButtonClicked();
			}
		});
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(71, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		hotelButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.hotelButtonClicked();
			}
		});
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		memberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.memberButtonClicked();
			}
		});
		
		//初始化
		//strArray = new String[5];
		//for(int i=0;i<5;i++)
		//{
		//	strArray[i] = "";
		//}
		//currentPage = 1;
		//totalPage = 1;
		
		//得到信息
		getMessage();
		
		//填充信息
		OrderID_1.setText(strArray[0]);
		OrderID_2.setText(strArray[1]);
		OrderID_3.setText(strArray[2]);
		OrderID_4.setText(strArray[3]);
		OrderID_5.setText(strArray[4]);
		credit.setText(creditstr);
		fillin(currentPage);
		
		pageLabel = new JLabel("\u7B2C-1-\u9875\uFF0C\u5171-1-\u9875");
		String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
		pageLabel.setText(str_page);
		pageLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		pageLabel.setBounds(725, 626, 149, 29);
		backgroundPanel.add(pageLabel);
		
		returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(71, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.returnMainUIButtonClicked();
			}
		});
		
	}
	
	public void getMessage()
	{
		currentPage = 1;
		try
		{
			list_creditVO = controller.ShowAllCredit(clientID);
			creditAmount = controller.getCreditPoint(clientID);
			int total = list_creditVO.size();
			
			String orderID = "";
			int count = 0;
			
			for(int i=0;i<total;i++)
			{
				creditVO = list_creditVO.get(i);
				String id = creditVO.getOrderID()+"/";
				orderID += id;
				count += 1;
			}
			totalPage=count%5==0?count/5:count/5+1;
			if(totalPage == 0)
			{
				totalPage = 1;
			}
			
			int strAmount = totalPage*5;
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
			DecimalFormat format = new DecimalFormat("#.0");
			creditstr = format.format(creditAmount);
			if(creditstr.equals(".0"))
			{
				creditstr = "0.0";
			}
			
		} catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	public void lastPageButtonClicked()
	{
		if(currentPage==1)
		{
			JOptionPane.showMessageDialog(null, "当前已是第一页！","", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			currentPage -= 1;
			int currentHead = (currentPage-1)*5;
			OrderID_1.setText(strArray[currentHead]);
			OrderID_2.setText(strArray[currentHead+1]);
			OrderID_3.setText(strArray[currentHead+2]);
			OrderID_4.setText(strArray[currentHead+3]);
			OrderID_5.setText(strArray[currentHead+4]);
			fillin(currentPage);
			String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
			pageLabel.setText(str_page);
			
		}
	}
	
	public void nextButtonClicked()
	{
		if(currentPage==totalPage)
		{
			JOptionPane.showMessageDialog(null, "当前已是最后一页！","", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			currentPage += 1;
			int currentHead = (currentPage-1)*5;
			OrderID_1.setText(strArray[currentHead]);
			OrderID_2.setText(strArray[currentHead+1]);
			OrderID_3.setText(strArray[currentHead+2]);
			OrderID_4.setText(strArray[currentHead+3]);
			OrderID_5.setText(strArray[currentHead+4]);
			fillin(currentPage);
			String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
			pageLabel.setText(str_page);
		}
	}
	
	public void fillin(int currentPage)
	{
		int currentHead = (currentPage-1)*5;
		String id1 = OrderID_1.getText().trim();
		String id2 = OrderID_2.getText().trim();
		String id3 = OrderID_3.getText().trim();
		String id4 = OrderID_4.getText().trim();
		String id5 = OrderID_5.getText().trim();
		
		if(!id1.equals(""))
		{
			TimeChange_1.setText(list_creditVO.get(currentHead).getTime());
			Cause_1.setText(list_creditVO.get(currentHead).getCause());
			Amount_1.setText(list_creditVO.get(currentHead).getChange());
		}
		else
		{
			TimeChange_1.setText("");
			Cause_1.setText("");
			Amount_1.setText("");
		}
		if(!id2.equals(""))
		{
			TimeChange_2.setText(list_creditVO.get(currentHead+1).getTime());
			Cause_2.setText(list_creditVO.get(currentHead+1).getCause());
			Amount_2.setText(list_creditVO.get(currentHead+1).getChange());
		}
		else
		{
			TimeChange_2.setText("");
			Cause_2.setText("");
			Amount_2.setText("");
		}
		if(!id3.equals(""))
		{
			TimeChange_3.setText(list_creditVO.get(currentHead+2).getTime());
			Cause_3.setText(list_creditVO.get(currentHead+2).getCause());
			Amount_3.setText(list_creditVO.get(currentHead+2).getChange());
		}
		else
		{
			TimeChange_3.setText("");
			Cause_3.setText("");
			Amount_3.setText("");
		}
		if(!id4.equals(""))
		{
			TimeChange_4.setText(list_creditVO.get(currentHead+3).getTime());
			Cause_4.setText(list_creditVO.get(currentHead+3).getCause());
			Amount_4.setText(list_creditVO.get(currentHead+3).getChange());
		}
		else
		{
			TimeChange_4.setText("");
			Cause_4.setText("");
			Amount_4.setText("");
		}
		if(!id5.equals(""))
		{
			TimeChange_5.setText(list_creditVO.get(currentHead+4).getTime());
			Cause_5.setText(list_creditVO.get(currentHead+4).getCause());
			Amount_5.setText(list_creditVO.get(currentHead+4).getChange());
		}
		else
		{
			TimeChange_5.setText("");
			Cause_5.setText("");
			Amount_5.setText("");
		}
	}
	
	public void accountButtonClicked()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		manageClientMessageUIController.setView(accountView);
		this.dispose();
	}
	
	public void orderButtonClicked()
	{
		ManagePersonalOrderUIController managePersonalOrderUIController = new ManagePersonalOrderUIController(clientID);
		showAllOrdersUI orderView = new showAllOrdersUI(managePersonalOrderUIController);
		managePersonalOrderUIController.setView(orderView);
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


