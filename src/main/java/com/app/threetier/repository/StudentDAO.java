package com.app.threetier.repository;

import com.app.threetier.domain.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDAO {

    private final StudentMapper studentMapper;

//    학생 정보 추가
    public void save(StudentVO studentVO) {
        studentMapper.insert(studentVO);
    }

//    학생 정보 전체 조회
    public List<StudentVO> findAll() {
        return studentMapper.selectAll();
    }

//    학생 정보 단일 조회
    public Optional<StudentVO> findById(Long id) {
        return studentMapper.select(id);
    }


}

