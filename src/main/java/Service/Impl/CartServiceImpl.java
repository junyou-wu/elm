package Service.Impl;

import Mapper.CartMapper;
import Mapper.FoodMapper;
import Service.CartService;
import Service.FoodService;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Cart;
import pojo.Food;

import javax.annotation.Resource;
import java.util.List;

public class CartServiceImpl implements CartService {
    @Resource
    CartMapper cartMapper;

    FoodService foodService = new FoodServiceImpl();

    @Override
    public List<Cart> listCartByBusinessId(Integer businessId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper=sqlSession.getMapper(CartMapper.class);
        return cartMapper.listCartByBusinessId(businessId);
    }

    @Override
    public List<Cart> listCart(String userId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper=sqlSession.getMapper(CartMapper.class);

        List<Cart> cartList = cartMapper.listCart(userId);

        for (Cart c:cartList
             ) {
            Food f = foodService.getFoodByFoodId(c.getFoodId());
            c.setFood(f);
        }

        return cartList;
    }

    @Override
    public int saveCart(Integer businessId, String userId, Integer foodId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper=sqlSession.getMapper(CartMapper.class);
        Integer cartId = cartMapper.selectMaxId() + 1;

        if(cartMapper.getCartId(businessId,userId,foodId) != null){
            return 0;
        }else{
            cartMapper.saveCart(cartId,businessId,userId,foodId);
            return 1;
        }

    }

    @Override
    public int updateCart(Integer businessId, String userId, Integer foodId, Integer quantity) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper=sqlSession.getMapper(CartMapper.class);
        cartMapper.updateCart(businessId,userId,foodId,quantity);
        return 1;
    }

    @Override
    public int removeCart(Integer businessId, String userId, Integer foodId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        cartMapper=sqlSession.getMapper(CartMapper.class);

        return cartMapper.removeCart(businessId,userId,foodId);

    }
}
