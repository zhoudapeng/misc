package com.zdp.chain;

/**
 * Created by dapeng.zhou on 2017/6/14.
 */
public class Demo {
    public static void main(String[] args) {
        Filter filter1 = new Filter() {
            public void doFilter(Context context, FilterChain chain) {
                System.out.println("filter1执行");
                context.put("filter1","filter1");
                chain.doFilter(context);
            }
        };
        Filter filter2 = new Filter() {
            public void doFilter(Context context, FilterChain chain) {
                System.out.println("filter2执行");
                context.put("filter2","filter2");
                if (System.currentTimeMillis() % 2 != 0) {
                    chain.doFilter(context);
                } else {
                    System.out.println("filter2判断不具备继续执行的条件，直接退出");
                }
            }
        };
        Filter filter3 = new Filter() {
            public void doFilter(Context context, FilterChain chain) {
                System.out.println("filter3执行");
                context.put("filter3","filter3");
                chain.doFilter(context);
            }
        };
        FilterChain chain = new FilterChain();
        chain.add(filter1);
        chain.add(filter2);
        chain.add(filter3);
        Context context = new Context();
        chain.doFilter(context);
        System.out.println(context);
    }
}
