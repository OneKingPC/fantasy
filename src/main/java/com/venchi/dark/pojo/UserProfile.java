package com.venchi.dark.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author liwc@tongtech.com
 * @date 2021/07/30
 * 用户基本信息
 */
@Data
public class UserProfile {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 出生年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthdate;

    /**
     * 性别
     */
    private String sexType;

}
