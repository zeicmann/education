package main;

public class DogTable {
	
	private Dog[] table;
	private int nameLength;
	private int sortedBy;
	/* 0 - not sorted
	 * 1 - sorted by name asc
	 * 2 - sorted by name desc
	 * 3 - sorted by size asc
	 * 4 - sorted by size desc
	 * 5 - sorted by age asc
	 * 6 - sorted by age desc*/
	
	public DogTable(Dog[] arr, int sort){
		this.table = arr;
		this.sortedBy = sort;
		for (int i = 0; i < table.length; i++){ // finds the longest name in order to specify column width
			this.nameLength = (this.table[i].getName().length() > this.nameLength) ? this.table[i].getName().length(): this.nameLength;
		}
	}
	
	public void setInd(int ind){
		this.sortedBy = ind;
	}
	
	public void printTable(){
		
		//Top
		this.tableLine();
		System.out.print("|Name");
		for(int i = 0; i < this.nameLength-3; i++){
			System.out.print(" ");
		}
		switch (this.sortedBy){
		case 1: System.out.print("^");
				break;
		case 2: System.out.print("v");
				break;
		default: System.out.print(" ");
				break;
		}				
		System.out.print("|Size   ");
		switch (this.sortedBy){
		case 3: System.out.print("^");
				break;
		case 4: System.out.print("v");
				break;
		default: System.out.print(" ");
				break;
		}	
		System.out.print("|Age ");
		switch (this.sortedBy){
		case 5: System.out.print("^");
				break;
		case 6: System.out.print("v");
				break;
		default: System.out.print(" ");
				break;
		}	
		System.out.println("|");
		
		this.tableLine();
		
		//data
		for (int i = 0 ; i<this.table.length ; i++){
			
			System.out.print("|"+ table[i].getName()); // Name
			for(int j = 0; j < this.nameLength-table[i].getName().length()+2; j++){
				System.out.print(" ");
			}
			
			System.out.print("|"+table[i].getSize()); // Size
			for(int j = 0; j < 8-table[i].getSize().length(); j++){
				System.out.print(" ");
			}
			
			System.out.print("|"+table[i].getAge()); // Age
			for(int j = 0; j < 5 - table[i].getAge().length(); j++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		
		//bottom
		this.tableLine();

		
	}
	
	public static void cls(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	private void tableLine(){ // draws horizontal line
		
		System.out.print("+");
		for (int i = 0; i < this.nameLength + 2; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 8; i ++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 5; i ++){
			System.out.print("-");
		}
		System.out.println("+");
	}
}
