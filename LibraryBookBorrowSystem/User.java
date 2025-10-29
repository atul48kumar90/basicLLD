package LibraryBookBorrowSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final String userId;
    private final String name;
    Set<String> borrowedBook = new HashSet<>();

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }
    
    public String getUserid(){
        return userId;
    }
    public String getname(){
        return name;
    }

    public Set<String> getUserBookList(){
        return borrowedBook;
    }

    public void borrowBook(String bookId){
        borrowedBook.add(bookId);
    }

    public void returnBook(String bookId){
        borrowedBook.remove(bookId);
    }
}
