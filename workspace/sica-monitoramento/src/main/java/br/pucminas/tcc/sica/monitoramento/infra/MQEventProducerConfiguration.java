package br.pucminas.tcc.sica.monitoramento.infra;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.*;

@Configuration
public class MQEventProducerConfiguration {

    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("barragemExchange");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
