package presentation.personnelui.WebSaler.ViewOrder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebSaler.CreditRecharge.CreditRecharge;
import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.WebSalerMainUi.WebSalerMainUi;
import runner.WebSalerRunner;
import vo.OrderVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
public class ViewOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultTableModel tablemodel;
	private presentation.personnelui.controller.ViewOrderUiController controller;
	private JLabel titleLbl;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrder frame = new ViewOrder();
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
	public ViewOrder(){
		new WebSalerRunner();
		this.controller=new presentation.personnelui.controller.ViewOrderUiController();
		this.setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background1=new ImageIcon("background3.jpg").getImage();
		Image background2=new ImageIcon("webManager.jpg").getImage();
		JPanel backgroundPanel=new BackgroundPanel(background1);
		backgroundPanel.setBounds(0,0,1280,800);
		contentPane.add(backgroundPanel);
		


		//���ùرռ�/��С��
		JLabel closeLabel = new JLabel("��");
		closeLabel.setForeground(Color.red);
		closeLabel.setFont(new Font("����", Font.BOLD, 25));
		closeLabel.setBounds(1232, 20, 26, 30);
		backgroundPanel.add(closeLabel);
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.WHITE);
		minLabel.setFont(new Font("����", Font.BOLD, 25));
		minLabel.setBounds(1191, 20, 26, 30);
		backgroundPanel.add(minLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1225, 15, 40, 40);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		backgroundPanel.add(closeBT);
		
		JButton minBT=new CircleButton("");
		minBT.setBackground(new Color(135, 206, 235));
		minBT.setBounds(1177, 15, 40, 40);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setExtendedState(ICONIFIED);
			}
		});
		backgroundPanel.add(minBT);
		MouseEventListener mouseListener = new MouseEventListener(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(980, 674, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrder.this.dispose();
				WebSalerMainUi frame=new WebSalerMainUi();
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_checkOrder.jpg"));
		button.setBounds(70, 575, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrder frame=new ViewOrder();
				frame.setVisible(true);
			}
		});
		JButton button_2 = new JButton(new ImageIcon("web_creditRecharge.jpg"));
		button_2.setBounds(70, 384, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CreditRecharge frame=new CreditRecharge();
				frame.setVisible(true);
			}
		});
		JButton button_3 = new JButton(new ImageIcon("web_manageWebStrategy.jpg"));
		button_3.setBounds(70, 476, 184, 60);
		backgroundPanel.add(button_3);
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("��ӭ�㣡");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("�鿴����");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 30));
		label.setBounds(430, 29, 343, 84);
		backgroundPanel.add(label);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("������");
		columnNames.add("�ͻ�id");
		columnNames.add("Ԥ��ʱ��");
		columnNames.add("����״̬");
		columnNames.add("�����");
		columnNames.add("��������");
		Vector<Vector<String>> rowData=null;
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		rowData = controller.getAllAbnormalOrders(); //�õ��쳣����
		
		rowData.addAll(controller.getAllUnexecutedOrders()); //����δִ�ж���
		
		tablemodel=new DefaultTableModel(rowData, columnNames);
		JTable friends=new JTable(tablemodel);
		//JTable friends = new JTable (rowData, columnNames);  
		JTableHeader tableHeader = friends.getTableHeader(); 
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
		friends.setFont(new Font("�����п�",Font.PLAIN,20));
		friends.getTableHeader().setFont(new Font("������ͤ��ϸ�ڼ���",Font.PLAIN,18));
		friends.setBorder(null);
		friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//���ñ��Ĵ�С  
		friends.setRowHeight (50);//����ÿ�еĸ߶�Ϊ20 
		friends.setRowMargin (3);//�����������е�Ԫ��ľ���
		friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse 
		friends.setSelectionBackground (Color.lightGray);//������ѡ���еı���ɫ 
		friends.setSelectionForeground (Color.black);//������ѡ���е�ǰ��ɫ 
		friends.setGridColor (Color.black);//���������ߵ���ɫ 
		friends.setShowGrid (true);//�Ƿ���ʾ������  
		friends.setShowHorizontalLines (true);//�Ƿ���ʾˮƽ��������
		friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ��������  
		friends.doLayout ();  
		friends.setBackground (Color.white); 
		for(int i=0;i<friends.getColumnCount();i++){
			if(i==0){
				friends.getColumnModel().getColumn(i).setPreferredWidth(25);
			}
			else if(i==1){
				friends.getColumnModel().getColumn(i).setPreferredWidth(25);
			}else if(i==2){
				friends.getColumnModel().getColumn(i).setPreferredWidth(80);
			}else if(i==3){
				friends.getColumnModel().getColumn(i).setPreferredWidth(30);
			}else{
				friends.getColumnModel().getColumn(i).setPreferredWidth(50);
			}
		}
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		friends.setDefaultRenderer(Object.class,   r);
		JScrollPane scrollPane = new JScrollPane(friends);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(370, 156, 873, 508);

 		backgroundPanel.add(scrollPane);
 		
		textField = new JTextField();
		textField.setText("����ͻ�id�������쳣����");
		textField.setColumns(10);
		textField.setBounds(806, 108, 344, 29);
		textField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textField.setText("");
			}
		});
		backgroundPanel.add(textField);
		
		JButton button_1 = new JButton(new ImageIcon("web_search.jpg"));
		button_1.setBounds(1146, 108, 79, 29);
		backgroundPanel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text=textField.getText().toString();
				Vector<Vector<String>> volist=controller.getAllAbnormalOrders();
				
				Vector<Vector<String>> result=new Vector<Vector<String>>();
				if("".equals(text)||text==null){
					JOptionPane.showMessageDialog(backgroundPanel, "����δ����Ҫ��ѯ�Ŀͻ���ţ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					boolean isNum=Pattern.matches("^\\d+$",text);
					boolean checkid=false;
					if(isNum==true){
						for(int i=0;i<volist.size();i++){
							if(!text.equals(volist.get(i).get(1))){
								//result.addAll(controller.getClientAbnormalOrders(text));
								checkid=false;
								break;
							}
						}
						if(checkid==true){
							result.addAll(controller.getClientAbnormalOrders(text));
							friends.setModel(new DefaultTableModel(volist,columnNames));
						}else{
							JOptionPane.showMessageDialog(backgroundPanel, "�ͻ�id������ ��ÿͻ�û���쳣������", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(backgroundPanel, "�����ʽ����", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JButton button_4 = new JButton(new ImageIcon("web_detail.jpg"));
		button_4.setBounds(494, 674, 165, 50);
		backgroundPanel.add(button_4);
		button_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int rowindex=friends.getSelectedRow();
				if(rowindex!=-1){
					String orderID=friends.getValueAt(rowindex, 0).toString();
					OrderVO vo=controller.getOrderVO1(orderID);
					ViewOrder.this.dispose();
					ViewOrderDetails frame=new ViewOrderDetails(vo);
					frame.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(backgroundPanel, "����δѡ��Ҫ�鿴�Ķ�����", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton button_5 = new JButton(new ImageIcon("web_withdraw.jpg"));
		button_5.setBounds(728, 674, 165, 50);
		backgroundPanel.add(button_5);
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=friends.getSelectedRow();
					if(index!=-1){
						String state=friends.getValueAt(index, 3).toString();
						if(!state.equals("�쳣")){
							JOptionPane.showMessageDialog(backgroundPanel, "��ֻ���Գ����쳣����","",JOptionPane.ERROR_MESSAGE);
							return;
						}
						String orderID=friends.getValueAt(index,0).toString();
						
						boolean q=controller.withdrawAbnormalOrder(orderID);
						if(q==true){
							JOptionPane.showMessageDialog(backgroundPanel, "�����ɹ���","���", JOptionPane.INFORMATION_MESSAGE);
							ViewOrder.this.dispose();
							ViewOrder frame=new ViewOrder();
							frame.setVisible(true);
							
						}else{
							JOptionPane.showMessageDialog(backgroundPanel, "����ʧ�ܣ�","���", JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else{
						JOptionPane.showMessageDialog(backgroundPanel, "����δѡȡ��Ҫ�����쳣�Ķ�������","���", JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
	}
}
class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //�����ק��Ҫ�ƶ���Ŀ�����
   ViewOrder frame;
     
    public MouseEventListener(ViewOrder viewOrder) {
      this.frame = viewOrder;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * ��¼��갴��ʱ�ĵ�
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * ����ƽ�������ʱ���������ͼ��Ϊ�ƶ�ͼ��
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
     
    /**
    * ����Ƴ�������ʱ���������ͼ��ΪĬ��ָ��
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * ����ڱ�������קʱ�����ô��ڵ�����λ��
    * �����µ�����λ�� = �ƶ�ǰ����λ��+�����ָ�뵱ǰ����-��갴��ʱָ���λ�ã�
    */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point p = this.frame.getLocation();
      this.frame.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }
