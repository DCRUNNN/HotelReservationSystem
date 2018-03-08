package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import vo.RoomVO;

public class ModifyRoomView extends JFrame {

	private JPanel contentPane;
	private JTextField roomIdField;
	private JTextField priceField;
	private JTextField typeField;
	private JTextArea  introArea;
	private JComboBox<String> typeBox;
	private JComboBox<String> stateBox;
//	private List<String> allRoomType;
	private String[] roomType;
	private String[] roomPrice;
	private String hotelId;
	private int numOfRoomtype;
	

	private HotelRoomControllerService controller;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ModifyRoomView frame = new ModifyRoomView();
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
	public ModifyRoomView(HotelRoomControllerService controller) {

		this.controller=controller;
		this.hotelId=controller.getHotelId();	
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
				controller.manageInfoButtonClicked(2);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
//		panel.setOpaque(false);
		panel.setBounds(363, 60, 778, 578);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_4= new JLabel("房间号");
		label_4.setBounds(56, 46, 66, 30);
		panel.add(label_4);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		roomIdField = new JTextField();
		roomIdField.setBounds(150, 50, 192, 27);
		roomIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		roomIdField.addFocusListener(new GetRoomIDListener());
		panel.add(roomIdField);
		roomIdField.setColumns(10);
		
		JLabel label_7 = new JLabel("房间类型");
		label_7.setBounds(44, 126, 88, 30);
		panel.add(label_7);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		//得到酒店所有房间类型
		String[] typeAndPrice={}; 
		String[] allRoomType={}; //酒店所有房间类型
		String temp=controller.getRoomTypeAndPrice(hotelId); //如果是空 那么酒店尚未设定房间类型及对应价格
		if(temp.equals("")||temp.equals(null)){
			numOfRoomtype=0; 
			roomType=new String[1];
			roomType[0]="房间类型为空";
		}else{
			typeAndPrice=temp.split("/");
			roomType=new String[typeAndPrice.length];
			roomPrice=new String[typeAndPrice.length];
			
			for(int i=0;i<typeAndPrice.length;i++){
				int poi=typeAndPrice[i].indexOf("|");
				roomType[i]=typeAndPrice[i].substring(0, poi);
				roomPrice[i]=typeAndPrice[i].substring(poi+1);
			}
			
			numOfRoomtype=roomType.length;
			
			allRoomType=new String[numOfRoomtype+1];
			for(int i=0;i<numOfRoomtype+1;i++){
				if(i==0){
					allRoomType[i]="";
				}else{
					allRoomType[i]=roomType[i-1];
				}
			}
		}
		
		typeBox = new JComboBox<String>(allRoomType);
		typeBox.setBounds(150, 130, 192, 27);
		typeBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
//		typeBox.setEditable(false);
		//一开始默认这个下拉框不可显示,除非工作人员要修改该房间类型,点击修改按钮后则把typefield设为不可显示,而显示这个下拉框
		typeBox.setVisible(false);
		typeBox.addItemListener(new SelectRoomTypeListener());
		panel.add(typeBox);

		//默认显示这个不可编辑的文本框,用来显示房间类型
		typeField=new JTextField();
		typeField.setBounds(150, 130, 192, 27);
		typeField.setEditable(false);
		typeField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel.add(typeField);
		typeField.setColumns(20);
		
		JButton editTypeBT=new JButton("修改房间类型");
		editTypeBT.setBounds(345, 130, 150, 27);
		editTypeBT.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		panel.add(editTypeBT);
		editTypeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				typeBox.setVisible(true);
				typeField.setVisible(false);
			}
		});
		
		JLabel label_6 = new JLabel("房间状态");
		label_6.setBounds(44, 208, 88, 30);
		panel.add(label_6);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		String[] roomState={"空闲","已预订","已入住"};
		stateBox = new JComboBox<String>(roomState);
		stateBox.setBounds(150, 212, 192, 27);
		stateBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel.add(stateBox);
		
		JLabel label_5 = new JLabel("房间价格");
		label_5.setBounds(44, 295, 88, 30);
		panel.add(label_5);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		priceField = new JTextField();
		priceField.setBounds(150, 299, 192, 27);
		priceField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel.add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("房间简介");
		lblNewLabel.setBounds(44, 407, 88, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		
		introArea = new JTextArea();
		introArea.setBounds(151, 372, 433, 115);
		introArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		panel.add(introArea);
		
		JButton confirmBT = new JButton(new ImageIcon("save.jpg"));
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		confirmBT.setBounds(500, 706, 123, 35);
		confirmBT.addActionListener(new ConfirmListener());
		contentPane.add(confirmBT);
		
		JButton backBT = new JButton(new ImageIcon("return.jpg"));
		backBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		backBT.setBounds(770, 706, 123, 35);
		backBT.addActionListener(new BackListener());
		contentPane.add(backBT);

		panel.setOpaque(false);
		//contentPane.setOpaque(false);
	}
	
	class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controller.comfirmButtonClicked(2);
		}
		
	}
	
	
	class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controller.backButtonClicked(2);
		}
		
	}
	
	class SelectRoomTypeListener implements ItemListener{
		//选择房间类型框变化时自动显示一些信息
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
				if(numOfRoomtype==0){
					
				}else{
					if(type.equals("")){
						priceField.setText("");
						introArea.setText("");
					}else{
						for(int i=0;i<numOfRoomtype;i++){
							if(roomType[i].equals(type)){
								//默认的价格是酒店新增房型的时候设定的价格
								//一般房间价格不可变动
								priceField.setText(roomPrice[i]);
								
								List<RoomVO> tempList=controller.getRoomByType(hotelId, type);
								if(tempList!=null&&tempList.size()!=0){
									RoomVO tempVO=tempList.get(0);
									introArea.setText(tempVO.getRoomIntroduction());
								}else{
									introArea.setText("请输入房间介绍");
								}
								break;
							}
						}//end for
					}//end else
				}//end outside else
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		
	}
	
	
	public void confirmButtonClicked(){
		
		String roomNumber=roomIdField.getText();
		String roomType=(String)typeBox.getSelectedItem();
		String roomState=(String)stateBox.getSelectedItem();
		String tempPrice=priceField.getText();
		String roomIntro=introArea.getText();
		double price=0.0;
		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		boolean flag4=false;
		
		if(!(tempPrice.equals(null)||tempPrice.equals(""))){
			price=Double.parseDouble(tempPrice);
		}
		if(roomNumber.equals("")||roomNumber.equals(null)
				||roomType.equals("")||roomType.equals(null)
				||tempPrice.equals("")||tempPrice.equals(null)
				||roomIntro.equals("")||roomIntro.equals(null)){
			JOptionPane.showMessageDialog(null, "信息输入不完整！请检查输入","修改房间信息失败",JOptionPane.WARNING_MESSAGE);
		}else{
			try{
				flag1=controller.changeRoomPriceById(hotelId, price, roomNumber);
				flag2=controller.changeRoomIntroByType(hotelId, roomType, roomIntro);
				flag3=controller.changeRoomState(hotelId, roomNumber, roomState);
				flag4=controller.changeRoomType(hotelId, roomNumber, roomType);
				
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
			if(flag1==true&&flag2==true&&flag3==true||flag4==true){
				JOptionPane.showMessageDialog(null, roomNumber+"房间信息修改成功！","修改成功",JOptionPane.INFORMATION_MESSAGE);
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
	
	class GetRoomIDListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			//得到焦点时执行的 
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			//失去焦点时执行的代码
			String roomId=roomIdField.getText();
			if(!roomId.equals("")){
				RoomVO room=controller.getRoomByNum(hotelId, roomId);
				if(!(room==null)){
					String type=room.getRoomType();
					for(int i=0;i<typeBox.getItemCount();i++){
						if(typeBox.getItemAt(i).equals(type)){
							typeField.setText(type);
							typeBox.setSelectedIndex(i);
							break;
						}
					}
				}else{//不存在这个房间类型
					typeBox.setSelectedIndex(0);
				}
				
			}
		}
		
	}
}
