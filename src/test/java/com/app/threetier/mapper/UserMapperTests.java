package com.app.threetier.mapper;

import com.app.threetier.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.build.Plugin;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

//    회원 등록
    @Test
    public void insertUserTest() {
        UserVO userVO = new UserVO();
        userVO.setUserEmail("user789@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("유저3");
        userMapper.insert(userVO);
        log.info(userVO.toString());
    }

//    회원 전체 조회
    @Test
    public void selectAllUserTest() {
        userMapper.selectAll().stream().map(UserVO::toString).forEach(log::info);
    }

//    회원 단일 조회
    @Test
    public void selectUserTest() {
        UserVO userVO = new UserVO();
        userVO.setUserEmail("user789@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("유저3");
        userMapper.select(userVO).map(UserVO::toString).ifPresent(log::info);
    }

//    회원 정보 수정
    @Test
    public void updateUserTest() {
        UserVO userVO = new UserVO();
        userVO.setUserEmail("user789@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("유저3");
        userMapper.select(userVO).ifPresent((user) -> {
                user.setUserEmail("user000@gmail.com");
                userMapper.update(user);
                log.info("{}", user);
            });

    }

//    회원 탈퇴
    @Test
    public void deleteUserTest() {
        UserVO userVO = new UserVO();
        userVO.setUserEmail("user777@gmail.com");
        userVO.setUserPassword("1234");
        userVO.setUserName("유저4");
        userMapper.select(userVO).map(UserVO::getId).ifPresent((id) -> {
            userMapper.delete(id);
            log.info("{}", id);
        });

    }






}
