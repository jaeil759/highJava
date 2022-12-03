package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapclientFactory;

public class JdbcToIbatisTest {
// JdbcTest05.java를 iBatis용으로 변환
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SqlMapClient smc = null;
				try {
					Charset charset = Charset.forName("utf-8");
					Resources.setCharset(charset);
					
					Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
					
					smc = SqlMapClientBuilder.buildSqlMapClient(rd);
					rd.close();
					
					smc = SqlMapclientFactory.getSqlMapClient();
				} catch (Exception e) {
					// TODO: handle exception
				}
	}

}
