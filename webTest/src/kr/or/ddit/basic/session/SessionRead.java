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
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Session정보 읽기
		
		// 1. Session 객체 생성하거나 현재 Session정보 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session값 읽어오기 
		// 형식) session객체 변수.getAttribute("key값");
		String testSession = (String)session.getAttribute("testSession");
		String userName = (String)session.getAttribute("userName");
		int age = 0;
		if(session.getAttribute("age")!=null) {
			age = (int)session.getAttribute("age");
		}
		TestMember mem = (TestMember)session.getAttribute("testObj");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>세션읽기</title></head>");
		out.println("<body>");
		out.println("<h3>읽어온 Session정보 출력하기 </h3>");
		
		if(testSession==null) {
			out.println("testSession의 세션값은 없습니다.");
		}else {
			out.println("testSession : " + testSession + "<br>");
		}
		out.println("age : " + age + "<br>");
		
		if(mem==null) {
			out.println("testObj의 세션값은 없습니다.<br>");
		}else {
			out.println("testId : " + mem.getTestId() + "<br>");
			out.println("name : " + mem.getName() + "<br>");
			
			
		}
		out.println("<hr>");
		
		out.println("<h3>Session관련 정보들</h3><br>");
		// 세션id ==> 세션을 구분하기 위한 고유한 값
		out.println("세션 Id : " + session.getId() + "<br>");
		//생성시간 ==> 1970년1월1일부터 경과한 시간으로 표시(밀리세컨트 단위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
		// 가장 최근에 세션에 접근한 시간 ==> 1970년1월1일부터 경과한 시간으로 표시(밀리세컨트 단위)
		out.println("세션에 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
		// 세션 유효시간 ==> (초단위)
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		out.println("<a href='" + request.getContextPath() + "/basic/session/sessionTest.jsp'> 시작문서로 가기</a>");
		
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
