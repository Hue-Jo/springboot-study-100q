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
public class UserUpdate {


    @NotBlank(message = "연락처는 필수입력 항목입니다.")
    @Size(max = 20, message = "연락처는 최대 20자까지 작성 가능합니다")
    private String phone;

}
