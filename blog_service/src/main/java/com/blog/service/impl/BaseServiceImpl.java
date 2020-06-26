package com.blog.service.impl;

import com.blog.mapper.BaseMapper;
import com.blog.pojo.Base;
import com.blog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Title: BaseServiceImpl
 * @ProjectName blog_service
 * @Description: TODO
 * @date 2020/6/2510:52
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public String hello(String hello) {
        Base base=new Base("1","we","you");
        int num=baseMapper.addBase(base);
        if (num==1){
            System.out.println("成功");
        }
        return null;
    }
}
