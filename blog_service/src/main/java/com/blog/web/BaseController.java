package com.blog.web;

import com.blog.pojo.Base;
import com.blog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @Title: BaseController
 * @ProjectName blog_service
 * @Description: 请求的模板
 * @date 2020/6/2510:01
 */
@RestController
@RequestMapping("/blog-web")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping({"/checkAlive"})
    public String checkAlive(){
        return "I am alive!";
    }

    @RequestMapping({"/postParams"})
    @ResponseBody
    public String postParams(@RequestBody Base base)
    {
        return "前台json对象，后台实体类:"+base.getUsername();
    }

    @RequestMapping({"/postParam"})
    @ResponseBody
    public String postParam(@RequestParam("param") String param)
    {
        return "前天未知，后台一个实体类";
    }

    @GetMapping({"/getParam/{param}"})
    @ResponseBody
    public String getParams(@PathVariable("param") String param)
    {
        System.out.println(param);
        return "get请求"+param;
    }
    
}
