package presentation.personnelui_hotelWorker.hotelpersonnel.MyInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.personnelui.BackgroundPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class MyInfoUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInfoUI frame = new MyInfoUI();
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
	public MyInfoUI() {
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);

		Image backgroundImage=new ImageIcon("background.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image headImage=new ImageIcon("hotelpersonnel.jpg").getImage();
		JPanel panel = new BackgroundPanel(headImage);
		panel.setBounds(54, 29, 170, 170);
		contentPane.add(panel);
		
		JLabel label_Welcome = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label_Welcome.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_Welcome.setBounds(70, 228, 143, 48);
		contentPane.add(label_Welcome);
		
		JButton button = new JButton("\u7BA1\u7406\u9152\u5E97\u4FE1\u606F");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button.setBounds(54, 291, 170, 60);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7BA1\u7406\u4F4F\u623F");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_1.setBounds(54, 381, 170, 60);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u7BA1\u7406\u7B56\u7565");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_2.setBounds(53, 466, 170, 60);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u7BA1\u7406\u8BA2\u5355");
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_3.setBounds(54, 555, 170, 60);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u6211\u7684\u8D44\u6599");
		button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_4.setBounds(54, 644, 170, 60);
		contentPane.add(button_4);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setBounds(399, 59, 716, 496);
		mainPanel.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		label.setBounds(98, 40, 66, 33);
		mainPanel.add(label);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblId.setBounds(106, 117, 41, 33);
		mainPanel.add(lblId);
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblNewLabel.setBounds(98, 199, 66, 31);
		mainPanel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("10001");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_1.setBounds(171, 126, 81, 21);
		mainPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7537");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_2.setBounds(171, 199, 81, 28);
		mainPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		label_3.setBounds(59, 283, 96, 33);
		mainPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u9152\u5E97\u5730\u5740");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		label_4.setBounds(59, 366, 96, 27);
		mainPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5730\u7403");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_5.setBounds(171, 372, 81, 21);
		mainPanel.add(label_5);
		
		JLabel label_6 = new JLabel("13166688888");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_6.setBounds(171, 292, 170, 21);
		mainPanel.add(label_6);
		
		JLabel label_7 = new JLabel("\u5F20\u4E09");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_7.setBounds(171, 42, 81, 30);
		mainPanel.add(label_7);
		
		contentPane.add(mainPanel);
		
		JButton button_5 = new JButton("\u4FEE\u6539");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		button_5.setBounds(551, 632, 123, 41);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u8FD4\u56DE");
		button_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		button_6.setBounds(801, 632, 123, 41);
		contentPane.add(button_6);
	}
}
