package com.huejo.spring100studies.notice.controller;

import com.huejo.spring100studies.entity.Notice;
import com.huejo.spring100studies.notice.exception.AlreadyDeletedException;
import com.huejo.spring100studies.notice.exception.NoticeNotFoundException;
import com.huejo.spring100studies.notice.model.NoticeDeleteInput;
import com.huejo.spring100studies.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiNoticeDeleteController {

    private final NoticeRepository noticeRepository;

    @ExceptionHandler(NoticeNotFoundException.class)
    public ResponseEntity<String> handlerNoticeNotFoundException(NoticeNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

    }

//    @DeleteMapping("/api/notice/{id}")
//    public void deleteNotice(@PathVariable Long id) {
//        Notice notice = noticeRepository.findById(id)
//                .orElseThrow(() -> new NoticeNotFoundException("해당하는 글이 존재하지 않습니다."));
//
//        noticeRepository.delete(notice);
//    }

    @ExceptionHandler(AlreadyDeletedException.class)
    public ResponseEntity<String> handlerAlreadyDeletedException(AlreadyDeletedException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);

    }

//    @DeleteMapping("/api/notice/{id}")
//    public void deleteNotice(@PathVariable Long id) {
//
//        Notice notice = noticeRepository.findById(id)
//                .orElseThrow(() -> new NoticeNotFoundException("해당하는 글이 존재하지 않습니다."));
//
//        if (notice.isDeleted()) {
//            throw new AlreadyDeletedException("이미 삭제된 글입니다.");
//        }
//
//        notice.setDeleted(true);
//        notice.setDeletedDt(LocalDateTime.now());
//
//        noticeRepository.save(notice);
//    }

//    @DeleteMapping("/api/notice")  // 여러 개 삭제 (리스트로!)
//    public void deleteNoticeList(@RequestBody NoticeDeleteInput noticeDeleteInput) {  // 물리적 삭제가 아니라 삭제됐다는 플래그 표시!
//
//        List<Notice> noticeList = noticeRepository.findByIdIn(noticeDeleteInput.getIdList())
//                .orElseThrow(() -> new NoticeNotFoundException("해당글이 존재하지 않습니다."));
//
//        noticeList.stream().forEach(e -> {
//            e.setDeleted(true);
//            e.setDeletedDt(LocalDateTime.now());
//        });
//
//        noticeRepository.saveAll(noticeList);
//    }

    @DeleteMapping("/api/notice/all")
    public void deleteAllNotices(){

        noticeRepository.deleteAll();
    }

}
