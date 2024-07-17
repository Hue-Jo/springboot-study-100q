package com.huejo.spring100studies.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageHeader {


    private boolean result;
    private String resultCode;
    private String resultMessage;
    private int status;
}
