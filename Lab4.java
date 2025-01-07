5) Create a class Book which contains four members: name, author, price, num_pages. Include a
constructor to set the values for the members. Include methods to set and get the details of the
objects. Display the complete details of the book. Develop a Java program to create n book
objects.
NOTE: 1: Use normal display method
2: Use Override toString method
Eg: public String toString() {Write code to display data }


import java.util.Scanner;


class Book {
   private String name;
   private String author;
   private double price;
   private int num_pages;


  


   public void set(String name, String author, double price, int num_pages) {
       this.name = name;
       this.author = author;
       this.price = price;
       this.num_pages = num_pages;
   }


   public static String inputName() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter book name: ");
       return scanner.nextLine();
   }


   public static String inputAuthor() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter author name: ");
       return scanner.nextLine();
   }


   public static double inputPrice() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter price: ");
       return scanner.nextDouble();
   }


   public static int inputNumPages() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter number of pages: ");
       return scanner.nextInt();
   }


   public void displayDetails() {
       System.out.println("Book Name: " + name);
       System.out.println("Author: " + author);
       System.out.println("Price: $" + price);
       System.out.println("Number of Pages: " + num_pages);
       System.out.println("-------------------------");
   }
}


public class BookDetails {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


       System.out.print("Enter the number of books: ");
       int n = scanner.nextInt();
       scanner.nextLine();  // Consume newline


       Book[] books = new Book[n];


       for (int i = 0; i < n; i++) {
           System.out.println("Enter details for book " + (i + 1) + ":");


           String name = Book.inputName();
           String author = Book.inputAuthor();
           double price = Book.inputPrice();
           int num_pages = Book.inputNumPages();


           books[i] = new Book();
           books[i].set(name, author, price, num_pages);
       }


       System.out.println("\nBook Details:");
       for (int i = 0; i < n; i++) {
           books[i].displayDetails();
       }


       scanner.close();
   }
}
