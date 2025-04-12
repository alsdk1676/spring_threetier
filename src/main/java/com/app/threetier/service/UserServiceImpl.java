package com.app.threetier.service;

import com.app.threetier.domain.UserVO;
import com.app.threetier.mapper.UserMapper;
import com.app.threetier.repository.NoticeDAO;
import com.app.threetier.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final NoticeDAO noticeDAO;

    @Override
    public void joinUser(UserVO userVO) {
        userDAO.save(userVO);
    }

    @Override
    public Optional<UserVO> login(UserVO userVO) {
        return userDAO.findUserByIdAndUserPassword(userVO);
    }

    @Override
    public void edit(UserVO userVO) {
        userDAO.update(userVO);
    }

    @Override
    public void withdraw(Long id) {
        noticeDAO.deleteAll(id);
        userDAO.delete(id);
    }
}
