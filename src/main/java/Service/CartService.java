package Service;

import org.apache.ibatis.annotations.Param;
import pojo.Cart;

import java.util.List;

public interface CartService {
    List<Cart> listCart(@Param("userId") String userId);

    List<Cart>listCartByBusinessId(@Param("businessId") Integer businessId);

    int saveCart(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId);

    int updateCart(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId,@Param("quantity") Integer quantity);

    int removeCart(@Param("businessId")Integer businessId,@Param("userId") String userId,@Param("foodId") Integer foodId);
}
