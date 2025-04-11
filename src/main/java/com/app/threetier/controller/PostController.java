package com.app.threetier.controller;

import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {

    private final PostMapper postMapper;

//    데이터 들고가야함
    @GetMapping("list")
    public void goToList(Model model) {
        model.addAttribute("posts", postMapper.selectAll());
    }

}
