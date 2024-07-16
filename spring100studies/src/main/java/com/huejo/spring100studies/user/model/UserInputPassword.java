package com.huejo.spring100studies.user.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInputPassword {

    @NotBlank(message = "현재 비밀번호는 필수항목입니다.")
    private String password;

    @NotBlank(message = "신규 비밀번호는 필수항목입니다.")
    @Size(min = 4, max = 20, message = "4-20자리로 작성하십시오")
    private String newPassword;
}
