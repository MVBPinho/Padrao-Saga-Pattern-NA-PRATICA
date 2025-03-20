package com.arantes.payment.application.ports.in;

import com.arantes.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(Integer userId);
}
