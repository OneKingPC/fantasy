package com.venchi.dark.service;

import com.venchi.dark.mapper.UserRoleMapper;
import com.venchi.dark.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2021/08/03
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> findRolesByUserId(Integer userId) {
        return userRoleMapper.findUserRoles(userId);
    }
}
