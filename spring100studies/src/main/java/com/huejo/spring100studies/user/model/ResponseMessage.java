package com.huejo.spring100studies.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

    private ResponseMessageHeader header;
    private Object body;

    public static ResponseMessage fail(String message) {

        return ResponseMessage.builder()
                .header(ResponseMessageHeader.builder()
                        .result(false)
                        .resultCode("")
                        .resultMessage(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build())
                .body(null)
                .build();

    }

    public static ResponseMessage success(Object data) {
        return ResponseMessage.builder()
                .header(ResponseMessageHeader.builder()
                        .result(true)
                        .resultCode("")
                        .resultMessage("")
                        .status(HttpStatus.OK.value())
                        .build())
                .body(data)
                .build();
    }

    public static ResponseMessage success() {
        return ResponseMessage.builder()
                .header(ResponseMessageHeader.builder()
                        .result(true)
                        .resultCode("")
                        .resultMessage("")
                        .status(HttpStatus.OK.value())
                        .build())
                .body(null)
                .build();
    }
}