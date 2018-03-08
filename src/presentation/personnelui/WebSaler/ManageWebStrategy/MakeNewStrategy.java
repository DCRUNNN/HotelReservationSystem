package presentation.personnelui.WebSaler.ManageWebStrategy;

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
import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageWebStrategyUiController;
import runner.WebSalerRunner;
import vo.StrategyVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class MakeNewStrategy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;
	private ManageWebStrategyUiController controller;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JLabel titleLbl;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeNewStrategy frame = new MakeNewStrategy();
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
	@SuppressWarnings("rawtypes")
	public MakeNewStrategy() {
		new WebSalerRunner();
		this.setUndecorated(true);
		this.controller=new ManageWebStrategyUiController();
		
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
		
		
		JLabel hotelpersonnellabel = new JLabel("制定新的网站营销策略");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(602, 23, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MakeNewStrategy.this.dispose();
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("web_publish.jpg"));
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		JButton button_2 = new JButton(new ImageIcon("web_newStrategy.jpg"));
		button_2.setBounds(77, 474, 184, 60);
		backgroundPanel.add(button_2);
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("策略名称：");
		label.setBounds(415, 111, 131, 50);
		label.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(561, 123, 216, 27);
		textField.setOpaque(false);
		textField.setBorder(new LineBorder(Color.gray));
		backgroundPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("策略适用人群：");
		label_4.setBounds(846, 119, 158, 34);
		label_4.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		JLabel label_1 = new JLabel("策略开始时间：");
		label_1.setBounds(415, 176, 177, 50);
		label_1.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_1);
		
		DateChooserJButton begintimebutton=new DateChooserJButton();
		begintimebutton.setBounds(561, 184, 216, 34);
		begintimebutton.setOpaque(false);
		begintimebutton.setFont(new Font("宋体",Font.HANGING_BASELINE,20));
		backgroundPanel.add(begintimebutton);
		begintimebutton.setVisible(true);
		
		JLabel label_7 = new JLabel("策略结束时间：");
		label_7.setBounds(846, 176, 158, 50);
		label_7.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_7);
		
		DateChooserJButton endtimebutton=new DateChooserJButton();
		endtimebutton.setBounds(991, 184, 216, 34);
		endtimebutton.setOpaque(false);
		endtimebutton.setFont(new Font("宋体",Font.HANGING_BASELINE,20));
		backgroundPanel.add(endtimebutton);
		endtimebutton.setVisible(true);
		
		JLabel label_9 = new JLabel("策略简介：");
		label_9.setBounds(415, 241, 131, 50);
		label_9.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_9);
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setBorder(new LineBorder(Color.gray));
		textArea.setBounds(536, 257, 671, 153);
		backgroundPanel.add(textArea);
		
		JLabel label_2 = new JLabel("酒店地址：");
		label_2.setBounds(415, 402, 131, 50);
		label_2.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		JLabel lblNewLabel = new JLabel("省/直辖市：");
		lblNewLabel.setBounds(415, 470, 130, 21);
		lblNewLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(lblNewLabel);
		
		JLabel label_8 = new JLabel("市/县/区：");
		label_8.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		label_8.setBounds(694, 470, 130, 21);
		backgroundPanel.add(label_8);
		
		JLabel label_3 = new JLabel("所属商圈");
		label_3.setBounds(954, 470, 130, 21);
		label_3.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_5 = new JLabel("是否针对会员生日：");
		label_5.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		label_5.setBounds(415, 533, 204, 50);
		backgroundPanel.add(label_5);
		
		JLabel label_6 = new JLabel("触发策略的房间数目：");
		label_6.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		label_6.setBounds(846, 533, 224, 50);
		backgroundPanel.add(label_6);
		textField_3 = new JTextField("");
		textField_3.setColumns(10);
		textField_3.setOpaque(false);
		textField_3.setBorder(new LineBorder(Color.gray));
		textField_3.setBounds(1062, 545, 109, 27);
		backgroundPanel.add(textField_3);
		
		JLabel label_10 = new JLabel("策略折扣：");
		label_10.setBounds(415, 598, 131, 50);
		label_10.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_10);
		textField_5 = new JTextField("");
		textField_5.setColumns(10);
		textField_5.setOpaque(false);
		textField_5.setBorder(new LineBorder(Color.gray));
		textField_5.setBounds(536, 610, 109, 27);
		backgroundPanel.add(textField_5);
		
		String[] temp={"普通客户","企业会员","普通会员_1","普通会员_2","普通会员_3","普通会员_4","普通会员_5"};
		JComboBox comboBox = new JComboBox(temp);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(993, 123, 150, 27);
		backgroundPanel.add(comboBox);
		
		String[] a={"是","否"};
		JComboBox comboBox_1 = new JComboBox(a);
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_1.setBounds(614, 545, 94, 27);
		backgroundPanel.add(comboBox_1);
		
		
		//省/直辖市的combobox初始化
		List<String> provinces=controller.getAllProvinces();
		provinces.add(0, "不限");
		String province[]=new String[provinces.size()];
		for(int i=0;i<provinces.size();i++){
			province[i]=provinces.get(i);
		}
		
		JComboBox comboBox_2 = new JComboBox(province);
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_2.setBounds(525, 467, 94, 27);
		//comboBox_2.setSelectedItem(null);
		comboBox_2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int index = comboBox_2.getSelectedIndex();
				if(index!=0){
					String province=(String)comboBox_2.getSelectedItem();
					initCityModel(province);
				}
			}
			
		});
		//comboBox_2.setSelectedItem(null);
		backgroundPanel.add(comboBox_2);
		
 
		//市/区combobox初始化
		String city[]={"不限"};
		comboBox_4 = new JComboBox(city);
		comboBox_4.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_4.setBounds(804, 467, 94, 27);
		comboBox_4.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index=comboBox_4.getSelectedIndex();
				if(index!=0){
					String city=(String)comboBox_4.getSelectedItem();
					initCbdModel(comboBox_2.getSelectedItem().toString(),city);
				}
				
			}
			
		});
		//comboBox_4.setSelectedItem(null);
		backgroundPanel.add(comboBox_4);
		
		//cbd初始化
	    String[] cbd={"不限"};
		comboBox_5 = new JComboBox(cbd);
		comboBox_5.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox_5.setBounds(1063, 467, 119, 27);
		//comboBox_5.setSelectedItem(null);
		backgroundPanel.add(comboBox_5);
		
		
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String name=textField.getText().toString();
				String usertype=comboBox.getSelectedItem().toString();
				String begintime=begintimebutton.getText().toString();
				String endtime=endtimebutton.getText().toString();
				String introduction=textArea.getText().toString();
				String temp=comboBox.getSelectedItem().toString();
				String province=comboBox_2.getSelectedItem().toString();
				String city=comboBox_4.getSelectedItem().toString();
				String cbd=comboBox_5.getSelectedItem().toString();
				if(comboBox_2.equals("不限")){
					province="";
				}if(comboBox_4.equals("不限")){
					city="";
			    }if(comboBox_5.equals("不限")){
			    	cbd="";
			    }
				boolean istobirthday=false;
				if(temp=="是"){
					istobirthday=true;
				}
				int roomnumber=0;
				double discount=0;
				
				if(textField_3.getText().toString()==null||"".equals(textField_3.getText().toString())||"".equals(textField_5.getText())||
						"".equals(name)||"".equals(usertype)||"".equals(begintime)||"".equals(endtime)||"".equals(introduction)||"".equals(province)||"".equals(city)||"".equals(cbd)){
					JOptionPane.showMessageDialog(backgroundPanel, "请完整填写信息！","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(Pattern.matches("^\\d+$",textField_3.getText())&&(Pattern.matches("^\\d+$", textField_5.getText()))){
						roomnumber=Integer.parseInt(textField_3.getText().toString());	
						discount=Double.valueOf(textField_5.getText().toString());
						StrategyVO vo=new StrategyVO("",name,introduction,begintime,endtime,usertype,province,city,cbd,istobirthday,"website","",roomnumber,"",discount);
						boolean result=false;
									result=controller.addStrategy(vo);
									JOptionPane.showMessageDialog(backgroundPanel, "发布成功！","发布结果",JOptionPane.INFORMATION_MESSAGE);
									ManageWebStrategy frame=new ManageWebStrategy();
									frame.setVisible(true);
									MakeNewStrategy.this.dispose();
					}else{
						JOptionPane.showMessageDialog(backgroundPanel,"输入格式有误，请重新输入！", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
		
		}});
	}
	
	
	
	protected void initCbdModel(String province,String city) {
		
		List<String> allCbds=controller.getCBDS(province, city);
		allCbds.add(0,"不限");
		String cbd[] =new String[allCbds.size()];
		for(int i=0;i<allCbds.size();i++){
			cbd[i]=allCbds.get(i);
		}
		
		comboBox_5.setModel(new DefaultComboBoxModel(cbd));
		comboBox_5.setSelectedItem(null);
	}

	
	
	private void initCityModel(String province){
		
		List<String> allCities=controller.getCities(province);
		
		allCities.add(0, "不限");
		String city[] = new String[allCities.size()];
		for(int i=0;i<allCities.size();i++){
			city[i]=allCities.get(i);
		}
		
		comboBox_4.setModel(new DefaultComboBoxModel(city));
		//comboBox_4.setSelectedItem(null);
	}
}


class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
   MakeNewStrategy frame;
     
    public MouseEventListener(MakeNewStrategy frame) {
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