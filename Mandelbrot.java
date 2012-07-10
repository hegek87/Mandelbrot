import java.util.Set;
import java.util.HashSet;
import java.awt.Color;

public class Mandelbrot{
	private Set<ComplexColor> set;
	private ComplexFunction cf;
	
	public Mandelbrot(){
		set = new HashSet<ComplexColor>();
	}
	
	private int converges(ComplexNum input){
		int count = 0;
		cf = new MandelbrotFunction(input);
		while(count < 255){
			cf.getNext();			
			if(cf.getCurrent().getReal() > 2 || cf.getCurrent().getImaginary() > 2){
				return count;
			}
			++count;
		}		
		return count;
	}
	
	private Color getIterationColor(int i) {
		//if(i < 255) return new Color(0x00012875*i);
		
		if (i < 255) return new Color(i, i, Math.abs(220-i));
		else return Color.BLACK;
	}
	
	public void generateSet(){
		for(double i = -2; i < 2; i += .003){
			for(double j = -2; j < 0; j+= .003){
				ComplexNum current = new ComplexNum(i, j);
				int col = converges(current);
				Color pixelColor = getIterationColor(col);
				ComplexColor cur = new ComplexColor(current, pixelColor);
				set.add(cur);
				cur = new ComplexColor(cur.getNum().getConjugate(), pixelColor);
				set.add(cur);
			}
		}
	}
	
	public Set<ComplexColor> getSet(){ return set; }
	
	public static void main(String[] args){
		Mandelbrot mb = new Mandelbrot();
		
		mb.generateSet();
		System.out.println(mb.getSet());
	}
}