package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class LogTest {
	// logger 객체 생성 ==> 현재 클래스명을 인수값으로 넣어서 생성한다.
	static Logger logger = Logger.getLogger(LogTest.class);
	public static void main(String[] args) {
		// 로그 레벨 ==> trace, debug, info, warn, error, fatal
		// 로그 기록을 남기는 방법
		// 형식1) logger객체.레벨명("출력할 메세지");
		// 형식2) logger객체.log(level.로그레벨, "출력할 메시지");
		
		logger.trace("이것은 Trace레벨의 메세지 입니다...");
		logger.debug("이것은 debug레벨의 메세지 입니다...");
		logger.info("이것은 info레벨의 메세지 입니다...");
		logger.warn("이것은 warn레벨의 메세지 입니다...");
		logger.error("이것은 error레벨의 메세지 입니다...");
		logger.fatal("이것은 fatal레벨의 메세지 입니다...");
		
	}

}
