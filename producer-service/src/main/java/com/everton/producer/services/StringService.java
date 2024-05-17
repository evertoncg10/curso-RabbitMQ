package com.everton.producer.services;

import com.everton.producer.configs.RabbitMQConfig;
import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.everton.producer.configs.RabbitMQConfig.EXCHANGE_NAME_MARKETPLACE;
import static com.everton.producer.configs.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        ProductDTO product = new ProductDTO();
        log.info("Enviando message: " + message);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, message);
    }
}
