package com.ktxdevelopment.gatewayservice.auth.user.service;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;

public interface UserService {

    User findUserById(String userId);

    User findByUsername(String username);

    User findByEmail(String email);
}
