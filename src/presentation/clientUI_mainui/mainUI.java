package presentation.clientUI_mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.ManageClientMessageUIController;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_account.accountUI;
import presentation.clientUI_book.bookUI;
import presentation.clientUI_credit.CheckPersonalCreditUIController;
import presentation.clientUI_credit.creditUI;
import presentation.clientUI_hotel.CheckHistoryHotelUIController;
import presentation.clientUI_hotel.showAllHotelsUI;
import presentation.clientUI_membership.ApplyforMemberUIController;
import presentation.clientUI_membership.DateChooserJButton;
import presentation.clientUI_membership.memberUI;
import presentation.clientUI_membership.DateChooserJButton.DateChooser;
import presentation.clientUI_order.ManagePersonalOrderUIController;
import presentation.clientUI_order.showAllOrdersUI;
import runner.ClientRunner;
import vo.SearchVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

public class mainUI extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainUIControllerService controller;
	
	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField checkInDate;
	private JTextField txtHotelName;
	private JTextField txtHotelGrade;
	private JTextField textField;
	private JTextField txtRoomType;
	private JTextField textField_2;
	private JTextField txtRoomAmount;

	private JComboBox<String> comboBox_province;
	private DefaultComboBoxModel<String> province_model;
	
	private JComboBox<String> comboBox_city;
	private DefaultComboBoxModel<String> city_model;
	
	private JComboBox<String> comboBox_CBD;
	private DefaultComboBoxModel<String> cbd_model;
	
	private JComboBox<String> comboBox_hotelGrade;
	private DefaultComboBoxModel<String> grade_model;

	private JButton accountButton;
	private JButton orderButton;
	private JButton hotelButton;
	private JButton creditButton;
	private JButton memberButton;
	private JButton searchButton;
	private JLabel welcomeLabel;
	
	private String welcomeStr;
	private String defaultHotelName = "(ѡ��)�Ƶ�����";
	private String defaultRoomType = "(ѡ��)��������";
	private String defaultRoomAmount = "(ѡ��)������Ŀ";
	
	private String clientID;
	private JButton dateChooserBT;
	
	/**
	 * Create the frame.
	 */
	
	public mainUI(MainUIControllerService controller)
	{
		
		this.controller = controller;
		clientID = controller.getClientID();
		this.initial();
	}
	
	public void initial()
	{
		//���ù���frame��һЩ����
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		//����Jpanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setLayout(null);
		
		//����ͼƬ
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		//��С����رհ�ť
		JLabel closeLabel = new JLabel("��");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("����", Font.BOLD, 25));
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
		minLabel.setFont(new Font("����", Font.BOLD, 25));
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
		
		//��������ק��label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		
		//�ͻ���ͷ��
		Image head = new ImageIcon("client.jpg").getImage();
		
	    accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		backgroundPanel.add(accountButton);
		accountButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
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
		
	    memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		backgroundPanel.add(memberButton);
		memberButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				controller.memberButtonClicked();
			}
		});
		
		//����button��ʼ��
		searchButton = new JButton(new ImageIcon("search.jpg"));
		searchButton.setBounds(980, 676, 170, 60);
		searchButton.addActionListener(new SearchListener());
		backgroundPanel.add(searchButton);
		
		//��ʾ��ҳ���label ���Ƶ�Ԥ����
		JLabel accountLabel = new JLabel("�Ƶ�Ԥ��");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);	
		
		//��ʾ��ҳ���textfield ��Ŀ�ĵء�
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("Ŀ�ĵ�");
		txtDestination.setBounds(400, 210, 200, 50);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		//��ʾ��ҳ���textfiled����ס���ڡ�
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("��ס����");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(400, 290, 200, 50);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		//��ʾ��ҳ���textfield���ؼ��ʡ�
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("�ؼ���");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(400, 450, 200, 50);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		//��ʾ��ҳ���textfield���Ƶ꼶��
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("�Ƶ꼶��");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(400, 370, 200, 50);
		backgroundPanel.add(txtHotelGrade);
		
		//��ʾ��ҳ���textfield���������͡�
		textField = new JTextField();
		textField.setText("\u5173\u952E\u8BCD");
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(400, 530, 200, 50);
		backgroundPanel.add(textField);
		
		//��ʾ��ҳ���textfield��������Ŀ��
		textField_2 = new JTextField();
		textField_2.setText("\u5173\u952E\u8BCD");
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(402, 610, 200, 50);
		backgroundPanel.add(textField_2);
		
		//����ͼƬ��ʼ��
		/*
		JPanel headPanel = new BackgroundPanel(head);
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
		
		//��ӭlabel��ʼ�� 
		initWelcomeStr();
		welcomeLabel = new JLabel(welcomeStr);
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 18));
		
		//�������textfield ��ס����
		/*
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//�õ���ǰ������
		checkInDate = new JTextField();
		checkInDate.setText(currentDate);
		checkInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(600, 290, 280, 50);
		checkInDate.addMouseListener(new MouseAdapter(){
			public void mouseExited(MouseEvent e){
				
				String date = checkInDate.getText();
				if(!checkDate(date)){
					JOptionPane.showMessageDialog(null, "�������ڸ�ʽ����ȷ","����",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		checkInDate.setMargin(new Insets(0, 60, 0, 20));
		
		backgroundPanel.add(checkInDate);
		*/
		
		dateChooserBT = new DateChooserJButton();
		dateChooserBT.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		dateChooserBT.setBackground(Color.WHITE);
		dateChooserBT.setBounds(600, 290, 280, 50);
		backgroundPanel.add(dateChooserBT);
		
		
		//�������textfield �Ƶ�����
		txtHotelName = new JTextField();
		Color defaultcolor = new Color(169,169,169);
		txtHotelName.setForeground(defaultcolor);
		txtHotelName.setText(defaultHotelName);
		txtHotelName.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(600, 450, 280, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 20));
		//���ϵ������
		txtHotelName.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			    String roomType = txtRoomType.getText();
			    if("".equals(roomType)||roomType==null){
			    	//û��������Ч�ķ�������
			    	txtRoomType.setText(defaultRoomType);
			    	txtRoomType.setForeground(defaultcolor);
			    }
			    if("".equals(txtRoomAmount.getText())||txtRoomAmount.getText()==null){
					//û��������Ч�ķ�����Ŀ
					txtRoomAmount.setText(defaultRoomAmount);
					txtRoomAmount.setForeground(defaultcolor);
				}
				txtHotelName.setText("");	
				txtHotelName.setForeground(Color.BLACK);
			}		
		});
		backgroundPanel.add(txtHotelName);
		
		//�������textfield ��������
		txtRoomType = new JTextField();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(0, 20, 0, 20));
		txtRoomType.setForeground(defaultcolor);
		txtRoomType.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(600, 530, 280, 50);
		//���ϵ������
		txtRoomType.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if("".equals(txtHotelName.getText())||txtHotelName.getText()==null){
					//û��������Ч�ľƵ�����
					txtHotelName.setText(defaultHotelName);
					txtHotelName.setForeground(defaultcolor);
				}
				if("".equals(txtRoomAmount.getText())||txtRoomAmount.getText()==null){
					//û��������Ч�ķ�����Ŀ
					txtRoomAmount.setText(defaultRoomAmount);
					txtRoomAmount.setForeground(defaultcolor);
				}
				txtRoomType.setText("");
				txtRoomType.setForeground(Color.BLACK);
			}
		});
		backgroundPanel.add(txtRoomType);
		
		//�������textfield ������Ŀ
		
		txtRoomAmount = new JTextField();
		txtRoomAmount.setText(defaultRoomAmount);
		txtRoomAmount.setMargin(new Insets(0, 20, 0, 20));
		txtRoomAmount.setForeground(defaultcolor);
		txtRoomAmount.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomAmount.setColumns(10);
		txtRoomAmount.setBounds(600, 610, 280, 50);
		//���ϵ������
		txtRoomAmount.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if("".equals(txtHotelName.getText())||txtHotelName.getText()==null){
					//û��������Ч�ľƵ�����
					txtHotelName.setText(defaultHotelName);
					txtHotelName.setForeground(defaultcolor);
				}
				if("".equals(txtRoomType.getText())||txtRoomType.getText()==null){
			    	//û��������Ч�ķ�������
			    	txtRoomType.setText(defaultRoomType);
			    	txtRoomType.setForeground(defaultcolor);
			    }
				txtRoomAmount.setText("");
				txtRoomAmount.setForeground(Color.BLACK);
			}
		});
		backgroundPanel.add(txtRoomAmount);
		
		//ʡ���������ʼ�� 
		initProvince_model();//��ʼ��ʡ��model
		comboBox_province = new JComboBox<String>(province_model);
		comboBox_province.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		comboBox_province.setBackground(Color.WHITE);
		comboBox_province.setBounds(600, 210, 140, 50);
		comboBox_province.addItemListener(new ProvinceListener());
		backgroundPanel.add(comboBox_province);
		
		String city[] = {"����"};
		city_model = new DefaultComboBoxModel<String>(city);//��ʼ��city_model
		
		//�����������ʼ��
		comboBox_city = new JComboBox<String>(city_model);
		comboBox_city.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		comboBox_city.setBackground(Color.WHITE);
		comboBox_city.setBounds(740, 210, 140, 50);
		comboBox_city.addItemListener(new CityListener());
		backgroundPanel.add(comboBox_city);
		
		String cbd[] = {"��Ȧ"};
		cbd_model = new DefaultComboBoxModel<String>(cbd);//��ʼ��cbd_model
		
		//��Ȧ�������ʼ��
		comboBox_CBD = new JComboBox<String>(cbd_model);
		comboBox_CBD.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		comboBox_CBD.setBackground(Color.WHITE);
		comboBox_CBD.setBounds(880, 210, 270, 50);
		backgroundPanel.add(comboBox_CBD);
		
		String grades[] = {
				"    ����","���Ǽ�/����","���Ǽ�/�ߵ�","���Ǽ�/����","���Ǽ�������/����"
		};
		grade_model = new DefaultComboBoxModel<String>(grades);//grade_model��ʼ��
		comboBox_hotelGrade = new JComboBox<String>(grade_model);
		comboBox_hotelGrade.setBackground(new Color(255, 255, 255));
		comboBox_hotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		comboBox_hotelGrade.setBounds(600, 370, 280, 50);
		backgroundPanel.add(comboBox_hotelGrade);
		
		JButton button = new JButton(new ImageIcon("returnMainUI.jpg"));
		button.setBounds(70, 330, 170, 60);
		backgroundPanel.add(button);
			
	}

	/**
	 * ��ʼ��ʡ��������
	 * */
	private void initProvince_model() {
		
		String provinces = controller.getProvinces();
		String show = "ʡ��"+"/"+provinces;
		String allProvinces[] = show.split("/");
		province_model = new DefaultComboBoxModel<String>(allProvinces);
	}

	/**
	 * ��ʼ����ӭ�ַ���
	 * */
	private void initWelcomeStr() {
		
		String name = controller.getClientName();
		welcomeStr = "��ӭ��! "+name;
	}

	public static void main(String args[]){
		
		new ClientRunner();
    	String clientID = "0000001";
    	MainUIController controller = new MainUIController(clientID);
    	mainUI ui = new mainUI(controller);	
    	controller.setUI(ui);
    	ui.setVisible(true);
	}
	
	/**
	 * ʡ���������Ӧ���¼��������ڲ���
	 * */
	private class ProvinceListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			controller.selectProvince();
		}
		
	}

	/**
	 * �ڽ����ڲ���ѡ��ʡ���¼���ʵ��
	 * */
	public void selectProvince() {
	    
		//ѡ���¼��ļ���
		int index = comboBox_province.getSelectedIndex();
		if(index!=0){
			//����Ĭ��ѡ��ֵ�Ļ�
			String province = (String) comboBox_province.getSelectedItem();
			initCity_model(province);
		}
	
	}
	
	/**
	 * ��city_model�����޸�
	 * */
	public void initCity_model(String province){
		
		String allCities = controller.getCities(province);
		String show = "����"+"/"+allCities;
		String city [] = show.split("/");
		city_model = new DefaultComboBoxModel<String>(city);
		comboBox_city.setModel(city_model);
	}
	
	/**
	 * �����������Ӧ�¼���Ӧ���ڲ���
	 * */
	private class CityListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
	
			controller.selectCity();
		}
		
	}

	/**
	 * �����ڲ���ѡ�г��еķ�����ʵ��
	 * */
	public void selectCity() {
		
		int index = comboBox_city.getSelectedIndex();
		if(index!=0){
			//����ѡ��Ĭ��ֵ
			String province = (String) comboBox_province.getSelectedItem();
			String city = (String)comboBox_city.getSelectedItem();
			initCBD_model(province,city);
		}
	}
	
	/**
	 * �ı���Ȧ������ķ���
	 * */
	public void initCBD_model(String province,String city){
		
		String cbds ="��Ȧ"+"/"+ controller.getCBDs(province,city);
	    cbd_model = new DefaultComboBoxModel<String>(cbds.split("/"));
	    comboBox_CBD.setModel(cbd_model);
	}
	
	/**
	 * �ж�����������Ƿ���ϸ�ʽ
	 * @param date ����
	 * @return ���ϸ�ʽ����true������Ϊfalse
	 * */
	public boolean checkDate (String date){
		
		String reg_yyyy_MM_dd = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))" +
                "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		if(date.matches(reg_yyyy_MM_dd)){
			return true;
		}
		return false;
	}
	
	/**
	 * ������ť��Ӧ���¼������ڲ���
	 * */
	private class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.searchButtonClicked();
		}
		
	}

	/**
	 * ʵ����������ť�ļ���
	 * */
	public void searchButtonClicked() {
	   
		int index_pro = comboBox_province.getSelectedIndex();
		int index_city = comboBox_city.getSelectedIndex();
		int index_cbd = comboBox_CBD.getSelectedIndex();
		if(index_pro==0){
			//û��ѡ��ʡ��
			JOptionPane.showMessageDialog(null, "��ѡ��Ԥ���Ƶ��ʡ��!","������˼",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		if(index_city==0){
			//û��ѡ�����
			JOptionPane.showMessageDialog(null, "��ѡ��Ԥ���Ƶ�ĳ���!","������˼",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		if(index_cbd==0){
			//û��ѡ����Ȧ
			JOptionPane.showMessageDialog(null, "��ѡ��Ԥ���Ƶ����Ȧ!","������˼",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		//String date = checkInDate.getText();
		String date = dateChooserBT.getText();
		
		if(!checkDate(date)){
			//����������ڽ��и�ʽ���
			JOptionPane.showMessageDialog(null, "��������ϸ�ʽ������!","������˼",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		
		int index_grade = comboBox_hotelGrade.getSelectedIndex();
		int minstar = -1;
		int maxstar = -1;
		if(1<=index_grade&&index_grade<=3){
			//ѡ������壬�ģ��������Ǽ�
			minstar = maxstar = 5-index_grade+1;
		}else if(index_grade==4){
			//ѡ��������Ǽ���������
			minstar = 1;
			maxstar = 2;
		}
		
		String hotelName = txtHotelName.getText().trim();
		if(hotelName.equals(defaultHotelName)){
			//�ͻ�û�н�������Ƶ�����
			hotelName = "";
		}
		
		String roomType = txtRoomType.getText().trim();
		if(roomType.equals(defaultRoomType)){
			//û�����뷿������
			roomType="";
		}
		
		int roomAmount = 1;
		String amount = txtRoomAmount.getText().trim();
		if(amount.matches("[0-9]*")){
			//����������
			if(!"".equals(amount)){
				roomAmount = Integer.valueOf(txtRoomAmount.getText());
			}
		}else if(!"".equals(amount)&&!defaultRoomAmount.equals(amount)){
			JOptionPane.showMessageDialog(null, "���������ָ�ʽ�ķ�����Ŀ��", "������˼",  JOptionPane.INFORMATION_MESSAGE);
		    return;
		    
		}
		
		String hotelProvince = comboBox_province.getItemAt(index_pro);
		String hotelCity = comboBox_city.getItemAt(index_city);
		String hotelCBD = comboBox_CBD.getItemAt(index_cbd);
		
		SearchVO searchvo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
	    
	    bookUI ui = new bookUI(hotelProvince,hotelCity,hotelCBD,controller.getClientID(),searchvo);
	    ui.setVisible(true);
	    this.dispose();
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
	
	public void creditButtonClicked()
	{
		CheckPersonalCreditUIController checkPersonalCreditUIController =new CheckPersonalCreditUIController(clientID);
		creditUI creditView = new creditUI(checkPersonalCreditUIController);
		checkPersonalCreditUIController.setView(creditView);
		this.dispose();
	}

}











