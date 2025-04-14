package com.app.threetier.service;

import com.app.threetier.domain.StudentVO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public void register(StudentVO studentVO);

    public List<StudentVO> getStudentList();

    public Optional<StudentVO> getStudentById(Long id);
}
