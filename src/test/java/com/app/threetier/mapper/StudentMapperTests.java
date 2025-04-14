package com.app.threetier.mapper;

import com.app.threetier.domain.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class StudentMapperTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertTest(){
        StudentVO studentVO = new StudentVO();
        studentVO.setKor(100);
        studentVO.setEng(90);
        studentVO.setMath(80);
        studentMapper.insert(studentVO);
    };

    @Test
    public void selectAllTest(){
        List<StudentVO> studentVOList = studentMapper.selectAll();
        log.info(studentVOList.toString());
    }

}
