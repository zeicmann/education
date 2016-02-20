package textReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextGo {
	private char nChar;
	private String text;
	private int count = 0;
		
	boolean isPutted = false;
	public void setChar(){
		try (Scanner s = new Scanner(System.in);){	
		while (isPutted == false){
		System.out.println("Input char ur looking for (single char is needed): ");
		String temp = s.nextLine();
		//Check input:
		if (temp.length()==1){
			this.isPutted = true;
			nChar = temp.charAt(0);
		} else System.out.println("You need to put a single char. Please try again.");
		}
		}
	}
	
	public void readText(){
		try {
			text = new String(Files.readAllBytes(Paths.get("TextEx.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void countChar(){
		
		if (text.length() == 0){ //checks if file was empty
			System.out.println("TextEx.txt contains no text. Please put smth in it.");
		} else{
		for (int i = 0; i<this.text.length(); i++){
			if (this.nChar == this.text.charAt(i)){
				this.count +=1;
			}
		}
		System.out.println();
		System.out.println("Here is your text: " + this.text);
		System.out.println();
		if (this.count <2){
			System.out.print("There is "+ this.count + " character \"");
		} else {
			System.out.print("There are "+ this.count+ " characters \"");
		}
		System.out.println(this.nChar+"\".");
	}
	}
}
