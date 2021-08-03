package com.venchi.dark.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author liwc
 * @date 2021/07/07
 */
@Data
public class Address {

    /**
     * 主键id
     */
    private int id;

    /**
     * 用户id
     */
    private int userId;
    private String address;
    private Date createTime;


}
