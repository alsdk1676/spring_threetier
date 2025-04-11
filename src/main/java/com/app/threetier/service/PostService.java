package com.app.threetier.service;

import com.app.threetier.domain.PostVO;

import java.util.List;

public interface PostService {
//    게시글 몰록
    public List<PostVO> getList();

//    게시글 삭제
    public void deleteAll(Long memberId);

}
