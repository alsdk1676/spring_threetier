package com.app.threetier.service;

import com.app.threetier.domain.BookVO;
import com.app.threetier.repository.BookDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Override
    public void register(BookVO bookVO) {
        bookDAO.save(bookVO);
    }

    @Override
    public List<BookVO> getList() {
        return bookDAO.findAll();
    }

    @Override
    public Optional<BookVO> getById(Long id) {
        return bookDAO.findById(id);
    }

    @Override
    public void modify(BookVO bookVO) {
        bookDAO.updateById(bookVO);
    }

    @Override
    public void remove(Long id) {
        bookDAO.deleteById(id);
    }
}
