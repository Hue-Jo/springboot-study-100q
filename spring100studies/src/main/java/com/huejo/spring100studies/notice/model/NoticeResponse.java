package com.huejo.spring100studies.notice.model;

import com.huejo.spring100studies.notice.entity.Notice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeResponse {

    private long id;
    private long regUserId;
    private String regUserName;

    private String title;
    private String contents;

    private LocalDateTime registerDt;
    private LocalDateTime updateDt;

    private int hits;
    private int likes;

    public static NoticeResponse of(Notice notice) {
        return NoticeResponse.builder()
                .id(notice.getId())
                .title(notice.getTitle())
                .contents(notice.getContents())
                .registerDt(notice.getRegisterDt())
                .regUserId(notice.getUser().getId())
                .regUserName(notice.getUser().getUserName())
                .updateDt(notice.getUpdateDt())
                .hits(notice.getHits())
                .likes(notice.getLikes())
                .build();
    }
}
