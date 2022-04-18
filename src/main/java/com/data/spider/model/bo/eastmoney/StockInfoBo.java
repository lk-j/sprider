package com.data.spider.model.bo.eastmoney;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StockInfoBo {

    /**
     * 股票名称
     */
    @JSONField(name="f14")
    private String name;

    /**
     * 股票代码
     */
    @JSONField(name = "f12")
    private String code;
}
