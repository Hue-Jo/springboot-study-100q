package com.huejo.spring100studies.notice.controller;

import com.huejo.spring100studies.notice.entity.Notice;
import com.huejo.spring100studies.notice.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiNoticeGetController {
    private final NoticeRepository noticeRepository;

    public ApiNoticeGetController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }


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

//    @GetMapping("/api/notice")
//    public int notice5() {
//        return 10;
//    }


    @GetMapping("/api/notice/lastest/{size}")
    public Page<Notice> noticeLatest(@PathVariable int size) {

        Page<Notice> noticeLists =
                noticeRepository.findAll(
                        PageRequest.of(0, size, Sort.Direction.DESC, "registerDt"));

        return noticeLists;
    }


}
