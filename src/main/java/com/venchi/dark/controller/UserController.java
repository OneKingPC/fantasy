package com.venchi.dark.controller;

import com.venchi.dark.common.CommonResult;
import com.venchi.dark.common.ResultCode;
import com.venchi.dark.common.ResultEnum;
import com.venchi.dark.pojo.UserProfile;
import com.venchi.dark.service.UserProfileService;
import com.venchi.dark.vo.LoginRequest;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liwc
 * @date 2021/08/02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @ApiOperation(value = "查询用户列表")
    @PostMapping(value = "list")
    public CommonResult list(){
        List<UserProfile> userProfiles = userProfileService.findAll();
        CommonResult result = new CommonResult();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("查询成功");
        result.setData(userProfiles);
        return result;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "login")
    public CommonResult login(@RequestBody LoginRequest loginRequest){
        CommonResult result = new CommonResult();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginRequest.getUsername(),loginRequest.getPassword());
        SecurityUtils.getSubject().login(usernamePasswordToken);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage("登录成功");
        return result;
    }

    @ApiOperation(value = "用户登录")
    @GetMapping(value = "login_index")
    public CommonResult login_index(@RequestBody LoginRequest loginRequest){
        CommonResult result = new CommonResult();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginRequest.getUsername(),loginRequest.getPassword());
        SecurityUtils.getSubject().login(usernamePasswordToken);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage("登录成功");
        return result;
    }

}
