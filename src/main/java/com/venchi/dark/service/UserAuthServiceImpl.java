package com.venchi.dark.service;

import com.venchi.dark.mapper.UserAuthMapper;
import com.venchi.dark.pojo.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liwc
 * @date 2021/08/02
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    public UserAuth findByUsername(String username) {
        return userAuthMapper.findByUsername(username);
    }

}
