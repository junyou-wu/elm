package Mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Business;

import java.util.List;

public interface BusinessMapper {
    List<Business> listBusinessByOrderTypeId(@Param("orderTypeId") Integer orderTypeId);
    Business getBusinessById(@Param("businessId") Integer businessId);
}
