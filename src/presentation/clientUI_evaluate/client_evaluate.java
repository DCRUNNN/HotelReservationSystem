package presentation.clientUI_evaluate;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import presentation.clientUI_account.BackgroundPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class client_evaluate extends JFrame
{

	private JPanel contentPane;
	private JTextField OrderID;
	private JTextField txtOrderID;
	private JTextField txtRoom;
	private JTextField txtOrderStatement;
	private JTextField txtHotelName;
	private JTextField txtComment;
	private JTextField OrderStatement;
	private JTextField HotelName;
	private JTextField txtOrderDate;
	private JTextField OrderDate;
	private JTextField txtOrderPrice;
	private JTextField OrderPrice;
	private JTextField txtHotelScore;
	private JTextField HotelScore;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;

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
					client_evaluate frame = new client_evaluate();
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
	public client_evaluate()
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
		
		JPanel headPanel = new BackgroundPanel(head);
		headPanel.setBounds(71, 90, 170, 170);
		contentPane.add(headPanel);
		
		Image background2 = new ImageIcon("background2.jpg").getImage();
		Image background3 = new ImageIcon("background3.jpg").getImage();
		JPanel backgroundPanel = new BackgroundPanel(background3);
		backgroundPanel.setBounds(0, 0, 1200, 800);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel accountLabel = new JLabel("订单信息");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setBounds(400, 82, 202, 50);
		accountLabel.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		backgroundPanel.add(accountLabel);
		
		txtOrderID = new JTextField();
		txtOrderID.setBackground(SystemColor.activeCaption);
		txtOrderID.setForeground(Color.WHITE);
		txtOrderID.setText("订单编号");
		txtOrderID.setBounds(400, 147, 120, 50);
		txtOrderID.setColumns(10);
		txtOrderID.setMargin(new Insets(0, 20, 0, 0));
		txtOrderID.setEditable(false);
		txtOrderID.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderID);
		
		txtRoom = new JTextField();
		txtRoom.setBackground(SystemColor.activeCaption);
		txtRoom.setForeground(Color.WHITE);
		txtRoom.setText("房间设施");
		txtRoom.setColumns(10);
		txtRoom.setBounds(400, 297, 120, 50);
		txtRoom.setMargin(new Insets(0, 20, 0, 0));
		txtRoom.setEditable(false);
		txtRoom.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtRoom);
		
		txtOrderStatement = new JTextField();
		txtOrderStatement.setBackground(SystemColor.activeCaption);
		txtOrderStatement.setForeground(Color.WHITE);
		txtOrderStatement.setText("订单状态");
		txtOrderStatement.setColumns(10);
		txtOrderStatement.setBounds(400, 197, 120, 50);
		txtOrderStatement.setMargin(new Insets(0, 20, 0, 0));
		txtOrderStatement.setEditable(false);
		txtOrderStatement.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtOrderStatement);
		
		txtHotelName = new JTextField();
		txtHotelName.setBackground(SystemColor.activeCaption);
		txtHotelName.setForeground(Color.WHITE);
		txtHotelName.setText("酒店名称");
		txtHotelName.setColumns(10);
		txtHotelName.setBounds(650, 197, 120, 50);
		txtHotelName.setMargin(new Insets(0, 20, 0, 0));
		txtHotelName.setEditable(false);
		txtHotelName.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtHotelName);
		
		txtComment = new JTextField();
		txtComment.setBackground(SystemColor.activeCaption);
		txtComment.setForeground(Color.WHITE);
		txtComment.setText("入住评价");
		txtComment.setColumns(10);
		txtComment.setBounds(400, 397, 120, 190);
		txtComment.setMargin(new Insets(0, 20, 0, 0));
		txtComment.setEditable(false);
		txtComment.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		backgroundPanel.add(txtComment);
		
		OrderID = new JTextField();
		OrderID.setBackground(new Color(245, 255, 250));
		OrderID.setBounds(520, 147, 130, 50);
		OrderID.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderID);
		OrderID.setColumns(10);
		
		OrderStatement = new JTextField();
		OrderStatement.setBackground(new Color(245, 255, 250));
		OrderStatement.setColumns(10);
		OrderStatement.setBounds(520, 197, 130, 50);
		OrderStatement.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(OrderStatement);
		
		HotelName = new JTextField();
		HotelName.setBackground(new Color(245, 255, 250));
		HotelName.setColumns(10);
		HotelName.setBounds(770, 197, 130, 50);
		HotelName.setMargin(new Insets(0, 20, 0, 0));
		backgroundPanel.add(HotelName);
		
		JButton modifyButton = new JButton(new ImageIcon("returnButton.jpg"));
		modifyButton.setBounds(400, 697, 165, 50);
		backgroundPanel.add(modifyButton);
		
		txtOrderDate = new JTextField();
		txtOrderDate.setBackground(SystemColor.activeCaption);
		txtOrderDate.setForeground(Color.WHITE);
		txtOrderDate.setText("订单日期");
		txtOrderDate.setMargin(new Insets(0, 20, 0, 0));
		txtOrderDate.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderDate.setEditable(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(650, 147, 120, 50);
		backgroundPanel.add(txtOrderDate);
		
		OrderDate = new JTextField();
		OrderDate.setBackground(new Color(245, 255, 250));
		OrderDate.setMargin(new Insets(0, 20, 0, 0));
		OrderDate.setColumns(10);
		OrderDate.setBounds(770, 147, 130, 50);
		backgroundPanel.add(OrderDate);
		
		txtOrderPrice = new JTextField();
		txtOrderPrice.setBackground(SystemColor.activeCaption);
		txtOrderPrice.setForeground(Color.WHITE);
		txtOrderPrice.setText("订单价格");
		txtOrderPrice.setMargin(new Insets(0, 20, 0, 0));
		txtOrderPrice.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtOrderPrice.setEditable(false);
		txtOrderPrice.setColumns(10);
		txtOrderPrice.setBounds(900, 147, 120, 50);
		backgroundPanel.add(txtOrderPrice);
		
		OrderPrice = new JTextField();
		OrderPrice.setBackground(new Color(245, 255, 250));
		OrderPrice.setMargin(new Insets(0, 20, 0, 0));
		OrderPrice.setColumns(10);
		OrderPrice.setBounds(1020, 147, 130, 50);
		backgroundPanel.add(OrderPrice);
		
		txtHotelScore = new JTextField();
		txtHotelScore.setBackground(SystemColor.activeCaption);
		txtHotelScore.setForeground(Color.WHITE);
		txtHotelScore.setText("综合评分");
		txtHotelScore.setMargin(new Insets(0, 20, 0, 0));
		txtHotelScore.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		txtHotelScore.setEditable(false);
		txtHotelScore.setColumns(10);
		txtHotelScore.setBounds(900, 197, 120, 50);
		backgroundPanel.add(txtHotelScore);
		
		HotelScore = new JTextField();
		HotelScore.setBackground(new Color(245, 255, 250));
		HotelScore.setMargin(new Insets(0, 20, 0, 0));
		HotelScore.setColumns(10);
		HotelScore.setBounds(1020, 197, 130, 50);
		backgroundPanel.add(HotelScore);
		
		button = new JButton(new ImageIcon("confirm.jpg"));
		button.setBounds(985, 697, 165, 50);
		backgroundPanel.add(button);
		
		button_1 = new JButton(new ImageIcon("ordercomment.jpg"));
		button_1.setBounds(1020, 82, 130, 50);
		backgroundPanel.add(button_1);
		
		button_2 = new JButton(new ImageIcon("orderInfo.jpg"));
		button_2.setBounds(890, 82, 130, 50);
		backgroundPanel.add(button_2);
		
		button_3 = new JButton(new ImageIcon("myOrder.jpg"));
		button_3.setBounds(760, 82, 130, 50);
		backgroundPanel.add(button_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\t\t\t1", "\t\t\t2", "\t\t\t3", "\t\t\t4", "\t\t\t5"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(520, 297, 45, 50);
		backgroundPanel.add(comboBox);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaption);
		textField.setForeground(Color.WHITE);
		textField.setText("服务态度");
		textField.setMargin(new Insets(0, 20, 0, 0));
		textField.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(650, 297, 120, 50);
		backgroundPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setForeground(Color.WHITE);
		textField_1.setText("周边环境");
		textField_1.setMargin(new Insets(0, 20, 0, 0));
		textField_1.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(900, 297, 120, 50);
		backgroundPanel.add(textField_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		comboBox_1.setBounds(770, 297, 45, 50);
		backgroundPanel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setFont(new Font("迷你简卡通", Font.BOLD, 20));
		comboBox_2.setBounds(1020, 297, 45, 50);
		backgroundPanel.add(comboBox_2);
		
		label = new JLabel("\u6B22\u8FCE\u60A8\uFF0C\u5F20\u4E09");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 20));
		label.setBounds(71, 270, 170, 60);
		backgroundPanel.add(label);
		
		JButton accountButton = new JButton(new ImageIcon("accountButton.jpg"));
		accountButton.setBounds(71, 400, 170, 60);
		backgroundPanel.add(accountButton);
		
		JButton orderButton = new JButton(new ImageIcon("orderButton.jpg"));
		orderButton.setBounds(71, 470, 170, 60);
		backgroundPanel.add(orderButton);
		
		JButton hotelButton = new JButton(new ImageIcon("hotelButton.jpg"));
		hotelButton.setBounds(71, 540, 170, 60);
		backgroundPanel.add(hotelButton);
		
		JButton creditButton = new JButton(new ImageIcon("creditButton.jpg"));
		creditButton.setBounds(71, 610, 170, 60);
		backgroundPanel.add(creditButton);
		
		JButton memberButton = new JButton(new ImageIcon("memberButton.jpg"));
		memberButton.setBounds(71, 680, 170, 60);
		backgroundPanel.add(memberButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 20));
		textArea.setBackground(new Color(248, 248, 255));
		textArea.setMargin(new Insets(30, 20, 30, 20));
		textArea.setLineWrap(true);
		textArea.setBounds(520, 397, 630, 190);
		backgroundPanel.add(textArea);
		
		Image leftbackground = new ImageIcon("leftbackground.jpg").getImage();
	}
}


