package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    PostMapper postMapper;

    @Test
    public void selectAllTest() {
        List<PostVO> posts = postMapper.selectAll();
        posts.stream().map(PostVO::toString).forEach(log::info);
    }

}
