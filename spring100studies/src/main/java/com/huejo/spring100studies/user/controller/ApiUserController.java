package com.huejo.spring100studies.user.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.huejo.spring100studies.notice.entity.Notice;
import com.huejo.spring100studies.notice.entity.NoticeLike;
import com.huejo.spring100studies.notice.model.NoticeResponse;
import com.huejo.spring100studies.notice.model.ResponseError;
import com.huejo.spring100studies.notice.repository.NoticeLikeRepository;
import com.huejo.spring100studies.notice.repository.NoticeRepository;
import com.huejo.spring100studies.user.entity.User;
import com.huejo.spring100studies.user.exception.ExistsEmailException;
import com.huejo.spring100studies.user.exception.PasswordNotMatchException;
import com.huejo.spring100studies.user.exception.UserNotFoundException;
import com.huejo.spring100studies.user.model.*;
import com.huejo.spring100studies.user.repository.UserRepository;
import com.huejo.spring100studies.util.JWTUtils;
import com.huejo.spring100studies.util.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ApiUserController {

    private final UserRepository userRepository;
    private final NoticeRepository noticeRepository;
    private final NoticeLikeRepository noticeLikeRepository;


//    @PostMapping("/api/user")
//    public ResponseEntity<?> adduser(@RequestBody @Valid UserInput userInput, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//
//        if(errors.hasErrors()) {
//            errors.getAllErrors().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        return ResponseEntity.ok().build();
//    }
//

//    @PostMapping("/api/user")
//    public ResponseEntity<?> adduser(@RequestBody @Valid UserInput userInput, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();

//        if(errors.hasErrors()) {
//            errors.getAllErrors().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        User user = User.builder()
//                .email(userInput.getEmail())
//                .userName(userInput.getUserName())
//                .password(userInput.getPassword())
//                .phone(userInput.getPhone())
//                .regDt(LocalDateTime.now())
//                .build();
//        userRepository.save(user);
//
//        return ResponseEntity.ok().build();
//    }

//
//    @PutMapping("/api/user/{id}")
//    public ResponseEntity<?> userUpdate(@PathVariable Long id, @RequestBody @Valid UserUpdate userUpdate, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//
//        if(errors.hasErrors()) {
//            errors.getAllErrors().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        user.setPhone(userUpdate.getPhone());
//        user.setUpdateDt(LocalDateTime.now());
//        userRepository.save(user);
//        return ResponseEntity.ok().build();
//
//    }
//
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//

//    @GetMapping("/api/user/{id}")
//    public UserResponse getUser(@PathVariable Long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        //UserResponse userResponse = new UserResponse(user);
//        UserResponse userResponse = UserResponse.of(user);
//        return userResponse;
//    }
//
//    @GetMapping("/api/user/{id}/notice")
//    public List<NoticeResponse> userNotice(@PathVariable Long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        List<Notice> noticeList = noticeRepository.findByUser(user);
//        List<NoticeResponse> noticeResponseList = new ArrayList<>();
//
//        noticeList.stream().forEach((e) ->  {
//            noticeResponseList.add(NoticeResponse.of(e));
//        });
//        return noticeResponseList;
//    }


//    @PostMapping("/api/user")
//    public ResponseEntity<?> addUser(@RequestBody @Valid UserInput userInput, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        if (userRepository.countByEmail(userInput.getEmail()) > 0) {
//            throw new ExistsEmailException("이미 가입된 이메일입니다.");
//        }
//
//        User user = User.builder()
//                .email(userInput.getEmail())
//                .userName(userInput.getUserName())
//                .phone(userInput.getPhone())
//                .password(userInput.getPassword())
//                .regDt(LocalDateTime.now())
//                .build();
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok().build();
//
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<?> ExistEmailExceptionHandler(ExistsEmailException existsEmailException) {
//        return new ResponseEntity<>(existsEmailException.getMessage(), HttpStatus.BAD_REQUEST);
//    }


    //    @PatchMapping("/api/user/{id}/password")
//    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody UserInputPassword userInputPassword, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        User user = userRepository.findByIdAndPassword(id, userInputPassword.getPassword())
//                .orElseThrow(() -> new PasswordNotMatchException("비밀번호가 일치하지 않습니다."));
//
//        user.setPassword(userInputPassword.getNewPassword());
//        userRepository.save(user);
//        return ResponseEntity.ok().build();
//    }
//
    @ExceptionHandler(value = {ExistsEmailException.class, PasswordNotMatchException.class})
    public ResponseEntity<?> ExistEmailExceptionHandler(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //
//
    private String getEncryptedPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    @PostMapping("/api/user")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserInput userInput, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        if (userRepository.countByEmail(userInput.getEmail()) > 0) {
            throw new ExistsEmailException("이미 가입된 이메일입니다.");
        }

        String encryptedPassword = getEncryptedPassword(userInput.getPassword());

        User user = User.builder()
                .email(userInput.getEmail())
                .userName(userInput.getUserName())
                .phone(userInput.getPhone())
                .password(encryptedPassword)
                .regDt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        return ResponseEntity.ok().build();

    }

//    @ExceptionHandler
//    public ResponseEntity<?> ExistEmailExceptionHandler(ExistsEmailException existsEmailException) {
//        return new ResponseEntity<>(existsEmailException.getMessage(), HttpStatus.BAD_REQUEST);
//    }


//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @DeleteMapping("/api/user/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        try {
//            userRepository.delete(user);
//        } catch (DataIntegrityViolationException e) {
//            String message = "작성한 게시물이 아직 남아있습니다.";
//            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            String message = "탈퇴 중 문제가 발생했습니다.";
//            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.ok().build();
//    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @GetMapping("/api/user/")
//    public ResponseEntity<UserResponse> findUser(@RequestBody UserInputFind userInputFind) {
//
//        User user = userRepository.findByUserNameAndPhone(userInputFind.getUserName(), userInputFind.getPhone())
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        UserResponse userResponse = UserResponse.of(user);
//
//        return ResponseEntity.ok().body(userResponse);
//    }


    private String getResetPassword() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }
//
//    @GetMapping("/api/user/{id}/password/reset")
//    public ResponseEntity<?> resetUserPassword(@PathVariable("id") Long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        String resetPassword = getResetPassword();
//        String resetEncryptedPassword = getEncryptedPassword(resetPassword);
//        user.setPassword(resetEncryptedPassword);
//        userRepository.save(user);
//
//        String message = String .format("[%s}님의 임시 비밀번호가 [%s]로 초기화되었습니다.",  user.getUserName(), resetPassword);
//        sendSMS(message);
//
//        return ResponseEntity.ok().build();
//
//    }
//    void sendSMS(String message) {
//        System.out.println("[문자 메시지 전송] ");
//        System.out.println(message);
//    }


//    @GetMapping("/api/user/{id}/notice/like")
//    public List<NoticeLike> likeNotice(@PathVariable long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다"));
//
//        List<NoticeLike> noticeLikeList = noticeLikeRepository.findByUser(user);
//        return noticeLikeList;
//    }


    //    @PostMapping("/api/user/login")
//    public ResponseEntity<?> createToken(@RequestBody @Valid UserLogin userLogin, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//
//        if(errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        User user = userRepository.findByEmail(userLogin.getEmail())
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        if (!PasswordUtils.equalPassword(userLogin.getPassword(), user.getPassword())) {
//            throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
//        }
//
//        return ResponseEntity.ok().build();
//    }


//    @PostMapping("/api/user/login")
//    public ResponseEntity<?> createToken(@RequestBody @Valid UserLogin userLogin, Errors errors) {
//
//        List<ResponseError> responseErrorList = new ArrayList<>();
//
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach((e) -> {
//                responseErrorList.add(ResponseError.of((FieldError) e));
//            });
//
//            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
//        }
//
//        User user = userRepository.findByEmail(userLogin.getEmail())
//                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
//
//        if (!PasswordUtils.equalPassword(userLogin.getPassword(), user.getPassword())) {
//            throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
//        }
//
//        //토큰 발행
//        String token = JWT.create()
//                        .withExpiresAt(new Date())
//                        .withClaim("user_id", user.getId())
//                        .withSubject(user.getUserName())
//                        .withIssuer(user.getEmail())
//                        .sign(Algorithm.HMAC512("zerobase".getBytes()));
//
//
//        return ResponseEntity.ok().body(UserLoginToken.builder().token(token).build());
//    }


    @PostMapping("/api/user/login")
    public ResponseEntity<?> createToken(@RequestBody @Valid UserLogin userLogin, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

        if (!PasswordUtils.equalPassword(userLogin.getPassword(), user.getPassword())) {
            throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
        }

        LocalDateTime expiredDateTime = LocalDateTime.now().plusMonths(1);
        Date expiredDate = java.sql.Timestamp.valueOf(expiredDateTime);

        String token = JWT.create()
                .withExpiresAt(expiredDate)
                .withClaim("user_id", user.getId())
                .withSubject(user.getUserName())
                .withIssuer(user.getEmail())
                .sign(Algorithm.HMAC512("zerobase".getBytes()));


        return ResponseEntity.ok().body(UserLoginToken.builder().token(token).build());
    }


    @PatchMapping("/api/user/login")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {

        String token = request.getHeader("Z-TOKEN");

        String email = "";
        try {
            email = JWT.require(Algorithm.HMAC512("zerobase".getBytes()))
                    .build().verify(token).getIssuer();
        } catch (SignatureVerificationException e) {
            throw new PasswordNotMatchException("비밀번호가 일치하지 않습니다.");
        }
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다. "));

        LocalDateTime expiredDateTime = LocalDateTime.now().plusMonths(1);
        Date expiredDate = java.sql.Timestamp.valueOf(expiredDateTime);

        String newToken = JWT.create()
                .withExpiresAt(expiredDate)
                .withClaim("user_id", user.getId())
                .withSubject(user.getUserName())
                .withIssuer(user.getEmail())
                .sign(Algorithm.HMAC512("zerobase".getBytes()));

        return ResponseEntity.ok().body(UserLoginToken.builder().token(newToken).build());
    }


    @DeleteMapping("/api/user/login")
    public ResponseEntity<?> removeToken(@RequestHeader("Z-TOKEN") String token) {

        String email = "";

        try {
            email = JWTUtils.getIssuer(token);
        } catch (SignatureVerificationException e) {
            return new ResponseEntity<>("토큰 정보가 정확하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().build();
    }
}
