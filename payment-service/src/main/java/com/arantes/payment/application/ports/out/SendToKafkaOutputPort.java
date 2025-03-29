package com.arantes.payment.application.ports.out;

import com.arantes.payment.application.core.domain.Sale;
import com.arantes.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
