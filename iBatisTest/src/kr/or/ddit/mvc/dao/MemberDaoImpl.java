package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapclientFactory;

public class MemberDaoImpl implements IMemberDao{
	private SqlMapClient smc; // SqlMapClient객체 변수 선언( iBatis 처리용 객체)
	//1번
	private static MemberDaoImpl dao;
	//2번
	private MemberDaoImpl() {
		smc = SqlMapclientFactory.getSqlMapClient();
	}
	
	
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0; // 반환값이 저장될 변수
		
		try {
			Object obj = smc.insert("member.insertMember", memVo);
			if(obj==null) cnt = 1;
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("member.memberDelete", memId);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
	
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
	/*	private String mem_id;
		private String mem_pass;
		private String mem_name;
		private String mem_tel;
		private String mem_addr;*/
		
		int cnt = 0; // 반환값이 저장될 변수
		try {
			cnt = smc.update("member.updateMember", memVo);
		}catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
	
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null; // 반환값이 저장될 변수
		try {
			memList = smc.queryForList("member.getAllMember");
			
		} catch (Exception e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
	
		int count = 0; // 반환값이 저장될 변수
		try {
			count = (int) smc.queryForObject("member.getMemberObject", memId);
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		
		int cnt = 0; //반환값 변수
		
		try {
			// Map구조 : key값 ==> 회원ID
			cnt = smc.update("member.updateMember2", paramMap);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}


}
