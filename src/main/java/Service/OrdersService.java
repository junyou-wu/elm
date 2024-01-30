package Service;

import org.apache.ibatis.annotations.Param;
import pojo.OrderDetailet;
import pojo.Orders;

import java.util.List;

public interface OrdersService {
    int createOrders(@Param("userId")String userId, @Param("businessId")Integer businessId, @Param("daId") Integer daId, @Param("orderTotal") Double orderTotal);

    List<Orders> listOrdersByUserId(@Param("userId")String userId);

    List<OrderDetailet> listOrdersDetailetByOrderId(@Param("orderId") Integer orderId);

    Orders getOrdersById(@Param("orderId") Integer orderId);


}
