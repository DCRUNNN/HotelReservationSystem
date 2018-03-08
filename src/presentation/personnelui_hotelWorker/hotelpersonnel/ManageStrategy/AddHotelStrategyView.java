package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

public class AddHotelStrategyView extends JFrame {

	private JPanel contentPane;
	private JTextArea introField;
	private JTextField nameField;
	private JTextField discountField;
	private JComboBox<String> userTypeBox;
	private JComboBox<String> vipLevelBox;
	private JComboBox<String>  companyField;
	private ObservingTextField beginDayField;
	private ObservingTextField endDayField;
	private JTextField roomNumField;
	private JRadioButton isBDayBT;
	private JRadioButton notBDayBT;
	private ButtonGroup choiceGroup;
	
	private JLabel viptypeLabel;
	
	private String hotelID;
	
	private HotelStrategyControllerService controller;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddHotelStrategyView frame = new AddHotelStrategyView();
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
	public AddHotelStrategyView(HotelStrategyControllerService controller) {
		
		this.controller=controller;
		this.hotelID=controller.getHotelId();
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
		
		//最小化与关闭按钮
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
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
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
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
		
		//可自由拖拽的label
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
				controller.manageInfoButtonClicked(2);
			}
		});
		contentPane.add(headButton);
		
		JLabel label_welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label_welcome.setBounds(70, 228, 143, 48);
		label_welcome.setFont(new Font("微软雅黑", Font.BOLD, 24));
		contentPane.add(label_welcome);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageHotelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageHotelButtonClicked(2);
			}
		});
		contentPane.add(manageHotelBT);
		
		JButton manageRoomBT = new JButton(new ImageIcon("manageRoom.jpg"));
		manageRoomBT.setBounds(54, 381, 170, 60);
		manageRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageRoomBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageRoomButtonClicked(2);
			}
		});
		contentPane.add(manageRoomBT);
		
		JButton manageStrategyBT = new JButton(new ImageIcon("manageStrategy.jpg"));
		manageStrategyBT.setBounds(53, 466, 170, 60);
		manageStrategyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageStrategyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageStrategyButtonClicked(2);
			}
		});
		contentPane.add(manageStrategyBT);
		
		JButton manageOrderBT = new JButton(new ImageIcon("manageOrder.jpg"));
		manageOrderBT.setBounds(54, 555, 170, 60);
		manageOrderBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageOrderBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.manageOrderButtonClicked(2);
			}
		});
		contentPane.add(manageOrderBT);
		
		JButton manageCompanyBT = new JButton(new ImageIcon("companyCooperation.jpg"));
		manageCompanyBT.setBounds(54, 644, 170, 60);
		manageCompanyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked(2);
			}
		});
		contentPane.add(manageCompanyBT);
		
		JLabel label = new JLabel("策略名称");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(433, 89, 96, 23);
		contentPane.add(label);
		
		nameField = new JTextField();
		nameField.setBounds(541, 89, 195, 27);
		nameField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel label_1 = new JLabel("策略简介");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_1.setBounds(433, 156, 96, 27);
		contentPane.add(label_1);
		
		introField = new JTextArea();
		introField.setBounds(541, 138, 305, 87);
		introField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(introField);
		introField.setBorder(BorderFactory.createEtchedBorder());
		introField.setLineWrap(true);
		
		JLabel label_2 = new JLabel("\u6298\u6263");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_2.setBounds(454, 247, 61, 23);
		contentPane.add(label_2);
		
		discountField = new JTextField();
		discountField.setBounds(541, 247, 195, 27);
		discountField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(discountField);
		discountField.setColumns(10);
		
		JLabel label_3 = new JLabel("例如8.5折请输入8.5");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_3.setBounds(750, 247, 201, 21);
		label_3.setForeground(Color.red);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("客户类型");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_4.setBounds(433, 303, 96, 30);
		contentPane.add(label_4);
		
		String[] userType={"普通客户","普通会员","企业会员"};
		userTypeBox = new JComboBox<String>(userType);
		userTypeBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		userTypeBox.setBounds(541, 307, 195, 27);
		userTypeBox.setSelectedItem(null);
		userTypeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent evt) {
				
				// 选择框变化时要改变相关信息
				if(evt.getStateChange() == ItemEvent.SELECTED){
					String selected=(String)userTypeBox.getSelectedItem();
					
					if(selected.equals("普通会员")){
						viptypeLabel=new JLabel("会员等级");
						viptypeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
						viptypeLabel.setBounds(770,303,96,30);
						contentPane.add(viptypeLabel);
						
						String[] vipLevel={"普通会员_1","普通会员_2","普通会员_3","普通会员_4","普通会员_5"};
						vipLevelBox=new JComboBox<String>(vipLevel);
						vipLevelBox.setFont(new Font("微软雅黑", Font.PLAIN,20));
						vipLevelBox.setBounds(890,307,180,27);
						contentPane.add(vipLevelBox);	
						
						if(!isBDayBT.isEnabled()){
							isBDayBT.setEnabled(true);
						}
						if(!notBDayBT.isEnabled()){
							notBDayBT.setEnabled(true);
						}
						companyField.setEnabled(false);
						
					}else{
						if(viptypeLabel!=null&&vipLevelBox!=null){
							contentPane.remove(viptypeLabel);
							contentPane.remove(vipLevelBox);
							contentPane.repaint();
						}
						if(selected.equals("普通客户")){
						    companyField.setEnabled(false);
							isBDayBT.setEnabled(false);
							notBDayBT.setEnabled(false);
						}else{
							//企业会员的话
							if(!companyField.isEnabled()){
								companyField.setEnabled(true);
							}
							isBDayBT.setEnabled(false);
							notBDayBT.setEnabled(false);
						}
					}
				}	
			}
		});
		contentPane.add(userTypeBox);
		
		JLabel label_5 = new JLabel("\u5408\u4F5C\u4F01\u4E1A");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_5.setBounds(431, 368, 96, 23);
		contentPane.add(label_5);
		
		String tempCompany=controller.getHotelVO(hotelID).getCompany();
		String[] companies;
		if(tempCompany.equals("")||tempCompany.equals(null)){
			companies=new String[1];
			companies[0]="请添加合作企业";
		}else{
			companies=tempCompany.split("/");
		}
		
		companyField = new JComboBox<>(companies);
		companyField.setBounds(539, 368, 300, 27);
		companyField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		companyField.setSelectedItem(null);
		contentPane.add(companyField);
		
		JLabel label_9 = new JLabel("若无您想填的酒店,请先新增合作企业");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_9.setBounds(848, 368, 300, 21);
		label_9.setForeground(Color.red);
		contentPane.add(label_9);
		
		JLabel label_6 = new JLabel("开始日期");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_6.setBounds(431, 432, 96, 27);
		contentPane.add(label_6);
		
		beginDayField = new ObservingTextField();
		beginDayField.setBounds(539, 432, 195, 27);
		beginDayField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(beginDayField);
		beginDayField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_7.setBounds(431, 502, 96, 23);
		contentPane.add(label_7);
		
		endDayField = new ObservingTextField();
		endDayField.setBounds(539, 502, 195, 27);
		endDayField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(endDayField);
		endDayField.setColumns(10);
		
		JButton beginBT = new JButton(new ImageIcon("calendar.jpg"));
		beginBT.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		beginBT.setBounds(733, 431, 80, 27);
		beginBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 DatePicker dp = new DatePicker(beginDayField, Locale.CHINA);
                 // previously selected date
                 Date selectedDate = dp.parseDate(beginDayField.getText());
                 dp.setSelectedDate(selectedDate);
                 dp.start(beginDayField);
			}
		});
		contentPane.add(beginBT);
		
		JButton endBT = new JButton(new ImageIcon("calendar.jpg"));
		endBT.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		endBT.setBounds(733, 501, 80, 27);
		endBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 DatePicker dp = new DatePicker(endDayField, Locale.CHINA);
                 // previously selected date
                 Date selectedDate = dp.parseDate(endDayField.getText());
                 dp.setSelectedDate(selectedDate);
                 dp.start(endDayField);
			}
		});
		contentPane.add(endBT);
		
		JLabel label_8 = new JLabel("若无可以输入无或者不选择");
		label_8.setForeground(Color.red);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_8.setBounds(797, 505, 224, 21);
		contentPane.add(label_8);
		
		JLabel label_10 = new JLabel("\u623F\u95F4\u6570\u76EE");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_10.setBounds(431, 574, 96, 23);
		contentPane.add(label_10);
		
		roomNumField = new JTextField();
		roomNumField.setBounds(539, 574, 195, 27);
		roomNumField.setText("1");
		roomNumField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(roomNumField);
		roomNumField.setColumns(10);
		
		JLabel label_11 = new JLabel("需要预订满x间房可以享受该策略,否则请填1");
		label_11.setForeground(Color.red);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_11.setBounds(765, 577, 371, 21);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("是否生日策略");
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label_12.setBounds(387, 646, 132, 21);
		contentPane.add(label_12);
		
		JButton saveBT = new JButton(new ImageIcon("web_save.jpg"));
		saveBT.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		saveBT.setBounds(541, 723, 149, 41);
		saveBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.confirmAddStrategyButtonClicked();
			}
		});
		contentPane.add(saveBT);
		
		JButton cancelBT = new JButton(new ImageIcon("web_return.jpg"));
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		cancelBT.setBounds(822, 723, 149, 41);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.cancelButtonClicked(2);
			}
		});
		contentPane.add(cancelBT);
		
		JLabel frameLabel = new JLabel("\u65B0\u589E\u7B56\u7565");
		frameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		frameLabel.setBounds(349, 29, 108, 31);
		contentPane.add(frameLabel);
		
		notBDayBT = new JRadioButton("否",true);
		notBDayBT.setOpaque(false);
		notBDayBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		notBDayBT.setBounds(554, 642, 96, 29);
		contentPane.add(notBDayBT);
		
		isBDayBT = new JRadioButton("是",false);
		isBDayBT.setOpaque(false);
		isBDayBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		isBDayBT.setBounds(672, 642, 96, 29);
		contentPane.add(isBDayBT);
		
		choiceGroup=new ButtonGroup();
		choiceGroup.add(notBDayBT);
		choiceGroup.add(isBDayBT);
		
		
	}

	
	public void confirmAddStrategyButtonClicked(){
		
		//确认添加酒店策略执行的代码
		String name=nameField.getText();
		String intro=introField.getText();
		String str_discount=discountField.getText();
		String company=(String)companyField.getSelectedItem();
		String beginDate=beginDayField.getText();
		String endDate=endDayField.getText();
		String str_roomNumber=roomNumField.getText();
		boolean isBDay= isBDayBT.isSelected()?true:false;
		String userType="";
		double discount=0;
		int roomNumber=0;
		
		if(company==null){
			company="";
		}
		
		if("无".equals(endDate)){
			endDate = "";
		}
		if("无".equals(beginDate)){
			beginDate = "";
		}
		
		if(!"".equals(beginDate)){
			beginDate+=" 00:00:00";
		}
		if(!"".equals(endDate)){
			endDate+=" 00:00:00";
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
		if(temp.equals("普通会员")){
			userType=(String)vipLevelBox.getSelectedItem();
		}else{
			userType=temp;
		}
		if(name.equals("")||userType.equals("")||intro.equals("")||str_discount.equals("")){
			JOptionPane.showMessageDialog(this, "信息填写不完整,请重新输入","新增策略失败",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		StrategyVO vo=new StrategyVO("", name, intro, beginDate, endDate, userType, "", "", "", isBDay, "酒店营销策略", hotelID, roomNumber, company, discount);
		boolean flag=controller.addHotelStrategy(vo);
		if(flag==true){
			JOptionPane.showMessageDialog(this, "新增酒店策略成功！","操作成功",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			InitManageStrategyView view=new InitManageStrategyView(controller);
			controller.setInitManageStrategyView(view);
			view.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "新增酒店策略失败,请检查输入","操作失败",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void cancelButtonClicked(){
		int response=JOptionPane.showConfirmDialog(this, "确定要离开此页面吗？","提示",JOptionPane.YES_NO_OPTION);
		if(response==0){
			dispose();
			InitManageStrategyView view=new InitManageStrategyView(controller);
			controller.setInitManageStrategyView(view);
			view.setVisible(true);
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
		InitManageStrategyView ui=new InitManageStrategyView(controller);
		controller.setInitManageStrategyView(ui);
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
