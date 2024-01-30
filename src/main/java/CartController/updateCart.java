package CartController;

import JSON.toJson;
import Service.CartService;
import Service.Impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CartController/updateCart")
public class updateCart extends HttpServlet {

    CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer businessId = Integer.parseInt(req.getParameter("businessId"));
        String userId = req.getParameter("userId");
        Integer foodId = Integer.valueOf(req.getParameter("foodId"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));

        int jsons = cartService.updateCart(businessId,userId,foodId,quantity);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        toJson json = new toJson();
        json.ObjectToJson(resp,jsons);
    }
}
