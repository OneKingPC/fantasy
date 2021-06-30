package com.venchi.dark.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liwc@tongtech.com
 * @date 2021/06/30
 */
@ApiModel(value = "接口测试请求")
@Data
public class TestRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "姓名")
    private String name;

}
