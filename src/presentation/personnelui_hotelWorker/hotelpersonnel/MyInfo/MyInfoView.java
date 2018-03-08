package presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.HotelStrategyControllerImpl;
import presentation.controller.InitHotelViewControllerImpl;
import presentation.controller.ModifyHotelInfoViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.help.HotelPicture;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import runner.HotelWorkerRunner;
import vo.HotelVO;

public class MyInfoView extends JFrame {

	private JPanel contentPane;
	
	private String hotelId;
	
	private String myId;
	
	private MyInfoControllerService controller;

	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new HotelWorkerRunner();
//					String hotelId="00001";
//					MyInfoControllerService controllerService=new MyInfoControllerImpl(hotelId);
//					MyInfoView view=new MyInfoView(controllerService);
//					controllerService.setInfoView(view);
//					view.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MyInfoView(MyInfoControllerService controller) {
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.myId="1"+hotelId;
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setLocation(-575, -59);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//×îÐ¡»¯Óë¹Ø±Õ°´Å¥
		JLabel closeLabel = new JLabel("¡Á");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		contentPane.add(closeLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1146, 13, 40, 40);
		contentPane.add(closeBT);		
		closeBT.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.BLACK);
		minLabel.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		minLabel.setBounds(1097, 18, 26, 30);
		contentPane.add(minLabel);
		
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
		contentPane.add(minBT);
		
		//¿É×ÔÓÉÍÏ×§µÄlabel
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		contentPane.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		JButton headButton=new JButton();
		headButton.setBounds(54, 29, 170, 170);
		headButton.setIcon(new ImageIcon("hotelPersonnel.jpg"));
		contentPane.add(headButton);
		
		JLabel label_welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label_welcome.setBounds(70, 228, 143, 48);
		label_welcome.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		contentPane.add(label_welcome);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageHotelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageHotelButtonClicked();
			}
		});
		contentPane.add(manageHotelBT);
		
		JButton manageRoomBT = new JButton(new ImageIcon("manageRoom.jpg"));
		manageRoomBT.setBounds(54, 381, 170, 60);
		manageRoomBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageRoomButtonClicked();
			}
		});
		contentPane.add(manageRoomBT);
		
		JButton manageStrategyBT = new JButton(new ImageIcon("manageStrategy.jpg"));
		manageStrategyBT.setBounds(53, 466, 170, 60);
		manageStrategyBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageStrategyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageStrategyButtonClicked();
			}
		});
		contentPane.add(manageStrategyBT);
		
		JButton manageOrderBT = new JButton(new ImageIcon("manageOrder.jpg"));
		manageOrderBT.setBounds(54, 555, 170, 60);
		manageOrderBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageOrderBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageOrderButtonClicked();
			}
		});
		contentPane.add(manageOrderBT);
		
		JButton manageInfoBT = new JButton(new ImageIcon("companyCooperation.jpg"));
		manageInfoBT.setBounds(54, 644, 170, 60);
		manageInfoBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageInfoBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked();
			}
		});
		contentPane.add(manageInfoBT);
		
		//µÃµ½Ò»¸öhotelvoÀ´ÏÔÊ¾×é¼þÐÅÏ¢
		HotelVO myHotel=controller.getHotelVO(hotelId);
		
		//´´½¨Ö÷½çÃæ
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setBounds(345, 79, 826, 496);
		mainPanel.setLayout(null);
