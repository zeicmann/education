package main;
/*
 * This one converts phone number to required format before printin
 * */


public class PhoneConverter {
	public static String convert(String mask, String number, int ... ind){

		int[] args = new int[ind.length];
		int j=0;
		for (int i: ind){
			args[j] = i;
			j++;
		}
		
		String[] subs = new String[ind.length];
		for (int i = 0; i<subs.length-1; i++){
			subs[i] = number.substring(args[i], args[i+1]);
		}
		subs[subs.length-1] = number.substring(args[args.length-1]);
		
		return String.format(mask, (Object[])subs);
	}
}
