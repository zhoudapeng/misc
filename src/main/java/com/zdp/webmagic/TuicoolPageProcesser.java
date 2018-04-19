package com.zdp.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * Created by dapeng.zhou on 2016/8/8.
 */
@TargetUrl("http://www.tuicool.com/articles/\\w+")
public class TuicoolPageProcesser  {
    @ExtractBy("//div[@class='span8 contant article_detail_bg']/h1/text()")
    private String title;
    @ExtractBy("//div[@class='article_body']/div")
    private String content;


    public static void main(String[] args) {
        OOSpider.create(Site.me(),new ConsolePageModelPipeline(),TuicoolPageProcesser.class).addUrl("http://www.tuicool.com/articles/26V3e2N").thread(2).run();
    }
}
