package com.app.threetier.mapper;

import com.app.threetier.domain.NoticeVO;
import com.app.threetier.domain.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class NoticeMapperTests {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeVO noticeVO;

    //    게시글 작성
    @Test
    public void insertNoticeTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("user000@gmail.com");
        userVO.setUserPassword("1234");
        userMapper.select(userVO).map(UserVO::getId).ifPresent(id -> {
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setUserId(id);
            noticeVO.setNoticeTitle("제목6");
            noticeVO.setNoticeContent("내용6");
            noticeMapper.insert(noticeVO);
            log.info("{}", noticeVO);
        });
    }

//    게시글 전체 조회
    @Test
    public void selectAllNoticeTest(){
//        List<NoticeVO> notices = noticeMapper.selectAll();
//        notices.stream().map(NoticeVO::toString).forEach(log::info);

        noticeMapper.selectAll().stream().map(NoticeVO::toString).forEach(log::info);
    }

//    게시글 단일 조회
    @Test
    public void selectNoticeTest(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setId(3L);
        noticeMapper.select(noticeVO.getId());
        log.info("{}", noticeVO);
    }

//    게시글 수정
    @Test
    public void updateNoticeTest(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setId(8L);

        noticeMapper.select(noticeVO.getId()).ifPresent(notice -> {
            notice.setId(8L);
            notice.setNoticeTitle("수정된 내용6");
            notice.setNoticeContent("수정된 내옹6");
            noticeMapper.update(notice);
        });
    }

    @Test
    public void deleteNoticeTest(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("제목1");
        noticeVO.setNoticeContent("내용1");
        noticeVO.setId(2L);
        noticeMapper.select(noticeVO.getId()).ifPresent((notice) -> {
            noticeMapper.delete(notice.getId());
        });
    }
}
