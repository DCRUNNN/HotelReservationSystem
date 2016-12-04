package presentation.personnelui_hotelWorker.hotelpersonnel.ManageRoom;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import presentation.personnelui.BackgroundPanel;
import rmi.HotelWorkerRemoteHelper;
import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import vo.RoomVO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.List;
import javax.swing.JTabbedPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ManageRoomUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChangeRoomInfoService roomHelper;
	private JPanel contentPane;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private static String hotelId="1";
	private List<String> allRoomType;
	private List<String> allRoomState;
	private int numOfRoomtype;
	private int numOfRoomstate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRoomUI frame = new ManageRoomUI(hotelId);
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
	public ManageRoomUI(String hotelId) {
		
		roomHelper=HotelWorkerRemoteHelper.getInstance().getChangeRoomInfoService();
		allRoomType=roomHelper.getRoomType(hotelId);
		numOfRoomtype=allRoomType.size();
		allRoomState=roomHelper.getRoomState(hotelId);
		numOfRoomstate=allRoomState.size();
		this.init();
		this.initSearch();
		this.buildMainPane();
	}

	public void initSearch(){
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
	}
	
	public void buildMainPane(){
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		tabbedPane.setBounds(340, 123, 826, 539);
		contentPane.add(tabbedPane);

		GridBagLayout gbLayout=new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill=GridBagConstraints.NONE;
		s.weightx=1;
		s.weighty=1;
		
		for(int i=0;i<numOfRoomtype;i++){
			JPanel p=new JPanel(gbLayout);
			p.setLayout(new FlowLayout());
			p.setOpaque(false);
			List<RoomVO> room=roomHelper.getRoomByType(allRoomType.get(i));
			for(int j=0;j<room.size();j++){
				s.gridx=2;
				s.gridy=2;
				s.insets=new Insets(20, 30, 0, 5);
				JButton button=new JButton(room.get(j).getRoomNumber());
				button.setVerticalTextPosition(JButton.BOTTOM);  
				button.setHorizontalTextPosition(JButton.CENTER);
				String picName=room.get(j).getRoomState()+".jpg";
				button.setIcon(new ImageIcon(picName));
				p.add(button,s);
			}
			tabbedPane.addTab(allRoomType.get(i),p);
		}
		
		
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
		
//		JButton btnn = new JButton("101");
//		btnn.setVerticalTextPosition(JButton.BOTTOM);  
//		btnn.setHorizontalTextPosition(JButton.CENTER);
//		btnn.setIcon(new ImageIcon("¿ÕÏÐ.jpg"));
//		GridBagConstraints gbc_btnn = new GridBagConstraints();
//		gbc_btnn.insets = new Insets(20, 30, 0, 5);
//		gbc_btnn.gridx = 2;
//		gbc_btnn.gridy = 2;
//		p1.add(btnn, gbc_btnn);
//		
//		JButton button_6 = new JButton("102");
//		button_6.setVerticalTextPosition(JButton.BOTTOM);  
//		button_6.setHorizontalTextPosition(JButton.CENTER);
//		button_6.setIcon(new ImageIcon("ÒÑ±»Ô¤¶©.jpg"));
//		GridBagConstraints gbc_button_6 = new GridBagConstraints();
//		gbc_button_6.insets = new Insets(20, 40, 0, 5);
//		gbc_button_6.gridx = 6;
//		gbc_button_6.gridy = 2;
//		p1.add(button_6, gbc_button_6);
//		
//	
//		


		
		JButton button_2 = new JButton("°ìÀíÈë×¡");
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button_2.setBounds(414, 52, 123, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("°ìÀíÍË·¿");
		button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button_3.setBounds(571, 54, 123, 29);
		contentPane.add(button_3);
		
		JButton btnNewButton = new JButton("ÐÞ¸Ä·¿¼ä");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnNewButton.setBounds(726, 54, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton button_4 = new JButton("»Øµ½Ê×Ò³");
		button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		button_4.setBounds(881, 54, 123, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("É¾³ý·¿¼ä");
		button_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_5.setBounds(430, 733, 123, 29);
		contentPane.add(button_5);
		
		JButton button_11 = new JButton("ÐÞ¸Ä·¿¼ä×´Ì¬");
		button_11.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_11.setBounds(598, 733, 165, 29);
		contentPane.add(button_11);
		
		JButton button_12=new JButton("ÐÂÔö×¡·¿");
		button_12.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		button_12.setBounds(808,733,123,29);
		contentPane.add(button_12);
		
	}
}
