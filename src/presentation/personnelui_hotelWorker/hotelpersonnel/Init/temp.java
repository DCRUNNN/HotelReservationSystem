package presentation.personnelui_hotelWorker.hotelpersonnel.Init;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class temp extends JFrame {

	private JPanel contentPane;
	private JTextField typeField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temp frame = new temp();
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
	public temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 21));
		label.setBounds(49, 54, 89, 34);
		contentPane.add(label);
		
		typeField = new JTextField();
		typeField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		typeField.setBounds(151, 56, 273, 35);
		contentPane.add(typeField);
		typeField.setColumns(20);
		
		JLabel label_1 = new JLabel("\u623F\u95F4\u4EF7\u683C");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 21));
		label_1.setBounds(49, 147, 89, 28);
		contentPane.add(label_1);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 19));
		priceField.setBounds(151, 147, 273, 35);
		contentPane.add(priceField);
		priceField.setColumns(20);
		
		JButton saveBT = new JButton("\u4FDD\u5B58");
		saveBT.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 21));
		saveBT.setBounds(107, 247, 123, 29);
		contentPane.add(saveBT);
		
		JButton cancelBT = new JButton("\u53D6\u6D88");
		cancelBT.setFont(new Font("ËÎÌå", Font.PLAIN, 21));
		cancelBT.setBounds(319, 248, 123, 29);
		contentPane.add(cancelBT);
	}
}
