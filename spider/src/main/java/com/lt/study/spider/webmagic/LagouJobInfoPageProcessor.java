package com.lt.study.spider.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by luotao on 2015/4/17.
 */
public class LagouJobInfoPageProcessor implements PageProcessor {

    private Site site = Site.me().setDomain("www.lagou.com");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www\\.lagou\\.com/jobs/\\d+\\.html").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//title/text()").toString());
        page.putField("content", page.getHtml().$("dt.clearfix.join_tc_icon").toString());
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new LagouJobInfoPageProcessor()).addUrl("http://www.lagou.com/jobs/453394.html")
                .addPipeline(new ConsolePipeline()).run();
    }
}
