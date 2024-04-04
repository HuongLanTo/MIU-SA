package books.integration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventListener {
    @EventListener
    public void handleBookEvent(BookEvent event) {
        System.out.println(event.getBook() + " : " + event.getAction());
    }
}
