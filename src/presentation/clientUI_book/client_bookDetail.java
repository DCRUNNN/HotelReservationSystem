package presentation.clientUI_book;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import presentation.clientUI_account.BackgroundPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;

public class client_bookDetail extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField destination;
	private JTextField checkInDate;
	private JTextField txtHotelGrade;
	private JTextField txtCheckOutDate;
	private JTextField checkOutDate;
	private JTextArea textArea;

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
					client_bookDetail frame = new client_bookDetail();
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
	public client_bookDetail()
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
		
		Image background = new ImageIcon("background.jpg").getImage();
		Image head = new ImageIcon("client.jpg").getImage();
		Image txtBackground = new ImageIcon("txtBackground.jpg").getImage();
		
		Image background2 = new ImageIcon("background2.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("酒店详情");
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
		txtKeyWord.setBounds(71, 570, 170, 40);
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
		txtHotelGrade.setBounds(71, 470, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setText("退房日期");
		txtCheckOutDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckOutDate.setForeground(Color.WHITE);
		txtCheckOutDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtCheckOutDate.setEditable(false);
		txtCheckOutDate.setColumns(10);
		txtCheckOutDate.setBackground(SystemColor.activeCaption);
		txtCheckOutDate.setBounds(71, 370, 170, 40);
		backgroundPanel.add(txtCheckOutDate);
		
		checkOutDate = new JTextField();
		checkOutDate.setBackground(new Color(245, 255, 250));
		checkOutDate.setText("2016/12/30");
		checkOutDate.setMargin(new Insets(0, 20, 0, 20));
		checkOutDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		checkOutDate.setColumns(10);
		checkOutDate.setBounds(71, 410, 170, 50);
		backgroundPanel.add(checkOutDate);
		
		JButton button = new JButton(new ImageIcon("search.jpg"));
		button.setBounds(71, 710, 170, 60);
		backgroundPanel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  \u4E0D\u9650", "  \u4E94\u661F\u7EA7/\u8C6A\u534E", "  \u56DB\u661F\u7EA7/\u9AD8\u6863", "  \u4E09\u661F\u7EA7/\u8212\u9002", "  \u4E8C\u661F\u7EA7\u4EE5\u4E0B/\u7ECF\u6D4E"}));
		comboBox.setBounds(71, 510, 170, 50);
		backgroundPanel.add(comboBox);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(192, 192, 192));
		textArea.setBackground(new Color(245, 255, 250));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setText("（选填）酒店名/地址/商圈");
		textArea.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textArea.setBounds(71, 610, 170, 90);
		backgroundPanel.add(textArea);
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		
		JButton button_3 = new JButton(new ImageIcon("lastPage.jpg"));
		button_3.setBounds(360, 710, 170, 60);
		backgroundPanel.add(button_3);
		
		JButton button_4 = new JButton(new ImageIcon("nextPage.jpg"));
		button_4.setBounds(975, 710, 170, 60);
		backgroundPanel.add(button_4);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setEditable(false);
		textArea_12.setText("abc\u5927\u9152\u5E97");
		textArea_12.setOpaque(false);
		textArea_12.setMargin(new Insets(10, 10, 10, 10));
		textArea_12.setForeground(new Color(25, 25, 112));
		textArea_12.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 35));
		textArea_12.setColumns(10);
		textArea_12.setBackground(new Color(176, 224, 230));
		textArea_12.setBounds(483, 50, 350, 50);
		backgroundPanel.add(textArea_12);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setEditable(false);
		textArea_13.setText("\u4ED9\u6797\u5927\u9053163\u53F7");
		textArea_13.setOpaque(false);
		textArea_13.setMargin(new Insets(10, 10, 10, 10));
		textArea_13.setForeground(new Color(0, 0, 128));
		textArea_13.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 16));
		textArea_13.setColumns(10);
		textArea_13.setBounds(490, 101, 350, 40);
		backgroundPanel.add(textArea_13);
		
		JLabel lblNewLabel = new JLabel("房型");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		lblNewLabel.setBounds(490, 181, 100, 30);
		backgroundPanel.add(lblNewLabel);
		
		Image background4 = new ImageIcon("background4.jpg").getImage();
		BackgroundPanel backgroundPanel_5 = new BackgroundPanel(background4);
		backgroundPanel_5.setLayout(null);
		backgroundPanel_5.setBounds(360, 211, 785, 90);
		backgroundPanel.add(backgroundPanel_5);
		
		Image room = new ImageIcon("room.jpg").getImage();
		BackgroundPanel backgroundPanel_6 = new BackgroundPanel(room);
		backgroundPanel_6.setBounds(0, 0, 90, 90);
		backgroundPanel_5.add(backgroundPanel_6);
		
		JLabel label_4 = new JLabel("标准单人间");
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_4.setBounds(104, 26, 118, 30);
		backgroundPanel_5.add(label_4);
		
		JLabel label_5 = new JLabel("普通客户");
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_5.setBounds(310, 26, 100, 30);
		backgroundPanel_5.add(label_5);
		
		JLabel label_6 = new JLabel("\u00A5499");
		label_6.setForeground(new Color(255, 69, 0));
		label_6.setFont(new Font("宋体", Font.BOLD, 20));
		label_6.setBounds(540, 26, 63, 30);
		backgroundPanel_5.add(label_6);
		
		JButton button_7 = new JButton(new ImageIcon("book.jpg"));
		button_7.setBounds(660, 23, 100, 45);
		backgroundPanel_5.add(button_7);
		
		BackgroundPanel backgroundPanel_7 = new BackgroundPanel(hotel);
		backgroundPanel_7.setBounds(360, 60, 120, 120);
		backgroundPanel.add(backgroundPanel_7);
		
		JButton button_6 = new JButton(new ImageIcon("search2.jpg"));
		button_6.setBounds(975, 120, 170, 60);
		backgroundPanel.add(button_6);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setText("\u00A5499");
		textArea_1.setOpaque(false);
		textArea_1.setForeground(new Color(255, 99, 71));
		textArea_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));
		textArea_1.setBounds(975, 60, 144, 60);
		backgroundPanel.add(textArea_1);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setEditable(false);
		textArea_14.setText("起");
		textArea_14.setOpaque(false);
		textArea_14.setMargin(new Insets(10, 10, 10, 10));
		textArea_14.setForeground(new Color(255, 69, 0));
		textArea_14.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		textArea_14.setColumns(10);
		textArea_14.setBounds(1105, 84, 40, 40);
		backgroundPanel.add(textArea_14);
		
		JLabel label = new JLabel("适用客户");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label.setBounds(670, 181, 100, 30);
		backgroundPanel.add(label);
		
		JLabel label_3 = new JLabel("价格");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_3.setBounds(900, 181, 100, 30);
		backgroundPanel.add(label_3);
		
		BackgroundPanel backgroundPanel_1 = new BackgroundPanel(background4);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(360, 311, 785, 90);
		backgroundPanel.add(backgroundPanel_1);
		
		BackgroundPanel backgroundPanel_2 = new BackgroundPanel(room);
		backgroundPanel_2.setBounds(0, 0, 90, 90);
		backgroundPanel_1.add(backgroundPanel_2);
		
		JLabel label_1 = new JLabel("\u6807\u51C6\u5355\u4EBA\u95F4");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_1.setBounds(104, 26, 118, 30);
		backgroundPanel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u666E\u901A\u5BA2\u6237");
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_2.setBounds(310, 26, 100, 30);
		backgroundPanel_1.add(label_2);
		
		JLabel label_7 = new JLabel("\u00A5499");
		label_7.setForeground(new Color(255, 69, 0));
		label_7.setFont(new Font("宋体", Font.BOLD, 20));
		label_7.setBounds(540, 26, 63, 30);
		backgroundPanel_1.add(label_7);
		
		JButton button_1 = new JButton(new ImageIcon("book.jpg"));
		button_1.setBounds(660, 23, 100, 45);
		backgroundPanel_1.add(button_1);
		
		BackgroundPanel backgroundPanel_3 = new BackgroundPanel(background4);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(360, 411, 785, 90);
		backgroundPanel.add(backgroundPanel_3);
		
		BackgroundPanel backgroundPanel_4 = new BackgroundPanel(room);
		backgroundPanel_4.setBounds(0, 0, 90, 90);
		backgroundPanel_3.add(backgroundPanel_4);
		
		JLabel label_8 = new JLabel("\u6807\u51C6\u5355\u4EBA\u95F4");
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_8.setBounds(104, 26, 118, 30);
		backgroundPanel_3.add(label_8);
		
		JLabel label_9 = new JLabel("\u666E\u901A\u5BA2\u6237");
		label_9.setForeground(new Color(0, 0, 128));
		label_9.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_9.setBounds(310, 26, 100, 30);
		backgroundPanel_3.add(label_9);
		
		JLabel label_10 = new JLabel("\u00A5499");
		label_10.setForeground(new Color(255, 69, 0));
		label_10.setFont(new Font("宋体", Font.BOLD, 20));
		label_10.setBounds(540, 26, 63, 30);
		backgroundPanel_3.add(label_10);
		
		JButton button_2 = new JButton(new ImageIcon("book.jpg"));
		button_2.setBounds(660, 23, 100, 45);
		backgroundPanel_3.add(button_2);
		
		BackgroundPanel backgroundPanel_8 = new BackgroundPanel(background4);
		backgroundPanel_8.setLayout(null);
		backgroundPanel_8.setBounds(360, 511, 785, 90);
		backgroundPanel.add(backgroundPanel_8);
		
		BackgroundPanel backgroundPanel_9 = new BackgroundPanel(room);
		backgroundPanel_9.setBounds(0, 0, 90, 90);
		backgroundPanel_8.add(backgroundPanel_9);
		
		JLabel label_11 = new JLabel("\u6807\u51C6\u5355\u4EBA\u95F4");
		label_11.setForeground(new Color(0, 0, 128));
		label_11.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_11.setBounds(104, 26, 118, 30);
		backgroundPanel_8.add(label_11);
		
		JLabel label_12 = new JLabel("\u666E\u901A\u5BA2\u6237");
		label_12.setForeground(new Color(0, 0, 128));
		label_12.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_12.setBounds(310, 26, 100, 30);
		backgroundPanel_8.add(label_12);
		
		JLabel label_13 = new JLabel("\u00A5499");
		label_13.setForeground(new Color(255, 69, 0));
		label_13.setFont(new Font("宋体", Font.BOLD, 20));
		label_13.setBounds(540, 26, 63, 30);
		backgroundPanel_8.add(label_13);
		
		JButton button_5 = new JButton(new ImageIcon("book.jpg"));
		button_5.setBounds(660, 23, 100, 45);
		backgroundPanel_8.add(button_5);
		
		BackgroundPanel backgroundPanel_10 = new BackgroundPanel(background4);
		backgroundPanel_10.setLayout(null);
		backgroundPanel_10.setBounds(360, 611, 785, 90);
		backgroundPanel.add(backgroundPanel_10);
		
		BackgroundPanel backgroundPanel_11 = new BackgroundPanel(room);
		backgroundPanel_11.setBounds(0, 0, 90, 90);
		backgroundPanel_10.add(backgroundPanel_11);
		
		JLabel label_14 = new JLabel("\u6807\u51C6\u5355\u4EBA\u95F4");
		label_14.setForeground(new Color(0, 0, 128));
		label_14.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_14.setBounds(104, 26, 118, 30);
		backgroundPanel_10.add(label_14);
		
		JLabel label_15 = new JLabel("\u666E\u901A\u5BA2\u6237");
		label_15.setForeground(new Color(0, 0, 128));
		label_15.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label_15.setBounds(310, 26, 100, 30);
		backgroundPanel_10.add(label_15);
		
		JLabel label_16 = new JLabel("\u00A5499");
		label_16.setForeground(new Color(255, 69, 0));
		label_16.setFont(new Font("宋体", Font.BOLD, 20));
		label_16.setBounds(540, 26, 63, 30);
		backgroundPanel_10.add(label_16);
		
		JButton button_8 = new JButton(new ImageIcon("book.jpg"));
		button_8.setBounds(660, 23, 100, 45);
		backgroundPanel_10.add(button_8);
		
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


