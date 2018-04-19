package com.zdp.xml;

import java.io.File;

import org.apache.commons.digester.Digester;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月24日 下午12:49:45
 */
public class AreaDigester {
    public static void main(String[] args) throws Exception{
        Digester digester = new Digester();
        digester.setValidating(true);
        digester.addObjectCreate("viewcache/areas", AreaCache.class);
        digester.addObjectCreate("viewcache/areas/area", Area.class);
        digester.addBeanPropertySetter("viewcache/areas/area/id");
        digester.addBeanPropertySetter("viewcache/areas/area/parentId");
        digester.addBeanPropertySetter("viewcache/areas/area/areaType");
        digester.addBeanPropertySetter("viewcache/areas/area/name");
        digester.addBeanPropertySetter("viewcache/areas/area/ordering");
        digester.addBeanPropertySetter("viewcache/areas/area/phoneArea");
        digester.addSetNext("viewcache/areas/area", "addArea");
        AreaCache cache = (AreaCache) digester.parse(AreaDigester.class.getClassLoader().getResourceAsStream("xml/viewcache.xml"));
        for(Area area:cache.getAreaList()){
            System.out.println(area);
        }
    }
}
