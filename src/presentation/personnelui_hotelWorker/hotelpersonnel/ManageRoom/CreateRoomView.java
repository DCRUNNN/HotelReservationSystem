package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

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

import presentation.clientUI_account.CircleButton;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
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
import runner.HotelWorkerRunner;
import vo.RoomVO;

public class CreateRoomView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField roomidField;
	private JTextField priceField;
	private JTextField stateField;
	private JTextArea roomIntroArea;
	private String hotelID;
	private JLabel label_welcome;
	private JLabel roomidLabel;

	private JComboBox<String> roomTypeBox;
	private JButton addRoomTypeBT;
	private String[] roomType;
	private String[] roomPrice;
	private int numOfRoomtype;
	
	private HotelRoomControllerService controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new HotelWorkerRunner();
//					String hotelId="00002";
//					HotelRoomControllerService controllerService=new HotelRoomControllerImpl(hotelId);
//					CreateRoomView view=new CreateRoomView(controllerService);
//					controllerService.setCreateRoomView(view);
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
	public CreateRoomView(HotelRoomControllerService controller) {
		new HotelWorkerRunner();
		this.controller=controller;
		this.hotelID=controller.getHotelId();
		
		init();
	}
	
	public void init(){
		//建立界面
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
				controller.manageInfoButtonClicked(1);
			}
		});
		contentPane.add(headButton);
		
		label_welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
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
				controller.manageHotelButtonClicked(1);
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
				controller.manageRoomButtonClicked(1);
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
				controller.manageStrategyButtonClicked(1);
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
				controller.manageOrderButtonClicked(1);
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
				controller.manageCompanyButtonClicked(1);
			}
		});
		contentPane.add(manageCompanyBT);
		
		roomidLabel = new JLabel("\u623F\u95F4\u53F7");
		roomidLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		roomidLabel.setBounds(487, 130, 98, 27);
		contentPane.add(roomidLabel);
		
		roomidField = new JTextField();
		roomidField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		roomidField.setBounds(600, 130, 211, 27);
		contentPane.add(roomidField);
		roomidField.setColumns(10);
		
		JLabel typeLabel = new JLabel("\u623F\u95F4\u7C7B\u578B");
		typeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		typeLabel.setBounds(473, 204, 133, 34);
		contentPane.add(typeLabel);
		
