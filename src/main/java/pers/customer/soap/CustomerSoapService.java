package pers.customer.soap;

import pers.customer.model.Customer;

/**
 * 客户 SOAP 服务接口
 */
public interface CustomerSoapService {

    /**
     * 根据 客户ID 获取客户对象
     */
    Customer getCustomer(long customerId);
}
