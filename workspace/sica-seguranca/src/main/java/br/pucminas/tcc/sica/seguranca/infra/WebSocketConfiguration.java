package br.pucminas.tcc.sica.seguranca.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.*;

@Component
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    public static final String MESSAGE_PREFIX = "/topic";

    @Value("${sica.websocket.stomp.endpoint}")
    private String stompEndpoint;
    @Value("${sica.websocket.broker.appDestPrefix}")
    private String brokerAppDestPrefix;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(stompEndpoint).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(MESSAGE_PREFIX);
        registry.setApplicationDestinationPrefixes(brokerAppDestPrefix);
    }
}
