package pers.fancy.customer.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.fancy.customer.model.Customer;
import pers.fancy.frame4j.annotation.Service;
import pers.fancy.frame4j.helper.DatabaseHelper;

/**
 * 提供客户数据服务
 * @author fancy
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        logger.info(sql);
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
