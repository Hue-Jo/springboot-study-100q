package com.huejo.spring100studies.user.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum UserStatus {

    NONE,
    USING,
    STOP,
    ;

    int value;

}
