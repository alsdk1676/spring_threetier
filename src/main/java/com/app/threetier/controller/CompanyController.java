package com.app.threetier.controller;

import com.app.threetier.domain.CompanyVO;
import com.app.threetier.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/company/*")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("check-in")
    public void goToCheckInForm(CompanyVO companyVO) {;}

    @GetMapping("get-to-work")
    public void goToGetToWork() {;}

    @GetMapping("leave-work")
    public void goToLeaveWork() {;}

    @GetMapping("late")
    public void goToLate() {;}

    @GetMapping("work")
    public void goToWork() {;}

    @PostMapping("check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag) {
        LocalDateTime now = LocalDateTime.now();

        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        int hours = now.getHour();
        int minutes = now.getMinute();

        boolean lateCondition = hours >= 9 && minutes > 0;
        boolean leaveWorkCondition = hours >= 17 && minutes >= 0;

        if(!flag.equals("getToWork")) {
            companyVO.setLeaveWorkDateTime(format);
            companyService.register(companyVO);
            log.info("{}", companyVO);

            return new RedirectView(lateCondition ? "/company/late" : "/company/get-to-work");
        }

        companyVO.setLeaveWorkDateTime(format);
        companyService.register(companyVO);

        return new RedirectView(leaveWorkCondition ? "/company/leave-work" : "/company/work");
    }


}
