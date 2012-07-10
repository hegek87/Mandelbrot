import java.awt.Color;
import java.util.Random;

public class ComplexColor{
	private final Color c;
	private final ComplexNum cn;
	private static final Random rand = new Random();
	
	public ComplexColor(ComplexNum cn, Color c){
		this.c = c;
		this.cn = cn;
	}
	
	public ComplexColor(ComplexNum cn, int num){
		Color c;
		if(num == -1){
			c = Color.BLACK;
		}
		else{
			c = new Color(Math.abs(num - 253), Math.abs(num - 253), Math.abs(112 - num));
		}
		this.cn = cn;
		this.c = c;
	}
	
	public Color getColor(){ return c; }
	public ComplexNum getNum(){ return cn; }
}