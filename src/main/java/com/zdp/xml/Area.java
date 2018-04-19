package com.zdp.xml;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年3月24日 下午12:48:11
 */
public class Area {
    private int id;
    private int parentId;
    private String areaType;
    private String name;
    private int ordering;
    private String phoneArea = "未配置";
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getAreaType() {
        return areaType;
    }
    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOrdering() {
        return ordering;
    }
    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }
    public String getPhoneArea() {
        return phoneArea;
    }
    public void setPhoneArea(String phoneArea) {
        this.phoneArea = phoneArea;
    }
    @Override
    public String toString() {
        return "Area [id=" + id + ", parentId=" + parentId + ", areaType=" + areaType + ", name=" + name
                + ", ordering=" + ordering + ", phoneArea=" + phoneArea + "]";
    }
    
}
