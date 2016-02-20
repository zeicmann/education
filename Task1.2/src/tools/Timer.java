package tools;

public class Timer {
	
	private long startTime;
	private long endTime;
	private float seconds;
	
	//timer to measure speed
	
	public void startTimer(){
		startTime = System.nanoTime();
	}
	
	public void stopTimer(){
		endTime = System.nanoTime();
		this.seconds = ((float)(this.endTime - this.startTime))/1000000000;
	}
	
	public void printData(String processName){
		System.out.println(processName+" took " + this.seconds +" seconds.");
	}
	
	public float getSeconds(){
		return seconds;
	}
}
