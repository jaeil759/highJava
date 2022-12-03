package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.SqlMapclientFactory;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	private SqlMapClient smc;
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() { 
		smc = SqlMapclientFactory.getSqlMapClient();
	}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}
	

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
	
		List<JdbcBoardVO> boardList = null;  // 반환값이 저장될 변수
		
		try {	
			boardList = smc.queryForList("board.getAllBoardList");
		} catch (Exception e) {
			boardList = null;
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("board.insertBoard",boardVo);
			if(obj==null) cnt= 1;
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
	
		int cnt = 0;
		
		try {
			cnt = smc.update("board.updateBoard", boardVo);
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
	
		JdbcBoardVO boardVo = null;
		
		try {
			boardVo = (JdbcBoardVO) smc.queryForObject("boad.getBoard", boardNo);
		} catch (Exception e) {
			boardVo = null;
			e.printStackTrace();
		}
		return boardVo;
	}

	@Override
	public int deleteBoard(int boardNo) {
	
		int cnt = 0;
		
		try {
			cnt = smc.delete("board.deleteBoard", boardNo);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		
		List<JdbcBoardVO> boardList = null;
		
		try {
			boardList = smc.queryForList("board.getSearchBoardList", title);	
		} catch (Exception e) {
			boardList = null;
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
	
		int cnt = 0;
		
		try {
			cnt = smc.update("board.setCountIncrement",boardNo);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}
	

}
