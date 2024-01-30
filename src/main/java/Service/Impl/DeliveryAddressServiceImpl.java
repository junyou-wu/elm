package Service.Impl;

import Mapper.DeliveryAddressMapper;
import Service.DeliveryAddressService;
import Utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import pojo.DeliveryAddress;

import javax.annotation.Resource;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Resource
    DeliveryAddressMapper deliveryAddressMapper;
    @Override
    public int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deliveryAddressMapper=sqlSession.getMapper(DeliveryAddressMapper.class);

        Integer MaxId = deliveryAddressMapper.selectMaxId() + 1;

        deliveryAddressMapper.saveDeliveryAddress(MaxId,userId,contactName,contactSex,contactTel,address);

        return 1;
    }

    @Override
    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deliveryAddressMapper=sqlSession.getMapper(DeliveryAddressMapper.class);

        deliveryAddressMapper.updateDeliveryAddress(daId,contactName,contactSex,contactTel,address);
        return 1;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deliveryAddressMapper=sqlSession.getMapper(DeliveryAddressMapper.class);

        deliveryAddressMapper.removeDeliveryAddress(daId);
        return 1;
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deliveryAddressMapper=sqlSession.getMapper(DeliveryAddressMapper.class);
        return deliveryAddressMapper.getDeliveryAddressById(daId);
    }

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        deliveryAddressMapper=sqlSession.getMapper(DeliveryAddressMapper.class);
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }
}
