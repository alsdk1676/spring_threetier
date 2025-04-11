package com.app.threetier.service;

import com.app.threetier.domain.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

//    게시글 전체 조회
    @Override
    public List<PostVO> getList() {
        return postDAO.findAll();
    }

//    게시글 단일 조히
    @Override
    public Optional<PostVO> getPostById(Long id) {
        return postDAO.findById(id);
    }

//    게시글 작성
    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

//    게시글 수정
    @Override
    public void edit(PostVO postVO) {
        postDAO.editById(postVO);
    }

//   게시글 삭제
    @Override
    public void removePost(Long id) {
        postDAO.deleteById(id);
    }

//    게시글 전체 삭제
    @Override
    public void deleteAll(Long memberId) {
        postDAO.deleteAllByMemberId(memberId);
    }
}
