package kr.or.ddit.basic.fileupload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

/**
 * Servlet implementation class FileListController
 */
@WebServlet("/fileList.do")
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에서 파일 정보를 List로 가져와 view로 보내는 servlet
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		
		// DB에서 파일 목록을 가져와 List에 담는다
		List<FileInfoVO>fileList = service.getAllFileinfo();
		
		// 가져온 파일 목록을 Request객체에 저장한다.
		request.setAttribute("fileList", fileList);
		
		// View페이지로 forwarding한다.
		request.getRequestDispatcher("/basic/fileupload/fileList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
