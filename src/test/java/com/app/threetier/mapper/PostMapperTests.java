package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import com.app.threetier.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    PostMapper postMapper;

    @Autowired
    PostService postService;

    @Test
    public void selectAllTest() {
        List<PostVO> posts = postMapper.selectAll();
        posts.stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void postReadTest() {
        postService.getPostById(3L).map(PostVO::toString).ifPresent(log::info);
    }

    @Test
    public void postUpdateTest() {
        PostVO postVO = new PostVO();
        postVO.setId(3L);
        postVO.setPostTitle("아무거나1");
        postVO.setPostContent("아무거나1");
        postService.edit(postVO);
    }

}
