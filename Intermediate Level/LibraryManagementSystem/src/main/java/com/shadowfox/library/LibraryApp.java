package com.shadowfox.library;

import java.util.List;
import java.util.Scanner;

public class LibraryApp 
{
    public static void main(String[] args) 
    {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        int choice;
        do 
        {
            System.out.println("\n📚 Library Management Menu");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    List<Book> allBooks = library.getAllBooks();
                    if (allBooks.isEmpty()) 
                    {
                    System.out.println("No books found in the library.");
                    } 
                    else 
                    {
                    for (Book book : allBooks) 
                    {
                    System.out.println(book);
                    }
                    }
                      break;


                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int delId = sc.nextInt();
                    library.deleteBook(delId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}