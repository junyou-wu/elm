package CartController;

import JSON.toJson;
import Service.CartService;
import Service.Impl.CartServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CartController/listCart")
public class listCart extends HttpServlet {

    CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");

        List<Cart> listCart = cartService.listCart(userId);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        toJson json = new toJson();
        json.ObjectToJson(resp,listCart);
    }
}
