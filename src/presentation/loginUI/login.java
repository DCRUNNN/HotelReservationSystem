package presentation.loginUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.SystemColor;

public class login extends JFrame
{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public login()
	{
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.blue));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background = new ImageIcon("background.jpg").getImage();
		Image background2 = new ImageIcon("background2.jpg").getImage();
		BackgroundPanel label_introduction = new BackgroundPanel(background2);
		label_introduction.setBounds(0, 0, 600, 217);
		contentPane.add(label_introduction);
		label_introduction.setLayout(null);
		
		JButton btnNewButton = new JButton(new ImageIcon("close.jpg"));
		btnNewButton.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		btnNewButton.setBounds(570, 0, 30, 30);
		label_introduction.add(btnNewButton);
		
		JButton button = new JButton(new ImageIcon("minimize.jpg"));
		button.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		button.setBounds(540, 0, 30, 30);
		label_introduction.add(button);
		
		username = new JTextField();
		username.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		username.setBounds(190, 230, 240, 40);
		contentPane.add(username);
		username.setColumns(10);
		username.setMargin(new Insets(0, 20, 0, 0));
		
		
		password = new JPasswordField();
		password.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		password.setBounds(190, 290, 240, 40);
		password.setMargin(new Insets(0, 20, 0, 0));
		contentPane.add(password);
		
		JButton loginButton = new JButton(new ImageIcon("login.jpg"));
		loginButton.setFont(new Font("迷你简卡通", Font.PLAIN, 20));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(190, 347, 240, 40);
		contentPane.add(loginButton);
		
		JLabel head = new JLabel(new ImageIcon("client.jpg"));
		head.setBounds(29, 230, 125, 118);
		head.setVisible(true);
		contentPane.add(head);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("幼圆", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\t客户", "酒店工作人员", "网站营销人员", "网站管理人员"}));
		comboBox.setBounds(29, 350, 125, 24);
		contentPane.add(comboBox);
		
		JButton register = new JButton(new ImageIcon("register.jpg"));
		register.setBounds(460, 230, 40, 40);
		contentPane.add(register);
		
		JButton show = new JButton(new ImageIcon("show.jpg"));
		show.setBounds(460, 290, 40, 40);
		contentPane.add(show);
		
		Image reg = new ImageIcon("registerLabel.jpg").getImage();
		Image sho = new ImageIcon("showLabel.jpg").getImage();
		
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
		
		
	}
}
