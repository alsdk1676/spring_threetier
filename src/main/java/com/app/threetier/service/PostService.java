package com.app.threetier.service;

import com.app.threetier.domain.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시글 목록
    public List<PostVO> getList();

//    게시글 1개 조회
    public Optional<PostVO> getPostById(Long id);

//    게시글 추가
    public void write(PostVO postVO);

//    게시글 수정
    public void edit(PostVO postVO);

//    게시글 삭제
    public void removePost(Long id);

//  게시글 전체 삭제
    public void deleteAll(Long memberId);



}
