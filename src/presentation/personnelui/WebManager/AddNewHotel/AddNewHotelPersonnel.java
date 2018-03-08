package presentation.personnelui.WebManager.AddNewHotel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
import presentation.personnelui.WebManager.ManageClient.ManageClient;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnel;
import presentation.personnelui.WebManagerMainUi.WebManagerMainUi;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageHotelPersonnelUiController;
import presentation.personnelui.controller.ManageWebPersonnelUiController;
import runner.WebManagerRunner;
import vo.PersonnelVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class AddNewHotelPersonnel extends JFrame {

	private JPanel contentPane;
	private ManageHotelPersonnelUiController controller;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private  PersonnelVO vo;
	private String hotelID;
	private JPasswordField passwordField;
	private JLabel titleLbl;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewHotelPersonnel frame = new AddNewHotelPersonnel();
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
	 * @param result 
	 */
	public AddNewHotelPersonnel(String result) {
		new WebManagerRunner();
		this.controller=new ManageHotelPersonnelUiController();
		this.setUndecorated(true);
		this.hotelID=result;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		MouseEventListener1 mouseListener = new MouseEventListener1(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		contentPane.add(backgroundPanel);


		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel hotelpersonnellabel = new JLabel("����µľƵ깤����Ա");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(622, 32, 343, 84);
		hotelpersonnellabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(937, 712, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel frame=new AddNewHotel();
				frame.setVisible(true);
				AddNewHotelPersonnel.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_add.jpg"));
		btnNewButton_1.setBounds(514, 712, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotelPersonnel.this.dispose();
				AddNewHotel frame=new AddNewHotel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotelPersonnel.this.dispose();
				ManageWebPersonnel frame=new ManageWebPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotelPersonnel.this.dispose();
				ManageHotelPersonnel frame=new ManageHotelPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotelPersonnel.this.dispose();
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("��ӭ�㣡");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
	
		
		JLabel label_2 = new JLabel("������Ա������");
		label_2.setBounds(593, 218, 158, 50);
		label_2.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		JLabel label_3 = new JLabel("��ϵ��ʽ��");
		label_3.setBounds(593, 326, 158, 21);
		label_3.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_4 = new JLabel("�Ա�");
		label_4.setBounds(593, 396, 131, 50);
		label_4.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_2.setOpaque(false);
		textField_2.setBorder(new LineBorder(Color.gray));
		textField_2.setColumns(10);
		textField_2.setBounds(779, 230, 200, 27);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_3.setOpaque(false);
		textField_3.setBorder(new LineBorder(Color.gray));
		textField_3.setColumns(10);
		textField_3.setBounds(779, 323, 200, 27);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_4.setOpaque(false);
		textField_4.setBorder(new LineBorder(Color.gray));
		textField_4.setColumns(10);
		textField_4.setBounds(779, 408, 200, 27);
		backgroundPanel.add(textField_4);
		
		JLabel label_5 = new JLabel("������ͣ�");
		label_5.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_5.setBounds(593, 481, 131, 50);
		backgroundPanel.add(label_5);
		
		JLabel label = new JLabel("�Ƶ깤����Ա");
		label.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label.setBounds(779, 481, 200, 50);
		backgroundPanel.add(label);
		
		JLabel label_1 = new JLabel("�Ƶ���");
		label_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_1.setBounds(593, 132, 131, 50);
		backgroundPanel.add(label_1);
		
		JLabel label_6 = new JLabel(hotelID);
		label_6.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_6.setBounds(779, 132, 200, 50);
		backgroundPanel.add(label_6);
		
		JLabel label_7 = new JLabel("���룺");
		label_7.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_7.setBounds(593, 556, 131, 50);
		backgroundPanel.add(label_7);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setBounds(779, 568, 200, 27);
		backgroundPanel.add(passwordField);
		
		
		btnNewButton_1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String personnelId="";
				String hotelId=hotelID;
			    String name=textField_2.getText().toString();
			    String phoneNumber=textField_3.getText().toString();
			    String sex=textField_4.getText().toString();
			    String type=label.getText().toString();
			    char[] pass=passwordField.getPassword();
			    String password=new String(pass);
			    
			    if(("".equals(name)||name==null)||"".equals(phoneNumber)||phoneNumber==null||"".equals(sex)||sex==null){
			    	JOptionPane.showMessageDialog(backgroundPanel, "��������д��Ϣ��", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
			    }else{
			    	PersonnelVO newvo=new PersonnelVO(personnelId,type,name,sex,phoneNumber,hotelId);
				    
				    boolean q=controller.addHotelWorker(newvo);
				    q=controller.savePassword("1"+hotelId, password);
				    if(q){
				    	JOptionPane.showMessageDialog(backgroundPanel, "��ӳɹ�������Ա���Ϊ��"+"1"+hotelID,"�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
				    }else{
				    	JOptionPane.showMessageDialog(backgroundPanel, "�����Ƶ깤����Աʧ��","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
				    }
			    }
			    
			}
		});
	}
}
class MouseEventListener1 implements MouseInputListener {
    
    Point origin;
    //�����ק��Ҫ�ƶ���Ŀ�����
   AddNewHotelPersonnel frame;
     
    public MouseEventListener1(AddNewHotelPersonnel frame) {
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