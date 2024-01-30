package Service;

import org.apache.ibatis.annotations.Param;
import pojo.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    int saveDeliveryAddress(@Param("userId")String userId, @Param("contactName")String contactName, @Param("contactSex")Integer contactSex, @Param("contactTel")String contactTel, @Param("address")String address);
    int updateDeliveryAddress(@Param("daId")Integer daId,@Param("contactName")String contactName,@Param("contactSex")Integer contactSex,@Param("contactTel")String contactTel,@Param("address")String address);
    int removeDeliveryAddress(@Param("daId")Integer daId);
    DeliveryAddress getDeliveryAddressById(@Param("daId")Integer daId);
    List<DeliveryAddress> listDeliveryAddressByUserId(@Param("userId")String userId);
}
