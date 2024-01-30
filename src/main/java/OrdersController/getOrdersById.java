package OrdersController;

import JSON.toJson;
import Service.Impl.OrdersServiceImpl;
import Service.OrdersService;
import pojo.Business;
import pojo.OrderDetailet;
import pojo.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrdersController/getOrdersById")
public class getOrdersById extends HttpServlet {

    OrdersService ordersService = new OrdersServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        Orders res = ordersService.getOrdersById(orderId);
        toJson json = new toJson();
        json.ObjectToJson(resp,res);
    }
}
