package pers.frame4j.proxy;


public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}