package com.achila.ETLloadservice.service;

import com.achila.ETLloadservice.EtlLoadServiceApplication;
import com.achila.ETLloadservice.model.AlertList;
import com.achila.ETLloadservice.model.AlertMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertSendService {

    private static final Logger log = LoggerFactory.getLogger(AlertSendService.class);

    private  RabbitTemplate rabbitTemplate;

    public AlertSendService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendAlertMessage(AlertList alerts) {
        rabbitTemplate.convertAndSend(EtlLoadServiceApplication.EXCHANGE_NAME, EtlLoadServiceApplication.ROUTING_KEY, alerts);
        log.info("Alert Message sent");
    }
}
