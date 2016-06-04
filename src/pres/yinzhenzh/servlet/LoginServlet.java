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
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = JdbcOperation.getUserInfo(username);
		if(user.getUsername()!=null && user.getPassword()!=null){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				//�û���½�ɹ�,��session�д�һ����½���
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/WebTaskYzz/index.jsp");
				return;
			}
			response.setHeader( "refresh", "3;url='/WebTaskYzz/login.html'" );
	        out.write( "��������������ת�ص�½ҳ..." );
			return;
		}
		response.setHeader( "refresh", "3;url='/WebTaskYzz/login.html'" );
        out.write( "�û������ڣ��������ת�ص�¼ҳ..." );
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
