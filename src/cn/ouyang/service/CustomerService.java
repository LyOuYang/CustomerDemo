package cn.ouyang.service;

import cn.ouyang.dao.CustomerDao;
import cn.ouyang.domain.Customer;
import org.junit.Test;
import ouyang.tools.bean.CommonUtils;

import java.util.List;

/**
 * @author oydh
 * @date 2018/10/5 15:49
 * @throws
 */
public class CustomerService {
    CustomerDao customersDao = new CustomerDao();
    public void addCustomer(Customer c)  {
        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(c);
    }
    @Test
    public void testAddCustomer(){
        Customer c = new Customer();
        c.setCid(CommonUtils.uuid());
        c.setCname("欧阳德鸿");
        c.setGender("男");
        c.setCellphone("15274953454");
        addCustomer(c);
    }

    public List<Customer> findAll() {
        System.out.println(customersDao.findAll().toString()+"service");
        return customersDao.findAll();
    }

    public void editCustomer(Customer customer) {
        customersDao.editCustomer(customer);
    }
    public Customer findCustomer(String cid){
        return customersDao.findCustomer(cid);
    }

    public void deleteCustomer(String cid) {
        customersDao.deleteCustomer(cid);
    }

    public List<Customer> findCustomers(Customer c) {

        System.out.println( c.toString()+"service!!!!!!");
        return customersDao.findCustomers(c);
    }
}
