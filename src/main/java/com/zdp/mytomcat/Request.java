package com.zdp.mytomcat;

import java.util.Map;

/**
 * Created by dapeng.zhou on 2016/2/19.
 */
public class Request {
    private String method;
    private String uri;
    private String protocol;
    private Map<String,String> headers;
    private Map<String,String> bodys;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getBodys() {
        return bodys;
    }

    public void setBodys(Map<String, String> bodys) {
        this.bodys = bodys;
    }
}
