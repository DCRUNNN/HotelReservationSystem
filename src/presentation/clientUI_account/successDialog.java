package presentation.clientUI_account;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.Cancelable;

import javax.swing.JLabel;

public class successDialog extends JDialog implements ActionListener
{
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			successDialog dialog = new successDialog();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public successDialog()
	{
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400,200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 134, 400, 66);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBounds(157, 13, 95, 40);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 133);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u6210\u529F\uFF01");
		lblNewLabel.setBounds(167, 50, 133, 53);
		panel.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == cancelButton)
		{
			this.dispose();
		}
		// TODO Auto-generated method stub
		
	}
}
