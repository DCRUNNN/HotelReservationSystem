package presentation.clientUI_membership;

/*
 * 
 * 客户查看&修改个人信息界面

 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import com.sun.org.apache.regexp.internal.recompile;

import po.ClientPO;
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
import presentation.clientUI_order.ManagePersonalOrderUIController;
import presentation.clientUI_order.showAllOrdersUI;
import runner.ClientRunner;
import vo.ClientVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class memberUI extends JFrame
{

	/**
	 * 
	 */
	
	private ApplyforMemberUIController controller;
	
	private String clientID;
	
	private ClientVO clientVO;
	
	private JTextField txtRegisterType;
	private JTextField txtHotelCooperation;
	private JTextField txtCompanyAddress;
	private JTextField holtelCooperation;
	private JTextField companyAddress;
	private JTextField txtVIPGrade;
	private JTextField txtBirthday;
	private JTextField vipGrade;
	private JTextField birthday;
	
	private JButton accountButton;
	private JButton orderButton;
	private JButton hotelButton;
	private JButton creditButton;
	private JButton memberButton;
	private JButton applyButton;
	
	private JPanel contentPane;
	private JPanel backgroundPanel;
	private JPanel headPanel;
	
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
	private String strHotelID;
	private String strAddress;
	private JTextField txtClientType;
	private JTextField clientType;
	
	private DateChooserJButton dateChooserButton;
	
	private int pageFlag = 0;//记录按钮点击状态
	private JButton returnMainUIButton;
	
	/**
	 * Create the frame.
	 */
	public memberUI(ApplyforMemberUIController controller)
	{
		this.controller = controller;
		clientID = controller.getClientID();
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		//setVisible(true);
		
		Image head = new ImageIcon("client.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backgroundPanel = new BackgroundPanel(background3);
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
		
		accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		backgroundPanel.add(accountButton);
		accountButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.accountButtonClicked();
				
			}
		});
		
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
		
		accountLabel = new JLabel("会员注册");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtRegisterType = new JTextField();
		txtRegisterType.setForeground(Color.WHITE);
		txtRegisterType.setBackground(SystemColor.activeCaption);
		txtRegisterType.setText("\u6CE8\u518C\u7C7B\u578B");
		txtRegisterType.setColumns(10);
		txtRegisterType.setBounds(400, 140, 200, 50);
		txtRegisterType.setMargin(new Insets(0, 20, 0, 0));
		txtRegisterType.setEditable(false);
		txtRegisterType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRegisterType);
		
		txtHotelCooperation = new JTextField();
		txtHotelCooperation.setForeground(Color.WHITE);
		txtHotelCooperation.setBackground(SystemColor.activeCaption);
		txtHotelCooperation.setText("合作酒店");
		txtHotelCooperation.setColumns(10);
		txtHotelCooperation.setBounds(400, 499, 200, 50);
		txtHotelCooperation.setMargin(new Insets(0, 20, 0, 0));
		txtHotelCooperation.setEditable(false);
		txtHotelCooperation.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelCooperation);
		
		txtCompanyAddress = new JTextField();
		txtCompanyAddress.setForeground(Color.WHITE);
		txtCompanyAddress.setBackground(SystemColor.activeCaption);
		txtCompanyAddress.setText("企业地址");
		txtCompanyAddress.setColumns(10);
		txtCompanyAddress.setBounds(400, 569, 200, 50);
		txtCompanyAddress.setMargin(new Insets(0, 20, 0, 0));
		txtCompanyAddress.setEditable(false);
		txtCompanyAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCompanyAddress);
		
		holtelCooperation = new JTextField();
		holtelCooperation.setBackground(Color.WHITE);
		holtelCooperation.setEditable(false);
		holtelCooperation.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		holtelCooperation.setColumns(10);
		holtelCooperation.setBounds(600, 499, 500, 50);
		holtelCooperation.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(holtelCooperation);
		
		companyAddress = new JTextField();
		companyAddress.setBackground(Color.WHITE);
		companyAddress.setEditable(false);
		companyAddress.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		companyAddress.setColumns(10);
		companyAddress.setBounds(600, 570, 500, 50);
		companyAddress.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(companyAddress);
		
		applyButton = new JButton(new ImageIcon("apply.jpg"));
		applyButton.setBounds(935, 653, 165, 50);
		
		backgroundPanel.add(applyButton);
		applyButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.applyButtonClicked();
			}
		});
		/*
		headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		backgroundPanel.add(headPanel);
		headPanel.setBorder(null);
		*/
		
		JLabel headPicture = new JLabel();
		headPicture.setBorder(BorderFactory.createEtchedBorder());
		headPicture.setBounds(71, 90, 170, 170);
		
		Icon icon = controller.getHeadIcon();
		headPicture.setIcon(icon);
		backgroundPanel.add(headPicture);
		
		dateChooserButton = new DateChooserJButton();
		dateChooserButton.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		dateChooserButton.setBackground(Color.WHITE);
		dateChooserButton.setBounds(850, 429, 250, 50);
		backgroundPanel.add(dateChooserButton);
		dateChooserButton.setVisible(false);
		
		welcomeLabel = new JLabel();
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		String labelstr = "欢迎您，"+clientID;
		welcomeLabel.setText(labelstr);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 18));
		
		txtVIPGrade = new JTextField();
		txtVIPGrade.setText("会员等级");
		txtVIPGrade.setMargin(new Insets(0, 20, 0, 0));
		txtVIPGrade.setForeground(Color.WHITE);
		txtVIPGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtVIPGrade.setEditable(false);
		txtVIPGrade.setColumns(10);
		txtVIPGrade.setBackground(SystemColor.activeCaption);
		txtVIPGrade.setBounds(400, 290, 200, 50);
		backgroundPanel.add(txtVIPGrade);
		
		txtBirthday = new JTextField();
		txtBirthday.setText("出生日期");
		txtBirthday.setMargin(new Insets(0, 20, 0, 0));
		txtBirthday.setForeground(Color.WHITE);
		txtBirthday.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtBirthday.setEditable(false);
		txtBirthday.setColumns(10);
		txtBirthday.setBackground(SystemColor.activeCaption);
		txtBirthday.setBounds(400, 429, 200, 50);
		backgroundPanel.add(txtBirthday);
		
		vipGrade = new JTextField();
		vipGrade.setBackground(Color.WHITE);
		vipGrade.setEditable(false);
		vipGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		vipGrade.setMargin(new Insets(0, 20, 0, 20));
		vipGrade.setColumns(10);
		vipGrade.setBounds(600, 290, 500, 50);
		backgroundPanel.add(vipGrade);
		
		birthday = new JTextField();
		birthday.setBackground(Color.WHITE);
		birthday.setEditable(false);
		birthday.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		birthday.setMargin(new Insets(0, 20, 0, 20));
		birthday.setColumns(10);
		birthday.setBounds(600, 429, 500, 50);
		backgroundPanel.add(birthday);
		
		try
		{
			clientVO = controller.getClientVO(clientID);
			strName = clientVO.getName();
			strSex = clientVO.getSex();
			strIdentity = clientVO.getIdentityID();
			strTel = clientVO.getPhoneNumber();
			strCredit = String.valueOf(clientVO.getCredit_point());//信用点保留方式
			strClientType = clientVO.getClientType();
			strGrade = String.valueOf(clientVO.getVipGrade());
			strBirthday = clientVO.getBirthday();
			strHotelID = clientVO.getHotelIDS();
			strAddress = clientVO.getCompanyAddress();
			
			if(strBirthday.equals("null"))
			{
				strBirthday = "";
			}
			if(strHotelID.equals("null"))
			{
				strHotelID = "";
			}
			if(strAddress.equals("null"))
			{
				strAddress = "";
			}
			
			//String 
		} catch (RemoteException e)
		{
			e.printStackTrace();
		}
		vipGrade.setText(strGrade);
		birthday.setText(strBirthday);
		holtelCooperation.setText(strHotelID);
		companyAddress.setText(strAddress);
		
		JButton commonMemberButton = new JButton(new ImageIcon("commonMember.jpg"));
		commonMemberButton.setBounds(652, 140, 165, 50);
		backgroundPanel.add(commonMemberButton);
		commonMemberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(strClientType.equals("普通客户")||strClientType.equals("企业会员"))
				{
					controller.commomMemberButtonClicked();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "您已是普通会员，无需再次申请","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton companyMemberButton = new JButton(new ImageIcon("companyMember.jpg"));
		companyMemberButton.setBounds(878, 140, 165, 50);
		backgroundPanel.add(companyMemberButton);
		companyMemberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.companyMemberButtonClicked();
			}
		});
		
		JLabel label = new JLabel("\u4FE1\u606F\u586B\u5199");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		label.setBounds(400, 366, 202, 50);
		backgroundPanel.add(label);
		
		txtClientType = new JTextField();
		txtClientType.setText("\u5BA2\u6237\u7C7B\u578B");
		txtClientType.setMargin(new Insets(0, 20, 0, 0));
		txtClientType.setForeground(Color.WHITE);
		txtClientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtClientType.setEditable(false);
		txtClientType.setColumns(10);
		txtClientType.setBackground(SystemColor.activeCaption);
		txtClientType.setBounds(400, 220, 200, 50);
		backgroundPanel.add(txtClientType);
		
		clientType = new JTextField();
		clientType.setText(strClientType);
		clientType.setMargin(new Insets(0, 20, 0, 20));
		clientType.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		clientType.setEditable(false);
		clientType.setColumns(10);
		clientType.setBackground(Color.WHITE);
		clientType.setBounds(600, 220, 500, 50);
		backgroundPanel.add(clientType);
		
		returnMainUIButton = new JButton(new ImageIcon("returnMainUI.jpg"));
		returnMainUIButton.setBounds(70, 330, 170, 60);
		backgroundPanel.add(returnMainUIButton);
		
		memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		backgroundPanel.add(memberButton);
		returnMainUIButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				controller.returnMainUIButtonClicked();
			}
		});
		
	
	}
	
	/*
	
	public void saveButtonClicked()
	{
		saveButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
					try
					{
						if(controller.changeClientMessage(clientID))
						{
							name.setEditable(false);
							name.setBackground(Color.white);
							sex.setEditable(false);
							sex.setBackground(Color.white);
							tel.setEditable(false);
							tel.setBackground(Color.white);
							identity.setEditable(false);
							identity.setBackground(Color.white);
							String namestr = name.getText();
							String sexstr = sex.getText();
							String telstr = tel.getText();
							String identitystr = identity.getText();
							successDialog dialog = new successDialog();
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
							name.setText(namestr);
							sex.setText(sexstr);
							identity.setText(identitystr);
							tel.setText(telstr);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "鏃犱慨鏀瑰唴瀹癸紒","", JOptionPane.ERROR_MESSAGE);
						}
					} catch (RemoteException e1)
					{
						e1.printStackTrace();
					} catch (SecurityException e1)
					{
						e1.printStackTrace();
					}
				
				
				
				name.setEditable(false);
				name.setBackground(Color.white);
				sex.setEditable(false);
				sex.setBackground(Color.white);
				tel.setEditable(false);
				tel.setBackground(Color.white);
				identity.setEditable(false);
				identity.setBackground(Color.white);
				String namestr = name.getText();
				String sexstr = sex.getText();
				String telstr = tel.getText();
				String identitystr = identity.getText();
				successDialog dialog = new successDialog();
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				name.setText(namestr);
				sex.setText(sexstr);
				identity.setText(identitystr);
				tel.setText(telstr);
				
			}
		});
	}

	*/
	
	
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
	
	public void accountButtonClicked()
	{
		ManageClientMessageUIController manageClientMessageUIController = new ManageClientMessageUIController(clientID);
		accountUI accountView = new accountUI(manageClientMessageUIController);
		manageClientMessageUIController.setView(accountView);
		this.dispose();
	}
	
	public void commonMemberButtonClicked()
	{
		if(pageFlag == 0)
		{
			pageFlag = 1;
			birthday.setText("请选择日期：");
			birthday.setBounds(600, 429, 250, 50);
			dateChooserButton.setVisible(true);
		}
	}
	
	public void companyMemberButtonClicked()
	{
		if(pageFlag == 0)
		{
			pageFlag = 2;
			holtelCooperation.setText("");
			holtelCooperation.setEditable(true);
			holtelCooperation.setBackground(new Color(220, 220, 220));
			//companyAddress.setEditable(true);
			//companyAddress.setBackground(new Color(220, 220, 220));
			if(companyAddress.getText().equals("")){
				companyAddress.setEditable(true);
				companyAddress.setBackground(new Color(220, 220, 220));
			}
		}
	}
	
	public void applyButtonClicked()
	{
		
		if(pageFlag == 1)
		{
			String date = dateChooserButton.getText();
			strBirthday = date.substring(5, 10);
			birthday.setText(date);
			birthday.setBounds(600, 429, 500, 50);
			
			try
			{
				controller.applyNormalVip(clientID, strBirthday);
				
				JOptionPane.showMessageDialog(null, "申请会员成功！");
				accountButtonClicked();
			} catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
		
		if(pageFlag == 2)
		{
			if(!isNumeric(holtelCooperation.getText().trim()))
			{
				JOptionPane.showMessageDialog(null, "合作酒店ID不全为数字，请确认后重新输入 ","", JOptionPane.ERROR_MESSAGE);
			}
			else if(holtelCooperation.getText().trim().length()!=5)
			{
				JOptionPane.showMessageDialog(null, "合作酒店ID不为5位，请确认后重新输入","", JOptionPane.ERROR_MESSAGE);
			}
			else if(companyAddress.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "企业地址不能为空，请确认后重新输入 ","", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				holtelCooperation.setEditable(false);
				holtelCooperation.setBackground(Color.white);
				companyAddress.setEditable(false);
				companyAddress.setBackground(Color.white);
				strHotelID = holtelCooperation.getText().trim();
				strAddress = companyAddress.getText().trim();
				try
				{
					controller.applyBusinessVip(clientID, strAddress, strHotelID);
					
					JOptionPane.showMessageDialog(null, "申请会员成功！");
					accountButtonClicked();
				} catch (RemoteException e)
				{
					e.printStackTrace();
				}
			}
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
	
	public void returnMainUIButtonClicked()
	{
		MainUIController mainUIController = new MainUIController(clientID);
		mainUI mainUI = new mainUI(mainUIController);
		mainUIController.setView(mainUI);
		this.dispose();
	}
}

