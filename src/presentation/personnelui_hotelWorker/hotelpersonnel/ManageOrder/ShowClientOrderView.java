package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import presentation.controller.HotelOrderControllerImpl;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.OrderVO;

public class ShowClientOrderView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private OrderTable myTable;
	
	private JTable orderTable;
	
	private HotelOrderControllerService controller;
	
	private String hotelId;
	
	private String clientId;
	
	private String orderId;
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public ShowClientOrderView(HotelOrderControllerService controller) {
//		new HotelWorkerRunner();
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.clientId=controller.getClientId();
		init();
	}
	
	public void init(){
		//�õ��ͻ������ж���
		List<OrderVO> clientOrderList=controller.getUnexecutedOrders(hotelId,clientId);
		
		int clientOrders=clientOrderList.size();
		if(clientOrders==0){
			JOptionPane.showMessageDialog(null, "�ÿͻ���δ�ж�����","����ʧ��",JOptionPane.WARNING_MESSAGE);	
			return;
		}else{
			//��ʼ����
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(200, 300, 1300, 500);
//			setUndecorated(true);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			contentPane.setOpaque(false);
			setContentPane(contentPane);
			
			//�������
			String[] titleName={"�ͻ�ID","�ͻ�����","�������","Ԥ�������","Ԥ��������","Ԥ����������","��������ִ��ʱ��"};
			
			String[][] data=new String[clientOrders][];
			for(int i=0;i<clientOrders;i++){
				OrderVO temp=clientOrderList.get(i);
				data[i]=new String[titleName.length];
				String[] s=new String[]{temp.getClientID(),temp.getClientName(),temp.getOrderID(),
						temp.getRoomNumber(),temp.getRoomTotal()+"",temp.getRoomType(),temp.getOrderLastDate()};
					
				for(int j=0;j<s.length;j++){
					data[i][j]=s[j];
				}
			}
			
			//���ģ��
			myTable=new OrderTable(data, titleName);
			orderTable=new JTable(myTable);
			orderTable.setBorder(BorderFactory.createEtchedBorder());
			orderTable.setFillsViewportHeight(true);
			orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
			orderTable.setFont(new Font("΢���ź�", Font.PLAIN, 16));
			orderTable.setRowHeight(25);	
			
			JScrollPane scrollPane=new JScrollPane(orderTable);
			scrollPane.setBounds(0, 0, 1300, 350);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		    // ����table��ͷ����
		    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
		    thRenderer.setHorizontalAlignment(JLabel.CENTER);
		    orderTable.getTableHeader().setDefaultRenderer(thRenderer);
		    // ����table���ݾ���
		    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
		    tcRender.setHorizontalAlignment(JLabel.CENTER);
		    orderTable.setDefaultRenderer(Object.class, tcRender);
		    
		    for(int i=0;i<orderTable.getColumnCount();i++){
		    	if(i==0||i==1||i==2){
		    		orderTable.getColumnModel().getColumn(i).setPreferredWidth(0);
		    	}
		    }
		    
			contentPane.add(scrollPane);
			
			JButton confirmBT=new JButton("ִ�ж���");
			confirmBT.setFont(new Font("΢���ź�", Font.PLAIN, 22));
			confirmBT.setBounds(400,380,150,40);
			confirmBT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					controller.executeOrderButtonClicked();
				}
			});
			contentPane.add(confirmBT);
			
			JButton cancelBT=new JButton("ȡ��");
			cancelBT.setFont(new Font("΢���ź�", Font.PLAIN, 22));
			cancelBT.setBounds(700, 380, 150, 40);
			cancelBT.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			contentPane.add(cancelBT);
		}
	}

	public void executeOrderButtonClicked(){
		int index=orderTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(null, "ѡ������","����ʧ��",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		orderId=(String)orderTable.getValueAt(index, 2);
		HotelOrderControllerService controllerService=new HotelOrderControllerImpl(hotelId, clientId, orderId);
		ProcessOrderView view=new ProcessOrderView(controllerService);
		controllerService.setProcessOrderView(view);
		view.setVisible(true);
		dispose();
	}
	
}
