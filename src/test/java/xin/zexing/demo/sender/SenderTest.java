package xin.zexing.demo.sender;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xin.zexing.demo.DemoApplicationTests;
import xin.zexing.demo.bean.Message;

import static org.junit.Assert.*;

/**
 * Created by czx on 2018/12/25.
 */
public class SenderTest extends DemoApplicationTests {
    @Test
    public void sendMessageMatch() throws Exception {
        Message message = new Message();
        message.setName("czx*");
        message.setYear("1994");
        sender.sendMessage(message);
    }

    @Autowired
    private Sender sender;

    @Test
    public void send() throws Exception {
        sender.send();
    }

    @Test
    public void sendMessage() throws Exception {
        Message message = new Message();
        message.setName("czx");
        message.setYear("1994");
        sender.sendMessage(message);
    }

    @Test
    public void sendMessages() throws Exception {
        Message message = new Message();
        message.setName("czx");
        message.setYear("1994");
        sender.sendMessages(message);
    }

    @Test
    public void sendFanoutMessage() throws Exception {
        Message message = new Message();
        message.setName("fanout");
        message.setYear("1994");
        sender.sendFanoutMessage(message);
    }
}