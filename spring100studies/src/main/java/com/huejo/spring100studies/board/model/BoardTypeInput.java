package com.huejo.spring100studies.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardTypeInput {

    @NotBlank(message = "게시판 제목은 필수입니다.")
    private String name;
}
