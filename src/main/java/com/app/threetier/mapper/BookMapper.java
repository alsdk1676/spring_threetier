package com.app.threetier.mapper;

import com.app.threetier.domain.BookVO;
import com.app.threetier.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookMapper {

//    도서 등록
    public void insert(BookVO bookVO);

//    도서 전체 조회
    public List<BookVO> selectAll();

//    도서 단일 조회
    public Optional<BookVO> select(Long id);

//    도서 수정
    public void update(BookVO bookVO);

//    도서 삭제
    public void delete(Long id);
}
