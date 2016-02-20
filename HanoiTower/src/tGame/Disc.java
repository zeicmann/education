package tGame;

import org.newdawn.slick.Color;

public class Disc {
	private int x;
	private int y;
	final private int w;
	public final static int h = 20;
	private Color col;
	
	//position
	
	private int tow = 1;
	private int ind;
	private int state =3;
	private boolean isActive;
	private boolean changedPos = false;
	
	
	public Disc(int a, int b, Color c, int range, int in){
		x = a; y = b; col = c; w = range * 16; ind = in;
		
	}
	
	public int getW(){
		return w;
	}
	
	public int getH(){
		return h;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Color getCol(){
		return col;
	}
	
	public int getRadius(){
		return this.w;
	}
	
	//moves
	private void moveUp (){
		y -=1;
	}
	
	private void moveDown(){
		y +=1;
	}
	
	private void left(){
		x -=1;
	}
	
	private void right(){
		x +=1;
	}
	
	public void moveTower(int tower, int high, int low){ //first is x coord. need to count it on send
		if (this.state == 0){
			if (y==high){
				this.state =1;				
			}
			this.moveUp();
		}
		
		if (this.state ==1){

			if (x<=tower){
				this.right();
				if (x==tower){
					this.state = 2;
				}
			}
			
			if (x>=tower){
				this.left();
				if (x==tower){
					this.state = 2;
				}
			}
		}
		
		if (this.state == 2){
			if (this.y == low){
				state = 3;
				this.isActive = false;
			}
			this.moveDown();
		}
	}
	
	//data
	public int getInd(){
		return ind;
	}
	
	public int getTow(){
		return tow;
	}
	
	public int getState(){ // 0 - beginning, 1 - is up, 2 - is on right column; 3 - is down and on place
		return state;
	}
	
	public void setInd(int index, int tower){
		this.ind = index;
		this.tow = tower;
		this.changedPos = false;
	}
	
	public boolean getActive(){
		return isActive;
	}
	
	public void setActive(){
		isActive = true;
		state = 0;
		this.changedPos = true;
	}
	
	public boolean getIsChanged(){
		return this.changedPos;
	}
}
