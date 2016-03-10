package main;

public class Point{
	
	public Point(int x, int y){
		this.x = x; this.y=y;
	}
	private int x;
	private int y;
	
	//setters
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//getters
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
