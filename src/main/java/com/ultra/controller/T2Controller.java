package com.ultra.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultra.commom.Result;
import com.ultra.commom.ResultGenerator;

@RestController
public class T2Controller {

    @RequestMapping(value = "/t2/{id}", method = RequestMethod.GET)
    public Result testGet(@PathVariable String id) {
        return ResultGenerator.genSuccessResult(id);
    }
}
