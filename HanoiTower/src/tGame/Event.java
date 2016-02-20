package tGame;

public class Event {
	
	
	private int from;
	private int to;
	private int count;
	
	public Event(int f, int t, int c){
		from = f; to = t; count = c;
	}
	
	public int getFrom(){
		return from;
	}
	
	public int getTo(){
		return to;
	}
	
	public int getCount(){
		return count;
	}
	
}
