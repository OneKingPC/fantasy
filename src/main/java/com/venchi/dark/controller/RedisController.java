package com.venchi.dark.controller;

import com.venchi.dark.annotation.Log;
import com.venchi.dark.common.CommonResult;
import com.venchi.dark.common.ResultEnum;
import com.venchi.dark.service.RedisService;
import com.venchi.dark.vo.RedisRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwc
 * @date 2021/08/27
 */
@Api(value = "redis测试")
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "测试get方法")
    @PostMapping(value = "/get")
    @Log("RedisController.get")
    public CommonResult get(@RequestBody RedisRequest request){
        Object rsData = redisService.getValue(request.getKey());
        CommonResult commonResult = new CommonResult();
        commonResult.setMessage(ResultEnum.SUCCESS.getMessage());
        commonResult.setCode(ResultEnum.SUCCESS.getCode());
        commonResult.setData(rsData);
        return commonResult;
    }

}
