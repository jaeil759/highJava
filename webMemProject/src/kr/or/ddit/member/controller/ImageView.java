package kr.or.ddit.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

// 이미지 파일을 읽어오는 Servlet
@WebServlet("/images/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memId = request.getParameter("memID");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO memvo = service.getMember(memId);
		
		String fileName = memvo.getMem_photo();
		if(fileName==null) {
			fileName = "noImage.png";
		}
		String imagePath = "D:/D_other/uploadFiles";
		
		
		String imageFilePath = imagePath + File.separator + fileName;

		File file = new File(imageFilePath);

		if (file.exists()) {
			// 출력용 스트림 객체 생성 ==> response객체 이용
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			// 파일 입력용 스트림 객체 생성
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] buffer = new byte[1024];
			int len = -1;

			// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림 객체로 출력한다.
			while ((len = bis.read(buffer)) > 0 ) {
				bos.write(buffer, 0, len);
			}
			
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
