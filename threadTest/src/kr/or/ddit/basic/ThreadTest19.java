package kr.or.ddit.basic;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox box = new DataBox();
		ProducerThread th1 = new ProducerThread(box);
		ConsumerThread th2 = new ConsumerThread(box);
		
		th1.start();
		th2.start();
	}

}

//  데이터를
class ProducerThread extends Thread{
	private DataBox databox;
	private String[] data;
	
	public ProducerThread(DataBox databox) {
		data = new String[] {"대전시", "서울시", "인천시"};
		this.databox = databox;
	}
	@Override
	public void run() {
		for(int i = 0; i < data.length; i++) {
			databox.setData(data[i]);
		}
	}	
}

// 데이터를 꺼내서 사용하는 쓰레드
class ConsumerThread extends Thread{
	private DataBox databox;

	public ConsumerThread(DataBox databox) {
		this.databox = databox;
	}
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
	String data = databox.getData();
		}
	}

}

// 데이터를 공통으로 사용하는 클래스
class DataBox{
	private String data;

	/*
	 * data변수의 값이 null 이면 data변수에 문자열이 채워질 때까지 기다리고
	 * data변수에 값이 있으면 해당 문자열을 반환한다.
	 * 이때 반환된 data변수값은 다시 null로 만든다.
	 */
	public synchronized String getData() {
		if(data==null) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}

		String temp = data;
		System.out.println("쓰레드가 읽어 간 데이터 : " + temp);

		data = null;

		notify();

		return temp;
	}

	/*
	 * this.data변수에 값이 있으면 this.data가 null이 될 때까지 기다린다.
	 * this.data변수의 값이 null이되면 새로운 data값을 저장한다.
	 * 
	 */

	public synchronized void setData(String data) {
		if(this.data !=null) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		this.data = data;
		System.out.println("Thread에서 새로 저장된 데이터 : " + data);
		notify();

	}



}