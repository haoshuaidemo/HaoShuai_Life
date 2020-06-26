package com.blog.web;

import com.blog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Title: BaseController
 * @ProjectName blog_service
 * @Description: TODO
 * @date 2020/6/2510:01
 */
@RestController
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping({"/helloWorld"})
    public String hello()
    {
        baseService.hello("hello");
        return "hello,world@";
    }
}
