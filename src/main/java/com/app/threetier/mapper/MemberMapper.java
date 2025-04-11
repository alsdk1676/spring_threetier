package com.app.threetier.mapper;

import com.app.threetier.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);

//    로그인
    public Optional<MemberVO> select(MemberVO memberVO);

//    회원 탈퇴
    public void delete(Long id);
}
