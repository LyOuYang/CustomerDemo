package cn.ouyang.servlet;


import cn.ouyang.domain.Customer;
import cn.ouyang.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;
import ouyang.tools.bean.CommonUtils;
import ouyang.tools.servletutils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author oydh
 * @date 2018/10/5 16:15
 * @throws
 */
@WebServlet(name = "CustomerServlet",urlPatterns = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {
    CustomerService customerService = new CustomerService();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        super.service(req, resp);

    }

    public String addCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Customer c = new Customer();
        try {
            BeanUtils.populate(c,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        c.setCid(CommonUtils.uuid());
        req.setAttribute("message","恭喜添加成功");
        customerService.addCustomer(c);
        System.out.println(c.toString()+"addCustomer");
        return "f:/message.jsp";
    }

    public String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customersList = customerService.findAll();
        req.setAttribute("customersList",customersList);
        return "f:/list.jsp";
    }

    public String deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerService.deleteCustomer(req.getParameter("cid"));
        req.setAttribute("message","删除成功");
        return "f:message.jsp";
    }

    public String editCustomer(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        System.out.println("到机房东兰复赛扽龙蛋法撒旦发送到了凡所担负；三戴森囧但凡撒； 三代繁琐的；");
        Customer c = new Customer();
        req.getParameterMap();
        try {
            BeanUtils.populate(c,req.getParameterMap());
            req.setAttribute("message","编辑成功");
        } catch (IllegalAccessException e) {
            req.setAttribute("message","访问权限出错");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            req.setAttribute("message","数据查询语句或参数存在问题");
            e.printStackTrace();
        }
        System.out.println("req.getParameter: "+req.getParameter("cid"));
        c.setCid(req.getParameter("cid"));
        customerService.editCustomer(c);
        System.out.println(c.toString()+"editCustomer");
        req.setAttribute("message","添加成功");
        return "f:message.jsp";
    }

    public String preEditCustomer(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Customer c = customerService.findCustomer(req.getParameter("cid"));
        req.setAttribute("customer",c);
        return "f:edit.jsp";
    }

    public String findCustomers(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        Customer c = new Customer();
        try {
            BeanUtils.populate(c,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(c.toString()+"||||||||||");
        List<Customer> customersList = customerService.findCustomers(c);
        for (Customer cc:customersList
             ) {
            System.out.println(cc.toString()+"hahahahahahhaha");
        }
        req.setAttribute("customersList",customersList);
        return "f:list.jsp";
    }
}
