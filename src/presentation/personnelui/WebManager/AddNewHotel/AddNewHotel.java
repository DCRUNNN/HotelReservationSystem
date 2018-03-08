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

import presentation.clientUI_account.CircleButton_min;
import presentation.clientUI_account.MouseEventListener_all;
import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.ManageClient.ManageClient;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnel;
import presentation.personnelui.WebManagerMainUi.WebManagerMainUi;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.AddNewHotelUiController;
import runner.WebManagerRunner;
import vo.HotelVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AddNewHotel extends JFrame {

	private JPanel contentPane;
	private AddNewHotelUiController controller;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_2;
	private JTextField textField_7;
	private JLabel titleLbl;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewHotel frame = new AddNewHotel();
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
	public AddNewHotel() {
		new WebManagerRunner();
		this.controller=new AddNewHotelUiController();
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
		
		//最小化与关闭按钮
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.WHITE);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1153, 18, 26, 30);
		contentPane.add(closeLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1146, 13, 40, 40);
		contentPane.add(closeBT);		
		closeBT.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.BLACK);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
		minLabel.setBounds(1097, 18, 26, 30);
		contentPane.add(minLabel);
		
		JButton minBT=new CircleButton_min("");
		minBT.setBackground(Color.WHITE);
		minBT.setBounds(1083, 13, 40, 40);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setExtendedState(ICONIFIED);
			}
		});
		contentPane.add(minBT);
		
		//可自由拖拽的label
		MouseEventListener_all mouseListener = new MouseEventListener_all(this);
		
		JLabel titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1075, 36);
		contentPane.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);

		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel hotelpersonnellabel = new JLabel("添加新的酒店");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(680, 15, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 666, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel.this.dispose();
				WebManagerMainUi frame=new WebManagerMainUi();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_add.jpg"));
		btnNewButton_1.setBounds(512, 666, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("web_addNewHotel.jpg"));
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel.this.dispose();
				AddNewHotel frame=new AddNewHotel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton(new ImageIcon("web_manageWebPersonnel.jpg"));
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel.this.dispose();
				ManageWebPersonnel frame=new ManageWebPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_manageHotelPersonnel.jpg"));
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel.this.dispose();
				ManageHotelPersonnel frame=new ManageHotelPersonnel();	
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_manageClient.jpg"));
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddNewHotel.this.dispose();
				ManageClient frame=new ManageClient();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("酒店名称：");
		label.setBounds(416, 98, 131, 50);
		label.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		textField.setBounds(527, 109, 152, 32);
//		textField.setOpaque(false);
		textField.setBorder(new LineBorder(Color.gray));
		backgroundPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("星级：");
		lblNewLabel.setBounds(751, 112, 81, 21);
		lblNewLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(lblNewLabel);
		
		String[] grade={"1","2","3","4","5"};
		JComboBox comboBox = new JComboBox(grade);
		comboBox.setOpaque(false);
		comboBox.setBounds(824, 106, 109, 34);
		backgroundPanel.add(comboBox);
		
		JLabel label_1 = new JLabel("酒店简介：");
		label_1.setBounds(416, 163, 131, 50);
		label_1.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(527, 179, 649, 141);
//		textArea.setOpaque(false);
		textArea.setBorder(new LineBorder(Color.gray));
		backgroundPanel.add(textArea);
		
		JLabel label_2 = new JLabel("酒店地址：");
		label_2.setBounds(416, 351, 131, 50);
		label_2.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_2);
	
		JLabel label_4 = new JLabel("酒店设施");
		label_4.setBounds(416, 410, 131, 50);
		label_4.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_1.setBounds(526, 426, 650, 141);
//		textArea_1.setOpaque(false);
		textArea_1.setBorder(new LineBorder(Color.gray));
		backgroundPanel.add(textArea_1);
		
		JLabel label_3 = new JLabel("所属商圈：");
		label_3.setBounds(790, 357, 109, 39);
		label_3.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_1.setColumns(10);
