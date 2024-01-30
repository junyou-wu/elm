package Service;

import pojo.Business;

import java.util.List;

public interface BusinessService {

    List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    Business getBusinessById(Integer businessId);
}
