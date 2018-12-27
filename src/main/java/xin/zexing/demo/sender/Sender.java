package xin.zexing.demo.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.zexing.demo.bean.Message;

/**
 * Created by czx on 2018/12/25.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue","hello,rabbit~");
    }

    public void sendMessage(Message message) {
        template.convertAndSend("exchange","topic.message",message);
    }

    public void sendMessageMatch(Message message) {
        template.convertAndSend("exchange","topic.33221",message);
    }

    public void sendMessages(Message message) {
        template.convertAndSend("exchange","topic.messages",message);
    }

    public void sendFanoutMessage(Message message) {
        template.convertAndSend("fanoutExchange","",message);
    }
}
