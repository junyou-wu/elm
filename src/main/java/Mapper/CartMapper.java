package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Cart;

import java.util.List;

public interface CartMapper {

    List<Cart> listCart(@Param("userId") String userId);

    List<Cart>listCartByBusinessId(@Param("businessId") Integer businessId);

    int saveCart(@Param("cartId") Integer cartId,@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId);

    Integer selectMaxId();

    Cart getCartId(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId);

    int updateCart(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId,@Param("quantity") Integer quantity);

    int removeCart(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId);
}
