package com.arantes.payment.application.ports.out;

import com.arantes.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);
}
