package presentation.clientUI_account;

import java.awt.Color;
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
import java.awt.SystemColor;

public class client_account extends JFrame
{

	private JPanel contentPane;
	private JTextField id;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField name;
	private JTextField txtIdentity;
	private JTextField txtTel;
	private JTextField txtCredit;
	private JTextField txtClientType;
	private JTextField txtCompanyName;
	private JTextField txtCompanyAddress;
	private JTextField identity;
	private JTextField tel;
	private JTextField credit;
	private JTextField clientType;
	private JTextField companyName;
	private JTextField companyAddress;
	private JTextField txtSex;
	private JTextField sex;
	private JTextField txtVIPGrade;
	private JTextField txtBirthday;
	private JTextField vipGrade;
	private JTextField birthday;

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
					client_account frame = new client_account();
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
	public client_account()
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
		
		JLabel accountLabel = new JLabel("我的账户");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtId = new JTextField();
		txtId.setForeground(Color.WHITE);
		txtId.setBackground(SystemColor.activeCaption);
		txtId.setText("ID");
		txtId.setBounds(400, 140, 200, 50);
		txtId.setColumns(10);
		txtId.setMargin(new Insets(0, 20, 0, 0));
		txtId.setEditable(false);
		txtId.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtId);
		
		txtName = new JTextField();
		txtName.setForeground(Color.WHITE);
		txtName.setBackground(SystemColor.activeCaption);
		txtName.setText("姓名");
		txtName.setColumns(10);
		txtName.setBounds(400, 190, 200, 50);
		txtName.setMargin(new Insets(0, 20, 0, 0));
		txtName.setEditable(false);
		txtName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtName);
		
		txtIdentity = new JTextField();
		txtIdentity.setForeground(Color.WHITE);
		txtIdentity.setBackground(SystemColor.activeCaption);
		txtIdentity.setText("身份证号");
		txtIdentity.setColumns(10);
		txtIdentity.setBounds(400, 290, 200, 50);
		txtIdentity.setMargin(new Insets(0, 20, 0, 0));
		txtIdentity.setEditable(false);
		txtIdentity.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtIdentity);
		
		txtTel = new JTextField();
		txtTel.setForeground(Color.WHITE);
		txtTel.setBackground(SystemColor.activeCaption);
		txtTel.setText("联系方式");
		txtTel.setColumns(10);
		txtTel.setBounds(400, 340, 200, 50);
		txtTel.setMargin(new Insets(0, 20, 0, 0));
		txtTel.setEditable(false);
		txtTel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtTel);
		
		txtCredit = new JTextField();
		txtCredit.setForeground(Color.WHITE);
		txtCredit.setBackground(SystemColor.activeCaption);
		txtCredit.setText("信用值");
		txtCredit.setColumns(10);
		txtCredit.setBounds(400, 390, 200, 50);
		txtCredit.setMargin(new Insets(0, 20, 0, 0));
		txtCredit.setEditable(false);
		txtCredit.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCredit);
		
		txtClientType = new JTextField();
		txtClientType.setForeground(Color.WHITE);
		txtClientType.setBackground(SystemColor.activeCaption);
		txtClientType.setText("客户类型");
		txtClientType.setColumns(10);
		txtClientType.setBounds(400, 440, 200, 50);
		txtClientType.setMargin(new Insets(0, 20, 0, 0));
		txtClientType.setEditable(false);
		txtClientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtClientType);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setForeground(Color.WHITE);
		txtCompanyName.setBackground(SystemColor.activeCaption);
		txtCompanyName.setText("企业名称");
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(400, 589, 200, 50);
		txtCompanyName.setMargin(new Insets(0, 20, 0, 0));
		txtCompanyName.setEditable(false);
		txtCompanyName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCompanyName);
		
		txtCompanyAddress = new JTextField();
		txtCompanyAddress.setForeground(Color.WHITE);
		txtCompanyAddress.setBackground(SystemColor.activeCaption);
		txtCompanyAddress.setText("企业地址");
		txtCompanyAddress.setColumns(10);
		txtCompanyAddress.setBounds(400, 639, 200, 50);
		txtCompanyAddress.setMargin(new Insets(0, 20, 0, 0));
		txtCompanyAddress.setEditable(false);
		txtCompanyAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCompanyAddress);
		
		id = new JTextField();
		id.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		id.setBounds(600, 590, 500, 50);
		id.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		name.setColumns(10);
		name.setBounds(600, 640, 500, 50);
		name.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(name);
		
		identity = new JTextField();
		identity.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		identity.setColumns(10);
		identity.setBounds(600, 140, 500, 50);
		identity.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(identity);
		
		tel = new JTextField();
		tel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		tel.setColumns(10);
		tel.setBounds(600, 190, 500, 50);
		tel.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(tel);
		
		credit = new JTextField();
		credit.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		credit.setColumns(10);
		credit.setBounds(600, 290, 500, 50);
		credit.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(credit);
		
		clientType = new JTextField();
		clientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		clientType.setColumns(10);
		clientType.setBounds(600, 340, 500, 50);
		clientType.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(clientType);
		
		companyName = new JTextField();
		companyName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		companyName.setColumns(10);
		companyName.setBounds(600, 390, 500, 50);
		companyName.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(companyName);
		
		companyAddress = new JTextField();
		companyAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		companyAddress.setColumns(10);
		companyAddress.setBounds(600, 440, 500, 50);
		companyAddress.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(companyAddress);
		
		JButton modifyButton = new JButton(new ImageIcon("modify.jpg"));
		modifyButton.setBounds(400, 702, 165, 50);
		backgroundPanel.add(modifyButton);
		
		JButton returnButton = new JButton(new ImageIcon("return.jpg"));
		returnButton.setBounds(985, 702, 165, 50);
		backgroundPanel.add(returnButton);
		
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		backgroundPanel.add(headPanel);
		headPanel.setBorder(null);
		
		JLabel welcomeLabel = new JLabel("欢迎您，张三");
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 26));
		
		txtSex = new JTextField();
		txtSex.setText("性别");
		txtSex.setMargin(new Insets(0, 20, 0, 0));
		txtSex.setForeground(Color.WHITE);
		txtSex.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtSex.setEditable(false);
		txtSex.setColumns(10);
		txtSex.setBackground(SystemColor.activeCaption);
		txtSex.setBounds(400, 240, 200, 50);
		backgroundPanel.add(txtSex);
		
		sex = new JTextField();
		sex.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		sex.setMargin(new Insets(0, 20, 0, 20));
		sex.setColumns(10);
		sex.setBounds(600, 240, 500, 50);
		backgroundPanel.add(sex);
		
		txtVIPGrade = new JTextField();
		txtVIPGrade.setText("VIP等级");
		txtVIPGrade.setMargin(new Insets(0, 20, 0, 0));
		txtVIPGrade.setForeground(Color.WHITE);
		txtVIPGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtVIPGrade.setEditable(false);
		txtVIPGrade.setColumns(10);
		txtVIPGrade.setBackground(SystemColor.activeCaption);
		txtVIPGrade.setBounds(400, 490, 200, 50);
		backgroundPanel.add(txtVIPGrade);
		
		txtBirthday = new JTextField();
		txtBirthday.setText("出生日期");
		txtBirthday.setMargin(new Insets(0, 20, 0, 0));
		txtBirthday.setForeground(Color.WHITE);
		txtBirthday.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtBirthday.setEditable(false);
		txtBirthday.setColumns(10);
		txtBirthday.setBackground(SystemColor.activeCaption);
		txtBirthday.setBounds(400, 540, 200, 50);
		backgroundPanel.add(txtBirthday);
		
		vipGrade = new JTextField();
		vipGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		vipGrade.setMargin(new Insets(0, 20, 0, 20));
		vipGrade.setColumns(10);
		vipGrade.setBounds(600, 490, 500, 50);
		backgroundPanel.add(vipGrade);
		
		birthday = new JTextField();
		birthday.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		birthday.setMargin(new Insets(0, 20, 0, 20));
		birthday.setColumns(10);
		birthday.setBounds(600, 540, 500, 50);
		backgroundPanel.add(birthday);
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


