package presentation.loginUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import presentation.clientUI_account.MouseEventListener_all;
import presentation.clientUI_mainui.MainUIController;
import presentation.clientUI_mainui.MainUIControllerService;
import presentation.clientUI_mainui.mainUI;
import presentation.controller.InitHotelViewControllerImpl;
import presentation.help.ClientPicture;
import presentation.personnelui.WebManagerMainUi.WebManagerMainUi;
import presentation.personnelui.WebSalerMainUi.WebSalerMainUi;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelView;
import presentation.personnelui_hotelWorker.hotelpersonnel.Init.InitHotelViewControllerService;
import runner.HotelWorkerRunner;



public class LoginView extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private LoginControllerService controller;
	private JLabel head;
	private ImageIcon headIcon;
	private JButton loginButton;
	
	//ͼƬ·��
	private final String hotelPersonnelURl="hotelPersonnel.jpg";
	private final String clientURL="client.jpg";
	private final String webManagerURL="webManager.jpg";
	private final String webPersonnelURL="webPersonnel.jpg";
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public LoginView(LoginControllerService controller){
		new HotelWorkerRunner();
		this.controller=controller;
		init();
	}
	
	public void init(){
		//���ô���
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
	
		
		//�������
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.blue));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background2 = new ImageIcon("background2.jpg").getImage();
		BackgroundPanel introLabel = new BackgroundPanel(background2);
		introLabel.setBounds(0, 0, 600, 217);
		contentPane.add(introLabel);
		introLabel.setLayout(null);
		
		//��������ק��label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 550, 36);
		introLabel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		JButton closeBT = new JButton(new ImageIcon("close.jpg"));
		closeBT.setFont(new Font("�����ͨ", Font.BOLD, 20));
		closeBT.setBounds(570, 0, 30, 30);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�˳�����
				System.exit(0);
			}
		});
		introLabel.add(closeBT);
		
		JButton minBT = new JButton(new ImageIcon("minimize.jpg"));
		minBT.setFont(new Font("�����ͨ", Font.BOLD, 20));
		minBT.setBounds(540, 0, 30, 30);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��С�����ڵ�������
				setExtendedState(ICONIFIED);
			}
		});
		introLabel.add(minBT);
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		userNameField.setBounds(190, 230, 240, 40);
		userNameField.addFocusListener(new GetHeadPicListener());
		userNameField.requestFocus();
		contentPane.add(userNameField);
		userNameField.setColumns(30);
		userNameField.setMargin(new Insets(0, 20, 0, 0));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		passwordField.setBounds(190, 290, 240, 40);
		passwordField.setMargin(new Insets(0, 20, 0, 0));
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//���س������Ե�¼
				controller.loginButtonClicked();
			}
		});
		contentPane.add(passwordField);
		
		head = new JLabel();
		head.setBounds(29, 230, 125, 118);
		head.setVisible(true);
		contentPane.add(head);
		//LabelͼƬ��ʼ����Ϊclient��ͼƬ
		headIcon=new ImageIcon(clientURL);
		//headIconͼƬ����
		headIcon=new ImageIcon(headIcon.getImage().getScaledInstance(head.getWidth(), head.getHeight(), Image.SCALE_DEFAULT));
		head.setIcon(headIcon);//setIconӦ����icon�������֮��

		
		loginButton = new JButton(new ImageIcon("login.jpg"));
		loginButton.setFont(new Font("�����ͨ", Font.PLAIN, 20));
		loginButton.setBounds(190, 347, 240, 40);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.loginButtonClicked();
			}
		});
		contentPane.add(loginButton);
		
		JButton registerBT = new JButton(new ImageIcon("register.jpg"));
		registerBT.setBounds(460, 230, 40, 40);
		registerBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//���ע�ᰴť �л���ע���˺Ž���
				RegisterView view=new RegisterView(controller);
				controller.setRegisterView(view);
				view.setVisible(true);
				dispose();
			}
		});
		contentPane.add(registerBT);
		
		JButton showBT = new JButton(new ImageIcon("show.jpg"));
		showBT.setBounds(460, 290, 40, 40);
		showBT.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//�ɿ�������������ʾ
				passwordField.setEchoChar('��');
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//����������ʾ����
				passwordField.setEchoChar((char)0);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		contentPane.add(showBT);
		
		JLabel label = new JLabel("\u6CE8\u518C");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 24));
		label.setBounds(514, 230, 50, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u660E\u6587");
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("������ͤ��ϸ�ڼ���", Font.BOLD, 24));
		label_1.setBounds(514, 290, 50, 40);
		contentPane.add(label_1);
		
		//�����ڴ�ʱ ��꽹���������û�����
		addWindowListener(new WindowAdapter() {
			   public void windowOpened(WindowEvent e){
			        userNameField.requestFocus();
			    }
		});
	}
	
	public void loginButtonClicked(){
		//�õ�����
		String userId=userNameField.getText();
		char[] pass=passwordField.getPassword();
		String password=new String(pass);
		String hotelId="";
		String type="";
		
		//����û�����Ϊ�� �õ�
		if(!userId.equals("")){
			type=controller.getType(userId);
		}
//		type="��վ������Ա";
		//����ǾƵ깤����Ա  �õ��Ƶ�ID
		if(type.equals("�Ƶ깤����Ա")){
			hotelId=userId.substring(1);
		}
		
		if(userId.equals("")||password.equals("")||type.equals("")){

			JOptionPane.showMessageDialog(this, "�������û���������","��Ϣ���벻����",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		boolean flag=controller.check(userId, password);
		if(flag==false){
			JOptionPane.showMessageDialog(this, "�û������������벻��ȷ,����������","��֤ʧ��",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			switch (type) {
			case "�ͻ�":
				//�л����ͻ�����
				MainUIControllerService controllerService1=new MainUIController(userId);
				mainUI clientView=new mainUI(controllerService1);
				controllerService1.setView(clientView);
				clientView.setVisible(true);
				dispose();
				break;
			case "�Ƶ깤����Ա":
				InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
				InitHotelView view=new InitHotelView(controllerService);
				controllerService.setView(view);
				view.setVisible(true);
				dispose();
				break;
				
			case "��վӪ����Ա":
				//�л�����վӪ����Ա����
				WebSalerMainUi webSalerView=new WebSalerMainUi();
				webSalerView.setVisible(true);
				dispose();
				break;
				
			case "��վ������Ա":
				//�л�����վ������Ա����
				WebManagerMainUi webManagerView=new WebManagerMainUi();
				webManagerView.setVisible(true);
				dispose();
				break;
				
			default:
				break;
			}
		}
		
	}
	
	public void registerButtonClicked(){
		RegisterView view=new RegisterView(controller);
		controller.setRegisterView(view);
		view.setVisible(true);
		dispose();
	}
	
	class GetHeadPicListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			//�õ�����ʱִ�еĴ���
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			//ʧȥ����ʱִ�е� 
			String type=controller.getType(userNameField.getText());
			if(type.equals("�ͻ�")){
				String clientID=userNameField.getText();
				//�жϿͻ��˱����Ƿ���ڸÿͻ���ͷ����Ƭ
				boolean isExist=ClientPicture.isExist(clientID);
				if(isExist==true){
					//�����ش��� ��ӱ���ȡ�ø�ͼƬ
					headIcon=new ImageIcon(ClientPicture.getLocalPicture(clientID));
				}else{
					//����ӷ�������ȡ��ͼƬ
					byte[] picByte=controller.getClientPicture(clientID);
					if(picByte==null){
						//����������Ҳû��(�������û�û������ͷ��) ����ʾĬ��ͷ��
						head.setIcon(new ImageIcon(clientURL));
					}else{
						//��ʾ�û�����ͼƬ
						headIcon=new ImageIcon(ClientPicture.changeByteAndSave(picByte, clientID));	
					}
				}
			}else if(type.equals("�Ƶ깤����Ա")){
				headIcon=new ImageIcon(hotelPersonnelURl);
			}else if(type.equals("��վӪ����Ա")){
				headIcon=new ImageIcon(webManagerURL);
			}else if(type.equals("��վ������Ա")){
				headIcon=new ImageIcon(webPersonnelURL);
			}//end if
			
			//ʵ��ͼƬ����label��С��������
			headIcon=new ImageIcon(headIcon.getImage().getScaledInstance(head.getWidth(), head.getHeight(), Image.SCALE_DEFAULT));
			head.setIcon(headIcon);	 //����ͷ��ͼƬ
			
		}//end method
	}//end inside class

}
