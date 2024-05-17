package com.everton.producer.services;

import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static constants.RabbitMQConstants.EXCHANGE_NAME_MARKETPLACE;
import static constants.RabbitMQConstants.ROUTING_KEY_PRODUCT_LOG;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO productDTO) {
        log.info("Enviando mensagem para o Exchange " + productDTO.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG, productDTO);
    }

}
