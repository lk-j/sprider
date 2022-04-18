package com.data.spider.mapper;

import com.data.spider.model.po.StockInfoPo;

import java.util.List;

public interface StockInfoMapper {
    List<StockInfoPo> getAll();

    boolean insert(StockInfoPo stockInfoPo);

    boolean updateByCode(StockInfoPo stockInfoPo);

    StockInfoPo selectByCode(String code);
}
