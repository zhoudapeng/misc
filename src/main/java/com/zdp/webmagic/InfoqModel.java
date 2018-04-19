package com.zdp.webmagic;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by dapeng.zhou on 2016/8/10.
 */
@TargetUrl("http://www.infoq.com/cn/news/\\d+/\\d+/[0-9a-zA-Z-]+")
public class InfoqModel {
    @ExtractBy("//h1[@class='general']/text()")
    private String title;
    @ExtractBy("//div[@class='text_info']/text()")
    private String content;

    public static void main(String[] args) {
        OOSpider.create(Site.me(),new ConsolePageModelPipeline(),InfoqModel.class).addUrl("http://www.infoq.com/cn/news/2016/08/big-data-jingdong-618").thread(2).run();
    }
}
