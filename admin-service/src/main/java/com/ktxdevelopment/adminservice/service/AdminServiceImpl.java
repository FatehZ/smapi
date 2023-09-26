package com.ktxdevelopment.siratumustakim.admin.service;

import com.ktxdevelopment.siratumustakim.auth.user.model.Role;
import com.ktxdevelopment.siratumustakim.auth.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void upgradeUserToManager(String userId) {
        var user = userRepository.findByUserId(userId).orElseThrow();
        user.setRole(Role.MANAGER);
        userRepository.save(user);
    }

    @Override
    public void downgradeManagerToUser(String userId) {
        var user = userRepository.findByUserId(userId).orElseThrow();
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Override
    public void banUserAccount(String userId) {
        var user = userRepository.findByUserId(userId).orElseThrow();
        user.setIsBanned(true);
        userRepository.save(user);
    }

    @Override
    public void unbanUserAccount(String userId) {
        var user = userRepository.findByUserId(userId).orElseThrow();
        user.setIsBanned(false);
        userRepository.save(user);
    }
}