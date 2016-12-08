package presentation.clientUI_book;


/*
 * 
 * 客户进行订单预订——查看酒店详细信息界面原型
 */

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.clientUI_account.BackgroundPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class hotelDetailUI extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField txtAdasdasdAdasdaS;
	private JTextField textField_14;
	private JTextField txtDhasjkdhaskjdhAsdfKajdhkj;
	private JTextArea textArea_3;
	private JButton button_3;

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
					hotelDetailUI frame = new hotelDetailUI();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public hotelDetailUI()
	{
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("\u641C\u7D22\u6761\u4EF6");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(71, 90, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("目的地");
		txtDestination.setBounds(71, 170, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("入住日期");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(71, 270, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("关键词");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(71, 470, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		destination = new JTextField();
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		destination.setColumns(10);
		destination.setBounds(71, 210, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(destination);
		
		checkInDate = new JTextField();
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText("2016/12/02");
		checkInDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(71, 310, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(checkInDate);
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("酒店级别");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(71, 370, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		JButton button = new JButton(new ImageIcon("search.jpg"));
		button.setBounds(71, 710, 170, 60);
		backgroundPanel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  \u4E0D\u9650", "  \u4E94\u661F\u7EA7/\u8C6A\u534E", "  \u56DB\u661F\u7EA7/\u9AD8\u6863", "  \u4E09\u661F\u7EA7/\u8212\u9002", "  \u4E8C\u661F\u7EA7\u4EE5\u4E0B/\u7ECF\u6D4E"}));
		comboBox.setBounds(71, 410, 170, 50);
		backgroundPanel.add(comboBox);
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		
		
		BackgroundPanel backgroundPanel_7 = new BackgroundPanel(hotel);
		backgroundPanel_7.setBounds(435, 77, 350, 150);
		backgroundPanel.add(backgroundPanel_7);
		backgroundPanel_7.setLayout(null);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setBounds(0, 97, 330, 53);
		backgroundPanel_7.add(textArea_12);
		textArea_12.setEditable(false);
		textArea_12.setText("abc\u5927\u9152\u5E97");
		textArea_12.setOpaque(false);
		textArea_12.setMargin(new Insets(10, 10, 10, 10));
		textArea_12.setForeground(new Color(255, 255, 255));
		textArea_12.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		textArea_12.setColumns(10);
		textArea_12.setBackground(new Color(176, 224, 230));
		
		JButton button_6 = new JButton(new ImageIcon("orderBook.jpg"));
		button_6.setBounds(690, 710, 170, 60);
		backgroundPanel.add(button_6);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(0, 0, 139));
		textField.setBackground(SystemColor.activeCaption);
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setMargin(new Insets(2, 20, 2, 2));
		textField.setText("\u8BE6\u7EC6\u5730\u5740");
		textField.setBounds(435, 227, 120, 50);
		backgroundPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("\u9152\u5E97\u5546\u5708");
		textField_1.setMargin(new Insets(2, 20, 2, 2));
		textField_1.setForeground(new Color(0, 0, 139));
		textField_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setBounds(785, 177, 120, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("\u9152\u5E97\u661F\u7EA7");
		textField_2.setMargin(new Insets(2, 20, 2, 2));
		textField_2.setForeground(new Color(0, 0, 139));
		textField_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(785, 127, 120, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("\u9152\u5E97\u8BBE\u65BD");
		textField_3.setMargin(new Insets(2, 20, 2, 2));
		textField_3.setForeground(new Color(0, 0, 139));
		textField_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.activeCaption);
		textField_3.setBounds(435, 277, 120, 50);
		backgroundPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("\u9152\u5E97\u7B80\u4ECB");
		textField_4.setMargin(new Insets(2, 20, 2, 2));
		textField_4.setForeground(new Color(0, 0, 139));
		textField_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.activeCaption);
		textField_4.setBounds(435, 327, 120, 150);
		backgroundPanel.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("\u7EFC\u5408\u8BC4\u5206");
		textField_6.setMargin(new Insets(2, 20, 2, 2));
		textField_6.setForeground(new Color(0, 0, 139));
		textField_6.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.activeCaption);
		textField_6.setBounds(785, 77, 120, 50);
		backgroundPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("\u7EFC\u5408\u8BC4\u4EF7");
		textField_7.setMargin(new Insets(2, 20, 2, 2));
		textField_7.setForeground(new Color(0, 0, 139));
		textField_7.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_7.setColumns(10);
		textField_7.setBackground(SystemColor.activeCaption);
		textField_7.setBounds(435, 477, 120, 220);
		backgroundPanel.add(textField_7);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(245, 255, 250));
		textField_9.setEditable(false);
		textField_9.setMargin(new Insets(0, 20, 0, 0));
		textField_9.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(905, 177, 195, 50);
		backgroundPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(245, 255, 250));
		textField_10.setEditable(false);
		textField_10.setMargin(new Insets(0, 20, 0, 0));
		textField_10.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(905, 127, 195, 50);
		backgroundPanel.add(textField_10);
		
		txtAdasdasdAdasdaS = new JTextField();
		txtAdasdasdAdasdaS.setBackground(new Color(245, 255, 250));
		txtAdasdasdAdasdaS.setEditable(false);
		txtAdasdasdAdasdaS.setMargin(new Insets(0, 20, 0, 0));
		txtAdasdasdAdasdaS.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtAdasdasdAdasdaS.setColumns(10);
		txtAdasdasdAdasdaS.setBounds(555, 277, 545, 50);
		backgroundPanel.add(txtAdasdasdAdasdaS);
		
		textField_14 = new JTextField();
		textField_14.setBackground(new Color(245, 255, 250));
		textField_14.setEditable(false);
		textField_14.setMargin(new Insets(0, 20, 0, 0));
		textField_14.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_14.setColumns(10);
		textField_14.setBounds(905, 77, 195, 50);
		backgroundPanel.add(textField_14);
		
		txtDhasjkdhaskjdhAsdfKajdhkj = new JTextField();
		txtDhasjkdhaskjdhAsdfKajdhkj.setBackground(new Color(245, 255, 250));
		txtDhasjkdhaskjdhAsdfKajdhkj.setEditable(false);
		txtDhasjkdhaskjdhAsdfKajdhkj.setMargin(new Insets(0, 20, 0, 0));
		txtDhasjkdhaskjdhAsdfKajdhkj.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtDhasjkdhaskjdhAsdfKajdhkj.setColumns(10);
		txtDhasjkdhaskjdhAsdfKajdhkj.setBounds(555, 227, 545, 50);
		backgroundPanel.add(txtDhasjkdhaskjdhAsdfKajdhkj);
		
		JButton button_1 = new JButton(new ImageIcon("search2.jpg"));
		button_1.setBounds(400, 710, 170, 60);
		backgroundPanel.add(button_1);
		
		JTextArea txtrDadadAdAsdasdas = new JTextArea();
		txtrDadadAdAsdasdas.setBackground(new Color(245, 255, 250));
		txtrDadadAdAsdasdas.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtrDadadAdAsdasdas.setLineWrap(true);
		txtrDadadAdAsdasdas.setEditable(false);
		txtrDadadAdAsdasdas.setMargin(new Insets(20, 30, 20, 30));
		txtrDadadAdAsdasdas.setBounds(555, 327, 545, 150);
		backgroundPanel.add(txtrDadadAdAsdasdas);
		
		Image background5 = new ImageIcon("background7.jpg").getImage();
		JPanel panel = new BackgroundPanel(background5);
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(555, 477, 545, 220);
		backgroundPanel.add(panel);
		panel.setLayout(null);
		
		JButton button_2 = new JButton(new ImageIcon("last.jpg"));
		button_2.setBounds(14, 92, 40, 40);
		panel.add(button_2);
		
		JButton button_5 = new JButton(new ImageIcon("next.jpg"));
		button_5.setBounds(491, 92, 40, 40);
		panel.add(button_5);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setOpaque(false);
		textArea_2.setText("\u975E\u5E38\u597D\uFF01");
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setMargin(new Insets(20, 30, 20, 30));
		textArea_2.setBounds(63, 30, 420, 160);
		panel.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setForeground(new Color(192, 192, 192));
		textArea_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textArea_3.setLineWrap(true);
		textArea_3.setMargin(new Insets(10, 10, 10, 10));
		textArea_3.setText("(\u9009\u586B)\u9152\u5E97\u540D\u79F0");
		textArea_3.setBounds(71, 510, 170, 50);
		textArea_3.setBackground(new Color(245, 255, 250));
		backgroundPanel.add(textArea_3);
		
		button_3 = new JButton(new ImageIcon("history.jpg"));
		button_3.setBounds(977, 710, 170, 60);
		backgroundPanel.add(button_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("(\u9009\u586B)\u623F\u95F4\u7C7B\u578B");
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textArea.setBackground(new Color(245, 255, 250));
		textArea.setBounds(71, 560, 170, 50);
		backgroundPanel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("(\u9009\u586B)\u623F\u95F4\u6570\u91CF");
		textArea_1.setMargin(new Insets(10, 10, 10, 10));
		textArea_1.setLineWrap(true);
		textArea_1.setForeground(Color.LIGHT_GRAY);
		textArea_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textArea_1.setBackground(new Color(245, 255, 250));
		textArea_1.setBounds(71, 610, 170, 50);
		backgroundPanel.add(textArea_1);
		
	}
}


