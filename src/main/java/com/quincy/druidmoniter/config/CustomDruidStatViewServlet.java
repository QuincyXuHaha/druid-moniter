package com.quincy.druidmoniter.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 默认的监控页面是没有任何限制的，这里加上限制
 * <p>
 * ps:这里要注意servlet的加载过程，首先servlet在匹配是只会匹配一个，不会执行所有满足urlPatterns的servlet。
 * 所以由于下面自定义的CustomDruidStatViewServlet的urlPatterns和
 * {@link com.alibaba.druid.spring.boot.autoconfigure.stat.DruidStatViewServletConfiguration#statViewServletRegistrationBean(DruidStatProperties)}
 * 中注册的 {@link StatViewServlet} 的urlPatterns是一样的，此时系统先匹配的是StatViewServlet，所以导致其实下面的属性并没有生效。
 * <p>
 * 解决办法有2个：1、这里观察到
 * {@link com.alibaba.druid.spring.boot.autoconfigure.stat.DruidStatViewServletConfiguration#statViewServletRegistrationBean(DruidStatProperties)}
 * 被执行的条件是不存在spring.datasource.druid.stat-view-servlet.enabled属性或者其为true，所以这里设置成false即可
 *  2、在配置文件中配置下面的属性即可，也不用自定义了，具体见{@link DruidStatProperties}
 * @author quincy
 * @date 2018/12/26 星期三
 */

@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "loginUsername", value = "root", description = "登录名"),
        @WebInitParam(name = "loginPassword", value = "root", description = "登录密码"),
        @WebInitParam(name = "allow", value = "127.0.0.1", description = "IP白名单"),
        @WebInitParam(name = "deny", value = "127.0.0.1", description = "IP黑名单"),
        @WebInitParam(name = "resetEnable", value = "true", description = "允许清空统计数据")
})
public class CustomDruidStatViewServlet extends StatViewServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("自定义初始化servlet成功");
    }
}
