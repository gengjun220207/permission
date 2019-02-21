package com.imooc.controller;

import com.imooc.common.ApplicationContextHelper;
import com.imooc.common.JsonData;
import com.imooc.dao.SysAclMapper;
import com.imooc.exception.ParamException;
import com.imooc.exception.PermissionException;
import com.imooc.model.SysAcl;
import com.imooc.param.TestVo;
import com.imooc.util.BeanValidator;
import com.imooc.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        log.info("hello");
        return "hello,permission";

    }

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData helloJson(){
        //throw new PermissionException("test exception");
        throw new RuntimeException();
        //return JsonData.fail("error");

    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        SysAclMapper sysAclMapper = ApplicationContextHelper.popBean(SysAclMapper.class);
        SysAcl sysAcl = sysAclMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(sysAcl));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
