package main;

import java.util.Scanner;

import tools.Timer;


public class Measure {
	
	private int arr[];
	private int value;
	private int count;
	private Scanner s;
	
	
	public void go(){
		
		//Generates new array
		System.out.println("Specify number of elements in array:");
		this.count=this.inputCount();
		Generator arrGen = new Generator(count);
		arr = arrGen.getArray();
		
		//Prints array:
		System.out.println("Here is your array:");
		this.printArr(arr);
		
		//Puts value to search
		System.out.println("Specify value u'r looking for:");
		this.value = inputValue();
		Search search = new Search();
		
		
		Timer timer = new Timer();
		
		//Measure search one by one search:
		
		timer.startTimer();
		System.out.println("One by one returns: " + search.searchOneByOne(this.value, this.arr));
		timer.stopTimer();
		timer.printData("One by one search");
		
		System.out.println();
		//Measure search by binary:
		
		System.out.println("Binary returns: " + search.searchBinSel(this.value, this.arr));
		
	}
	
	private void printArr(int arr[]){
		System.out.print("( ");
		int str = 0;
		for (int i = 0; i<arr.length; i++){
			if (str<20) {
				System.out.print(arr[i] + " ");
				str += 1;
			} else {
				System.out.println(arr[i]);
				str = 0;
			}
		}
		System.out.println(")");
	}
	
	private int inputValue(){
		
		int value = 0;

		boolean isPutted = false;
		this.s = new Scanner(System.in);
				while (isPutted == false){
				try{
					value = Integer.parseInt(s.nextLine());
					if (value < 0 || value >=10000){
						System.out.println("Only numbers btw 0 and 9999 are generated for the arr. It make no sense to search for " + value + ". Please, try again.");
						isPutted = false;
					} else {
						isPutted = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("Inputted data is incorrect, please try again");
						isPutted = false;
					}
				}
				
		return value;
	}
	
private int inputCount(){
		
		int count = 0;

		boolean isPutted = false;
		this.s = new Scanner(System.in);
				while (isPutted == false){
				try{
					count = Integer.parseInt(s.nextLine());
					if (count <= 0){
						System.out.println("Only positive integer number is required. Please try again.");
						isPutted = false;
					} else {
						isPutted = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("Inputted data is incorrect, please try again");
						isPutted = false;
					}
				}
				
		return count;
	}
		
}

