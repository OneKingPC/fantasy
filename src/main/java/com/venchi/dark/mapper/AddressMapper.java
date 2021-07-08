package com.venchi.dark.mapper;

import com.venchi.dark.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author liwc@tongtech.com
 * @date 2021/07/07
 */
@Mapper
public interface AddressMapper {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from address where id=#{id}")
    public Address findById(Integer id);

}
