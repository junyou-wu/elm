package Service.Impl;

import Mapper.CartMapper;
import Mapper.OrdersMapper;
import Service.BusinessService;
import Service.CartService;
import Service.FoodService;
import Service.OrdersService;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cart;
import pojo.OrderDetailet;
import pojo.Orders;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public List<OrderDetailet> listOrdersDetailetByOrderId(Integer orderId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        return ordersMapper.listOrdersDetailetByOrderId(orderId);
    }

    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        int orderId = ordersMapper.selectOrdersMaxId()+1;
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String orderDate = ft.format(dNow);

        CartService cartService = new CartServiceImpl();
        List<Cart> list = cartService.listCartByBusinessId(businessId);
        for (Cart c:list
             ) {
            int odId = ordersMapper.selectOrderDetailetMaxId() + 1;
            ordersMapper.saveOrderDetailet(odId,orderId,c.getFoodId(),c.getQuantity());
        }
        ordersMapper.createOrders(orderId,userId,businessId,orderDate,daId,orderTotal);
        return orderId;
    }

    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.listOrdersByUserId(userId);
        BusinessService businessService = new BusinessServiceImpl();
        for (Orders o:ordersList
             ) {
            List<OrderDetailet> orderDetailetList = ordersMapper.listOrdersDetailetByOrderId(o.getOrderId());
            FoodService foodService = new FoodServiceImpl();
            for (OrderDetailet od:orderDetailetList
            ) {
                od.setFood(foodService.getFoodByFoodId(od.getFoodId()));
            }
            o.setBusiness(businessService.getBusinessById(o.getBusinessId()));
            o.setList(orderDetailetList);
        }
        return ordersList;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        Orders orders = ordersMapper.getOrdersById(orderId);
        List<OrderDetailet> orderDetailetList = ordersMapper.listOrdersDetailetByOrderId(orderId);
        FoodService foodService = new FoodServiceImpl();
        for (OrderDetailet o:orderDetailetList
             ) {
            o.setFood(foodService.getFoodByFoodId(o.getFoodId()));
        }
        BusinessService businessService = new BusinessServiceImpl();
        orders.setBusiness(businessService.getBusinessById(orders.getBusinessId()));
        orders.setList(orderDetailetList);
        return orders;
    }
}
