package com.ultra.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultra.commom.Result;
import com.ultra.commom.ResultGenerator;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class TController {

    @ApiOperation(value = "测试get请求", notes = "注意事项")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "String", paramType = "path")
    @RequestMapping(value = "/t/{id}", method = RequestMethod.GET)
    public Result testGet(@PathVariable String id) {
        return ResultGenerator.genSuccessResult(id);
    }
}
