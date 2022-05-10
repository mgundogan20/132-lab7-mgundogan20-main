package inlab;

public class Book {

	// Instance variables:
	// name
	// authorName
	// yearPublished
	private String name;
	private String authorName;
	private int yearPublished;
	
	
	
	// Methods:
	// Constructor
	public Book(String name, String authorName, int yearPublished) {
		this.name = name;
		this.authorName = authorName;
		this.yearPublished = yearPublished;
	}
	
	// toString
	public String toString() {
		String str = String.format("Book Name: %s%nAuthor Name: %s%nYear Published: %s", name, authorName, yearPublished);
		return str;
	}
}
