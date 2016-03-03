package main;

import java.util.Random;

public class Dog {
	private String dogName;
	private int dogSize;
	private int dogAge;
	private Random ran;
	
	public Dog(String name, int size, int age){
		
		this.dogName = name;
		this.dogSize = size;
		this.dogAge = age;
		
		if (this.dogName == null || this.dogSize == 0 || this.dogAge == 0){
			
			this.ran = new Random();
			
			if (this.dogName == null){ // generates name in case if name's not set
				this.dogName = NameGenerator.fPart[ran.nextInt(NameGenerator.fPart.length)] 
						+ NameGenerator.lPart[ran.nextInt(NameGenerator.lPart.length)];
			}
			
			if (this.dogSize == 0){ // generates age if it's not set
				this.dogSize = ran.nextInt(3)+1;
			}
			
			if (this.dogAge == 0){ // sets dogs age 
				this.dogAge = ran.nextInt(20)+1;
			}
		}
	}
	
	public String getSize(){ // Interprets int size as String
		String result;
		switch (this.dogSize){
		case 1: result = "small";
				break;
		case 2: result = "medium";
				break;
		default: result = "big";
				break;
		}
		return result;
	}
	
	public void setName(String name){
		// changes format if input is not correct. Same methods should be generated in case if user needs to change age or size
		this.dogName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}
	
	public String getAge(){
		Integer temp = new Integer(this.dogAge);
		return temp.toString();
	}
	
	public String getName(){
		return this.dogName;
	}
	
	public int getAgeInt(){
		return this.dogAge;
	}
	
	public int getSizeInt(){
		return this.dogSize;
	}
	
	@Override
	public String toString(){ // toString override ----------------------------------------------------------------
		return "Dog name is "+ this.dogName + " it's " + this.getSize() + " sized and " + this.dogAge + " years old.";
	}
	//-----------------------------------------------------------------------------------------------------
		
}
