package books.integration;

import books.domain.Book;

public class BookEvent {
    private final String action;
    private final Book book;

    public BookEvent(String action, Book book) {
        this.action = action;
        this.book = book;
    }

    public String getAction() {
        return action;
    }

    public Book getBook() {
        return book;
    }
}
