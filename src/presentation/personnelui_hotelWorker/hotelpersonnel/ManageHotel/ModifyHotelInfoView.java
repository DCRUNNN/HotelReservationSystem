
package presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import runner.HotelWorkerRunner;
import vo.HotelVO;

public class ModifyHotelInfoView extends JFrame {

	private JPanel contentPane;
	private JTextField hotelnameField;
	private JTextField provinceField;
	private JTextField hotelCBDField;
	private JTextField telephoneField;
	private JTextField hotelIntroField;
	private JTextArea hotelEquipmentArea;
	private JComboBox<Integer> hotelStarCombo;
	private String hotelID;
	private HotelVO hotelVO;
	private JLabel picLabel;
	private JTextField cityField;
	private JTextField addressField;
	private String picPath;
	private File picFile;
	private byte[] picByte;
	private ImageIcon icon;
	private ModifyHotelInfoViewControllerService controller;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new HotelWorkerRunner();
					ModifyHotelInfoViewControllerService controllerService=new ModifyHotelInfoViewControllerImpl("00001");
					ModifyHotelInfoView frame = new ModifyHotelInfoView(controllerService);
					controllerService.setView(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyHotelInfoView(ModifyHotelInfoViewControllerService controller ) {
		new HotelWorkerRunner();
		this.controller=controller;
		this.hotelID=controller.getHotelId();
//		hotelHelper=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//×îÐ¡»¯Óë¹Ø±Õ°´Å¥
		JLabel closeLabel = new JLabel("¡Á");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		contentPane.add(closeLabel);
		
		JButton close = new CircleButton("");
		close.setBackground(new Color(135, 206, 235));
		close.setBounds(1146, 13, 40, 40);
		contentPane.add(close);		
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
		headButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageInfoButtonClicked();
			}
		});
		contentPane.add(headButton);
		
		JLabel label = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label.setBounds(70, 228, 143, 48);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		contentPane.add(label);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageHotelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageOrderButtonClicked();
			}
		});
		contentPane.add(manageOrderBT);
		
		JButton manageCompanyBT = new JButton(new ImageIcon("companyCooperation.jpg"));
		manageCompanyBT.setBounds(54, 644, 170, 60);
		manageCompanyBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageInfoButtonClicked();
			}
		});
		contentPane.add(manageCompanyBT);
		
		JLabel frameLabel=new JLabel("ÐÞ¸Ä¾ÆµêÐÅÏ¢");
		frameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		frameLabel.setBounds(300,30,200,30);
		contentPane.add(frameLabel);
		
		JLabel hotelNameLabel = new JLabel("¾ÆµêÃû³Æ");
		hotelNameLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		hotelNameLabel.setBounds(393, 86, 103, 30);
		contentPane.add(hotelNameLabel);
		
		try{
			hotelVO=controller.getHotelVO(hotelID);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		hotelnameField = new JTextField();
		hotelnameField.setBounds(511, 86, 176, 31);
		hotelnameField.setText(hotelVO.getHotelName());
		hotelnameField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		contentPane.add(hotelnameField);
		hotelnameField.setColumns(10);
		
		JLabel label_3 = new JLabel("¾ÆµêµØÖ·");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_3.setBounds(393, 147, 103, 30);
		contentPane.add(label_3);
		
		provinceField = new JTextField();
		provinceField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		provinceField.setBounds(511, 141, 93, 27);
		provinceField.setText(hotelVO.getHotelProvince());
		contentPane.add(provinceField);
		provinceField.setColumns(10);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		cityField.setText(hotelVO.getHotelCity());
		cityField.setBounds(659, 141, 96, 27);
		contentPane.add(cityField);
		cityField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		addressField.setBounds(798, 141, 228, 27);
		addressField.setText(hotelVO.getHotelAddress());
		contentPane.add(addressField);
		addressField.setColumns(10);

		JLabel label_1 = new JLabel("Ê¡");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_1.setBounds(608, 141, 30, 24);
		contentPane.add(label_1);
	
		JLabel label_7 = new JLabel("ÊÐ");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_7.setBounds(757, 141, 37, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("ÏêÏ¸µØÖ·");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_8.setBounds(1024, 141, 126, 21);
		contentPane.add(label_8);
		
		JLabel label_4 = new JLabel("ËùÔÚÉÌÈ¦");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_4.setBounds(393, 212, 93, 21);
		contentPane.add(label_4);
		
		hotelCBDField = new JTextField();
		hotelCBDField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		hotelCBDField.setBounds(511, 212, 176, 27);
		hotelCBDField.setText(hotelVO.getHotelCBD());
		contentPane.add(hotelCBDField);
		hotelCBDField.setColumns(10);
		
		JLabel label_9 = new JLabel("¾ÆµêÐÇ¼¶");
		label_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_9.setBounds(757, 212, 103, 30);
		contentPane.add(label_9);
		
		Integer[] star={1,2,3,4,5,6};
		hotelStarCombo = new JComboBox<Integer>(star);
		
		hotelStarCombo.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 17));
		hotelStarCombo.setBounds(856, 212, 135, 27);
		hotelStarCombo.setSelectedItem(hotelVO.getHotelStar());
		contentPane.add(hotelStarCombo);
		
		JLabel lblNewLabel = new JLabel("ÁªÏµµç»°");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		lblNewLabel.setBounds(393, 272, 103, 21);
		contentPane.add(lblNewLabel);
		
		telephoneField = new JTextField();
		telephoneField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		telephoneField.setBounds(511, 272, 176, 27);
		telephoneField.setText(hotelVO.getTelephone());
		contentPane.add(telephoneField);
		telephoneField.setColumns(10);
		
		JLabel label_5 = new JLabel("¾ÆµêÍ¼Æ¬");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_5.setBounds(393, 347, 93, 21);
		contentPane.add(label_5);
		
		picLabel = new JLabel();
		picLabel.setBounds(511, 328, 170, 126);
		picLabel.setBackground(Color.CYAN);
		picLabel.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(picLabel);
		
		//ÅÐ¶Ï±¾µØÊÇ·ñ´æÔÚ¾ÆµêÍ¼Æ¬
