package prelab;

import java.util.Scanner;

public class BookStoreClerk {
	

	// Partitions the single input String into 3 substrings depending 
	// on the occurrences of '-' char and returns a String[] containing 3 elements:
	// First element is the substring from index 0 to first occurrence of '-' character
	// Second element contains the substring from the first occurrence of '-' character to its second
	// Third element contains the substring from the second occurrence of '-' character to the end of the input
	// In case of not finding enough '-' chars (2 in this case) in the input string, should throw Exception.
	private String[] partitionString(String input) throws IllegalArgumentException
	{
		String[] tokens = new String[3];
		int first = input.indexOf("-");
		int last = input.lastIndexOf("-");
		
		if(first == last) { //both -1 for no hyphens, and some n for a single hyphen
			throw new IllegalArgumentException("Invalid Input to partitionString method: Could not find seperator character '-'");
		}
		for(int i=0; i<input.length() ;i++) {
			if(input.charAt(i) == '-' && i!=first && i!=last) {
				//there is a 3rd hyphen, the input is invalid
				throw new IllegalArgumentException("Invalid Input, too many tokens");
			}
		}
		
		tokens[0] = input.substring(0, first);
		tokens[1] = input.substring(first+1, last);
		tokens[2] = input.substring(last+1);
		

		
		//tokens = input.split("-");
		//for(String element : tokens)
		//	System.out.println(element);
		//if(tokens.length != 3)
		//	throw new IllegalArgumentException("partition");
		return tokens;
	}	
	
	// Reads input bookInfo using a ScannerObject
	// Note that bookInfo should be in desired format, as it is explained in Lab Assignment Document
	// First checks whether input book info is blank or null, throws necessary exceptions
	// Then, calls partitionString method to partition input bookInfo into pieces
	// Saves the partitioned pieces into necessary variables
	// Finally, if all necessary info is valid,i.e., bookName, authorName and yearPublished, creates
	// a new book instance and returns it. If even one of them is invalid, throws Exception
	public Book readAndValidateBook() throws IllegalArgumentException
	{
		int intForDate = 0;
		Scanner scanner = new Scanner(System.in);
		String[] tokens = new String[3];
		
		System.out.print("Enter information for book in required format: ");
		String input = scanner.nextLine();
		if(input.trim().length() <= 0) {
			throw new IllegalArgumentException("Input BookInfo is empty!");
		}
		tokens = partitionString(input);
		intForDate = Integer.parseInt(tokens[2]);
		if(tokens[0].trim().length() <= 0 || tokens[1].trim().length() <= 0)
			throw new IllegalArgumentException("Input BookInfo is invalid!");
		
		return new Book(tokens[0], tokens[1], intForDate);
	}
}
