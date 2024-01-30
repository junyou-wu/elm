package Service.Impl;

import Mapper.CartMapper;
import Mapper.FoodMapper;
import Service.FoodService;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Food;

import javax.annotation.Resource;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    @Resource
    FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        foodMapper=sqlSession.getMapper(FoodMapper.class);
        return foodMapper.listFoodByBusinessId(businessId);
    }

    @Override
    public Food getFoodByFoodId(Integer foodId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        foodMapper=sqlSession.getMapper(FoodMapper.class);
        return foodMapper.getFoodByFoodId(foodId);
    }
}
