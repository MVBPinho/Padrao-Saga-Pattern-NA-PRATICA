package com.arantes.inventory.adapters.out;

import com.arantes.inventory.adapters.out.message.SaleMessage;
import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.out.SendUpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SendUpdatedInventoryAdapter implements SendUpdateInventoryOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
