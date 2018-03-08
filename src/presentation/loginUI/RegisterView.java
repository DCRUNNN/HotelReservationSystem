package presentation.loginUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import presentation.help.ClientPicture;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.JPGFileFliter;
import presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel.PNGFileFliter;
import vo.ClientVO;

public class RegisterView extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField confirmPasswordField;
	private JPasswordField passwordField;
	private JTextField phoneField;
	private JTextField IDField;
	private JLabel existLabel;
	private JComboBox<String> sexBox;
	private JLabel headLabel;
	private String picPath;
	private File picFile;
	private byte[] picByte;
	private ImageIcon icon;
	private LoginControllerService controller;

	
	private boolean isExist;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public RegisterView(LoginControllerService controller){
		setLocation(10, 25);
		this.controller=controller;
		init();
	}
	
	public void init(){
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(684,427);
		setLocationRelativeTo(null);
		
		
//		Image background2 = new ImageIcon("background2.jpg").getImage();
		
		contentPane = new BackgroundPanel(new ImageIcon("background3.jpg").getImage());
		contentPane.setBorder(new LineBorder(Color.blue));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("����", Font.PLAIN, 20));
		username.setBounds(327, 25, 240, 40);
		contentPane.add(username);
		username.setColumns(10);
		username.setMargin(new Insets(0, 20, 0, 0));
		
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		confirmPasswordField.setBounds(327, 296, 240, 40);
		confirmPasswordField.setMargin(new Insets(0, 20, 0, 0));
		contentPane.add(confirmPasswordField);

		icon=new ImageIcon("client.jpg");
		if(!username.getText().equals("")){
			boolean isExist=ClientPicture.isExist(username.getText());
			if(isExist==true){
				icon=new ImageIcon(ClientPicture.getLocalPicture(username.getText()));
			}else{
				byte[] picByte=controller.getClientPicture(username.getText());
				if(picByte==null){
					
				}else{
					icon=new ImageIcon(ClientPicture.changeByteAndSave(picByte, username.getText()));	
				}
			}	
		}
		
		headLabel = new JLabel();
		headLabel.setBounds(13, 118, 158, 150);
		headLabel.setVisible(true);
		//ʵ��ͼƬ������
		icon=new ImageIcon(icon.getImage().getScaledInstance(headLabel.getWidth(), headLabel.getHeight(), Image.SCALE_DEFAULT));
		headLabel.setIcon(icon);
		contentPane.add(headLabel);
		
		passwordField = new JPasswordField();
		passwordField.setMargin(new Insets(0, 20, 0, 0));
		passwordField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		passwordField.setBounds(327, 243, 240, 40);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label.setBounds(262, 36, 46, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u624B\u673A\u53F7");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label_1.setBounds(247, 90, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label_2.setBounds(262, 255, 51, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label_3.setBounds(228, 304, 72, 18);
		contentPane.add(label_3);
		
		phoneField = new JTextField();
		phoneField.setMargin(new Insets(0, 20, 0, 0));
		phoneField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		phoneField.setColumns(10);
//		phoneField.getDocument().addDocumentListener(new CheckPhoneExistListener());
		phoneField.addFocusListener(new CheckPhoneExistListener());
		phoneField.setBounds(327, 78, 240, 40);
		contentPane.add(phoneField);
		
		existLabel=new JLabel();
		existLabel.setFont(new Font("΢���ź�", Font.BOLD, 12));
		existLabel.setBounds(572,90,100,20);
		existLabel.setForeground(Color.red);
		contentPane.add(existLabel);
		
		JLabel label_4 = new JLabel("\u6027\u522B");
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label_4.setBounds(262, 143, 51, 18);
		contentPane.add(label_4);
		
		String[] sex={"��","Ů"};
		sexBox = new JComboBox<String>(sex);
		sexBox.setBounds(327, 137, 240, 30);
		sexBox.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		contentPane.add(sexBox);
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		label_5.setBounds(228, 196, 72, 18);
		contentPane.add(label_5);
		
		IDField = new JTextField();
		IDField.setBounds(327, 190, 240, 40);
		IDField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JButton registerBT = new JButton("\u6CE8\u518C");
		registerBT.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		registerBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.confirmRegisterButtonClicked();
			}
		});
		registerBT.setBounds(242, 357, 131, 40);
		contentPane.add(registerBT);
		
		JButton cancelBT = new JButton("\u53D6\u6D88");
		cancelBT.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		cancelBT.setBounds(459, 357, 131, 40);
		cancelBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				LoginView view=new LoginView(controller);
				controller.setLoginView(view);
				view.setVisible(true);
			}
		});
		contentPane.add(cancelBT);
		
		JButton setHeadBT = new JButton("\u4E0A\u4F20\u5934\u50CF");
		setHeadBT.setFont(new Font("΢���ź�", Font.PLAIN, 19));
		setHeadBT.setBounds(30, 275, 123, 29);
		setHeadBT.addActionListener(new AddPictureListener());
		contentPane.add(setHeadBT);
	}
	
	public void confirmRegisterButtonClicked(){
		String name=username.getText();
		String phoneNumber=phoneField.getText();
		String identityID=IDField.getText();
		String pass1=new String(passwordField.getPassword());
		String pass2=new String(confirmPasswordField.getPassword());
		String sex=(String)sexBox.getSelectedItem();
		if(isExist==true){
			JOptionPane.showMessageDialog(this, "���ֻ����ѱ�ע�ᣬ��ѡ�������ֻ��ţ�","ע��ʧ��",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(name.equals("")||phoneNumber.equals("")||identityID.equals("")
				||pass1.equals("")||pass2.equals("")){
			JOptionPane.showMessageDialog(this, "��Ϣ��д��������","",JOptionPane.ERROR_MESSAGE);
			return;
		}			
		if(!pass1.equals(pass2)){
			JOptionPane.showMessageDialog(this, "����������д��һ��,��������������","",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ClientVO clientVO=new ClientVO("", name, sex, identityID, phoneNumber, 0.0, "��ͨ�ͻ�", "", 0, "", "");
		String ClientId=controller.insert(clientVO);
		if(ClientId.equals("")){
			JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ���������","",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		boolean flag=false;
		if(picByte!=null){
		flag=controller.uploadPicture(picByte, ClientId);
		}
		flag=controller.savePassword(ClientId, pass2);
		if(flag==true){
			JOptionPane.showMessageDialog(this, "ע��ɹ�������ID�����"+ClientId+",���μ�����ID��","ע��ɹ���",JOptionPane.INFORMATION_MESSAGE);
			LoginView view=new LoginView(controller);
			controller.setLoginView(view);
			view.setVisible(true);
			dispose();
			return;
		}else{
			JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ���������","ע��ʧ��",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}
	
	public boolean isNumeric(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	class CheckPhoneExistListener implements FocusListener{
		//ʵ�ֶ�����ĵ绰�����ʵʱ��⣬���ú����Ƿ��ѱ�ע��
		
		@Override
		public void focusGained(FocusEvent e) {
			
			//��ȡ����ʱִ��
			existLabel.setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			//ʧȥ����ʱִ��
			if(!isNumeric(phoneField.getText())){
				existLabel.setText("�ֻ��Ų�ȫΪ����!");
				return ;
			}
			
			if(phoneField.getText().length()!=11){
				existLabel.setText("�ֻ��Ų�Ϊʮһλ!");
				return;
			}
			isExist=controller.isExistPhoneNumber(phoneField.getText());
			if(isExist==true){
				existLabel.setText("���ֻ����ѱ�ע��!");
			}else{
				existLabel.setText("");
			}
		}
	
	}
	
	class AddPictureListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser jfc=new JFileChooser();  
		    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);  
		    jfc.setFileFilter(new JPGFileFliter());
		    jfc.addChoosableFileFilter(new PNGFileFliter());
		    jfc.showDialog(new JLabel(), "ѡ��");  
		    picFile=jfc.getSelectedFile();  
		   	picPath=picFile.getAbsolutePath();
		   	icon=new ImageIcon(picPath);
		   	//ʵ��ͼƬ������
			icon=new ImageIcon(icon.getImage().getScaledInstance(headLabel.getWidth(), headLabel.getHeight(), Image.SCALE_DEFAULT));
		   	headLabel.setIcon(icon);
		   	
		   	picByte=ClientPicture.changeFileToByte(picFile);
		}
		
	}

	
}
