package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;


import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.rmi.RemoteException;

import presentation.personnelui.BackgroundPanel;
import rmi.HotelWorkerRemoteHelper;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import vo.StrategyVO;


public class ManageStrategyUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hotelID="1";
	private JPanel contentPane;
	private JTable strategyTable;
	ManageHotelStrategyService strategyHelper;
	List<StrategyVO> strategyList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStrategyUI frame = new ManageStrategyUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ManageStrategyUI() throws RemoteException {
		strategyHelper=HotelWorkerRemoteHelper.getInstance().getManageHotelStrategyService();
		strategyList=strategyHelper.getAllHotelStrategy(hotelID);
		
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);

		Image backgroundImage=new ImageIcon("background.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image headImage=new ImageIcon("hotelpersonnel.jpg").getImage();
		JPanel panel = new BackgroundPanel(headImage);
		panel.setBounds(54, 29, 170, 170);
		contentPane.add(panel);
		
		JLabel label_Welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label_Welcome.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_Welcome.setBounds(70, 228, 143, 48);
		contentPane.add(label_Welcome);
		
		JButton button = new JButton("\u7BA1\u7406\u9152\u5E97\u4FE1\u606F");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button.setBounds(54, 291, 170, 60);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7BA1\u7406\u4F4F\u623F");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_1.setBounds(54, 381, 170, 60);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u7BA1\u7406\u7B56\u7565");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_2.setBounds(53, 466, 170, 60);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u7BA1\u7406\u8BA2\u5355");
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_3.setBounds(54, 555, 170, 60);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u6211\u7684\u8D44\u6599");
		button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_4.setBounds(54, 644, 170, 60);
		contentPane.add(button_4);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(336, 47, 849, 541);
		tablePanel.setLayout(new BorderLayout());
		
		
		//create strategy table
		String[][] data=new String[strategyList.size()][];
		for(int i=0;i<strategyList.size();i++){
			StrategyVO temp=strategyList.get(i);
			//"²ßÂÔ±àºÅ","²ßÂÔÃû³Æ","ÆðÊ¼Ê±¼ä","½áÊøÊ±¼ä","ÕÛ¿Û","ºÏ×÷ÆóÒµ"
			data[i]=new String[6];
			String[] s=new String[]{temp.getStrategyID(),temp.getName(),temp.getBeginTime()
					,temp.getEndTime(),temp.getStrategy_discount()+"",temp.getCompanyAddress()};
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		String[] titleName={"²ßÂÔ±àºÅ","²ßÂÔÃû³Æ","ÆðÊ¼Ê±¼ä","½áÊøÊ±¼ä","ÕÛ¿Û","ºÏ×÷ÆóÒµ"};
		
		StrategyTable myTable=new StrategyTable(data,titleName);
		
		strategyTable=new JTable(myTable);
		strategyTable.setBorder(BorderFactory.createEtchedBorder());
		
		strategyTable.setFillsViewportHeight(true);  
		
		strategyTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 17));
		strategyTable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		strategyTable.setBackground(Color.CYAN);
		
		JScrollPane scroll=new JScrollPane(strategyTable);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setUI(new MultiScrollPaneUI());
		
		//ÉèÖÃ¾ÓÖÐÏÔÊ¾
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
	    render.setHorizontalAlignment(SwingConstants.CENTER);
	    
		for(int i=0;i<strategyTable.getColumnCount();i++){
			if(i==0){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(0);
			}else if(i==1){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(80);
			}else if(i==5){
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(70);
			}else{
				strategyTable.getColumnModel().getColumn(i).setPreferredWidth(8);
			}
			strategyTable.getColumnModel().getColumn(i).setCellRenderer(render);
		}
		strategyTable.setRowHeight(25);

		
		tablePanel.add(scroll,BorderLayout.CENTER);
		tablePanel.setOpaque(false);
		contentPane.add(tablePanel);
		
		JButton addBT=new JButton("ÐÂÔö²ßÂÔ");
		addBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		addBT.setBounds(399,654,150,40);
		contentPane.add(addBT);
		
		JButton modifyBT=new JButton("ÐÞ¸Ä");
		modifyBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		modifyBT.setBounds(593,654,150,40);
		contentPane.add(modifyBT);
		
		JButton cancelBT=new JButton("\u5220\u9664");
		cancelBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		cancelBT.setBounds(788,654,150,40);
		contentPane.add(cancelBT);
		
		JButton button_5 = new JButton("\u8FD4\u56DE");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_5.setBounds(979, 654, 150, 40);
		contentPane.add(button_5);
	}
}
