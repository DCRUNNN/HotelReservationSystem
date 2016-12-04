package presentation.personnelui_hotelWorker.hotelpersonnel.CheckIn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import presentation.personnelui.BackgroundPanel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckInUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInUI frame = new CheckInUI();
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
	public CheckInUI() {
		init();
	}

	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setUndecorated(true);
		
		Image backgroundImage=new ImageIcon("background.jpg").getImage();
		contentPane = new BackgroundPanel(backgroundImage);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label_1 = new JLabel("\u623F\u6001\u7B5B\u9009");
		label_1.setFont(new Font("寰蒋闆呴粦", Font.BOLD, 22));
		label_1.setBounds(106, 199, 103, 27);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label.setFont(new Font("寰蒋闆呴粦", Font.BOLD, 18));
		label.setBounds(30, 274, 81, 21);
		contentPane.add(label);
		
		String[] roomType={"鎵�鏈夌被鍨�","鏍囧噯澶у簥鎴�","璞崕澶у簥鎴�","鏍囧噯鍙屽簥鎴�","璞崕鍙屽簥鎴�","鎬荤粺濂楁埧"};
		JComboBox roomTypeBox = new JComboBox(roomType);
		roomTypeBox.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		roomTypeBox.setBounds(126, 271, 133, 27);
		contentPane.add(roomTypeBox);
		
		JLabel label_2 = new JLabel("\u623F\u95F4\u53F7");
		label_2.setFont(new Font("寰蒋闆呴粦", Font.BOLD, 18));
		label_2.setBounds(41, 423, 59, 21);
		contentPane.add(label_2);
		
		JTextField textField = new JTextField();
		textField.setBounds(126, 423, 133, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u623F\u95F4\u72B6\u6001");
		label_3.setFont(new Font("寰蒋闆呴粦", Font.BOLD, 18));
		label_3.setBounds(30, 344, 81, 21);
		contentPane.add(label_3);
		
		String[] roomState={"鎵�鏈夌姸鎬�","绌洪棽","宸茶棰勮","宸插叆浣�"};
		JComboBox roomStateBox = new JComboBox(roomState);
		roomStateBox.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		roomStateBox.setBounds(126, 344, 133, 27);
		contentPane.add(roomStateBox);
		
		JButton button = new JButton("\u67E5\u627E");
		button.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 20));
		button.setBounds(42, 529, 103, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5237\u65B0");
		button_1.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 20));
		button_1.setBounds(160, 529, 103, 33);
		contentPane.add(button_1);
		
		JLabel label_4 = new JLabel("璁㈠崟淇℃伅");
		label_4.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 20));
		label_4.setBounds(342, 142, 81, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("璁㈠崟鍙�");
		label_5.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_5.setBounds(375, 181, 59, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("璁㈠崟鐘舵��");
		label_6.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_6.setBounds(615, 181, 81, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("鎬讳环");
		label_7.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_7.setBounds(842, 181, 51, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("棰勫畾鏃堕棿");
		label_8.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_8.setBounds(1005, 181, 81, 21);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("鏈�鏅氭墽琛屾椂闂�");
		label_9.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_9.setBounds(334, 220, 108, 21);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("鍏ヤ綇鏃堕棿");
		label_10.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_10.setBounds(615, 220, 81, 21);
		contentPane.add(label_10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		textField_6.setText("鏈叆浣�");
		textField_6.setBounds(694, 217, 96, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_11 = new JLabel("绂诲簵鏃堕棿");
		label_11.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_11.setBounds(823, 220, 81, 21);
		contentPane.add(label_11);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		textField_7.setText("鏈叆浣�");
		textField_7.setBounds(908, 217, 81, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(348, 271, 837, 2);
		contentPane.add(separator);
		
		JLabel label_12 = new JLabel("瀹㈡埛淇℃伅");
		label_12.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 20));
		label_12.setBounds(348, 289, 81, 21);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("涓诲濮撳悕");
		label_13.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_13.setBounds(370, 337, 72, 21);
		contentPane.add(label_13);
		
		JLabel lblNewLabel = new JLabel("鑱旂郴鐢佃瘽");
		lblNewLabel.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel.setBounds(578, 337, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("瀹汉鏁伴噺");
		lblNewLabel_1.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(829, 337, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		textField_10.setText("3");
		textField_10.setBounds(914, 334, 64, 27);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_14 = new JLabel("浼氬憳绫诲瀷");
		label_14.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_14.setBounds(370, 387, 72, 21);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("淇＄敤鍊�");
		label_15.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_15.setBounds(588, 387, 59, 21);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("00001");
		label_16.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_16.setBounds(457, 181, 81, 21);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("鏈墽琛�");
		label_17.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_17.setBounds(694, 181, 81, 21);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("2016-12-2");
		label_18.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_18.setBounds(1082, 181, 103, 21);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("2016-12-3 21:00");
		label_19.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_19.setBounds(451, 220, 149, 21);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel("寮犱笁");
		label_20.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_20.setBounds(449, 337, 81, 21);
		contentPane.add(label_20);
		
		JLabel lblNewLabel_2 = new JLabel("13466678976");
		lblNewLabel_2.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(655, 337, 126, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_21 = new JLabel("闈炰細鍛�");
		label_21.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_21.setBounds(449, 387, 81, 21);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("90");
		label_22.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_22.setBounds(662, 387, 81, 21);
		contentPane.add(label_22);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(348, 425, 837, 2);
		contentPane.add(separator_1);
		
		JLabel label_23 = new JLabel("鎴块棿淇℃伅");
		label_23.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 20));
		label_23.setBounds(348, 442, 81, 21);
		contentPane.add(label_23);
		
		JLabel lblNewLabel_3 = new JLabel("鎴块棿鏁伴噺");
		lblNewLabel_3.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(370, 489, 81, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_24 = new JLabel("2");
		label_24.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_24.setBounds(457, 489, 34, 21);
		contentPane.add(label_24);
		
		JLabel lblNewLabel_4 = new JLabel("鎴块棿绫诲瀷");
		lblNewLabel_4.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(578, 489, 81, 21);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(655, 486, 141, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("鎴块棿鍙�");
		lblNewLabel_5.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(859, 489, 59, 21);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(919, 486, 201, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_25 = new JLabel("鏈夋棤鍎跨");
		label_25.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_25.setBounds(370, 537, 81, 21);
		contentPane.add(label_25);
		
		textField_4 = new JTextField();
		textField_4.setBounds(457, 533, 149, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button_3 = new JButton("鎵ц璁㈠崟");
		button_3.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		button_3.setBounds(527, 660, 123, 29);
		contentPane.add(button_3);
		
		JButton button_5 = new JButton("杩斿洖");
		button_5.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		button_5.setBounds(786, 660, 123, 29);
		contentPane.add(button_5);
		
		JButton button2 = new JButton("\u529E\u7406\u5165\u4F4F");
		button2.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		button2.setBounds(414, 52, 123, 29);
		contentPane.add(button2);
		
		JButton button3 = new JButton("\u529E\u7406\u9000\u623F");
		button3.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		button3.setBounds(571, 54, 123, 29);
		contentPane.add(button3);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u623F\u95F4");
		btnNewButton.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		btnNewButton.setBounds(726, 54, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton button4 = new JButton("\u56DE\u5230\u9996\u9875");
		button4.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 22));
		button4.setBounds(881, 54, 123, 29);
		contentPane.add(button4);
		
		JLabel label_26 = new JLabel("楼300");
		label_26.setFont(new Font("寰蒋闆呴粦", Font.PLAIN, 18));
		label_26.setBounds(908, 181, 81, 21);
		contentPane.add(label_26);
		
		final Object[] columnNames={"璁㈠崟鍙�","璁㈠崟鐘舵��","鎬讳环","棰勮鏃堕棿","鏈�鏅氭墽琛屾椂闂�","鍏ヤ綇鏃堕棿","绂诲簵鏃堕棿"};
		Object[][] rowDatas={{"00001","鏈墽琛�","楼300","2016-12-2","2016-12-3 21:00","鏈叆浣�","鏈叆浣�"},{"00001","鏈墽琛�","楼300","2016-12-2","2016-12-3 21:00","鏈叆浣�","鏈叆浣�"}};
		
			
		
	}
}
