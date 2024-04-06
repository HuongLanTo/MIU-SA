package books.integration;

import books.service.BookModificationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookModificationTracker {


    @EventListener
    public void onEvent(BookModificationEvent event) {
        System.out.println("*************** Book modification event :" + event.getModification()+" "+ event.getBook());;
    }

}
