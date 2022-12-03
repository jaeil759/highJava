package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	static final Logger logger = Logger.getLogger(DBUtil3.class);
	//1번
	private static MemberDaoImpl dao;
	//2번
	private MemberDaoImpl() {}
	
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성");
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr) values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			logger.debug("preparedStatement객체 생성");
			logger.debug("실행 SQL문 : " + sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			logger.debug("사용 데이터 : [" + memVo.getMem_id() + "," + memVo.getMem_pass() + "," + memVo.getMem_name() + "," + memVo.getMem_tel() + "," + memVo.getMem_addr() + "]");
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공");
		} catch (Exception e) {
			logger.error("작업 실패 : " + e);
			cnt = 0;
			e.printStackTrace();
			
		}finally {
			if(pstmt!=null)try {pstmt.close(); logger.info("PreparedStatement객체 반납..." );}catch(SQLException e) {}
			if(conn!=null)try {conn.close(); logger.info("Connection 객체 반납..." );}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection 객체 생성");
			String sql = "delete from mymember where mem_id = ?";
			logger.info(sql + "sql문 실행");
			pstmt = conn.prepareStatement(sql);
			logger.info(pstmt);
			pstmt.setNString(1, memId);
			logger.debug(memId);
			cnt = pstmt.executeUpdate();
			logger.info(logger);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close(); logger.info("PreparedStatement 객체 닫기"); }catch(SQLException e) {}
			if(conn!=null)try {conn.close(); logger.info("Connection 객체 닫기"); }catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
	/*	private String mem_id;
		private String mem_pass;
		private String mem_name;
		private String mem_tel;
		private String mem_addr;*/
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			cnt = pstmt.executeUpdate();
		}catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVO> memList = null; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성");
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			logger.debug("preparedStatement객체 생성");
			logger.debug("실행 SQL문 : " + sql);
			rs = pstmt.executeQuery();
			memList = new ArrayList<MemberVO>();
			
			while(rs.next()) {
				MemberVO memVo = new MemberVO(); // 1개의 레코드가 저장할 VO객체 생성
				// ResultSet에서 각 컬럼값을 가져와 VO객체에 저장한다.
				memVo.setMem_id(rs.getString("mem_id"));
				logger.debug("가져올 데이터들" + " " +memVo.getMem_id());
				logger.info("가져올 데이터들" + " " +memVo.getMem_id());
				memVo.setMem_pass(rs.getString("mem_pass"));
				logger.debug("가져올 데이터들" + " " +memVo.getMem_pass());
				logger.info("가져올 데이터들" + " " +memVo.getMem_pass());
				memVo.setMem_name(rs.getString("mem_name"));
				logger.debug("가져올 데이터들" + " " +memVo.getMem_name());
				logger.info("가져올 데이터들" + " " +memVo.getMem_name());
				memVo.setMem_tel(rs.getString("mem_tel"));
				logger.debug("가져올 데이터들" + " " + memVo.getMem_tel());
				logger.info("가져올 데이터들" + " " + memVo.getMem_tel());
				memVo.setMem_addr(rs.getString("mem_addr"));
				logger.debug("가져올 데이터들" + " " +memVo.getMem_addr());
				logger.info("가져올 데이터들" + " " +memVo.getMem_addr());
				// 1개의 레코드가 저장된 VO객체를 List에 추가한다.
				memList.add(memVo);
				logger.debug("데이터출력");
				logger.info(memVo);
				
			}
		} catch (Exception e) {
			memList = null;
//			e.printStackTrace();
			logger.error("작업 에러" + e);
		}finally {
			if(rs!=null)try {rs.close(); logger.info("ResultSet객체 반납"); }catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close(); logger.info("PreparedStatement 객체 반납");}catch(SQLException e) {}
			if(conn!=null)try {conn.close(); logger.info("Connection 객체 반납");}catch(SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0; // 반환값이 저장될 변수
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
				
				
			}
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0; //반환값 변수
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set" +  paramMap.get("field")  + "= ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}


}
