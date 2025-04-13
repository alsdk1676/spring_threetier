package com.app.threetier.mapper;


import com.app.threetier.domain.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BookMapperTests {

    @Autowired
    private BookMapper bookMapper;

    //    도서 등록
    @Test
    public void insertTest() {
        BookVO bookVO = new BookVO();
        bookVO.setBookTitle("제목5");
        bookVO.setBookAuthor("작가5");
        bookVO.setBookPrice(500000);
        bookVO.setBookStock(500);
        bookMapper.insert(bookVO);
        log.info("{}", bookVO);
    }

//    도서 전체 조회
    @Test
    public void selectAllTest() {
        List<BookVO> bookList = bookMapper.selectAll();
        bookList.stream().map(BookVO::toString).forEach(log::info);
    }

//    도서 단일 조회
    @Test
    public void selectByIdTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(4L);
        bookMapper.select(bookVO.getId()).map(BookVO::toString).ifPresent(log::info);
    }

//    도서 수정
    @Test
    public void updateTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(1L);
        bookVO.setBookTitle("수정된 제목1");
        bookVO.setBookAuthor("수정된 작가1");
        bookVO.setBookPrice(1000000);
        bookVO.setBookStock(10000);
        bookMapper.update(bookVO);
    }

//    도서 삭제
    @Test
    public void deleteTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(5L);
        bookMapper.delete(bookVO.getId());
    }


}
