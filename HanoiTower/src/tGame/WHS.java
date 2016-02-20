package tGame;

import java.util.ArrayList;

public class WHS {
	
	ArrayList<Event> whs;
	int step;
	
	/*public void testCreateList(){
		whs = new ArrayList<Event>();
		for (int i =0; i <3; i++){
			Event sonic = new Event(1, 3, 2); // from, to, count
			whs.add(sonic);
		}
	}*/
	
	public void initDB(){
		whs = new ArrayList<Event>();
	}
	
	public void createEvent(int from, int to, int count){
		Event sonic = new Event(from, to, count);
		whs.add(sonic);
	}
	
	public Event getById(int id){
		return whs.get(id);
	}
	
	public int getSize(){
		return whs.size();
	}
	
}
