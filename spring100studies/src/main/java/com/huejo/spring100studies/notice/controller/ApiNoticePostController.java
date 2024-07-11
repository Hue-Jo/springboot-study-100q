package com.huejo.spring100studies.notice.controller;

import com.huejo.spring100studies.entity.Notice;
import com.huejo.spring100studies.notice.model.NoticeInput;
import com.huejo.spring100studies.notice.model.NoticeModel;
import com.huejo.spring100studies.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ApiNoticePostController {

    private final NoticeRepository noticeRepository;

//    @PostMapping("/api/notice-post")
//    public NoticeModel addNotice(String title, String contents) {
//        NoticeModel notice = NoticeModel.builder()
//                .id(1)
//                .title(title)
//                .contents(contents)
//                .registerDt(LocalDateTime.now())
//                .build();
//        return notice;
//    }

//    @PostMapping("/api/notice")
//    public NoticeModel addNotice2(NoticeModel noticeModel){
//        noticeModel.setId(2);
//        noticeModel.setRegisterDt(LocalDateTime.now());
//
//        return noticeModel;
//    }

//    @PostMapping("/api/notice")
//    public NoticeModel addNotice3(@RequestBody NoticeModel noticeModel) {
//        noticeModel.setId(3);
//        noticeModel.setRegisterDt(LocalDateTime.now());
//        return noticeModel;
//    }

//    @PostMapping("/api/notice")
//    public Notice addNotice4(@RequestBody NoticeInput noticeInput) {
//        Notice notice = Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .registerDt(LocalDateTime.now())
//                .build();
//
//        noticeRepository.save(notice);
//        return notice;
//    }

    @PostMapping("/api/notice")
    public Notice addNotice5(@RequestBody NoticeInput noticeInput) {
        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .registerDt(LocalDateTime.now())
                .hits(0)
                .likes(0)
                .build();

        Notice resultNotice = noticeRepository.save(notice);
        return resultNotice;
    }

}