//		String[] roomType=(String[])allRoomType.toArray(new String[numOfRoomtype]);	
		
		String[] typeAndPrice={}; 
		String[] allRoomType={}; //酒店所有房间类型
		String temp=controller.getRoomTypeAndPrice(hotelID); //如果是空 那么酒店尚未设定房间类型及对应价格
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
		roomTypeBox = new JComboBox<String>(allRoomType);
		roomTypeBox.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		roomTypeBox.setBounds(600, 204, 211, 27);
		
		roomTypeBox.addItemListener(new SelectRoomTypeListener());
		
		contentPane.add(roomTypeBox);
		
		addRoomTypeBT=new JButton("添加新的房间类型");
		addRoomTypeBT.setFont(new Font("微软雅黑", Font.PLAIN, 18));	
		addRoomTypeBT.setBounds(835,198, 180, 35);
		addRoomTypeBT.addActionListener(new AddRoomTypeListener());
		contentPane.add(addRoomTypeBT);
		
		//设置组件
		JLabel priceLabel = new JLabel("\u623F\u4EF7");
		priceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		priceLabel.setBounds(502, 269, 75, 26);
		contentPane.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(602, 268, 209, 27);
		priceField.setFont(new Font("微软雅黑",Font.PLAIN, 20));
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		JLabel stateLabel = new JLabel("\u623F\u95F4\u72B6\u6001");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		stateLabel.setBounds(473, 336, 114, 34);
		contentPane.add(stateLabel);
		
		JLabel introLabel = new JLabel("\u623F\u95F4\u4ECB\u7ECD");
		introLabel.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		introLabel.setBounds(473, 455, 122, 34);
		contentPane.add(introLabel);
		
		stateField = new JTextField();
		stateField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateField.setEditable(false);
		stateField.setText("\u7A7A\u95F2");
		stateField.setBounds(602, 335, 209, 35);
		contentPane.add(stateField);
		stateField.setColumns(10);
		
		roomIntroArea = new JTextArea();
		roomIntroArea.setBounds(602, 410, 455, 131);
		roomIntroArea.setBorder(BorderFactory.createEtchedBorder());
		roomIntroArea.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		contentPane.add(roomIntroArea);
		
		JButton confirmBT = new JButton(new ImageIcon("save.jpg"));
		confirmBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		confirmBT.setBounds(588, 616, 123, 40);
		confirmBT.addActionListener(new ConfirmListener());
		contentPane.add(confirmBT);
		
		JButton cancelBT = new JButton(new ImageIcon("return4.jpg"));
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		cancelBT.setBounds(841, 616, 123, 40);
		cancelBT.addActionListener(new CancelListener());
		contentPane.add(cancelBT);
		
		JLabel frameLabel = new JLabel("\u65B0\u589E\u623F\u95F4");
		frameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		frameLabel.setBounds(366, 32, 156, 40);
		contentPane.add(frameLabel);
	}
	
	class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			controller.comfirmButtonClicked(1);
		}
		
	}
	
	class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			controller.backButtonClicked(1);
		}
		
	}
	
	class SelectRoomTypeListener implements ItemListener{
		
		String type;

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if("".equals((String)e.getItem())){
				priceField.setText("");
				roomIntroArea.setText("");
			}
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
						roomIntroArea.setText("");
					}else{
						for(int i=0;i<numOfRoomtype;i++){
							if(roomType[i].equals(type)){
								//默认的价格是酒店新增房型的时候设定的价格
								//一般房间价格不可变动
								priceField.setText(roomPrice[i]);
								
								List<RoomVO> tempList=controller.getRoomByType(hotelID, type);
								if(tempList!=null&&tempList.size()!=0){
									RoomVO tempVO=tempList.get(0);
									roomIntroArea.setText(tempVO.getRoomIntroduction());
								}else{
									
									roomIntroArea.setText("请输入房间介绍");
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
	
	class AddRoomTypeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame tempFrame=new JFrame("新增房型");
			tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			tempFrame.setBounds(370, 300, 558, 379);
			JPanel tempPanel = new JPanel();
			tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			tempFrame.setContentPane(tempPanel);
			tempPanel.setLayout(null);
			
			JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B");
			label.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			label.setBounds(49, 54, 89, 34);
			tempPanel.add(label);
			
			JTextField typeField = new JTextField();
			typeField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
			typeField.setBounds(151, 56, 273, 35);
			tempPanel.add(typeField);
			typeField.setColumns(20);
			
			JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C");
			label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			label_1.setBounds(49, 147, 89, 28);
			tempPanel.add(label_1);
			
			priceField = new JTextField();
			priceField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
			priceField.setBounds(151, 147, 273, 35);
			tempPanel.add(priceField);
			priceField.setColumns(20);
			
			JButton saveBT = new JButton("保存");
			saveBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
			saveBT.setBounds(107, 247, 123, 29);
			saveBT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String roomType=typeField.getText();
					String price=priceField.getText();
					if(roomType.equals("")||price.equals("")){
						JOptionPane.showMessageDialog(tempFrame, "信息输入不完整","新增失败",JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					boolean flag=controller.addRoomTypeAndPrice(hotelID, roomType, Double.parseDouble(price));
					if(flag==true){
						JOptionPane.showMessageDialog(tempFrame, "新增成功！","",JOptionPane.INFORMATION_MESSAGE);
						tempFrame.dispose();
						dispose();
						CreateRoomView view=new CreateRoomView(controller);
						controller.setCreateRoomView(view);
						view.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(tempFrame, "新增失败","",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			tempPanel.add(saveBT);
			
			JButton cancelBT = new JButton("取消");
			cancelBT.setFont(new Font("宋体", Font.PLAIN, 21));
			cancelBT.setBounds(319, 248, 123,29);
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
		
	}
	
	
	public void comfirmButtonClicked(){
		
		String roomId=roomidField.getText();
		String roomType=(String)roomTypeBox.getSelectedItem();
		String state=stateField.getText();
		String intro=roomIntroArea.getText();
		String bookDate="未预定";
		double price = 0;
		
		if(!(priceField.getText().equals("")||priceField.getText().equals(null))){
			 price=Double.parseDouble(priceField.getText());
		}
		
		if(roomId.equals("")||roomId.equals(null)||priceField.getText().equals("")||priceField.getText().equals(null)
				||state.equals("")||state.equals(null)||intro.equals("")||intro.equals(null)){
		
			JOptionPane.showMessageDialog(null, "信息输入不完整！","新增房间失败",JOptionPane.WARNING_MESSAGE);
		}else{
			RoomVO vo=new RoomVO(hotelID, roomType, price, state, bookDate, roomId, intro);
			
			boolean flag=false;
			
			//判断房间号是否重复
			List<RoomVO> roomList=controller.getAllRoomList(hotelID);
			for(int i=0;i<roomList.size();i++){
				if(roomList.get(i).getRoomNumber().equals(roomId)){
					flag=false;
					JOptionPane.showMessageDialog(this, "该房间号已存在！","新增失败",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			try{
			 	flag=controller.createRoom(vo);
			 	if(flag==true){
			 		JOptionPane.showMessageDialog(this, "已成功添加房间，房间号为"+roomId, "新增房间成功", JOptionPane.INFORMATION_MESSAGE);
			 	}else{
			 		JOptionPane.showMessageDialog(this, "创建房间失败,请检查信息填写是否正确","新增房间失败",JOptionPane.WARNING_MESSAGE);
			 	}
			 	dispose();
				InitManageRoomView view=new InitManageRoomView(controller);
				controller.setInitManageRoomView(view);
				view.setVisible(true);
			}catch(Exception e){
				e.printStackTrace();
			}
		}//end else
	}//end method

	public void cancelButtonClicked(){
		String[] options={"确定","取消"};
		int response=JOptionPane.showOptionDialog(this,"确定要离开当前页面吗？", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
		if(response==0){
			dispose();
			InitManageRoomView view=new InitManageRoomView(controller);
			controller.setInitManageRoomView(view);
			view.setVisible(true);
		}else{
			
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
		InitManageRoomView view=new InitManageRoomView(controller);
		controller.setInitManageRoomView(view);
		view.setVisible(true);
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
