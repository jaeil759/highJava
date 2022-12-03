package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.vo.LprodVO;

/**
 * Servlet implementation class LprodListController
 */
@WebServlet("/lprodListController2.do")
public class LprodListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LprodDao lprodDao = LprodDao.getInstance();
		
		
		List<LprodVO> lprodList = lprodDao.getAllLprod();
		
		request.setAttribute("lprodList", lprodList);
		RequestDispatcher rd = request.getRequestDispatcher("/basic/json/lprodList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
