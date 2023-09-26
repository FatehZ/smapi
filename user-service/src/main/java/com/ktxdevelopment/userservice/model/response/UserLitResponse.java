package com.ktxdevelopment.userservice.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLitResponse {
    String userId;
    String username;
}
