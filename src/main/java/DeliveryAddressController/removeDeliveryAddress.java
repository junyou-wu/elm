package DeliveryAddressController;

import JSON.toJson;
import Service.DeliveryAddressService;
import Service.Impl.DeliveryAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeliveryAddressController/removeDeliveryAddress")
public class removeDeliveryAddress extends HttpServlet {

    DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer daId= Integer.valueOf(req.getParameter("daId"));

        int res = deliveryAddressService.removeDeliveryAddress(daId);

        toJson json = new toJson();
        json.ObjectToJson(resp,res);
    }
}
