package com.app.threetier.service;

import com.app.threetier.domain.ScoreVO;
import com.app.threetier.dto.ScoreDTO;

import java.util.List;
import java.util.Optional;

public interface ScoreService {

//    점수 등록
    public void write(ScoreVO scoreVO);

//    점수 전체 조회
    public List<ScoreDTO> getScoreList();

//    점수 단일 조회
    public Optional<ScoreDTO> getScoreById(Long id);

}
