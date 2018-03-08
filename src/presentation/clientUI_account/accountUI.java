package presentation.clientUI_account;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import presentation.clientUI_credit.CheckPersonalCreditUIController;
import presentation.clientUI_credit.creditUI;
import presentation.clientUI_hotel.CheckHistoryHotelUIController;
import presentation.clientUI_hotel.showAllHotelsUI;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.memberUI;
import presentation.clientUI_order.ManagePersonalOrderUIController;
import presentation.clientUI_order.showAllOrdersUI;
import presentation.help.ClientPicture;
import presentation.help.HotelPicture;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.JPGFileFliter;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.PNGFileFliter;
import vo.ClientVO;

@SuppressWarnings("serial")
public class accountUI extends JFrame
{

	/**
	 * 
	 */
	
	ManageClientMessageUIController controller;
	
	private String clientID;
	
	private ClientVO clientVO;
	
	private JPanel contentPane;
	
	private JTextField id;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField name;
	private JTextField txtIdentity;
	private JTextField txtTel;
	private JTextField txtCredit;
	private JTextField txtClientType;
	private JTextField txtHotelCooperation;
	private JTextField txtCompanyAddress;
	private JTextField identity;
	private JTextField tel;
	private JTextField credit;
	private JTextField clientType;
	private JTextField holtelCooperation;
	private JTextField companyAddress;
	private JTextField txtSex;
	private JTextField sex;
	private JTextField txtVIPGrade;
	private JTextField txtBirthday;
	private JTextField vipGrade;
	private JTextField birthday;
	
	private JButton accountButton;
	private JButton orderButton;
	private JButton hotelButton;
	private JButton creditButton;
	private JButton memberButton;
	private JButton modifyButton;
	private JButton saveButton;
	
	private JPanel backgroundPanel;
	
	private JLabel headPicture;
	private JLabel accountLabel;
	private JLabel welcomeLabel;
	
	private String strName;
	private String strSex;
	private String strIdentity;
	private String strTel;
	private String strCredit;
	private String strClientType;
	private String strGrade;
	private String strBirthday;
	private String strHotel;
	private String strAddress;
	
	private JLabel titleLbl;
	
	private JLabel picLabel;
	
	private int currentStatement = 0;//用来记录当前界面的状态
	private JButton close;
	
	private File picFile;
	private String picPath;
	
	private ImageIcon icon;
	private byte[] picByte;
	
	
	
