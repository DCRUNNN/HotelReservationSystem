package presentation.clientUI_mainui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import presentation.clientUI_account.BackgroundPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class mainUI extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtDestination;
	private JTextField txtCheckInDate;
	private JTextField txtKeyWord;
	private JTextField checkInDate;
	private JTextField keyWord;
	private JTextField txtHotelGrade;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

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
					mainUI frame = new mainUI();
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
	
	public mainUI()
	{
		this.initial();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initial()
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
		
		Image head = new ImageIcon("client.jpg").getImage();
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(70, 400, 170, 60);
		contentPane.add(accountButton);
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(70, 470, 170, 60);
		contentPane.add(orderButton);
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(70, 540, 170, 60);
		contentPane.add(hotelButton);
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(70, 610, 170, 60);
		contentPane.add(creditButton);
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(70, 680, 170, 60);
		contentPane.add(memberButton);
		
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("¾ÆµêÔ¤¶©");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setBackground(SystemColor.activeCaption);
		txtDestination.setText("Ä¿µÄµØ");
		txtDestination.setBounds(400, 210, 200, 50);
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
		txtCheckInDate.setBounds(400, 290, 200, 50);
		txtCheckInDate.setMargin(new Insets(0, 20, 0, 0));
		txtCheckInDate.setEditable(false);
		txtCheckInDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtCheckInDate);
		
		txtKeyWord = new JTextField();
		txtKeyWord.setForeground(Color.WHITE);
		txtKeyWord.setBackground(SystemColor.activeCaption);
		txtKeyWord.setText("¹Ø¼ü´Ê");
		txtKeyWord.setColumns(10);
		txtKeyWord.setBounds(400, 450, 200, 50);
		txtKeyWord.setMargin(new Insets(0, 20, 0, 0));
		txtKeyWord.setEditable(false);
		txtKeyWord.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		backgroundPanel.add(txtKeyWord);
		
		checkInDate = new JTextField();
		checkInDate.setText("2016/12/02");
		checkInDate.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		checkInDate.setColumns(10);
		checkInDate.setBounds(600, 290, 280, 50);
		checkInDate.setMargin(new Insets(0, 60, 0, 20));
		backgroundPanel.add(checkInDate);
		
		keyWord = new JTextField();
		keyWord.setForeground(new Color(169, 169, 169));
		keyWord.setText("\uFF08\u9009\u586B\uFF09\u9152\u5E97\u540D");
		keyWord.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		keyWord.setColumns(10);
		keyWord.setBounds(600, 450, 280, 50);
		keyWord.setMargin(new Insets(0, 20, 0, 20));
		backgroundPanel.add(keyWord);
		
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		backgroundPanel.add(headPanel);
		headPanel.setBorder(null);
		
		JLabel welcomeLabel = new JLabel("»¶Ó­Äú£¬ÕÅÈý");
		welcomeLabel.setBounds(71, 270, 170, 60);
		backgroundPanel.add(welcomeLabel);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 26));
		
		txtHotelGrade = new JTextField();
		txtHotelGrade.setText("¾Æµê¼¶±ð");
		txtHotelGrade.setMargin(new Insets(0, 20, 0, 0));
		txtHotelGrade.setForeground(Color.WHITE);
		txtHotelGrade.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		txtHotelGrade.setEditable(false);
		txtHotelGrade.setColumns(10);
		txtHotelGrade.setBackground(SystemColor.activeCaption);
		txtHotelGrade.setBounds(400, 370, 200, 50);
		backgroundPanel.add(txtHotelGrade);
		
		button = new JButton(new ImageIcon("search.jpg"));
		button.setBounds(980, 676, 170, 60);
		backgroundPanel.add(button);
		button.addActionListener(this);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"        \u4E0D\u9650", "        \u4E94\u661F\u7EA7/\u8C6A\u534E", "        \u56DB\u661F\u7EA7/\u9AD8\u6863", "        \u4E09\u661F\u7EA7/\u8212\u9002", "        \u4E8C\u661F\u7EA7\u4EE5\u4E0B/\u7ECF\u6D4E"}));
		comboBox.setBounds(600, 370, 280, 50);
		backgroundPanel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"        \u7701"}));
		comboBox_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(600, 210, 140, 50);
		backgroundPanel.add(comboBox_1);
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"        \u5E02"}));
		comboBox_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(740, 210, 140, 50);
		backgroundPanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"        \uFF08\u5546\u5708\uFF09"}));
		comboBox_3.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(880, 210, 270, 50);
		backgroundPanel.add(comboBox_3);
		
		textField = new JTextField();
		textField.setText("\u5173\u952E\u8BCD");
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(400, 530, 200, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\uFF08\u9009\u586B\uFF09\u623F\u95F4\u7C7B\u578B");
		textField_1.setMargin(new Insets(0, 20, 0, 20));
		textField_1.setForeground(new Color(169, 169, 169));
		textField_1.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(600, 530, 280, 50);
		backgroundPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u5173\u952E\u8BCD");
		textField_2.setMargin(new Insets(0, 20, 0, 0));
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.activeCaption);
		textField_2.setBounds(402, 610, 200, 50);
		backgroundPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("\uFF08\u9009\u586B\uFF09\u623F\u95F4\u6570\u91CF");
		textField_3.setMargin(new Insets(0, 20, 0, 20));
		textField_3.setForeground(new Color(169, 169, 169));
		textField_3.setFont(new Font("·½ÕýÀ¼Í¤³¬Ï¸ºÚ¼òÌå", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(600, 610, 280, 50);
		backgroundPanel.add(textField_3);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == button)
		{
			String address = (String) comboBox_1.getSelectedItem();
			String time = checkInDate.getText();
			String hoteltype = (String) comboBox.getSelectedItem();
			String keyword1 = keyWord.getText()+textField_1.getText()+textField_3.getText();
			
		}
		// TODO Auto-generated method stub
		
	}
}


