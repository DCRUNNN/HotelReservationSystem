package presentation.clientUI_mainui;

import java.awt.Color;
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
import java.awt.SystemColor;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class client_mainui extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField keyWord;
	private JTextField txtHotelGrade;
	private JTextField txtCheckOutDate;
	private JTextField checkOutDate;

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
					client_mainui frame = new client_mainui();
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
	public client_mainui()
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
		Image txtBackground = new ImageIcon("txtBackground.jpg").getImage();
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		contentPane.add(accountButton);
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(70, 470, 170, 60);
		contentPane.add(orderButton);
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(70, 540, 170, 60);
		contentPane.add(hotelButton);
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(70, 610, 170, 60);
		contentPane.add(creditButton);
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		contentPane.add(memberButton);
		
		Image background2 = new ImageIcon("background2.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("酒店预订");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(400, 210, 200, 50);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(400, 290, 200, 50);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(400, 450, 200, 50);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		destination = new JTextField();
		destination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		destination.setColumns(10);
		destination.setBounds(600, 210, 550, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(destination);
		
		checkInDate = new JTextField();
		checkInDate.setText("2016/12/02");
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(600, 290, 175, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(checkInDate);
		
		keyWord = new JTextField();
		keyWord.setForeground(new Color(169, 169, 169));
		keyWord.setText("（选填）酒店名/地址/商圈");
		keyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		keyWord.setColumns(10);
		keyWord.setBounds(600, 450, 550, 50);
		keyWord.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(keyWord);
		
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		backgroundPanel.add(headPanel);
		headPanel.setBorder(null);
		
		JLabel welcomeLabel = new JLabel("欢迎您，张三");
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(400, 370, 200, 50);
		backgroundPanel.add(txtHotelGrade);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setText("退房日期");
		txtCheckOutDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckOutDate.setForeground(Color.WHITE);
		txtCheckOutDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtCheckOutDate.setEditable(false);
		txtCheckOutDate.setColumns(10);
		txtCheckOutDate.setBackground(SystemColor.activeCaption);
		txtCheckOutDate.setBounds(775, 290, 200, 50);
		backgroundPanel.add(txtCheckOutDate);
		
		checkOutDate = new JTextField();
		checkOutDate.setText("2016/12/30");
		checkOutDate.setMargin(new Insets(0, 20, 0, 20));
		checkOutDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkOutDate.setColumns(10);
		checkOutDate.setBounds(975, 290, 175, 50);
		backgroundPanel.add(checkOutDate);
		
		JButton button = new JButton(new ImageIcon("search.jpg"));
		button.setBounds(950, 558, 200, 60);
		backgroundPanel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  \u4E0D\u9650", "  \u4E94\u661F\u7EA7/\u8C6A\u534E", "  \u56DB\u661F\u7EA7/\u9AD8\u6863", "  \u4E09\u661F\u7EA7/\u8212\u9002", "  \u4E8C\u661F\u7EA7\u4EE5\u4E0B/\u7ECF\u6D4E"}));
		comboBox.setBounds(600, 370, 300, 50);
		backgroundPanel.add(comboBox);
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