//		mainPanel.setOpaque(false);
		contentPane.add(mainPanel);
		
		JLabel lblId = new JLabel("\u6211\u7684ID");
		lblId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblId.setBounds(14, 186, 88, 33);
		mainPanel.add(lblId);
		
		JLabel myIdLabel = new JLabel();
		myIdLabel.setText(myId);
		myIdLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		myIdLabel.setBounds(177, 193, 81, 21);
		mainPanel.add(myIdLabel);
		
		JLabel label_4 = new JLabel("\u9152\u5E97\u5730\u5740");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		label_4.setBounds(14, 439, 96, 27);
		mainPanel.add(label_4);
		
		JLabel addLabel = new JLabel();
		addLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		addLabel.setBounds(177, 443, 570, 21);
		String address=myHotel.getHotelProvince()+myHotel.getHotelCity()+myHotel.getHotelAddress();
		addLabel.setText(address);
		mainPanel.add(addLabel);
		
		JLabel label = new JLabel("\u6211\u7684\u9152\u5E97\u540D\u79F0");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		label.setBounds(15, 261, 144, 33);
		mainPanel.add(label);
		
		JLabel hotelNameLabel = new JLabel();
		hotelNameLabel.setText(myHotel.getHotelName());
		hotelNameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		hotelNameLabel.setBounds(190, 268, 255, 21);
		mainPanel.add(hotelNameLabel);
		
		JLabel lblid = new JLabel("\u9152\u5E97ID");
		lblid.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblid.setBounds(14, 351, 96, 33);
		mainPanel.add(lblid);
		
		JLabel hotelIdLabel = new JLabel();
		hotelIdLabel.setText(hotelId);
		hotelIdLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		hotelIdLabel.setBounds(177, 358, 81, 21);
		mainPanel.add(hotelIdLabel);
		
		//³õÊ¼»¯ÉèÖÃlabelµÄÍ¼Æ¬
		JLabel picLabel = new JLabel();
		picLabel.setBorder(BorderFactory.createEtchedBorder());
		picLabel.setBounds(478, 18, 294, 278);
		picLabel.setBackground(Color.CYAN);
		ImageIcon icon=new ImageIcon();
		boolean isExist=HotelPicture.isExist(hotelId);
		if(isExist==true){
			icon=new ImageIcon(HotelPicture.getLocalPicture(hotelId));
		}else{
			byte[] picByte=controller.getHotelPicture(hotelId);
			if(picByte==null){
				//ÉÐÎ´ÉèÖÃÍ¼Æ¬ ·þÎñÆ÷¶ËºÍ¿Í»§¶Ë¶¼Ã»ÓÐÍ¼Æ¬ ÔòÏÔÊ¾Ä¬ÈÏÍ¼Æ¬
				icon=new ImageIcon("hoteldefaultpicture.jpg");
			}else{
				icon=new ImageIcon(HotelPicture.changeByteAndSave(picByte, hotelId));	
			}
		}
		
		//ÊµÏÖÍ¼Æ¬¸ù¾ÝlabelµÄ´óÐ¡½øÐÐËõ·Å
		icon=new ImageIcon(icon.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_DEFAULT));
		
		picLabel.setIcon(icon);
		mainPanel.add(picLabel);
		
		JLabel label_1 = new JLabel("\u9152\u5E97\u56FE\u7247");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_1.setBounds(581, 309, 111, 33);
		mainPanel.add(label_1);
		
		JButton backBT = new JButton(new ImageIcon("returnHomepage.jpg"));
		backBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		backBT.setBounds(578, 652, 266, 41);
		backBT.addActionListener(new ActionListener(	) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.backButtonClicked();
			}
		});
		contentPane.add(backBT);
		//contentPane.setOpaque(false);
		
		mainPanel.setOpaque(false);
	}
	
	public void manageHotelButtonClicked(){
		ModifyHotelInfoViewControllerService controllerService=new ModifyHotelInfoViewControllerImpl(hotelId);
		ModifyHotelInfoView modifyHotelInfoUI=new ModifyHotelInfoView(controllerService);
		controllerService.setView(modifyHotelInfoUI);
		modifyHotelInfoUI.setVisible(true);
		dispose();
	}
	
	public void backButtonClicked(){
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageRoomButtonClicked(){
		HotelRoomControllerService controllerService=new HotelRoomControllerImpl(hotelId);
		InitManageRoomView newFrame=new InitManageRoomView(controllerService);
		controllerService.setInitManageRoomView(newFrame);
		newFrame.setVisible(true);
		dispose();
	}
	
	public void manageOrderButtonClicked(){
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, "", "");
		ManageOrderView view=new ManageOrderView(controllerService);
		controllerService.setManageOrderView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageStrategyButtonClicked(){
		HotelStrategyControllerService controllerService=new HotelStrategyControllerImpl(hotelId,"");
		InitManageStrategyView ui=new InitManageStrategyView(controllerService);
		controllerService.setInitManageStrategyView(ui);
		ui.setVisible(true);
		dispose();
	}
	
	public void manageInfoButtonClicked(){
		MyInfoControllerService controllerService=new MyInfoControllerImpl(hotelId);
		MyInfoView view=new MyInfoView(controllerService);
		controllerService.setInfoView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageCompanyButtonClicked(){
		HotelCoCompanyControllerService controllerService=new HotelCoCompanyControllerImpl(hotelId);
		InitManageCompanyView view=new InitManageCompanyView(controllerService);
		controllerService.setInitManageCompanyView(view);
		view.setVisible(true);
		dispose();
	}
}
