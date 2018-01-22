package pers.frame4j.proxy;


public interface Proxy {

    /**
     * do chained proxy
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}