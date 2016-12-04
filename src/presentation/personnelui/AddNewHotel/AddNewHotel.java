package presentation.personnelui.AddNewHotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.personnelui.BackgroundPanel;

import java.awt.GridLayout;
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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class AddNewHotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
		
		
		JLabel hotelpersonnellabel = new JLabel("添加新的酒店");
		hotelpersonnellabel.setForeground(Color.WHITE);
		hotelpersonnellabel.setBounds(680, 15, 343, 84);
		hotelpersonnellabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(hotelpersonnellabel);
		
		JButton btnNewButton_2=new JButton("返回");
		btnNewButton_2.setBounds(936, 679, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(513, 679, 165, 50);
		backgroundPanel.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton("添加新的酒店");
		btnNewButton.setBounds(70, 631, 184, 60);
		backgroundPanel.add(btnNewButton);
		
		JButton button_1 = new JButton("管理网站营销人员");
		button_1.setBounds(70, 556, 184, 60);
		backgroundPanel.add(button_1);
		
		JButton button = new JButton("管理酒店工作人员");
		button.setBounds(70, 481, 184, 60);
		backgroundPanel.add(button);
		
		JButton button_2 = new JButton("管理客户信息");
		button_2.setBounds(70, 406, 184, 60);
		backgroundPanel.add(button_2);
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("\u9152\u5E97\u540D\u79F0\uFF1A");
		label.setBounds(415, 87, 131, 50);
		backgroundPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(494, 99, 117, 27);
		//textField.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u661F\u7EA7\uFF1A");
		lblNewLabel.setBounds(750, 101, 81, 21);
		backgroundPanel.add(lblNewLabel);
		
		String[] grade={"1","2","3","4","5"};
		JComboBox comboBox = new JComboBox(grade);
		comboBox.setBounds(800, 98, 81, 27);
		backgroundPanel.add(comboBox);
		
		JLabel label_1 = new JLabel("\u9152\u5E97\u7B80\u4ECB\uFF1A");
		label_1.setBounds(415, 152, 131, 50);
		backgroundPanel.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(494, 168, 641, 141);
		//textArea.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textArea);
		
		JLabel label_2 = new JLabel("\u9152\u5E97\u5730\u5740\uFF1A");
		label_2.setBounds(415, 340, 131, 50);
		backgroundPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u6240\u5C5E\u5546\u5708\uFF1A");
		label_3.setBounds(714, 355, 95, 21);
		backgroundPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u9152\u5E97\u8BBE\u65BD\uFF1A");
		label_4.setBounds(415, 399, 131, 50);
		backgroundPanel.add(label_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(494, 415, 641, 141);
		//textArea_1.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textArea_1);
		
		String[] province={"江苏省","浙江省","广东省"};
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(794, 352, 117, 27);
		//textField_1.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textField_1);
		
		textField_4 = new JTextField("省/直辖市：");
		textField_4.setBounds(494, 352, 73, 27);
		//textField_4.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("市/县/区：");
		textField_5.setColumns(10);
		textField_5.setBounds(602, 352, 81, 27);
		//textField_5.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textField_5);
		
		textField_6 = new JTextField("详细地址：");
		textField_6.setColumns(10);
		textField_6.setBounds(963, 352, 158, 27);
		//textField_6.setBackground(Color.LIGHT_GRAY);
		backgroundPanel.add(textField_6);
		
		JLabel label_5 = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A");
		label_5.setBounds(415, 571, 131, 50);
		backgroundPanel.add(label_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5927\u5E8A\u623F");
		rdbtnNewRadioButton.setBounds(496, 582, 95, 29);
		backgroundPanel.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("\u6807\u51C6\u95F4");
		radioButton.setBounds(596, 582, 87, 29);
		backgroundPanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5355\u4EBA\u95F4");
		radioButton_1.setBounds(700, 582, 87, 29);
		backgroundPanel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\u4E3B\u9898\u623F");
		radioButton_2.setBounds(794, 582, 87, 29);
		backgroundPanel.add(radioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u8C6A\u534E\u623F");
		rdbtnNewRadioButton_1.setBounds(895, 582, 177, 29);
		backgroundPanel.add(rdbtnNewRadioButton_1);
		
		JLabel label_6 = new JLabel("\u623F\u95F4\u4EF7\u683C\uFF1A");
		label_6.setBounds(415, 619, 131, 50);
		backgroundPanel.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(494, 631, 81, 27);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(602, 631, 81, 27);
		backgroundPanel.add(textField_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(804, 631, 81, 27);
		backgroundPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(700, 631, 81, 27);
		backgroundPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(905, 631, 81, 27);
		backgroundPanel.add(textField_9);


		
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