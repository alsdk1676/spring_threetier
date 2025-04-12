package com.app.threetier.repository;


import com.app.threetier.domain.NoticeVO;
import com.app.threetier.mapper.MemberMapper;
import com.app.threetier.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class NoticeDAO {

    private final NoticeMapper noticeMapper;

//    게시물 등록
    public void save(NoticeVO noticeVO) {
        noticeMapper.insert(noticeVO);
    }

//    게시물 전체 조회
    public List<NoticeVO> findAll() {
        return noticeMapper.selectAll();
    }

//    게시물 단일 조회
    public Optional<NoticeVO> findById(Long id) {
        return noticeMapper.select(id);
    }

//    게시물 수정
    public void update(NoticeVO noticeVO) {
        noticeMapper.update(noticeVO);
    }

//    게시물 삭제
    public void delete(Long id) {
        noticeMapper.delete(id);
    }

//    게시물 전체 삭제
    public void deleteAll(Long memberId) {
        noticeMapper.deleteAll(memberId);
    }

}
