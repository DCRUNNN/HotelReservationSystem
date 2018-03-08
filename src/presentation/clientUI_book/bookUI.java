package presentation.clientUI_book;

/*
 * 
 * �ͻ�����Ԥ�����������鿴�Ƶ����ԭ��
 */

import java.awt.Color;



import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.BackgroundPanel;
import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.mainUI;
import presentation.help.HotelPicture;
import vo.HotelVO;
import vo.SearchVO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class bookUI extends JFrame
{

	private bookUIControllerService controller;
	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextArea txtHotelName_1;
	private JTextArea score_1;
	private JButton detailButton_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextArea txtHotelName;
	private JTextArea txtRoomType;
	private JTextArea txtRoomAmount;
	
	private String defaultHotelName = "(ѡ��)�Ƶ���";
	private String defaultRoomType = "(ѡ��)��������";
	private JTextArea txtTel_1;
	private JTextArea txtTel_2;
	private JTextArea txtTel_3;
	private JTextArea txtAddress_1;
	private JTextArea star_1;
	private JTextArea price_1;
	private JPanel picture_1;
	private JTextArea txtHotelName_2;
	private JButton detailButton_2;
	private JTextArea score_2;
	private BackgroundPanel picture_2;
	private JTextArea txtAddress_2;
	private JTextArea star_2;
	private JTextArea price_2;
	private JTextArea txtHotelName_3;
	private JButton detailButton_3;
	private JTextArea score_3;
	private JTextArea txtAddress_3;
	private JTextArea star_3;
	private BackgroundPanel picture_3;
	private JTextArea price_3;
	
	private JPanel backgroundPanel;
	private Image background2;
	private Image background3;
	private Image hotel;
	
	private JLabel pageLabel;
	private JButton returnButton;
	private JButton search;
	
	private JComboBox<String> comboBox_HotelGrade;
	//private String scoreOfFirstHotel ;
	private String clientID;
	/**
	 * Create the frame.
	 */

	public bookUI(String hotelProvince, String hotelCity, String hotelCBD, String clientID, SearchVO searchvo) {
		
		this.clientID = clientID;
		controller = new bookUIController(clientID);
		controller.initAllHotel(hotelProvince,hotelCity,hotelCBD);
		controller.search(searchvo);
		initUI(hotelProvince,hotelCity,hotelCBD,searchvo);
		
	}

	private void initUI(String hotelProvince, String hotelCity, String hotelCBD, SearchVO searchvo) {
	
		//����JFrame��һЩ����
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		//����contentPane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���ñ���ͼƬ
		background2 = new ImageIcon("background2_1.jpg").getImage();
		background3 = new ImageIcon("background3.jpg").getImage();
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
		
		//�鿴���鰴ť�ĳ�ʼ��
		detailButton_1 = new JButton(new ImageIcon("view.jpg"));
		detailButton_2 = new JButton(new ImageIcon("view.jpg"));
		detailButton_3 = new JButton(new ImageIcon("view.jpg"));
		
		//JLabel "��������"������
		JLabel searchLabel = new JLabel("��������");
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setBounds(71, 149, 202, 50);
		searchLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 30));
		backgroundPanel.add(searchLabel);
		
		//��ʾ��Ŀ�ĵ� JLabel
		txtDestination = new JTextField();
		txtDestination.setEditable(false);
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("Ŀ�ĵ�");
		txtDestination.setBounds(71, 200, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		//��ʾ����ס����JLabel
		txtCheckInDate = new JTextField();
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("��ס����");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(71, 300, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		//��ʾ�Ĺؼ���JLabel
		txtKeyWord = new JTextField();
		txtKeyWord.setEditable(false);
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("�ؼ���");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(71, 500, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		//��ʾ��ʡ��
		destination = new JTextField();
		destination.setEditable(false);
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		destination.setColumns(10);
		destination.setBounds(71, 240, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		destination.setText(hotelCity+"/"+hotelCBD);//������ܳ��Ȳ���
		backgroundPanel.add(destination);
		
		//��ʾ��һ��ҳ����������ס����
		checkInDate = new JTextField();
		checkInDate.setEditable(true);
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText(searchvo.getOrderBeginDate());
		checkInDate.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(71, 340, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(checkInDate);
		
		//��ʾ��ҳ��ľƵ���label
		txtHotelGrade = new JTextField();
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setText("�Ƶ꼶��");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(71, 400, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		//�����hotelName �Ƶ�����
		txtHotelName = new JTextArea();
		txtHotelName.setForeground(Color.BLACK);
		txtHotelName.setBackground(new Color(245, 255, 250));
		txtHotelName.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName.setLineWrap(true);
		txtHotelName.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtHotelName.setBounds(71, 540, 170, 50);
		//����������Ƶ�����Ϊ��ʱ������Ĭ�ϣ�������������ľƵ�����
		if(searchvo.getHotelName().equals("")||searchvo.getHotelName()==null){
			txtHotelName.setText(defaultHotelName);
		}else{
			txtHotelName.setText(searchvo.getHotelName());
			txtHotelName.setForeground(Color.black);
		}		
		backgroundPanel.add(txtHotelName);
		
		//�Ƶ��Ǽ��������б��
		comboBox_HotelGrade = new JComboBox<String>();
		comboBox_HotelGrade.setBackground(new Color(245, 255, 250));
		comboBox_HotelGrade.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		String grades[] = {
				"    ����","���Ǽ�/����","���Ǽ�/�ߵ�","���Ǽ�/����","���Ǽ�������/����"
		};
		comboBox_HotelGrade.setModel(new DefaultComboBoxModel<String>(grades));
		comboBox_HotelGrade.setBounds(71, 440, 170, 50);
		backgroundPanel.add(comboBox_HotelGrade);
		int minHotelStar = searchvo.getMinstar();
		int maxHotelStar = searchvo.getMaxstar();
		if(minHotelStar!=maxHotelStar){
			comboBox_HotelGrade.setSelectedIndex(4);
		}else{
			if(minHotelStar==maxHotelStar&&minHotelStar==-1){
				comboBox_HotelGrade.setSelectedIndex(0);
			}else{
				comboBox_HotelGrade.setSelectedIndex(6-minHotelStar);
			}
		}
		
		//����ķ������� 
		txtRoomType = new JTextArea();
		txtRoomType.setText(defaultRoomType);
		txtRoomType.setMargin(new Insets(10, 10, 10, 10));
		txtRoomType.setLineWrap(true);
		txtRoomType.setForeground(Color.BLACK);
		txtRoomType.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomType.setBackground(new Color(245, 255, 250));
		txtRoomType.setBounds(71, 590, 170, 50);
		if(!"".equals(searchvo.getRoomType())&&searchvo.getRoomType()!=null){
			//�����˷�������
			txtRoomType.setText(searchvo.getRoomType());
			txtRoomType.setForeground(Color.BLACK);
		}
		backgroundPanel.add(txtRoomType);
		
		//����ķ�����Ŀ
		txtRoomAmount = new JTextArea();
		int total = searchvo.getRoomTotal();
		String roomtotal = "������Ŀ:"+total;
		txtRoomAmount.setText(roomtotal);
		txtRoomAmount.setMargin(new Insets(10, 10, 10, 10));
		txtRoomAmount.setLineWrap(true);
		txtRoomAmount.setForeground(Color.black);
		txtRoomAmount.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtRoomAmount.setBackground(new Color(245, 255, 250));
		txtRoomAmount.setBounds(71, 640, 170, 50);
		backgroundPanel.add(txtRoomAmount);
		
		//�Ƶ�ͼƬ
		hotel = new ImageIcon("hotel.jpg").getImage();
		
		//��ʾ��Ϣ ������ʽ��
		JTextArea sortLabel = new JTextArea();
		sortLabel.setEditable(false);
		sortLabel.setText("\u6392\u5E8F\u65B9\u5F0F");
		sortLabel.setOpaque(false);
		sortLabel.setMargin(new Insets(10, 10, 10, 10));
		sortLabel.setForeground(Color.WHITE);
		sortLabel.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		sortLabel.setColumns(10);
		sortLabel.setBounds(360, 24, 99, 40);
		backgroundPanel.add(sortLabel);
		
		List<HotelVO> volist = controller.getThreeHotels();
	    initThreeHotelPanel(volist);
		//��һҳ��ť
		JButton lastPageButton = new JButton(new ImageIcon("lastPage.jpg"));
		lastPageButton.setBounds(360, 710, 170, 60);
		lastPageButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//��һҳ��ť�ļ���
				List<HotelVO> volist = controller.getLastThreeHotels();
				changeThreeHotelPanel(volist);//���������Ƶ�label
				
				changePageLabel();//�ı��·���ҳ��
			}
			
		});
		backgroundPanel.add(lastPageButton);
		
		//��һҳ��ť
		JButton nextPageButton = new JButton(new ImageIcon("nextPage.jpg"));
		nextPageButton.setBounds(975, 710, 170, 60);
		nextPageButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//��һҳ��ť�ļ���
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);//������ʾ�������Ƶ�label
				
				changePageLabel();
			}		
		});
		backgroundPanel.add(nextPageButton);
		
		returnButton = new JButton(new ImageIcon("return2.jpg"));
		returnButton.setBounds(71, 64, 170, 60);
		returnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				returnButtonClicked();
			}
			
		});
		backgroundPanel.add(returnButton);
		
		//���۸�����ť
		JButton priceButton = new JButton(new ImageIcon("price.jpg"));
		priceButton.setBounds(360, 64, 170, 60);
		priceButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.showByprice();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(priceButton);
		
		//���ۺ���������ť
		JButton scoreButton = new JButton(new ImageIcon("score.jpg"));
		scoreButton.setBounds(565, 64, 170, 60);
		scoreButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				controller.showByPoint();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(scoreButton);
		
		//���Ǽ���������ť
		JButton starButton = new JButton(new ImageIcon("star.jpg"));
		starButton.setBounds(770, 64, 170, 60);
		starButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.showByStar();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
				
			}
			
		});
		backgroundPanel.add(starButton);
		
		//���Ƿ�����Ԥ����������
		JButton historyButton = new JButton(new ImageIcon("hotelButton.jpg"));
		historyButton.setBounds(975, 64, 170, 60);
		historyButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("history button clicked!");
				controller.showHotelOrdered();
				List<HotelVO> volist = controller.getThreeHotels();
				changeThreeHotelPanel(volist);
				
				changePageLabel();
			}
			
		});
		backgroundPanel.add(historyButton);
		
		//�·���ҳ����������ʾ
		int currentPage = controller.getCurrentPage();
		int allPage = controller.getAllPages();
		initPageLabel(currentPage,allPage);		
	  
		search = new JButton(new ImageIcon("search.jpg"));
		search.setBounds(71, 703, 170, 60);
		search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			    String date = checkInDate.getText().trim();
			    if(!checkDate(date)){
			    	JOptionPane.showMessageDialog(null, "�밴����ȷ�ĸ�ʽ�������ڣ�","������˼",JOptionPane.INFORMATION_MESSAGE);
			        return;
			    }//�õ��������ס����
			    
			    int index_grade = comboBox_HotelGrade.getSelectedIndex();
				int minstar = -1;
				int maxstar = -1;
				if(1<=index_grade&&index_grade<=3){
					//ѡ������壬�ģ��������Ǽ�
					minstar = maxstar = 5-index_grade+1;
				}else if(index_grade==4){
					//ѡ��������Ǽ���������
					minstar = 1;
					maxstar = 2;
				}//�õ�ѡ��ľƵ��Ǽ�
				
				String hotelName = txtHotelName.getText().trim();
				if(hotelName.equals(defaultHotelName)){
					//�ͻ�û�н�������Ƶ�����
					hotelName = "";
				}//�õ��Ƶ�����
				
				String roomType = txtRoomType.getText().trim();
				if(roomType.equals(defaultRoomType)){
					//û�����뷿������
					roomType="";
				}//�õ�����ķ�������
				
				int roomAmount = 1;
				String amount = txtRoomAmount.getText().trim();
				if(amount.matches("[0-9]*")){
					//����������
					if(!"".equals(amount)){
						roomAmount = Integer.valueOf(txtRoomAmount.getText());
					}
				}else if(!"".equals(amount)&&!roomtotal.equals(amount)){
					JOptionPane.showMessageDialog(null, "���������ָ�ʽ�ķ�����Ŀ��", "������˼",  JOptionPane.INFORMATION_MESSAGE);
				    return;
				}//�õ�����ķ�����Ŀ
				
				SearchVO vo = new SearchVO(hotelName, roomType, roomAmount, -1, -1, date, minstar, maxstar, -1, -1, false);
			    controller.search(vo);
			    
			    List<HotelVO> volist = controller.getThreeHotels();
			    changeThreeHotelPanel(volist);
			    changePageLabel();
			    
			}
		});
		backgroundPanel.add(search);
	}

	/**
	 * �Ƶ���Ϣ��ʼ��
	 * @param threeHotels �����Ƶ���Ϣvo
	 * */
	private void initThreeHotelPanel(List<HotelVO> threeHotels) {
		
		HotelVO vo = new HotelVO("", "", "", "", "", 1, "", "", "���˼�|20","","");
		if(threeHotels.size()==1){
			initPanel1(threeHotels.get(0));
			initPanel2(vo);
			panel_2.setVisible(false);
			initPanel3(vo);
			panel_3.setVisible(false);
		}else if(threeHotels.size()==2){
			initPanel1(threeHotels.get(0));
			initPanel2(threeHotels.get(1));
			initPanel3(vo);
			panel_3.setVisible(false);
		}else if(threeHotels.size()==3){
			initPanel1(threeHotels.get(0));
			initPanel2(threeHotels.get(1));
			initPanel3(threeHotels.get(2));
		}else if(threeHotels.size()==0){
			if(panel_1==null){
				initPanel1(vo);
				panel_1.setVisible(false);
			}
			if(panel_2==null){
				initPanel2(vo);
				panel_2.setVisible(false);
			}
			if(panel_3==null){
				initPanel3(vo);
				panel_3.setVisible(false);
			}
		}
	}

	/**
	 * �þƵ���Ϣ��ʼ�� ��һ���Ƶ�panel
	 * @param hotelVO �Ƶ���Ϣ
	 * */
	private void initPanel1(HotelVO hotelVO) {
		
		//��һ���Ƶ�
		panel_1 = new BackgroundPanel(background2);
		panel_1.setBounds(360, 155, 785, 155);
		backgroundPanel.add(panel_1);
		panel_1.setLayout(null);
		
		//��һ���Ƶ�ĵ绰
		txtTel_1 = new JTextArea();
		txtTel_1.setBounds(228, 99, 220, 43);
		panel_1.add(txtTel_1);
		txtTel_1.setForeground(new Color(25, 25, 112));
		txtTel_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtTel_1.setMargin(new Insets(10, 10, 10, 10));
		txtTel_1.setText(hotelVO.getTelephone());
		txtTel_1.setOpaque(false);
		txtTel_1.setColumns(10);
		
		//��ʾ�ġ�Ԥ�����ߡ� ����
		JTextArea textField = new JTextArea();
		textField.setEditable(false);
		textField.setBounds(135, 103, 98, 40);
		panel_1.add(textField);
		textField.setForeground(new Color(25, 25, 112));
		textField.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		textField.setMargin(new Insets(10, 10, 10, 10));
		textField.setText("\u9884\u8BA2\u70ED\u7EBF");
		textField.setOpaque(false);
		textField.setColumns(10);
		
		//��һ���Ƶ�ĵ�ַ
		txtAddress_1 = new JTextArea();
		txtAddress_1.setBounds(135, 70, 350, 40);
		panel_1.add(txtAddress_1);
		txtAddress_1.setForeground(new Color(25, 25, 112));
		txtAddress_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		txtAddress_1.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_1.setText(hotelVO.getHotelAddress());
		txtAddress_1.setOpaque(false);
		txtAddress_1.setColumns(10);
		
		//�������ʾ��label ���ۺ����֡�
		JLabel label = new JLabel();
		label.setBounds(425, 17, 98, 40);
		panel_1.add(label);
		label.setText("�ۺ�����");
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		
		//��һ���Ƶ���Ǽ���ʾ
		star_1 = new JTextArea();
		star_1.setText(hotelVO.getHotelStar()+"�Ǽ�");
		star_1.setOpaque(false);
		star_1.setMargin(new Insets(10, 10, 10, 10));
		star_1.setForeground(new Color(25, 25, 112));
		star_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		star_1.setEditable(false);
		star_1.setColumns(10);
		star_1.setBounds(463, 103, 98, 40);
		panel_1.add(star_1);
		
		//��һ���Ƶ����ͼ۸�
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_1 = new JTextArea();
		price_1.setText("��"+String.valueOf(price)+"��");
		price_1.setOpaque(false);
		price_1.setMargin(new Insets(10, 10, 10, 10));
		price_1.setForeground(new Color(25, 25, 112));
		price_1.setFont(new Font("����", Font.BOLD, 20));
		price_1.setEditable(false);
		price_1.setColumns(10);
		price_1.setBounds(540, 99, 98, 43);
		panel_1.add(price_1);
		
		//���þƵ������
		txtHotelName_1 = new JTextArea();
		txtHotelName_1.setBounds(135, 17, 280, 40);
		panel_1.add(txtHotelName_1);
		txtHotelName_1.setOpaque(false);
		txtHotelName_1.setBackground(new Color(176, 224, 230));
		txtHotelName_1.setForeground(new Color(25, 25, 112));
		txtHotelName_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 26));
		txtHotelName_1.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_1.setText(hotelVO.getHotelName());
		txtHotelName_1.setColumns(10);
		
		//�Ѳ鿴���鰴ť��ӵ�panel1��
		detailButton_1 = new JButton(new ImageIcon("view.jpg"));
		detailButton_1.setBounds(636, 17, 135, 120);
		detailButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_1.add(detailButton_1);
		
		//��һ���Ƶ�ĵ÷ֵĳ�ʼ��
		score_1 = new JTextArea();
		score_1.setBounds(512, 17, 126, 90);
		panel_1.add(score_1);
		score_1.setForeground(new Color(255, 99, 71));
		score_1.setOpaque(false);
		score_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD | Font.ITALIC, 60));
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		
		score_1.setText(formatPoint(average_point));
		
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_1 = new BackgroundPanel(i);
			}else{
		         picture_1 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_1 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_1 = new BackgroundPanel(i);
			}
		}
		
		picture_1.setBounds(14, 17, 120, 120);
		panel_1.add(picture_1);		
		
	}

	/**
	 * �þƵ���Ϣ��ʼ���ڶ����Ƶ���Ϣpanel
	 * @param hotelVO �Ƶ���Ϣ
	 * */
	private void initPanel2(HotelVO hotelVO) {
		
		panel_2 = new BackgroundPanel(background2);
		panel_2.setLayout(null);
		panel_2.setBounds(360, 330, 785, 155);
		backgroundPanel.add(panel_2);
		
		//�ڶ����Ƶ�ľƵ�����
		txtHotelName_2 = new JTextArea();
		txtHotelName_2.setBounds(135, 17, 280, 40);
		panel_2.add(txtHotelName_2);
		txtHotelName_2.setText(hotelVO.getHotelName());
		txtHotelName_2.setOpaque(false);
		txtHotelName_2.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_2.setForeground(new Color(25, 25, 112));
		txtHotelName_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 26));
		txtHotelName_2.setColumns(10);
		txtHotelName_2.setBackground(new Color(176, 224, 230));
		
		//�ڶ����Ƶ�Ĳ鿴���鰴ť
		detailButton_2 = new JButton(new ImageIcon("view.jpg"));
		detailButton_2.setBounds(636, 17, 135, 120);
		detailButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_2.add(detailButton_2);
		
		//�ڶ����Ƶ������
		score_2 = new JTextArea();
		score_2.setBounds(512, 17, 126, 90);  
		panel_2.add(score_2);
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		score_2.setText(formatPoint(average_point));
		score_2.setOpaque(false);
		score_2.setForeground(new Color(255, 99, 71));
		score_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD | Font.ITALIC, 60));
		
		//�ڶ����Ƶ�ľƵ�ͼƬ
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_2 = new BackgroundPanel(i);
			}else{
		         picture_2 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_2 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_2 = new BackgroundPanel(i);
			}
		}
		picture_2.setBounds(14, 17, 120, 120);
		panel_2.add(picture_2);
		
		//�ڶ����Ƶ�ĵ绰����
		txtTel_2 = new JTextArea();
		txtTel_2.setText(hotelVO.getTelephone());
		txtTel_2.setOpaque(false);
		txtTel_2.setMargin(new Insets(10, 10, 10, 10));
		txtTel_2.setForeground(new Color(25, 25, 112));
		txtTel_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtTel_2.setColumns(10);
		txtTel_2.setBounds(228, 99, 220, 43);
		panel_2.add(txtTel_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_3.setOpaque(false);
		textArea_3.setMargin(new Insets(10, 10, 10, 10));
		textArea_3.setForeground(new Color(25, 25, 112));
		textArea_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		textArea_3.setEditable(false);
		textArea_3.setColumns(10);
		textArea_3.setBounds(135, 103, 98, 40);
		panel_2.add(textArea_3);
		
		//�ڶ����Ƶ����ϸ��ַ
		txtAddress_2 = new JTextArea();
		txtAddress_2.setText(hotelVO.getHotelAddress());
		txtAddress_2.setOpaque(false);
		txtAddress_2.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_2.setForeground(new Color(25, 25, 112));
		txtAddress_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		txtAddress_2.setColumns(10);
		txtAddress_2.setBounds(135, 70, 350, 40);
		panel_2.add(txtAddress_2);
		
		JLabel label_1 = new JLabel();
		label_1.setText("\u7EFC\u5408\u8BC4\u5206");
		label_1.setOpaque(false);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_1.setBounds(425, 17, 98, 40);
		panel_2.add(label_1);
		
		//�ڶ����Ƶ���Ǽ�
		star_2 = new JTextArea();
		star_2.setText(hotelVO.getHotelStar()+"�Ǽ�");
		star_2.setOpaque(false);
		star_2.setMargin(new Insets(10, 10, 10, 10));
		star_2.setForeground(new Color(25, 25, 112));
		star_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		star_2.setEditable(false);
		star_2.setColumns(10);
		star_2.setBounds(463, 102, 98, 40);
		panel_2.add(star_2);
		
		//�ڶ����Ƶ�ļ۸�
		price_2 = new JTextArea();
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_2.setText("��"+String.valueOf(price)+"��");
		price_2.setOpaque(false);
		price_2.setMargin(new Insets(10, 10, 10, 10));
		price_2.setForeground(new Color(25, 25, 112));
		price_2.setFont(new Font("����", Font.BOLD, 20));
		price_2.setEditable(false);
		price_2.setColumns(10);
		price_2.setBounds(540, 98, 98, 43);
		panel_2.add(price_2);	
		
	}

	/**
	 * ��hotelVO ��ʼ���������Ƶ���Ϣlabel
	 * @param hotelVO �Ƶ���Ϣ
	 * */
	private void initPanel3(HotelVO hotelVO) {
		
		panel_3 = new BackgroundPanel(background2);
		panel_3.setLayout(null);
		panel_3.setBounds(360, 510, 785, 155);
		backgroundPanel.add(panel_3);
		
		//�������Ƶ�ĵ绰
		txtTel_3 = new JTextArea();
		txtTel_3.setText(hotelVO.getTelephone());
		txtTel_3.setOpaque(false);
		txtTel_3.setMargin(new Insets(10, 10, 10, 10));
		txtTel_3.setForeground(new Color(25, 25, 112));
		txtTel_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		txtTel_3.setColumns(10);
		txtTel_3.setBounds(228, 99, 220, 43);
		panel_3.add(txtTel_3);
		
		//�������Ƶ�ľƵ�����
		txtHotelName_3 = new JTextArea();
		txtHotelName_3.setBounds(135, 17, 280, 40);
		panel_3.add(txtHotelName_3);
		txtHotelName_3.setText(hotelVO.getHotelName());
		txtHotelName_3.setOpaque(false);
		txtHotelName_3.setMargin(new Insets(10, 10, 10, 10));
		txtHotelName_3.setForeground(new Color(25, 25, 112));
		txtHotelName_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 26));
		txtHotelName_3.setColumns(10);
		txtHotelName_3.setBackground(new Color(176, 224, 230));
		
		//�������Ƶ�Ĳ鿴���鰴ť
		detailButton_3 = new JButton(new ImageIcon("view.jpg"));
		detailButton_3.setBounds(636, 17, 135, 120);
		detailButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
			
		});
		panel_3.add(detailButton_3);
		
		//�������Ƶ������
		score_3 = new JTextArea();
		score_3.setBounds(512, 17, 126, 90);
		panel_3.add(score_3);
		
		double average_point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
		score_3.setText(formatPoint(average_point));
		score_3.setOpaque(false);
		score_3.setForeground(new Color(255, 99, 71));
		score_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD | Font.ITALIC, 60));
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_8.setOpaque(false);
		textArea_8.setMargin(new Insets(10, 10, 10, 10));
		textArea_8.setForeground(new Color(25, 25, 112));
		textArea_8.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		textArea_8.setEditable(false);
		textArea_8.setColumns(10);
		textArea_8.setBounds(135, 103, 98, 40);
		panel_3.add(textArea_8);
		
		//�������Ƶ����ϸ��ַ
		txtAddress_3 = new JTextArea();
		txtAddress_3.setText(hotelVO.getHotelAddress());
		txtAddress_3.setOpaque(false);
		txtAddress_3.setMargin(new Insets(10, 10, 10, 10));
		txtAddress_3.setForeground(new Color(25, 25, 112));
		txtAddress_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		txtAddress_3.setColumns(10);
		txtAddress_3.setBounds(135, 70, 350, 40);
		panel_3.add(txtAddress_3);
		
		JLabel label_2 = new JLabel();
		label_2.setText("\u7EFC\u5408\u8BC4\u5206");
		label_2.setOpaque(false);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_2.setBounds(425, 17, 98, 40);
		panel_3.add(label_2);
		
		//�������Ƶ���Ǽ�
		star_3 = new JTextArea();
		star_3.setText(hotelVO.getHotelStar()+"�Ǽ�");
		star_3.setOpaque(false);
		star_3.setMargin(new Insets(10, 10, 10, 10));
		star_3.setForeground(new Color(25, 25, 112));
		star_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 16));
		star_3.setEditable(false);
		star_3.setColumns(10);
		star_3.setBounds(462, 103, 98, 40);
		panel_3.add(star_3);
		
		//�������Ƶ��ͼƬ
		String hotelID = hotelVO.getHotelID();
		if(HotelPicture.isExist(hotelID)){
			//ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			if(i!=null){
				picture_3 = new BackgroundPanel(i);
			}else{
		         picture_3 = new BackgroundPanel(hotel);
			}
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				picture_3 = new BackgroundPanel(hotel);
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
                picture_3 = new BackgroundPanel(i);
			}
		}
		picture_3.setBounds(14, 17, 120, 120);
		panel_3.add(picture_3);
		
		//�������Ƶ�ļ۸�
		price_3 = new JTextArea();
		double price = findMin(hotelVO.getRoomTypeAndPrice());
		price_3.setText("��"+String.valueOf(price)+"��");
		price_3.setOpaque(false);
		price_3.setMargin(new Insets(10, 10, 10, 10));
		price_3.setForeground(new Color(25, 25, 112));
		price_3.setFont(new Font("����", Font.BOLD, 20));
		price_3.setEditable(false);
		price_3.setColumns(10);
		price_3.setBounds(539, 99, 98, 43);
		panel_3.add(price_3);	
	}

	/**
	 * ���������Ƶ�vo����ʼ����ʾ�ľƵ���Ϣ����
	 * @param threeHotels �����Ƶ�vo
	 * */
	private void changeThreeHotelPanel(List<HotelVO> threeHotels) {
		
		if(threeHotels.size()==1){
			changePanel1(threeHotels.get(0));
			hidePanel2();
			hidePanel3();
		}else if(threeHotels.size()==2){
			changePanel1(threeHotels.get(0));
			changePanel2(threeHotels.get(1));
			hidePanel3();
		}else if(threeHotels.size()==3){
			changePanel1(threeHotels.get(0));
			changePanel2(threeHotels.get(1));
			changePanel3(threeHotels.get(2));
		}/*else{
			//�Ƶ���Ϣ����ĿΪ0
			hidePanel1();
			hidePanel2();
			hidePanel3();
		}*/
	}

	private void changePanel1(HotelVO hotelVO) {
		
		if(panel_1==null){
			initPanel1(hotelVO);
		}
		if(!panel_1.isVisible()){
			panel_1.setVisible(true);
		}
		txtHotelName_1.setText(hotelVO.getHotelName());
		txtTel_1.setText(hotelVO.getTelephone());
		txtAddress_1.setText(hotelVO.getHotelAddress());
		
		star_1.setText(hotelVO.getHotelStar()+"�Ǽ�");
		price_1.setText("��"+findMin(hotelVO.getRoomTypeAndPrice())+"��");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_1.setText(formatPoint(point));
	    detailButton_1.removeActionListener(detailButton_1.getActionListeners()[0]);
	    detailButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//�Ƶ�ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_1.remove(picture_1);
			picture_1 = new BackgroundPanel(i);
			picture_1.setBounds(14, 17, 120, 120);
			panel_1.add(picture_1);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//������ͼƬ�Ļ�����Ĭ�ϵľƵ�ͼƬ
				panel_1.remove(picture_1);
				picture_1 = new BackgroundPanel(hotel);
				picture_1.setBounds(14, 17, 120, 120);
				panel_1.add(picture_1);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_1.remove(picture_1);
				picture_1 = new BackgroundPanel(i);
				picture_1.setBounds(14, 17, 120, 120);
				panel_1.add(picture_1);	
			}
		}
		panel_1.repaint();
	}

	private void changePanel2(HotelVO hotelVO) {
		
		if(panel_2==null){
			initPanel2(hotelVO);
		}
		if(!panel_2.isVisible()){
			panel_2.setVisible(true);
		}
		txtHotelName_2.setText(hotelVO.getHotelName());
		txtTel_2.setText(hotelVO.getTelephone());
		txtAddress_2.setText(hotelVO.getHotelAddress());
		//picture_1 �������ͼƬ��û��ʵ��
		star_2.setText(hotelVO.getHotelStar()+"�Ǽ�");
		price_2.setText("��"+findMin(hotelVO.getRoomTypeAndPrice())+"��");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_2.setText(formatPoint(point));
	    detailButton_2.removeActionListener(detailButton_2.getActionListeners()[0]);
	    detailButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//�Ƶ�ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_2.remove(picture_2);
			picture_2 = new BackgroundPanel(i);
			picture_2.setBounds(14, 17, 120, 120);
			panel_2.add(picture_2);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//������ͼƬ�Ļ�����Ĭ�ϵľƵ�ͼƬ
				panel_2.remove(picture_2);
				picture_2 = new BackgroundPanel(hotel);
				picture_2.setBounds(14, 17, 120, 120);
				panel_2.add(picture_2);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_2.remove(picture_2);
				picture_2 = new BackgroundPanel(i);
				picture_2.setBounds(14, 17, 120, 120);
				panel_2.add(picture_2);	
			}
		}
		panel_2.repaint();
	}

	private void changePanel3(HotelVO hotelVO) {
		
		if(panel_3==null){
			initPanel3(hotelVO);
		}
		if(!panel_3.isVisible()){
			panel_3.setVisible(true);
		}
		txtHotelName_3.setText(hotelVO.getHotelName());
		txtTel_3.setText(hotelVO.getTelephone());
		txtAddress_3.setText(hotelVO.getHotelAddress());

		star_3.setText(hotelVO.getHotelStar()+"�Ǽ�");
		price_3.setText("��"+findMin(hotelVO.getRoomTypeAndPrice())+"��");
		double point = (hotelVO.getPoint_facilities()+hotelVO.getPoint_service()+hotelVO.getPoint_surroundings())/3;
	    score_3.setText(formatPoint(point));
	    detailButton_3.removeActionListener(detailButton_3.getActionListeners()[0]);
	    detailButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				detailButtonClicked(hotelVO,clientID);
			}
	    	
	    });
	    
	    String hotelID = hotelVO.getHotelID();
		//byte[] b = null;
		if(HotelPicture.isExist(hotelID)){
			//�Ƶ�ͼƬ�Ѿ�����
			Image i = HotelPicture.getLocalPicture(hotelID);
			panel_3.remove(picture_3);
			picture_3 = new BackgroundPanel(i);
			picture_3.setBounds(14, 17, 120, 120);
			panel_3.add(picture_3);	
		}else{
			byte[] b = controller.getHotelImage(hotelID);
			if(b==null){
				//������ͼƬ�Ļ�����Ĭ�ϵľƵ�ͼƬ
				panel_3.remove(picture_3);
				picture_3 = new BackgroundPanel(hotel);
				picture_3.setBounds(14, 17, 120, 120);
				panel_3.add(picture_3);	
			}else{
				Image i = HotelPicture.changeByteAndSave(b, hotelID);
				panel_3.remove(picture_3);
				picture_3 = new BackgroundPanel(i);
				picture_3.setBounds(14, 17, 120, 120);
				panel_3.add(picture_3);	
			}
		}
		panel_3.repaint();
	}

	private void hidePanel2() {
	
		if(panel_2!=null){
			panel_2.setVisible(false);
		}
	}

	private void hidePanel3() {
		
		//backgroundPanel.remove(panel_3);
		if(panel_3!=null){
			panel_3.setVisible(false);
		}
		
	}

	/**
	 * �Խ����·���ҳ��label���г�ʼ��
	 * @param currentPage ��ǰҳ��
	 * @param allPage ��ҳ��
	 * */
	private void initPageLabel(int currentPage, int allPage) {
		
		if(currentPage == 0)
		{ 
			currentPage = 1;
		}
		if(allPage == 0)
		{
			allPage = 1;
		}
		
		
		String page_before = "��"+currentPage+"ҳ";
		String page_behind = "��"+allPage+"ҳ";
		pageLabel = new JLabel(page_before+" "+page_behind);
		pageLabel.setFont(new Font("����", Font.BOLD, 15));
		pageLabel.setBounds(704, 716, 120, 29);
		backgroundPanel.add(pageLabel);	
		
	}

	private void changePageLabel(){
		
		int currentPage = controller.getCurrentPage();
		int allPage = controller.getAllPages();
		String page = "��"+currentPage+"ҳ ��"+allPage+"ҳ";
		pageLabel.setText(page);
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

	/**
	 * �����ֱ�����λС��������ʾ
	 * @param d ����
	 * */
	private String formatPoint(double d){
		
		if(d==0){
			return "0.0";
		}else{
			DecimalFormat dec = new DecimalFormat("#.0");
			return dec.format(d);
		
		}
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
	
	private void returnButtonClicked(){

		String clientID = controller.getClientID();
		MainUIController controller = new MainUIController(clientID);
		mainUI ui = new mainUI(controller);
		controller.setUI(ui);
		ui.setVisible(true);
		this.dispose();
	}
	
	private void detailButtonClicked(HotelVO vo,String clientID){
		
		hotelDetailUI ui = new hotelDetailUI(vo,clientID);
		ui.setLastUI(this);
		ui.setVisible(true);
		this.dispose();
	}
}


