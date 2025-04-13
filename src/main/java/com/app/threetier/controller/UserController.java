package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.NoticeVO;
import com.app.threetier.domain.UserVO;
import com.app.threetier.mapper.UserMapper;
import com.app.threetier.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/user/*")
@Slf4j
@RequiredArgsConstructor

public class UserController {

    private final UserMapper userMapper;
    private final HttpSession session;
    private final UserService userService;

    //    로그인
    @GetMapping("join")
    public void goToJoin(UserVO userVO) {;}

    @PostMapping("join")
    public RedirectView join(UserVO userVO) {
        userService.joinUser(userVO);
        return new RedirectView("/user/login");
    }

    @GetMapping("login")
    public void goToLogin(UserVO userVO) {;}

    @PostMapping("login")
    public RedirectView login(UserVO userVO, RedirectAttributes redirectAttributes) {
        Optional<UserVO> foundUser = userMapper.select(userVO);
        if(foundUser.isPresent()) {
            session.setAttribute("user", foundUser.get());
            session.setAttribute("notice", new NoticeVO());
            return new RedirectView("/notice/list");

        }
        redirectAttributes.addFlashAttribute("login", false);
        return new RedirectView("/user/login");
    }

    @GetMapping("logout")
    public RedirectView logout() {
        session.invalidate();
        return new RedirectView("/user/login");
    }

    @GetMapping("withdraw")
    public RedirectView withdraw() {
        userService.withdraw(((UserVO)session.getAttribute("user")).getId());
        return new RedirectView("/user/login");
    }


}

