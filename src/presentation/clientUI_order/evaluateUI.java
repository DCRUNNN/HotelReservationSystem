package presentation.clientUI_order;

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
import presentation.clientUI_account.successDialog;
import presentation.clientUI_credit.CheckPersonalCreditUIController;
import presentation.clientUI_credit.creditUI;
import presentation.clientUI_hotel.CheckHistoryHotelUIController;
import presentation.clientUI_hotel.showAllHotelsUI;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import vo.OrderVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

import javax.swing.JTextArea;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class evaluateUI extends JFrame
{
	private ManagePersonalOrder_clientControllerService controller;
	
	private String clientID;
	
	private String orderID;
	
	private JPanel contentPane;
	private JTextField OrderID;
	private JTextField txtOrderID;
	private JTextField txtRoom;
	private JTextField txtOrderStatement;
	private JTextField txtHotelName;
	private JTextField txtComment;
	private JTextField OrderStatement;
	private JTextField HotelName;
	private JTextField txtOrderDate;
	private JTextField OrderDate;
	private JTextField txtOrderPrice;
	private JTextField OrderPrice;
	private JTextField txtService;
	private JTextField txtSurroundings;
	
	private JTextArea Comment;
	
	private JLabel label;
	
	private OrderVO orderVO;
	
	private String orderDate;
	
	private JButton savebutton;
	private JButton allOrdersButton;
	
	private double price;
	
	private String orderPrice;
	
	private String orderStatement;
	
	private String hotelName;
	
	private String comment;
	
	private JComboBox<Integer> comboBox_facilities;
	private JComboBox<Integer> comboBox_service;
	private JComboBox<Integer> comboBox_surroundings;
	
	private int flag = 0;
	private int point_facilities = 1;
	private int point_surroundings = 1;
	private int point_service = 1;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public evaluateUI(ManagePersonalOrder_clientControllerService controller,String orderID)
	{
		this.controller = controller;
		this.orderID = orderID;
		clientID = controller.getClientID();
		
		try
		{
			orderVO = controller.getOrderVO(orderID);
			orderDate = orderVO.getOrderCreatedDate();
			price = orderVO.getPrice();
			DecimalFormat format = new DecimalFormat("#.0");
			orderPrice = format.format(price);
			orderStatement = orderVO.getOrderStatus();
			hotelName = orderVO.getHotelName();
			comment = orderVO.getComment();
			
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
		
		txtOrderID = new JTextField();
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setText("订单编号");
		txtOrderID.setBounds(400, 147, 120, 50);
		txtOrderID.setColumns(10);
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setEditable(false);
		txtOrderID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderID);
		
		txtRoom = new JTextField();
		txtRoom.setBackground(SystemColor.activeCaption);
		txtRoom.setForeground(Color.WHITE);
		txtRoom.setText("房间设施");
		txtRoom.setColumns(10);
		txtRoom.setBounds(400, 297, 120, 50);
		txtRoom.setMargin(new Insets(0, 20, 0, 0));
		txtRoom.setEditable(false);
		txtRoom.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRoom);
		txtRoom.setVisible(false);
		
		txtOrderStatement = new JTextField();
		txtOrderStatement.setBackground(SystemColor.activeCaption);
		txtOrderStatement.setForeground(Color.WHITE);
		txtOrderStatement.setText("订单状态");
		txtOrderStatement.setColumns(10);
		txtOrderStatement.setBounds(695, 147, 120, 50);
		txtOrderStatement.setMargin(new Insets(0, 20, 0, 0));
		txtOrderStatement.setEditable(false);
		txtOrderStatement.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderStatement);
		
		txtHotelName = new JTextField();
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setText("酒店名称");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(400, 197, 120, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		txtComment = new JTextField();
		txtComment.setBackground(SystemColor.activeCaption);
		txtComment.setForeground(Color.WHITE);
		txtComment.setText("入住评价");
		txtComment.setColumns(10);
		txtComment.setBounds(400, 397, 120, 190);
		txtComment.setMargin(new Insets(0, 20, 0, 0));
		txtComment.setEditable(false);
		txtComment.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtComment);
		
		OrderID = new JTextField();
		OrderID.setFont(new Font("微软雅黑", Font.BOLD, 20));
		OrderID.setEditable(false);
		OrderID.setBackground(Color.WHITE);
		OrderID.setBounds(520, 147, 175, 50);
		OrderID.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderID);
		OrderID.setColumns(10);
		
		OrderStatement = new JTextField();
		OrderStatement.setFont(new Font("微软雅黑", Font.BOLD, 20));
		OrderStatement.setEditable(false);
		OrderStatement.setBackground(Color.WHITE);
		OrderStatement.setColumns(10);
		OrderStatement.setBounds(815, 147, 130, 50);
		OrderStatement.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderStatement);
		
		HotelName = new JTextField();
		HotelName.setFont(new Font("微软雅黑", Font.BOLD, 20));
		HotelName.setEditable(false);
		HotelName.setBackground(Color.WHITE);
		HotelName.setColumns(10);
		HotelName.setBounds(520, 197, 175, 50);
		HotelName.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(HotelName);
		
		JButton commentButton = new JButton(new ImageIcon("addComment.jpg"));
		commentButton.setBounds(400, 697, 165, 50);
		backgroundPanel.add(commentButton);
		commentButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.commentButtonClicked();
			}
		});
		
		
		txtOrderDate = new JTextField();
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setText("订单日期");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(695, 197, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		OrderDate = new JTextField();
		OrderDate.setFont(new Font("微软雅黑", Font.BOLD, 20));
		OrderDate.setEditable(false);
		OrderDate.setBackground(Color.WHITE);
		OrderDate.setMargin(new Insets(0, 20, 0, 0));
		OrderDate.setColumns(10);
		OrderDate.setBounds(815, 197, 335, 50);
		backgroundPanel.add(OrderDate);
		
		txtOrderPrice = new JTextField();
		txtOrderPrice.setBackground(SystemColor.activeCaption);
		txtOrderPrice.setForeground(Color.WHITE);
		txtOrderPrice.setText("订单价格");
		txtOrderPrice.setMargin(new Insets(0, 20, 0, 0));
		txtOrderPrice.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderPrice.setEditable(false);
		txtOrderPrice.setColumns(10);
		txtOrderPrice.setBounds(945, 147, 120, 50);
		backgroundPanel.add(txtOrderPrice);
		
		OrderPrice = new JTextField();
		OrderPrice.setFont(new Font("微软雅黑", Font.BOLD, 20));
		OrderPrice.setEditable(false);
		OrderPrice.setBackground(Color.WHITE);
		OrderPrice.setMargin(new Insets(0, 20, 0, 0));
		OrderPrice.setColumns(10);
		OrderPrice.setBounds(1066, 147, 84, 50);
		backgroundPanel.add(OrderPrice);
		
		savebutton = new JButton(new ImageIcon("confirm.jpg"));
		savebutton.setBounds(985, 697, 165, 50);
		backgroundPanel.add(savebutton);
		savebutton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.saveButtonClicked();
			}
		});
		
		allOrdersButton = new JButton(new ImageIcon("return4.jpg"));
		allOrdersButton.setBounds(1020, 82, 130, 50);
		backgroundPanel.add(allOrdersButton);
		allOrdersButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.allOrdersButtonClicked_comment();
			}
		});
		
		comboBox_facilities = new JComboBox();
		comboBox_facilities.setFont(new Font("隶书", Font.PLAIN, 20));
		comboBox_facilities.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\t\t\t1", "\t\t\t2", "\t\t\t3", "\t\t\t4", "\t\t\t5"}));
		
		comboBox_facilities.setSelectedIndex(0);
		
		comboBox_facilities.setToolTipText("");
		comboBox_facilities.setBounds(520, 297, 90, 50);
		backgroundPanel.add(comboBox_facilities);
		comboBox_facilities.setVisible(false);
		
		txtService = new JTextField();
		txtService.setBackground(SystemColor.activeCaption);
		txtService.setForeground(Color.WHITE);
		txtService.setText("服务态度");
		txtService.setMargin(new Insets(0, 20, 0, 0));
		txtService.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtService.setEditable(false);
		txtService.setColumns(10);
		txtService.setBounds(650, 297, 120, 50);
		backgroundPanel.add(txtService);
		txtService.setVisible(false);
		
		txtSurroundings = new JTextField();
		txtSurroundings.setBackground(SystemColor.activeCaption);
		txtSurroundings.setForeground(Color.WHITE);
		txtSurroundings.setText("周边环境");
		txtSurroundings.setMargin(new Insets(0, 20, 0, 0));
		txtSurroundings.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtSurroundings.setEditable(false);
		txtSurroundings.setColumns(10);
		txtSurroundings.setBounds(900, 297, 120, 50);
		backgroundPanel.add(txtSurroundings);
		txtSurroundings.setVisible(false);
		
		comboBox_service = new JComboBox();
		comboBox_service.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "1", "2", "3", "4", "5"}));
		comboBox_service.setSelectedIndex(0);
		comboBox_service.setToolTipText("");
		comboBox_service.setFont(new Font("隶书", Font.PLAIN, 20));
		comboBox_service.setBounds(770, 297, 90, 50);
		backgroundPanel.add(comboBox_service);
		comboBox_service.setVisible(false);
		
		comboBox_surroundings = new JComboBox();
		comboBox_surroundings.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "1", "2", "3", "4", "5"}));
		comboBox_surroundings.setSelectedIndex(0);
		comboBox_surroundings.setToolTipText("");
		comboBox_surroundings.setFont(new Font("隶书", Font.PLAIN, 20));
		comboBox_surroundings.setBounds(1020, 297, 90, 50);
		backgroundPanel.add(comboBox_surroundings);
		comboBox_surroundings.setVisible(false);
		
		label = new JLabel("\u6B22\u8FCE\u60A8\uFF0C\u5F20\u4E09");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		accountButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.accountButtonClicked_comment();
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
			public void actionPerformed(ActionEvent arg0)
			{
				controller.hotelButtonClicked_comment();
			}
		});
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		creditButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.creditButtonClicked_comment();
			}
		});
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		memberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.memberButtonClicked_comment();
			}
		});
		
		Comment = new JTextArea();
		Comment.setEditable(false);
		Comment.setFont(new Font("Dialog", Font.BOLD, 20));
		Comment.setBackground(new Color(248, 248, 255));
		Comment.setMargin(new Insets(30, 20, 30, 20));
		Comment.setLineWrap(true);
		Comment.setBounds(520, 397, 630, 190);
		backgroundPanel.add(Comment);
		
		OrderID.setText(orderID);
		OrderDate.setText(orderDate);
		OrderPrice.setText(orderPrice);
		OrderStatement.setText(orderStatement);
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
				controller.returnMainUIButtonClicked_evaluate();
			}
		});
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
	
	public void allOrdersButtonClicked()
	{
		showAllOrdersUI showAllOrdersView = new showAllOrdersUI(controller);
		controller.setView(showAllOrdersView);
		this.dispose();
	}
	
	public void commentButtonClicked()
	{
		if(Comment.getText().trim().equals("")&&!Comment.isEditable())
		{
			flag = 1;
			txtRoom.setVisible(true);
			txtService.setVisible(true);
			txtSurroundings.setVisible(true);
			comboBox_facilities.setVisible(true);
			comboBox_service.setVisible(true);
			comboBox_surroundings.setVisible(true);
		}
		else
		{
			flag = 2;
		}
		
		Comment.setText("");
		Comment.setEditable(true);

		comboBox_facilities.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent)
			{
				if(itemEvent.getStateChange() == ItemEvent.SELECTED)
				{
					point_facilities = comboBox_facilities.getSelectedIndex();
				}
			}
		});
		comboBox_service.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent)
			{
				if(itemEvent.getStateChange() == ItemEvent.SELECTED)
				{
					point_service = comboBox_service.getSelectedIndex();
				}
			}
		});
		comboBox_surroundings.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent)
			{
				if(itemEvent.getStateChange() == ItemEvent.SELECTED)
				{
					point_surroundings = comboBox_surroundings.getSelectedIndex();
				}
			}
		});
	}
	
	public void saveButtonClicked()
	{
		if(flag == 1)
		{
			try
			{
				String commentAdded = Comment.getText();
				controller.addComment(orderID, commentAdded, point_facilities, point_service, point_surroundings);
				
				successDialog dialog = new successDialog();
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				
				evaluateUI evaluateView = new evaluateUI(controller, orderID);
				controller.setView(evaluateView);
				this.dispose();
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag == 2)
		{
			try
			{
				String commentAdded = Comment.getText();
				if(!commentAdded.trim().equals(""))
				{
					controller.addExtraComment(orderID, commentAdded);
					
					successDialog dialog = new successDialog();
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					
					evaluateUI evaluateView = new evaluateUI(controller, orderID);
					controller.setView(evaluateView);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "无评价内容","", JOptionPane.ERROR_MESSAGE);
					evaluateUI evaluateView = new evaluateUI(controller, orderID);
					controller.setView(evaluateView);
					this.dispose();
				}
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void returnMainUIButtonClicked()
	{
		MainUIController mainUIController = new MainUIController(clientID);
		mainUI mainUI = new mainUI(mainUIController);
		mainUIController.setView(mainUI);
		this.dispose();
	}
}


