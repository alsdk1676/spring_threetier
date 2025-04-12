package com.app.threetier.service;

import com.app.threetier.domain.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface NoticeService {

//    게시글 등록
    public void write(NoticeVO notice);

//    게시글 전체 조회
    public List<NoticeVO> getListNotice();

//    게시글 단일 조회
    public Optional<NoticeVO> getNoticeById(Long id);

//    게시글 수정
    public void edit(NoticeVO notice);

//    게시글 삭제
    public void remove(Long id);

//    게시글 전체 삭제
    public void removeAll(Long memberId);

}
