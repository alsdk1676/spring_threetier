package com.app.threetier.controller;

import com.app.threetier.domain.CompanyVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.StudentVO;
import com.app.threetier.service.CompanyService;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
//@RequestMapping("/product/*")
@RequiredArgsConstructor
public class TaskController {

    private final ProductService productService;
    private final StudentService studentService;
    private final CompanyService companyService;

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

//    ==================================================================
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

//    ===================================================================
//    3번 실습
    @GetMapping("/company/check-in")
    public void goToCheckInForm(CompanyVO companyVO) {;}

    @GetMapping("/company/get-to-work")
    public void goToGetToWork() {;}

    @GetMapping("/company/leave-work")
    public void goToLeaveWork() {;}

    @GetMapping("/company/late")
    public void goToLate() {;}

    @GetMapping("/company/work")
    public void goToWork() {;}

//    페이지에 도착했을 떄 : 버튼 이미 누른 상태 (버튼을 누른 뒤 서버로 POST 요청이 들어온 상태)
//    "출근 버튼을 눌렀을 때 서버로 요청이 들어와 실행되는 로직"
//    출근 버튼 클릭 후 출근/퇴근 처리하는 메서드
    @PostMapping("/company/check-in")
//    화면에서 어떻게 보낼지 고민 X => 여기서 만들어놓고 화면에서 이렇게 보내라!
//    flag : 출근인지 퇴근인지 구분하는 구분점 ("getToWork"이면 퇴근)
    public RedirectView checkIn(CompanyVO companyVO, String flag) { // CompanyVO : 출근/퇴근 시간 정보를 담는 객체
        LocalDateTime now = LocalDateTime.now(); // now() : 현재 시간의 시, 분, 초

//        자바는 HH가 24, 오라클에서는 HH24가 24 /  MI, mm
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("{}", format);
//        현재 시간이 일하고 있는 시간인지 아닌지
        int hours = now.getHour();
        int minutes = now.getMinute();

//        지각 (9시 이후)
        boolean lateCondition = hours >= 9 && minutes > 0;
//        퇴근 (17시 이후에 퇴근 가능)
        boolean leaveWorkCondition = hours >= 17 && minutes >= 0;

//        경우 비교
//        화면에서 받는 flag가 ~..
//        출근
        if(!flag.equals("getToWork")) {
            companyVO.setGetToWorkDateTime(format); // 출근 시간 기록
            companyService.register(companyVO); // 현재 시간 찍힘(DB에 저장)
            log.info("{}", companyVO); // 횡단

//            출근 시간 비교해서 초과하면 지각, 아니면 정시 출근
//            초과 ? 지각 : 정시출근
            return new RedirectView(lateCondition ? "/company/late" : "/company/get-to-work");
        }
//        퇴근 (if문 밖)
        companyVO.setLeaveWorkDateTime(format); // 퇴근 시간 기록
        log.info("{}", companyVO); // 횡단
        companyService.register(companyVO); // 현재 시간 찍힘(DB에 저장)

//        퇴근 시간이면 ? 퇴근 : 땡떙이
//        퇴근 시간 조건에 따라 퇴근 or 땡땡이로 이동!
        return new RedirectView(leaveWorkCondition ? "/company/leave-work" : "/company/work");

    }



}
