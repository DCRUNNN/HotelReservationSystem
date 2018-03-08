package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import presentation.clientUI_account.CircleButton;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelStrategyControllerImpl;
import presentation.controller.ModifyHotelInfoViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import vo.HotelVO;
import vo.RoomVO;


public class ModifyRoomWithTypeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField priceField;
	private JTextArea introArea;
	private List<String> allRoomType;
	private List<String> allRoomState;
	private String hotelId;
	private JComboBox<String> comboBox;
	private int numOfRoomtype;
	private int numOfRoomstate;
	private RoomVO roomVO;
	private HotelRoomControllerService controller;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ModifyRoomWithTypeView(HotelRoomControllerService controller) {
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		try {
			allRoomType=controller.getRoomType(hotelId);
			allRoomState=controller.getRoomState(hotelId);
			numOfRoomtype=allRoomType.size();
			numOfRoomstate=allRoomState.size();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		init();
	}
	
	public void init(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		contentPane.add(closeLabel);
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.BLACK);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
		minLabel.setBounds(1097, 18, 26, 30);
		contentPane.add(minLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1146, 13, 40, 40);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		contentPane.add(closeBT);
		
		JButton minBT=new CircleButton("");
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
		
		contentPane.setLayout(null);
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
		
		JLabel label = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label.setBounds(70, 228, 143, 48);
		label.setFont(new Font("微软雅黑", Font.BOLD, 24));
		contentPane.add(label);
		
		JButton manageHotelBT = new JButton(new ImageIcon("manageHotel.jpg"));
		manageHotelBT.setBounds(54, 291, 170, 60);
		manageHotelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageRoomBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageStrategyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageOrderBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
		manageCompanyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		manageCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.manageCompanyButtonClicked(3);
			}
		});
		contentPane.add(manageCompanyBT);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.cyan);
//		panel.setOpaque(false);
		mainPanel.setBounds(363, 60, 778, 578);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);
		
		JLabel label_5 = new JLabel("房间价格");
		label_5.setBounds(44, 215, 88, 30);
		mainPanel.add(label_5);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		priceField = new JTextField();
		priceField.setBounds(170, 215, 192, 35);
		priceField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		mainPanel.add(priceField);
		priceField.setColumns(10);
		
		JLabel label_7 = new JLabel("房间类型");
		label_7.setBounds(44, 106, 88, 30);
		mainPanel.add(label_7);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		List<String> myRoomType= new ArrayList<String>();
		myRoomType.add("");
		myRoomType.addAll(allRoomType);
		String[] roomType=(String[])myRoomType.toArray(new String[numOfRoomtype]);
		comboBox = new JComboBox<String>(roomType);
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		comboBox.setBounds(170, 106, 192, 27);
		comboBox.addItemListener(new SelectRoomTypeListener());
		mainPanel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("房间简介");
		lblNewLabel.setBounds(44, 367, 88, 30);
		mainPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		introArea = new JTextArea();
		introArea.setBounds(170, 312, 433, 115);
		introArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		mainPanel.add(introArea);
		
		JButton confirmBT = new JButton(new ImageIcon("save.jpg"));
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		confirmBT.setBounds(500, 706, 123, 35);
		confirmBT.addActionListener(new ConfirmActionListener());
		contentPane.add(confirmBT);
		
		JButton cancelBT = new JButton(new ImageIcon("return.jpg"));
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		cancelBT.setBounds(855, 706, 123, 35);
		cancelBT.addActionListener(new BackListener());
		contentPane.add(cancelBT);
	
		
	}
	
	class ConfirmActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			controller.comfirmButtonClicked(3);
		}
		
	}
	
	class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			controller.backButtonClicked(3);
		}
		
	}
	
	class SelectRoomTypeListener implements ItemListener{
		String type="";
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if("".equals((String)e.getItem())){
				priceField.setText("");
				introArea.setText("");
			}
//			type=(String)e.getItem();
		
			switch (e.getStateChange()) {
			case ItemEvent.SELECTED:
				type=(String)e.getItem();
				break;
			default:
				break;
			}	
			
			try{
				List<RoomVO> tempList=controller.getRoomByType(hotelId, type);
				if(tempList.size()!=0){
					RoomVO tempVO=tempList.get(0);
					priceField.setText(tempVO.getPrice()+"");
					introArea.setText(tempVO.getRoomIntroduction());
				}else{
					priceField.setText("");
					introArea.setText("");
				}
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		
		
	}
	
	
	public void confirmButtonClicked(){
		String roomType=(String)comboBox.getSelectedItem();
		String roomIntro=introArea.getText();
		String tempPrice=priceField.getText();
		double price=0.0;
		boolean flag1=false;
		boolean flag2=false;
		
		if(!(tempPrice.equals(null)||tempPrice.equals(""))){
			price=Double.parseDouble(tempPrice);
		}
		
		if(roomType.equals("")||roomType.equals(null)
				||tempPrice.equals("")||tempPrice.equals(null)
				||roomIntro.equals("")||roomIntro.equals(null)){
			JOptionPane.showMessageDialog(null, "信息输入不完整！请检查输入","修改房间信息失败",JOptionPane.WARNING_MESSAGE);
		}else{
			try{
				flag1=controller.changeRoomPrice(hotelId, roomType, price);
				flag2=controller.changeRoomIntroByType(hotelId, roomType, roomIntro);
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
			if(flag1==true&&flag2==true){
				JOptionPane.showMessageDialog(null, "修改房间信息成功！","修改成功",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				InitManageRoomView view=new InitManageRoomView(controller);
				controller.setInitManageRoomView(view);
				view.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "修改房间信息失败！请检查输入","修改失败",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public void backButtonClicked(){
		int response=JOptionPane.showConfirmDialog(null, "确定要离开此页面吗？","提示",JOptionPane.YES_NO_OPTION);
		if(response==0){
			dispose();
			InitManageRoomView view=new InitManageRoomView(controller);
			controller.setInitManageRoomView(view);
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
		InitManageRoomView newFrame=new InitManageRoomView(controller);
		controller.setInitManageRoomView(newFrame);
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
