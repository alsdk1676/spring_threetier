package com.app.threetier.service;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.repository.MemberDAO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

// 서비스와 관련된 로직 모두 작성
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class) // 메서드 단위보다 클래스 단위로 한꺼번에 관리하면 더 편리함!
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

//    회원 가입
    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

//    로그인
    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.findByMemberIdAndMemberPassword(memberVO);
    }

//    회원 탈퇴 => 회원이 들어간 테이블 다 삭제
    @Override
//    @Transactional(rollbackFor = Exception.class) // 어떤 오류가 발생해도 모두 다 되돌림
//    @Transactional(rollbackFor = {IOException.class, RuntimeException.class})
    public void withdraw(Long id) {
//        게시글도 모두 삭제 (서비스인 이유! => postMapper.xml로 이동)
//        게시글이 먼저 지워지고, 회원 삭제됨
//        이 서비스가 하나의 작업단위 : 트랜잭션
        postDAO.deleteAllByMemberId(id);
        memberDAO.delete(id);
    }
}
