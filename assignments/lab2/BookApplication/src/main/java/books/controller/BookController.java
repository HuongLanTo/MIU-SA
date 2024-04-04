package books.controller;
import books.domain.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<?> addContact(@RequestBody Book book) throws Exception {
        bookService.add(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) throws Exception {
        bookService.update(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) throws Exception {
        Book book = bookService.findByIsbn(isbn);
        if (book == null) {
            return new ResponseEntity<>(("Book with ISBN = " + isbn + " is not available."), HttpStatus.NOT_FOUND);
        }
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.findByIsbn(isbn);
        if (book == null) {
            return new ResponseEntity<>(("Book with ISBN = " + isbn + " is not available."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Collection<Book> books = bookService.findAll();
        return new ResponseEntity<Collection<Book>>(books, HttpStatus.OK);
    }
}