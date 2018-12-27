package xin.zexing.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by czx on 2018/12/25.
 */
@Configuration
public class SenderConf {
    /**
     * direct
     */
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
    /**
     * topic 模式
     */
    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue("topic.message");
    }
    @Bean(name="message1")
    public Queue queueMessage1() {
        return new Queue("topic.*");
    }
    @Bean(name = "messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    @Bean
    public Binding bindExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    public Binding bindExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
    }
    @Bean
    public Binding bindExchangeMessage2(@Qualifier("message1") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.*");
    }

    /**
     * fanout
     */
    @Bean
    public Queue aMessage() {
        return new Queue("fanout.A");
    }
    @Bean
    public Queue bMessage() {
        return new Queue("fanout.B");
    }
    @Bean
    public Queue cMessage() {
        return new Queue("fanout.C");
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public Binding bindAFanExchange(@Qualifier("aMessage") Queue queueMessages, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueMessages).to(fanoutExchange);
    }
    @Bean
    public Binding bindBFanExchange(@Qualifier("bMessage") Queue queueMessages, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueMessages).to(fanoutExchange);
    }
    @Bean
    public Binding bindCFanExchange(@Qualifier("cMessage") Queue queueMessages, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueMessages).to(fanoutExchange);
    }
}