//		textField_1.setOpaque(false);
		textField_1.setBorder(new LineBorder(Color.gray));
		textField_1.setBounds(884, 361, 96, 32);
		backgroundPanel.add(textField_1);
		
		textField_4 = new JTextField("省/直辖市：");
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_4.setBounds(527, 361, 109, 32);
//		textField_4.setOpaque(false);
		textField_4.setBorder(new LineBorder(Color.gray));
		textField_4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textField_4.setText("");
			}
		});
		backgroundPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("市/县/区：");
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_5.setColumns(10);
//		textField_5.setOpaque(false);
		textField_5.setBorder(new LineBorder(Color.gray));
		textField_5.setBounds(669, 361, 96, 32);
		textField_5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textField_5.setText("");
			}
		});
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField("详细地址：");
		textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_6.setColumns(30);
//		textField_6.setOpaque(false);
		textField_6.setBorder(new LineBorder(Color.gray));
		textField_6.setBounds(1003, 361, 173, 32);
		textField_6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textField_6.setText("");
			}
		});
		backgroundPanel.add(textField_6);
		
		JLabel label_5 = new JLabel("房间类型和价格：");
		label_5.setBounds(416, 588, 181, 50);
		label_5.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_5);
		
		textField_2 = new JTextField("类型A|价格/类型B|价格");
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_2.setColumns(100);
		textField_2.setOpaque(false);
		textField_2.setBorder(new LineBorder(Color.gray));
		textField_2.setBounds(594, 598, 262, 32);
		textField_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				textField_2.setText("");
			}
		});
		backgroundPanel.add(textField_2);
		
		JLabel label_7 = new JLabel("\u9152\u5E97\u7535\u8BDD\uFF1A");
		label_7.setBounds(885, 588, 109, 50);
		label_7.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		textField_7.setColumns(10);
		textField_7.setOpaque(false);
		textField_7.setBorder(new LineBorder(Color.gray));
		textField_7.setBounds(992, 598, 184, 32);
		backgroundPanel.add(textField_7);
		
		JLabel label_6 = new JLabel("\u7701");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_6.setBounds(639, 366, 23, 21);
		backgroundPanel.add(label_6);
		
		JLabel label_8 = new JLabel("\u5E02");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		label_8.setBounds(764, 366, 29, 21);
		backgroundPanel.add(label_8);

		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String hotelname=textField.getText().toString();
				int hotelgrade=Integer.parseInt(comboBox.getSelectedItem().toString());
				String introduction=textArea.getText().toString();
				String province=textField_4.getText().toString();
				String city=textField_5.getText().toString();
				String cbd=textField_1.getText().toString();
				String address=textField_6.getText().toString();
				String facility=textArea_1.getText().toString();
				String roomtypeandprice=textField_2.getText().toString();
				String telephone=textField_7.getText().toString();
				HotelVO vo=new HotelVO(province,city,cbd,address,hotelname,hotelgrade,introduction,facility,roomtypeandprice,"",telephone);
				
				if((hotelname.equals(""))||hotelname==null||(introduction.equals(""))||(province.equals(""))||(city.equals(""))||(cbd.equals(""))||(address.equals(""))||(facility.equals(""))||(roomtypeandprice.equals(""))||(telephone.equals(""))||(comboBox.getSelectedItem().toString().equals(""))){
				JOptionPane.showMessageDialog(backgroundPanel, "请完整填写信息！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					String result=controller.addHotel(vo);
					if(result!=""){
						int temp=JOptionPane.showConfirmDialog(null, "添加成功！酒店编号为："+result+"  是否为其添加工作人员？", "添加结果", JOptionPane.YES_NO_OPTION);
					 if(temp==0){
						AddNewHotelPersonnel frame=new AddNewHotelPersonnel(result);
						frame.setVisible(true);
						dispose();
					}
					}else{
						JOptionPane.showMessageDialog(backgroundPanel, "添加失败","添加结果",JOptionPane.INFORMATION_MESSAGE);
				}
				}
			}
		});
		
	}
}
class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
    AddNewHotel frame;
     
    public MouseEventListener(AddNewHotel frame) {
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
