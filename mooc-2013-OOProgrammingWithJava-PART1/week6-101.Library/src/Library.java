/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> libraryBooks;
    
    public Library() {
        libraryBooks = new ArrayList<Book>();
    }
    
    public void addBook(Book newBook) {
        libraryBooks.add(newBook);
    }
    
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book i : libraryBooks) {
            if(StringUtils.included(i.title(), title)) {
                found.add(i);
            }
        }
        return found;
    }
    
    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book i : libraryBooks) {
            if(StringUtils.included(i.publisher(), publisher)) {
                found.add(i);
            }
        }
        return found;
    }
    
    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book i : libraryBooks) {
            if(i.year() == year) {
                found.add(i);
            }
        }
        return found;
    }
            
    public void printBooks() {
        for(Book i : libraryBooks) {
            System.out.println(i);
        }
    }
}
