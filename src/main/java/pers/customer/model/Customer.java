package pers.customer.model;

import lombok.Data;

/**
 * 客户
 * @author fancy
 */
@Data
public class Customer {

    
    private long id;
    private String name;
    private String contact;
    private String telephone;
    private String email;
    private String remark;

}
