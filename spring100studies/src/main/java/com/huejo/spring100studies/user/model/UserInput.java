package com.huejo.spring100studies.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput {

    @Email(message = "이메일 형식에 맞게 입력해주세요")
    @NotBlank(message = "이메일은 필수 입력항목입니다.")
    private String email;

    @NotBlank(message = "이름은 필수 입력항목입니다.")
    private String userName;

    @Size(min = 8, message = "8자리 이상 입력하십시오")
    @NotBlank(message = "비밀번호는 필수 입력항목입니다.")
    private String password;

    @NotBlank(message = "연락처는 필수입력 항목입니다.")
    @Size(max = 20, message = "20자까지 입력 가능")
    private String phone;

}
