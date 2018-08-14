package org.westos.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.bean.User;
import org.westos.service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(value = "/register")
public class MyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            //设置编码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            // System.out.println(user);
            //调用业务层
            boolean b= new UserService().addUser(user);
            if(b){
                //如果注册成功跳转到成功页面
                request.getRequestDispatcher("/success.jsp").forward(request,response);

            }else{
                //如果不成功跳转到注册页面继续注册
                request.setAttribute("msg","用户名已经存在，请重新输入");
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
