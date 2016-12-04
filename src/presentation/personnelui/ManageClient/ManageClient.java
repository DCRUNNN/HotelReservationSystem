package presentation.personnelui.ManageClient;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import presentation.personnelui.BackgroundPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ManageClient extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ManageClientControllerService controller;

	public ManageClient(ManageClientControllerService controller){
		this.controller=controller;
	}

	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClient frame = new ManageClient();
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
	public ManageClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background1=new ImageIcon("background1.jpg").getImage();
		Image background2=new ImageIcon("background2.jpg").getImage();
		JPanel backgroundPanel=new BackgroundPanel(background1);
		backgroundPanel.setBounds(0,0,1280,800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		
		JLabel clientlabel = new JLabel("客户信息");
		clientlabel.setForeground(Color.WHITE);
		clientlabel.setBounds(357, 57, 343, 84);
		clientlabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(clientlabel);
		
		JButton btnNewButton_2=new JButton("返回");
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u65B0\u7684\u9152\u5E97");
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		JButton button_1 = new JButton("\u7BA1\u7406\u7F51\u7AD9\u8425\u9500\u4EBA\u5458");
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		JButton button = new JButton("\u7BA1\u7406\u9152\u5E97\u5DE5\u4F5C\u4EBA\u5458");
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		JButton button_2 = new JButton("\u7BA1\u7406\u5BA2\u6237\u4FE1\u606F");
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		txtid = new JTextField("id/\u540D\u79F0/\u53F7\u7801");
		txtid.setBounds(953, 120, 197, 29);
		backgroundPanel.add(txtid);
		txtid.setColumns(10);
		
		JButton searchButton_3 = new JButton("搜索");
		searchButton_3.setBounds(1148, 120, 71, 29);
		backgroundPanel.add(searchButton_3);
		
		
		
		final Object[] columnNames = {"编号", "姓名", "性别","联系电话","身份类型","生日","会员等级","公司名称","信用点","身份证号"};   
		Object[][] rowData = {{"151250021", "陈远志", "男", "1378313210","普通会员","19970212","vip_5","","100","321084199702125515"},
				};  
		JTable friends = new JTable (rowData, columnNames);  
		friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//设置表格的大小  
		friends.setRowHeight (30);//设置每行的高度为20 
		friends.setRowHeight (0, 20);//设置第1行的高度为15 
		friends.setRowMargin (3);//设置相邻两行单元格的距离
		friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false 
		friends.setSelectionBackground (Color.white);//设置所选择行的背景色 
		friends.setSelectionForeground (Color.red);//设置所选择行的前景色 
		friends.setGridColor (Color.black);//设置网格线的颜色 
		friends.setShowGrid (false);//是否显示网格线  
		friends.setShowHorizontalLines (false);//是否显示水平的网格线
		friends.setShowVerticalLines (true);//是否显示垂直的网格线  
		friends.doLayout ();  
		friends.setBackground (Color.lightGray); 
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		friends.setDefaultRenderer(Object.class,   r);
		
		JScrollPane scrollPane = new JScrollPane(friends);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(350, 156, 888, 502);
		
	
 		backgroundPanel.add(scrollPane);
		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
