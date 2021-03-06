package com.venchi.dark.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author liwc
 * @date 2021/07/30
 * 用户认证信息
 */
@Data
public class UserAuth {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private List<Role> roleList;

}
