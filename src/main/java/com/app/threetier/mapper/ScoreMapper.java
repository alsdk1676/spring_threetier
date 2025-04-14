package com.app.threetier.mapper;

import com.app.threetier.domain.ScoreVO;
import com.app.threetier.dto.ScoreDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ScoreMapper {

//    점수 입력
    public void insert(ScoreVO scoreVO);

//    점수 전체 조회
    public List<ScoreDTO> selectAll();

//    점수 단일 조회
    public Optional<ScoreDTO> select(Long id);

}
