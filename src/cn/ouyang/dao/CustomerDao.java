package cn.ouyang.dao;

import cn.ouyang.domain.Customer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import ouyang.tools.bean.CommonUtils;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author oydh
 * @date 2018/10/5 15:48
 * @throws
 */
public class CustomerDao {
    Customer c = new Customer();


    private static Connection getConnection() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream("E:\\IDEAProject\\CustomerDemo\\src\\jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        try {
            dataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取连接出错");
        }
        return connection;
    }

    public void addCustomer(Customer c) {
        QueryRunner qr = new QueryRunner();
        Connection connection = CustomerDao.getConnection();
        String sql = "insert into t_customers (cid,cname,gender,birthday,cellphone,email,description) values (?,?,?,?,?,?,?)";
        Object[] params = {c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getDescription()};
        try {
            qr.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException("插入数据出错");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testAddCustomer() {
        c.setCid(CommonUtils.uuid());
        c.setCname("欧德鸿");
        c.setGender("男");
        c.setCellphone("15274953454");
        addCustomer(c);
    }

    public List<Customer> findAll() {
        QueryRunner qr = new QueryRunner();
        List<Customer> customerList = null;
        String sql = "select * from t_customers";
        Connection connection = CustomerDao.getConnection();
        try {
            customerList = qr.query(connection, sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Test
    public void testFindAll() {
        List<Customer> all = findAll();
        System.out.println(all.toString());
    }

    public void editCustomer(Customer c) {
        QueryRunner qr = new QueryRunner();
        Connection connection = CustomerDao.getConnection();
        String sql = "update t_customers set cname = ?, gender = ?, cellphone = ?, birthday = ?, email = ?, description =? where cid = ?";
        try {
            qr.update(connection, sql, c.getCname(), c.getGender(), c.getCellphone(),
                    c.getBirthday(), c.getEmail(), c.getDescription(), c.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomer(String cid){
        QueryRunner qr = new QueryRunner();
        Connection connection = CustomerDao.getConnection();
        String sql = "select * from t_customers where cid = ?";
        Customer customer = null;
        try {
            customer = qr.query(connection, sql, new BeanHandler<>(Customer.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteCustomer(String cid) {
        QueryRunner qr = new QueryRunner();
        Connection connection = CustomerDao.getConnection();
        String sql = "delete from t_customers where cid = ?";
        try {
            qr.update(connection,sql,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> findCustomers(Customer c) {
        System.out.println(c.toString());
        QueryRunner qr = new QueryRunner();
        Connection connection = CustomerDao.getConnection();
        StringBuilder sql = new StringBuilder("select * from t_customers where 1=1");
        List<String> params = new ArrayList<>();
        List<Customer> customers = null;
        Method[] methods = c.getClass().getDeclaredMethods();
        for (Method m: methods
             ) {
            if (m.getName().startsWith("get")){
                try {
                    System.out.println(m.getName());
                    System.out.println(m.invoke(c)+":invoketest");
                    System.out.println(m.invoke(c)==null);
                    if (m.invoke(c)!=null&&m.invoke(c)!=""){
                        sql.append(" and "+ m.getName().substring(3)+" like ?");
                        params.add("%"+m.invoke(c)+"%");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
       customers = qr.query(connection, sql.toString(), new BeanListHandler<>(Customer.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(sql);
        return customers;
    }

    @Test
    public void testFundCustomers(){
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.setCname("欧阳德鸿");
        c1.setGender("man");
        c2.setCname("dd");
        List<Customer> customers1 = findCustomers(c1);
        //List<Customer> customers2 = findCustomers(c2);
        System.out.println(customers1.toString());
        //System.out.println( customers2.toString());


    }
}
