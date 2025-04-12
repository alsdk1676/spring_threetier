package com.app.threetier.repository;

import com.app.threetier.domain.UserVO;
import com.app.threetier.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UserMapper userMapper;
    private final UserVO userVO;

//    회원가입
    public void save(UserVO userVO) {
        userMapper.insert(userVO);
    }

//    로그인
    public Optional<UserVO> findUserByIdAndUserPassword(UserVO userVO) {
        return userMapper.select(userVO);
    }

//    회원 수정
    public void update(UserVO userVO) {
        userMapper.update(userVO);
    }

//    회원 탈퇴
    public void delete(Long id) {
        userMapper.delete(id);
    }

}
