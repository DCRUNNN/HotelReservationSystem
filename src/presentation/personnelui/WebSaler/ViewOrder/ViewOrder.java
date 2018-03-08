package presentation.personnelui.WebSaler.ViewOrder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import presentation.personnelui.BackgroundPanel;
import presentation.personnelui.WebSaler.CreditRecharge.CreditRecharge;
import presentation.personnelui.WebSaler.ManageWebStrategy.ManageWebStrategy;
import presentation.personnelui.WebSalerMainUi.CircleButton;
import presentation.personnelui.WebSalerMainUi.WebSalerMainUi;
import runner.WebSalerRunner;
import vo.OrderVO;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
public class ViewOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultTableModel tablemodel;
	private presentation.personnelui.controller.ViewOrderUiController controller;
	private JLabel titleLbl;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrder frame = new ViewOrder();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ViewOrder(){
		new WebSalerRunner();
		this.controller=new presentation.personnelui.controller.ViewOrderUiController();
		this.setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image background1=new ImageIcon("background3.jpg").getImage();
		Image background2=new ImageIcon("webManager.jpg").getImage();
		JPanel backgroundPanel=new BackgroundPanel(background1);
		backgroundPanel.setBounds(0,0,1280,800);
		contentPane.add(backgroundPanel);
		


		//设置关闭键/最小化
		JLabel closeLabel = new JLabel("×");
		closeLabel.setForeground(Color.red);
		closeLabel.setFont(new Font("宋体", Font.BOLD, 25));
		closeLabel.setBounds(1232, 20, 26, 30);
		backgroundPanel.add(closeLabel);
		
		JLabel minLabel=new JLabel("-");
		minLabel.setForeground(Color.WHITE);
		minLabel.setFont(new Font("宋体", Font.BOLD, 25));
		minLabel.setBounds(1191, 20, 26, 30);
		backgroundPanel.add(minLabel);
		
		JButton closeBT = new CircleButton("");
		closeBT.setBackground(new Color(135, 206, 235));
		closeBT.setBounds(1225, 15, 40, 40);
		closeBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		backgroundPanel.add(closeBT);
		
		JButton minBT=new CircleButton("");
		minBT.setBackground(new Color(135, 206, 235));
		minBT.setBounds(1177, 15, 40, 40);
		minBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setExtendedState(ICONIFIED);
			}
		});
		backgroundPanel.add(minBT);
		MouseEventListener mouseListener = new MouseEventListener(this);

		titleLbl = new JLabel();
		titleLbl.setBounds(0, 0, 1130, 36);
		backgroundPanel.add(titleLbl);
		titleLbl.addMouseListener(mouseListener);
		titleLbl.addMouseMotionListener(mouseListener);
		backgroundPanel.setLayout(null);
		
		
		JPanel panel = new BackgroundPanel(background2);
		panel.setBounds(77, 98, 158, 153);
		backgroundPanel.add(panel);
		
		JButton btnNewButton_2=new JButton(new ImageIcon("web_return.jpg"));
		btnNewButton_2.setBounds(980, 674, 165, 50);
		backgroundPanel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrder.this.dispose();
				WebSalerMainUi frame=new WebSalerMainUi();
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton(new ImageIcon("web_checkOrder.jpg"));
		button.setBounds(70, 575, 184, 60);
		backgroundPanel.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ViewOrder frame=new ViewOrder();
				frame.setVisible(true);
			}
		});
		JButton button_2 = new JButton(new ImageIcon("web_creditRecharge.jpg"));
		button_2.setBounds(70, 384, 184, 60);
		backgroundPanel.add(button_2);
		
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CreditRecharge frame=new CreditRecharge();
				frame.setVisible(true);
			}
		});
		JButton button_3 = new JButton(new ImageIcon("web_manageWebStrategy.jpg"));
		button_3.setBounds(70, 476, 184, 60);
		backgroundPanel.add(button_3);
		
		button_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ManageWebStrategy frame=new ManageWebStrategy();
				frame.setVisible(true);
			}
		});
		
		JLabel welcomeLabel = new JLabel("欢迎你！");
		welcomeLabel.setBounds(106, 285, 158, 84);
		welcomeLabel.setFont(new Font("方正兰亭超细黑简体",Font.BOLD,30));
		backgroundPanel.add(welcomeLabel);
		
		JLabel label = new JLabel("查看订单");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("方正兰亭超细黑简体", Font.BOLD, 30));
		label.setBounds(430, 29, 343, 84);
		backgroundPanel.add(label);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("订单号");
		columnNames.add("客户id");
		columnNames.add("预定时间");
		columnNames.add("订单状态");
		columnNames.add("房间号");
		columnNames.add("房间类型");
		Vector<Vector<String>> rowData=null;
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		
		rowData = controller.getAllAbnormalOrders(); //得到异常订单
		
		rowData.addAll(controller.getAllUnexecutedOrders()); //加上未执行订单
		
		tablemodel=new DefaultTableModel(rowData, columnNames);
		JTable friends=new JTable(tablemodel);
		//JTable friends = new JTable (rowData, columnNames);  
		JTableHeader tableHeader = friends.getTableHeader(); 
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
		friends.setFont(new Font("华文行楷",Font.PLAIN,20));
		friends.getTableHeader().setFont(new Font("方正兰亭超细黑简体",Font.PLAIN,18));
		friends.setBorder(null);
		friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//设置表格的大小  
		friends.setRowHeight (50);//设置每行的高度为20 
		friends.setRowMargin (3);//设置相邻两行单元格的距离
		friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false 
		friends.setSelectionBackground (Color.lightGray);//设置所选择行的背景色 
		friends.setSelectionForeground (Color.black);//设置所选择行的前景色 
		friends.setGridColor (Color.black);//设置网格线的颜色 
		friends.setShowGrid (true);//是否显示网格线  
		friends.setShowHorizontalLines (true);//是否显示水平的网格线
		friends.setShowVerticalLines (true);//是否显示垂直的网格线  
		friends.doLayout ();  
		friends.setBackground (Color.white); 
		for(int i=0;i<friends.getColumnCount();i++){
			if(i==0){
				friends.getColumnModel().getColumn(i).setPreferredWidth(25);
			}
			else if(i==1){
				friends.getColumnModel().getColumn(i).setPreferredWidth(25);
			}else if(i==2){
				friends.getColumnModel().getColumn(i).setPreferredWidth(80);
			}else if(i==3){
				friends.getColumnModel().getColumn(i).setPreferredWidth(30);
			}else{
				friends.getColumnModel().getColumn(i).setPreferredWidth(50);
			}
		}
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		friends.setDefaultRenderer(Object.class,   r);
		JScrollPane scrollPane = new JScrollPane(friends);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(370, 156, 873, 508);

 		backgroundPanel.add(scrollPane);
 		
		textField = new JTextField();
		textField.setText("输入客户id以搜索异常订单");
		textField.setColumns(10);
		textField.setBounds(806, 108, 344, 29);
		textField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				textField.setText("");
			}
		});
		backgroundPanel.add(textField);
		
		JButton button_1 = new JButton(new ImageIcon("web_search.jpg"));
		button_1.setBounds(1146, 108, 79, 29);
		backgroundPanel.add(button_1);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text=textField.getText().toString();
				Vector<Vector<String>> volist=controller.getAllAbnormalOrders();
				
				Vector<Vector<String>> result=new Vector<Vector<String>>();
				if("".equals(text)||text==null){
					JOptionPane.showMessageDialog(backgroundPanel, "您尚未输入要查询的客户编号！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}else{
					boolean isNum=Pattern.matches("^\\d+$",text);
					boolean checkid=false;
					if(isNum==true){
						for(int i=0;i<volist.size();i++){
							if(!text.equals(volist.get(i).get(1))){
								//result.addAll(controller.getClientAbnormalOrders(text));
								checkid=false;
								break;
							}
						}
						if(checkid==true){
							result.addAll(controller.getClientAbnormalOrders(text));
							friends.setModel(new DefaultTableModel(volist,columnNames));
						}else{
							JOptionPane.showMessageDialog(backgroundPanel, "客户id不存在 或该客户没有异常订单！", "提示",JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(backgroundPanel, "输入格式有误！", "提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		JButton button_4 = new JButton(new ImageIcon("web_detail.jpg"));
		button_4.setBounds(494, 674, 165, 50);
		backgroundPanel.add(button_4);
		button_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int rowindex=friends.getSelectedRow();
				if(rowindex!=-1){
					String orderID=friends.getValueAt(rowindex, 0).toString();
					OrderVO vo=controller.getOrderVO1(orderID);
					ViewOrder.this.dispose();
					ViewOrderDetails frame=new ViewOrderDetails(vo);
					frame.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(backgroundPanel, "您尚未选择要查看的订单！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JButton button_5 = new JButton(new ImageIcon("web_withdraw.jpg"));
		button_5.setBounds(728, 674, 165, 50);
		backgroundPanel.add(button_5);
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=friends.getSelectedRow();
					if(index!=-1){
						String state=friends.getValueAt(index, 3).toString();
						if(!state.equals("异常")){
							JOptionPane.showMessageDialog(backgroundPanel, "您只可以撤销异常订单","",JOptionPane.ERROR_MESSAGE);
							return;
						}
						String orderID=friends.getValueAt(index,0).toString();
						
						boolean q=controller.withdrawAbnormalOrder(orderID);
						if(q==true){
							JOptionPane.showMessageDialog(backgroundPanel, "撤销成功！","结果", JOptionPane.INFORMATION_MESSAGE);
							ViewOrder.this.dispose();
							ViewOrder frame=new ViewOrder();
							frame.setVisible(true);
							
						}else{
							JOptionPane.showMessageDialog(backgroundPanel, "撤销失败！","结果", JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else{
						JOptionPane.showMessageDialog(backgroundPanel, "您尚未选取需要撤销异常的订单！！","结果", JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
	}
}
class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
   ViewOrder frame;
     
    public MouseEventListener(ViewOrder viewOrder) {
      this.frame = viewOrder;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
 
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * 鼠标在标题栏拖拽时，设置窗口的坐标位置
    * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
    */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point p = this.frame.getLocation();
      this.frame.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }
