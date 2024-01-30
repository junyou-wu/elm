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

@WebServlet("/DeliveryAddressController/saveDeliveryAddress")
public class saveDeliveryAddress extends HttpServlet {

    DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String contactName = req.getParameter("contactName");
        Integer contactSex = Integer.valueOf(req.getParameter("contactSex"));
        String contactTel = req.getParameter("contactTel");
        String address = req.getParameter("address");

        int res = deliveryAddressService.saveDeliveryAddress(userId,contactName,contactSex,contactTel,address);
        toJson json = new toJson();
        json.ObjectToJson(resp,res);
    }
}
