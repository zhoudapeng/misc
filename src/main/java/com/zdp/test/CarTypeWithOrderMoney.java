package com.zdp.test;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年6月30日 下午6:06:31
 */
public class CarTypeWithOrderMoney {
    private Integer carTypeId;
    private Double orderMoney;
    public CarTypeWithOrderMoney() {
        super();
    }
    public CarTypeWithOrderMoney(Integer carTypeId, Double orderMoney) {
        super();
        this.carTypeId = carTypeId;
        this.orderMoney = orderMoney;
    }
    public Integer getCarTypeId() {
        return carTypeId;
    }
    public void setCarTypeId(Integer carTypeId) {
        this.carTypeId = carTypeId;
    }
    public Double getOrderMoney() {
        return orderMoney;
    }
    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }
}
