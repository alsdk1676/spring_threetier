package com.app.threetier.repository;

import com.app.threetier.domain.BookVO;
import com.app.threetier.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookDAO {

    private final BookMapper bookMapper;

//    도서 등록
    public void save(BookVO bookVO) {
        bookMapper.insert(bookVO);
    }

//    도서 전체 조회
    public List<BookVO> findAll() {
        return bookMapper.selectAll();
    }

//    도서 단일 조회
    public Optional<BookVO> findById(Long id) {
        return bookMapper.select(id);
    }

//    도서 수정
    public void updateById(BookVO bookVO) {
        bookMapper.update(bookVO);
    }

//    도서 삭제
    public void deleteById(Long id) {
        bookMapper.delete(id);
    }

}
