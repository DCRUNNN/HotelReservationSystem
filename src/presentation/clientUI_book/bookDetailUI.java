package presentation.clientUI_book;


/*
 * 
 * �ͻ����ж���Ԥ�������鿴�Ƶ��������ԭ��
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.help.HotelPicture;
import vo.HotelVO;
import vo.SearchVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class bookDetailUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextArea txtHotelName;
	
	private JButton searchButton;
	private JComboBox<String> comboBox_hotelGrade;
	private JButton lastPageButton;
	private JButton nextPageButton;

	private bookUI ui;
	private JTextComponent lowestPrice;
	private JButton otherButton;
	private JTextArea txtRoomAmount;
	private JTextArea txtRoomType;
	private JLabel pageLabel;
	private JLabel type_1;
	private JLabel client_1;
	private JLabel price_1;
	private JButton book_1;
	private JLabel type_2;
	private Component client_2;
	private JLabel price_2;
	private BackgroundPanel backgroundPanel;
	private Image room;
	private Image background4;
	
	private bookDetailUIControllerService controller;
	private HotelVO vo;
	private String clientID;
	
	private String[] roomTypes ;
	private int index =0;
	
	private String defaultHotelName = "(ѡ��)�Ƶ�����";
	private String defaultRoomType = "(ѡ��)��������";
	private String defaultRoomAmount = "(ѡ��)������Ŀ";
	private BackgroundPanel backgroundPanel_2;
	private BackgroundPanel backgroundPanel_1;
	private BackgroundPanel backgroundPanel_3;
	private BackgroundPanel backgroundPanel_4;
	private BackgroundPanel backgroundPanel_5;
	private JLabel type_3;
	private JLabel price_3;
	private JButton book_3;
	private JLabel type_4;
	private JLabel price_4;
	private JButton book_4;
	private JLabel type_5;
	private JLabel client_5;
	private JButton book_5;
	private JLabel price_5;
	
	private int current;
	private int total;
	private JPanel createOrderPanel;
	private JLabel totalPrice;
	private JLabel txtChosenRoom;
	private JPanel searchPanel;
	private JTextArea rooms;
	private JScrollPane scrollPane;
	private JButton resetButton;
	private JButton createButton;
	private JButton book_2;
	private JButton closeButton;
	
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public bookDetailUI(HotelVO vo,String clientID)
	{
		controller = new bookDetailUIController(vo.getHotelID(),clientID);
		controller.setView(this);
		this.clientID = clientID;
		this.vo = vo;
		roomTypes = vo.getRoomTypeAndPrice().split("/");//���еķ�������
		
		//����JFrame��һЩ����
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
	
		//JPanel ������
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���ñ���
		Image background3 = new ImageIcon("background3.jpg").getImage();
		backgroundPanel = new BackgroundPanel(background3);
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
		
		
		searchPanel = new JPanel();
		//searchPanel = new BackgroundPanel(new ImageIcon("backgroundLabel.jpg").getImage());
		searchPanel.setOpaque(false);
		//searchPanel.setBackground(null);
		//searchPanel.setForeground(new Color(0, 191, 255));
		searchPanel.setLayout(null);
		searchPanel.setBounds(71, 90, 202, 680);
		
		//com.sun.awt.AWTUtilities.setWindowOpaque(searchPanel, 0.3f);
		
		backgroundPanel.add(searchPanel);
		
		//��ʾ�ڽ������������ JLabel
		JLabel searchLabel = new JLabel("��������");
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setBounds(0, 0, 202, 50);
		searchLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 30));
		searchPanel.add(searchLabel);
		
		//��ʾ�ڽ���ġ�Ŀ�ĵء�����
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("Ŀ�ĵ�");
		txtDestination.setBounds(0, 80, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		searchPanel.add(txtDestination);
		
		//��ʾ��ҳ���ϵġ���ס���ڡ�����
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("��ס����");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(0, 195, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		searchPanel.add(txtCheckInDate);
		
		//��ʾ��ҳ���ϵġ��ؼ��ʡ�����
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("�ؼ���");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(0, 404, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		searchPanel.add(txtKeyWord);
		
		//
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		destination.setColumns(10);
		destination.setBounds(0, 120, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		destination.setText(vo.getHotelCity()+"/"+vo.getHotelCBD());
		searchPanel.add(destination);
		
		checkInDate = new JTextField();
		checkInDate.setEditable(true);
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText("2016-12-02");
		checkInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(0, 235, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		searchPanel.add(checkInDate);
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("�Ƶ꼶��");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(0, 298, 170, 40);
		searchPanel.add(txtHotelGrade);
		
		//�Ƶ��Ǽ�������
		comboBox_hotelGrade = new JComboBox<String>();
		comboBox_hotelGrade.setBackground(new Color(245, 255, 250));
		comboBox_hotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		String grades[] = {
				"    ����","���Ǽ�/����","���Ǽ�/�ߵ�","���Ǽ�/����","���Ǽ�������/����"
		};
		comboBox_hotelGrade.setModel(new DefaultComboBoxModel(grades));
		comboBox_hotelGrade.setBounds(0, 338, 170, 50);
		searchPanel.add(comboBox_hotelGrade);
		
		Color defaultcolor = new Color(192,192,192,192);
		//������ľƵ�����
		txtHotelName = new JTextArea();
		txtHotelName.setForeground(new Color(192, 192, 192));
		txtHotelName.setBackground(new Color(245, 255, 250));
		txtHotelName.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName.setLineWrap(true);
		txtHotelName.setText(defaultHotelName);
		txtHotelName.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelName.setBounds(0, 444, 170, 50);
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
		searchPanel.add(txtHotelName);
		
		//��һҳ��ť
		lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(360, 710, 170, 60);
		lastPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.lastPageButtonClicked();
			}
			
		});
		backgroundPanel.add(lastPageButton);
		
		//��һҳ��ť
		nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(975, 710, 170, 60);
		nextPageButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.nextPageButtonClicked();
			}
			
		});
		backgroundPanel.add(nextPageButton);
		
		//�������ʾ��ҳ���ϵľƵ����� ��Ҫ��������
		JTextArea hotelName = new JTextArea();
		hotelName.setEditable(false);
		hotelName.setText(vo.getHotelName());
		hotelName.setOpaque(false);
		hotelName.setMargin(new Insets(10, 10, 10, 10));
		hotelName.setForeground(new Color(25, 25, 112));
		hotelName.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 35));
		hotelName.setColumns(10);
		hotelName.setBackground(new Color(176, 224, 230));
		hotelName.setBounds(483, 50, 350, 50);
		backgroundPanel.add(hotelName);
		
		//��ʾ��ҳ���ϵľƵ��ַ ��Ҫ��������
		JTextArea hotelAddress = new JTextArea();
		hotelAddress.setEditable(false);
		hotelAddress.setText(vo.getHotelAddress());
		hotelAddress.setOpaque(false);
		hotelAddress.setMargin(new Insets(10, 10, 10, 10));
		hotelAddress.setForeground(new Color(0, 0, 128));
		hotelAddress.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		hotelAddress.setColumns(10);
		hotelAddress.setBounds(490, 101, 350, 40);
		backgroundPanel.add(hotelAddress);
		
		//��ʾ��ҳ���ϵġ����͡�����
		JLabel lblNewLabel = new JLabel("����");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		lblNewLabel.setBounds(490, 181, 100, 30);
		backgroundPanel.add(lblNewLabel);
		
		background4 = new ImageIcon("background4.jpg").getImage();
		
		//������Ƭ
		room = new ImageIcon("room.jpg").getImage();
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		String hotelID = vo.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			hotel = HotelPicture.getLocalPicture(hotelID);
		}
		//�����ھƵ�ͼƬ�Ļ�  ��ʹ��Ĭ�ϵ�ͼƬ��
		
		BackgroundPanel hotelPanel = new BackgroundPanel(hotel);
		hotelPanel.setBounds(360, 60, 120, 120);
		backgroundPanel.add(hotelPanel);
		
		//��ͼ۸� �������Ҫ�������õ�
		lowestPrice = new JTextArea();
		lowestPrice.setEditable(false);
		lowestPrice.setText("��"+String.valueOf(findMin(vo.getRoomTypeAndPrice())));
		lowestPrice.setOpaque(false);
		lowestPrice.setForeground(new Color(255, 99, 71));
		lowestPrice.setFont(new Font("����", Font.BOLD | Font.ITALIC, 40));
		lowestPrice.setBounds(975, 69, 144, 50);
		backgroundPanel.add(lowestPrice);
		
		//�����"��"����������Ҫ��������
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setEditable(false);
		textArea_14.setText("��");
		textArea_14.setOpaque(false);
		textArea_14.setMargin(new Insets(10, 10, 10, 10));
		textArea_14.setForeground(new Color(255, 69, 0));
		textArea_14.setFont(new Font("����", Font.BOLD | Font.ITALIC, 16));
		textArea_14.setColumns(10);
		textArea_14.setBounds(1105, 84, 40, 40);
		backgroundPanel.add(textArea_14);
		
		//��Ҫ��������ķ�������
		txtRoomType = new JTextArea();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(10, 10, 10, 10));
		txtRoomType.setLineWrap(true);
		txtRoomType.setForeground(Color.LIGHT_GRAY);
		txtRoomType.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomType.setBackground(new Color(245, 255, 250));
		txtRoomType.setBounds(0, 494, 170, 50);
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
		searchPanel.add(txtRoomType);
		
		//��Ҫ��������ķ�����Ŀ
		txtRoomAmount = new JTextArea();
		txtRoomAmount.setText(defaultRoomAmount);
		txtRoomAmount.setMargin(new Insets(10, 10, 10, 10));
		txtRoomAmount.setLineWrap(true);
		txtRoomAmount.setForeground(Color.LIGHT_GRAY);
		txtRoomAmount.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomAmount.setBackground(new Color(245, 255, 250));
		txtRoomAmount.setBounds(0, 545, 170, 50);
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
		searchPanel.add(txtRoomAmount);
		
		//������ť
		searchButton = new JButton(new ImageIcon("search.jpg"));
		searchButton.setBounds(0, 620, 170, 60);
		searchPanel.add(searchButton);
		
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.searchButtonClicked();
			}
			
		});
		
		//�����Ƶ�İ�ť
		otherButton = new JButton(new ImageIcon("search2.jpg"));
		otherButton.setBounds(975, 120, 170, 60);
		otherButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				bookDetailUI.this.dispose();
				ui.setVisible(true);
			}
			
		});
		backgroundPanel.add(otherButton);
		
		JLabel label = new JLabel("���ÿͻ�");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label.setBounds(670, 181, 100, 30);
		backgroundPanel.add(label);
		
		JLabel label_3 = new JLabel("�۸�");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_3.setBounds(900, 181, 100, 30);
		backgroundPanel.add(label_3);
		
		initFinePanels();
		
		initPageLabel();
		
		initCreateOrderPanel();
		
	}
	
	private void initCreateOrderPanel() {
		
		//�������ɶ�����panel
		//createOrderPanel = new JPanel();
		createOrderPanel = new BackgroundPanel(new ImageIcon("backgroundLabel.jpg").getImage());
		createOrderPanel.setBounds(0, 0, 317, 800);
		createOrderPanel.setForeground(Color.WHITE);
		createOrderPanel.setBackground(Color.WHITE);
		createOrderPanel.setVisible(false);
		
		//searchPanel.setVisible(false);
		backgroundPanel.add(createOrderPanel);
		createOrderPanel.setLayout(null);
		
		JLabel txtTotalPrice = new JLabel("\u5F53\u524D\u603B\u4EF7\u683C:");
		txtTotalPrice.setForeground(Color.black);
		txtTotalPrice.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtTotalPrice.setBounds(55, 70, 128, 38);
		createOrderPanel.add(txtTotalPrice);
		
		totalPrice = new JLabel();
		totalPrice.setHorizontalAlignment(SwingConstants.LEFT);
		totalPrice.setForeground(new Color(255, 99, 71));
		totalPrice.setBackground(new Color(255, 0, 0));
		totalPrice.setFont(new Font("����", Font.BOLD, 52));
		totalPrice.setBounds(55, 100, 250, 111);
		createOrderPanel.add(totalPrice);
		
		txtChosenRoom = new JLabel("��ѡ����:");
		txtChosenRoom.setForeground(Color.black);
		txtChosenRoom.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtChosenRoom.setBounds(55, 299, 128, 38);
		createOrderPanel.add(txtChosenRoom);
		
		rooms = new JTextArea();
		rooms.setForeground(new Color(255, 165, 0));
		rooms.setFont(new Font("����", Font.BOLD, 23));
		rooms.setEditable(false);
		rooms.setBounds(0,300,202,200);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(rooms);
		scrollPane.setAutoscrolls(true);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(55,350,220,200);
		
		createOrderPanel.add(scrollPane);
		
		
		JLabel closeLabel = new JLabel("��");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("����", Font.BOLD, 25));
		closeLabel.setBounds(270, 18, 26, 30);
		createOrderPanel.add(closeLabel);
		
		closeButton = new CircleButton("");
		closeButton.setBackground(new Color(135, 206, 235));
		closeButton.setBounds(263, 13, 40, 40);
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				totalPrice.setText("");
				rooms.setText("");
				createOrderPanel.setVisible(false);
				searchPanel.setVisible(true);
			}
			
		});
		createOrderPanel.add(closeButton);
		
		//����ѡ��ť
		resetButton = new JButton(new ImageIcon("rechoose.jpg"));
		resetButton.setBounds(75, 600, 170, 60);
		createOrderPanel.add(resetButton);
		
		//���ɶ�����ť
		createButton = new JButton(new ImageIcon("createOrder.jpg"));
		createButton.setBounds(75, 700, 170, 60);
		createOrderPanel.add(createButton);
		createButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.ceateButtonClicked();
			}
			
		});
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				totalPrice.setText("");
				rooms.setText("");
				//����һ��controller
				controller = new bookDetailUIController(vo.getHotelID(),clientID);
				controller.setView(bookDetailUI.this);
			}
			
		});
	}

	/**
	 *��ʼ����ʾ�����panel 
	 * */
	private void initFinePanels() {
		
		int total = roomTypes.length;
		switch(total){
		case 0:
		{
			initPanel1("");
			initPanel2("");
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		case 1:
		{
			initPanel1(roomTypes[index++]);
			initPanel2("");
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			//backgroundPanel_1.setVisible(false);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3("");
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 3:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4("");
			initPanel5("");
			
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		case 4:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4(roomTypes[index++]);
			initPanel5("");

			backgroundPanel_5.setVisible(false);
			
			break;
		}
		
		default:
		{
			initPanel1(roomTypes[index++]);
			initPanel2(roomTypes[index++]);
			initPanel3(roomTypes[index++]);
			initPanel4(roomTypes[index++]);
			initPanel5(roomTypes[index++]);

			break;
		}
		
	}
	}

	/**
	 * �ҳ��Ƶ����ͷ������͵ļ۸�
	 * @param roomTypeAndPrice �������ͺͼ۸�
	 * */
	private double findMin(String roomTypeAndPrice) {
		
		String types[] = roomTypeAndPrice.split("/");//�������ͺͼ۸������
		if(types.length==0){
			//����Ϊ0
			return 0;
		}else{
			double min = Double.valueOf(types[0].split("[|]")[1]);
			for(String str:types){
				if(Double.valueOf(str.split("[|]")[1])<=min){
					//�������� �ҳ���Сֵ
					min = Double.valueOf(str.split("[|]")[1]);
				}
			}
			return min;
		}
	}
	private void initPageLabel() {
		
		current = index%5==0?index/5:index/5+1;
		total = roomTypes.length%5==0?roomTypes.length/5:roomTypes.length/5+1;
		
		if(current == 0)
		{
			current = 1;
		}
		if(total == 0)
		{
			total = 1;
		}
		
		pageLabel = new JLabel("��"+current+"ҳ ��"+total+"ҳ");
		pageLabel.setFont(new Font("����", Font.BOLD, 15));
		pageLabel.setBounds(704, 716, 120, 29);
		backgroundPanel.add(pageLabel);
	}

	private void initPanel5(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_5 = new BackgroundPanel(background4);
		backgroundPanel_5.setLayout(null);
		backgroundPanel_5.setBounds(360, 611, 785, 90);
		backgroundPanel.add(backgroundPanel_5);
		
		BackgroundPanel roomPanel_5 = new BackgroundPanel(room);
		roomPanel_5.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(roomPanel_5);
		
		type_5 = new JLabel(type);
		type_5.setForeground(new Color(0, 0, 128));
		type_5.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		type_5.setBounds(104, 26, 118, 30);
		backgroundPanel_5.add(type_5);
		
		client_5 = new JLabel("���пͻ�");
		client_5.setForeground(new Color(0, 0, 128));
		client_5.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		client_5.setBounds(310, 26, 100, 30);
		backgroundPanel_5.add(client_5);
		
		price_5 = new JLabel("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_5.setForeground(new Color(255, 69, 0));
		price_5.setFont(new Font("����", Font.BOLD, 20));
		price_5.setBounds(540, 26, 63, 30);
		backgroundPanel_5.add(price_5);
		
		book_5 = new JButton(new ImageIcon("book.jpg"));
		book_5.setBounds(660, 23, 100, 45);
		book_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_5.add(book_5);
	}

	private void initPanel4(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_4 = new BackgroundPanel(background4);
		backgroundPanel_4.setLayout(null);
		backgroundPanel_4.setBounds(360, 511, 785, 90);
		backgroundPanel.add(backgroundPanel_4);
		
		BackgroundPanel roomPanel_4 = new BackgroundPanel(room);
		roomPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_4.add(roomPanel_4);
		
		type_4 = new JLabel(type);
		type_4.setForeground(new Color(0, 0, 128));
		type_4.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		type_4.setBounds(104, 26, 118, 30);
		backgroundPanel_4.add(type_4);
		
		JLabel client_4 = new JLabel("���пͻ�");
		client_4.setForeground(new Color(0, 0, 128));
		client_4.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		client_4.setBounds(310, 26, 100, 30);
		backgroundPanel_4.add(client_4);
		
		price_4 = new JLabel("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_4.setForeground(new Color(255, 69, 0));
		price_4.setFont(new Font("����", Font.BOLD, 20));
		price_4.setBounds(540, 26, 63, 30);
		backgroundPanel_4.add(price_4);
		
		book_4 = new JButton(new ImageIcon("book.jpg"));
		book_4.setBounds(660, 23, 100, 45);
		book_4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_4.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_4.add(book_4);
	}

	private void initPanel3(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_3 = new BackgroundPanel(background4);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(360, 411, 785, 90);
		backgroundPanel.add(backgroundPanel_3);
		
		BackgroundPanel roomPanel_3 = new BackgroundPanel(room);
		roomPanel_3.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(roomPanel_3);
		
		type_3 = new JLabel(type);
		type_3.setForeground(new Color(0, 0, 128));
		type_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		type_3.setBounds(104, 26, 118, 30);
		backgroundPanel_3.add(type_3);
		
		JLabel client_3 = new JLabel("���пͻ�");
		client_3.setForeground(new Color(0, 0, 128));
		client_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		client_3.setBounds(310, 26, 100, 30);
		backgroundPanel_3.add(client_3);
		
		price_3 = new JLabel("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_3.setForeground(new Color(255, 69, 0));
		price_3.setFont(new Font("����", Font.BOLD, 20));
		price_3.setBounds(540, 26, 63, 30);
		backgroundPanel_3.add(price_3);
		
		book_3 = new JButton(new ImageIcon("book.jpg"));
		book_3.setBounds(660, 23, 100, 45);
		book_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				checkPanel();
				
				String roomType = type_3.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			
				
			}
			
		});
		backgroundPanel_3.add(book_3);
	}

	private void initPanel2(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_2 = new BackgroundPanel(background4);
		backgroundPanel_2.setLayout(null);
		backgroundPanel_2.setBounds(360, 311, 785, 90);
		backgroundPanel.add(backgroundPanel_2);
		
		BackgroundPanel roomPanel_2 = new BackgroundPanel(room);
		roomPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_2.add(roomPanel_2);
		
		//�������� ��Ҫ��������
		type_2 = new JLabel(type);
		type_2.setForeground(new Color(0, 0, 128));
		type_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		type_2.setBounds(104, 26, 118, 30);
		backgroundPanel_2.add(type_2);
		
		//�ͻ�����
		client_2 = new JLabel("���пͻ�");
		client_2.setForeground(new Color(0, 0, 128));
		client_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		client_2.setBounds(310, 26, 100, 30);
		backgroundPanel_2.add(client_2);
		
		//�۸�
	    price_2 = new JLabel("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_2.setForeground(new Color(255, 69, 0));
		price_2.setFont(new Font("����", Font.BOLD, 20));
		price_2.setBounds(540, 26, 63, 30);
		backgroundPanel_2.add(price_2);
		
		book_2 = new JButton(new ImageIcon("book.jpg"));
		book_2.setBounds(660, 23, 100, 45);
		book_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_2.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			
			}
			
		});
		backgroundPanel_2.add(book_2);
	}

	private void initPanel1(String roomType) {
		
		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		backgroundPanel_1 = new BackgroundPanel(background4);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(360, 211, 785, 90);
		backgroundPanel.add(backgroundPanel_1);
		BackgroundPanel roomPanel_1 = new BackgroundPanel(room);
		roomPanel_1.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(roomPanel_1);//���÷���ͼƬ
		
		//�������� ��Ҫ�������õ�
		type_1 = new JLabel(type);
		type_1.setForeground(new Color(0, 0, 128));
		type_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		type_1.setBounds(104, 26, 118, 30);
		backgroundPanel_1.add(type_1);
		
	    //���ÿͻ� 
		client_1 = new JLabel("���пͻ�");
		client_1.setForeground(new Color(0, 0, 128));
		client_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		client_1.setBounds(310, 26, 100, 30);
		backgroundPanel_1.add(client_1);
		
		//����۸� ��Ҫ��������
		price_1 = new JLabel("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		price_1.setForeground(new Color(255, 69, 0));
		price_1.setFont(new Font("����", Font.BOLD, 20));
		price_1.setBounds(540, 26, 63, 30);
		backgroundPanel_1.add(price_1);
		
		//Ԥ����ť ��Ҫ��������
		book_1 = new JButton(new ImageIcon("book.jpg"));
		book_1.setBounds(660, 23, 100, 45);
		book_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		backgroundPanel_1.add(book_1);
	}

	public void setBookUI(bookUI ui){
		this.ui = ui;
	}
	
	/**
	 * ������ɶ�����JPanel�Ƿ�ɼ�
	 * */
	public void checkPanel(){
		
		if(!createOrderPanel.isVisible()){
			createOrderPanel.setVisible(true);
			searchPanel.setVisible(false);
		}
	}

	/**
	 * �õ���ѡ���͵ķ���ĺ���
	 * @param roomType ��ѡ��������
	 * */
	public String getRoomNumber(String roomType){
		
		String chosenTypes[] = rooms.getText().split("\n");//��ѡ�����з�������
		ArrayList<String> a = new ArrayList<String>();
		for(String str:chosenTypes){
			//������ѡ�����з���
			if(str.split(":")[0].equals(roomType)){
				//�Ѻ͵�ǰ����һ���ķ���������a��
				a.add(str.split(":")[1]);
			}
		}
		
		String roomNumber = "";
		if(a.size()==0){
			//û��ѡ��ͬһ���ͷ���
			roomNumber = controller.getRoomNumber(roomType);//û�з��䷵�ص���""
		}else{
			String lastRoomNumber = a.get(a.size()-1);//�õ���һ�������ķ���
			roomNumber = controller.getNextRoomNumber(roomType,lastRoomNumber);
		}
		
		return roomNumber;
	}
	
	/**
	 * ������ѡ��������ż۸�
	 * */
	public void setPrice(){

	    String allRooms[] = rooms.getText().split("\n");//��ѡ�����з���
	    
	    String numbers ="";
	    for(int i=0;i<allRooms.length;i++){
	    	numbers = numbers+allRooms[i].split(":")[1]+"/";
	    }
	    
	    double price = controller.getPrice(numbers.substring(0, numbers.length()-1));//�������ż۸�
	    totalPrice.setText("��"+String.valueOf(price));

	}
	
	public void searchButtonClicked() {
		
		String date = checkInDate.getText();
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
		
		String hotelProvince = vo.getHotelProvince();
		String hotelCity = vo.getHotelCity();
		String hotelCBD = vo.getHotelCBD();
		
       SearchVO searchvo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
	    
	    bookUI ui = new bookUI(hotelProvince,hotelCity,hotelCBD,clientID,searchvo);
	    ui.setVisible(true);
	    this.dispose();
	}
	
	/**
	 * �ж�����������Ƿ���ϸ�ʽ
	 * @param date ����
	 * @return ���ϸ�ʽ����true������Ϊfalse
	 * */
	private boolean checkDate (String date){
		
		String reg_yyyy_MM_dd = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})" +
                "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))" +
                "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
		if(date.matches(reg_yyyy_MM_dd)){
			return true;
		}
		return false;
	}
	
	private int formatPrice (double d){
		
		return (int) Math.round(d);
	}

	public void lastPageButtonClicked() {
	
		if(index>5){
			
			int end = 0; //end����һҳ�Ľ����ľƵ����
			if(index%5==0){
				end = (index/5-1)*5;
			}else{
				end = (index/5)*5;
			}
			index = end;//�ѵ�ǰҳ����Ϊ�������
			
			changePageLabel();
			changeFinePanel();
	
		}
	}

	private void changeFinePanel() {
		
		changePanel1(roomTypes[index-5]);
		changePanel2(roomTypes[index-4]);
		changePanel3(roomTypes[index-3]);
		changePanel4(roomTypes[index-2]);
		changePanel5(roomTypes[index-1]);
		
		if(!backgroundPanel_1.isVisible()){
			backgroundPanel_1.setVisible(true);
		}
		
		if(!backgroundPanel_2.isVisible()){
			backgroundPanel_2.setVisible(true);
		}
		
		if(!backgroundPanel_3.isVisible()){
			backgroundPanel_3.setVisible(true);
		}
		
		if(!backgroundPanel_4.isVisible()){
			backgroundPanel_4.setVisible(true);
		}
		
		if(!backgroundPanel_5.isVisible()){
			backgroundPanel_5.setVisible(true);
		}
	}

	private void changePanel5(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_5.setText(type);
		price_5.setText("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_5.removeActionListener(book_5.getActionListeners()[0]);
		book_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_5.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel4(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_4.setText(type);
		price_4.setText("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_4.removeActionListener(book_4.getActionListeners()[0]);
		book_4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_4.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel3(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_3.setText(type);
		price_3.setText("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_3.removeActionListener(book_3.getActionListeners()[0]);
		book_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_3.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	private void changePanel2(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_2.setText(type);
		price_2.setText("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_2.removeActionListener(book_2.getActionListeners()[0]);
		book_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_2.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
	}

	private void changePanel1(String roomType) {

		String strs[] = roomType.split("[|]");
		String type="",price="";
		if(strs.length==2){
			type = strs[0];
			price = strs[1];
		}
		
		type_1.setText(type);
		price_1.setText("��"+formatPrice(Double.valueOf(price.equals("")?"0":price)));
		
		book_1.removeActionListener(book_1.getActionListeners()[0]);
		book_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkPanel();
				
				String roomType = type_1.getText();
				String roomNumber = getRoomNumber(roomType);
				
				if("".equals(roomNumber)){
					JOptionPane.showMessageDialog(null, "�ܱ�Ǹ�������͵Ŀշ���ʱû����!","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;	
				}
				
			   rooms.append(roomType+":"+roomNumber+"\n");
			   setPrice();
			}
			
		});
		
	}

	/**
	 * ��һҳ��ť���µ�ʵ���¼���Ӧ
	 * */
	public void nextPageButtonClicked() {
		
		int size = roomTypes.length;
		if(index+5>size){
			if(index<size){
				int left = size - index;
				changeNextFinePanel(left);
			}
		}else{
			changeNextFinePanel(5);
		}
	}

	/**
	 * �ı���ʾ������
	 * @param left ʣ�µķ������͵�����
	 * */
	private void changeNextFinePanel(int left) {
		
		switch(left){
		case 1:{
			changePanel1(roomTypes[index++]);
			backgroundPanel_2.setVisible(false);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 2:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			backgroundPanel_3.setVisible(false);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 3:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			backgroundPanel_4.setVisible(false);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 4:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			changePanel4(roomTypes[index++]);
			backgroundPanel_5.setVisible(false);
			break;
		}
		case 5:{
			changePanel1(roomTypes[index++]);
			changePanel2(roomTypes[index++]);
			changePanel3(roomTypes[index++]);
			changePanel4(roomTypes[index++]);
			changePanel5(roomTypes[index++]);
			break;
		}
		}
		
		changePageLabel();
	}

	/**
	 * �ı�ҳ��
	 * */
	private void changePageLabel() {
		
		current = index%5==0?index/5:index/5+1;
		total = roomTypes.length%5==0?roomTypes.length/5:roomTypes.length/5+1;
		String str = "��"+current+"ҳ ��"+total+"ҳ";
		pageLabel.setText(str);
	}

	public void createButtonClicked() {
		
		if("".equals(rooms.getText())){
			JOptionPane.showMessageDialog(null, "��ѡ�񷿼䣡","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(!controller.checkCredit(clientID)){
			//�ͻ����õ�Ϊ����
			JOptionPane.showMessageDialog(null, "�ͻ����õ㲻�㣬���Ƚ��г�ֵ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
		String chosenRooms[] = rooms.getText().split("\n");
		//��List roomNumbers ���õ����еķ�����Ϣ
		ArrayList<String> roomNumbers = new ArrayList<String>();
		ArrayList<String> roomTypes = new ArrayList<String>();
		
		String types = "";
		String numbers = "";
		
		for(String str: chosenRooms){
			roomTypes.add(str.split(":")[0]);
			types = types+str.split(":")[0]+"/";
			roomNumbers.add(str.split(":")[1]);
			numbers = numbers+str.split(":")[1]+"/";
		}
		
		for(String str:roomNumbers){
			
			if(!controller.checkRoom(vo.getHotelID(),str)){
				
				int index =roomNumbers.indexOf(str);
				String roomType = roomTypes.get(index);
				JOptionPane.showMessageDialog(null,roomType+":"+str+" �����µ�ʱ��Ԥ���ˣ��´β�Ҫ��ԥ̫��Ŷ","��ʾ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			    return ;
			}
		}
		
		types = types.substring(0,types.length()-1);
		numbers = numbers.substring(0,numbers.length()-1);
		
		boolean q = controller.createOrder(vo.getHotelID(),clientID,types,numbers);
		if(q == true){
			
			JOptionPane.showMessageDialog(null, "���ɶ����ɹ���");
			closeButton.doClick();
		}else{
			JOptionPane.showMessageDialog(null, "������δ֪�Ĵ���","������˼",JOptionPane.INFORMATION_MESSAGE);
		    return;
		}
	}
}


