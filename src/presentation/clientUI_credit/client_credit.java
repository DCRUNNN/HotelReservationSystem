package presentation.clientUI_credit;

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
import javax.swing.JScrollBar;
import java.awt.SystemColor;

public class client_credit extends JFrame
{

	private JPanel contentPane;
	private JTextField credit;
	private JTextField txtCredit;
	private JTextField txtRecord;
	private JTextField txtTimechange;
	private JTextField txtOrderID;
	private JTextField txtClientType;
	private JTextField txtCompanyName;
	private JTextField identity;
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
	private JScrollBar scrollBar;
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
					client_credit frame = new client_credit();
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
	public client_credit()
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
		
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
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
		txtClientType.setBounds(845, 252, 140, 50);
		txtClientType.setMargin(new Insets(0, 25, 0, 0));
		txtClientType.setEditable(false);
		txtClientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtClientType);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBackground(SystemColor.activeCaption);
		txtCompanyName.setForeground(Color.WHITE);
		txtCompanyName.setText("变化额度");
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(985, 252, 165, 50);
		txtCompanyName.setMargin(new Insets(0, 25, 0, 0));
		txtCompanyName.setEditable(false);
		txtCompanyName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCompanyName);
		
		credit = new JTextField();
		credit.setBounds(540, 202, 610, 50);
		credit.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(credit);
		credit.setColumns(10);
		
		identity = new JTextField();
		identity.setColumns(10);
		identity.setBounds(540, 302, 140, 50);
		identity.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(identity);
		
		JButton modifyButton = new JButton(new ImageIcon("recharge.jpg"));
		modifyButton.setBounds(400, 702, 165, 50);
		backgroundPanel.add(modifyButton);
		
		JButton returnButton = new JButton(new ImageIcon("return.jpg"));
		returnButton.setBounds(985, 702, 165, 50);
		backgroundPanel.add(returnButton);
		
		textField = new JTextField();
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setColumns(10);
		textField.setBounds(680, 302, 165, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setMargin(new Insets(0, 20, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBounds(845, 302, 140, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setColumns(10);
		textField_2.setBounds(985, 302, 145, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setMargin(new Insets(0, 20, 0, 0));
		textField_3.setColumns(10);
		textField_3.setBounds(540, 352, 140, 50);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setMargin(new Insets(0, 20, 0, 0));
		textField_4.setColumns(10);
		textField_4.setBounds(680, 352, 165, 50);
		backgroundPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setMargin(new Insets(0, 20, 0, 0));
		textField_5.setColumns(10);
		textField_5.setBounds(845, 352, 140, 50);
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setMargin(new Insets(0, 20, 0, 0));
		textField_6.setColumns(10);
		textField_6.setBounds(985, 352, 145, 50);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setMargin(new Insets(0, 20, 0, 0));
		textField_7.setColumns(10);
		textField_7.setBounds(540, 402, 140, 50);
		backgroundPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setMargin(new Insets(0, 20, 0, 0));
		textField_8.setColumns(10);
		textField_8.setBounds(680, 402, 165, 50);
		backgroundPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setMargin(new Insets(0, 20, 0, 0));
		textField_9.setColumns(10);
		textField_9.setBounds(845, 402, 140, 50);
		backgroundPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setMargin(new Insets(0, 20, 0, 0));
		textField_10.setColumns(10);
		textField_10.setBounds(985, 402, 145, 50);
		backgroundPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setMargin(new Insets(0, 20, 0, 0));
		textField_11.setColumns(10);
		textField_11.setBounds(540, 452, 140, 50);
		backgroundPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setMargin(new Insets(0, 20, 0, 0));
		textField_12.setColumns(10);
		textField_12.setBounds(680, 452, 165, 50);
		backgroundPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setMargin(new Insets(0, 20, 0, 0));
		textField_13.setColumns(10);
		textField_13.setBounds(845, 452, 140, 50);
		backgroundPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setMargin(new Insets(0, 20, 0, 0));
		textField_14.setColumns(10);
		textField_14.setBounds(985, 452, 145, 50);
		backgroundPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setMargin(new Insets(0, 20, 0, 0));
		textField_15.setColumns(10);
		textField_15.setBounds(540, 502, 140, 50);
		backgroundPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setMargin(new Insets(0, 20, 0, 0));
		textField_16.setColumns(10);
		textField_16.setBounds(680, 502, 165, 50);
		backgroundPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setMargin(new Insets(0, 20, 0, 0));
		textField_17.setColumns(10);
		textField_17.setBounds(845, 502, 140, 50);
		backgroundPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setMargin(new Insets(0, 20, 0, 0));
		textField_18.setColumns(10);
		textField_18.setBounds(985, 502, 145, 50);
		backgroundPanel.add(textField_18);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(1130, 302, 20, 250);
		backgroundPanel.add(scrollBar);
		
		label = new JLabel("欢迎您，张三");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
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


