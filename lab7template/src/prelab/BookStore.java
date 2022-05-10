package prelab;

import java.util.Scanner;

public class BookStore {
	
	public static void main(String[] args) {
		BookStoreClerk clerk = new BookStoreClerk();
		boolean continueLoop = true;
		
		do {
			try {
				Book tempBook = clerk.readAndValidateBook();
				
				continueLoop = false;

				System.out.println(tempBook.toString());

				System.out.printf("%nBookStore Registration Program ended");
			}
			catch(NumberFormatException e) {
				System.out.printf("Cannot create the book instance!%n");
				System.err.println(e);
				System.out.printf("Please modify the input yearPublished argument%n%n");
			}
			catch(IllegalArgumentException e) {
				System.out.printf("Cannot create the book instance!%n");
				System.err.println(e);
				System.out.printf("Please modify the input arguments%n%n");
			}
		}while(continueLoop);
		
		
		
		
		

	}
}
