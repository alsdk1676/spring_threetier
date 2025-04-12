package com.app.threetier.mapper;

import com.app.threetier.domain.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {

//    게시물 등록
    public void insert(NoticeVO noticeVO);

//    게시물 전체 조회
    public List<NoticeVO> selectAll();

//    게시물 단일 조회
    public Optional<NoticeVO> select(Long id);

//    게시물 수정
    public void update(NoticeVO noticeVO);

//    게시물 삭제
    public void delete(Long id);

//    게시물 전체 삭제
    public void deleteAll(Long id);
}
