package com.ktxdevelopment.siratumustakim.admin.service;


import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    void upgradeUserToManager(String userId);

    void downgradeManagerToUser(String userId);

    void banUserAccount(String userId);

    void unbanUserAccount(String userId);
}