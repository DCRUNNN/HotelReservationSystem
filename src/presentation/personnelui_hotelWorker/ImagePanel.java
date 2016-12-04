package presentation.personnelui_hotelWorker;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private ImageIcon icon;
	private Image image;

	public ImagePanel(String url){
		icon=new ImageIcon(url);
		image=icon.getImage();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 1, 0, null);
	}
}
