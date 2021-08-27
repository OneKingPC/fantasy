package com.venchi.dark.service;

import com.venchi.dark.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/27
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object getValue(String key) {
        return redisUtil.get(key);
    }

}
