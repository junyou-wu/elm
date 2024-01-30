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

@WebServlet("/CartController/saveCart")
public class saveCart extends HttpServlet {

    CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");

        Integer businessId = Integer.parseInt(req.getParameter("businessId"));
        String userId = req.getParameter("userId");
        Integer foodId = Integer.parseInt(req.getParameter("foodId"));

        int jsons = cartService.saveCart(businessId,userId,foodId);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        toJson json = new toJson();
        json.ObjectToJson(resp,jsons);
    }
}
