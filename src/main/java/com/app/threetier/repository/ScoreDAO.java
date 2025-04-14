package com.app.threetier.repository;

import com.app.threetier.domain.ScoreVO;
import com.app.threetier.dto.ScoreDTO;
import com.app.threetier.mapper.ScoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ScoreDAO {

    private final ScoreMapper scoreMapper;

//    점수 등록
    public void save(ScoreVO scoreVO) {
        scoreMapper.insert(scoreVO);
    }

//    점수 전체 조회
    public List<ScoreDTO> findAll() {
        return scoreMapper.selectAll();
    }

//    점수 단일 조회
    public Optional<ScoreDTO> findById(Long id) {
        return scoreMapper.select(id);
    }

}
