package com.venchi.dark.mapper;

import com.venchi.dark.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/03
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 根据userId查询用户的角色
     * @param userId
     * @return
     */
    @Select("select id,user_id as userId,role_id as roleId from user_role where user_id=#{userId}")
    public List<UserRole> findUserRoles(@Param("userId") Integer userId);

}
