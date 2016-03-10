package main;

import org.newdawn.slick.Input;

import graphic.Game;

public class Circle extends BasicObj{

	public Circle(int x, int y, int r){
		this.x= x; this.y=y; this.r = r; this.lX=r;
		this.dY=r;
	}
	
	//vars
	int r;
	
	@Override
	public double square() {
		return (Math.PI*Math.pow(this.r, 2))/4;
	}

	@Override
	public double perimetr() {
		return (Math.PI)*(double)this.r;
	}

	@Override
	public boolean isInside(int px, int py) {
		boolean isIn = false;
		if (r/2>Math.sqrt(Math.pow(px-(this.x+r/2), 2)+(Math.pow(py-(this.y+r/2), 2)))){
			isIn = true;
		}
		return isIn;
	}
	
	public Rectangle boundingBox(){
		Rectangle rect = new Rectangle(0, 0, 0, 0);
		rect.update(this);
		return rect;
	}
	
	public int getRadius(){
		return this.r;
	}

	public void resize(Input input) {
		
		 if (input.isKeyDown(Input.KEY_SUBTRACT)&&this.r>1) {
		        this.r -=1;
		        this.lX = this.r;
		        this.dY = this.r;
		    }
		 
		 if (input.isKeyDown(Input.KEY_ADD)&&this.x<Game.scrX-this.lX-1&&this.y<Game.scrY-this.dY-1) {
		        this.r +=1;
		        this.lX = this.r;
		        this.dY = this.r;
		    }
		
	}

}
