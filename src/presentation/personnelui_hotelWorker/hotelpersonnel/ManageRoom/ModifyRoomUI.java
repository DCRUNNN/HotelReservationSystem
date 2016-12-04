package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.personnelui.BackgroundPanel;
import rmi.HotelWorkerRemoteHelper;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class ModifyRoomUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private List<String> allRoomType;
	private List<String> allRoomState;
	private static String hotelId="1";
	private int numOfRoomtype;
	private int numOfRoomstate;
	private ChangeRoomInfoService roomHelper;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyRoomUI frame = new ModifyRoomUI();
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
	public ModifyRoomUI() {
		
		roomHelper=HotelWorkerRemoteHelper.getInstance().getChangeRoomInfoService();
		allRoomType=roomHelper.getRoomType(hotelId);
		allRoomState=roomHelper.getRoomState(hotelId);
		numOfRoomtype=allRoomType.size();
		numOfRoomstate=allRoomState.size();
		
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
		
		JLabel label = new JLabel("·¿Ì¬ËÑË÷");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 22));
		label.setBounds(106, 199, 103, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("·¿¼äÀàÐÍ");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_1.setBounds(30, 274, 81, 21);
		contentPane.add(label_1);
		
		String[] roomType=(String[])allRoomType.toArray(new String[numOfRoomtype]);
		JComboBox<String> roomTypeBox = new JComboBox<String>(roomType);
		roomTypeBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		roomTypeBox.setBounds(126, 271, 133, 27);
		contentPane.add(roomTypeBox);
		
		JLabel label_2 = new JLabel("·¿¼äºÅ");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_2.setBounds(41, 423, 59, 21);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(126, 423, 133, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("·¿¼ä×´Ì¬");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		label_3.setBounds(30, 344, 81, 21);
		contentPane.add(label_3);
		
		
		String[] roomState=(String[])allRoomState.toArray((new String[numOfRoomstate]));
		JComboBox<String> roomStateBox = new JComboBox<String>(roomState);
		roomStateBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		roomStateBox.setBounds(126, 344, 133, 27);
		contentPane.add(roomStateBox);
		
		JButton button = new JButton("²éÕÒ");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button.setBounds(42, 529, 103, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Ë¢ÐÂ");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_1.setBounds(160, 529, 103, 33);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);
//		panel.setOpaque(false);
		panel.setBounds(363, 60, 778, 578);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_4= new JLabel("\u623F\u95F4\u53F7");
		label_4.setBounds(56, 46, 66, 30);
		panel.add(label_4);
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		textField = new JTextField();
		textField.setBounds(150, 50, 192, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 130, 192, 27);
		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(151, 372, 433, 115);
		panel.add(textArea);
		
		JLabel label_5 = new JLabel("\u623F\u95F4\u4EF7\u683C");
		label_5.setBounds(44, 295, 88, 30);
		panel.add(label_5);
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 299, 192, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_6 = new JLabel("\u623F\u95F4\u72B6\u6001");
		label_6.setBounds(44, 208, 88, 30);
		panel.add(label_6);
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		JLabel label_7 = new JLabel("\u623F\u95F4\u7C7B\u578B");
		label_7.setBounds(44, 126, 88, 30);
		panel.add(label_7);
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u7B80\u4ECB");
		lblNewLabel.setBounds(44, 407, 88, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 212, 192, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button4 = new JButton("\u786E\u8BA4");
		button4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button4.setBounds(479, 706, 123, 29);
		contentPane.add(button4);
		
		JButton button_5 = new JButton("\u53D6\u6D88");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button_5.setBounds(695, 706, 123, 29);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u8FD4\u56DE");
		button_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button_6.setBounds(905, 706, 123, 29);
		contentPane.add(button_6);
	}
}
