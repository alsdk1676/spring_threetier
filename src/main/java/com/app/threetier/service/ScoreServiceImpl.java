package com.app.threetier.service;

import com.app.threetier.domain.ScoreVO;
import com.app.threetier.dto.ScoreDTO;
import com.app.threetier.mapper.ScoreMapper;
import com.app.threetier.repository.ScoreDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.app.threetier.domain.ScoreVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ScoreServiceImpl implements ScoreService {

    private final ScoreMapper scoreMapper;
    private final ScoreDTO scoreDTO;
    private final ScoreVO scoreVO;
    private final ScoreDAO scoreDAO;

    //    점수 등록
    @Override
    public void write(ScoreVO scoreVO) {
        scoreMapper.insert(scoreVO);
    }

//    점수 전체 조회
    @Override
    public List<ScoreDTO> getScoreList() {
        return scoreMapper.selectAll();
    };

//    점수 단일 조회
    @Override
    public Optional<ScoreDTO> getScoreById(Long id) {
        return scoreMapper.select(id);
    }



}
