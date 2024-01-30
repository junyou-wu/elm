package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.OrderDetailet;
import pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    int createOrders(@Param("orderId")Integer orderId,@Param("userId")String userId,@Param("businessId")Integer businessId,@Param("orderDate")String orderDate,@Param("daId") Integer daId,@Param("orderTotal") Double orderTotal);

    List<OrderDetailet> listOrdersDetailetByOrderId(@Param("orderId") Integer orderId);

    List<Orders> listOrdersByUserId(@Param("userId")String userId);

    Orders getOrdersById(@Param("orderId") Integer orderId);

    int selectOrdersMaxId();

    int selectOrderDetailetMaxId();

    int saveOrderDetailet(@Param("odId")Integer odId,@Param("orderId")Integer orderId,@Param("foodId") Integer foodId,@Param("quantity") Integer quantity);
}
