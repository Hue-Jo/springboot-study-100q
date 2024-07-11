package com.huejo.spring100studies.notice.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeModel {

    private int id;
    private String title;
    private String contents;
    private LocalDateTime registerDt;
}
