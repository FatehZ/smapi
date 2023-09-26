package com.ktxdevelopment.gatewayservice.auth.user.model.dto;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import com.ktxdevelopment.siratumustakim.auth.user.model.response.UserLitResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLitDto {
    private String userId;
    private String username;

    public UserLitResponse toResponse() {
        return new UserLitResponse(userId, username);
    }
}
