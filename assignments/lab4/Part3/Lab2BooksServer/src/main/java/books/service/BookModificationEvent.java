package books.service;

import books.domain.Book;

public class BookModificationEvent {
    private String modification;
    private Book book;

    public BookModificationEvent(String modification, Book book) {
        this.modification = modification;
        this.book = book;
    }

    public String getModification() {
        return modification;
    }

    public Book getBook() {
        return book;
    }
}
