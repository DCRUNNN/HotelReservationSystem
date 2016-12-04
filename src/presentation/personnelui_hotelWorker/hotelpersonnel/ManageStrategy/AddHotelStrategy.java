package presentation.personnelui_hotelWorker.hotelpersonnel.ManageStrategy;

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
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddHotelStrategy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHotelStrategy frame = new AddHotelStrategy();
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
	public AddHotelStrategy() {
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
		
		JLabel label = new JLabel("\u7B56\u7565\u7F16\u53F7");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label.setBounds(433, 41, 96, 23);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(541, 41, 195, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7B56\u7565\u540D\u79F0");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_1.setBounds(433, 108, 96, 27);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(541, 110, 195, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6298\u6263");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_2.setBounds(454, 179, 61, 23);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(541, 179, 195, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\uFF08\u8BF7\u4EE5\u5C0F\u6570\u5F62\u5F0F\u8F93\u5165\uFF09");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_3.setBounds(750, 182, 201, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u9002\u7528\u7C7B\u578B");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_4.setBounds(433, 245, 96, 30);
		contentPane.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(541, 249, 195, 27);
		contentPane.add(comboBox);
		
		JLabel label_5 = new JLabel("\u5408\u4F5C\u4F01\u4E1A");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_5.setBounds(431, 312, 96, 23);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(539, 312, 195, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8D77\u59CB\u65E5\u671F");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_6.setBounds(431, 382, 96, 27);
		contentPane.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(539, 384, 195, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_7 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_7.setBounds(431, 454, 96, 23);
		contentPane.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(539, 454, 195, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_8 = new JLabel("\uFF08\u82E5\u6682\u65E0\u7ED3\u675F\u65E5\u671F\u8BF7\u586B\u65E0\uFF09");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_8.setBounds(797, 457, 224, 21);
		contentPane.add(label_8);
		
		ImageIcon calendarImage=new ImageIcon("calendar.jpg");
		JButton beginBT = new JButton("begind");
		beginBT.setIcon(calendarImage);
		beginBT.setBounds(733, 383, 28, 27);
		contentPane.add(beginBT);
		
		JButton endBT = new JButton("endd");
		endBT.setIcon(calendarImage);
		endBT.setBounds(733, 453, 28, 27);
		contentPane.add(endBT);
		
		JLabel label_9 = new JLabel("\uFF08\u82E5\u6CA1\u6709\u8BF7\u586B\u65E0\uFF09");
		label_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_9.setBounds(748, 315, 162, 21);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u623F\u95F4\u6570\u76EE");
		label_10.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_10.setBounds(431, 526, 96, 23);
		contentPane.add(label_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(539, 526, 195, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_11 = new JLabel("\uFF08\u9700\u8981\u8BA2\u6EE1\u6570\u95F4\u623F\u624D\u6267\u884C\u7B56\u7565\uFF0C\u82E5\u4E0D\u662F\u8BF7\u586B0\uFF09");
		label_11.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_11.setBounds(765, 529, 371, 21);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("\u662F\u5426\u751F\u65E5\u7B56\u7565");
		label_12.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		label_12.setBounds(387, 598, 132, 21);
		contentPane.add(label_12);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(539, 597, 195, 27);
		contentPane.add(comboBox_1);
		
		JButton button_5 = new JButton("\u4FDD\u5B58");
		
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		button_5.setBounds(540, 690, 149, 41);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u53D6\u6D88");
		button_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		button_6.setBounds(821, 690, 149, 41);
		contentPane.add(button_6);
	}
}
