package presentation.personnelui.WebManager.ManageHotelPersonnel;

import java.awt.Color;
import java.awt.Cursor;
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
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageHotelPersonnelUiController;
import runner.WebManagerRunner;
import vo.PersonnelVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModifyMessage extends JFrame {

	private JPanel contentPane;
	private ManageHotelPersonnelUiController controller;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected AbstractButton textField_5;
	private JLabel titleLbl;
	private static PersonnelVO vo;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyMessage frame = new ModifyMessage(vo);
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
	public ModifyMessage(PersonnelVO vo) {
		this.vo=vo;
		new WebManagerRunner();
		this.controller=new ManageHotelPersonnelUiController();
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
		backgroundPanel.setBounds(0,-11,1280,800);
		

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
		
		
		JLabel hotelpersonnellabel = new JLabel("�޸ľƵ깤����Ա��Ϣ");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(625, 24, 343, 84);
		hotelpersonnellabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageHotelPersonnel frame=new ManageHotelPersonnel();
				frame.setVisible(true);
				ModifyMessage.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_save.jpg"));
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModifyMessage.this.dispose();
				AddNewHotel frame=new AddNewHotel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModifyMessage.this.dispose();
				ManageWebPersonnel frame=new ManageWebPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModifyMessage.this.dispose();
				ManageHotelPersonnel frame=new ManageHotelPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModifyMessage.this.dispose();
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("��ӭ�㣡");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("������Ա��ţ�");
		label.setBounds(520, 123, 147, 50);
		label.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label);
		
		
		
		
		JLabel label_1 = new JLabel("�Ƶ�id��");
		label_1.setBounds(520, 213, 131, 50);
		label_1.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_1);
	
		
		JLabel label_2 = new JLabel("������Ա������");
		label_2.setBounds(520, 311, 158, 50);
		label_2.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		JLabel label_3 = new JLabel("��ϵ��ʽ��");
		label_3.setBounds(520, 419, 158, 21);
		label_3.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_4 = new JLabel("�Ա�");
		label_4.setBounds(520, 498, 131, 50);
		label_4.setFont(new Font("������ͤ��ϸ�ڼ���",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		textField_2 = new JTextField(vo.getname());
		textField_2.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_2.setOpaque(false);
		textField_2.setBorder(new LineBorder(Color.gray));
		textField_2.setColumns(10);
		textField_2.setBounds(826, 329, 200, 27);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField(vo.getphoneNumber());
		textField_3.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(826, 418, 200, 27);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField(vo.getsex());
		textField_4.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		textField_4.setOpaque(false);
		textField_4.setBorder(new LineBorder(Color.gray));
		textField_4.setColumns(10);
		textField_4.setBounds(826, 510, 200, 27);
		backgroundPanel.add(textField_4);
		
		JLabel label_5 = new JLabel("������ͣ�");
		label_5.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_5.setBounds(520, 578, 131, 50);
		backgroundPanel.add(label_5);
		
		JLabel label_6 = new JLabel(vo.getpersonnelID());
		label_6.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_6.setBounds(826, 123, 147, 50);
		backgroundPanel.add(label_6);
		
		JLabel label_7 = new JLabel(vo.getType());
		label_7.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_7.setBounds(826, 576, 147, 50);
		backgroundPanel.add(label_7);
		
		JLabel label_8 = new JLabel(vo.gethotelID());
		label_8.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 20));
		label_8.setBounds(826, 213, 147, 50);
		backgroundPanel.add(label_8);
		
		
		btnNewButton_1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String personnelId=label_6.getText().toString();
			    String hotelId=label_8.getText().toString();
			    String name=textField_2.getText().toString();
			    String phoneNumber=textField_3.getText().toString();
			    String sex=textField_4.getText().toString();
			    String type=label_7.getText().toString();
			    
			    PersonnelVO newvo=new PersonnelVO(personnelId,type,name,sex,phoneNumber,hotelId);
			    
			    boolean q=controller.modifyPersonnel(newvo);
			    boolean isNum=Pattern.matches("^\\d+$",phoneNumber);
			    boolean isChinese=name.matches("[\\u4e00-\\u9fa5]+");
			    
			    if("".equals(name)||"".equals(phoneNumber)){
			    	JOptionPane.showMessageDialog(backgroundPanel, "��Ϣ��д��������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			    }else{
			    	  if(isNum==false){
					    	JOptionPane.showMessageDialog(backgroundPanel, "�ֻ��������ʽ��������������","��ʾ", JOptionPane.INFORMATION_MESSAGE);
					    }else if(isChinese==false){
					    	JOptionPane.showMessageDialog(backgroundPanel, "���������ʽ��������������","��ʾ", JOptionPane.INFORMATION_MESSAGE);
					    }else if(q==true){
					    	JOptionPane.showMessageDialog(backgroundPanel, "�޸ĳɹ���","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
					    	ModifyMessage.this.dispose();
					    	ManageHotelPersonnel frame=new ManageHotelPersonnel();
					    	frame.setVisible(true);
					    }else{
					    	JOptionPane.showMessageDialog(backgroundPanel, "ʧ��","�޸Ľ��",JOptionPane.INFORMATION_MESSAGE);
					    }
			    }
			}
		});
	}
}

class MouseEventListener1 implements MouseInputListener {
    
    Point origin;
    //�����ק��Ҫ�ƶ���Ŀ�����
   ModifyMessage frame;
     
    public MouseEventListener1(ModifyMessage frame) {
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