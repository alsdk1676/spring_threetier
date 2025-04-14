package com.app.threetier.controller;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.StudentVO;
import com.app.threetier.service.ProductService;
import com.app.threetier.service.StudentService;
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
//@RequestMapping("/product/*")
@RequiredArgsConstructor
public class TaskController {

    private final ProductService productService;
    private final StudentService studentService;

    //    1번 실습
    @GetMapping("/product/write")
    public void goToWrite(ProductVO productVO) {;}

    //    상품 등록
    @PostMapping("/product/write")
    public RedirectView write(ProductVO productVO) {
        productService.write(productVO);
        return new RedirectView("/product/list");
    }

    //    상품 전체 조회
    @GetMapping("/product/list")
    public void goToList(Model model) {
        model.addAttribute("products", productService.getListProduct());
    }

    //    상품 단일 조회
    @GetMapping("/product/read")
    public void goToRead(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id).orElseThrow(() -> {
            throw new RuntimeException("Product Not Found");
        }));
    }

    //    상품 수정
//    @GetMapping("/product/edit")
    public void goToEdit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        ProductVO productVO = productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        model.addAttribute("product", productVO);
    }

@PostMapping("/product/edit")
    public RedirectView edit(ProductVO productVO) {
        productService.edit(productVO);
        return new RedirectView("/product/list");
    }

    @GetMapping("/product/remove")
    public RedirectView remove(@RequestParam("id") Long id) {
        productService.remove(id);
        return new RedirectView("/product/list");
    }

//    2번 실습
    @GetMapping("/student/register")
    public void goToRegister(StudentVO studentVO) {;}

    @PostMapping("/student/register")
    public RedirectView register(StudentVO studentVO) {
        studentService.register(studentVO);
        return new RedirectView("/student/result");
    }

    @GetMapping("/student/result")
    public void goToResultForm(Model model) {
        model.addAttribute("students", studentService.getStudentList());
    }



}
