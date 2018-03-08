package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qt.datapicker.DatePicker;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.ModifyHotelInfoViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import vo.HotelVO;
import vo.StrategyVO;


public class ModifyStrategyView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField discountField;
	private JTextField companyField;
	private ObservingTextField beginDateField;
	private ObservingTextField endDateField;
	private JTextField roomNumberField;
	private JTextArea introField;
	private JComboBox<String> isBDayBox;
	private JComboBox<String> userTypeBox;
	private JComboBox<String> vipLevelBox;
	private JLabel viptypeLabel;
	
	private HotelStrategyControllerService controller;
	private String hotelId;
	private String strategyId;
	
	private StrategyVO strategy;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModifyStrategyView frame = new ModifyStrategyView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ModifyStrategyView(HotelStrategyControllerService controller) {
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.strategyId=controller.getStrategyId();
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//◊Ó–°ªØ”Îπÿ±’∞¥≈•
		JLabel closeLabel = new JLabel("°¡");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("ÀŒÃÂ", Font.BOLD, 25));
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
		minLabel.setFont(new Font("ÀŒÃÂ", Font.BOLD, 25));
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
		
		//ø…◊‘”…Õœ◊ßµƒlabel
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
				controller.manageInfoButtonClicked(3);
			}
		});
		contentPane.add(headButton);
		
		JLabel label_welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label_welcome.setBounds(70, 228, 143, 48);
		label_welcome.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 24));
		contentPane.add(label_welcome);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		manageHotelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageHotelButtonClicked(3);
			}
		});
		contentPane.add(manageHotelBT);
		
		JButton manageRoomBT = new JButton(new ImageIcon("manageRoom.jpg"));
		manageRoomBT.setBounds(54, 381, 170, 60);
		manageRoomBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		manageRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageRoomButtonClicked(3);
			}
		});
		contentPane.add(manageRoomBT);
		
		JButton manageStrategyBT = new JButton(new ImageIcon("manageStrategy.jpg"));
		manageStrategyBT.setBounds(53, 466, 170, 60);
		manageStrategyBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		manageStrategyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageStrategyButtonClicked(3);
			}
		});
		contentPane.add(manageStrategyBT);
		
		JButton manageOrderBT = new JButton(new ImageIcon("manageOrder.jpg"));
		manageOrderBT.setBounds(54, 555, 170, 60);
		manageOrderBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		manageOrderBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageOrderButtonClicked(3);
			}
		});
		contentPane.add(manageOrderBT);
		
		JButton manageCompanyBT = new JButton(new ImageIcon("companyCooperation.jpg"));
		manageCompanyBT.setBounds(54, 644, 170, 60);
		manageCompanyBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked(3);
			}
		});
		contentPane.add(manageCompanyBT);
		
		List<StrategyVO> list=controller.getAllHotelStrategy(hotelId);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getStrategyID().equals(strategyId)){
				strategy=list.get(i);
				break;
			}
		}
		
		JLabel idlabel = new JLabel("\u7B56\u7565\u7F16\u53F7");
		idlabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 24));
		idlabel.setBounds(276, 29, 105, 37);
		contentPane.add(idlabel);
		
		JLabel strategyIDField = new JLabel(strategyId);
		strategyIDField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		strategyIDField.setBounds(387, 38, 142, 21);
		contentPane.add(strategyIDField);
		
		JLabel label_1 = new JLabel("\u7B56\u7565\u540D\u79F0");
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_1.setBounds(433, 70, 96, 27);
		contentPane.add(label_1);
		
		nameField = new JTextField();
		nameField.setText(strategy.getName());
		nameField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		nameField.setBounds(541, 72, 264, 27);
		contentPane.add(nameField);
		nameField.setColumns(20);
		
		JLabel label = new JLabel("\u7B56\u7565\u7B80\u4ECB");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label.setBounds(433, 142, 96, 27);
		contentPane.add(label);
		
		introField = new JTextArea();
		introField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		introField.setText(strategy.getIntroduction());
		introField.setBounds(541, 114, 346, 103);
		introField.setBorder(BorderFactory.createEtchedBorder());
		introField.setLineWrap(true);
		contentPane.add(introField);
		
		JLabel label_2 = new JLabel("\u6298\u6263");
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_2.setBounds(456, 243, 61, 23);
		contentPane.add(label_2);
		
		discountField = new JTextField();
		discountField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		discountField.setBounds(543, 243, 195, 27);
		discountField.setText(strategy.getStrategy_discount()+"");
		contentPane.add(discountField);
		discountField.setColumns(10);
		
		JLabel label_3 = new JLabel("\uFF08\u8BF7\u4EE5\u5C0F\u6570\u5F62\u5F0F\u8F93\u5165\uFF09");
		label_3.setForeground(Color.red);
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		label_3.setBounds(752, 246, 201, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u9002\u7528\u7C7B\u578B");
		label_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_4.setBounds(433, 303, 96, 30);
		contentPane.add(label_4);
		
		String[] userType={"∆’Õ®øÕªß","∆’Õ®ª·‘±","∆Û“µª·‘±"};
		userTypeBox = new JComboBox<String>(userType);
		userTypeBox.setBounds(541, 307, 195, 27);
		userTypeBox.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		userTypeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent evt) {
				// TODO Auto-generated method stub
				//—°‘ÒøÚ±‰ªØ ±«–ªª–≈œ¢
				if(evt.getStateChange() == ItemEvent.SELECTED){
					String selected=(String)userTypeBox.getSelectedItem();
					
					if(selected.equals("∆’Õ®ª·‘±")){
						//»Ù «∆’Õ®ª·‘±‘Úø…“‘—°‘Òª·‘±µ»º∂
						viptypeLabel=new JLabel("ª·‘±µ»º∂");
						viptypeLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
						viptypeLabel.setBounds(770,303,96,30);
						contentPane.add(viptypeLabel);
						viptypeLabel.setVisible(true);
						
						String[] vipLevel={"∆’Õ®ª·‘±_1","∆’Õ®ª·‘±_2","∆’Õ®ª·‘±_3","∆’Õ®ª·‘±_4","∆’Õ®ª·‘±_5"};
						vipLevelBox=new JComboBox<String>(vipLevel);
						vipLevelBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN,20));
						vipLevelBox.setBounds(890,307,180,27);
						contentPane.add(vipLevelBox);	
					}else{
						contentPane.remove(viptypeLabel);
						contentPane.remove(vipLevelBox);
						contentPane.repaint();
					}
				}	
			}
		});
		contentPane.add(userTypeBox);
		
		JLabel label_5 = new JLabel("\u5408\u4F5C\u4F01\u4E1A");
		label_5.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_5.setBounds(433, 365, 96, 23);
		contentPane.add(label_5);
		
		companyField = new JTextField();
		companyField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		companyField.setBounds(541, 365, 195, 27);
		companyField.setText(strategy.getCompanyAddress());
		contentPane.add(companyField);
		companyField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8D77\u59CB\u65E5\u671F");
		label_6.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_6.setBounds(433, 424, 96, 27);
		contentPane.add(label_6);
		
		beginDateField = new ObservingTextField();
		beginDateField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		beginDateField.setBounds(541, 426, 195, 27);
		contentPane.add(beginDateField);
		beginDateField.setText(strategy.getBeginTime());
		beginDateField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_7.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_7.setBounds(433, 490, 96, 23);
		contentPane.add(label_7);
		
		endDateField = new ObservingTextField();
		endDateField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		endDateField.setBounds(541, 490, 195, 27);
		contentPane.add(endDateField);
		endDateField.setText(strategy.getEndTime());
		endDateField.setColumns(10);
		
		JLabel label_8 = new JLabel("\uFF08\u82E5\u6682\u65E0\u7ED3\u675F\u65E5\u671F\u8BF7\u586B\u65E0\uFF09");
		label_8.setForeground(Color.red);
		label_8.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		label_8.setBounds(823, 493, 224, 21);
		contentPane.add(label_8);
		
		
		JButton beginCalendarBT = new JButton(new ImageIcon("calendar.jpg"));
		beginCalendarBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		beginCalendarBT.setBounds(735, 425, 80, 27);
		beginCalendarBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 DatePicker dp = new DatePicker(beginDateField, Locale.CHINA);
                 // previously selected date
                 Date selectedDate = dp.parseDate(beginDateField.getText());
                 dp.setSelectedDate(selectedDate);
                 dp.start(beginDateField);
			}
		});
		contentPane.add(beginCalendarBT);
		
		JButton endCalendarBT = new JButton(new ImageIcon("calendar.jpg"));
		endCalendarBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
		endCalendarBT.setBounds(735, 489, 80, 27);
		endCalendarBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DatePicker dp = new DatePicker(endDateField, Locale.CHINA);
                // previously selected date
                Date selectedDate = dp.parseDate(endDateField.getText());
                dp.setSelectedDate(selectedDate);
                dp.start(endDateField);
			}
		});
		contentPane.add(endCalendarBT);
		
		JLabel label_9 = new JLabel("\uFF08\u82E5\u6CA1\u6709\u8BF7\u586B\u65E0\uFF09");
		label_9.setForeground(Color.red);
		label_9.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		label_9.setBounds(750, 368, 162, 21);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u623F\u95F4\u6570\u76EE");
		label_10.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_10.setBounds(433, 552, 96, 23);
		contentPane.add(label_10);
		
		roomNumberField = new JTextField();
		roomNumberField.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		roomNumberField.setBounds(541, 552, 195, 27);
		roomNumberField.setText(strategy.getRoomTotal()+"");
		contentPane.add(roomNumberField);
		roomNumberField.setColumns(10);
		
		JLabel label_11 = new JLabel("(–Ë“™∂©¬˙xº‰∑ø≤≈÷¥––≤ﬂ¬‘£¨∑Ò‘Ú«ÎÃÓ1)");
		label_11.setForeground(Color.red);
		label_11.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		label_11.setBounds(750, 555, 371, 21);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("\u662F\u5426\u751F\u65E5\u7B56\u7565");
		label_12.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_12.setBounds(387, 613, 132, 21);
		contentPane.add(label_12);
		
		String[] choice={"∑Ò"," «"};
		isBDayBox = new JComboBox<String>(choice);
		isBDayBox.setBounds(539, 612, 195, 27);
		isBDayBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		contentPane.add(isBDayBox);
		
		JButton saveBT = new JButton(new ImageIcon("web_save.jpg"));
		saveBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 24));
		saveBT.setBounds(498, 690, 149, 41);
		saveBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.confirmModifyStrategyButtonClicked();
			}
		});
		contentPane.add(saveBT);
		
		JButton cancelBT = new JButton(new ImageIcon("web_return.jpg"));
		cancelBT.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 24));
		cancelBT.setBounds(799, 690, 149, 41);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.cancelButtonClicked(3);
			}
		});
		contentPane.add(cancelBT);
	}

	public void confirmModifyStrategyButtonClicked(){
		//»∑»œ–ﬁ∏ƒ≤ﬂ¬‘
		String name=nameField.getText();
		String intro=introField.getText();
		String str_discount=discountField.getText();
		String company=companyField.getText();
		String beginDate=beginDateField.getText();
		String endDate=endDateField.getText();		
		String str_roomNumber=roomNumberField.getText();
		boolean isBDay=(isBDayBox.getSelectedIndex()==0)?false:true;
		String userType="";
		double discount=0;
		int roomNumber=0;
		
		if(company==null){
			company="";
		}
		
		if("Œﬁ".equals(endDate)){
			endDate = "";
		}
		if("Œﬁ".equals(beginDate)){
			beginDate = "";
		}
		 
		if(!endDate.contains(":")){
			endDate+=" 00:00:00";
		}
		
		if(!beginDate.contains(":")){
			beginDate+=" 00:00:00";
		}
		
		if(!(str_discount.equals("")||str_discount.equals(null))){
			discount=Double.parseDouble(str_discount);
		}
		if(!(str_roomNumber.equals("")||str_roomNumber.equals(null))){
			roomNumber=Integer.parseInt(str_roomNumber);
		}else{
			roomNumber=0;
		}
		
		String temp=(String)userTypeBox.getSelectedItem();
		if(temp.equals("∆’Õ®ª·‘±")){
			userType=(String)vipLevelBox.getSelectedItem();
		}else{
			userType=temp;
		}
		if(name.equals("")||userType.equals("")||intro.equals("")||str_discount.equals("")||beginDate.equals("")){
			JOptionPane.showMessageDialog(this, "–≈œ¢ÃÓ–¥≤ªÕÍ’˚,«Î÷ÿ–¬ ‰»Î","–¬‘ˆ≤ﬂ¬‘ ß∞‹",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		HotelVO hotelVO=controller.getHotelVO(hotelId);
		
		StrategyVO vo=new StrategyVO(strategyId, name, intro, beginDate, endDate, userType, hotelVO.getHotelProvince(), hotelVO.getHotelCity(), hotelVO.getHotelCBD(), isBDay, "æ∆µÍ”™œ˙≤ﬂ¬‘", hotelId, roomNumber, company, discount);
	
		//flag≈–∂œ–ﬁ∏ƒæ∆µÍ≤ﬂ¬‘ «∑Ò≥…π¶
		boolean flag=controller.changeHotelStrategy(vo);
		if(flag==true){
			JOptionPane.showMessageDialog(this, "–ﬁ∏ƒæ∆µÍ≤ﬂ¬‘≥…π¶£°","≤Ÿ◊˜≥…π¶",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			InitManageStrategyView view=new InitManageStrategyView(controller);
			controller.setInitManageStrategyView(view);
			view.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "–ﬁ∏ƒæ∆µÍ≤ﬂ¬‘ ß∞‹,«ÎºÏ≤È ‰»Î","≤Ÿ◊˜ ß∞‹",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void cancelButtonClicked(){
		int response=JOptionPane.showConfirmDialog(this, "»∑∂®“™¿Îø™¥À“≥√Ê¬£ø","Ã· æ",JOptionPane.YES_NO_OPTION);
		if(response==0){
			dispose();
			InitManageStrategyView view=new InitManageStrategyView(controller);
			controller.setInitManageStrategyView(view);
			view.setVisible(true);
		}
	}
	
	public void manageHotelButtonClicked(){
		ModifyHotelInfoViewControllerService controllerService=new ModifyHotelInfoViewControllerImpl(hotelId);
		ModifyHotelInfoView modifyHotelInfoUI=new ModifyHotelInfoView(controllerService);
		controllerService.setView(modifyHotelInfoUI);
		modifyHotelInfoUI.setVisible(true);
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
		InitManageStrategyView ui=new InitManageStrategyView(controller);
		controller.setInitManageStrategyView(ui);
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
