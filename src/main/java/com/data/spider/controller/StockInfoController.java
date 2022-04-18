package com.data.spider.controller;

import com.data.spider.mapper.StockInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockInfoController {
    @Autowired
    private StockInfoMapper stockInfoMapper;

    @GetMapping("/test")
    private String getAll() {
        return String.valueOf(stockInfoMapper.getAll().size());
    }
}
