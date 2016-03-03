package main;

import java.util.Comparator;

public class SortBySizeAsc implements Comparator<Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		int size1 = dog1.getSizeInt();
		int size2 = dog2.getSizeInt();
		
		return (size1>=size2)? 1: -1;
	}
	
}
