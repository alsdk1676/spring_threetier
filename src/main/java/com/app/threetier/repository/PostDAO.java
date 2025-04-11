package com.app.threetier.repository;

import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;
    
//    게시글 전체 조회
    public List<PostVO> findAll() {
        return postMapper.selectAll();
    }

//    게시글 전체 삭제
    public void deleteAllByMemberId(Long memberId) {
        postMapper.deleteAll(memberId);
    }
}
