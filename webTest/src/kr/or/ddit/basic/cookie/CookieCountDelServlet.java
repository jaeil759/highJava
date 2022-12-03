package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		
		// 쿠키에서 count라는 key값 찾기
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				if("count".equals(name)) {
					// 쿠키 삭제하기...
					cookie.setMaxAge(0); // 유지시간을 0 으로 셋팅
					response.addCookie(cookie);
					break;
				}
			}
				
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 카운트</title></head>");
		out.println("<body>");
		out.println("<h3>카운트가 초기화 되었습니다.</h3><br><br>");
		out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'> 시작문서로 가기</a>");
		out.println("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
