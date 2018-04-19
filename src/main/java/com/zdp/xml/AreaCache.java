package com.zdp.xml;

import java.util.ArrayList;
import java.util.List;

/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月24日 下午12:53:08
 */
public class AreaCache {
    private List<Area> areaList = new ArrayList<Area>();
    
    public void setAreaList(List<Area> areaList){
        this.areaList = areaList;
    }
    public void addArea(Area area){
        areaList.add(area);
    }
    public List<Area> getAreaList(){
        return areaList;
    }
}
