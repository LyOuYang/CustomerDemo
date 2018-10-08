package test;

import cn.ouyang.domain.Customer;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
/**
 * @author oydh
 * @date 2018/10/6 11:06
 * @throws
 */
public class MapToBean {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Customer c = new Customer();
        map.put("cname", "123");
        try {
            BeanUtils.populate(c,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(c.toString());
    }
}
