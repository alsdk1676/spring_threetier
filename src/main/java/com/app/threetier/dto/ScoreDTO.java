package com.app.threetier.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ScoreDTO {
    private Long id;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private int average;
}
