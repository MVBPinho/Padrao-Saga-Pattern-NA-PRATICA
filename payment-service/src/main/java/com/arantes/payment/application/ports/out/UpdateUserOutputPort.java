package com.arantes.payment.application.ports.out;

import com.arantes.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}
