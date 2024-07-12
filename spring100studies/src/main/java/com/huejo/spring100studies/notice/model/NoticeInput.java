package com.huejo.spring100studies.notice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeInput {

    @Size(min = 10, max = 100, message = "제목은 10-100자로 작성하십시오")
    @NotBlank(message = "제목은 필수항목입니다.")
    private String title;

    @Size(min = 5, max = 1000, message = "내용은 5-1000자 사이로 입력하십시오")
    @NotBlank(message = "내용은 필수항목입니다.")
    private String contents;
}
