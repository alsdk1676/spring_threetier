package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/member/*")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

//    테스트가 아니기 때문에 생성자 주입 받기!!
    private final MemberMapper memberMapper;
//    로그인 된 유저의 정보를 session에 담기
    private final HttpSession session;

//  회원가입

//    포워드(요청 조인 응답 조인)
//    join (회원가입페이지에서 보낼 데이터 없음)
//    member/join.html -> join.html로 컨트롤러 타고옴
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO) {;}

//    리다이렉트 (요청 조인 응답 로그인)
//    입력하고 버튼 누르면 join 컨트롤러로 오면서 log 찍힘
//    join-ok
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {
        log.info(memberVO.toString());
        memberMapper.insert(memberVO);
//        return "forword://member/login"; 포워드
        return new RedirectView("/member/login");
    }

//    로그인 페이지 이동 (보내기만 하고 더 할 게 없음)
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

//    로그인
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {
//        내가 보낸 데이터 잘 들고오는지 확인 (DB 찍고 오지 X 컨트롤러로 바로 옴)
        log.info(memberVO.toString());
//       검증
        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
//        null이 아닐때만 값 가져오게 하기
//            로그인 성공한 경우
        if(foundMember.isPresent()) {
//            로그인된 유저의 정보을 세션에 담기
            // "member"에는 memberVO의 메모리 주소값이 들어있음 - hashcode - 상태적
//            메모리 주소값을 session에 저장하는 건 잘못됨(상대적이라 값이 변함) -> 직렬화로 해결
//            직렬화 : 세션에 들어가는 값들 , VO, DTO
            session.setAttribute("member", foundMember.get()); // get() : 옵셔널에서 꺼내옴
            session.setAttribute("product", new ProductVO());
            return new RedirectView("/post/list");
        }
//        flash : 리다이렉트되고 데이터 유지 , 새로운 요청 경로를 받았을 때 초기화 됨 
//        ex ) login -> mypage : new flash(초기화), login -> login : 그대로 유지
//        1) 로그인 실패
//        2) 인증코드

//       ** 로그인 실패 => 세션 이용 ** (실패한 정보도 리다이렉트 시켜줘야함) 쿼리스트링 대신 flash 영역 사용해서 상태값 넘겨줌
//        session의 flash 영역
//        session이 과부화 되므로, session에 flash 영역을 사용하여
//        화면으로 상태 값을 보내고, new Request가 되면 session에 flash 값이 새로 주입되어 기존 flash 값이 사라진다.
//        따라서 과부화의 부담이 줄어든다.

//        로그인 실패 시 flash가 false 값 가짐
//        addFlashAttribute를 관리하는 게 redirectAttributes
        redirectAttributes.addFlashAttribute("login", false);
        redirectAttributes.addFlashAttribute("code", 12345678);
        return new RedirectView("/member/login");
    }
    
    
//    로그아웃
    @GetMapping("logout")
    public RedirectView logout() {
//        session.removeAttribute("member"); 
        session.invalidate(); // 여러 정보를 지울 수 있음
        return new RedirectView("/member/login");
    }

}
