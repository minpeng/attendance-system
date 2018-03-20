package com.attendance.service.impl;

import com.attendance.domain.UserInfo;
import com.attendance.repository.UserInfoRepository;
import com.attendance.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pengmin on 2018/3/3.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    public UserInfoServiceImpl() {
        super();
    }
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public Page<UserInfo> findList(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public UserInfo findUserByUserNameAndPassword(String userName, String password) {
        return userInfoRepository.findAllByUserNameAndPassword(userName,password);
    }

    @Override
    public UserInfo findUserByUserName(String userName) {
        return userInfoRepository.findAllByUserName(userName);
    }

    @Override
    public void delete(Long id) {
         userInfoRepository.delete(id);
    }

    @Override
    public int updatePassword(String password, Long id) {
       return userInfoRepository.updatePassword(password,id);
    }

    @Override
    public UserInfo findOne(Long id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
