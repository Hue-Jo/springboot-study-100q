package com.huejo.spring100studies.user.model;

import com.huejo.spring100studies.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private long id;
    private String email;
    private String userName;
    private String phone;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.phone = user.getPhone();
    }

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .phone(user.getPhone())
                .build();
    }
}
