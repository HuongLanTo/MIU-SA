package books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;

import java.util.Collection;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/books";

		// add Book1
		restTemplate.postForLocation(serverUrl, new Book("1","John", "How to relax", 100.98));
		// add Book2
		restTemplate.postForLocation(serverUrl, new Book("2","Alex", "Chilling", 99.34));
		// get Book1
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1");
		System.out.println("----------- get Book1 -----------------------");
		System.out.println(book);
        // get all
		Collection<Book> books = restTemplate.getForObject(serverUrl, Collection.class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);

		// delete Book2
		restTemplate.delete(serverUrl+"/{isbn}", "2");

		// update Book1
		book.setTitle("How to study");
		restTemplate.put(serverUrl+"/{isbn}", book, book.getIsbn());

		// get all
		books = restTemplate.getForObject(serverUrl, Collection.class);
		System.out.println("----------- get all books -----------------------");
		System.out.println(books);
	}

}
