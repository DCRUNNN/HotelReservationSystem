package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.personnelui.BackgroundPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CreateRoomUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateRoomUI frame = new CreateRoomUI();
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
	public CreateRoomUI() {
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
		
		JButton btnNewButton = new JButton("\u7BA1\u7406\u8BA2\u5355");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton.setBounds(54, 555, 170, 60);
		contentPane.add(btnNewButton);
		
		JButton button_3 = new JButton("\u6211\u7684\u8D44\u6599");
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_3.setBounds(54, 644, 170, 60);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("\u623F\u95F4\u53F7");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		label.setBounds(487, 130, 98, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(600, 130, 211, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		label_1.setBounds(473, 204, 133, 34);
		contentPane.add(label_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(600, 204, 211, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u623F\u4EF7");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		lblNewLabel.setBounds(502, 269, 75, 26);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(602, 268, 209, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u623F\u95F4\u72B6\u6001");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		label_2.setBounds(473, 336, 114, 34);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u623F\u95F4\u4ECB\u7ECD");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		label_3.setBounds(473, 455, 122, 34);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		textField_2.setText("\u7A7A\u95F2");
		textField_2.setBounds(602, 335, 209, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(602, 410, 455, 131);
		textArea.setBorder(BorderFactory.createEtchedBorder());
		contentPane.add(textArea);
		
		JButton button2 = new JButton("\u786E\u5B9A");
		button2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button2.setBounds(588, 616, 123, 29);
		contentPane.add(button2);
		
		JButton button3 = new JButton("\u53D6\u6D88");
		button3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button3.setBounds(841, 616, 123, 29);
		contentPane.add(button3);
		
		JLabel label_4 = new JLabel("\u65B0\u589E\u623F\u95F4");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		label_4.setBounds(366, 32, 156, 40);
		contentPane.add(label_4);
	}

}
