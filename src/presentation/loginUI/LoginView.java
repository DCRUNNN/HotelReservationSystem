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
	
	//图片路径
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
		//设置窗口
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
	
		
		//设置组件
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
		
		//可自由拖拽的label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 550, 36);
		introLabel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		
		JButton closeBT = new JButton(new ImageIcon("close.jpg"));
		closeBT.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		closeBT.setBounds(570, 0, 30, 30);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//退出程序
				System.exit(0);
			}
		});
		introLabel.add(closeBT);
		
		JButton minBT = new JButton(new ImageIcon("minimize.jpg"));
		minBT.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		minBT.setBounds(540, 0, 30, 30);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//最小化窗口到任务栏
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
				//按回车键可以登录
				controller.loginButtonClicked();
			}
		});
		contentPane.add(passwordField);
		
		head = new JLabel();
		head.setBounds(29, 230, 125, 118);
		head.setVisible(true);
		contentPane.add(head);
		//Label图片初始设置为client的图片
		headIcon=new ImageIcon(clientURL);
		//headIcon图片缩放
		headIcon=new ImageIcon(headIcon.getImage().getScaledInstance(head.getWidth(), head.getHeight(), Image.SCALE_DEFAULT));
		head.setIcon(headIcon);//setIcon应该在icon完成缩放之后

		
		loginButton = new JButton(new ImageIcon("login.jpg"));
		loginButton.setFont(new Font("迷你简卡通", Font.PLAIN, 20));
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
				//点击注册按钮 切换到注册账号界面
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
				//松开鼠标密码加密显示
				passwordField.setEchoChar('●');
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//长按明文显示密码
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
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 24));
		label.setBounds(514, 230, 50, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u660E\u6587");
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 24));
		label_1.setBounds(514, 290, 50, 40);
		contentPane.add(label_1);
		
		//当窗口打开时 光标焦点设置在用户名处
		addWindowListener(new WindowAdapter() {
			   public void windowOpened(WindowEvent e){
			        userNameField.requestFocus();
			    }
		});
	}
	
	public void loginButtonClicked(){
		//得到输入
		String userId=userNameField.getText();
		char[] pass=passwordField.getPassword();
		String password=new String(pass);
		String hotelId="";
		String type="";
		
		//如果用户名不为空 得到
		if(!userId.equals("")){
			type=controller.getType(userId);
		}
//		type="网站管理人员";
		//如果是酒店工作人员  得到酒店ID
		if(type.equals("酒店工作人员")){
			hotelId=userId.substring(1);
		}
		
		if(userId.equals("")||password.equals("")||type.equals("")){

			JOptionPane.showMessageDialog(this, "请输入用户名和密码","信息输入不完整",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		boolean flag=controller.check(userId, password);
		if(flag==false){
			JOptionPane.showMessageDialog(this, "用户名或密码输入不正确,请重新输入","验证失败",JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			switch (type) {
			case "客户":
				//切换到客户界面
				MainUIControllerService controllerService1=new MainUIController(userId);
				mainUI clientView=new mainUI(controllerService1);
				controllerService1.setView(clientView);
				clientView.setVisible(true);
				dispose();
				break;
			case "酒店工作人员":
				InitHotelViewControllerService controllerService=new InitHotelViewControllerImpl(hotelId);
				InitHotelView view=new InitHotelView(controllerService);
				controllerService.setView(view);
				view.setVisible(true);
				dispose();
				break;
				
			case "网站营销人员":
				//切换到网站营销人员界面
				WebSalerMainUi webSalerView=new WebSalerMainUi();
				webSalerView.setVisible(true);
				dispose();
				break;
				
			case "网站管理人员":
				//切换到网站管理人员界面
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
			//得到焦点时执行的代码
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			//失去焦点时执行的 
			String type=controller.getType(userNameField.getText());
			if(type.equals("客户")){
				String clientID=userNameField.getText();
				//判断客户端本地是否存在该客户的头像照片
				boolean isExist=ClientPicture.isExist(clientID);
				if(isExist==true){
					//若本地存在 则从本地取得该图片
					headIcon=new ImageIcon(ClientPicture.getLocalPicture(clientID));
				}else{
					//否则从服务器端取得图片
					byte[] picByte=controller.getClientPicture(clientID);
					if(picByte==null){
						//若服务器端也没有(可能是用户没有设置头像) 则显示默认头像
						head.setIcon(new ImageIcon(clientURL));
					}else{
						//显示用户个人图片
						headIcon=new ImageIcon(ClientPicture.changeByteAndSave(picByte, clientID));	
					}
				}
			}else if(type.equals("酒店工作人员")){
				headIcon=new ImageIcon(hotelPersonnelURl);
			}else if(type.equals("网站营销人员")){
				headIcon=new ImageIcon(webManagerURL);
			}else if(type.equals("网站管理人员")){
				headIcon=new ImageIcon(webPersonnelURL);
			}//end if
			
			//实现图片根据label大小进行缩放
			headIcon=new ImageIcon(headIcon.getImage().getScaledInstance(head.getWidth(), head.getHeight(), Image.SCALE_DEFAULT));
			head.setIcon(headIcon);	 //设置头像图片
			
		}//end method
	}//end inside class

}
