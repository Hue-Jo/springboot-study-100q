package com.huejo.spring100studies.notice.controller;

import com.huejo.spring100studies.notice.entity.Notice;
import com.huejo.spring100studies.notice.exception.NoticeNotFoundException;
import com.huejo.spring100studies.notice.model.NoticeInput;
import com.huejo.spring100studies.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ApiNoticePutController {

    private final NoticeRepository noticeRepository;

//    @GetMapping("/api/notice/{id}")
//    public Notice notice1(@PathVariable Long id) {
//
//        Optional<Notice> notice = noticeRepository.findById(id);
//        if (notice.isPresent()) {
//            return notice.get();
//        }
//        return null;
//    }
//
//    @PutMapping("/api/notice/{id}")
//    public void updateNotice(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {
//
//        Optional<Notice> notice = noticeRepository.findById(id);
//        if(notice.isPresent()) {
//            notice.get().setTitle(noticeInput.getTitle());
//            notice.get().setContents(noticeInput.getContents());
//            notice.get().setUpdateDt(LocalDateTime.now());
//            noticeRepository.save(notice.get());
//        }
//
//    }


    @ExceptionHandler(NoticeNotFoundException.class)
    public ResponseEntity<String> handlerNoticeNotFoundException(NoticeNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/api/notice/{id}")
    public void updateNotice2(@PathVariable Long id, @RequestBody NoticeInput noticeInput) {

//        Optional<Notice> notice = noticeRepository.findById(id);
//
//        if (!notice.isPresent()) {
//            throw new NoticeNotFoundException("해당하는 글이 없습니다.");
//        }
//        notice.get().setTitle(noticeInput.getTitle());
//        notice.get().setContents(noticeInput.getContents());
//        notice.get().setUpdateDt(LocalDateTime.now());
//        noticeRepository.save(notice.get());

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("해당 글이 존재하지 않습니다."));

        notice.setTitle(noticeInput.getTitle());
        notice.setContents(noticeInput.getContents());
        notice.setUpdateDt(LocalDateTime.now());
        noticeRepository.save(notice);
    }

    @PatchMapping("/api/notices/{id}/hits") // 부분갱신은 패치
    public void updateNotice4(@PathVariable Long id) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new NoticeNotFoundException("해당 글이 존재하지 않습니다."));
        notice.setHits(notice.getHits() + 1);

        noticeRepository.save(notice);
    }
}

