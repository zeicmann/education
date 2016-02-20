package main;

public class Generator {
	
	private int arr[];
	
	//this generates array which could be returned
	
	public Generator(int count){
		this.generateArray(count);
	}
	
	public void generateArray(int count){
		arr = new int[count];
		for (int i = 0; i<this.arr.length;i++){
			this.arr[i] = (int)(Math.random()*10000);
		}
	}
	
	public int[] getArray(){
		return this.arr;
	}
	
}
