package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
	
		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("일지매");
		p2.setNum(1);
		p2.setName("홍길동");
	
		Person p3 = p1;
		System.out.println();
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
//		System.out.println(p1==p3);
//		System.out.println(p1.equals(p3));
		System.out.println("------------------------------------------------");
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("Set의 크기 : " + testSet.size());
		
		System.out.println("p1 ==> " + p1.hashCode());
		System.out.println("p2 ==> " + p2.hashCode());
		System.out.println("p3 ==> " + p3.hashCode());
		
		/*
		 *  - equals() 메서드 ==> 두 객체의 내용이 같은지 검사하는 메서드
		 *  - hashCode() 메서드 ==> 두 객체의 동일성을 검사하는 메서드
		 *  
		 *  HashSet, Hashtable, HashMap 과 같이 Hash로 시작하는 컬렉션 객체들은
		 *  객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출해서 비교한다.
		 *  그러므로, 객체가 같은지 여부를 결정하려면 equals() 메서드와 hashCode() 메서드를 모두 재정의 해야한다.
		 *  
		 *  
		 */
		
}

}
class Person{
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
/*	@Override
	public boolean equals(Object obj) {
		if(obj ==null) return false;
		
		if(this.getClass() != obj.getClass()) { //같은 유형의 클래스인지 검사
			return false;
		}
		if(this==obj) { // 참조값이 같은지 검사
			return true;
		}
		Person that = (Person)obj; // 매개변수의 값을 현재 객체 유형으로 형변환한다.
		
		if(this.name==null && that.name !=null) {
			return false;
		}
		if(this.num == that.num && this.name.equals(that.name)) {
			return true;
		}
		return false;
	}
	*/
}