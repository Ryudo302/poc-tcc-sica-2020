package br.pucminas.tcc.sica.seguranca.infra;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class MQEventConsumerConfiguration {

    @Bean
    public Exchange eventExchange(@Value("${sica.mq.exchange.barragem}") String barragemExchangeName) {
        return new TopicExchange(barragemExchangeName);
    }

    @Bean
    public Queue queue(@Value("${sica.mq.queue.barragem}") String barragemQueueName) {
        return new Queue(barragemQueueName);
    }

    @Bean
    public Binding binding(Queue queue, Exchange eventExchange) {
        return BindingBuilder
                .bind(queue)
                .to(eventExchange)
                .with("barragem.*")
                .noargs();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
