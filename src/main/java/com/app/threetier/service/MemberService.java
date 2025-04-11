package com.app.threetier.service;

import com.app.threetier.domain.MemberVO;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

// 인터페이스는 어노테이션 필요 없음!
// 구현이 안되서 메모리에 할당시킬 수 없음 => Spring이 관리할 수 없음
// 확장성 때문
// 메서드가 하나여도 인터페이스로 만들어야 함
// 매개변수를 다르게 받아야 하는 경우 => 쉽게 관리하기 위해서
// 오버라이딩 X => @Qualifier 주입
// 하나의 메서드가 하나의 서비스
// 서비스 단위별로 트랜잭션 존재 (트랜잭션 관리 : 서비스에서 관리)

public interface MemberService {
//    회원가입
    public void join(MemberVO memberVO);

//    로그인
    public Optional<MemberVO> login(MemberVO memberVO);

//    회원 탈퇴
    public void withdraw(Long id);

}
