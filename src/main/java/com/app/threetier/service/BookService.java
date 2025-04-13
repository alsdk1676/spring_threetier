package com.app.threetier.service;

import com.app.threetier.domain.BookVO;

import java.util.List;
import java.util.Optional;

public interface BookService {

//    도서 등록
    public void register(BookVO bookVO);

//    도서 전체 조회
    public List<BookVO> getList();

//    도서 단일 조회
    public Optional<BookVO> getById(Long id);

//    도서 수정
    public void modify(BookVO bookVO);

//    도서 삭제
    public void remove(Long id);

}
