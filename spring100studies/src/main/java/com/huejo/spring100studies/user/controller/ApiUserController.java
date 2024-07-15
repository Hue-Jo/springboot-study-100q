package com.huejo.spring100studies.user.controller;

import com.huejo.spring100studies.notice.model.ResponseError;
import com.huejo.spring100studies.user.entity.User;
import com.huejo.spring100studies.user.exception.UserNotFoundException;
import com.huejo.spring100studies.user.model.UserInput;
import com.huejo.spring100studies.user.model.UserUpdate;
import com.huejo.spring100studies.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiUserController {

    private final UserRepository userRepository;

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

    @PostMapping("/api/user")
    public ResponseEntity<?> adduser(@RequestBody @Valid UserInput userInput, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();
        if(errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .email(userInput.getEmail())
                .userName(userInput.getUserName())
                .password(userInput.getPassword())
                .phone(userInput.getPhone())
                .regDt(LocalDateTime.now())
                .build();
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<?> userUpdate(@PathVariable Long id, @RequestBody @Valid UserUpdate userUpdate, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();

        if(errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError) e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

        user.setPhone(userUpdate.getPhone());
        user.setUpdateDt(LocalDateTime.now());
        userRepository.save(user);
        return ResponseEntity.ok().build();

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundExceptionHandler(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
