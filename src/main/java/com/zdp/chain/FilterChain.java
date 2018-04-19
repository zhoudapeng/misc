package com.zdp.chain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by dapeng.zhou on 2017/6/14.
 */
public class FilterChain {
    private List<Filter> filterList = Lists.newArrayList();
    private int pos = 0;

    public void add(Filter filter) {
        filterList.add(filter);
    }

    public void doFilter(Context context) {
        if (pos < filterList.size()) {
            filterList.get(pos++).doFilter(context,this);
        }
    }
}
