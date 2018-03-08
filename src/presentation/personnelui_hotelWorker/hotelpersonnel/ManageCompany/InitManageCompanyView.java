package presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

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
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.ModifyHotelInfoViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.HotelStrategyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy.InitManageStrategyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.HotelVO;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class InitManageCompanyView extends JFrame {

	private JPanel contentPane;

	private String hotelId;

	private HotelCoCompanyControllerService controller;
	
	private CompanyTable myTable;
	
	private JTable companyTable;
	
	private JTextField nameField;
	private JTextField provinceField;
	private JTextField cityFIeld;
	private JTextField detailedField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new HotelWorkerRunner();
					HotelCoCompanyControllerService controller=new HotelCoCompanyControllerImpl("00001");
					InitManageCompanyView frame = new InitManageCompanyView(controller);
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
	public InitManageCompanyView(HotelCoCompanyControllerService controller) {
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		init();
		initCompanyTable();
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background6.jpg").getImage();
		contentPane = new BackgroundPanel(new ImageIcon("background6.jpg").getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

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
		contentPane.setLayout(null);
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
		
		JButton addCompanyBT = new JButton(new ImageIcon("addNewCompany.jpg"));
		addCompanyBT.setBounds(406, 685, 170, 41);
		addCompanyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		addCompanyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.addCompanyButtonClicked();
			}
		});
		contentPane.add(addCompanyBT);
		
		JButton deleteBT = new JButton(new ImageIcon("delete.jpg"));
		deleteBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deleteBT.setBounds(677, 685, 138, 41);
		deleteBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.deleteCompanyButtonClicked();
			}
		});
		contentPane.add(deleteBT);
		
		JButton backBT = new JButton(new ImageIcon("return3_hotel.jpg"));
		backBT.setBounds(902, 685, 138, 41);
		backBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		backBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.backButtonClicked();
			}
		});
		contentPane.add(backBT);
		
	}
	
	public void initCompanyTable(){
		//初始化合作企业的表格
		String[] titleName={"编号","企业地址"};
		
		//数据
		HotelVO myHotel=controller.getHotelVO(hotelId);
		String[] company=myHotel.getCompany().split("/");
		int numOfCompany=company.length;
		
		for(int i=0;i<numOfCompany;i++){
			if(company[i].equals("null")){
				company[i]="";
			}
		}
		
		String[][] data=new String[numOfCompany][];
		for(int i=0;i<numOfCompany;i++){
			data[i]=new String[titleName.length];
			String[] s=new String[]{toInteger(i),company[i]};
			
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		//模型
		myTable=new CompanyTable(data, titleName);
		
		//表格
		companyTable=new JTable();
		companyTable.setBounds(1, 1, 810, 523);
		contentPane.add(companyTable);
		companyTable.setModel(myTable);
		companyTable.setBorder(BorderFactory.createEtchedBorder());
		companyTable.setFillsViewportHeight(true);
		companyTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		companyTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		companyTable.setRowHeight(25);
		companyTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(companyTable);
		scrollPane.setBounds(334, 79, 820, 535);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
				
		// 设置table表头居中
		DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
		thRenderer.setHorizontalAlignment(JLabel.CENTER);
		companyTable.getTableHeader().setDefaultRenderer(thRenderer);
		// 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    companyTable.setDefaultRenderer(Object.class, tcRender);
		
	    //设置列宽度
	    for(int i=0;i<companyTable.getColumnCount();i++){
	    	if(i==0){
	    		companyTable.getColumnModel().getColumn(i).setPreferredWidth(30);
	    	}else if(i==1){
	    		companyTable.getColumnModel().getColumn(i).setPreferredWidth(460);
	    	}
	    }
	   contentPane.add(scrollPane);	
	   
	}
	

	public void addCompanyButtonClicked(){
		//添加合作企业要执行的
		JFrame tempFrame=new JFrame();
		tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tempFrame.setBounds(450, 220, 621, 367);
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tempFrame.setContentPane(tempPanel);
		tempPanel.setLayout(null);
		
		JLabel label = new JLabel("\u4F01\u4E1A\u540D\u79F0");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(49, 54, 89, 34);
		tempPanel.add(label);
		
		nameField = new JTextField();
		nameField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		nameField.setBounds(151, 56, 348, 28);
		tempPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F01\u4E1A\u5730\u5740");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_1.setBounds(49, 147, 81, 28);
		tempPanel.add(label_1);
		
		provinceField = new JTextField();
		provinceField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		provinceField.setBounds(151, 149, 73, 27);
		tempPanel.add(provinceField);
		provinceField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7701");
		label_2.setBounds(226, 152, 31, 21);
		tempPanel.add(label_2);
		
		cityFIeld = new JTextField();
		cityFIeld.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		cityFIeld.setBounds(256, 152, 96, 27);
		tempPanel.add(cityFIeld);
		cityFIeld.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5E02");
		label_3.setBounds(355, 152, 24, 21);
		tempPanel.add(label_3);
		
		detailedField = new JTextField();
		detailedField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		detailedField.setBounds(383, 149, 188, 27);
		tempPanel.add(detailedField);
		detailedField.setColumns(10);
		
		JButton saveBT = new JButton("\u4FDD\u5B58");
		saveBT.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		saveBT.setBounds(123, 247, 123, 29);
		saveBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(provinceField.getText().equals("")||cityFIeld.getText().equals("")||detailedField.getText().equals("")
						||nameField.getText().equals("")){
					JOptionPane.showMessageDialog(tempFrame, "请输入完整信息","信息填写不完整",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String companyAdd=provinceField.getText()+cityFIeld.getText()+detailedField.getText()+nameField.getText();
				boolean flag=controller.addCompany(hotelId, companyAdd);
				
				if(flag==true){
					JOptionPane.showMessageDialog(tempFrame, "新增合作企业成功","操作成功",JOptionPane.INFORMATION_MESSAGE);
					tempFrame.dispose();
					controller.manageCompanyButtonClicked();
				}else{
					JOptionPane.showMessageDialog(tempFrame, "新增合作企业失败","操作失败",JOptionPane.ERROR_MESSAGE);
					tempFrame.dispose();
				}
				
			}
		});
		tempPanel.add(saveBT);
		
		JButton cancelBT = new JButton("\u53D6\u6D88");
		cancelBT.setFont(new Font("宋体", Font.PLAIN, 21));
		cancelBT.setBounds(335, 248, 123, 29);
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
	
	public void deleteCompanyButtonClicked(){
		//删除合作企业
		int index=companyTable.getSelectedRow();//获得选取的行号
		
		if(index==-1){
			JOptionPane.showMessageDialog(this, "请选择要删除的合作企业！","",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String add=(String)companyTable.getValueAt(index, 1);
		int response=JOptionPane.showConfirmDialog(this, "确定要解除与该企业的合作关系吗？","",JOptionPane.YES_NO_OPTION);
		if(response==0){
			boolean flag=controller.deleteCompany(hotelId, add);
			if(flag==true){
				JOptionPane.showMessageDialog(this, "删除成功!","",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				controller.manageCompanyButtonClicked();
			}else{
				JOptionPane.showMessageDialog(this, "删除失败！","",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public String toInteger(int i){
		//为了显示若没有合作企业 应该不显示数字在列表上的 好像有点问题
		return i+1+"";
	}
	
	public void backButtonClicked(){
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
		dispose();
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
		InitManageCompanyView view=new InitManageCompanyView(controller);
		controller.setInitManageCompanyView(view);
		view.setVisible(true);
		dispose();
	}
}
