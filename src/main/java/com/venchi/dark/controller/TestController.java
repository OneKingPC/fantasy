package com.venchi.dark.controller;

import com.venchi.dark.common.CommonResult;
import com.venchi.dark.vo.TestRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwc
 * @date 2021/06/30
 */
@Api(value = "api测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @ApiOperation(value = "接口方法测试")
    @PostMapping(value = "/sayHello")
    public CommonResult sayHello(@RequestBody TestRequest testRequest){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("success");
        commonResult.setData("Hello "+testRequest.getName());
        return commonResult;
    }

}
