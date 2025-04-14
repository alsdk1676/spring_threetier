package com.app.threetier.service;

import com.app.threetier.domain.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import com.app.threetier.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Override
    public void register(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    @Override
    public List<StudentVO> getStudentList() {
        return studentDAO.findAll();
    }

    @Override
    public Optional<StudentVO> getStudentById(Long id) {
        return studentDAO.findById(id);
    }
}
