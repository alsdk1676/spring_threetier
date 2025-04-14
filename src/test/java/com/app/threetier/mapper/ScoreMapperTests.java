package com.app.threetier.mapper;

import com.app.threetier.domain.ScoreVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ScoreMapperTests {

    @Autowired
    private ScoreMapper scoreMapper;

//    점수 등록
    @Test
    public void insertTest(){
        ScoreVO scoreVO = new ScoreVO();
        scoreVO.setKor(100);
        scoreVO.setEng(100);
        scoreVO.setMath(100);
        scoreMapper.insert(scoreVO);
        log.info("{}", scoreVO);
    }
}
