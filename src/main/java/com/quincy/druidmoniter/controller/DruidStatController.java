package com.quincy.druidmoniter.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库监控
 *
 * @author quinc
 * @date 2018/12/26 星期三
 */
@RestController
public class DruidStatController {

    @GetMapping("/dbStat")
    public Object databaseStat() {
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}