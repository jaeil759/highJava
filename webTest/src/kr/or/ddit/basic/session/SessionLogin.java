package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		
		if("admin".equals(userId) && "1234".equals(pass)) {
			session.setAttribute("loginID", userId);
		}
		
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>session login</title></head>");
		out.println("<body>");
		out.println("<h2>admin님 반갑습니다</h2>");
		out.println("<a href='" + request.getContextPath() + "/basic/session/sessionLogin.jsp'> 로그아웃하기</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
