package main;

import tools.Timer;

public class ArrayGo {
	
	private int arr[];
	private int arrIns[];
	private int arrSel[];
	
	public void go(int count){
		Generator arrGen = new Generator(count);
		
		//Generates new array using Generator class and outputs it to d console
		arr = arrGen.getArray();
		arrIns = arr.clone();
		arrSel = arr.clone();
		
		if (count ==10){ //to verify sort works correctly;
			System.out.println("Here is an array to sort:");
			this.printArr(arr);
			System.out.println();
		}
		
		//Sort starts here
		
		Sort sort = new Sort();
		Timer timer = new Timer();
		
		//Insertion

		timer.startTimer();
		sort.insertionSort(arrIns);
		timer.stopTimer();
		
		
		if (count ==10){
			System.out.println("Here is the array sorted by insertion:");
			this.printArr(arrIns);
			} else {
				timer.printData("Sort by Insertion", count);
			}
		
		
		//Bubble
		
		timer.startTimer();
		sort.bubbleSort(this.arr);
		timer.stopTimer();
				
		if (count ==10){
			System.out.println("Here is the array sorted by bubles:");
			this.printArr(arr);
			} else {
				timer.printData("Sort by Bubble", count);
			}
		
		//Selection
				
		timer.startTimer();
		sort.selectionSort(arrSel);
		timer.stopTimer();
		
		
		if (count ==10){
			System.out.println("Here is the array sorted by selection:");
			this.printArr(arrSel);
			} else {
				timer.printData("Sort by Selection", count);
			}
		System.out.println("__________________________________________________________________");//to separate results for diff counts
		System.out.println();
	}
	

	
	public void printArr(int arr[]){
		System.out.print("( ");
		for (int i = 0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println(")");
	}
		
}

