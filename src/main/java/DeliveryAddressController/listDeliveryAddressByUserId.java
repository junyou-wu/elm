package DeliveryAddressController;

import JSON.toJson;
import Service.DeliveryAddressService;
import Service.Impl.DeliveryAddressServiceImpl;
import pojo.DeliveryAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeliveryAddressController/listDeliveryAddressByUserId")
public class listDeliveryAddressByUserId extends HttpServlet {

    DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        List<DeliveryAddress> deliveryAddressList = deliveryAddressService.listDeliveryAddressByUserId(userId);
        toJson json = new toJson();
        json.ObjectToJson(resp,deliveryAddressList);
    }
}
