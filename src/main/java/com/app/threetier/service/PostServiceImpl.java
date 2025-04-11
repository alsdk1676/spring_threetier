package com.app.threetier.service;

import com.app.threetier.domain.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostVO> getList() {
        return postDAO.findAll();
    }

    @Override
    public void deleteAll(Long memberId) {
        postDAO.deleteAllByMemberId(memberId);
    }
}
