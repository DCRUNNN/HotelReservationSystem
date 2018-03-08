package presentation.personnelui_hotelWorker.hotelpersonnel.Init;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.HotelStrategyControllerImpl;
import presentation.controller.ModifyHotelInfoViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.help.HotelPicture;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientAbnormalOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientExecutedOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ShowClientOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import runner.HotelWorkerRunner;
import sun.awt.IconInfo;
import vo.HotelVO;



public class InitHotelView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private String hotelId;
	
	private HotelVO hotelVO;

	private ImageIcon icon;
	private InitHotelViewControllerService controller;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */

	public InitHotelView(InitHotelViewControllerService controller) {
		new HotelWorkerRunner();
		this.controller=controller;
		this.hotelId=controller.getHotelId();
//		hotelHelper=HotelWorkerRemoteHelper.getInstance().getMaintainHotelMessageService();
		init();
	}
	
	public void init(){
		//设置窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background.jpg").getImage();
		contentPane = new BackgroundPanel(new ImageIcon("background6.jpg").getImage());
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(282, 108, 878, 638);
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.setLayout(null);		
		
		//最小化与关闭按钮
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
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
				controller.manageInfoButtonClicked();
			}
		});
		contentPane.add(headButton);
		
		//设置界面组件
		JLabel label = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label.setBounds(70, 228, 143, 48);
		label.setFont(new Font("微软雅黑", Font.BOLD, 24));
		contentPane.add(label);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageStrategyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageOrderBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageCompanyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked();
			}
		});
		contentPane.add(manageCompanyBT);
		
		JButton checkinBT = new JButton(new ImageIcon("checkIn.jpg"));
		checkinBT.setBounds(339, 40, 120, 40);
		checkinBT.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		checkinBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.CheckInButtonClicked();
			}
		});
		contentPane.add(checkinBT);
		
		JButton checkoutBT = new JButton(new ImageIcon("checkOut.jpg"));
		checkoutBT.setBounds(504, 40, 120, 40);
		checkoutBT.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		checkoutBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.checkOutButtonClicked();
			}
		});
		contentPane.add(checkoutBT);
		
		JButton delayCheckinBT = new JButton(new ImageIcon("delay.jpg"));
		delayCheckinBT.setBounds(666, 40, 153, 40);
		delayCheckinBT.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		delayCheckinBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.delayButtonClicked();
			}
		});
		contentPane.add(delayCheckinBT);
		
		//得到一个hotelVO 获取vo里的信息显示在界面对应组件上
		hotelVO=controller.getHotelVO(hotelId);
		
		JLabel hotelNameLabel = new JLabel(hotelVO.getHotelName());
		hotelNameLabel.setBounds(41, 15, 279, 48);
		hotelNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		bottomPanel.add(hotelNameLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 78, 840, 2);
		bottomPanel.add(separator);
		
		JLabel hotelIntroLabel = new JLabel("\u7B80\u4ECB");
		hotelIntroLabel.setBounds(60, 95, 53, 21);
		hotelIntroLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(hotelIntroLabel);
		
		JLabel label_3 = new JLabel("\u5730\u5740");
		label_3.setBounds(60, 154, 59, 21);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_4.setBounds(38, 217, 81, 21);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\u6240\u5728\u5546\u5708");
		label_5.setBounds(520, 154, 81, 21);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_5);
		
		JLabel label_6 = new JLabel("\u661F\u7EA7");
		label_6.setBounds(531, 217, 59, 21);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_6);
		
		JLabel label_7 = new JLabel("\u9152\u5E97\u56FE\u7247");
		label_7.setBounds(38, 327, 81, 21);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_7);
		
		JLabel label_8 = new JLabel("\u9152\u5E97\u8BBE\u65BD");
		label_8.setBounds(31, 495, 81, 21);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		bottomPanel.add(label_8);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 131, 840, 2);
		bottomPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 190, 840, 2);
		bottomPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(15, 256, 840, 2);
		bottomPanel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(15, 432, 840, 2);
		bottomPanel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(15, 620, 840, 2);
		bottomPanel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(461, 131, 1, 121);
		bottomPanel.add(separator_6);
		
		JLabel hotelIntroContent = new JLabel(hotelVO.getIntroduction());
		hotelIntroContent.setBounds(128, 95, 386, 21);
		hotelIntroContent.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottomPanel.add(hotelIntroContent);
		
		JLabel addContent = new JLabel(hotelVO.getHotelProvince()+hotelVO.getHotelCity()+hotelVO.getHotelAddress());
		addContent.setBounds(124, 154, 380, 21);
		addContent.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottomPanel.add(addContent);
		
		JLabel cbdContent = new JLabel(hotelVO.getHotelCBD());
		cbdContent.setBounds(616, 154, 219, 21);
		cbdContent.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottomPanel.add(cbdContent);
		
		JLabel telContent = new JLabel(hotelVO.getTelephone());
		telContent.setBounds(134, 218, 258, 21);
		telContent.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottomPanel.add(telContent);
		
		JLabel starContent = new JLabel(String.valueOf(hotelVO.getHotelStar()));
		starContent.setBounds(584, 218, 81, 21);
		starContent.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottomPanel.add(starContent);
		
		//初始化设置label的图片
		JLabel picLabel = new JLabel();
		picLabel.setBorder(BorderFactory.createEtchedBorder());
		picLabel.setBounds(152, 273, 162, 150);
		picLabel.setBackground(Color.CYAN);
		boolean isExist=HotelPicture.isExist(hotelId);
		if(isExist==true){
			icon=new ImageIcon(HotelPicture.getLocalPicture(hotelId));
		}else{
			byte[] picByte=controller.getHotelPicture(hotelId);
			if(picByte==null){
				//尚未设置图片 服务器端和客户端都没有图片 则显示默认图片
				icon=new ImageIcon("hoteldefaultpicture.jpg");
			}else{
				icon=new ImageIcon(HotelPicture.changeByteAndSave(picByte, hotelId));	
			}
		}
		
		//实现图片根据label的大小进行缩放
		icon=new ImageIcon(icon.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_DEFAULT));
		
		picLabel.setIcon(icon);
		bottomPanel.add(picLabel);
		
		//显示酒店设施的区域
		JTextArea equipmentArea = new JTextArea();
		equipmentArea.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		equipmentArea.setEditable(false);
		equipmentArea.setBounds(145, 461, 500, 110);
		equipmentArea.setOpaque(false);
