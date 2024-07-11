package com.huejo.spring100studies.notice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiNoticeGetController {


//    @GetMapping("/api/notice")
//    public String noticeString() {
//        return " 공지사항입니다";
//    }
//
//
//    @GetMapping("/api/notice")
//    public NoticeModel notice() {
//
//        NoticeModel notice = new NoticeModel();
//
//        notice.setId(1);
//        notice.setTitle("제목");
//        notice.setContents("내용");
//        notice.setRegisterDt(LocalDateTime.now());
//
//        return notice;
//    }
//
//
//    @GetMapping("/api/notice")
//    public List<NoticeModel> notices() {
//
//        List<NoticeModel> noticeLists = new ArrayList<>();
//
//        noticeLists.add(NoticeModel.builder()
//                .id(2)
//                .title("title2")
//                .contents("content2")
//                .registerDt(LocalDateTime.now())
//                .build());
//
//        noticeLists.add(NoticeModel.builder()
//                .id(3)
//                .title("title3")
//                .contents("content3")
//                .registerDt(LocalDateTime.now())
//                .build());
//
//        return noticeLists;
//    }
//
//    @GetMapping("/api/notice")
//    public List<NoticeModel> notice4() {
//        List<NoticeModel> noticeList = new ArrayList<>();
//
//        return noticeList;
//    }

    @GetMapping("/api/notice")
    public int notice5() {
        return 10;
    }


}
