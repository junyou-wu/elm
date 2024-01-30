package Service.Impl;

import Service.userService;
import pojo.User;
import Mapper.UserMapper;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;


import javax.annotation.Resource;

public class userServiceImpl implements userService {
    @Resource
    public UserMapper userMapper;


    @Override
    public int saveUser(User user){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
        if(getUserById(user.getUserId()) == 0) {
            userMapper.saveUser(user);
            return 1;
        }
        return 0;
    }

    @Override
    public int getUserById(String userId){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
        if(userMapper.getUserById(userId) != null){
            return 1;
        }
    return 0;
    }

    @Override
    public User getUserByIdByPass(String userId, String password) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user =  userMapper.getUserByIdByPass(userId,password);
        return user;
    }
}
