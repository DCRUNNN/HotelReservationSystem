package presentation.clientUI_order;

import java.awt.event.MouseAdapter;  
import java.awt.event.MouseMotionListener;  
import java.awt.Color;
import java.awt.Component;  
import java.awt.Point;  
import java.awt.event.MouseEvent;  
import javax.swing.BorderFactory;  
import javax.swing.JFrame;  
import javax.swing.border.BevelBorder;  
  
public class EasyMove extends MouseAdapter implements MouseMotionListener {  
    private Point offset;  
    private Component host;  
  
    public static void main(String[] args) {  
        JFrame frm = new client_order();  
        frm.setBackground(Color.blue);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
        frm.getRootPane().setBorder(  
                BorderFactory.createBevelBorder(BevelBorder.RAISED));  
        new EasyMove().install(frm);
        frm.setVisible(true);  
    }  
  
    public synchronized void install(Component comp) {  
        uninstall();  
        host = comp;  
        host.addMouseListener(this);  
        host.addMouseMotionListener(this);  
    }  
  
    public synchronized void uninstall() {  
        if (host != null) {  
            host.removeMouseListener(this);  
            host.removeMouseMotionListener(this);  
            host = null;  
        }  
    }  
  
    public void mousePressed(MouseEvent e) {  
        if (e.getSource() == host)  
            offset = e.getPoint();  
    }  
  
    public void mouseDragged(MouseEvent e) {  
        if (e.getSource() != host)  
            return;  
        final int x = host.getX();  
        final int y = host.getY();  
        final Point lastAt = e.getPoint();  
        host.setLocation(x + lastAt.x - offset.x, y + lastAt.y - offset.y);  
    }  
  
    public void mouseMoved(MouseEvent e) {  
  
    }  
}  