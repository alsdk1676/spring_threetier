package com.app.threetier.mapper;

import com.app.threetier.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberName("홍길동");
        memberVO.setMemberPassword("1234");
        memberMapper.insert(memberVO);
    }

    @Test
    public void selectTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberName("홍길동");
        memberVO.setMemberPassword("1234");
//        memberMapper.select(memberVO).map(MemberVO::toString).ifPresent(log::info);
        memberMapper.select(memberVO)
                .map((member) -> memberVO.toString())
                .ifPresent((member) -> {
                    log.info("{}", memberVO);
        });

    }


}
