package kr.or.ddit.basic.json;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapclientFactory;
import kr.or.ddit.vo.LprodVO;

public class LprodDao {
	private SqlMapClient smc;
	private static LprodDao dao;
	private LprodDao() {
		smc = SqlMapclientFactory.getSqlMapClient();
	}
	
	public static LprodDao getInstance() {
		if(dao==null) dao = new LprodDao();
		return dao;
	}
	public List<LprodVO> getAllLprod(){
		List<LprodVO>lprodList =null;
		
		try {
			lprodList = smc.queryForList("lprod.getAllLprod");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lprodList;
	}
}
