package main;

public class Rectangle extends BasicObj{
	
	//Vars

	private int w;
	private int h;
	
	//Cons
	
	public Rectangle(int x, int y, int w, int h){
		this.x = x; this.y = y; this.h = h; this.w = w;
	}
	
	//Methods
	
	@Override
	public double square(){
		return (double)(this.w*this.h);
	}
	
	@Override
	public double perimetr(){
		return (double)(2*(this.w+this.h));
	}
	
	@Override
	public boolean isInside(int px, int py){
		boolean isIn =false;
		if ((px>=this.x&&px<=this.x+this.w)&&(py>=this.y&&py<=this.h+this.y)){
			isIn = true;
		}
		return isIn;
	}
	
	public void update(Circle circle){
		int cxr = (int)(circle.getRadius()/2*(1-Math.sin(Math.toRadians(45))));
		int cyr = (int)(circle.getRadius()/2*(1-Math.cos(Math.toRadians(45))));
		
		this.x = circle.getX()+cxr;
		this.y = circle.getY()+cyr;
		this.w = circle.getRadius()-2*cxr-2;
		this.h = circle.getRadius()-2*cyr-2;
	}
	
	//getters
	
	public int getW(){
		return this.w;
	}
	
	public int getH(){
		return this.h;
	}
	
}
