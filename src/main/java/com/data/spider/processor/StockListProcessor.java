package com.data.spider.processor;

import com.data.spider.model.bo.eastmoney.EastmoneyStockInfoBo;
import com.data.spider.pipeline.StockListPipeline;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
@Slf4j
public class StockListProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        EastmoneyStockInfoBo eastmoneyStockInfoBo = page.getJson().toObject(EastmoneyStockInfoBo.class);
        log.info("spider stock list data result:{}", page.getJson().toString());
        page.putField("data", eastmoneyStockInfoBo.getData().getDiff());
    }

    @Override
    public Site getSite() {
        return site;
    }

    /*public static void main(String[] args) {
        Spider.create(new StockListProcessor()).
                addUrl("http://7.push2.eastmoney.com/api/qt/clist/get?pn=1&pz=10000&po=0&np=1&fltt=2&invt=2&fid=f12&fs=m:0+t:6,m:0+t:80,m:1+t:2,m:1+t:23,m:0+t:81+s:2048&fields=f12,f14").
                addPipeline(new StockListPipeline()).thread(5).run();
    }*/
}
   