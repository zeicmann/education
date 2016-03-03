package main;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		return dog2.getName().compareTo(dog1.getName());
	}

}
