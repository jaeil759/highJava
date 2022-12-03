package kr.or.ddit.basic;

public class CC {

	public static void main(String[] args) {
		BB b = new BB();
		AA a = new BB();
		
		System.out.println("b.name=" + b.name);
		System.out.println("a.name=" + a.name);
		System.out.println("-------------------------------------------------------");
		
		b.test2();
		a.test2();
		System.out.println("-------------------------------------------------------");
		b.test3();
//		a.test3();
		System.out.println("-------------------------------------------------------");
		
		b.test1();  // 메서드를 오버라이딩하면 무조건 오버라이딩한 메서드가 호출된다.
		a.test1();
		
		BB bb = (BB)a;
	}

}
class AA{
	public String name = "AA";
	
	public void test1() {
		System.out.println(name + "의 test1() 입니다.");
	}
	public void test2() {
		System.out.println(name + "의 test2() 입니다.");
	}
}
class BB extends AA{
	public String name = "BB";
	@Override
	public void test1() {
		System.out.println(name + "의 test1() 입니다");
	}
	public void test3() {
		System.out.println(name + "의 test3() 입니다");
	}
}