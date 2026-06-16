package project;
import java.util.*;

interface BookIssued
{
	void issuedBook();
	void returnBook();
}
abstract class Library
{
	protected int BookId;
	protected String BookName;
	 
	public Library(int BookId, String BookName)
	{
		this.BookId=BookId;
		this.BookName=BookName;
	}
	abstract void displayDetails();
}
class Book extends Library implements BookIssued
{
	Scanner sc=new Scanner(System.in);
	public Book(int BookId, String BookName) {
		super(BookId, BookName);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void issuedBook() {
		 System.out.print("Enter issued book name: ");
	        String issuedBook = sc.nextLine();
	        System.out.println(issuedBook + " has been issued.");
	}

	@Override
	public void returnBook() {
		  System.out.print("Enter returned book name: ");
	        String returnedBook = sc.nextLine();
	        System.out.println(returnedBook + " has been returned.");
	}

	@Override
	void displayDetails() {
		 System.out.println("\n----- Book Details -----");
	        System.out.println("Book ID   : " + BookId);
	        System.out.println("Book Name : " + BookName);
	}
}
class Member
{
	 private String name;

	    public void addMember(String name) {
	        this.name = name;
	    }

	    public void displayMember() {
	        System.out.println("Member Name : " + name);
	    }
}
 public class LibraryManagement{
	public static void main(String[] args)
	{
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Book ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Book Name: ");
	        String bookName = sc.nextLine();

	        System.out.print("Enter Member Name: ");
	        String memberName = sc.nextLine();

	        Book b = new Book(id, bookName);

	        Member m = new Member();
	        m.addMember(memberName);

	        b.displayDetails();
	        m.displayMember();

	        b.issuedBook();
	        b.returnBook();

	        sc.close();
	}
}
