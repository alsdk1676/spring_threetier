package com.app.threetier.repository;

import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;
    
//    게시글 전체 조회
    public List<PostVO> findAll() {
        return postMapper.selectAll();
    }

//    게시글 1개 조회
    public Optional<PostVO> findById(Long id) {
        return postMapper.select(id);
    }

//    게시글 작성
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

//    게시글 수정
    public void editById(PostVO postVO) {
        postMapper.update(postVO);
    }

//    게시글 삭제
    public void deleteById(Long id) {
        postMapper.delete(id);
    }

//    게시글 전체 삭제
    public void deleteAllByMemberId(Long memberId) {
        postMapper.deleteAll(memberId);
    }


}
