package OrdersController;

import JSON.toJson;
import Service.Impl.OrdersServiceImpl;
import Service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrdersController/createOrders")
public class createOrders extends HttpServlet {

    OrdersService ordersService = new OrdersServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        Integer businessId = Integer.valueOf(req.getParameter("businessId"));
        Integer daId = Integer.valueOf(req.getParameter("daId"));
        Double orderTotal = Double.valueOf(req.getParameter("orderTotal"));

        int res = ordersService.createOrders(userId,businessId,daId,orderTotal);
        toJson json = new toJson();
        json.ObjectToJson(resp,res);
    }
}
