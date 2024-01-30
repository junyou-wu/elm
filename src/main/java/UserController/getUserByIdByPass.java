package UserController;

import pojo.User;
import Service.userService;
import Service.Impl.userServiceImpl;
import JSON.toJson;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserController/getUserByIdByPass")
public class getUserByIdByPass extends HttpServlet {

    userService userservice = new userServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = userservice.getUserByIdByPass(userId,password);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        toJson json = new toJson();
        json.ObjectToJson(resp,user);
    }
}
