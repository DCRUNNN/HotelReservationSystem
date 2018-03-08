package presentation.personnelui.WebManager.ManageClient;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnel;
import presentation.personnelui.WebManagerMainUi.WebManagerMainUi;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageClientUiController;
import runner.WebManagerRunner;
import vo.ClientVO;

public class ManageClient extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ManageClientUiController controller;

	private DefaultTableModel tablemodel;
	private JPanel contentPane;
	private JTextField txtid;

	private JLabel titleLbl;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClient frame = new ManageClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
**/
	/**
	 * Create the frame.
	 */
	public ManageClient() {
		new WebManagerRunner();
		this.controller=new ManageClientUiController();
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
		backgroundPanel.setLayout(null);
		MouseEventListener mouseListener = new MouseEventListener(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel clientlabel = new JLabel("�ͻ���Ϣ");
		clientlabel.setForeground(Color.WHITE);
		clientlabel.setBounds(363, 57, 343, 84);
		clientlabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(clientlabel);
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				AddNewHotel frame=new AddNewHotel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				ManageWebPersonnel frame=new ManageWebPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				ManageHotelPersonnel frame=new ManageHotelPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("��ӭ�㣡");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("���");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("���֤��");
		columnNames.add("���õ�");
		columnNames.add("��ϵ�绰");
		columnNames.add("�������");
		Vector<Vector<String>> rowData=controller.getAllClientVO();
		tablemodel=new DefaultTableModel(rowData, columnNames);
		JTable friends=new JTable(tablemodel);
		//JTable friends = new JTable (rowData, columnNames);  
		JTableHeader tableHeader = friends.getTableHeader(); 
		//tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
		
		friends.setFont(new Font("�����п�",Font.PLAIN,20));
		friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//���ñ��Ĵ�С  
		friends.setRowHeight (50);//����ÿ�еĸ߶�Ϊ20 
		friends.setRowMargin (3);//�����������е�Ԫ��ľ���
		
		friends.getTableHeader().setFont(new Font("������ͤ��ϸ�ڼ���",Font.PLAIN,18));
		
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
				friends.getColumnModel().getColumn(i).setPreferredWidth(20);
			}
			else if(i==1){
				friends.getColumnModel().getColumn(i).setPreferredWidth(20);
			}else if(i==2){
				friends.getColumnModel().getColumn(i).setPreferredWidth(15);
			}else if(i==3){
				friends.getColumnModel().getColumn(i).setPreferredWidth(100);
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
		scrollPane.setBounds(367, 156, 873, 508);

 		backgroundPanel.add(scrollPane);
 		
		
 		JButton searchButton_3 = new JButton(new ImageIcon("web_search.jpg"));
		searchButton_3.setBounds(1165, 120, 71, 29);
		backgroundPanel.add(searchButton_3);
		txtid = new JTextField("id/�ͻ�����/�ֻ�");
		txtid.setBounds(970, 120, 197, 29);
		txtid.setForeground(Color.gray);
		txtid.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtid.setText("");
			}
		});
		backgroundPanel.add(txtid);
		txtid.setColumns(10);
		
		searchButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				String text=txtid.getText().toString();
				boolean isNum=Pattern.matches("^\\d+$",text);
				boolean q=false;
				Vector<Vector<String>> clientvolist=controller.getAllClientVO();
				Vector<Vector<String>> volist=new Vector<Vector<String>>();
				if("".equals(text)){
					JOptionPane.showMessageDialog(backgroundPanel, "����δ������Ҫ��������Ϣ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(isNum==true){
						for(int i=0;i<clientvolist.size();i++){
							if(clientvolist.get(i).get(0).equals(text)){
								volist.add(clientvolist.get(i));
								q=true;
							}
							else if(clientvolist.get(i).get(5).equals(text)){
								volist.add(clientvolist.get(i));
								q=true;
							}
						}
						
					}else if(text.matches("[\\u4e00-\\u9fa5]+")){
						for(int i=0;i<clientvolist.size();i++){
							if(clientvolist.get(i).get(1).equals(text)){
								volist.add(clientvolist.get(i));
								q=true;
							}
						}
					}
					if(q==false){
						JOptionPane.showMessageDialog(backgroundPanel, "�Ҳ��������Ϣ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else{
						friends.setModel(new DefaultTableModel(volist,columnNames));	
					}
				
				}
			}
		});
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				WebManagerMainUi frame=new WebManagerMainUi();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_modify.jpg"));
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//boolean q=false;
				ClientVO vo;
				int rowindex  =	friends.getSelectedRow();
				if(rowindex!=-1){
					ManageClient.this.dispose();
					
					String clientid=friends.getValueAt(rowindex,0).toString();
					
					vo=controller.getClientMessgae(clientid);
	
					ModifyClientMessage frame=new ModifyClientMessage(vo);
					frame.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(scrollPane, "��δѡ��Ҫ�޸ĵĿͻ���","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton button_3 = new JButton(new ImageIcon("web_detail.jpg"));
		button_3.setBounds(726, 679, 165, 50);
		backgroundPanel.add(button_3);
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ClientVO vo;
				int rowindex=friends.getSelectedRow();
				if(rowindex!=-1){
					ManageClient.this.dispose();
					String clientid=friends.getValueAt(rowindex, 0).toString();
					vo=controller.getClientMessgae(clientid);
					ViewDetails frame=new ViewDetails(vo);
					frame.setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(scrollPane, "��δѡ��Ҫ�޸ĵĿͻ���","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
	}
}
class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //�����ק��Ҫ�ƶ���Ŀ�����
   ManageClient frame;
     
    public MouseEventListener(ManageClient frame) {
      this.frame = frame;
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