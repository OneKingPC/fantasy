package com.venchi.dark.service;

/**
 * @author liwc
 * @date 2021/08/27
 */
public interface RedisService {

    /**
     * 根据@key获取value
     * @param key
     * @return
     */
    Object getValue(String key);

}
