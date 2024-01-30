package OrdersController;

import JSON.toJson;
import Service.Impl.OrdersServiceImpl;
import Service.OrdersService;
import pojo.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrdersController/listOrdersByUserId")
public class listOrdersByUserId extends HttpServlet {
    OrdersService ordersService = new OrdersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        List<Orders> ordersList = ordersService.listOrdersByUserId(userId);
        toJson json = new toJson();
        json.ObjectToJson(resp,ordersList);
    }
}
