package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setCharacterEncoding("utf-8");
//		int n1 = Integer.parseInt(request.getParameter("number1"));
//		int n2 = Integer.parseInt(request.getParameter("number2"));
//		
//		String op = request.getParameter("operator");
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><head><meta charset='utf-8'><title>ㅋㅋㅋ</title></head>");
//		out.println("<body>");
//		out.println("<h2>계산 결과</h2>");
//		out.println("<br><hr>");
//		out.println(n1 + " " + op + " " + n2 + " = ");
//		 
//		if(op.equals("+")) {
//			out.println((double)n1 + n2);
//		}else if(op.equals("-")) {
//			out.println((double)n1 - n2);
//		}else if(op.equals("*")) {
//			out.println((double)n1 * n2);
//		}else if(op.equals("/")) {
//			out.println((double)n1 / n2);
//		}
		
		
		//방법2
//		request.setCharacterEncoding("utf-8");
//		String strNum1 = request.getParameter("num1");
//		String strNum2 = request.getParameter("num2");
//		String op = request.getParameter("op");
//		
//		int num1 = Integer.parseInt(strNum1);
//		int num2 = Integer.parseInt(strNum2);
//		
//		double result = 0;   // 계산된 결과가 저장될 변수 선언
//		
//		boolean clacOK = true;	// 계산 성공 여부가 저장될 변수
//		
//		switch(op) {
//		case"+" : result = num1+num2; break;
//		case"-" : result = num1-num2; break;
//		case"*" : result = num1*num2; break;
//		case"/" : result = if(num2!=0) {
//					result = (double)num1/num2;
//				}else {
//					clacOK = false;
//					break;
//				}
//				
//		case"%" : if(num2!=0) {
//			result = num1%num2;
//		}else {
//			clacOK = false;
//		}
//		break;
//		
//		if(num2!=0) {
//			result = (double)num1/num2;
//		}else {
//			clacOK = false;
//		}
//		break;
//		
//		}
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><head><meta charset='utf-8'><title>Request객체 연습</title></head>");
//		out.println("<body>");
//		out.println("<h3>계산결과</h3><hr>");
////		out.printf("%d %s %d = %.2f<br>", num1, op, num2, result );
//		out.printf("%d %s %d = ", num1,op,num2);
//		out.println("</body></html>");
//		
	}

}
