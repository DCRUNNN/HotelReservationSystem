package presentation.personnelui_hotelWorker.hotelpersonnel.Init;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import presentation.personnelui.BackgroundPanel;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class InitUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitUI frame = new InitUI();
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
	public InitUI() {
		this.init();
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
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label.setBounds(70, 228, 143, 48);
		contentPane.add(label);
		
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
		
		JButton btnNewButton_1 = new JButton("\u529E\u7406\u5165\u4F4F");
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		btnNewButton_1.setBounds(339, 29, 120, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u529E\u7406\u9000\u623F");
		btnNewButton_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		btnNewButton_2.setBounds(504, 29, 120, 35);
		contentPane.add(btnNewButton_2);
		
		JButton button_4 = new JButton("\u5EF6\u8FDF\u5165\u4F4F");
		button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		button_4.setBounds(666, 29, 120, 35);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\u641C\u7D22\u4F4F\u623F");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		button_5.setBounds(828, 29, 120, 35);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u9000\u51FA");
		button_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		button_6.setBounds(993, 29, 120, 35);
		contentPane.add(button_6);
		
		JLabel label_1 = new JLabel("\u4ED9\u6797\u5927\u9152\u5E97");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		label_1.setBounds(349, 89, 143, 48);
		contentPane.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(323, 152, 790, 2);
		contentPane.add(separator);
		
		JLabel label_2 = new JLabel("\u7B80\u4ECB");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_2.setBounds(368, 169, 48, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5730\u5740");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_3.setBounds(368, 228, 59, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_4.setBounds(346, 291, 81, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u6240\u5728\u5546\u5708");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_5.setBounds(828, 228, 81, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u661F\u7EA7");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_6.setBounds(839, 291, 59, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u9152\u5E97\u56FE\u7247");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_7.setBounds(346, 401, 81, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u9152\u5E97\u8BBE\u65BD");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_8.setBounds(346, 555, 81, 21);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u5468\u8FB9\u8BBE\u65BD");
		label_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_9.setBounds(346, 664, 81, 21);
		contentPane.add(label_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(323, 205, 808, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(323, 264, 797, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(323, 330, 797, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(323, 506, 797, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(323, 643, 781, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(769, 205, 1, 110);
		contentPane.add(separator_6);
		
		
		
		
	}
}
