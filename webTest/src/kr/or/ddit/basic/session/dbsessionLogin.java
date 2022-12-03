package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class DbsessionLogin
 */
@WebServlet("/dbsessionLogin.do")
public class dbsessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		// 읽어온 정보를 VO객체에 저장
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(pass);
		
		//Dao 객체 생성(Service객체가 없어서 Dao객체를 직접 생성...)
		MemberDao dao = MemberDao.getInstance();
		// 세션객체 생성
		HttpSession session = request.getSession();
		//DB에서 회원Id와 pass가 일치하는 회원 정보 검색
		MemberVO loginMemVo = dao.getMember(memVo);
		//로그인 성공 여부 판단
		if(loginMemVo!=null) {
			session.setAttribute("loginMember", loginMemVo);
		}
		response.sendRedirect(request.getContextPath() + "/basic/session/db_sessionLogin.jsp");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
