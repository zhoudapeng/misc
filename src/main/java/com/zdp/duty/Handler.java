package com.zdp.duty;

import java.util.List;

/**
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年11月24日 下午5:05:58
 */
public class Handler {
    private GetCityNameable getCityNameService;
    private GetStoreIdsable getStoreIdsService;
    private GetStoreNamesable getStoreNameService;

    /**
     * 主干代码,各组件的执行顺序不开放给开发者，开发者只需要提供各个组件的实现即可<br/>
     * 
     * @param cityCode
     * @return
     */
    public final List<String> handle(int cityCode) {
        String cityName = getCityNameService.getCityName(cityCode);
        List<Integer> storeIds = getStoreIdsService.getIds(cityName);
        List<String> storeNames = getStoreNameService.getStoreNames(storeIds);
        return storeNames;
    }

}
