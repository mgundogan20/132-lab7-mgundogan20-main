package inlab;

import java.util.Scanner;

import inlab.InvalidBookException;

public class BookStore {
	
	public static void main(String[] args) {
		BookStoreClerk clerk = new BookStoreClerk();
		boolean continueLoop = true;
		
		do {
			try {
				try {
					Book tempBook = clerk.readAndValidateBook();
				
					continueLoop = false;

					System.out.println(tempBook.toString());

					System.out.printf("%nBookStore Registration Program ended");
				}
				catch(NumberFormatException e) {
					throw new InvalidBookException("Invalid yearPublished argument for the book!", e);
				}
			}
			catch(InvalidBookException e) {
				System.out.printf("Cannot create the book instance!%n");
				System.out.println(e);
				System.out.printf("caused by %s%n", e.getCause());
				System.out.printf("Please modify the input arguments%n%n");
			}
		}while(continueLoop);
		
		
		
		
		

	}
}
