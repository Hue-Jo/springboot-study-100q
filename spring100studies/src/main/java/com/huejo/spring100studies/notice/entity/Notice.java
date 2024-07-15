package com.huejo.spring100studies.notice.entity;

import com.huejo.spring100studies.user.entity.User;
import lombok.*;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn
    private User user;

    private String title;
    private String contents;
    private LocalDateTime registerDt;
    private LocalDateTime updateDt;

    private int hits;
    private int likes;

    private boolean deleted;
    private LocalDateTime deletedDt;
}
