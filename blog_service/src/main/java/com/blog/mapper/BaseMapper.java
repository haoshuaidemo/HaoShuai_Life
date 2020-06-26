package com.blog.mapper;

import com.blog.pojo.Base;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Title: baseMapper
 * @ProjectName blog_service
 * @Description: TODO
 * @date 2020/6/2511:25
 */
@Repository
public interface BaseMapper {
    int addBase(Base base);
}
