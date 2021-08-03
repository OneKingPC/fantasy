package com.venchi.dark.service;

import com.venchi.dark.pojo.Address;

/**
 * @author liwc
 * @date 2021/07/07
 */
public interface AddressService {

    /**
     * 根据 id 查询 address
     * @param id
     * @return
     */
    public Address findById(int id);

}
