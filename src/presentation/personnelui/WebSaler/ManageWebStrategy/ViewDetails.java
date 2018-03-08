package presentation.personnelui.WebSaler.ManageWebStrategy;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebSaler.CreditRecharge.CreditRecharge;
import presentation.personnelui.WebSaler.ViewOrder.ViewOrder;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageWebStrategyUiController;
import runner.WebSalerRunner;
import vo.StrategyVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewDetails extends JFrame {

	private JPanel contentPane;
	private ManageWebStrategyUiController controller;
	protected AbstractButton textField_5;
	private JLabel titleLbl;
	

	/**
	 * Launch the application.
	 */
	
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetails frame = new ViewDetails(vo);
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
	public ViewDetails(StrategyVO vo) {
		new WebSalerRunner();
		this.controller=new ManageWebStrategyUiController();
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

		MouseEventListener3 mouseListener = new MouseEventListener3(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel hotelpersonnellabel = new JLabel("查看策略详情");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(663, 24, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(677, 680, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
				ViewDetails.this.dispose();
			}
		});
		
		
		
		JButton button = new JButton(new ImageIcon("web_checkOrder.jpg"));
		button.setBounds(70, 575, 184, 60);
		backgroundPanel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewDetails.this.dispose();
				ViewOrder frame=new ViewOrder();
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton(new ImageIcon("web_creditRecharge.jpg"));
		button_2.setBounds(70, 384, 184, 60);
		backgroundPanel.add(button_2);
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewDetails.this.dispose();
				CreditRecharge frame=new CreditRecharge();
				frame.setVisible(true);
			}
		});
		
		JButton button_3 = new JButton(new ImageIcon("web_manageWebStrategy.jpg"));
		button_3.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button_3);
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewDetails.this.dispose();
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("策略编号：");
		label.setBounds(426, 123, 147, 50);
		label.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label);
		
		JLabel label_6 = new JLabel(vo.getStrategyID());
		label_6.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_6.setBounds(547, 123, 264, 50);
		backgroundPanel.add(label_6);
		
		
		JLabel label_1 = new JLabel("策略名称：");
		label_1.setBounds(837, 123, 131, 50);
		label_1.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_1);
		
		JLabel label_11 = new JLabel(vo.getName());
		label_11.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_11.setBounds(954, 123, 295, 50);
		backgroundPanel.add(label_11);
	
		
		JLabel label_2 = new JLabel("酒店id：");
		label_2.setBounds(836, 188, 158, 50);
		label_2.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		
		JLabel label_12 = new JLabel(vo.getHotelID());
		label_12.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_12.setBounds(954, 188, 277, 50);
		backgroundPanel.add(label_12);
		
		JLabel label_3 = new JLabel("策略简介：");
		label_3.setBounds(426, 361, 158, 21);
		label_3.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_13 = new JLabel(vo.getIntroduction());
		label_13.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_13.setBounds(536, 324, 591, 94);
		backgroundPanel.add(label_13);
		
		JLabel label_4 = new JLabel("开始时间：");
		label_4.setBounds(426, 188, 131, 50);
		label_4.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		JLabel label_9 = new JLabel(vo.getBeginTime());
		label_9.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_9.setBounds(547, 188, 264, 50);
		backgroundPanel.add(label_9);
		
		JLabel label_5 = new JLabel("适用人群：");
		label_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_5.setBounds(837, 253, 131, 50);
		backgroundPanel.add(label_5);
		
		JLabel label_7 = new JLabel(vo.getUserType());
		label_7.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_7.setBounds(964, 253, 251, 50);
		backgroundPanel.add(label_7);
		
		
		JLabel label_8 = new JLabel("结束时间：");
		label_8.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_8.setBounds(426, 253, 131, 50);
		backgroundPanel.add(label_8);
		

		JLabel label_10 = new JLabel(vo.getEndTime());
		label_10.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_10.setBounds(547, 253, 264, 50);
		backgroundPanel.add(label_10);
		
		JLabel label_14 = new JLabel("省/直辖市：");
		label_14.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_14.setBounds(426, 462, 147, 50);
		backgroundPanel.add(label_14);
		
		JLabel label_23 = new JLabel(vo.getHotelProvince());
		label_23.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_23.setBounds(531, 462, 147, 50);
		backgroundPanel.add(label_23);
		
		JLabel label_15 = new JLabel("市/县/区：");
		label_15.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_15.setBounds(706, 462, 105, 50);
		backgroundPanel.add(label_15);
		
		JLabel label_24 = new JLabel(vo.getHotelCity());
		label_24.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_24.setBounds(807, 462, 147, 50);
		backgroundPanel.add(label_24);
		
		JLabel label_16 = new JLabel("所属商圈：");
		label_16.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_16.setBounds(980, 462, 105, 50);
		backgroundPanel.add(label_16);
		
		JLabel label_25 = new JLabel(vo.getHotelCBD());
		label_25.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_25.setBounds(1084, 462, 165, 50);
		backgroundPanel.add(label_25);
		
		JLabel label_18 = new JLabel("是否针对会员生日：");
		label_18.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_18.setBounds(426, 542, 189, 50);
		backgroundPanel.add(label_18);
		
		String istobirthday="";
	    boolean q=vo.isToBirthday();
	    if(q==true){
	    	istobirthday="是";
	    }else{
	    	istobirthday="否";
	    }
		
		JLabel label_17 = new JLabel(istobirthday);
		label_17.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_17.setBounds(607, 542, 88, 50);
		backgroundPanel.add(label_17);
		
		JLabel label_19 = new JLabel("策略类型：");
		label_19.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_19.setBounds(706, 542, 114, 50);
		backgroundPanel.add(label_19);
		
		JLabel label_28 = new JLabel(vo.getUserType());
		label_28.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_28.setBounds(807, 542, 131, 50);
		backgroundPanel.add(label_28);
		
		JLabel label_20 = new JLabel("触发房间数：");
		label_20.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_20.setBounds(980, 542, 147, 50);
		backgroundPanel.add(label_20);
		
		JLabel label_29 = new JLabel(String.valueOf(vo.getRoomTotal()));
		label_29.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_29.setBounds(1129, 542, 120, 50);
		backgroundPanel.add(label_29);
		
		JLabel label_21 = new JLabel("公司地址：");
		label_21.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_21.setBounds(426, 607, 105, 50);
		backgroundPanel.add(label_21);
		
		JLabel label_30 = new JLabel(vo.getCompanyAddress());
		label_30.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_30.setBounds(547, 607, 232, 50);
		backgroundPanel.add(label_30);
		
		JLabel label_22 = new JLabel("折扣：");
		label_22.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_22.setBounds(837, 607, 189, 50);
		backgroundPanel.add(label_22);
		
		JLabel label_31 = new JLabel(String.valueOf(vo.getStrategy_discount()));
		label_31.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_31.setBounds(912, 607, 120, 50);
		backgroundPanel.add(label_31);
		
	
			}
		
	}

class MouseEventListener3 implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
   ViewDetails frame;
     
    public MouseEventListener3(ViewDetails frame) {
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
