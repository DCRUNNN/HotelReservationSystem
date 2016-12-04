package presentation.personnelui_hotelWorker.hotelpersonnel.ManageHotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.personnelui.BackgroundPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;

public class ModifyHotelInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyHotelInfoUI frame = new ModifyHotelInfoUI();
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
	public ModifyHotelInfoUI() {
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
		
		JLabel label = new JLabel("   \u6B22\u8FCE\u60A8\uFF01");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 24));
		label.setBounds(70, 228, 143, 48);
		contentPane.add(label);
		
		JButton button = new JButton("\u7BA1\u7406\u9152\u5E97\u4FE1\u606F");
		button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		button.setBounds(54, 291, 170, 60);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u7BA1\u7406\u4F4F\u623F");
		button_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		button_1.setBounds(54, 381, 170, 60);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u7BA1\u7406\u7B56\u7565");
		button_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		button_2.setBounds(53, 466, 170, 60);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("\u7BA1\u7406\u8BA2\u5355");
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		btnNewButton.setBounds(54, 555, 170, 60);
		contentPane.add(btnNewButton);
		
		JButton button_3 = new JButton("\u6211\u7684\u8D44\u6599");
		button_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 20));
		button_3.setBounds(54, 644, 170, 60);
		contentPane.add(button_3);
		
		JLabel label_1 = new JLabel("æ∆µÍ√˚≥∆");
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_1.setBounds(443, 56, 103, 30);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(561, 56, 176, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("æ∆µÍºÚΩÈ");
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_2.setBounds(443, 485, 93, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("æ∆µÍµÿ÷∑");
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_3.setBounds(443, 127, 103, 30);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(561, 131, 248, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("À˘‘⁄…Ã»¶");
		label_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_4.setBounds(443, 202, 93, 21);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(561, 201, 176, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("¡™œµµÁª∞");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		lblNewLabel.setBounds(443, 272, 103, 21);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(561, 271, 176, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("æ∆µÍÕº∆¨");
		label_5.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_5.setBounds(443, 347, 93, 21);
		contentPane.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(561, 328, 170, 106);
		panel_1.setBackground(Color.CYAN);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(765, 328, 170, 106);
		panel_2.setBackground(Color.CYAN);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(965, 328, 170, 106);
		panel_3.setBackground(Color.CYAN);
		contentPane.add(panel_3);
		
		JButton button_4 = new JButton("…œ¥´Õº∆¨");
		button_4.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,18));
		button_4.setBounds(423, 390, 123, 29);
		contentPane.add(button_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(561, 473, 581, 38);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("æ∆µÍ…Ë ©");
		label_6.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		label_6.setBounds(443, 555, 93, 21);
		contentPane.add(label_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(561, 543, 581, 114);
		textArea.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(textArea);
		
		JButton button_5 = new JButton("±£¥Ê");
		button_5.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		button_5.setBounds(561, 712, 123, 29);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("»°œ˚");
		button_6.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		button_6.setBounds(743, 712, 123, 29);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("∑µªÿ");
		button_7.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 22));
		button_7.setBounds(918, 714, 123, 29);
		contentPane.add(button_7);
		
	}
}
