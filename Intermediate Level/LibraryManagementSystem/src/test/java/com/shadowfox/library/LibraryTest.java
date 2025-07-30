package com.shadowfox.library;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest 
{
    @Test
    public void testAddBook() 
    {
        Library lib = new Library();
        Book book = new Book(1, "Java", "John Doe");
        lib.addBook(book);
        assertEquals(1, lib.getAllBooks().size());
    }

    @Test
    public void testSearchBookFound() 
    {
        Library lib = new Library();
        Book book = new Book(2, "DSA", "Alice");
        lib.addBook(book);
        assertNotNull(lib.searchBookById(2));
    }

    @Test
    public void testSearchBookNotFound() 
    {
        Library lib = new Library();
        assertNull(lib.searchBookById(99));
    }

    @Test
    public void testRemoveBook() 
    {
        Library lib = new Library();
        Book book = new Book(3, "Networks", "Bob");
        lib.addBook(book);
        lib.removeBook(3);
        assertNull(lib.searchBookById(3));
    }
}
