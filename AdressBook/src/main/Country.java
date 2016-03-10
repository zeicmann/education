/*
 * This one is for country entities. Required for locale specific format
 * */

package main;

public class Country{
	private String code;
	private String addressFormat;
	private String name;
	private String mask;
	private int[] inds;
	
	
	public Country(String code, String address, String name, String mask, int ... args){
		this.code = code; this.addressFormat = address;
		this.name = name; this.mask = mask;
		int j = 0;
		inds = new int[args.length];
		for (int i: args){
			inds[j] = i;
			j++;
		}
		
	}
	public String getCode(){
		return this.code;
	}
	
	public String getAddressFormat(){
		return this.addressFormat;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhoneMask(){
		return this.mask;
	}
	
	public int[] getPhoneSubIndexes(){
		return this.inds;
	}
}
