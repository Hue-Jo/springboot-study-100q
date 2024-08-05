package com.huejo.spring100studies.user.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLogCount {
    private long id;
    private String email;
    private String userName;

    private long noticeCount;
    private long noticeLikeCount;
}
