package com.venchi.dark.service;

import com.venchi.dark.pojo.UserAuth;

/**
 * @author liwc
 * @date 2021/08/02
 */
public interface UserAuthService {

    /**
     * 根据用户名查询验证信息
     * @param username
     * @return
     */
    public UserAuth findByUsername(String username);

}
