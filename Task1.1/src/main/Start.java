package main;

public class Start {
		
	private static int little = 10;
	private static int medium = 10000;
	private static int big = 500000;
	
	public static void main (String[] args){
		
		ArrayGo go = new ArrayGo();
		go.go(little);
		go.go(medium);
		go.go(big);

	}

}
