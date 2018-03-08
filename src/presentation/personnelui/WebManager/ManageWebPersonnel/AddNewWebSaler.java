package presentation.personnelui.WebManager.ManageWebPersonnel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

import presentation.clientUI_book.bookDetailUI;
import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
import presentation.personnelui.WebManager.ManageClient.ManageClient;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnel;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageWebPersonnelUiController;
import runner.WebManagerRunner;
import vo.PersonnelVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class AddNewWebSaler extends JFrame {

	private JPanel contentPane;
	private ManageWebPersonnelUiController controller;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel titleLbl;
	private static PersonnelVO vo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewWebSaler frame = new AddNewWebSaler();
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
	public AddNewWebSaler() {
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
		

		//设置关闭键/最小化
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.red);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1232, 20, 26, 30);
		backgroundPanel.add(closeLabel);
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.WHITE);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
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
		
		
		JLabel hotelpersonnellabel = new JLabel("添加新的网站营销人员");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(635, 51, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebPersonnel frame=new ManageWebPersonnel();
				frame.setVisible(true);
				AddNewWebSaler.this.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_add.jpg"));
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewWebSaler.this.dispose();
				AddNewHotel frame=new AddNewHotel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewWebSaler.this.dispose();
				ManageWebPersonnel frame=new ManageWebPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewWebSaler.this.dispose();
				ManageHotelPersonnel frame=new ManageHotelPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewWebSaler.this.dispose();
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
	
		
		JLabel label_2 = new JLabel("工作人员姓名：");
		label_2.setBounds(581, 186, 158, 50);
		label_2.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		JLabel label_3 = new JLabel("联系方式：");
		label_3.setBounds(581, 294, 158, 21);
		label_3.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_4 = new JLabel("性别：");
		label_4.setBounds(581, 373, 131, 50);
		label_4.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_2.setOpaque(false);
		textField_2.setBorder(new LineBorder(Color.gray));
		textField_2.setColumns(10);
		textField_2.setBounds(767, 198, 200, 27);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_3.setOpaque(false);
		textField_3.setBorder(new LineBorder(Color.gray));
		textField_3.setColumns(10);
		textField_3.setBounds(767, 293, 200, 27);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_4.setOpaque(false);
		textField_4.setBorder(new LineBorder(Color.gray));
		textField_4.setColumns(10);
		textField_4.setBounds(767, 385, 200, 27);
		backgroundPanel.add(textField_4);
		
		JLabel label_5 = new JLabel("身份类型：");
		label_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_5.setBounds(581, 453, 131, 50);
		backgroundPanel.add(label_5);
		
		JLabel label = new JLabel("网站营销人员");
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label.setBounds(767, 453, 131, 50);
		backgroundPanel.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(581, 540, 131, 50);
		backgroundPanel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(767, 552, 200, 30);
		passwordField.setOpaque(false);
		passwordField.setBorder(new LineBorder(Color.gray));
		backgroundPanel.add(passwordField);
		
		
		btnNewButton_1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String personnelId="";
				String hotelId="";
			    String name=textField_2.getText().toString();
			    String phoneNumber=textField_3.getText().toString();
			    String sex=textField_4.getText().toString();
			    String type=label.getText().toString();
			    String password=passwordField.getText().toString();
			    
			    
			    PersonnelVO newvo=new PersonnelVO(personnelId,type,name,sex,phoneNumber,hotelId);
			    String personnelid=null;
			    boolean isNum=Pattern.matches("^\\d+$",phoneNumber);
			    boolean isChinese=name.matches("[\\u4e00-\\u9fa5]+");
			    
			    if("".equals(name)||"".equals(phoneNumber)){
			    	JOptionPane.showMessageDialog(backgroundPanel, "信息填写不完整！", "提示",JOptionPane.INFORMATION_MESSAGE);
			    }else{
			    	if(isNum==false){
			    		JOptionPane.showMessageDialog(backgroundPanel, "手机格式输入有误！", "提示", JOptionPane.INFORMATION_MESSAGE);
			    	}else if(isChinese==false){
			    		JOptionPane.showMessageDialog(backgroundPanel, "姓名格式输入有误！", "提示", JOptionPane.INFORMATION_MESSAGE);
			    	}else{
			    		 personnelid=controller.addNewWebsalers(newvo);
						    boolean q=controller.savePassword(personnelid, password);
						    if(personnelid!=""){
						    	if(q){
						    		JOptionPane.showMessageDialog(backgroundPanel, "修改成功！人员编号："+personnelid+"","修改结果",JOptionPane.INFORMATION_MESSAGE);
							    	AddNewWebSaler.this.dispose();
							    	ManageWebPersonnel frame=new ManageWebPersonnel();
							    	frame.setVisible(true);	
						    	}else{
						    		JOptionPane.showMessageDialog(backgroundPanel, "失败","修改结果",JOptionPane.INFORMATION_MESSAGE);
						    	}
						    	
						    }else{
						    	JOptionPane.showMessageDialog(backgroundPanel, "失败","修改结果",JOptionPane.INFORMATION_MESSAGE);
						    }
			    	}
			    }
			   
			}
		});
	}
}

class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
   AddNewWebSaler frame;
     
    public MouseEventListener(AddNewWebSaler frame) {
      this.frame = frame;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * 鼠标在标题栏拖拽时，设置窗口的坐标位置
    * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
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