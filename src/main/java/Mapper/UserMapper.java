package Mapper;

import pojo.User;
import org.apache.ibatis.annotations.Param;



public interface UserMapper {
    int saveUser(User user);

    User getUserById(@Param("userId") String userId);

    User getUserByIdByPass(@Param("userId") String userId, @Param("password") String password);

}
