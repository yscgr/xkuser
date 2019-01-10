package com.xk.servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xk.model.User;
import com.xk.service.UserService;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		//从login.jsp页面获取登录用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//创建userService类，业务逻辑类
		UserService userService = new UserService();
		//封装user，登录对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//验证登录是否合法
		if(userService.checkUser(user)) {
		//合法，则从数据库中取出全体数据,植入request的attribute域中，页面跳转到main.jsp
			ArrayList<User> allUsers = userService.getAllUsers();
			request.setAttribute("allUsers", allUsers);
			request.setAttribute("user", username);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else {
		//非法，则重新定位到登录页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}
}
