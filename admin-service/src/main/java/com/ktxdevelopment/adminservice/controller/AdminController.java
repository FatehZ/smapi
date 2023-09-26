package com.ktxdevelopment.siratumustakim.admin.controller;


import com.ktxdevelopment.siratumustakim.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/upgrade/{id}")
    private ResponseEntity<String> giveManagerRoleToUser(@PathVariable String id) {
        adminService.upgradeUserToManager(id);
        return ResponseEntity.ok("Added successfully");
    }

    @PostMapping("/downgrade/{id}")
    private ResponseEntity<String> takeAuthorityFromManager(@PathVariable String id) {
        adminService.downgradeManagerToUser(id);
        return ResponseEntity.ok("Taken away successfully");
    }

    @PostMapping("/ban/{id}")
    private ResponseEntity<String> banUserAccount(@PathVariable String id) {
        adminService.banUserAccount(id);
        return ResponseEntity.ok("Banned successfully");
    }

    @PostMapping("/unban/{id}")
    private ResponseEntity<String> unbanUserAccount(@PathVariable String id) {
        adminService.unbanUserAccount(id);
        return ResponseEntity.ok("Unbanned successfully");
    }

}