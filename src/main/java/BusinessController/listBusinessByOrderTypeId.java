package BusinessController;

import Service.BusinessService;
import Service.Impl.BusinessServiceImpl;
import JSON.toJson;
import pojo.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BusinessController/listBusinessByOrderTypeId")
public class listBusinessByOrderTypeId extends HttpServlet {

    BusinessService businessService = new BusinessServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer orderTypeId = Integer.parseInt(req.getParameter("orderTypeId"));
        List<Business> businessList = businessService.listBusinessByOrderTypeId(orderTypeId);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        toJson json = new toJson();
        json.ObjectToJson(resp,businessList);
    }
}
