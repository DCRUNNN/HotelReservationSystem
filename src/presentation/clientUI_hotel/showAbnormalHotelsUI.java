package presentation.clientUI_hotel;

import java.awt.EventQueue;



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
import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_account.accountUI;
import presentation.clientUI_credit.CheckPersonalCreditUIController;
import presentation.clientUI_credit.creditUI;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.clientUI_order.ManagePersonalOrderUIController;
import presentation.clientUI_order.showAllOrdersUI;
import presentation.clientUI_order.showSingleOrderUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import vo.HotelVO;
import vo.OrderVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollBar;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class showAbnormalHotelsUI extends JFrame
{
	private CheckHistoryHotelUIController controller;
	
	
	private String clientID;
	
	private JPanel contentPane;
	private JTextField txtHotelID;
	private JTextField txtHotelName;
	private JTextField txtHotelAddress;
	private JTextField txtHotelCBD;
	private JButton nextPageButton;
	private JTextField hotelId1;
	private JTextField hotelAddress1;
	private JTextField hotelCBD1;
	private JTextField hotelName1;
	private JTextField hotelId2;
	private JTextField hotelId3;
	private JTextField hotelId4;
	private JTextField hotelId5;
	private JTextField hotelId6;
	private JTextField hotelId7;
	private JTextField hotelId8;
	private JTextField hotelName8;
	private JTextField hotelAddress2;
	private JTextField hotelAddress3;
	private JTextField hotelAddress4;
	private JTextField hotelAddress5;
	private JTextField hotelAddress6;
	private JTextField hotelAddress7;
	private JTextField hotelAddress8;
	private JTextField hotelCBD2;
	private JTextField hotelCBD3;
	private JTextField hotelCBD4;
	private JTextField hotelCBD5;
	private JTextField hotelCBD6;
	private JTextField hotelCBD7;
	private JTextField hotelCBD8;
	private JTextField hotelName2;
	private JTextField hotelName3;
	private JTextField hotelName4;
	private JTextField hotelName5;
	private JTextField hotelName6;
	private JTextField hotelName7;
	private JLabel label;
	private JTextField textField;
	private JTextField hotelId9;
	private JTextField hotelAddress9;
	private JTextField hotelCBD9;
	private JTextField hotelName9;
	
	private JButton check_1;
	private JButton check_2;
	private JButton check_3;
	private JButton check_4;
	private JButton check_5;
	private JButton check_6;
	private JButton check_7;
	private JButton check_8;
	private JButton check_9;
	
	private JLabel pageLabel;
	
	private int currentPage;
	
	private int totalPage;
	
	private String strArray[];
	
	private List<HotelVO> list_unexecutehotelVO;
	private List<HotelVO> list_executedhotelVO;
	private List<HotelVO> list_withdrawnhotelVO;
	private List<HotelVO> list_abnormalhotelVO;
	
	private HotelVO hotelVO;
	
	private String id_hotel1;
	private String id_hotel2;
	private String id_hotel3;
	private String id_hotel4;
	private String id_hotel5;
	private String id_hotel6;
	private String id_hotel7;
	private String id_hotel8;
	private String id_hotel9;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	public showAbnormalHotelsUI(CheckHistoryHotelUIController controller)
	{
		this.controller = controller;
		clientID = controller.getClientID();
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		try
		{
			//list_unexecutehotelVO = controller.getUnexecutedHotels(clientID);
			//list_executedhotelVO = controller.getExecutedHotels(clientID);
			//list_withdrawnhotelVO = controller.getWithdrawnHotels(clientID);
			list_abnormalhotelVO = controller.getAbnormalHotels(clientID);
			
			//int une_hotels = list_unexecutehotelVO.size();
			//int exe_hotels = list_executedhotelVO.size();
			//int wit_hotels = list_withdrawnhotelVO.size();
			int abn_hotels = list_abnormalhotelVO.size();
			
			currentPage = 1;
			
			String hotelID = "";
			int count = 0;
			
			/*
			for(int i=0;i<une_hotels;i++)
			{
				hotelVO = list_unexecutehotelVO.get(i);
				String id = hotelVO.getHotelID()+"/";
				if(hotelID.contains(id));
				else 
				{
					hotelID += id;
					count += 1;
				}//若酒店ID已存在则不加入ID列表
			}
			
			for(int i=0;i<exe_hotels;i++)
			{
				hotelVO = list_executedhotelVO.get(i);
				String id = hotelVO.getHotelID()+"/";
				if(hotelID.contains(id));
				else 
				{
					hotelID += id;
					count += 1;
				}//若酒店ID已存在则不加入ID列表
			}
			
			for(int i=0;i<wit_hotels;i++)
			{
				hotelVO = list_withdrawnhotelVO.get(i);
				String id = hotelVO.getHotelID()+"/";
				if(hotelID.contains(id));
				else 
				{
					hotelID += id;
					count += 1;
				}//若酒店ID已存在则不加入ID列表
			}
			*/
			
			for(int i=0;i<abn_hotels;i++)
			{
				hotelVO = list_abnormalhotelVO.get(i);
				String id = hotelVO.getHotelID()+"/";
				if(hotelID.contains(id));
				else 
				{
					hotelID += id;
					count += 1;
				}//若酒店ID已存在则不加入ID列表
			}
			
			
			totalPage=count%9==0?count/9:count/9+1;
			if(totalPage == 0)
			{
				totalPage = 1;
			}
			
			int strAmount = 9*totalPage;
			strArray = new String[strAmount];
			
			for(int i=count;i<strAmount;i++)
			{
				hotelID += " /";
			}
			strArray = hotelID.split("/");
			
			/*
			for(int i=0;i<strAmount;i++)
			{
				System.out.println(strArray[i]+"~");
			}
			*/
			

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
		
		JLabel accountLabel = new JLabel("历史酒店");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtHotelID = new JTextField();
		txtHotelID.setForeground(Color.WHITE);
		txtHotelID.setBackground(SystemColor.activeCaption);
		txtHotelID.setText("\u9152\u5E97\u7F16\u53F7");
		txtHotelID.setBounds(380, 145, 150, 50);
		txtHotelID.setColumns(10);
		txtHotelID.setMargin(new Insets(0, 30, 0, 0));
		txtHotelID.setEditable(false);
		txtHotelID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelID);
		
		txtHotelName = new JTextField();
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setText("酒店名称");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(530, 145, 200, 50);
		txtHotelName.setMargin(new Insets(0, 60, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		JButton lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(380, 690, 140, 50);
		backgroundPanel.add(lastPageButton);
		lastPageButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.lastPageButtonClicked_abn();
			}
		});
		
		txtHotelAddress = new JTextField();
		txtHotelAddress.setForeground(Color.WHITE);
		txtHotelAddress.setBackground(SystemColor.activeCaption);
		txtHotelAddress.setText("酒店地址");
		txtHotelAddress.setMargin(new Insets(0, 80, 0, 0));
		txtHotelAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelAddress.setEditable(false);
		txtHotelAddress.setColumns(10);
		txtHotelAddress.setBounds(850, 145, 251, 50);
		backgroundPanel.add(txtHotelAddress);
		
		txtHotelCBD = new JTextField();
		txtHotelCBD.setForeground(Color.WHITE);
		txtHotelCBD.setBackground(SystemColor.activeCaption);
		txtHotelCBD.setText("酒店商圈");
		txtHotelCBD.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCBD.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelCBD.setEditable(false);
		txtHotelCBD.setColumns(10);
		txtHotelCBD.setBounds(730, 145, 120, 50);
		backgroundPanel.add(txtHotelCBD);
		
		nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controller.nextPageButtonClicked_abn();
			}
		});
		nextPageButton.setBounds(1021, 690, 140, 50);
		backgroundPanel.add(nextPageButton);
		
		hotelId1 = new JTextField();
		hotelId1.setMargin(new Insets(0, 20, 0, 0));
		hotelId1.setColumns(10);
		hotelId1.setBounds(380, 195, 150, 50);
		backgroundPanel.add(hotelId1);
		
		hotelAddress1 = new JTextField();
		hotelAddress1.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress1.setColumns(10);
		hotelAddress1.setBounds(850, 195, 251, 50);
		backgroundPanel.add(hotelAddress1);
		
		hotelCBD1 = new JTextField();
		hotelCBD1.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD1.setColumns(10);
		hotelCBD1.setBounds(730, 195, 120, 50);
		backgroundPanel.add(hotelCBD1);
		
		hotelName1 = new JTextField();
		hotelName1.setMargin(new Insets(0, 20, 0, 0));
		hotelName1.setColumns(10);
		hotelName1.setBounds(530, 195, 200, 50);
		backgroundPanel.add(hotelName1);
		
		hotelId2 = new JTextField();
		hotelId2.setMargin(new Insets(0, 20, 0, 0));
		hotelId2.setColumns(10);
		hotelId2.setBounds(380, 245, 150, 50);
		backgroundPanel.add(hotelId2);
		
		hotelId3 = new JTextField();
		hotelId3.setMargin(new Insets(0, 20, 0, 0));
		hotelId3.setColumns(10);
		hotelId3.setBounds(380, 295, 150, 50);
		backgroundPanel.add(hotelId3);
		
		hotelId4 = new JTextField();
		hotelId4.setMargin(new Insets(0, 20, 0, 0));
		hotelId4.setColumns(10);
		hotelId4.setBounds(380, 345, 150, 50);
		backgroundPanel.add(hotelId4);
		
		hotelId5 = new JTextField();
		hotelId5.setMargin(new Insets(0, 20, 0, 0));
		hotelId5.setColumns(10);
		hotelId5.setBounds(380, 395, 150, 50);
		backgroundPanel.add(hotelId5);
		
		hotelId6 = new JTextField();
		hotelId6.setMargin(new Insets(0, 20, 0, 0));
		hotelId6.setColumns(10);
		hotelId6.setBounds(380, 445, 150, 50);
		backgroundPanel.add(hotelId6);
		
		hotelId7 = new JTextField();
		hotelId7.setMargin(new Insets(0, 20, 0, 0));
		hotelId7.setColumns(10);
		hotelId7.setBounds(380, 495, 150, 50);
		backgroundPanel.add(hotelId7);
		
		hotelId8 = new JTextField();
		hotelId8.setMargin(new Insets(0, 20, 0, 0));
		hotelId8.setColumns(10);
		hotelId8.setBounds(380, 545, 150, 50);
		backgroundPanel.add(hotelId8);
		
		hotelName8 = new JTextField();
		hotelName8.setMargin(new Insets(0, 20, 0, 0));
		hotelName8.setColumns(10);
		hotelName8.setBounds(530, 545, 200, 50);
		backgroundPanel.add(hotelName8);
		
		hotelAddress2 = new JTextField();
		hotelAddress2.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress2.setColumns(10);
		hotelAddress2.setBounds(850, 245, 251, 50);
		backgroundPanel.add(hotelAddress2);
		
		hotelAddress3 = new JTextField();
		hotelAddress3.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress3.setColumns(10);
		hotelAddress3.setBounds(850, 295, 251, 50);
		backgroundPanel.add(hotelAddress3);
		
		hotelAddress4 = new JTextField();
		hotelAddress4.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress4.setColumns(10);
		hotelAddress4.setBounds(850, 345, 251, 50);
		backgroundPanel.add(hotelAddress4);
		
		hotelAddress5 = new JTextField();
		hotelAddress5.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress5.setColumns(10);
		hotelAddress5.setBounds(850, 395, 251, 50);
		backgroundPanel.add(hotelAddress5);
		
		hotelAddress6 = new JTextField();
		hotelAddress6.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress6.setColumns(10);
		hotelAddress6.setBounds(850, 445, 251, 50);
		backgroundPanel.add(hotelAddress6);
		
		hotelAddress7 = new JTextField();
		hotelAddress7.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress7.setColumns(10);
		hotelAddress7.setBounds(850, 495, 251, 50);
		backgroundPanel.add(hotelAddress7);
		
		hotelAddress8 = new JTextField();
		hotelAddress8.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress8.setColumns(10);
		hotelAddress8.setBounds(850, 545, 251, 50);
		backgroundPanel.add(hotelAddress8);
		
		hotelCBD2 = new JTextField();
		hotelCBD2.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD2.setColumns(10);
		hotelCBD2.setBounds(730, 245, 120, 50);
		backgroundPanel.add(hotelCBD2);
		
		hotelCBD3 = new JTextField();
		hotelCBD3.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD3.setColumns(10);
		hotelCBD3.setBounds(730, 295, 120, 50);
		backgroundPanel.add(hotelCBD3);
		
		hotelCBD4 = new JTextField();
		hotelCBD4.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD4.setColumns(10);
		hotelCBD4.setBounds(730, 345, 120, 50);
		backgroundPanel.add(hotelCBD4);
		
		hotelCBD5 = new JTextField();
		hotelCBD5.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD5.setColumns(10);
		hotelCBD5.setBounds(730, 395, 120, 50);
		backgroundPanel.add(hotelCBD5);
		
		hotelCBD6 = new JTextField();
		hotelCBD6.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD6.setColumns(10);
		hotelCBD6.setBounds(730, 445, 120, 50);
		backgroundPanel.add(hotelCBD6);
		
		hotelCBD7 = new JTextField();
		hotelCBD7.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD7.setColumns(10);
		hotelCBD7.setBounds(730, 495, 120, 50);
		backgroundPanel.add(hotelCBD7);
		
		hotelCBD8 = new JTextField();
		hotelCBD8.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD8.setColumns(10);
		hotelCBD8.setBounds(730, 545, 120, 50);
		backgroundPanel.add(hotelCBD8);
		
		hotelName2 = new JTextField();
		hotelName2.setMargin(new Insets(0, 20, 0, 0));
		hotelName2.setColumns(10);
		hotelName2.setBounds(530, 245, 200, 50);
		backgroundPanel.add(hotelName2);
		
		hotelName3 = new JTextField();
		hotelName3.setMargin(new Insets(0, 20, 0, 0));
		hotelName3.setColumns(10);
		hotelName3.setBounds(530, 295, 200, 50);
		backgroundPanel.add(hotelName3);
		
		hotelName4 = new JTextField();
		hotelName4.setMargin(new Insets(0, 20, 0, 0));
		hotelName4.setColumns(10);
		hotelName4.setBounds(530, 345, 200, 50);
		backgroundPanel.add(hotelName4);
		
		hotelName5 = new JTextField();
		hotelName5.setMargin(new Insets(0, 20, 0, 0));
		hotelName5.setColumns(10);
		hotelName5.setBounds(530, 395, 200, 50);
		backgroundPanel.add(hotelName5);
		
		hotelName6 = new JTextField();
		hotelName6.setMargin(new Insets(0, 20, 0, 0));
		hotelName6.setColumns(10);
		hotelName6.setBounds(530, 445, 200, 50);
		backgroundPanel.add(hotelName6);
		
		hotelName7 = new JTextField();
		hotelName7.setMargin(new Insets(0, 20, 0, 0));
		hotelName7.setColumns(10);
		hotelName7.setBounds(530, 495, 200, 50);
		backgroundPanel.add(hotelName7);
		
		label = new JLabel();
		String labelstr = "欢迎您，"+clientID;
		label.setText(labelstr);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				controller.accountButtonClicked_abn();
			}
		});
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(71, 470, 170, 60);
		backgroundPanel.add(orderButton);
		orderButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.orderButtonClicked_abn();
			}
		});
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(71, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		creditButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.creditButtonClicked_abn();
			}
		});
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				controller.memberButtonClicked_abn();
			}
		});
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		
		textField = new JTextField();
		textField.setText("\u64CD\u4F5C");
		textField.setMargin(new Insets(0, 10, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(1101, 145, 60, 50);
		backgroundPanel.add(textField);
		
		check_1 = new JButton(new ImageIcon("view4.jpg"));
		check_1.setBounds(1101, 202, 60, 37);
		backgroundPanel.add(check_1);
		
		check_2 = new JButton(new ImageIcon("view4.jpg"));
		check_2.setBounds(1101, 252, 60, 37);
		backgroundPanel.add(check_2);
		
		check_3 = new JButton(new ImageIcon("view4.jpg"));
		check_3.setBounds(1101, 302, 60, 37);
		backgroundPanel.add(check_3);
		
		check_4 = new JButton(new ImageIcon("view4.jpg"));
		check_4.setBounds(1101, 352, 60, 37);
		backgroundPanel.add(check_4);
		
		check_5 = new JButton(new ImageIcon("view4.jpg"));
		check_5.setBounds(1101, 402, 60, 37);
		backgroundPanel.add(check_5);
		
		check_6 = new JButton(new ImageIcon("view4.jpg"));
		check_6.setBounds(1101, 452, 60, 37);
		backgroundPanel.add(check_6);
		
		check_7 = new JButton(new ImageIcon("view4.jpg"));
		check_7.setBounds(1101, 502, 60, 37);
		backgroundPanel.add(check_7);
		
		check_8 = new JButton(new ImageIcon("view4.jpg"));
		check_8.setBounds(1101, 552, 60, 37);
		backgroundPanel.add(check_8);
		
		check_9 = new JButton(new ImageIcon("view4.jpg"));
		check_9.setBounds(1101, 602, 60, 37);
		backgroundPanel.add(check_9);
		
		hotelId9 = new JTextField();
		hotelId9.setMargin(new Insets(0, 20, 0, 0));
		hotelId9.setColumns(10);
		hotelId9.setBounds(380, 595, 150, 50);
		backgroundPanel.add(hotelId9);
		
		hotelAddress9 = new JTextField();
		hotelAddress9.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress9.setColumns(10);
		hotelAddress9.setBounds(850, 595, 251, 50);
		backgroundPanel.add(hotelAddress9);
		
		hotelCBD9 = new JTextField();
		hotelCBD9.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD9.setColumns(10);
		hotelCBD9.setBounds(730, 595, 120, 50);
		backgroundPanel.add(hotelCBD9);
		
		hotelName9 = new JTextField();
		hotelName9.setMargin(new Insets(0, 20, 0, 0));
		hotelName9.setColumns(10);
		hotelName9.setBounds(530, 595, 200, 50);
		backgroundPanel.add(hotelName9);
		
		pageLabel = new JLabel("\u7B2C-1-\u9875\uFF0C\u5171-1-\u9875");
		pageLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		pageLabel.setBounds(705, 690, 140, 37);
		backgroundPanel.add(pageLabel);
		
		
		hotelId1.setText(strArray[0]);
		hotelId2.setText(strArray[1]);
		hotelId3.setText(strArray[2]);
		hotelId4.setText(strArray[3]);
		hotelId5.setText(strArray[4]);
		hotelId6.setText(strArray[5]);
		hotelId7.setText(strArray[6]);
		hotelId8.setText(strArray[7]);
		hotelId9.setText(strArray[8]);
		
		JButton allHotelsButton = new JButton(new ImageIcon("allHotels.jpg"));
		allHotelsButton.setBounds(621, 100, 100, 30);
		backgroundPanel.add(allHotelsButton);
		allHotelsButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.allButtonClicked_abn();
			}
		});
		
		JButton exeButton = new JButton(new ImageIcon("exe.jpg"));
		exeButton.setBounds(731, 100, 100, 30);
		backgroundPanel.add(exeButton);
		exeButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.exeButtonClicked_abn();
			}
		});
		
		JButton uneButton = new JButton(new ImageIcon("une.jpg"));
		uneButton.setBounds(841, 100, 100, 30);
		backgroundPanel.add(uneButton);
		uneButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.uneButtonClicked_abn();
			}
		});
		
		JButton witButton = new JButton(new ImageIcon("wit.jpg"));
		witButton.setBounds(951, 100, 100, 30);
		backgroundPanel.add(witButton);
		witButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.witButtonClicked_abn();
			}
		});
		
		JButton abnButton = new JButton(new ImageIcon("abn.jpg"));
		abnButton.setBounds(1061, 100, 100, 30);
		backgroundPanel.add(abnButton);
		
		returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(71, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnMainUIButtonClicked_abn();
			}
		});
		
		fillin();
		
	}
	
	public void fillin()
	{
		id_hotel1 = hotelId1.getText().trim();
		id_hotel2 = hotelId2.getText().trim();
		id_hotel3 = hotelId3.getText().trim();
		id_hotel4 = hotelId4.getText().trim();
		id_hotel5 = hotelId5.getText().trim();
		id_hotel6 = hotelId6.getText().trim();
		id_hotel7 = hotelId7.getText().trim();
		id_hotel8 = hotelId8.getText().trim();
		id_hotel9 = hotelId9.getText().trim();
		
		try
		{
			if(!id_hotel1.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel1);
				hotelName1.setText(hotelVO.getHotelName());
				hotelAddress1.setText(hotelVO.getHotelAddress());
				hotelCBD1.setText(hotelVO.getHotelCBD());
				check_1.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton1Clicked_abn();
					}
				});
			}
			else
			{
				hotelName1.setText("");
				hotelAddress1.setText("");
				hotelCBD1.setText("");
			}
			if(!id_hotel2.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel2);
				hotelName2.setText(hotelVO.getHotelName());
				hotelAddress2.setText(hotelVO.getHotelAddress());
				hotelCBD2.setText(hotelVO.getHotelCBD());
				check_2.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton2Clicked_abn();
					}
				});
			}
			else
			{
				hotelName2.setText("");
				hotelAddress2.setText("");
				hotelCBD2.setText("");
			}
			if(!id_hotel3.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel3);
				hotelName3.setText(hotelVO.getHotelName());
				hotelAddress3.setText(hotelVO.getHotelAddress());
				hotelCBD3.setText(hotelVO.getHotelCBD());
				check_3.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton3Clicked_abn();
					}
				});
			}
			else
			{
				hotelName3.setText("");
				hotelAddress3.setText("");
				hotelCBD3.setText("");
			}
			if(!id_hotel4.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel4);
				hotelName4.setText(hotelVO.getHotelName());
				hotelAddress4.setText(hotelVO.getHotelAddress());
				hotelCBD4.setText(hotelVO.getHotelCBD());
				check_4.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton4Clicked_abn();
					}
				});
			}
			else
			{
				hotelName4.setText("");
				hotelAddress4.setText("");
				hotelCBD4.setText("");
			}
			if(!id_hotel5.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel5);
				hotelName5.setText(hotelVO.getHotelName());
				hotelAddress5.setText(hotelVO.getHotelAddress());
				hotelCBD5.setText(hotelVO.getHotelCBD());
				check_5.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton5Clicked_abn();
					}
				});
			}
			else
			{
				hotelName5.setText("");
				hotelAddress5.setText("");
				hotelCBD5.setText("");
			}
			if(!id_hotel6.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel6);
				hotelName6.setText(hotelVO.getHotelName());
				hotelAddress6.setText(hotelVO.getHotelAddress());
				hotelCBD6.setText(hotelVO.getHotelCBD());
				check_6.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton6Clicked_abn();
					}
				});
			}
			else
			{
				hotelName6.setText("");
				hotelAddress6.setText("");
				hotelCBD6.setText("");
			}
			if(!id_hotel7.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel7);
				hotelName7.setText(hotelVO.getHotelName());
				hotelAddress7.setText(hotelVO.getHotelAddress());
				hotelCBD7.setText(hotelVO.getHotelCBD());
				check_7.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton7Clicked_abn();
					}
				});
			}
			else
			{
				hotelName7.setText("");
				hotelAddress7.setText("");
				hotelCBD7.setText("");
			}
			if(!id_hotel8.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel8);
				hotelName8.setText(hotelVO.getHotelName());
				hotelAddress8.setText(hotelVO.getHotelAddress());
				hotelCBD8.setText(hotelVO.getHotelCBD());
				check_8.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton8Clicked_abn();
					}
				});
			}
			else
			{
				hotelName8.setText("");
				hotelAddress8.setText("");
				hotelCBD8.setText("");
			}
			if(!id_hotel9.equals(""))
			{
				hotelVO = controller.getHotelVO(clientID, id_hotel9);
				hotelName9.setText(hotelVO.getHotelName());
				hotelAddress9.setText(hotelVO.getHotelAddress());
				hotelCBD9.setText(hotelVO.getHotelCBD());
				check_9.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						controller.checkButton9Clicked_abn();
					}
				});
			}
			else
			{
				hotelName9.setText("");
				hotelAddress9.setText("");
				hotelCBD9.setText("");
			}
			
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void creditButtonClicked()
	{
		CheckPersonalCreditUIController checkPersonalCreditUIController =new CheckPersonalCreditUIController(clientID);
		creditUI creditView = new creditUI(checkPersonalCreditUIController);
		checkPersonalCreditUIController.setView(creditView);
		this.dispose();
	}
	
	public void memberButtonClicked()
	{
		ApplyforMemberUIController applyforMemberUIController = new ApplyforMemberUIController(clientID);
		memberUI memberView = new memberUI(applyforMemberUIController);
		applyforMemberUIController.setView(memberView);
		this.dispose();
	}
	
	public void checkButton1Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel1);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton2Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel2);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton3Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel3);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton4Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel4);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton5Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel5);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton6Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel6);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton7Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel7);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton8Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel8);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void checkButton9Clicked()
	{
		showSingleHotelUI showSingleHotelView = new showSingleHotelUI(controller, id_hotel9);
		controller.setView(showSingleHotelView);
		this.dispose();
	}
	
	public void lastPageButtonClicked()
	{
		if(currentPage==1)
		{
			JOptionPane.showMessageDialog(null, "当前已是第一页！","", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			currentPage-=1;
			int currentHead = (currentPage-1)*9;
			hotelId1.setText(strArray[currentHead]);
			hotelId2.setText(strArray[currentHead+1]);
			hotelId3.setText(strArray[currentHead+2]);
			hotelId4.setText(strArray[currentHead+3]);
			hotelId5.setText(strArray[currentHead+4]);
			hotelId6.setText(strArray[currentHead+5]);
			hotelId7.setText(strArray[currentHead+6]);
			hotelId8.setText(strArray[currentHead+7]);
			hotelId9.setText(strArray[currentHead+8]);
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
			currentPage+=1;
			int currentHead = (currentPage-1)*9;
			hotelId1.setText(strArray[currentHead]);
			hotelId2.setText(strArray[currentHead+1]);
			hotelId3.setText(strArray[currentHead+2]);
			hotelId4.setText(strArray[currentHead+3]);
			hotelId5.setText(strArray[currentHead+4]);
			hotelId6.setText(strArray[currentHead+5]);
			hotelId7.setText(strArray[currentHead+6]);
			hotelId8.setText(strArray[currentHead+7]);
			hotelId9.setText(strArray[currentHead+8]);
			String str_page = "第-" + String.valueOf(currentPage) + "-页，共-" + String.valueOf(totalPage) + "-页";
			pageLabel.setText(str_page);
			fillin();
		}
	}
	
	public void exeButtonClicked_abn()
	{
		showExecutedHotelsUI showExecutedHotelsView = new showExecutedHotelsUI(controller);
		controller.setView(showExecutedHotelsView);
		this.dispose();
	}
	
	public void uneButtonClicked_abn()
	{
		showUnexecutedHotelsUI showUnexecutedHotelsView = new showUnexecutedHotelsUI(controller);
		controller.setView(showUnexecutedHotelsView);
		this.dispose();
	}
	
	public void witButtonClicked_abn()
	{
		showWithdrawnHotelsUI showWithdrawnHotelsView = new showWithdrawnHotelsUI(controller);
		controller.setView(showWithdrawnHotelsView);
		this.dispose();
	}
	
	public void allButtonClicked_abn()
	{
		showAllHotelsUI showAllHotelsView = new showAllHotelsUI(controller);
		controller.setView(showAllHotelsView);
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


