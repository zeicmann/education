package main;

import org.newdawn.slick.Input;

import graphic.Game;

public abstract class BasicObj {
	
	//
	int x;
	int y;
	int lX;
	int dY;
	
	//getters
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	
	abstract public double square();
	abstract public double perimetr();
	abstract public boolean isInside(int px, int py);
	
	public void move(Input input){
		
	    if (input.isKeyDown(Input.KEY_LEFT)&&this.x>0) {
	        this.x -=1;
	    }
	    
	    if (input.isKeyDown(Input.KEY_RIGHT)&& this.x<Game.scrX-this.lX-1) {
	        this.x +=1;
	    }
	    
	    if (input.isKeyDown(Input.KEY_UP)&&this.y>0) {
	        this.y -=1;
	    }
	    
	    if (input.isKeyDown(Input.KEY_DOWN) && this.y<Game.scrY-this.dY-1) {
	        this.y +=1;
	    }
	}


	
}
