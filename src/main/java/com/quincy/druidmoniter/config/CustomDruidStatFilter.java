package com.quincy.druidmoniter.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 自定义过滤器
 *
 * @author quinc
 * @date 2018/12/26 星期三
 */
@WebFilter(filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*",
                        description = "忽略资源")
        })
public class CustomDruidStatFilter extends WebStatFilter {

        @Override
        public void init(FilterConfig config) throws ServletException {
                super.init(config);
                System.out.println();
        }
}
