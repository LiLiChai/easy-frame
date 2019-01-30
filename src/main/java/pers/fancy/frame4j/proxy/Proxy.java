package pers.fancy.frame4j.proxy;


/**
 * @author Fancy
 */
public interface Proxy {

    /**
     * 代理方法
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}