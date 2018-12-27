package xin.zexing.demo.recieve;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import xin.zexing.demo.bean.Message;

/**
 * Created by czx on 2018/12/25.
 */
@Component
public class Receive {
    /**
     * diract
     */
    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Receive:"+str);
    }

    /**
     * topic
     */
    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void message(Message message) {
        System.out.println("Receive message:"+message);
    }
    @RabbitListener(queues="topic.*")    //监听器监听指定的Queue
    public void message1(Message message) {
        System.out.println("Receive message *:"+message);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void messages(Message message) {
        System.out.println("Receive messages:"+message);
    }


    /**
     * fanout
     */
    @RabbitListener(queues="fanout.A")    //监听器监听指定的Queue
    public void messageA(Message message) {
        System.out.println("Receive A messages:"+message);
    }
    @RabbitListener(queues="fanout.B")    //监听器监听指定的Queue
    public void messageB(Message message) {
        System.out.println("Receive B messages:"+message);
    }
    @RabbitListener(queues="fanout.C")    //监听器监听指定的Queue
    public void messageC(Message message) {
        System.out.println("Receive C messages:"+message);
    }
}
