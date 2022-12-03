package kr.or.ddit.basic.session;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapclientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDao {
	private SqlMapClient smc;
	
	private static MemberDao dao;
	
	private MemberDao() {
		smc = SqlMapclientFactory.getSqlMapClient();
		
	}
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao(); 
			return dao;
	}
	
	/**
	 * 회원 ID와 Password가 저장된 MemberVO객체를 인수값으로 받아서 해당 회원 정보를 반환하는 메서드
	 * @param memVo 검색할 회원ID와 Password가 저장된 MemberVO객체
	 * @return 검색성공 : 회원 정보가 저장된 MemberVO객체, 검색실패 : null
	 */
	
	
	public MemberVO getMember(MemberVO memVo) {
		MemberVO loginMemberVo = null;
		try {
			loginMemberVo = (MemberVO) smc.queryForObject("member.getMember", memVo);
		} catch (Exception e) {
			System.out.println(smc);
			System.out.println(loginMemberVo);
			e.printStackTrace();
		}
		return loginMemberVo;
	}
}
