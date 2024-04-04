package books.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendJmsMessage(BookMessage bookMessage) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String bookMessageAsString = objectMapper.writeValueAsString(bookMessage);
        jmsTemplate.convertAndSend("bookQueue", bookMessageAsString);
    }
}
