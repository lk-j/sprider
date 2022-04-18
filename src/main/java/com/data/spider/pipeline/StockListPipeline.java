package com.data.spider.pipeline;

import com.data.spider.mapper.StockInfoMapper;
import com.data.spider.model.bo.eastmoney.StockInfoBo;
import com.data.spider.model.po.StockInfoPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class StockListPipeline implements Pipeline {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    private static Map<String, Integer> relation;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<StockInfoBo> stockInfoBoList = (List<StockInfoBo>) resultItems.getAll().get("data");
        for (StockInfoBo stockInfoBo: stockInfoBoList) {
            StockInfoPo stockInfoPo = new StockInfoPo();
            stockInfoPo.setCode(stockInfoBo.getCode());
            stockInfoPo.setName(stockInfoBo.getName());
            stockInfoPo.setType(1);
            try {
                StockInfoPo infoPo = stockInfoMapper.selectByCode(stockInfoBo.getCode());
                boolean res;
                if (ObjectUtils.isEmpty(infoPo)) {
                     res = stockInfoMapper.insert(stockInfoPo);
                } else {
                     res = stockInfoMapper.updateByCode(stockInfoPo);
                }
                if (!res) {
                    log.error("插入失败, data:{}", stockInfoPo);
                }
            } catch (Exception exception) {
                log.error("插入失败, data:{}", stockInfoPo, exception);
            }
        }
    }
}
