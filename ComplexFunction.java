public interface ComplexFunction{
	void getNext();
	ComplexNum getCurrent();
}

abstract class AbstractComplexFunction implements ComplexFunction{
	private ComplexNum current;
	private ComplexNum constant;
	
	public AbstractComplexFunction(ComplexNum current){
		this.current = new ComplexNum();
		this.constant = current;
	}
	
	@Override public abstract void getNext();
	@Override public ComplexNum getCurrent(){ return current; }
	public ComplexNum getConstant(){ return constant; }
	public void setCurrent(ComplexNum current){ this.current = current; }
}

class MandelbrotFunction extends AbstractComplexFunction{
	
	public MandelbrotFunction(ComplexNum current){
		super(current);
	}
	
	@Override public void getNext(){
		ComplexNum current = super.getCurrent();
		ComplexNum constant = super.getConstant();
		
		current = current.mult(current);
		current = current.add(constant);
		
		super.setCurrent(current);
	}
	
	@Override public ComplexNum getCurrent(){ return super.getCurrent(); }
}

class MBFunction extends AbstractComplexFunction{
	
	public MBFunction(ComplexNum current){
		super(current);
	}
	
	@Override public void getNext(){
		ComplexNum current = super.getCurrent();
		ComplexNum constant = super.getConstant();
		
		current = current.mult(current.mult(current));
		current = current.add(constant);
		
		super.setCurrent(current);
	}
	
	@Override public ComplexNum getCurrent(){ return super.getCurrent(); }
}

class QuadraticComplex extends AbstractComplexFunction{
	
	public QuadraticComplex(ComplexNum current){
		super(current);
	}
	
	@Override public void getNext(){
		ComplexNum current = super.getCurrent();
		ComplexNum constant = super.getConstant();
		ComplexNum temp = current;
		
		current = temp.mult(temp);
		current = current.add(temp);
		current = current.add(constant);
		
		super.setCurrent(current);
	}
	
	@Override public ComplexNum getCurrent(){ return super.getCurrent(); }
}

class DegreeFive extends AbstractComplexFunction{
	
	public DegreeFive(ComplexNum current){
		super(current);
	}
	
	@Override public void getNext(){
		ComplexNum current = super.getCurrent();
		ComplexNum constant = super.getConstant();
		ComplexNum temp = current;
		
		current = temp.mult(temp.mult(temp.mult(temp)));
		current = current.add(temp.mult(temp));
		current = current.add(temp);
		current = current.add(constant.add(constant));
		
		super.setCurrent(current);
	}
	
	@Override public ComplexNum getCurrent(){ return super.getCurrent(); }
}

class SinFunction extends AbstractComplexFunction{
	public SinFunction(ComplexNum current){
		super(current);
	}
	
	@Override public void getNext(){
		ComplexNum current = super.getCurrent();
		ComplexNum constant = super.getConstant();
		current = current.div(constant);
		current = current.sin();
		current = current.add(constant);
		
		super.setCurrent(current);
	}
	
	@Override public ComplexNum getCurrent(){ return super.getCurrent(); }
}