public class ComplexNum{
	private final double real;
	private final double imaginary;
	
	public ComplexNum(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public ComplexNum(){
		this.real = 0;
		this.imaginary = 0;
	}
	
	public ComplexNum add(ComplexNum other){
		double realPart = this.real + other.real;
		double imPart = this.imaginary + other.imaginary;
		
		return new ComplexNum(realPart, imPart);
	}
	
	public ComplexNum sub(ComplexNum other){
		double realPart = this.real - other.real;
		double imPart = this.imaginary - other.imaginary;
		
		return new ComplexNum(realPart, imPart);
	}
	
	public ComplexNum mult(ComplexNum other){
		double realPart = this.real * other.real;
		realPart += (-1 * (this.imaginary * other.imaginary));
		
		double imPart = this.imaginary * other.real;
		imPart += other.imaginary * this.real;
		
		return new ComplexNum(realPart, imPart);
	}
	
	private double sinh(double theta) {
		return (Math.exp(theta)-Math.exp(-theta))/2;
    }
	
	private double cosh(double theta) {
		return (Math.exp(theta)+Math.exp(-theta))/2;
    }
	
	public ComplexNum sin() {
		return new ComplexNum(cosh(imaginary)*Math.sin(real),
							sinh(imaginary)*Math.cos(real));
    }
	
	public ComplexNum cos() {
		return new ComplexNum(cosh(imaginary)*Math.cos(real),
							-sinh(imaginary)*Math.sin(real));
    }
	
	public ComplexNum getConjugate(){
		return new ComplexNum(this.real, (-1 * this.imaginary));
	}
	
	public ComplexNum div(ComplexNum other){
		ComplexNum conj = other.getConjugate();
		
		ComplexNum numerator = this.mult(conj);
		ComplexNum denominator = other.mult(conj);
		
		return new ComplexNum((numerator.real / denominator.real),
								(numerator.imaginary / denominator.real));
	}
	
	public double getReal(){ return this.real; }
	public double getImaginary(){ return this.imaginary; }
	
	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		
		if((this.real - (int) this.real) == 0){
			sb.append((int)this.real);
		}
		else{
			sb.append(this.real);
		}
		sb.append((this.imaginary < 0) ? " - " : " + ");
		if((this.imaginary - (int)this.imaginary) == 0){
			sb.append((int)Math.abs(this.imaginary));
		}
		else{
			sb.append(Math.abs(this.imaginary));
		}
		sb.append("i");
		
		return sb.toString();
	}
	
	
	public static void main(String[] args){
		ComplexNum x = new ComplexNum(5, 0);
		ComplexNum y = new ComplexNum(4, 2);
		
		System.out.println(x.div(y));
	}
}