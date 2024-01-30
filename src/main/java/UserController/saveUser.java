package UserController;

import JSON.toJson;
import pojo.User;
import Service.userService;
import Service.Impl.userServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserController/saveUser")
public class saveUser extends HttpServlet {

   userService userservice = new userServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        int userSex= Integer.parseInt(req.getParameter("userSex"));

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSex(userSex);
        int jsons = userservice.saveUser(user);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        toJson json = new toJson();
        json.ObjectToJson(resp,jsons);





    }
}