//		boolean isExist=HotelPicture.isExist(hotelID);
//		if(isExist==true){
//			icon=new ImageIcon(HotelPicture.getLocalPicture(hotelID));
//		}else{
		
		//´Ó·þÎñÆ÷¶ËµÃµ½Í¼Æ¬
			byte[] picByte=controller.getHotelPicture(hotelID);
			if(picByte==null){
				//ÉÐÎ´ÉèÖÃÍ¼Æ¬ ·þÎñÆ÷¶ËºÍ¿Í»§¶Ë¶¼Ã»ÓÐÍ¼Æ¬ ÔòÏÔÊ¾Ä¬ÈÏÍ¼Æ¬
				icon=new ImageIcon("hoteldefaultpicture.jpg");
			}else{
				icon=new ImageIcon(HotelPicture.changeByteAndSave(picByte, hotelID));	
			}
//		}
		//ÊµÏÖÍ¼Æ¬¸ù¾ÝlabelµÄ´óÐ¡½øÐÐËõ·Å
		icon=new ImageIcon(icon.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_DEFAULT));
		picLabel.setIcon(icon);

		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(715, 328, 170, 106);
//		panel_2.setBackground(Color.CYAN);
//		contentPane.add(panel_2);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBounds(915, 328, 170, 106);
//		panel_3.setBackground(Color.CYAN);
//		contentPane.add(panel_3);
		
		JButton addPhotoBT = new JButton(new ImageIcon("uploadHead.jpg"));
		addPhotoBT.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,18));
		addPhotoBT.setBounds(373, 390, 123, 29);
		addPhotoBT.addActionListener(new AddPictureListener());
		contentPane.add(addPhotoBT);
		
		JLabel label_2 = new JLabel("¾Æµê¼ò½é");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_2.setBounds(393, 475, 93, 21);
		contentPane.add(label_2);
		
		hotelIntroField = new JTextField();
		hotelIntroField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		hotelIntroField.setBounds(511, 475, 581, 38);
		hotelIntroField.setText(hotelVO.getIntroduction());
		contentPane.add(hotelIntroField);
		hotelIntroField.setColumns(10);
		
		JLabel label_6 = new JLabel("¾ÆµêÉèÊ©");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_6.setBounds(393, 555, 93, 21);
		contentPane.add(label_6);
		
		hotelEquipmentArea = new JTextArea();
		hotelEquipmentArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		hotelEquipmentArea.setBounds(511, 555, 581, 114);
		hotelEquipmentArea.setText(hotelVO.getFacilities());
		hotelEquipmentArea.setBorder(BorderFactory.createEtchedBorder());
		hotelEquipmentArea.setLineWrap(true);
		contentPane.add(hotelEquipmentArea);
		
		JButton saveBT = new JButton(new ImageIcon("save_hotel.jpg"));
		saveBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		saveBT.setBounds(550, 722, 123, 35);
		saveBT.addActionListener(new SaveListener());
		contentPane.add(saveBT);
		
		JButton backBT = new JButton(new ImageIcon("return_hotel.jpg"));
		backBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		backBT.setBounds(830, 722, 123, 35);
		backBT.addActionListener(new BackListener());
		contentPane.add(backBT);
		
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String hotelProvince=provinceField.getText();
			String hotelCity=cityField.getText();
			String hotelCBD=hotelCBDField.getText();
			String hotelAddress=addressField.getText();
			String hotelName=hotelnameField.getText();
			String introduction=hotelIntroField.getText();
			String facilities=hotelEquipmentArea.getText();
			int star=(int)hotelStarCombo.getSelectedItem();
			
			
			String roomTypeAndPrices=hotelVO.getRoomTypeAndPrice();
			
			String telephone=telephoneField.getText();
			
			boolean flag=false;
			try{
				//ÅÐ¶ÏÐÞ¸Ä¾ÆµêÐÅÏ¢ÊÇ·ñ³É¹¦ ³É¹¦·µ»Øtrue ·ñÔòfalse
				flag=controller.changeHotelInfo(hotelID, hotelProvince, hotelCity, hotelCBD, hotelAddress, hotelName, introduction, facilities, star, roomTypeAndPrices,telephone);
				if(!(picByte==null)){
					//ÅÐ¶Ï½«Í¼Æ¬ÉÏ´«µ½·þÎñÆ÷ÒÔ¼°ÐÞ¸Ä¾ÆµêÍ¼Æ¬ÊÇ·ñ³É¹¦
					flag=controller.uploadHotelPicture(picByte, hotelID);
					flag=controller.changeHotelPicture(picByte, hotelID);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			if(true==flag){
				JOptionPane.showMessageDialog(null,"ÐÞ¸Ä³É¹¦","ÌáÊ¾",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				InitHotelViewControllerService controller=new InitHotelViewControllerImpl(hotelID);
				InitHotelView ui=new InitHotelView(controller);
				controller.setView(ui);
				ui.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü","ÌáÊ¾",JOptionPane.WARNING_MESSAGE);
			}	
		}	
	}
	
	class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int response=JOptionPane.showConfirmDialog(null, "È·¶¨ÒªÀë¿ª´ËÒ³ÃæÂð£¿","ÌáÊ¾",JOptionPane.YES_NO_OPTION);
			if(0==response){
				dispose();
				InitHotelViewControllerService controller=new InitHotelViewControllerImpl(hotelID);
				InitHotelView ui=new InitHotelView(controller);
				controller.setView(ui);
				ui.setVisible(true);
			}
		}
		
	}
	
	class AddPictureListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			JFileChooser jfc=new JFileChooser();  
		    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);  
		    //ÎÄ¼þ¹ýÂËÆ÷ Ö»ÏÔÊ¾jpgºÍpng¸ñÊ½µÄ
		    jfc.setFileFilter(new JPGFileFliter());
		    jfc.addChoosableFileFilter(new PNGFileFliter());
		    jfc.showDialog(new JLabel(), "Ñ¡Ôñ");  
		    picFile=jfc.getSelectedFile();  
		   	picPath=picFile.getAbsolutePath();
		   	ImageIcon icon=new ImageIcon(picPath);
		   	
		   	//ÊµÏÖÍ¼Æ¬¸ù¾ÝlabelµÄ´óÐ¡½øÐÐËõ·Å
			icon=new ImageIcon(icon.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_DEFAULT));
		   	picLabel.setIcon(icon);
		   	
		   	picByte=HotelPicture.changeFileToByte(picFile);
		}
	}
	
	public void manageHotelButtonClicked(){
		ModifyHotelInfoViewControllerService controllerService=new ModifyHotelInfoViewControllerImpl(hotelID);
		ModifyHotelInfoView modifyHotelInfoUI=new ModifyHotelInfoView(controllerService);
		controllerService.setView(modifyHotelInfoUI);
		modifyHotelInfoUI.setVisible(true);
		dispose();
	}
	
	public void manageRoomButtonClicked(){
		HotelRoomControllerService controllerService=new HotelRoomControllerImpl(hotelID);
		InitManageRoomView newFrame=new InitManageRoomView(controllerService);
		controllerService.setInitManageRoomView(newFrame);
		newFrame.setVisible(true);
		dispose();
	}
	
	public void manageOrderButtonClicked(){
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelID, "", "");
		ManageOrderView view=new ManageOrderView(controllerService);
		controllerService.setManageOrderView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageStrategyButtonClicked(){
		HotelStrategyControllerService controllerService=new HotelStrategyControllerImpl(hotelID,"");
		InitManageStrategyView ui=new InitManageStrategyView(controllerService);
		controllerService.setInitManageStrategyView(ui);
		ui.setVisible(true);
		dispose();
	}
	
	public void manageInfoButtonClicked(){
		MyInfoControllerService controllerService=new MyInfoControllerImpl(hotelID);
		MyInfoView view=new MyInfoView(controllerService);
		controllerService.setInfoView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void manageCompanyButtonClicked(){
		HotelCoCompanyControllerService controllerService=new HotelCoCompanyControllerImpl(hotelID);
		InitManageCompanyView view=new InitManageCompanyView(controllerService);
		controllerService.setInitManageCompanyView(view);
		view.setVisible(true);
		dispose();
	}
	
	

}	
