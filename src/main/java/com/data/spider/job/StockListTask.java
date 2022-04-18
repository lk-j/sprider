package com.data.spider.job;

import com.data.spider.pipeline.StockListPipeline;
import com.data.spider.processor.StockListProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * 股票基本信息爬取
 */
@Component
@EnableScheduling
public class StockListTask implements CommandLineRunner {

    @Autowired
    private StockListPipeline stockListPipeline;

    private static final String STOCK_LIST_URL = "http://7.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=0&np=1&fltt=2&invt=2&fid=f12&fs=m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048&fields=f12,f14";

    @Scheduled(cron = "0 0 */1 * * ?")
    private void getStockInfo() {
        Spider.create(new StockListProcessor()).addUrl(STOCK_LIST_URL).addPipeline(stockListPipeline).thread(5).run();
    }

    @Override
    public void run(String... args) throws Exception {
        getStockInfo();
    }
}
