package com.venchi.dark.service;

import com.venchi.dark.pojo.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/02
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    public UserAuth findByUsername(String username) {
        return userAuthService.findByUsername(username);
    }

}