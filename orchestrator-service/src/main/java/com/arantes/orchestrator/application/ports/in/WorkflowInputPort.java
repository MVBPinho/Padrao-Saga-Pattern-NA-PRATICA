package com.arantes.orchestrator.application.ports.in;

import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent event);

}
