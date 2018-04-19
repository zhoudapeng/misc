package com.zdp.chain;

/**
 * Created by dapeng.zhou on 2017/6/14.
 */
public interface Filter {
    public void doFilter(Context context,FilterChain chain);
}
