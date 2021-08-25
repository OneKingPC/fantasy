package com.venchi.dark.mapper;

import com.venchi.dark.pojo.UserAuth;
import org.apache.ibatis.annotations.*;

/**
 * @author liwc
 * @date 2021/08/02
 */
@Mapper
public interface UserAuthMapper {

    /**
     * 根据用户名获取用户验证信息
     * @param username
     * @return
     */
    @Select("select * from user_auth where username=#{username}")
    public UserAuth findByUsername(@Param("username") String username);

}
