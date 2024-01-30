package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Food;

import java.util.List;

public interface FoodMapper {

    List<Food> listFoodByBusinessId(@Param("businessId") Integer businessId);

    Food getFoodByFoodId(@Param("foodId")Integer foodId);
}
