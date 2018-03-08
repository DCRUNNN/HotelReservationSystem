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

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

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
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import vo.HotelVO;
import vo.OrderVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class showSingleHotelUI extends JFrame
{
	private CheckHistoryHotelUIController controller;
	
	
	private String clientID;
	
	private JPanel contentPane;
	private JTextField txtHotelID;
	private JTextField txtHotelName;
	private JTextField txtHotelAddress;
	private JTextField txtHotelCBD;
	private JButton returnButton;
	private JTextField hotelId;
	private JTextField hotelProvince;
	private JTextField hotelCBD;
	private JTextField hotelName;
	private JLabel label;
	
	private String strArray[];
	
	private HotelVO hotelVO;
	
	private JTextField txtOrderID;
	private JTextField orderID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField hotelCity;
	private JTextField hotelAddress;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField orderStatement;
	private JTextField facility;
	private JTextField orderPrice;
	private JTextField star;
	
	private JTextArea introduction;
	private JTextArea comment;
	
	private int commentAmount;
	private int current;
	private String[] com;
	private JButton returnMainUIButton;

	/**
	 * Create the frame.
	 */
	
	public showSingleHotelUI(CheckHistoryHotelUIController controller, String HotelID)
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
		
		JLabel headPicture = new JLabel();
		headPicture.setBorder(BorderFactory.createEtchedBorder());
		headPicture.setBounds(71, 90, 170, 170);
		
		Icon icon = controller.getHeadIcon();
		headPicture.setIcon(icon);
		backgroundPanel.add(headPicture);
		
		JLabel accountLabel = new JLabel("\u9152\u5E97\u8BE6\u60C5");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtHotelID = new JTextField();
		txtHotelID.setForeground(Color.WHITE);
		txtHotelID.setBackground(SystemColor.activeCaption);
		txtHotelID.setText("\u9152\u5E97\u7F16\u53F7");
		txtHotelID.setBounds(600, 60, 150, 50);
		txtHotelID.setColumns(10);
		txtHotelID.setMargin(new Insets(0, 30, 0, 0));
		txtHotelID.setEditable(false);
		txtHotelID.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtHotelID);
		
		txtHotelName = new JTextField();
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setText("¾ÆµêÃû³Æ");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(400, 360, 200, 50);
		txtHotelName.setMargin(new Insets(0, 60, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		txtHotelAddress = new JTextField();
		txtHotelAddress.setForeground(Color.WHITE);
		txtHotelAddress.setBackground(SystemColor.activeCaption);
		txtHotelAddress.setText("¾ÆµêµØÖ·");
		txtHotelAddress.setMargin(new Insets(0, 60, 0, 0));
		txtHotelAddress.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelAddress.setEditable(false);
		txtHotelAddress.setColumns(10);
		txtHotelAddress.setBounds(400, 410, 200, 50);
		backgroundPanel.add(txtHotelAddress);
		
		txtHotelCBD = new JTextField();
		txtHotelCBD.setForeground(Color.WHITE);
		txtHotelCBD.setBackground(SystemColor.activeCaption);
		txtHotelCBD.setText("¾ÆµêÉÌÈ¦");
		txtHotelCBD.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCBD.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelCBD.setEditable(false);
		txtHotelCBD.setColumns(10);
		txtHotelCBD.setBounds(850, 360, 120, 50);
		backgroundPanel.add(txtHotelCBD);
		
		hotelId = new JTextField();
		hotelId.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		hotelId.setBackground(Color.WHITE);
		hotelId.setEditable(false);
		hotelId.setMargin(new Insets(0, 20, 0, 0));
		hotelId.setColumns(10);
		hotelId.setBounds(750, 60, 350, 50);
		backgroundPanel.add(hotelId);
		
		hotelId.setText(HotelID);
		
		hotelProvince = new JTextField();
		hotelProvince.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelProvince.setBackground(Color.WHITE);
		hotelProvince.setEditable(false);
		hotelProvince.setMargin(new Insets(0, 20, 0, 0));
		hotelProvince.setColumns(10);
		hotelProvince.setBounds(600, 410, 125, 50);
		backgroundPanel.add(hotelProvince);
		
		hotelCBD = new JTextField();
		hotelCBD.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelCBD.setBackground(Color.WHITE);
		hotelCBD.setEditable(false);
		hotelCBD.setMargin(new Insets(0, 20, 0, 20));
		hotelCBD.setColumns(10);
		hotelCBD.setBounds(970, 360, 130, 50);
		backgroundPanel.add(hotelCBD);
		
		hotelName = new JTextField();
		hotelName.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelName.setBackground(Color.WHITE);
		hotelName.setEditable(false);
		hotelName.setMargin(new Insets(0, 20, 0, 20));
		hotelName.setColumns(10);
		hotelName.setBounds(600, 360, 250, 50);
		backgroundPanel.add(hotelName);
		
		label = new JLabel();
		String labelstr = "»¶Ó­Äú£¬"+clientID;
		label.setText(labelstr);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 18));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		txtOrderID = new JTextField();
		txtOrderID.setText("\u8BA2\u5355\u7F16\u53F7");
		txtOrderID.setMargin(new Insets(0, 60, 0, 0));
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtOrderID.setEditable(false);
		txtOrderID.setColumns(10);
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setBounds(400, 210, 200, 50);
		backgroundPanel.add(txtOrderID);
		
		orderID = new JTextField();
		orderID.setFont(new Font("·ÂËÎ", Font.BOLD, 18));
		orderID.setBackground(Color.WHITE);
		orderID.setEditable(false);
		orderID.setMargin(new Insets(0, 20, 0, 20));
		orderID.setColumns(10);
		orderID.setBounds(600, 210, 500, 50);
		backgroundPanel.add(orderID);
		
		textField = new JTextField();
		textField.setText("\u8BA2\u5355\u72B6\u6001");
		textField.setMargin(new Insets(0, 60, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(400, 260, 200, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8BA2\u5355\u4EF7\u683C");
		textField_1.setMargin(new Insets(0, 60, 0, 0));
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(400, 310, 200, 50);
		backgroundPanel.add(textField_1);
		
		hotelCity = new JTextField();
		hotelCity.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelCity.setBackground(Color.WHITE);
		hotelCity.setEditable(false);
		hotelCity.setMargin(new Insets(0, 20, 0, 0));
		hotelCity.setColumns(10);
		hotelCity.setBounds(725, 410, 125, 50);
		backgroundPanel.add(hotelCity);
		
		hotelAddress = new JTextField();
		hotelAddress.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		hotelAddress.setBackground(Color.WHITE);
		hotelAddress.setEditable(false);
		hotelAddress.setMargin(new Insets(0, 20, 0, 20));
		hotelAddress.setColumns(10);
		hotelAddress.setBounds(850, 410, 250, 50);
		backgroundPanel.add(hotelAddress);
		
		textField_4 = new JTextField();
		textField_4.setText("\u9152\u5E97\u661F\u7EA7");
		textField_4.setMargin(new Insets(0, 30, 0, 0));
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.activeCaption);
		textField_4.setBounds(600, 160, 150, 50);
		backgroundPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("\u9152\u5E97\u8BBE\u65BD");
		textField_5.setMargin(new Insets(0, 30, 0, 0));
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.activeCaption);
		textField_5.setBounds(600, 110, 150, 50);
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("\u9152\u5E97\u7B80\u4ECB");
		textField_6.setMargin(new Insets(0, 60, 0, 0));
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.activeCaption);
		textField_6.setBounds(400, 460, 200, 70);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("\u9152\u5E97\u8BC4\u4EF7");
		textField_7.setMargin(new Insets(0, 60, 0, 0));
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBackground(SystemColor.activeCaption);
		textField_7.setBounds(400, 530, 200, 210);
		backgroundPanel.add(textField_7);
		
		orderStatement = new JTextField();
		orderStatement.setFont(new Font("·ÂËÎ", Font.BOLD, 18));
		orderStatement.setBackground(Color.WHITE);
		orderStatement.setEditable(false);
		orderStatement.setMargin(new Insets(0, 20, 0, 20));
		orderStatement.setColumns(10);
		orderStatement.setBounds(600, 260, 500, 50);
		backgroundPanel.add(orderStatement);
		
		facility = new JTextField();
		facility.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		facility.setBackground(Color.WHITE);
		facility.setEditable(false);
		facility.setText("");
		facility.setMargin(new Insets(0, 20, 0, 0));
		facility.setColumns(10);
		facility.setBounds(750, 110, 350, 50);
		backgroundPanel.add(facility);
		
		orderPrice = new JTextField();
		orderPrice.setFont(new Font("·ÂËÎ", Font.BOLD, 18));
		orderPrice.setBackground(Color.WHITE);
		orderPrice.setEditable(false);
		orderPrice.setMargin(new Insets(0, 20, 0, 20));
		orderPrice.setColumns(10);
		orderPrice.setBounds(600, 310, 500, 50);
		backgroundPanel.add(orderPrice);
		
		star = new JTextField();
		star.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		star.setBackground(Color.WHITE);
		star.setEditable(false);
		star.setText("");
		star.setMargin(new Insets(0, 20, 0, 0));
		star.setColumns(10);
		star.setBounds(750, 160, 350, 50);
		backgroundPanel.add(star);
		
		introduction = new JTextArea();
		introduction.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		introduction.setMargin(new Insets(20, 30, 20, 30));
		introduction.setLineWrap(true);
		introduction.setBackground(Color.WHITE);
		introduction.setEditable(false);
		introduction.setBounds(600, 460, 500, 70);
		backgroundPanel.add(introduction);
		
		Image background5 = new ImageIcon("background7.jpg").getImage();
		JPanel panel = new BackgroundPanel(null);
		panel.setBounds(600, 530, 500, 210);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		
		comment = new JTextArea();
		comment.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comment.setMargin(new Insets(20, 30, 20, 30));
		comment.setEditable(false);
		
		comment.setBounds(64, 13, 370, 184);
		comment.setLineWrap(true);
		panel.add(comment);
		
		//Ìî³äÐÅÏ¢
		try
		{
			hotelVO = controller.getHotelVO(clientID, HotelID);
		} catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		if(hotelVO!=null)
		{
			facility.setText(hotelVO.getFacilities());
			star.setText(String.valueOf(hotelVO.getHotelStar()));
			hotelName.setText(hotelVO.getHotelName());
			orderID.setText(hotelVO.getOrderID());
			orderStatement.setText(hotelVO.getOrderStatus());
			orderPrice.setText(hotelVO.getPrice());
			hotelCBD.setText(hotelVO.getHotelCBD());
			hotelProvince.setText(hotelVO.getHotelProvince());
			hotelCity.setText(hotelVO.getHotelCity());
			hotelAddress.setText(hotelVO.getHotelAddress());
			introduction.setText(hotelVO.getIntroduction());
			
			String comments = hotelVO.getCommentList();
			if(comments.equals(""))
			{
				comment.setText("ÔÝÎÞÆÀÂÛ");
			}
			else
			{
				com = comments.split("%");
				commentAmount = com.length;
				current = 0;
				String text = "¶©µ¥±àºÅ:" + com[current].substring(0, 12) + "\n" + 
												"¿Í»§±àºÅ:" + com[current].substring(13, 20) + "\n" +
																com[current].substring(21);
				//System.out.println(text);
				comment.setText(text);
			}
		}
		
		
		returnButton = new JButton(new ImageIcon("return.jpg"));
		returnButton.setBounds(970, 746, 130, 41);
		backgroundPanel.add(returnButton);
		returnButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnButtonClicked();
			}
		});
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				controller.accountButtonClicked_single();
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
				controller.orderButtonClicked_single();
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
				controller.creditButtonClicked_single();
			}
		});
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.memberButtonClicked_single();
			}
		});
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		
		JButton lastButton = new JButton(new ImageIcon("last.jpg"));
		lastButton.setBounds(14, 87, 40, 40);
		panel.add(lastButton);
		lastButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.lastButtonClicked();
			}
		});
		
		
		JButton nextButton = new JButton(new ImageIcon("next.jpg"));
		nextButton.setBounds(446, 87, 40, 40);
		panel.add(nextButton);
		nextButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.nextButtonClicked();
			}
		});
		
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
	
	public void lastButtonClicked()
	{
		if(current==0)
		{
			current = commentAmount-1;
		}
		else
		{
			current-=1;
		}
		String text = "¶©µ¥±àºÅ:" + com[current].substring(0, 12) + "\n" + 
				"¿Í»§±àºÅ:" + com[current].substring(13, 20) + "\n" +
								com[current].substring(21);
		comment.setText(text);
	}
	
	public void nextButtonClicked()
	{
		if(current==commentAmount-1)
		{
			current = 0;
		}
		else
		{
			current+=1;
		}
		String text = "¶©µ¥±àºÅ:" + com[current].substring(0, 12) + "\n" + 
				"¿Í»§±àºÅ:" + com[current].substring(13, 20) + "\n" +
								com[current].substring(21);
		comment.setText(text);
	}
	
	public void returnButtonClicked()
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


