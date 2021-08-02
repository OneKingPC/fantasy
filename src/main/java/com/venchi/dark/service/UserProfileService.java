package com.venchi.dark.service;

import com.venchi.dark.pojo.UserProfile;

import java.util.List;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/02
 */
public interface UserProfileService {

    /**
     * 查询所有用户信息列表
     * @return
     */
    public List<UserProfile> findAll();

}
