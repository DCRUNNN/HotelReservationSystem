package presentation.personnelui.WebSalerMainUi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/**
 * ����һ��Բ�εİ�ťʱ����Ҫ�������£� ��һ����������һ���ʵ��Ļ滭�����Ի���һ��Բ�Ρ�
 * �ڶ�����������һЩ�¼�ʹ��ֻ�е�����Բ�ΰ�ť�ķ�Χ�е�ʱ�ť�Ż�������Ӧ
 */
public class CircleButton extends JButton {
 
    public CircleButton(String label) {
        super(label);
 
        // ��ȡ��ť����Ѵ�С
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
 
        setContentAreaFilled(false);
    }
 
    // ��Բ�İ�ť�ı����ͱ�ǩ
    protected void paintComponent(Graphics g) {
 
        if (getModel().isArmed()) {
            g.setColor(Color.RED); // ���ʱ����
        } else {
            g.setColor(getBackground());
        }
        // fillOval������һ�����ε�������Բ��������������Բ��
        // ������Ϊ������ʱ����������Բ����Բ
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
        super.paintComponent(g);
    }
 
    // �ü򵥵Ļ�����ť�ı߽硣
    protected void paintBorder(Graphics g) {
        g.setColor(Color.white);
        // drawOval���������ε�������Բ��������䡣ֻ����һ���߽�
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
 
    // shape�������ڱ��水ť����״�����������������ť�¼�
    Shape shape;
 
    public boolean contains(int x, int y) {
 
        if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
            // ����һ����Բ�ζ���
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        // �ж�����x��y�����Ƿ����ڰ�ť��״�ڡ�
        return shape.contains(x, y);
    }
 
    public static void main(String[] args) {
        JButton button = new CircleButton("");
        button.setBackground(Color.orange);
 
        JFrame frame = new JFrame("Բ�ΰ�ť");
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
}