package com.everton.producer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME_MARKETPLACE = "marketplace.direct";
    public static final String QUEUE_NAME_PRODUCT_LOG = "product.log";
    public static final String ROUTING_KEY_PRODUCT_LOG = "product.log";


    @Bean
    public Queue queue() {

        return new Queue(QUEUE_NAME_PRODUCT_LOG, false, false, false);
    }


    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue()) // defino qual é a queue
                .to(directExchange()) // defino qual é a exchange
                .with(ROUTING_KEY_PRODUCT_LOG);
    }

}
