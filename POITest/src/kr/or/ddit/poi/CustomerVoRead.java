package kr.or.ddit.poi;

public class CustomerVoRead { //엑셀 파일의 칼럼 항목과 동일하게 구성된 VoRead
	//컬럼명--------------------------------------------
	private String  custId;		//고객ID
	private String  custName;	//고객명
	private String	custAge;	//고객나이
	private String	custEmail;	//고객이메일
	//--------------------------------------------------
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAge() {
		return custAge;
	}
	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Override
	public String toString() {
		return "ID : " + custId + ", NAME : " + custName + ", AGE : " + custAge + ", EMAIL : "
				+ custEmail;
	}
	
}
