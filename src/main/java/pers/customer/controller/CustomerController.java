package pers.customer.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.customer.aspect.ControllerAspect;
import pers.customer.model.Customer;
import pers.customer.service.CustomerService;
import pers.frame4j.annotation.Action;
import pers.frame4j.annotation.Controller;
import pers.frame4j.annotation.Inject;
import pers.frame4j.bean.Data;
import pers.frame4j.bean.Param;
import pers.frame4j.bean.View;

/**
 * 处理客户管理相关请求
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
        return new View("customer_show.jsp").addModel("customer", customer);
    }
    
    @Action("get:/customer_show2")
    public Data show2(Param param) {
    	long id = param.getLong("id");
    	Customer customer = customerService.getCustomer(id);
    	return new Data(customer);
    }
    
    @Action("post:/test")
    public View test(Param param) {
    	System.out.println("hello test2222");
    	return new View ("test.html");
    }
    
    @Action("get:/test2")
    public View test2(Param param) {
    	System.out.println("hello test2222222222222222");
    	return new View ("index.html");
    }
    
    @Action("put:/test3")
    public View test3(Param param) {
    	System.out.println("hello test3");
    	return new View("test.html");
    }
    /**
     * 进入 创建客户 界面
     */
    @Action("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    /**
     * 处理 创建客户 请求
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param) {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入 编辑客户 界面
     */
    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理 编辑客户 请求
     */
    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理 删除客户 请求
     */
    @Action("delete:/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}