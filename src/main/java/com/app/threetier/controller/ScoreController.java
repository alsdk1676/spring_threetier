package com.app.threetier.controller;

import com.app.threetier.domain.ScoreVO;
import com.app.threetier.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/score/*")
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("register")
    public void goToRegister(ScoreVO scoreVO) {;}

    @PostMapping("register")
    public RedirectView register(ScoreVO scoreVO) {
        scoreService.write(scoreVO);
        return new RedirectView("/score/result");
    }

    @GetMapping("result")
    public void goToResult(ScoreVO scoreVO, Model model) {
        model.addAttribute("scores", scoreVO);
        scoreService.getScoreList();
    }

}
