package presentation.personnelui_hotelWorker.hotelpersonnel.ManageOrder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.controller.HotelOrderControllerImpl;
import runner.HotelWorkerRunner;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vo.OrderVO;
import vo.RoomVO;

public class ShowClientAbnormalOrderView extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private DetailedOrderTable myTable;
	
	private JTable orderTable;
	
	private HotelOrderControllerService controller;
	
	private String hotelId;
	
	private String clientId;
	
	private String orderId;
		
	private String[] roomNumbers;
	
	private String[] roomTypes;
	
	private int roomTotal;
	
	public ShowClientAbnormalOrderView(HotelOrderControllerService controller){
		this.controller=controller;
		this.hotelId=controller.getHotelId();
		this.orderId=controller.getOrderId();
		this.clientId=controller.getClientId();
		init();
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(580, 300, 800, 340);
//		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		setContentPane(contentPane);
				
		String temp=controller.getDelayRoomNumber(orderId,hotelId);
		if(temp.contains("�޿��з���")){
			JOptionPane.showMessageDialog(this, "�޿��з��䣡�����ӳ���סʧ��","�޷������ӳ���ס",JOptionPane.ERROR_MESSAGE);
			return;
		}
		roomNumbers=controller.getDelayRoomNumber(orderId, hotelId).split("/");
		roomTotal=roomNumbers.length;

		//�������
		String[] titleName={"�����","��������","���䵥��","���޶�ͯ","��������"};
		
		String price="";
		String type="";
		for(int i=0;i<roomTotal;i++){
			RoomVO vo=controller.getRoomByNum(hotelId, roomNumbers[i]);
			type+=vo.getRoomType()+"/";
			price+=String.valueOf(vo.getPrice())+"/";
		}
		
		String[] roomPrices=price.split("/");//���淿��۸�
		roomTypes=type.split("/");//�������
		
		//����
		String[][] data=new String[roomTotal][];
		for(int i=0;i<roomTotal;i++){
			data[i]=new String[titleName.length];
			String[] s=new String[]{roomNumbers[i],roomTypes[i],roomPrices[i],"",""};
			
			for(int j=0;j<s.length;j++){
				data[i][j]=s[j];
			}
		}
		
		//ģ��
		myTable=new DetailedOrderTable(data, titleName);
		orderTable=new JTable(myTable);
		orderTable.setBorder(BorderFactory.createEtchedBorder());
		orderTable.setFillsViewportHeight(true);
		
		JComboBox<String> childBox=new JComboBox<String>();
		childBox.addItem("��");
		childBox.addItem("��");
		
		orderTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(childBox));
		orderTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		orderTable.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		orderTable.setRowHeight(25);	
		
		JScrollPane scrollPane=new JScrollPane(orderTable);
		scrollPane.setBounds(0, 0,800, 200);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	    // ����table��ͷ����
	    DefaultTableCellHeaderRenderer thRenderer = new DefaultTableCellHeaderRenderer();
	    thRenderer.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.getTableHeader().setDefaultRenderer(thRenderer);
	    // ����table���ݾ���
	    DefaultTableCellRenderer tcRender = new DefaultTableCellRenderer();
	    tcRender.setHorizontalAlignment(JLabel.CENTER);
	    orderTable.setDefaultRenderer(Object.class, tcRender);
	    
	    contentPane.add(scrollPane);
	    
	    JButton confirmDelayButton=new JButton("ȷ�ϰ����ӳ���ס");
	    confirmDelayButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
	    confirmDelayButton.setBounds(140,215,190,50);
	    confirmDelayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controller.confirmDelayButtonClicked();
			}
		});
	    contentPane.add(confirmDelayButton);
	    
	    JButton cancelBT=new JButton("ȡ��");
	    cancelBT.setFont(new Font("΢���ź�",Font.PLAIN,18));
	    cancelBT.setBounds(465,215,150,50);
	    contentPane.add(cancelBT);
	    
	    setVisible(true);
		
	}
	
	public void executeOrderButtonClicked(){
		int index=orderTable.getSelectedRow();
		if(index==-1){
			JOptionPane.showMessageDialog(null, "��ѡ�񶩵���","����ʧ��",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		boolean flag=false;
		
		for(int i=0;i<roomTotal;i++){
			flag=!(orderTable.getValueAt(i, 3).equals("")||orderTable.getValueAt(i, 4).equals(""));
			//��û���������޶�ͯ�ͷ������� ��flagΪfalse
		}	
		
		if(flag==false){
			JOptionPane.showMessageDialog(null, "������ÿ�䷿���޶�ͯ��ÿ�䷿������","��Ϣ��д������",JOptionPane.WARNING_MESSAGE);
		}else{
			boolean check=false;
			for(int i=0;i<roomTotal;i++){
				//���÷��������Լ����޶�ͯ
				controller.setRoomChild(roomNumbers[i], transform((String)orderTable.getValueAt(i,3)));
				controller.setRoomPeople(roomNumbers[i], Integer.parseInt((String)orderTable.getValueAt(i, 4)));
			}
			check=controller.executeOrder();
			if(check==true){
				JOptionPane.showMessageDialog(null, "�ɹ�ִ�ж�����","�����ɹ�",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				ManageOrderView view=new ManageOrderView(controller);
				controller.setManageOrderView(view);
				view.setVisible(true);
				//���¶����б�
				
			}else{
				JOptionPane.showMessageDialog(null, "ִ�ж���ʧ��","����ʧ��",JOptionPane.WARNING_MESSAGE);
				ManageOrderView view=new ManageOrderView(controller);
				controller.setManageOrderView(view);
				view.setVisible(true);
			}
		}	
	}
	
	public boolean transform(String str){
		if(str.equals("��")){
			return false;
		}
		return true;
	}

}
