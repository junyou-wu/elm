package FoodController;

import Service.FoodService;
import Service.Impl.FoodServiceImpl;
import JSON.toJson;

import pojo.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/FoodController/listFoodByBusinessId")
public class listFoodByBusinessId extends HttpServlet {
    FoodService foodService = new FoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer businessId = Integer.parseInt(req.getParameter("businessId"));
        List<Food> foodList = foodService.listFoodByBusinessId(businessId);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        toJson json = new toJson();
        json.ObjectToJson(resp,foodList);
    }
}
