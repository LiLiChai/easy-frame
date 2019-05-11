package pers.fancy.customer.service;

import java.io.UnsupportedEncodingException;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.fancy.customer.model.Customer;
import pers.fancy.frame4j.annotation.Service;
import pers.fancy.frame4j.annotation.Transaction;
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
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap) throws Exception {

        fieldMap = new HashMap<>(0);
        fieldMap.put("id", UUID.randomUUID().toString().substring(0,8));
        fieldMap.put("name", "NAME" + new Random().nextLong());

        try {
            fieldMap.put("contact", new String ("王自强".getBytes(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.equals(e.toString());
        }
        fieldMap.put("telephone", "19983163458");
        fieldMap.put("email", "SmartShuShu@163.com");
        fieldMap.put("remark", 1);
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if (result){
            throw new Exception("erro");
        }
        return result;
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
    @Transaction
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
