package Service;

import Mapper.FoodMapper;
import org.apache.ibatis.annotations.Param;
import pojo.Food;

import javax.annotation.Resource;
import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(@Param("businessId") Integer businessId);

    Food getFoodByFoodId(@Param("foodId")Integer foodId);
}
