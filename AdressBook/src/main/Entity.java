/*
 * This is a phone book entity
 * */

package main;

public class Entity {
	//Class variables:
	
	String countryCode;
	
	String name;
	String phoneNumber;
	Address address;
	
	public Entity(String name, String phoneNumber, String countryCode, String postalCode, String street, String house) {
		this.name = name; this.phoneNumber = phoneNumber;
		address = new Address(countryCode, postalCode, street, house);
	}

	class Address{
		String data[];
		
		private Address(String country, String postalCode, String street, String house){
			data = new String[4];
			data[0] = postalCode; data[1] = street; data[2] = house; data[3] = country;
		}
	}
	
	public void printName(){
		System.out.println("Name: " +this.name);
	}
	
	public void printPhone(){
		String phoneFormat = "%s (%s) %s-%s-%s";
		int inds[] = {0, 1, 4, 7, 9};
		for (Country c: CountryFormat.countries){
			if (c.getCode().compareTo(this.address.data[3])==0){
				phoneFormat = c.getPhoneMask();
				inds =c.getPhoneSubIndexes();
				break;
			}
		}
		
		System.out.println(PhoneConverter.convert(phoneFormat, this.phoneNumber, inds));
						
	}
	
	public void printAddress(){
		String countryFormat = "0123";
		
		for (Country c: CountryFormat.countries){
			if (c.getCode().compareTo(this.address.data[3])==0){
				countryFormat = c.getAddressFormat();
				break;
			}
		}
		
		int arg1 = Integer.parseInt(countryFormat.substring(0, 1));
		int arg2 = Integer.parseInt(countryFormat.substring(1, 2));
		int arg3 = Integer.parseInt(countryFormat.substring(2, 3));
		int arg4 = Integer.parseInt(countryFormat.substring(3, 4));
		
		System.out.println(CountryFormat.fields[arg1]+this.address.data[arg1]);
		System.out.println(CountryFormat.fields[arg2]+this.address.data[arg2]);
		System.out.println(CountryFormat.fields[arg3]+this.address.data[arg3]);
		System.out.println(CountryFormat.fields[arg4]+this.address.data[arg4]);
		
	}
	
	public String getCode(){
		return this.countryCode;
	}
	
}
