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
    public UserInfo insert(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void delete(Long id) {
         userInfoRepository.delete(id);
    }

    @Override
    public int updatePassword(String password, Long id) {
       return userInfoRepository.updatePassword(password,id);
    }
}
