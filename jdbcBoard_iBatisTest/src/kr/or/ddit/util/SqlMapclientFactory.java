package kr.or.ddit.util;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SqlMapclientFactory {
	
	private static SqlMapClient smc;
		static {
			try {
				Charset charset = Charset.forName("utf-8");
				Resources.setCharset(charset);
				
				Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
				
				
				rd.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static SqlMapClient getSqlMapClient() {
			return smc;
		}
	}
	


