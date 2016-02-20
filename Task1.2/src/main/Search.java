package main;

import tools.Timer;

public class Search {
	
	public boolean searchOneByOne(int value, int[] arr){
		boolean isFound = false;
		
		for (int i = 0; i<arr.length; i++){
			if (arr[i] == value){
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	
	public boolean searchBinSel(int value, int[] arr) {
		boolean isFound = false;
		int[] arrSorted = arr.clone();		
		Sort sort = new Sort();
		float sortTimer;
		float allTimer;
		
		//measure search
		Timer timer = new Timer();
		
		timer.startTimer();
		sort.selectionSort(arrSorted);
		timer.stopTimer();
		timer.printData("Sorting for binary search");
		sortTimer = timer.getSeconds();
		
		timer.startTimer();
		isFound = this.binary(0, arrSorted.length-1, value, arrSorted);	
		timer.stopTimer();
		timer.printData("Binary search");
		allTimer = timer.getSeconds() + sortTimer;
		
		System.out.println("Sorting + search total time: " + allTimer + " seconds.");
		return isFound;
	}
	
	private boolean binary(int min, int max, int value, int[] arr){
		
		boolean isFound = false;
		if (min>max){
			isFound = false;
		} else {
			int mid = (max+min)/2;

			if (arr[mid]==value){
				isFound = true;
			}			
			if (arr[mid]<value){
				isFound = this.binary(mid+1, max, value, arr);
			} 
			if (arr[mid]>value){
				isFound = this.binary(min, mid-1, value, arr);
			}
		}
		return isFound;
	}
}
