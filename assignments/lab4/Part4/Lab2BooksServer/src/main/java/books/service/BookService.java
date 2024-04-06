package books.service;

import books.data.BookRepository;
import books.domain.Book;
import books.integration.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    JmsSender jmsSender;
    @Autowired
    private ApplicationEventPublisher publisher;



    public void add(Book book){
        bookRepository.save(book);
        jmsSender.sendMessage(book);
        publisher.publishEvent(new BookModificationEvent("Add", book));
    }

    public void update(Book book){
        bookRepository.save(book);
    }

    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public void delete(String isbn){
        Book book = bookRepository.findByIsbn(isbn);
        bookRepository.delete(book);
        publisher.publishEvent(new BookModificationEvent("Delete", book));
    }

    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }
}
