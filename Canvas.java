import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Canvas extends JPanel{
	Mandelbrot mandelbrotSet;//315,300
	
	public static final int SCALE_X = 315;
	public static final int SCALE_Y = 300;
	public static final int OFFSET_X = 700;
	public static final int OFFSET_Y = 350;
	
	public Canvas(){
		super();
		mandelbrotSet = new Mandelbrot();
		mandelbrotSet.generateSet();
	}
	
	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(ComplexColor cn : mandelbrotSet.getSet()){
			g.setColor(cn.getColor());
			int x = (int)((cn.getNum().getReal() * SCALE_X) + OFFSET_X);
			int y = (int)((cn.getNum().getImaginary() * SCALE_Y) + OFFSET_Y);
			g.fillOval(x, y, 2, 2);
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(BorderLayout.CENTER, new Canvas());
		frame.setSize(1000, 600);
		frame.setVisible(true);
		frame.repaint();
	}
}