//		equipmentArea.setBorder(BorderFactory.createEtchedBorder());
		equipmentArea.setLineWrap(true);
		equipmentArea.setText(hotelVO.getFacilities());
		bottomPanel.add(equipmentArea);
	
		bottomPanel.setOpaque(false);
		contentPane.add(bottomPanel);
	}
	
	
	public void checkInButtonClicked(){
		//为客户办理入住 显示界面 执行相关操作
		JFrame tempFrame=new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(600, 300, 450, 300);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel lblid = new JLabel("请输入客户ID");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblid.setBounds(31, 43, 189, 27);
		tempPanel.add(lblid);		
		
		JTextField IdField = new JTextField();
		IdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		IdField.setBounds(72, 112, 275, 29);
		tempPanel.add(IdField);
		IdField.setColumns(10);
		
		JButton confirmBT = new JButton("确认");
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmBT.setBounds(72, 189, 111, 29);
		confirmBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String clientID=IdField.getText();
				if(clientID.equals("")||clientID.equals(null)){
					//要先输入客户的ID
					JOptionPane.showMessageDialog(tempFrame, "请输入客户ID！","信息输入不完整",JOptionPane.WARNING_MESSAGE);
				}else{
					HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientID, "");
					if(controllerService.getUnexecutedOrders(hotelId, clientID).size()==0){
						JOptionPane.showMessageDialog(null, "该客户尚未有订单","",JOptionPane.INFORMATION_MESSAGE);
						tempFrame.dispose();
					}else{
						//输入ID正确后跳转到订单处理界面
						controllerService=new HotelOrderControllerImpl(hotelId,clientID,"");
						ShowClientOrderView view=new ShowClientOrderView(controllerService);
						controllerService.setShowClientOrderView(view);
						view.setVisible(true);
						tempFrame.dispose();
						dispose();
					}
				
				}
			}
		});
		tempPanel.add(confirmBT);
		
		JButton cancelBT = new JButton("取消");
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(236, 189, 111, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
	
		
		tempFrame.setVisible(true);
	}
	
	public void checkOutButtonClicked(){
		//办理退房操作
		JFrame tempFrame=new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(600, 300, 450, 300);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel lblid = new JLabel("请输入客户ID");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblid.setBounds(31, 43, 189, 27);
		tempPanel.add(lblid);		
		
		JTextField IdField = new JTextField();
		IdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		IdField.setBounds(72, 112, 275, 29);
		tempPanel.add(IdField);
		IdField.setColumns(10);
		
		JButton confirmBT = new JButton("确认");
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		confirmBT.setBounds(72, 189, 111, 29);
		confirmBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String clientID=IdField.getText();
				if(clientID.equals("")||clientID.equals(null)){
					JOptionPane.showMessageDialog(tempFrame, "请输入客户ID！","信息输入不完整",JOptionPane.WARNING_MESSAGE);
				}else{
					HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientID, "");
					if(controllerService.getAllRooms(clientID, hotelId).size()==0){
						JOptionPane.showMessageDialog(null, "该客户尚未有订单","",JOptionPane.INFORMATION_MESSAGE);
						tempFrame.dispose();
					}else{
						//跳转到处理界面
						ShowClientExecutedOrderView view=new ShowClientExecutedOrderView(controllerService);
						controllerService.setShowClientExecutedOrderView(view);
						view.setVisible(true);
						tempFrame.dispose();
						dispose();
					}
				}
			
			}
		});
		tempPanel.add(confirmBT);
		
		JButton cancelBT = new JButton("取消");
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(236, 189, 111, 29);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tempFrame.dispose();
			}
		});
		tempPanel.add(cancelBT);
	
		tempFrame.setVisible(true);
	}
	
	public void delayButtonClicked(){
		//办理延迟入住
		controller.manageOrderButtonClicked();
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
