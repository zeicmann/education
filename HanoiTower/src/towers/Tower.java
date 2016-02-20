package towers;

import tGame.WHS;

public class Tower{
	
	int count;
	int  from = 1; 
	int  buff = 3;
	int  to = 2;
		
	
	public void start(int count, WHS db){
		this.count = count;
		this.updateTows(count, from, buff, to, db);
	}
	
	public void updateTows(int count, int from, int buff, int to, WHS db){
		if (count>0){
			this.updateTows(count-1, from, to, buff, db);
			
			this.moveDisc(from, buff, db);
			
			this.updateTows(count-1, to, buff, from, db);
		}
	}
	
	public void moveDisc(int from, int to, WHS db){
		db.createEvent(from, to, 1);
	}
}