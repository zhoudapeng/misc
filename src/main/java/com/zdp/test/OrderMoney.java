package com.zdp.test;
/**
@author：  <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
@date： 2015年6月30日 下午6:28:35
 */
public class OrderMoney {
    private int carTypeId;
    private double orderMoney;
    
    public OrderMoney(int carTypeId, double orderMoney) {
        super();
        this.carTypeId = carTypeId;
        this.orderMoney = orderMoney;
    }
    public int getCarTypeId() {
        return carTypeId;
    }
    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }
    public double getOrderMoney() {
        return orderMoney;
    }
    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }
    
}
