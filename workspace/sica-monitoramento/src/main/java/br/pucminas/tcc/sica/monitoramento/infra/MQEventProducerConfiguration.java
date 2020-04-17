package br.pucminas.tcc.sica.monitoramento.infra;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class MQEventProducerConfiguration {

    @Bean
    public Exchange eventExchange(@Value("${sica.mq.exchange.barragem}") String barragemExchangeName) {
        return new TopicExchange(barragemExchangeName);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
