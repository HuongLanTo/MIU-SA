package books.integration;

import books.service.BookModificationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookPrinter {

    @EventListener
    public void onEvent(BookModificationEvent event) {
        System.out.println("***************  Book event :" + event.getModification()+" "+ event.getBook());;
    }

}
