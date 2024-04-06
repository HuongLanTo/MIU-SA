package books.data;

import books.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);

}
