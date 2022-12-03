package kr.or.ddit.basic.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// id, password, checkbox값 구하기
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		String chkid = request.getParameter("chkid");
		
		// 우선 cookie객체 생성
		Cookie loginCookie = new Cookie("USERID", userid);
		
		// Check박스는 check된것만  전송된다,
		if(chkid==null) { // 체크박스가 체크되었을 때,,,
			response.addCookie(loginCookie);
		}else {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		if("test".equals(userid) && "1234".equals(pass)) {
			response.addCookie(loginCookie);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
