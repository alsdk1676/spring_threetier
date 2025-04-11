package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<PostVO> selectAll();

    public void deleteAll(Long id);
}
