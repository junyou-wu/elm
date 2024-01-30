package Service.Impl;

import Mapper.BusinessMapper;
import Mapper.UserMapper;
import Service.BusinessService;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.Business;

import javax.annotation.Resource;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    @Resource
    public BusinessMapper businessMapper;
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        businessMapper = sqlSession.getMapper(BusinessMapper.class);

        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        businessMapper = sqlSession.getMapper(BusinessMapper.class);

        return businessMapper.getBusinessById(businessId);
    }
}
