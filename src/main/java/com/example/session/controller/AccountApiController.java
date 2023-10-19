package com.example.session.controller;

import com.example.session.model.LoginRequest;
import com.example.session.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor //생성자를 자동으로 생성해주는 역할. 클래스 내의 final 필드나 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 자동으로 만들어주어 코드를 간결하게 작성할 수 있도록 도와준다.
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;
    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,
            HttpSession httpSession
    ) {

        userService.login(loginRequest, httpSession);

    }
}
