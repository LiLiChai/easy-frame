package pers.fancy.customer.controller;

import java.util.List;
import java.util.Map;

import pers.fancy.customer.model.Customer;
import pers.fancy.customer.service.CustomerService;
import pers.fancy.frame4j.annotation.Controller;
import pers.fancy.frame4j.bean.Param;
import pers.fancy.frame4j.annotation.Action;
import pers.fancy.frame4j.annotation.Inject;
import pers.fancy.frame4j.bean.Data;
import pers.fancy.frame4j.bean.View;

/**
 *
 * @author fancy
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public Data index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }

    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("view/customer_show.jsp").addModel("customer", customer);
    }
    
    @Action("get:/customer_show2")
    public Data show2(Param param) {
    	long id = param.getLong("id");
    	Customer customer = customerService.getCustomer(id);
    	return new Data(customer);
    }

    @Action("get:/test2")
    public View test2(Param param) {
    	System.out.println("hello test2222222222222222");
    	return new View ("index.html");
    }

    @Action("get:/customer_create")
    public Data createSubmit(Param param) throws Exception {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }


    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }


    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }


    @Action("delete:/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }

}