package kr.or.ddit.basic.fileupload.dao;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapclientFactory;
import kr.or.ddit.vo.FileInfoVO;
import sun.security.jca.GetInstance;

public class FileInfoDaoImpl implements IFileInfoDao{
	private SqlMapClient smc;
	
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl() {
		smc = SqlMapclientFactory.getSqlMapClient();
		
	}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao==null ) dao= new FileInfoDaoImpl();
		return dao;
	}

	@Override
	public int insertFileinfo(FileInfoVO fileinfoVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("fileinfo.insertFileInfo", fileinfoVo);
			if(obj == null) cnt = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		List<FileInfoVO> fileList = null;
		try {
			fileList = smc.queryForList("fileinfo.getAllFileinfo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileList;
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		FileInfoVO fileVo = null;
		try {
			fileVo = (FileInfoVO) smc.queryForObject("fileinfo.getFileinfo", fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileVo;
	}
	
}
