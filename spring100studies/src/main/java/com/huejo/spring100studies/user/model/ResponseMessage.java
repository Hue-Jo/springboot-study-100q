package com.huejo.spring100studies.user.model;

import com.huejo.spring100studies.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

    private ResponseMessageHeader header;
    private Object data;

    public static ResponseMessage fail(String message) {

        return ResponseMessage.builder()
                .header(ResponseMessageHeader.builder()
                        .result(false)
                        .resultCode("")
                        .resultMessage(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build())
                .data(null)
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
                .data(data)
                .build();
    }
}
