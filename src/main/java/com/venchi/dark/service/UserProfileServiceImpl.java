package com.venchi.dark.service;

import com.venchi.dark.mapper.UserProfileMapper;
import com.venchi.dark.pojo.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/02
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public List<UserProfile> findAll() {
        return userProfileMapper.findAll();
    }

}
