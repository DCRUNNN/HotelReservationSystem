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

public class client_allOrder extends JFrame
{

	private JPanel contentPane;
	private JTextField BeginTime;
	private JTextField txtOrderDate;
	private JTextField ExecuteTime;
	private JTextField CheckOutTime;
	private JTextField RoomAmount;
	private JTextField RoomID;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel label;
	private JTextField txtOrderID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JButton btnNewButton;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;

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
					client_allOrder frame = new client_allOrder();
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
	public client_allOrder()
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
		
		JLabel accountLabel = new JLabel("¶©µ¥ÐÅÏ¢");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		BeginTime = new JTextField();
		BeginTime.setColumns(10);
		BeginTime.setBounds(400, 202, 120, 50);
		BeginTime.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(BeginTime);
		
		JButton modifyButton = new JButton(new ImageIcon("lastPage.jpg"));
		modifyButton.setBounds(400, 702, 165, 50);
		backgroundPanel.add(modifyButton);
		
		txtOrderDate = new JTextField();
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setText("¶©µ¥ÈÕÆÚ");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(670, 152, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		ExecuteTime = new JTextField();
		ExecuteTime.setMargin(new Insets(0, 20, 0, 0));
		ExecuteTime.setColumns(10);
		ExecuteTime.setBounds(520, 202, 150, 50);
		backgroundPanel.add(ExecuteTime);
		
		CheckOutTime = new JTextField();
		CheckOutTime.setMargin(new Insets(0, 20, 0, 0));
		CheckOutTime.setColumns(10);
		CheckOutTime.setBounds(670, 202, 120, 50);
		backgroundPanel.add(CheckOutTime);
		
		RoomAmount = new JTextField();
		RoomAmount.setMargin(new Insets(0, 20, 0, 0));
		RoomAmount.setColumns(10);
		RoomAmount.setBounds(790, 202, 120, 50);
		backgroundPanel.add(RoomAmount);
		
		RoomID = new JTextField();
		RoomID.setMargin(new Insets(0, 20, 0, 0));
		RoomID.setColumns(10);
		RoomID.setBounds(910, 202, 120, 50);
		backgroundPanel.add(RoomID);
		
		button = new JButton(new ImageIcon("nextPage.jpg"));
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
		label.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 26));
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
		txtOrderID.setText("¶©µ¥±àºÅ");
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtOrderID.setEditable(false);
		txtOrderID.setColumns(10);
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setBounds(400, 152, 120, 50);
		backgroundPanel.add(txtOrderID);
		
		textField = new JTextField();
		textField.setText("\u9152\u5E97\u540D\u79F0");
		textField.setMargin(new Insets(0, 35, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(520, 152, 150, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8BA2\u5355\u4EF7\u683C");
		textField_1.setMargin(new Insets(0, 20, 0, 0));
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(790, 152, 120, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8BA2\u5355\u72B6\u6001");
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(910, 152, 120, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("²Ù×÷");
		textField_3.setMargin(new Insets(0, 40, 0, 0));
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.activeCaption);
		textField_3.setBounds(1030, 152, 120, 50);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setMargin(new Insets(0, 20, 0, 0));
		textField_4.setColumns(10);
		textField_4.setBounds(400, 252, 120, 50);
		backgroundPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setMargin(new Insets(0, 20, 0, 0));
		textField_5.setColumns(10);
		textField_5.setBounds(400, 302, 120, 50);
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setMargin(new Insets(0, 20, 0, 0));
		textField_6.setColumns(10);
		textField_6.setBounds(400, 352, 120, 50);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setMargin(new Insets(0, 20, 0, 0));
		textField_7.setColumns(10);
		textField_7.setBounds(400, 402, 120, 50);
		backgroundPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setMargin(new Insets(0, 20, 0, 0));
		textField_8.setColumns(10);
		textField_8.setBounds(400, 452, 120, 50);
		backgroundPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setMargin(new Insets(0, 20, 0, 0));
		textField_9.setColumns(10);
		textField_9.setBounds(400, 502, 120, 50);
		backgroundPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setMargin(new Insets(0, 20, 0, 0));
		textField_10.setColumns(10);
		textField_10.setBounds(400, 552, 120, 50);
		backgroundPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setMargin(new Insets(0, 20, 0, 0));
		textField_11.setColumns(10);
		textField_11.setBounds(400, 602, 120, 50);
		backgroundPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setMargin(new Insets(0, 20, 0, 0));
		textField_12.setColumns(10);
		textField_12.setBounds(520, 252, 150, 50);
		backgroundPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setMargin(new Insets(0, 20, 0, 0));
		textField_13.setColumns(10);
		textField_13.setBounds(520, 302, 150, 50);
		backgroundPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setMargin(new Insets(0, 20, 0, 0));
		textField_14.setColumns(10);
		textField_14.setBounds(520, 352, 150, 50);
		backgroundPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setMargin(new Insets(0, 20, 0, 0));
		textField_15.setColumns(10);
		textField_15.setBounds(520, 402, 150, 50);
		backgroundPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setMargin(new Insets(0, 20, 0, 0));
		textField_16.setColumns(10);
		textField_16.setBounds(520, 452, 150, 50);
		backgroundPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setMargin(new Insets(0, 20, 0, 0));
		textField_17.setColumns(10);
		textField_17.setBounds(520, 502, 150, 50);
		backgroundPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setMargin(new Insets(0, 20, 0, 0));
		textField_18.setColumns(10);
		textField_18.setBounds(520, 552, 150, 50);
		backgroundPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setMargin(new Insets(0, 20, 0, 0));
		textField_19.setColumns(10);
		textField_19.setBounds(520, 602, 150, 50);
		backgroundPanel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setMargin(new Insets(0, 20, 0, 0));
		textField_20.setColumns(10);
		textField_20.setBounds(670, 252, 120, 50);
		backgroundPanel.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setMargin(new Insets(0, 20, 0, 0));
		textField_21.setColumns(10);
		textField_21.setBounds(670, 302, 120, 50);
		backgroundPanel.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setMargin(new Insets(0, 20, 0, 0));
		textField_22.setColumns(10);
		textField_22.setBounds(670, 352, 120, 50);
		backgroundPanel.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setMargin(new Insets(0, 20, 0, 0));
		textField_23.setColumns(10);
		textField_23.setBounds(670, 402, 120, 50);
		backgroundPanel.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setMargin(new Insets(0, 20, 0, 0));
		textField_24.setColumns(10);
		textField_24.setBounds(670, 452, 120, 50);
		backgroundPanel.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setMargin(new Insets(0, 20, 0, 0));
		textField_25.setColumns(10);
		textField_25.setBounds(670, 502, 120, 50);
		backgroundPanel.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setMargin(new Insets(0, 20, 0, 0));
		textField_26.setColumns(10);
		textField_26.setBounds(670, 552, 120, 50);
		backgroundPanel.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setMargin(new Insets(0, 20, 0, 0));
		textField_27.setColumns(10);
		textField_27.setBounds(670, 602, 120, 50);
		backgroundPanel.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setMargin(new Insets(0, 20, 0, 0));
		textField_28.setColumns(10);
		textField_28.setBounds(790, 252, 120, 50);
		backgroundPanel.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setMargin(new Insets(0, 20, 0, 0));
		textField_29.setColumns(10);
		textField_29.setBounds(790, 302, 120, 50);
		backgroundPanel.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setMargin(new Insets(0, 20, 0, 0));
		textField_30.setColumns(10);
		textField_30.setBounds(790, 352, 120, 50);
		backgroundPanel.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setMargin(new Insets(0, 20, 0, 0));
		textField_31.setColumns(10);
		textField_31.setBounds(790, 402, 120, 50);
		backgroundPanel.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setMargin(new Insets(0, 20, 0, 0));
		textField_32.setColumns(10);
		textField_32.setBounds(790, 452, 120, 50);
		backgroundPanel.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setMargin(new Insets(0, 20, 0, 0));
		textField_33.setColumns(10);
		textField_33.setBounds(790, 502, 120, 50);
		backgroundPanel.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setMargin(new Insets(0, 20, 0, 0));
		textField_34.setColumns(10);
		textField_34.setBounds(790, 552, 120, 50);
		backgroundPanel.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setMargin(new Insets(0, 20, 0, 0));
		textField_35.setColumns(10);
		textField_35.setBounds(790, 602, 120, 50);
		backgroundPanel.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setMargin(new Insets(0, 20, 0, 0));
		textField_36.setColumns(10);
		textField_36.setBounds(910, 252, 120, 50);
		backgroundPanel.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setMargin(new Insets(0, 20, 0, 0));
		textField_37.setColumns(10);
		textField_37.setBounds(910, 302, 120, 50);
		backgroundPanel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setMargin(new Insets(0, 20, 0, 0));
		textField_38.setColumns(10);
		textField_38.setBounds(910, 352, 120, 50);
		backgroundPanel.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setMargin(new Insets(0, 20, 0, 0));
		textField_39.setColumns(10);
		textField_39.setBounds(910, 402, 120, 50);
		backgroundPanel.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setMargin(new Insets(0, 20, 0, 0));
		textField_40.setColumns(10);
		textField_40.setBounds(910, 452, 120, 50);
		backgroundPanel.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setMargin(new Insets(0, 20, 0, 0));
		textField_41.setColumns(10);
		textField_41.setBounds(910, 502, 120, 50);
		backgroundPanel.add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setMargin(new Insets(0, 20, 0, 0));
		textField_42.setColumns(10);
		textField_42.setBounds(910, 552, 120, 50);
		backgroundPanel.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setMargin(new Insets(0, 20, 0, 0));
		textField_43.setColumns(10);
		textField_43.setBounds(910, 602, 120, 50);
		backgroundPanel.add(textField_43);
		
		btnNewButton = new JButton(new ImageIcon("view2.jpg"));
		btnNewButton.setBounds(1040, 205, 100, 45);
		backgroundPanel.add(btnNewButton);
		
		button_4 = new JButton(new ImageIcon("view2.jpg"));
		button_4.setBounds(1040, 255, 100, 45);
		backgroundPanel.add(button_4);
		
		button_5 = new JButton(new ImageIcon("view2.jpg"));
		button_5.setBounds(1040, 305, 100, 45);
		backgroundPanel.add(button_5);
		
		button_6 = new JButton(new ImageIcon("view2.jpg"));
		button_6.setBounds(1040, 355, 100, 45);
		backgroundPanel.add(button_6);
		
		button_7 = new JButton(new ImageIcon("view2.jpg"));
		button_7.setBounds(1040, 405, 100, 45);
		backgroundPanel.add(button_7);
		
		button_8 = new JButton(new ImageIcon("view2.jpg"));
		button_8.setBounds(1040, 455, 100, 45);
		backgroundPanel.add(button_8);
		
		button_9 = new JButton(new ImageIcon("view2.jpg"));
		button_9.setBounds(1040, 505, 100, 45);
		backgroundPanel.add(button_9);
		
		button_10 = new JButton(new ImageIcon("view2.jpg"));
		button_10.setBounds(1040, 555, 100, 45);
		backgroundPanel.add(button_10);
		
		button_11 = new JButton(new ImageIcon("view2.jpg"));
		button_11.setBounds(1040, 605, 100, 45);
		backgroundPanel.add(button_11);
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


