package com.app.threetier.mapper;

import com.app.threetier.domain.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {

    public void insert(StudentVO studentVO);

    public List<StudentVO> selectAll();

    public Optional<StudentVO> select(Long id);
}
