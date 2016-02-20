package main;

import java.util.Scanner;

public class MinGo {
	
	private float num1;
	private float num2;
	private float num3;
	private float num4;
	private Scanner s;
	
	public void getMinOf4(){
		
		num1 = this.inputNum("1");
		num2 = this.inputNum("2");
		num3 = this.inputNum("3");
		num4 = this.inputNum("4");
		
		System.out.println();
		System.out.println("The smallest number is " + this.minOf4());
	}
	
	private float minOf2(){ // 4.1
		float minNum = (this.num1 < this.num2)? this.num1 : this.num2;
		return minNum;
	}
	
	private float minOf3(){ // 4.2
		float minNum = (this.minOf2()<this.num3) ? this.minOf2(): this.num3;
		return minNum;
	}
	
	private float minOf4(){ // 4.3
		float minNum = (this.minOf3()<this.num4)? this.minOf3(): this.num4;
		return minNum;
	}
		
	private float inputNum(String numS){
		
		float num = 0;

		boolean isPutted = false;
		this.s = new Scanner(System.in);
				while (isPutted == false){
				System.out.println("Please enter " + numS +" number.");
				try{
					num = Float.parseFloat(s.nextLine());
					isPutted = true;
					} catch (NumberFormatException e) {
						System.out.println("Inputted data is incorrect, please try again");
						isPutted = false;
					}
				}
				
		return num;
	}
}
