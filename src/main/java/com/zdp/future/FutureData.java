package com.zdp.future;

/**
 * Created by dapeng.zhou on 2016/9/30.
 */
class FutureData implements Data {
    private RealData realData;
    private volatile boolean finished;

    public synchronized String getResult() throws Exception{
        if (!finished) {
            wait();
        }
        return realData.getResult();
    }

    public synchronized void setData(RealData realData) {
        this.realData = realData;
        finished = true;
        notifyAll();
    }
}
