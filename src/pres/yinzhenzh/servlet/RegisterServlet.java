package pres.yinzhenzh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.yinzhenzh.dao.JdbcOperation;
/**
 * @author yzz-13008082
 * */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username,password);
		PrintWriter out = response.getWriter();
		
		boolean bool = JdbcOperation.addUser(user);
		if(bool){
			response.setHeader( "refresh", "3;url='/WebTaskYzz/login.html'" );
            out.write( "注册成功！三秒后跳转到登录页..." );
			return;
		}
		response.setHeader( "refresh", "3;url='/WebTaskYzz/register.html'" );
        out.write( "注册失败，用户已存在！三秒后跳转回注册页..." );
        return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
