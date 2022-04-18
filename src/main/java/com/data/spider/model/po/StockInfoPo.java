package com.data.spider.model.po;

import lombok.Data;

@Data
public class StockInfoPo {
    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票名称
     */
    private String code;

    /**
     * 股票类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private String ctime;

    /**
     * 更新时间
     */
    private String rtime;

    /**
     * 是否有效
     */
    private Integer isvalid;
}
