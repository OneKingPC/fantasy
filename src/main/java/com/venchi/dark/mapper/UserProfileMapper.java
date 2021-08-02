package com.venchi.dark.mapper;

import com.venchi.dark.pojo.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/02
 */
@Mapper
public interface UserProfileMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select id,username,birthdate,sex_type as sexType from user_profile")
    public List<UserProfile> findAll();

}
