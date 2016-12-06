package presentation.clientUI_hotel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import presentation.clientUI_account.BackgroundPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.SystemColor;

public class client_hotel extends JFrame
{

	private JPanel contentPane;
	private JTextField txtOrderID;
	private JTextField orderStatememt1;
	private JTextField txtOrderStatement;
	private JTextField txtHotelName;
	private JTextField txtOrderDate;
	private JTextField txtHotelAddress;
	private JTextField txtHotelCBD;
	private JButton button;
	private JTextField orderId1;
	private JTextField orderDate1;
	private JTextField hotelAddress1;
	private JTextField hotelCBD;
	private JTextField hotelName;
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
	private JLabel label;

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
					client_hotel frame = new client_hotel();
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
	public client_hotel()
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
		
		JLabel accountLabel = new JLabel("ÀúÊ·¾Æµê");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtOrderID = new JTextField();
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setText("¶©µ¥±àºÅ");
		txtOrderID.setBounds(400, 147, 120, 50);
		txtOrderID.setColumns(10);
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setEditable(false);
		txtOrderID.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtOrderID);
		
		txtOrderStatement = new JTextField();
		txtOrderStatement.setForeground(Color.WHITE);
		txtOrderStatement.setBackground(SystemColor.activeCaption);
		txtOrderStatement.setText("¶©µ¥×´Ì¬");
		txtOrderStatement.setColumns(10);
		txtOrderStatement.setBounds(520, 147, 120, 50);
		txtOrderStatement.setMargin(new Insets(0, 20, 0, 0));
		txtOrderStatement.setEditable(false);
		txtOrderStatement.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtOrderStatement);
		
		txtHotelName = new JTextField();
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setText("¾ÆµêÃû³Æ");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(1000, 147, 140, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		orderStatememt1 = new JTextField();
		orderStatememt1.setColumns(10);
		orderStatememt1.setBounds(520, 197, 120, 50);
		orderStatememt1.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(orderStatememt1);
		
		JButton modifyButton = new JButton(new ImageIcon("returnButton.jpg"));
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
		txtOrderDate.setBounds(640, 147, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		txtHotelAddress = new JTextField();
		txtHotelAddress.setForeground(Color.WHITE);
		txtHotelAddress.setBackground(SystemColor.activeCaption);
		txtHotelAddress.setText("¾ÆµêµØÖ·");
		txtHotelAddress.setMargin(new Insets(0, 20, 0, 0));
		txtHotelAddress.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelAddress.setEditable(false);
		txtHotelAddress.setColumns(10);
		txtHotelAddress.setBounds(760, 147, 120, 50);
		backgroundPanel.add(txtHotelAddress);
		
		txtHotelCBD = new JTextField();
		txtHotelCBD.setForeground(Color.WHITE);
		txtHotelCBD.setBackground(SystemColor.activeCaption);
		txtHotelCBD.setText("¾ÆµêÉÌÈ¦");
		txtHotelCBD.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCBD.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelCBD.setEditable(false);
		txtHotelCBD.setColumns(10);
		txtHotelCBD.setBounds(880, 147, 120, 50);
		backgroundPanel.add(txtHotelCBD);
		
		button = new JButton(new ImageIcon("button2.jpg"));
		button.setBounds(985, 702, 165, 50);
		backgroundPanel.add(button);
		
		orderId1 = new JTextField();
		orderId1.setMargin(new Insets(0, 20, 0, 0));
		orderId1.setColumns(10);
		orderId1.setBounds(400, 197, 120, 50);
		backgroundPanel.add(orderId1);
		
		orderDate1 = new JTextField();
		orderDate1.setMargin(new Insets(0, 20, 0, 0));
		orderDate1.setColumns(10);
		orderDate1.setBounds(640, 197, 120, 50);
		backgroundPanel.add(orderDate1);
		
		hotelAddress1 = new JTextField();
		hotelAddress1.setMargin(new Insets(0, 20, 0, 0));
		hotelAddress1.setColumns(10);
		hotelAddress1.setBounds(760, 197, 120, 50);
		backgroundPanel.add(hotelAddress1);
		
		hotelCBD = new JTextField();
		hotelCBD.setMargin(new Insets(0, 20, 0, 0));
		hotelCBD.setColumns(10);
		hotelCBD.setBounds(880, 197, 120, 50);
		backgroundPanel.add(hotelCBD);
		
		hotelName = new JTextField();
		hotelName.setMargin(new Insets(0, 20, 0, 0));
		hotelName.setColumns(10);
		hotelName.setBounds(1000, 197, 120, 50);
		backgroundPanel.add(hotelName);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1120, 197, 20, 400);
		backgroundPanel.add(scrollBar);
		
		textField = new JTextField();
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setColumns(10);
		textField.setBounds(400, 247, 120, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setMargin(new Insets(0, 20, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBounds(400, 297, 120, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setColumns(10);
		textField_2.setBounds(400, 347, 120, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setMargin(new Insets(0, 20, 0, 0));
		textField_3.setColumns(10);
		textField_3.setBounds(400, 397, 120, 50);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setMargin(new Insets(0, 20, 0, 0));
		textField_4.setColumns(10);
		textField_4.setBounds(400, 447, 120, 50);
		backgroundPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setMargin(new Insets(0, 20, 0, 0));
		textField_5.setColumns(10);
		textField_5.setBounds(400, 497, 120, 50);
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setMargin(new Insets(0, 20, 0, 0));
		textField_6.setColumns(10);
		textField_6.setBounds(400, 547, 120, 50);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setMargin(new Insets(0, 20, 0, 0));
		textField_7.setColumns(10);
		textField_7.setBounds(1000, 547, 120, 50);
		backgroundPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setMargin(new Insets(0, 20, 0, 0));
		textField_8.setColumns(10);
		textField_8.setBounds(520, 247, 120, 50);
		backgroundPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setMargin(new Insets(0, 20, 0, 0));
		textField_9.setColumns(10);
		textField_9.setBounds(520, 297, 120, 50);
		backgroundPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setMargin(new Insets(0, 20, 0, 0));
		textField_10.setColumns(10);
		textField_10.setBounds(520, 347, 120, 50);
		backgroundPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setMargin(new Insets(0, 20, 0, 0));
		textField_11.setColumns(10);
		textField_11.setBounds(520, 397, 120, 50);
		backgroundPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setMargin(new Insets(0, 20, 0, 0));
		textField_12.setColumns(10);
		textField_12.setBounds(520, 447, 120, 50);
		backgroundPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setMargin(new Insets(0, 20, 0, 0));
		textField_13.setColumns(10);
		textField_13.setBounds(520, 497, 120, 50);
		backgroundPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setMargin(new Insets(0, 20, 0, 0));
		textField_14.setColumns(10);
		textField_14.setBounds(520, 547, 120, 50);
		backgroundPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setMargin(new Insets(0, 20, 0, 0));
		textField_15.setColumns(10);
		textField_15.setBounds(640, 247, 120, 50);
		backgroundPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setMargin(new Insets(0, 20, 0, 0));
		textField_16.setColumns(10);
		textField_16.setBounds(640, 297, 120, 50);
		backgroundPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setMargin(new Insets(0, 20, 0, 0));
		textField_17.setColumns(10);
		textField_17.setBounds(640, 347, 120, 50);
		backgroundPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setMargin(new Insets(0, 20, 0, 0));
		textField_18.setColumns(10);
		textField_18.setBounds(640, 397, 120, 50);
		backgroundPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setMargin(new Insets(0, 20, 0, 0));
		textField_19.setColumns(10);
		textField_19.setBounds(640, 447, 120, 50);
		backgroundPanel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setMargin(new Insets(0, 20, 0, 0));
		textField_20.setColumns(10);
		textField_20.setBounds(640, 497, 120, 50);
		backgroundPanel.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setMargin(new Insets(0, 20, 0, 0));
		textField_21.setColumns(10);
		textField_21.setBounds(640, 547, 120, 50);
		backgroundPanel.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setMargin(new Insets(0, 20, 0, 0));
		textField_22.setColumns(10);
		textField_22.setBounds(760, 247, 120, 50);
		backgroundPanel.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setMargin(new Insets(0, 20, 0, 0));
		textField_23.setColumns(10);
		textField_23.setBounds(760, 297, 120, 50);
		backgroundPanel.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setMargin(new Insets(0, 20, 0, 0));
		textField_24.setColumns(10);
		textField_24.setBounds(760, 347, 120, 50);
		backgroundPanel.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setMargin(new Insets(0, 20, 0, 0));
		textField_25.setColumns(10);
		textField_25.setBounds(760, 397, 120, 50);
		backgroundPanel.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setMargin(new Insets(0, 20, 0, 0));
		textField_26.setColumns(10);
		textField_26.setBounds(760, 447, 120, 50);
		backgroundPanel.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setMargin(new Insets(0, 20, 0, 0));
		textField_27.setColumns(10);
		textField_27.setBounds(760, 497, 120, 50);
		backgroundPanel.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setMargin(new Insets(0, 20, 0, 0));
		textField_28.setColumns(10);
		textField_28.setBounds(760, 547, 120, 50);
		backgroundPanel.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setMargin(new Insets(0, 20, 0, 0));
		textField_29.setColumns(10);
		textField_29.setBounds(880, 247, 120, 50);
		backgroundPanel.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setMargin(new Insets(0, 20, 0, 0));
		textField_30.setColumns(10);
		textField_30.setBounds(880, 297, 120, 50);
		backgroundPanel.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setMargin(new Insets(0, 20, 0, 0));
		textField_31.setColumns(10);
		textField_31.setBounds(880, 347, 120, 50);
		backgroundPanel.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setMargin(new Insets(0, 20, 0, 0));
		textField_32.setColumns(10);
		textField_32.setBounds(880, 397, 120, 50);
		backgroundPanel.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setMargin(new Insets(0, 20, 0, 0));
		textField_33.setColumns(10);
		textField_33.setBounds(880, 447, 120, 50);
		backgroundPanel.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setMargin(new Insets(0, 20, 0, 0));
		textField_34.setColumns(10);
		textField_34.setBounds(880, 497, 120, 50);
		backgroundPanel.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setMargin(new Insets(0, 20, 0, 0));
		textField_35.setColumns(10);
		textField_35.setBounds(880, 547, 120, 50);
		backgroundPanel.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setMargin(new Insets(0, 20, 0, 0));
		textField_36.setColumns(10);
		textField_36.setBounds(1000, 247, 120, 50);
		backgroundPanel.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setMargin(new Insets(0, 20, 0, 0));
		textField_37.setColumns(10);
		textField_37.setBounds(1000, 297, 120, 50);
		backgroundPanel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setMargin(new Insets(0, 20, 0, 0));
		textField_38.setColumns(10);
		textField_38.setBounds(1000, 347, 120, 50);
		backgroundPanel.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setMargin(new Insets(0, 20, 0, 0));
		textField_39.setColumns(10);
		textField_39.setBounds(1000, 397, 120, 50);
		backgroundPanel.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setMargin(new Insets(0, 20, 0, 0));
		textField_40.setColumns(10);
		textField_40.setBounds(1000, 447, 120, 50);
		backgroundPanel.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setMargin(new Insets(0, 20, 0, 0));
		textField_41.setColumns(10);
		textField_41.setBounds(1000, 497, 120, 50);
		backgroundPanel.add(textField_41);
		
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
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


