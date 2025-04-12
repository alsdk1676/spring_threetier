package com.app.threetier.service;

import com.app.threetier.domain.UserVO;

import java.util.Optional;

public interface UserService {

//    회원가입
    public void joinUser(UserVO userVO);

//    로그인
    public Optional<UserVO> login(UserVO userVO);

//    회원수정
    public void edit(UserVO userVO);

//    회원탈퇴
    public void withdraw(Long id);

}
