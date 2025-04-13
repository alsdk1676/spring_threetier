package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.NoticeVO;
import com.app.threetier.domain.UserVO;
import com.app.threetier.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/notice/*")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;
    private final HttpSession session;

    @GetMapping("list")
    public void goToList(Model model) {
        model.addAttribute("notices", noticeService.getListNotice());
    }

    @GetMapping("read")
    public void goToRead(@RequestParam("id") Long id, Model model) {
        model.addAttribute("notice", noticeService.getNoticeById(id).orElseThrow(() -> new RuntimeException("notice Not Found")));
    }

    @GetMapping("write")
    public void goToWrite(Model model) {
        model.addAttribute("noticeVO", new NoticeVO());
        model.addAttribute("userId", ((UserVO)session.getAttribute("user")).getId());
    }

    @PostMapping("write")
    public RedirectView write(NoticeVO noticeVO) {
        noticeService.write(noticeVO);
        return new RedirectView("/notice/list");
    }

    @GetMapping("edit")
    public void goToEdit(@RequestParam("id") Long id, Model model) {
        Long userId = ((NoticeVO)session.getAttribute("notice")).getId();
        NoticeVO noticeVO = noticeService.getNoticeById(id).orElseThrow(() -> new RuntimeException("notice Not Found"));
        model.addAttribute("noticeVO", noticeVO);
        model.addAttribute("userId", userId);
    }

    @PostMapping("edit")
    public RedirectView edit(NoticeVO noticeVO) {
        noticeService.edit(noticeVO);
        return new RedirectView("/notice/list");
    }

    @GetMapping("remove")
    public RedirectView remove(@RequestParam("id") Long id, Model model) {
        noticeService.remove(id);
        return new RedirectView("/notice/list");
    }

}
