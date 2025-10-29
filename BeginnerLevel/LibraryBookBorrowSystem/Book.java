package LibraryBookBorrowSystem;

public class Book {
    private final String bookId;
    private final String bookName;
    private boolean isBorrowed;

    public Book(String bookid, String bookName){
        this.bookId = bookid;
        this.bookName = bookName;
        this.isBorrowed = false;
    }

    public String getbookId(){
        return bookId;
    }
    
    public String getBookName(){
        return bookName;
    }

    public boolean isBorrowed(){
        return isBorrowed;
    }

    public void borrow(){
        isBorrowed = true;
    }

    public void returnBook(){
        isBorrowed = false;
    }
}
