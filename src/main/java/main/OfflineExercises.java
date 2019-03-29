package main;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {

		String result = "";
		
		for(int i=0; i < input.length(); i++) {
			
			for(int j=0; j < 3; j++)
				result += input.substring(i, i+1);
		}
		
		return result;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		
		String result = input.toLowerCase();
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i=0; i < result.length()-3; i++) {
			
			if(result.substring(i, i+3).equals("ert")) {

					startIndex = i+3;
					
			}
			if(result.substring(i, i+3).equals("ber")) {

				endIndex = i;
				
			}
		}
		 result = result.substring(startIndex, endIndex);
		
		
		return result;	
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		
		boolean result = false;
		
		int small = 0;
		int medium = 0;
		int large = 0;
		
		//find smallest
		if(a < b && a < c)
			small = a;
		else if (b < a && b < c)
			small = b;
		else 
			small = c;
		
		//find large
		if(a > b && a > c)
			large = a;
		else if (b > a && b > c)
			large = b;
		else 
			large = c;
		
		//find medium
		if((a > b && a < c) || (a < b && a > c))
			medium = a;
		else if((b > a && b < c) || (b < a && b > c))
			medium = b;
		else
			medium = c;
		
//		System.out.println("small: " + small + " medium: " + medium + " large: " + large);
		
		if(large - medium == medium - small)
			result = true;
		
		return result;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		
		String newString = "";
		
		if(a == 1) {
			
			newString = input.substring(0, input.length()/2 ) + 
					input.substring(input.length()/2  + a, input.length());
		}
		else {
			newString = input.substring(0, input.length()/2 -1) + 
					input.substring(input.length()/2 -1 + a, input.length());
		}
		
		return newString;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("jh") → false
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		
		String result = input.toLowerCase();
		boolean isDev = false;
		
		
		if(result.substring(result.length()-3, result.length()).equals("dev")){
			isDev = true;
			System.out.println("true");
		}
		else {
			isDev = false;
			System.out.println("false");
		}
			
		
		return isDev;
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		
		int count = 0;
		int largest = 0;
		
		for(int i = 0; i < input.length() -1; i++) {
			if(input.substring(i, i+1).equals(input.substring(i+1, i+2))) {
				count++;
				if(count > 0 && input.substring(i, i+1) != (input.substring(i+1, i+2))) {
					largest = count;
					count = 0;
				}
			}

		}
		
		return largest;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		
		int count = 0;
		arg1 = " " + arg1;
		arg1 = arg1.toLowerCase();
		
		for(int i=0; i < arg1.length()-4; i++) {
			if(arg1.substring(i, i+4).equals(" am ")) {
				count++;
			}
		}
		
		
		return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		String result = "";
		
		if(arg1 % 3 == 0) {
			result = "fizz";
		}
		
		if(arg1 % 5 == 0) {
			result = "buzz";
		}
		
		if(arg1 % 3 == 0 && arg1 % 5 == 0) {
			result = "fizzbuzz";
		}
		return result;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		
		
		
		return 0;
		
	}
	
	
}
