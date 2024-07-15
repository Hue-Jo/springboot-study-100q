package com.huejo.spring100studies.notice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String contents;
    private LocalDateTime registerDt;
    private LocalDateTime updateDt;

    private int hits;
    private int likes;

    private boolean deleted;
    private LocalDateTime deletedDt;
}
