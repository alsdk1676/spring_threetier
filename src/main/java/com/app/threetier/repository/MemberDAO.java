package com.app.threetier.repository;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // JPA :
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;
    private final MemberVO memberVO;

    //    회원가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

//    로그인
    public Optional<MemberVO> findByMemberIdAndMemberPassword(MemberVO memberVO) {
        return memberMapper.select(memberVO);
    }

//    회원 탈퇴
    public void delete(Long id) {
        memberMapper.delete(id);
    }

}
