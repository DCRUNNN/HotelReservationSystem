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

public class client_book extends JFrame
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
	private JLabel txtPrice;
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	private JCheckBox c4;
	private JCheckBox c5;
	private JTextArea txtAbc;
	private JTextArea textField;
	private JTextArea textField_1;
	private JTextArea textArea_1;
	private JTextArea textField_2;
	private JButton btnNewButton;
	private JPanel panel_1;

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
					client_book frame = new client_book();
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
	public client_book()
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
		
		Image background2 = new ImageIcon("background2_1.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("¾ÆµêÔ¤¶©");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(71, 90, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("Ä¿µÄµØ");
		txtDestination.setBounds(71, 170, 170, 40);
		txtDestination.setColumns(10);
		txtDestination.setMargin(new Insets(0, 20, 0, 0));
		txtDestination.setEditable(false);
		txtDestination.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtDestination);
		
		txtCheckInDate = new JTextField();
		txtCheckInDate.setForeground(Color.WHITE);
		txtCheckInDate.setBackground(SystemColor.activeCaption);
		txtCheckInDate.setText("Èë×¡ÈÕÆÚ");
		txtCheckInDate.setColumns(10);
		txtCheckInDate.setBounds(71, 270, 170, 40);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("¹Ø¼ü´Ê");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(71, 570, 170, 40);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		destination = new JTextField();
		destination.setBackground(new Color(245, 255, 250));
		destination.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		destination.setColumns(10);
		destination.setBounds(71, 210, 170, 50);
		destination.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(destination);
		
		checkInDate = new JTextField();
		checkInDate.setBackground(new Color(245, 255, 250));
		checkInDate.setText("2016/12/02");
		checkInDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(71, 310, 170, 50);
		checkInDate.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(checkInDate);
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("¾Æµê¼¶±ð");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(71, 470, 170, 40);
		backgroundPanel.add(txtHotelGrade);
		
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setText("ÍË·¿ÈÕÆÚ");
		txtCheckOutDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckOutDate.setForeground(Color.WHITE);
		txtCheckOutDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtCheckOutDate.setEditable(false);
		txtCheckOutDate.setColumns(10);
		txtCheckOutDate.setBackground(SystemColor.activeCaption);
		txtCheckOutDate.setBounds(71, 370, 170, 40);
		backgroundPanel.add(txtCheckOutDate);
		
		checkOutDate = new JTextField();
		checkOutDate.setBackground(new Color(245, 255, 250));
		checkOutDate.setText("2016/12/30");
		checkOutDate.setMargin(new Insets(0, 20, 0, 20));
		checkOutDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		checkOutDate.setColumns(10);
		checkOutDate.setBounds(71, 410, 170, 50);
		backgroundPanel.add(checkOutDate);
		
		JButton button = new JButton(new ImageIcon("search.jpg"));
		button.setBounds(71, 710, 170, 60);
		backgroundPanel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"  \u4E0D\u9650", "  \u4E94\u661F\u7EA7/\u8C6A\u534E", "  \u56DB\u661F\u7EA7/\u9AD8\u6863", "  \u4E09\u661F\u7EA7/\u8212\u9002", "  \u4E8C\u661F\u7EA7\u4EE5\u4E0B/\u7ECF\u6D4E"}));
		comboBox.setBounds(71, 510, 170, 50);
		backgroundPanel.add(comboBox);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(192, 192, 192));
		textArea.setBackground(new Color(245, 255, 250));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setText("£¨Ñ¡Ìî£©¾ÆµêÃû/µØÖ·/ÉÌÈ¦");
		textArea.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textArea.setBounds(71, 610, 170, 90);
		backgroundPanel.add(textArea);
		
		txtPrice = new JLabel();
		txtPrice.setOpaque(false);
		txtPrice.setText("¼Û¸ñ");
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtPrice.setBounds(413, 69, 52, 50);
		backgroundPanel.add(txtPrice);
		
		c1 = new JCheckBox("\u00A5150\u4EE5\u4E0B");
		c1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		c1.setOpaque(false);
		c1.setBounds(475, 60, 140, 50);
		backgroundPanel.add(c1);
		
		c2 = new JCheckBox("\u00A5150~300");
		c2.setOpaque(false);
		c2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		c2.setBounds(609, 60, 140, 50);
		backgroundPanel.add(c2);
		
		c3 = new JCheckBox("\u00A5300~450");
		c3.setOpaque(false);
		c3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		c3.setBounds(755, 60, 140, 50);
		backgroundPanel.add(c3);
		
		c4 = new JCheckBox("\u00A5450~600");
		c4.setOpaque(false);
		c4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		c4.setBounds(543, 90, 140, 50);
		backgroundPanel.add(c4);
		
		c5 = new JCheckBox("\u00A5600\u4EE5\u4E0A");
		c5.setOpaque(false);
		c5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		c5.setBounds(683, 90, 140, 50);
		backgroundPanel.add(c5);
		
		Image hotel = new ImageIcon("hotel.jpg").getImage();
		JPanel panel = new BackgroundPanel(hotel);
		panel.setBounds(374, 170, 120, 120);
		backgroundPanel.add(panel);
		
		txtAbc = new JTextArea();
		txtAbc.setOpaque(false);
		txtAbc.setBackground(new Color(176, 224, 230));
		txtAbc.setForeground(new Color(25, 25, 112));
		txtAbc.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 26));
		txtAbc.setMargin(new Insets(10, 10, 10, 10));
		txtAbc.setText("abc\u5927\u9152\u5E97");
		txtAbc.setBounds(494, 170, 280, 40);
		backgroundPanel.add(txtAbc);
		txtAbc.setColumns(10);
		
		textArea_1 = new JTextArea();
		textArea_1.setForeground(new Color(255, 99, 71));
		textArea_1.setOpaque(false);
		textArea_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD | Font.ITALIC, 60));
		textArea_1.setText("4.5");
		textArea_1.setBounds(870, 180, 126, 90);
		backgroundPanel.add(textArea_1);
		
		btnNewButton = new JButton(new ImageIcon("view.jpg"));
		btnNewButton.setBounds(996, 170, 135, 120);
		backgroundPanel.add(btnNewButton);
		
		//panel_1 = new JPanel();
		//panel_1.setBackground(Color.white);
		panel_1 = new BackgroundPanel(background2);
		panel_1.setBounds(360, 155, 785, 155);
		backgroundPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_2 = new JTextArea();
		textField_2.setBounds(228, 99, 220, 43);
		panel_1.add(textField_2);
		textField_2.setForeground(new Color(25, 25, 112));
		textField_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_2.setMargin(new Insets(10, 10, 10, 10));
		textField_2.setText("13951723660");
		textField_2.setOpaque(false);
		textField_2.setColumns(10);
		
		textField_1 = new JTextArea();
		textField_1.setEditable(false);
		textField_1.setBounds(135, 103, 98, 40);
		panel_1.add(textField_1);
		textField_1.setForeground(new Color(25, 25, 112));
		textField_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textField_1.setMargin(new Insets(10, 10, 10, 10));
		textField_1.setText("\u9884\u8BA2\u70ED\u7EBF");
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		
		textField = new JTextArea();
		textField.setBounds(135, 70, 350, 40);
		panel_1.add(textField);
		textField.setForeground(new Color(25, 25, 112));
		textField.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textField.setMargin(new Insets(10, 10, 10, 10));
		textField.setText("\u4ED9\u6797\u5927\u9053163\u53F7");
		textField.setOpaque(false);
		textField.setColumns(10);
		
		JLabel label = new JLabel();
		label.setBounds(425, 17, 98, 40);
		panel_1.add(label);
		label.setText("×ÛºÏÆÀ·Ö");
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		
		BackgroundPanel backgroundPanel_2 = new BackgroundPanel(hotel);
		backgroundPanel_2.setBounds(374, 345, 120, 120);
		backgroundPanel.add(backgroundPanel_2);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setText("4.5");
		textArea_6.setOpaque(false);
		textArea_6.setForeground(new Color(255, 99, 71));
		textArea_6.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD | Font.ITALIC, 60));
		textArea_6.setBounds(870, 355, 126, 90);
		backgroundPanel.add(textArea_6);
		
		JButton button_1 = new JButton(new ImageIcon("view.jpg"));
		button_1.setBounds(996, 345, 135, 120);
		backgroundPanel.add(button_1);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setText("abc\u5927\u9152\u5E97");
		textArea_5.setOpaque(false);
		textArea_5.setMargin(new Insets(10, 10, 10, 10));
		textArea_5.setForeground(new Color(25, 25, 112));
		textArea_5.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 26));
		textArea_5.setColumns(10);
		textArea_5.setBackground(new Color(176, 224, 230));
		textArea_5.setBounds(494, 345, 280, 40);
		backgroundPanel.add(textArea_5);
		
		BackgroundPanel backgroundPanel_1 = new BackgroundPanel(background2);
		backgroundPanel_1.setLayout(null);
		backgroundPanel_1.setBounds(360, 330, 785, 155);
		backgroundPanel.add(backgroundPanel_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("13951723660");
		textArea_2.setOpaque(false);
		textArea_2.setMargin(new Insets(10, 10, 10, 10));
		textArea_2.setForeground(new Color(25, 25, 112));
		textArea_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textArea_2.setColumns(10);
		textArea_2.setBounds(228, 99, 220, 43);
		backgroundPanel_1.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_3.setOpaque(false);
		textArea_3.setMargin(new Insets(10, 10, 10, 10));
		textArea_3.setForeground(new Color(25, 25, 112));
		textArea_3.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textArea_3.setEditable(false);
		textArea_3.setColumns(10);
		textArea_3.setBounds(135, 103, 98, 40);
		backgroundPanel_1.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("\u4ED9\u6797\u5927\u9053163\u53F7");
		textArea_4.setOpaque(false);
		textArea_4.setMargin(new Insets(10, 10, 10, 10));
		textArea_4.setForeground(new Color(25, 25, 112));
		textArea_4.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textArea_4.setColumns(10);
		textArea_4.setBounds(135, 70, 350, 40);
		backgroundPanel_1.add(textArea_4);
		
		JLabel label_1 = new JLabel();
		label_1.setText("\u7EFC\u5408\u8BC4\u5206");
		label_1.setOpaque(false);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		label_1.setBounds(425, 17, 98, 40);
		backgroundPanel_1.add(label_1);
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setText("4.5");
		textArea_11.setOpaque(false);
		textArea_11.setForeground(new Color(255, 99, 71));
		textArea_11.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD | Font.ITALIC, 60));
		textArea_11.setBounds(870, 535, 126, 90);
		backgroundPanel.add(textArea_11);
		
		BackgroundPanel backgroundPanel_4 = new BackgroundPanel(hotel);
		backgroundPanel_4.setBounds(374, 525, 120, 120);
		backgroundPanel.add(backgroundPanel_4);
		
		JButton button_2 = new JButton(new ImageIcon("view.jpg"));
		button_2.setBounds(996, 525, 135, 120);
		backgroundPanel.add(button_2);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setText("abc\u5927\u9152\u5E97");
		textArea_10.setOpaque(false);
		textArea_10.setMargin(new Insets(10, 10, 10, 10));
		textArea_10.setForeground(new Color(25, 25, 112));
		textArea_10.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 26));
		textArea_10.setColumns(10);
		textArea_10.setBackground(new Color(176, 224, 230));
		textArea_10.setBounds(494, 525, 280, 40);
		backgroundPanel.add(textArea_10);
		
		BackgroundPanel backgroundPanel_3 = new BackgroundPanel(background2);
		backgroundPanel_3.setLayout(null);
		backgroundPanel_3.setBounds(360, 510, 785, 155);
		backgroundPanel.add(backgroundPanel_3);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setText("13951723660");
		textArea_7.setOpaque(false);
		textArea_7.setMargin(new Insets(10, 10, 10, 10));
		textArea_7.setForeground(new Color(25, 25, 112));
		textArea_7.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textArea_7.setColumns(10);
		textArea_7.setBounds(228, 99, 220, 43);
		backgroundPanel_3.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setText("\u9884\u8BA2\u70ED\u7EBF");
		textArea_8.setOpaque(false);
		textArea_8.setMargin(new Insets(10, 10, 10, 10));
		textArea_8.setForeground(new Color(25, 25, 112));
		textArea_8.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textArea_8.setEditable(false);
		textArea_8.setColumns(10);
		textArea_8.setBounds(135, 103, 98, 40);
		backgroundPanel_3.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setText("\u4ED9\u6797\u5927\u9053163\u53F7");
		textArea_9.setOpaque(false);
		textArea_9.setMargin(new Insets(10, 10, 10, 10));
		textArea_9.setForeground(new Color(25, 25, 112));
		textArea_9.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 16));
		textArea_9.setColumns(10);
		textArea_9.setBounds(135, 70, 350, 40);
		backgroundPanel_3.add(textArea_9);
		
		JLabel label_2 = new JLabel();
		label_2.setText("\u7EFC\u5408\u8BC4\u5206");
		label_2.setOpaque(false);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		label_2.setBounds(425, 17, 98, 40);
		backgroundPanel_3.add(label_2);
		
		JButton button_3 = new JButton(new ImageIcon("lastPage.jpg"));
		button_3.setBounds(360, 710, 170, 60);
		backgroundPanel.add(button_3);
		
		JButton button_4 = new JButton(new ImageIcon("nextPage.jpg"));
		button_4.setBounds(975, 710, 170, 60);
		backgroundPanel.add(button_4);
		
		JButton button_5 = new JButton(new ImageIcon("return2.jpg"));
		button_5.setBounds(975, 80, 170, 60);
		backgroundPanel.add(button_5);
		
		JCheckBox[] jcb =new JCheckBox[]{c1,c2,c3,c4,c5};
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


