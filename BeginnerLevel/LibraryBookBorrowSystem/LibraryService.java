package LibraryBookBorrowSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibraryService {
    Map<String, Book> bookList = new HashMap<>();
    Map<String, User> userList = new HashMap<>();
    Set<Book> alreadyHaveBooks = new HashSet<>();
    private final int max_allowed_borrowing =3;

    public Book addBook(String bookId, String bookName){
        Book book = new Book(bookId, bookName);
        bookList.put(bookId, book);
        return book;
    }

    public User addUser(String userId, String name){
        User user = new User(userId, name);
        userList.put(userId, user);
        return user;
    }

    public void borrowBook(String bookId, String userId){
        Book book = bookList.get(bookId);
        if(book == null){
            System.out.println(" no book available with this bookId");
        }

        if(book.isBorrowed() == true){
            System.out.println(" Book is already borrowed");
        }

        User user = userList.get(userId);
        if(user == null){
            System.out.println("no user available with this user id");
        }

        if(user.getUserBookList().size() >= max_allowed_borrowing){
            System.out.println("you have already borrowed maximum allowed");
        }

        book.borrow();
        user.borrowBook(bookId);
    }

    public void returnBook(String bookId, String userId){
        Book book = bookList.get(bookId);
        User user = userList.get(userId);

        if(book == null || user == null){
            System.out.println(" not available");
        }

        book.returnBook();
        user.returnBook(bookId);
    }
}
