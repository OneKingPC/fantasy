package com.venchi.dark.service;

import com.venchi.dark.pojo.UserRole;

import java.util.List;

/**
 * @author
 * @date 2021/08/03
 */
public interface UserRoleService {

    public List<UserRole> findRolesByUserId(Integer userId);

}
