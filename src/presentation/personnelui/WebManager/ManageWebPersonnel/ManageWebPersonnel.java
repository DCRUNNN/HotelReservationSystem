package presentation.personnelui.WebManager.ManageWebPersonnel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
//import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
import presentation.personnelui.WebManager.ManageClient.ManageClient;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManagerMainUi.WebManagerMainUi;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageWebPersonnelUiController;
//import presentation.personnelui_hotelWorker.AddNewHotel.AddNewHotel;
import runner.WebManagerRunner;
import vo.PersonnelVO;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class ManageWebPersonnel extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private ManageWebPersonnelControllerService controller;
	private DefaultTableModel tablemodel;
	private JLabel titleLbl;
	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWebPersonnel frame = new ManageWebPersonnel();
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
	public ManageWebPersonnel() {
		
		new WebManagerRunner();
		this.controller=new ManageWebPersonnelUiController();
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

		contentPane.add(backgroundPanel);
		MouseEventListener1 mouseListener = new MouseEventListener1(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel webpersonnellabel = new JLabel("��վӪ����Ա��Ϣ");
		webpersonnellabel.setForeground(Color.WHITE);
		webpersonnellabel.setBounds(373, 65, 343, 84);
		webpersonnellabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(webpersonnellabel);
		
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("���");
		columnNames.add("����");
		columnNames.add("��ϵ�绰");
		columnNames.add("�Ա�");
		columnNames.add("�������");
		Vector<Vector<String>> rowData=null;
		rowData = controller.getAllWebSalers();
		tablemodel=new DefaultTableModel(rowData, columnNames);
		JTable friends=new JTable(tablemodel);
		//JTable friends = new JTable (rowData, columnNames);  
		JTableHeader tableHeader = friends.getTableHeader(); 
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
		friends.setFont(new Font("�����п�",Font.PLAIN,20));
		friends.getTableHeader().setFont(new Font("������ͤ��ϸ�ڼ���",Font.PLAIN,18));
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
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		friends.setDefaultRenderer(Object.class,   r);
		JScrollPane scrollPane = new JScrollPane(friends);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(366, 164, 873, 508);

 		backgroundPanel.add(scrollPane);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebPersonnel.this.dispose();
				WebManagerMainUi frame=new WebManagerMainUi();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_modify.jpg"));
		btnNewButton_1.setBounds(513, 679, 165, 50);
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonnelVO vo;
				int rowindex  =	friends.getSelectedRow();
				if(rowindex!=-1){
					ManageWebPersonnel.this.dispose();
					String personnelid=friends.getValueAt(rowindex,0).toString();
					String name=friends.getValueAt(rowindex, 1).toString();
					String phonenumber=friends.getValueAt(rowindex, 2).toString();
					String sex=friends.getValueAt(rowindex, 3).toString();
					String type=friends.getValueAt(rowindex, 4).toString();

					vo=new PersonnelVO(personnelid,type,name,sex,phonenumber,"");
					ModifyWebSalerMessage frame=new ModifyWebSalerMessage(vo);
					frame.setVisible(true);
				}
				else if(rowindex==-1){
					JOptionPane.showMessageDialog(scrollPane, "��δѡ��Ҫ�޸ĵ���Ա��","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel frame=new AddNewHotel();
				frame.setVisible(true);
				ManageWebPersonnel.this.dispose();
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ManageWebPersonnel frame=new ManageWebPersonnel();
				frame.setVisible(true);
				ManageWebPersonnel.this.dispose();
				
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageHotelPersonnel frame=new ManageHotelPersonnel();
				frame.setVisible(true);
				ManageWebPersonnel.this.dispose();
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
				ManageWebPersonnel.this.dispose();
			}
		});
		
		JLabel welcomeLabel = new JLabel("��ӭ�㣡");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		txtid = new JTextField("id/����/����");
		txtid.setBounds(969, 128, 197, 29);
		backgroundPanel.add(txtid);
		txtid.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtid.setText("");
			}
		});
		txtid.setColumns(10);
		
		JButton searchButton_3 = new JButton(new ImageIcon("web_search.jpg"));
		searchButton_3.setBounds(1164, 128, 71, 29);
		backgroundPanel.add(searchButton_3);
		searchButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text=txtid.getText().toString();
				boolean isNum=Pattern.matches("^\\d+$",text);
				boolean q=false;
				Vector<Vector<String>>personnelvolist=controller.getAllWebSalers();
				Vector<Vector<String>> volist=new Vector<Vector<String>>();
				
				if("".equals(text)){
					JOptionPane.showMessageDialog(backgroundPanel, "����δ������Ҫ��������Ϣ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(isNum==true){
						for(int i=0;i<personnelvolist.size();i++){
							if(personnelvolist.get(i).get(0).equals(text)){
								volist.add(personnelvolist.get(i));
								q=true;
							}
							else if(personnelvolist.get(i).get(1).equals(text)){
								volist.add(personnelvolist.get(i));
								q=true;
							}
						}
						
					}else if(text.matches("[\\u4e00-\\u9fa5]+")){
						for(int i=0;i<personnelvolist.size();i++){
							if(personnelvolist.get(i).get(2).equals(text)){
								volist.add(personnelvolist.get(i));
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
		
		JButton button_3 = new JButton(new ImageIcon("web_addNewWebPersonnel.jpg"));
		button_3.setBounds(726, 679, 165, 50);
		backgroundPanel.add(button_3);
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebPersonnel.this.dispose();
				AddNewWebSaler frame=new AddNewWebSaler();
				frame.setVisible(true);
			}
		});
		
	}
}
class MouseEventListener1 implements MouseInputListener {
    
    Point origin;
    //�����ק��Ҫ�ƶ���Ŀ�����
   ManageWebPersonnel frame;
     
    public MouseEventListener1(ManageWebPersonnel frame) {
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