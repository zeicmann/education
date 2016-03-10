package main;

import java.util.ArrayList;

public class Start {
	
	ArrayList<Entity> book;
	public Start(){
		book = new ArrayList<Entity>();
	}
	
	public static void main(String[] args){
		Start start = new Start();
		start.createList();
		start.printList();
		
	}
	
	private void createList(){ // list test
		book.add(new Entity("Maney the Sad Panda", "88005553535", "US", "90210", "Street 1", "1"));
		book.add(new Entity("Cookie Monster", "40540566650", "BR", "ZZZ063", "St. Anger", "13"));
		book.add(new Entity("Someone Else", "89510981212", "US", "35004", "Seasame", "1515"));
	}
	
	private void printList(){
		for (Entity e : book){
			e.printName();
			e.printAddress();
			e.printPhone();
			System.out.println();
		}
	}
}
