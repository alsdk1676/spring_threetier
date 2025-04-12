package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
@Slf4j
@RequiredArgsConstructor

public class UserController {

    private final UserMapper userMapper;
    private final HttpSession session;

//    로그인
//    @GetMapping("join")
//    @PostMapping("join")
}
