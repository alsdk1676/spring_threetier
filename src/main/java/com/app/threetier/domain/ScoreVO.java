package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ScoreVO {
    private Long id;
    private int kor;
    private int eng;
    private int math;
}
