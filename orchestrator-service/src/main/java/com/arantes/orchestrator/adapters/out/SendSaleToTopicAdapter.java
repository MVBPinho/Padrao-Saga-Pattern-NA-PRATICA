package com.arantes.orchestrator.adapters.out;

import com.arantes.orchestrator.adapters.out.message.SaleMessage;
import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.core.domain.enums.SaleEvent;
import com.arantes.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent, String topic) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send(topic, saleMessage);
    }
}
