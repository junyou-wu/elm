package BusinessController;

import JSON.toJson;
import Service.BusinessService;
import Service.Impl.BusinessServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BusinessController/getBusinessById")
public class getBusinessById extends HttpServlet {
    BusinessService businessService = new BusinessServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer businessId = Integer.valueOf(req.getParameter("businessId"));
        Business business = businessService.getBusinessById(businessId);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        toJson json = new toJson();
        json.ObjectToJson(resp,business);
    }
}
