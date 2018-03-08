package presentation.personnelui.WebSaler.ViewOrder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebManager.AddNewHotel.AddNewHotel;
import presentation.personnelui.WebManager.ManageClient.ManageClient;
import presentation.personnelui.WebManager.ManageHotelPersonnel.ManageHotelPersonnel;
import presentation.personnelui.WebManager.ManageWebPersonnel.ManageWebPersonnel;
import presentation.personnelui.WebSaler.CreditRecharge.CreditRecharge;
import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.controller.ManageHotelPersonnelUiController;
import presentation.personnelui.controller.ManageWebStrategyUiController;
import runner.WebManagerRunner;
import runner.WebSalerRunner;
import vo.OrderVO;
import vo.PersonnelVO;
import vo.StrategyVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ViewOrderDetails extends JFrame {

	private JPanel contentPane;
	private ManageWebStrategyUiController controller;
	private JTextField textField;
	protected AbstractButton textField_5;
	private JLabel titleLbl;
	private static OrderVO vo;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrderDetails frame = new ViewOrderDetails(vo);
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
	public ViewOrderDetails(OrderVO vo) {
		this.vo=vo;
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
		backgroundPanel.setBounds(0,-11,1280,800);
		contentPane.add(backgroundPanel);
		//设置关闭键/最小化
				JLabel closeLabel = new JLabel("×");
				closeLabel.setForeground(Color.WHITE);
				closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
				closeLabel.setBounds(1153, 18, 26, 30);
				backgroundPanel.add(closeLabel);
				
				JLabel minLabel=new JLabel("-");
				minLabel.setForeground(Color.BLACK);
				minLabel.setFont(new Font("宋体", Font.BOLD, 25));
				minLabel.setBounds(1097, 18, 26, 30);
				backgroundPanel.add(minLabel);
				
				JButton closeBT = new CircleButton("");
				closeBT.setBackground(new Color(135, 206, 235));
				closeBT.setBounds(1146, 13, 40, 40);
				closeBT.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				backgroundPanel.add(closeBT);
				
				JButton minBT=new CircleButton("");
				minBT.setBackground(Color.WHITE);
				minBT.setBounds(1083, 13, 40, 40);
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
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel hotelpersonnellabel = new JLabel("订单详情");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(625, 24, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrder frame=new ViewOrder();
				frame.setVisible(true);
				ViewOrderDetails.this.dispose();
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_checkOrder.jpg"));
		button.setBounds(70, 575, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrderDetails.this.dispose();
				ViewOrder frame=new ViewOrder();
				frame.setVisible(true);
			}
		});
		JButton button_2 = new JButton(new ImageIcon("web_creditRecharge.jpg"));
		button_2.setBounds(70, 384, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrderDetails.this.dispose();
				CreditRecharge frame=new CreditRecharge();
				frame.setVisible(true);
			}
		});
		JButton button_3 = new JButton(new ImageIcon("web_manageWebStrategy.jpg"));
		button_3.setBounds(70, 476, 184, 60);
		backgroundPanel.add(button_3);
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrderDetails.this.dispose();
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
			}
		});
		
		
		
		
		
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("订单编号：");
		label.setBounds(426, 123, 147, 50);
		label.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label);
		
		JLabel label_6 = new JLabel(vo.getOrderID());
		label_6.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_6.setBounds(547, 123, 264, 50);
		backgroundPanel.add(label_6);
		
		
		JLabel label_1 = new JLabel("酒店名称：");
		label_1.setBounds(837, 123, 131, 50);
		label_1.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_1);
		
		JLabel label_11 = new JLabel(vo.getHotelID());
		label_11.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_11.setBounds(954, 123, 295, 50);
		backgroundPanel.add(label_11);
	
		
		JLabel label_2 = new JLabel("酒店id：");
		label_2.setBounds(837, 180, 158, 50);
		label_2.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_2);
		
		
		JLabel label_12 = new JLabel(vo.getHotelID());
		label_12.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_12.setBounds(954, 180, 277, 50);
		backgroundPanel.add(label_12);
		
		JLabel label_3 = new JLabel("客户id：");
		label_3.setBounds(426, 187, 94, 36);
		label_3.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_3);
		
		JLabel label_13 = new JLabel(vo.getClientID());
		label_13.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_13.setBounds(547, 180, 251, 50);
		backgroundPanel.add(label_13);
		
		JLabel label_4 = new JLabel("创建时间：");
		label_4.setBounds(426, 240, 131, 50);
		label_4.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,20));
		backgroundPanel.add(label_4);
		
		JLabel label_9 = new JLabel(vo.getOrderCreatedDate());
		label_9.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_9.setBounds(547, 240, 264, 50);
		backgroundPanel.add(label_9);
		
		JLabel label_5 = new JLabel("持续时间：");
		label_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_5.setBounds(426, 305, 131, 50);
		backgroundPanel.add(label_5);
		
		JLabel label_7 = new JLabel(vo.getOrderLastDate());
		label_7.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_7.setBounds(547, 305, 251, 50);
		backgroundPanel.add(label_7);
		
		
		JLabel label_8 = new JLabel("开始时间：");
		label_8.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_8.setBounds(837, 240, 131, 50);
		backgroundPanel.add(label_8);
		

		JLabel label_10 = new JLabel(vo.getOrderBeginDate());
		label_10.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_10.setBounds(954, 240, 264, 50);
		backgroundPanel.add(label_10);
		
		JLabel label_14 = new JLabel("结束时间：");
		label_14.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_14.setBounds(836, 305, 147, 50);
		backgroundPanel.add(label_14);
		
		JLabel label_23 = new JLabel(vo.getOrderEndDate());
		label_23.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_23.setBounds(954, 305, 277, 50);
		backgroundPanel.add(label_23);
		
		JLabel label_15 = new JLabel("房间价格：");
		label_15.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_15.setBounds(837, 370, 105, 50);
		backgroundPanel.add(label_15);
		
		JLabel label_24 = new JLabel(String.valueOf(vo.getPrice()));
		label_24.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_24.setBounds(954, 370, 147, 50);
		backgroundPanel.add(label_24);
		
		JLabel label_16 = new JLabel("房间数：");
		label_16.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_16.setBounds(426, 426, 105, 50);
		backgroundPanel.add(label_16);
		
		JLabel label_25 = new JLabel(vo.getRoomNumber());
		label_25.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_25.setBounds(547, 426, 264, 50);
		backgroundPanel.add(label_25);
		
		JLabel label_18 = new JLabel("房间类型：");
		label_18.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_18.setBounds(426, 370, 189, 50);
		backgroundPanel.add(label_18);
		
		JLabel label_17 = new JLabel(vo.getRoomType());
		label_17.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_17.setBounds(547, 370, 264, 50);
		backgroundPanel.add(label_17);
		
		JLabel label_19 = new JLabel("房间号：");
		label_19.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_19.setBounds(837, 426, 114, 50);
		backgroundPanel.add(label_19);
		
		JLabel label_28 = new JLabel(vo.getRoomNumber());
		label_28.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_28.setBounds(954, 426, 277, 50);
		backgroundPanel.add(label_28);
		
		JLabel label_20 = new JLabel("入住人数：");
		label_20.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_20.setBounds(426, 486, 147, 50);
		backgroundPanel.add(label_20);
		
		JLabel label_29 = new JLabel(String.valueOf(vo.getPeopleNumber()));
		label_29.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_29.setBounds(547, 481, 251, 50);
		backgroundPanel.add(label_29);
		
		JLabel label_21 = new JLabel("有无儿童：");
		label_21.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_21.setBounds(837, 491, 105, 50);
		backgroundPanel.add(label_21);
		
		JLabel label_30 = new JLabel(vo.getHasChild());
		label_30.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_30.setBounds(958, 491, 232, 50);
		backgroundPanel.add(label_30);
		
		JLabel label_22 = new JLabel("订单状态：");
		label_22.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_22.setBounds(426, 551, 189, 50);
		backgroundPanel.add(label_22);
		
		JLabel label_31 = new JLabel(vo.getOrderStatus());
		label_31.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_31.setBounds(547, 551, 232, 50);
		backgroundPanel.add(label_31);
		
		JLabel label_26 = new JLabel("撤销时间：");
		label_26.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_26.setBounds(837, 551, 105, 50);
		backgroundPanel.add(label_26);
		
		JLabel label_27 = new JLabel(vo.getWithdrawTime());
		label_27.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_27.setBounds(958, 551, 232, 50);
		backgroundPanel.add(label_27);
		
		JLabel label_32 = new JLabel("评价：");
		label_32.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_32.setBounds(426, 605, 105, 50);
		backgroundPanel.add(label_32);
		
		JLabel label_33 = new JLabel(vo.getComment());
		label_33.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_33.setBounds(547, 605, 554, 59);
		backgroundPanel.add(label_33);
		
	
			}
	}
class MouseEventListener1 implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
   ViewOrderDetails frame;
     
    public MouseEventListener1(ViewOrderDetails frame) {
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
