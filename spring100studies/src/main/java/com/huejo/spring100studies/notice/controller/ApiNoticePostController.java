package com.huejo.spring100studies.notice.controller;

import com.huejo.spring100studies.notice.entity.Notice;
import com.huejo.spring100studies.notice.exception.DuplicatedNoticeException;
import com.huejo.spring100studies.notice.model.NoticeInput;
import com.huejo.spring100studies.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


//    @PostMapping("/api/notice")
//    public Notice addNotice5(@RequestBody NoticeInput noticeInput) {
//        Notice notice = Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .registerDt(LocalDateTime.now())
//                .hits(0)
//                .likes(0)
//                .build();
//
//        Notice resultNotice = noticeRepository.save(notice);
//        return resultNotice;
//    }


//    @PostMapping("/api/notice")
//    public void postNotice(@RequestBody NoticeInput noticeInput) {
//        Notice notice = Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .hits(0)
//                .likes(0)
//                .registerDt(LocalDateTime.now())
//                .build();
//
//        noticeRepository.save(notice);
//    }


//    //     입력받은 값에 대한 유효성 검사
//    @PostMapping("/api/notice")
//    public ResponseEntity<Object> addNotice(@RequestBody @Valid NoticeInput noticeInput,
//                                            Errors errors) {
//        // 필수입력 조건있을 때
//
//        //DTO에 NotBlank어노테이션 없고 RequestBody에 Valid 어노테이션 없을 떄
////        if (noticeInput.getTitle() == null
////                || noticeInput.getTitle().length() < 1
////                || noticeInput.getContents() == null
////                || noticeInput.getContents().length() < 1) {
////            return new ResponseEntity<>("입력값이 정확하지 않습니다.", HttpStatus.BAD_REQUEST);
////        }
//        if(errors.hasErrors()) {
//
//            List<ResponseError>  responseErrors = new ArrayList<>();
//
//            errors.getAllErrors().stream().forEach(e -> {
//                responseErrors.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);
//        }
//
//        noticeRepository.save(Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .hits(0)
//                .likes(0)
//                .registerDt(LocalDateTime.now())
//                .build());
//
//        return ResponseEntity.ok().build();
//    }


//    @PostMapping("/api/novice")
//    public ResponseEntity<Object> post(@RequestBody @Valid NoticeInput noticeInput
//            , Errors errors) {
//
//        if(errors.hasErrors()) {
//
//            List<ResponseError>  responseErrors = new ArrayList<>();
//
//            errors.getAllErrors().stream().forEach(e -> {
//                responseErrors.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);
//        }
//
//        noticeRepository.save(Notice.builder()
//                .title(noticeInput.getTitle())
//                .contents(noticeInput.getContents())
//                .hits(0)
//                .likes(0)
//                .registerDt(LocalDateTime.now())
//                .build());
//
//        return ResponseEntity.ok().build();
//    }

    @ExceptionHandler(DuplicatedNoticeException.class)
    public ResponseEntity<?> handlerDuplicatedNoticeException(DuplicatedNoticeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    //1분 이내 동일한 제목, 내용의 글이 작성될 경우 중복등록 막기
    @PostMapping("/api/notice")
    public void addNotice(@RequestBody NoticeInput noticeInput) {

        // 1분 미만 체크
        LocalDateTime checkDate = LocalDateTime.now().minusMinutes(1);

        // 제목, 내용 동일 체크
        int noticeCount = noticeRepository.countByTitleAndContentsAndRegisterDtIsGreaterThanEqual(
                noticeInput.getTitle(),
                noticeInput.getContents(),
                checkDate);
        if (noticeCount > 0) {
                throw new DuplicatedNoticeException("1분 이내에 작성한 동일한 공지가 이미 존재합니다.");
        }
        noticeRepository.save(Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .hits(0)
                .likes(0)
                .registerDt(LocalDateTime.now())
                .build());
    }
}