package books.integration;



import books.domain.Book;

import java.io.Serializable;

public class BookMessage implements Serializable {
    private String action;
    private Book book;

    public BookMessage(String action, Book book) {
        this.action = action;
        this.book = book;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
