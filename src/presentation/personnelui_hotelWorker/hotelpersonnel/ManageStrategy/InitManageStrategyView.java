package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.sun.glass.ui.View;

import presentation.clientUI_account.CircleButton;
import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.controller.HotelCoCompanyControllerImpl;
import presentation.controller.HotelOrderControllerImpl;
import presentation.controller.HotelRoomControllerImpl;
import presentation.controller.HotelStrategyControllerImpl;
import presentation.controller.InitHotelViewControllerImpl;
import presentation.controller.MyInfoControllerImpl;
import presentation.personnelui_hotelWorker.BackgroundPanel;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.HotelCoCompanyControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageCompany.InitManageCompanyView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.HotelOrderControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder.ManageOrderView;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.HotelRoomControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom.InitManageRoomView;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoControllerService;
import presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo.MyInfoView;
import rmi.HotelWorkerRemoteHelper;
import runner.HotelWorkerRunner;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.StrategyVO;


public class InitManageStrategyView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelId;;
	private JPanel contentPane;
	private JTable strategyTable;
	private HotelStrategyControllerService controller;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public InitManageStrategyView(HotelStrategyControllerService controller)  {
		new HotelWorkerRunner();
		this.controller=controller;
		hotelId=controller.getHotelId();
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
				controller.manageInfoButtonClicked(1);
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
			public void actionPerformed(ActionEvent e) {
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
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(305, 65, 877, 541);
		tablePanel.setLayout(new BorderLayout());
		
		//建立表格
		String[] titleName={"策略编号","策略名称","起始时间","结束时间","折扣","合作企业"};
		
		//数据
		List<StrategyVO> strategyList=controller.getAllHotelStrategy(hotelId);
		String[][] data=new String[strategyList.size()][];
		for(int i=0;i<strategyList.size();i++){
			StrategyVO temp=strategyList.get(i);
			//"策略编号","策略名称","起始时间","结束时间","折扣","合作企业"
			data[i]=new String[titleName.length];
			String[] s=new String[]{temp.getStrategyID(),temp.getName(),temp.getBeginTime()
					,temp.getEndTime(),temp.getStrategy_discount()+"",temp.getCompanyAddress()};
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		StrategyTable myTable=new StrategyTable(data,titleName);
		
		strategyTable=new JTable(myTable);
		strategyTable.setBorder(BorderFactory.createEtchedBorder());
		
		strategyTable.setFillsViewportHeight(true);  
		
		strategyTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 17));
		strategyTable.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JScrollPane scroll=new JScrollPane(strategyTable);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setUI(new MultiScrollPaneUI());
		
	    // 设置table表头居中
	    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
	    thRenderer.setHorizontalAlignment(JLabel.CENTER);
	    strategyTable.getTableHeader().setDefaultRenderer(thRenderer);
	    // 设置table内容居中
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    strategyTable.setDefaultRenderer(Object.class, tcRender);
	    
		for(int i=0;i<strategyTable.getColumnCount();i++){
			if(i==0){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(20);
			}else if(i==1){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(83);
			}else if(i==5){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(85);
			}else if(i==2||i==3){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(85);
			}else{
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(0);
			}
		}
		strategyTable.setRowHeight(25);

		
		tablePanel.add(scroll,BorderLayout.CENTER);
		tablePanel.setOpaque(false);
		contentPane.add(tablePanel);
		
		JButton addBT=new JButton(new ImageIcon("addStrategy.jpg"));
		addBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		addBT.setBounds(399,660,150,40);
		addBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.addStrategyButtonClicked();
			}
		});
		contentPane.add(addBT);
		
		JButton modifyBT=new JButton(new ImageIcon("modifyStrategy.jpg"));
		modifyBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		modifyBT.setBounds(593,660,150,40);
		modifyBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.modifyStrategyButtonClicked();
			}
		});
		contentPane.add(modifyBT);
		
		JButton deleteBT=new JButton(new ImageIcon("delete2.jpg"));
		deleteBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		deleteBT.setBounds(788,660,150,40);
		deleteBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.deleteButtonClicked();
			}
		});
		contentPane.add(deleteBT);
		
		JButton cancelBT = new JButton(new ImageIcon("return3.jpg"));
		cancelBT.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		cancelBT.setBounds(979, 660, 150, 40);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.cancelButtonClicked(1);
			}
		});
		contentPane.add(cancelBT);
	}
	
	public void manageHotelButtonClicked(){
		dispose();
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
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
	
	public void addStrategyButtonClicked(){
		AddHotelStrategyView view=new AddHotelStrategyView(controller);
		controller.setAddHotelStrategyView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void modifyStrategyButtonClicked(){
		int index=strategyTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(this, "请选择策略！","",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String strategyId=(String)strategyTable.getValueAt(index, 0);
		dispose();
		HotelStrategyControllerService controllerService=new HotelStrategyControllerImpl(hotelId, strategyId);
		ModifyStrategyView view=new ModifyStrategyView(controllerService);
		controllerService.setModifyHotelStrategyView(view);
		view.setVisible(true);
	}
	
	public void cancelButtonClicked(){
		InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
		InitHotelView view=new InitHotelView(controllerService);
		controllerService.setView(view);
		view.setVisible(true);
		dispose();
	}
	
	public void deleteButtonClicked(){
		int index=strategyTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(this, "请选择要删除的策略！","",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String strategyId=(String)strategyTable.getValueAt(index, 0);
		
		int response=JOptionPane.showConfirmDialog(this, "确定要删除该策略吗？","提示",JOptionPane.YES_NO_OPTION);
		if(response==0){
			boolean flag=controller.deleteHotelStrategy(strategyId);
			if(flag==true){
				JOptionPane.showMessageDialog(this, "删除成功!","操作成功",JOptionPane.INFORMATION_MESSAGE);
				controller.manageStrategyButtonClicked(1);
			}else{
				JOptionPane.showMessageDialog(this, "删除失败","操作失败",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
