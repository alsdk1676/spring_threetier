package com.app.threetier.controller;

import com.app.threetier.domain.BookVO;
import com.app.threetier.service.BookService;
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
@RequiredArgsConstructor
@RequestMapping("/book/*")
public class BookController {

    private final BookService bookService;

//    도서 등록
    @GetMapping("write")
    public void goToWrite(BookVO bookVO) {;}

    @PostMapping("write")
    public RedirectView write(BookVO bookVO) {
        bookService.register(bookVO);
        return new RedirectView("/book/list");
    }

//    도서 전체 조회
    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("books", bookService.getList());
    }

//    도서 단일 조회
    @GetMapping("read")
    public void read(@RequestParam("id") Long id, Model model) {
        model.addAttribute("book", bookService.getById(id).orElseThrow(() -> {
            throw new RuntimeException("Book not found");
        }));
    }

//    도서 수정
    @GetMapping("edit")
    public void goToEdit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        BookVO bookVO = bookService.getById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", bookVO);
    }

    @PostMapping("edit")
    public RedirectView edit(BookVO bookVO) {
        bookService.modify(bookVO);
        return new RedirectView("/book/list");
    }

//    도서 삭제
    @GetMapping("remove")
    public RedirectView remove(@RequestParam("id") Long id) {
        bookService.remove(id);
        return new RedirectView("/book/list");
    }


}
