package com.shadowfox.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Library 
{
    private static final String DB_URL = "jdbc:sqlite:library.db";

    public Library() 
    {
        createTable();
    }

    private void createTable() 
    {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) 
             {
            String sql = "CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY, title TEXT, author TEXT)";
            stmt.executeUpdate(sql);
             } 
        catch (SQLException e) 
        {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public void addBook(Book book) 
    {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO books(id, title, author) VALUES (?, ?, ?)")) 
             {
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.executeUpdate();
            System.out.println("Book added!");
             } 
        catch (SQLException e) 
        {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public ArrayList<Book> getAllBooks() 
    {
        ArrayList<Book> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) 
             {
            while (rs.next()) 
            {
                list.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author")));
            }
             } 
        catch (SQLException e) 
        {
            System.out.println("Error fetching books: " + e.getMessage());
        }
        return list;
    }

    public void deleteBook(int id) 
    {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM books WHERE id = ?")) 
        {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book deleted!");
            else System.out.println("Book not found.");
        } 
        catch (SQLException e) 
        {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}