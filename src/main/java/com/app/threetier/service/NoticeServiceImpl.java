package com.app.threetier.service;

import com.app.threetier.domain.NoticeVO;
import com.app.threetier.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;

    @Override
    public void write(NoticeVO noticeVO) {
        noticeDAO.save(noticeVO);
    }

    @Override
    public List<NoticeVO> getListNotice() {
        return noticeDAO.findAll();
    }

    @Override
    public Optional<NoticeVO> getNoticeById(Long id) {
        return noticeDAO.findById(id);
    }

    @Override
    public void edit(NoticeVO notice) {
        noticeDAO.update(notice);
    }

    @Override
    public void remove(Long id) {
        noticeDAO.delete(id);
    }

    @Override
    public void removeAll(Long memberId) {
        noticeDAO.deleteAll(memberId);
    }
}
