package main;
/*
 * This one specifies country format;
 * "0123" - specifies the order of address attributes
 * int args and string before them specify phone mask for each country
 * */
public class CountryFormat {
	
	public static Country[] countries = {
		new Country("US", "0123", "United States", "%s (%s) %s-%s-%s", 0, 1, 4, 7, 9),
		new Country("BR", "3210", "Brazil", "%s-%s-%s", 0, 5, 9)
	};
	
	public static String[] fields = {
			"Postal code: ", "Street: ", "House: ", "Country: "
	};
}