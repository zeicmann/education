package main;

import java.util.Comparator;

public class SortByAgeDesc implements Comparator<Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		int age1 = dog1.getAgeInt();
		int age2 = dog2.getAgeInt();
		
		return (age1>=age2)? -1: 1;
	}
	
}
