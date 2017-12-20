package pers.customer.soap;

import pers.customer.model.Customer;
import pers.customer.service.CustomerService;
import pers.frame4j.annotation.Inject;
import pers.frame4j.annotation.Service;
import pers.frame4j.soap.Soap;

/**
 * 客户 SOAP 服务接口实现
 */
@Soap
@Service
public class CustomerSoapServiceImpl implements CustomerSoapService {

    @Inject
    private CustomerService customerService;

    public Customer getCustomer(long customerId) {
        return customerService.getCustomer(customerId);
    }
}
