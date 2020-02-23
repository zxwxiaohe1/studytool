package com.study.en;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.study.en.support.holder.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heyong
 * @date 2020/2/23
 */
@Configuration
public class CoreConfig {
    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
