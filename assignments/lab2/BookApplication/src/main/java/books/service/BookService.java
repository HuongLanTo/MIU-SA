package books.service;

import books.domain.Book;
import books.integration.BookEvent;
import books.integration.BookMessage;
import books.integration.JmsSender;
import books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JmsSender jmsSender;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void add(Book book) throws Exception {
        bookRepository.save(book);
        jmsSender.sendJmsMessage(new BookMessage("added", book));
        applicationEventPublisher.publishEvent(new BookEvent("added", book));
    }
    public void update(Book book) throws Exception {
        bookRepository.save(book);
        jmsSender.sendJmsMessage(new BookMessage("updated", book));
    }
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    public void delete(String isbn) throws Exception {
        Book book = bookRepository.findByIsbn(isbn);
        jmsSender.sendJmsMessage(new BookMessage("deleted", book));
        applicationEventPublisher.publishEvent(new BookEvent("deleted", book));
        bookRepository.delete(isbn);
    }
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }
}
