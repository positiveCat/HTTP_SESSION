package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
            ) {

        var id = loginRequest.getId();
        var pwd = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if (userDto.getPassword().equals(pwd)) {
                //세션에 정보 저장
                httpSession.setAttribute("USER",userDto);

            } else {
                throw new RuntimeException("Password Not Match");
            }

        } else {
            throw new RuntimeException("User Not Found");
        }

    }
}
