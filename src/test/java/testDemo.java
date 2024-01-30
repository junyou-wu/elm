import Mapper.BusinessMapper;
import Mapper.CartMapper;
import Mapper.UserMapper;
import Service.*;
import Service.Impl.*;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pojo.Business;
import pojo.Cart;

import javax.annotation.Resource;
import java.util.List;

@RunWith(JUnit4.class)
public class testDemo {
    @Resource
    private UserMapper mapper;

    private userService userService = new userServiceImpl();

    @Test
    public void userTest() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        mapper = sqlSession.getMapper(UserMapper.class);
      /* User u = new User();
        u.setUserid("12345673333");
        u.setPassword("123");
        u.setUsername("鸡哥");
        u.setUsersex(1);*/
        //   System.out.println(userService.saveUser(u));
        System.out.println(mapper.getUserByIdByPass("123", "123"));
        // mapper.saveUser(u);
        System.out.println(userService.getUserByIdByPass("123", "123"));

    }

    @Resource
    BusinessMapper businessMapper;

    BusinessService businessService = new BusinessServiceImpl();
    @Test
    public void businessTest() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        businessMapper = sqlSession.getMapper(BusinessMapper.class);
        List<Business> list = businessService.listBusinessByOrderTypeId(1);
        for (Business e:list
             ) {
            System.out.println(e);
        }
    }

    @Resource
    CartMapper cartMapper;

    CartService cartService = new CartServiceImpl();

    @Test
    public void cartTest() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper = sqlSession.getMapper(CartMapper.class);
       /* List<Cart> listCart = cartService.listCart("123");
        for (Cart e:listCart
        ) {
            System.out.println(e);
        }
*/

       // System.out.println(cartMapper.getCartId(0,"123",1));

       // cartService.saveCart(5,"1234",5);

        //cartMapper.updateCart(1,"123",1,2);

        //cartService.updateCart(1,"123",1,3);

        //cartService.removeCart(4,"123456",4);



    }

    @Test
    public void DeliveryAddressTest(){
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        deliveryAddressService.saveDeliveryAddress("123","123",1,"123","123");
    }

    @Test
    public void OrdersTest(){
        OrdersService ordersService = new OrdersServiceImpl();
        ordersService.createOrders("1212",10001,2,12.00);
       // System.out.println(ordersService.listOrdersByUserId("1234"));
        //System.out.println(ordersService.listOrdersDetailetByOrderId(3));
    }

}
