package com.huejo.spring100studies.board.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult {

    private boolean result;
    private String message;


    public static ServiceResult fail(String message) {

        return ServiceResult.builder()
                .result(false)
                .message(message)
                .build();
    }

    public static ServiceResult success() {

        return ServiceResult.builder()
                .result(true)
                .build();
    }
}
