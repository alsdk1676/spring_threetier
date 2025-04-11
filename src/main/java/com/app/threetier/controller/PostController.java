package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {

//    private final PostMapper postMapper;
    private final PostService postService;
    private final HttpSession session;

//    데이터 들고가야함
//    @GetMapping("list")
//    public void goToList(Model model) {
//        model.addAttribute("posts", postMapper.selectAll());
//    }

    @GetMapping("list")
//    public void goToList(Model model) {
//        model.addAttribute("posts", postMapper.selectAll());
//    }
    public void goToList(Model model) {
        model.addAttribute("posts", postService.getList());
    }

    @GetMapping("read")
//    public void goToRead(@RequestParam("id") Long id, Model model) {
//        postService.getPostById(id).ifPresent((post) -> {
//            model.addAttribute("post", post);
//        });
//    }
    public void goToRead(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id).orElseThrow( () -> {
            throw new RuntimeException("Post Not Found");
        }));
    }

    @GetMapping("write")
    public void goToWrite(Model model) {
        model.addAttribute("postVO", new PostVO());
//        *******
//        write.html console.log => 글 작성하려면 memberId 필요 => session에서 가져오기
        model.addAttribute("memberId", ((MemberVO)session.getAttribute("member")).getId());
    }

    @PostMapping("write")
    public RedirectView write(PostVO postVO) {
        postService.write(postVO);
        return new RedirectView("/post/list");
    }

    @GetMapping("edit")
    public void goToEdit(@RequestParam("id") Long id, Model model) {
        Long memberId = ((MemberVO)session.getAttribute("member")).getId();
        PostVO postVO = postService.getPostById(id).orElseThrow(() -> new RuntimeException("postVO Not Found"));
        model.addAttribute("postVO", postVO);
        model.addAttribute("memberId", memberId);
    }

    @PostMapping("edit")
    public RedirectView edit(PostVO postVO) {
        postService.edit(postVO);
        log.info("{}", postVO);
        return new RedirectView("/post/list");
//        return new RedirectView("/post/read?id=" + postVO.getId());
    }

//    삭제하기 버튼을 누를 떄 페이지 이동 => 페이지 요청 => Get 요청
    @GetMapping("remove")
    public RedirectView removePost(@RequestParam("id") Long id) {
        postService.removePost(id);
        return new RedirectView("/post/list");
    }
}