	public static void main(String[] args){
		String clientID="0000001";
		ManageClientMessageUIController controller=new ManageClientMessageUIController(clientID);
		accountUI UI=new accountUI(controller);
		controller.setView(UI);
		UI.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public accountUI(ManageClientMessageUIController controller)
	{
		this.controller = controller;
		clientID = controller.getClientID();
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		ImageIcon head = new ImageIcon("client.jpg");
		Image background = new ImageIcon("background3.jpg").getImage();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backgroundPanel = new BackgroundPanel(background);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		MouseEventListener mouseListener = new MouseEventListener(this);
		
		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		backgroundPanel.add(accountButton);
		
		orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(70, 470, 170, 60);
		backgroundPanel.add(orderButton);
		orderButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.orderButtonClicked();
				
			}
		});
		
		hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(70, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		hotelButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.hotelButtonClicked();
				
			}
		});
		
		creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(70, 610, 170, 60);
		backgroundPanel.add(creditButton);
		creditButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.creditButtonClicked();
				
			}
		});
		
		memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		backgroundPanel.add(memberButton);
		memberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.memberButtonClicked();
				
			}
		});
		
		accountLabel = new JLabel("我的账户");
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
		
		txtHotelCooperation = new JTextField();
		txtHotelCooperation.setForeground(Color.WHITE);
		txtHotelCooperation.setBackground(SystemColor.activeCaption);
		txtHotelCooperation.setText("合作酒店");
		txtHotelCooperation.setColumns(10);
		txtHotelCooperation.setBounds(400, 590, 200, 50);
		txtHotelCooperation.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCooperation.setEditable(false);
		txtHotelCooperation.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelCooperation);
		
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
		id.setBackground(Color.WHITE);
		id.setEditable(false);
		id.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		id.setBounds(600, 140, 500, 50);
		id.setMargin(new Insets(0, 20, 0, 20));
		id.setText(clientID);
		backgroundPanel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBackground(Color.white);
		name.setEditable(false);
		name.setFont(new Font("宋体", Font.BOLD, 20));
		name.setColumns(10);
		name.setBounds(600, 190, 500, 50);
		name.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(name);
		
		identity = new JTextField();
		identity.setBackground(Color.WHITE);
		identity.setEditable(false);
		identity.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		identity.setColumns(10);
		identity.setBounds(600, 290, 500, 50);
		identity.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(identity);
		
		tel = new JTextField();
		tel.setBackground(Color.WHITE);
		tel.setEditable(false);
		tel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		tel.setColumns(10);
		tel.setBounds(600, 340, 500, 50);
		tel.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(tel);
		
		credit = new JTextField();
		credit.setBackground(Color.WHITE);
		credit.setEditable(false);
		credit.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		credit.setColumns(10);
		credit.setBounds(600, 390, 500, 50);
		credit.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(credit);
		
		clientType = new JTextField();
		clientType.setBackground(Color.WHITE);
		clientType.setEditable(false);
		clientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		clientType.setColumns(10);
		clientType.setBounds(600, 440, 500, 50);
		clientType.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(clientType);
		
		holtelCooperation = new JTextField();
		holtelCooperation.setBackground(Color.WHITE);
		holtelCooperation.setEditable(false);
		holtelCooperation.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		holtelCooperation.setColumns(10);
		holtelCooperation.setBounds(600, 590, 500, 50);
		holtelCooperation.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(holtelCooperation);
		
		companyAddress = new JTextField();
		companyAddress.setBackground(Color.WHITE);
		companyAddress.setEditable(false);
		companyAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		companyAddress.setColumns(10);
		companyAddress.setBounds(600, 640, 500, 50);
		companyAddress.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(companyAddress);
		
		headPicture = new JLabel();
		headPicture.setBorder(BorderFactory.createEtchedBorder());
		headPicture.setBounds(71, 90, 170, 170);
		boolean isExist = ClientPicture.isExist(clientID);
		if(isExist)
		{
			icon = new ImageIcon(ClientPicture.getLocalPicture(clientID));
		}
		else
		{
		//从服务器端get图片
			byte[] picByte = controller.getClientPicture(clientID);
			 
			if(picByte==null){
				//尚未设置图片 服务器端和客户端都没有图片 则显示默认图片
				icon=new ImageIcon("client.jpg");
			}
			else 
			{
				icon = new ImageIcon(ClientPicture.changeByteAndSave(picByte, clientID));
			}
		}
		icon = new ImageIcon(icon.getImage().getScaledInstance(headPicture.getWidth(), headPicture.getHeight(), Image.SCALE_DEFAULT));
		headPicture.setIcon(icon);
		
		backgroundPanel.add(headPicture);
		
		welcomeLabel = new JLabel();
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		String labelstr = "欢迎你，"+clientID;
		welcomeLabel.setText(labelstr);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		
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
		sex.setBackground(Color.WHITE);
		sex.setEditable(false);
		sex.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		sex.setMargin(new Insets(0, 20, 0, 20));
		sex.setColumns(10);
		sex.setBounds(600, 240, 500, 50);
		backgroundPanel.add(sex);
		
		txtVIPGrade = new JTextField();
		txtVIPGrade.setText("会员等级");
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
		vipGrade.setBackground(Color.WHITE);
		vipGrade.setEditable(false);
		vipGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		vipGrade.setMargin(new Insets(0, 20, 0, 20));
		vipGrade.setColumns(10);
		vipGrade.setBounds(600, 490, 500, 50);
		backgroundPanel.add(vipGrade);
		
		birthday = new JTextField();
		birthday.setBackground(Color.WHITE);
		birthday.setEditable(false);
		birthday.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		birthday.setMargin(new Insets(0, 20, 0, 20));
		birthday.setColumns(10);
		birthday.setBounds(600, 540, 500, 50);
		backgroundPanel.add(birthday);
		
		modifyButton = new JButton(new ImageIcon("modify.jpg"));
		modifyButton.setBounds(400, 702, 165, 50);
		modifyButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.modifyButtonClicked();
				
			}
		});
		backgroundPanel.add(modifyButton);
		
		saveButton = new JButton(new ImageIcon("save.jpg"));
		saveButton.setBounds(935, 702, 165, 50);
		saveButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.saveButtonClicked();
			}
		});
		backgroundPanel.add(saveButton);
		
		strName = "";
		strSex = "";
		strIdentity = "";
		strTel = "";
		strCredit = "";
		strClientType = "普通客户";
		strGrade = "";
		strBirthday = "";
		strHotel = "";
		strAddress = "";
		
		getMessage();
		
		name.setText(strName);
		sex.setText(strSex);
		identity.setText(strIdentity);
		tel.setText(strTel);
		credit.setText(strCredit);
		clientType.setText(strClientType);
		vipGrade.setText(strGrade);
		birthday.setText(strBirthday);
		holtelCooperation.setText(strHotel);
		companyAddress.setText(strAddress);
		
		JButton returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(70, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.returnMainUIButtonClicked();
			}
		});
		
		JButton modifyHeadButton = new JButton(new ImageIcon("modifyHead.jpg"));
		modifyHeadButton.setBounds(71, 260, 170, 25);
		backgroundPanel.add(modifyHeadButton);
		modifyHeadButton.addActionListener(new AddPictureListener());
		
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		backgroundPanel.add(closeLabel);
		
		close = new CircleButton("");
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
		
		
		if(strClientType.equals("普通客户"))
		{
			txtVIPGrade.setVisible(false);
			vipGrade.setVisible(false);
			txtBirthday.setVisible(false);
			birthday.setVisible(false);
			txtHotelCooperation.setVisible(false);
			holtelCooperation.setVisible(false);
			txtCompanyAddress.setVisible(false);
			companyAddress.setVisible(false);
		}
		else if(strClientType.equals("普通会员"))
		{
			txtHotelCooperation.setVisible(false);
			holtelCooperation.setVisible(false);
			txtCompanyAddress.setVisible(false);
			companyAddress.setVisible(false);
		}
		else if(strClientType.equals("企业会员"))
		{
			txtBirthday.setVisible(false);
			birthday.setVisible(false);
		}
	}
	
	public static boolean isNumeric(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	public void getMessage()
	{
		try
		{
			clientVO = controller.getClientVO(clientID);
			
			strName = clientVO.getName();
			strSex = clientVO.getSex();
			strIdentity = clientVO.getIdentityID();
			strTel = clientVO.getPhoneNumber();
				
			double creditAmount = clientVO.getCredit_point();
			DecimalFormat format = new DecimalFormat("#.0");
			strCredit = format.format(creditAmount);
				
			strClientType = clientVO.getClientType();
			strGrade = String.valueOf(clientVO.getVipGrade());
			strBirthday = clientVO.getBirthday();
			strHotel = clientVO.getHotelIDS();
			strAddress = clientVO.getCompanyAddress();
		} catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}

	public void modifyButtonClicked()
	{
		if(currentStatement == 0)
		{
			//name.setEditable(true);
			//name.setBackground(new Color(220, 220, 220));
			//sex.setEditable(true);
			//sex.setBackground(new Color(220, 220, 220));
			tel.setEditable(true);
			tel.setBackground(new Color(220, 220, 220));
			//identity.setEditable(true);
			//identity.setBackground(new Color(220, 220, 220));
			currentStatement = 1;
		}
	}
	
	public void saveButtonClicked()
	{
		try
		{
			if(currentStatement == 1)
			{
				//String namestr = name.getText().trim();
				//String sexstr = sex.getText().trim();
				String telstr = tel.getText().trim();
				//String identitystr = identity.getText().trim();
				
				if(!isNumeric(telstr))
				{
					JOptionPane.showMessageDialog(null, "输入的联系方式不全为数字，请确认后重新输入 ","", JOptionPane.ERROR_MESSAGE);
				}
				else if(telstr.length()!=11)
				{
					JOptionPane.showMessageDialog(null, "输入的联系方式不为11位，请确认后重新输入","", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					//name.setEditable(false);
					//name.setBackground(Color.white);
					//sex.setEditable(false);
					//sex.setBackground(Color.white);
					tel.setEditable(false);
					tel.setBackground(Color.white);
					//identity.setEditable(false);
					//identity.setBackground(Color.white);
					
					successDialog dialog = new successDialog();
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					//name.setText(namestr);
					//sex.setText(sexstr);
					//identity.setText(identitystr);
					tel.setText(telstr);
					
					//clientVO.setName(namestr);
					//clientVO.setSex(sexstr);
					clientVO.setPhoneNumber(telstr);
					//clientVO.setIdentityID(identitystr);
					controller.changeClientMessage(clientVO);
					
					//搞图片
					//boolean flag=false;
					//if(!(picByte==null)){
					//	flag=controller.uploadPicture(picByte, clientID);
					//	flag=controller.changeClientPicture(picByte, clientID);
					//}
					//if(true==flag){
					//	JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
					//}
					
					currentStatement = 0;
				}
				
			}
			else if(currentStatement == 0)
			{
				
			}
			else if(currentStatement == 2)
			{
				//搞图片
				boolean flag=false;
				if(!(picByte==null)){
					flag=controller.uploadPicture(picByte, clientID);
					flag=controller.changeClientPicture(picByte, clientID);
				}
				if(true==flag){
					JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				currentStatement = 0;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "无修改内容","", JOptionPane.ERROR_MESSAGE);
			}
		}  catch (RemoteException e)
		{
			e.printStackTrace();
		} catch (SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
	public void OrderButtonClicked()
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
	
	public void returnMainUIButtonClicked()
	{
		MainUIController mainUIController = new MainUIController(clientID);
		mainUI mainUI = new mainUI(mainUIController);
		mainUIController.setView(mainUI);
		this.dispose();
	}
	
	public void closeButtonClicked()
	{
		this.dispose();
	}
	
	/*
	static class FadeOut extends Thread {
        private accountUI wnd;
        public FadeOut(accountUI wnd) {
            this.wnd = wnd;
        }
        public void run() {
            try {
                for (int i = 100; i > 0; i--) {
                    Thread.sleep(100);
                    AWTUtilities.setWindowOpacity(wnd, i / 100f);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            wnd.setVisible(false);
        }
    }
	
	public static void main(String[] args) {
		String clientID = "0000001";
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
        accountView.setVisible(true);
        new FadeOut(accountView).start();
	}
	*/
	
	class AddPictureListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			/*
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setFileFilter(new PictureFileFliter());
			jfc.showDialog(new JLabel(), "选择");
			picFile = jfc.getSelectedFile();
			picPath = picFile.getAbsolutePath();
			ImageIcon icon = new ImageIcon(picPath);
			
			icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), getHeight()-25, Image.SCALE_DEFAULT));
			headPicture.setIcon(icon);
			*/
			
			currentStatement = 2;
			
			JFileChooser jfc=new JFileChooser();  
		    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);  
		    jfc.setFileFilter(new JPGFileFliter());
		    jfc.addChoosableFileFilter(new PNGFileFliter());
		    jfc.showDialog(new JLabel(), "选择");  
		    picFile=jfc.getSelectedFile();  
		   	picPath=picFile.getAbsolutePath();
		   	icon=new ImageIcon(picPath);
		   	//实现图片的缩放
			icon=new ImageIcon(icon.getImage().getScaledInstance(headPicture.getWidth(), headPicture.getHeight(), Image.SCALE_DEFAULT));
		   	headPicture.setIcon(icon);
		   	
		   	picByte = ClientPicture.changeFileToByte(picFile);
		}
	}
	
	public Icon getHeadIcon()
	{
		return icon;
	}
	
}


class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
    accountUI frame;
     
    public MouseEventListener(accountUI frame) {
      this.frame = frame;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * 鼠标在标题栏拖拽时，设置窗口的坐标位置
    * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
    */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point p = this.frame.getLocation();
      this.frame.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }




