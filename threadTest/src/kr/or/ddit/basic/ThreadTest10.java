package kr.or.ddit.basic;

/*
 * 	10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
 * 	
 * 	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는 말이름(String), 등수(int), 현재위치(int) 를
 * 	멤버변수로 갖는다. 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.(Comparable구현)
 * 
 * 	경기 구간은 1~50 구간으로 되어 있다.
 * 
 * 	경기 중간에 각 말들의 위치를 다음과 같이 나타내시오.
 * 	예) 
 * 	01번말 : ---------------->------------------------
 * 	02번말 : ------->---------------------------------
 * 	03번말 : ------------------------>----------------
 * 	....
 * 	10번말 : ->---------------------------------------
 * 
 * 	경기가 끝나면 등수 순으로 출력한다.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreadTest10 {
	public static void main(String[] args) {
		Horse[] horses = new Horse[] {
				new Horse("01번말"),	
				new Horse("02번말"),	
				new Horse("03번말"),	
				new Horse("04번말"),	
				new Horse("05번말"),	
				new Horse("06번말"),	
				new Horse("07번말"),	
				new Horse("08번말"),	
				new Horse("09번말"),	
				new Horse("10번말")	
		};
		GameState gs = new GameState(horses);
		for(Horse h : horses) {
			h.start();
		}
		gs.start();
		
		for(Horse h : horses) {
			try {
				h.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		try {
			gs.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 끝........");
		System.out.println();
		
		
		//등수의 오름차순으로 정렬
		Arrays.sort(horses);
		for(Horse h : horses) {
			System.out.println(h);
		}
	}
	
}

// 말들의 현재 위치를 나타낸 쓰레드
class GameState extends Thread{
	private Horse[] horses;

	public GameState(Horse[] horses) {
		this.horses = horses;
	}
	@Override
	public void run() {
		while(true) {
			// 모든 말들의 경주가 끝나면 이 반복문을 탈출한다.
			if(Horse.currentRank==horses.length) {
				break;
			}
			for(int i = 1; i < 15; i++) {
				System.out.println();
			}
			
			
			for(int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for(int j = 1; j<=50; j++) {
					if(j == horses[i].getLocation()) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
				}	//for문j
				System.out.println(); // 줄바꿈
			}//for문 i
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}




class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; // 말들의 현재 등수를 구할 때 사용할 변수
	private String horseName;	//말이름
	private int rank;			//등수
	private int location;		//위치

	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + " 은(는)" + rank + " 등 입니다.";
	}

	//등수의 오름차순 정렬의 기준을 설정한다.
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(rank, horse.getRank());
	}
	@Override
	public void run() {
		// 1~50 구간을 진행시키고, 각 단계에서 말의 현재위치를 구간값으로 변경한다.
		for(int i = 1; i<=50; i++) {
			this.location = i;

			try {
				Thread.sleep((int)(Math.random() * 400));
			} catch (Exception e) {

			}
		}
		// 한마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
		currentRank++;
		this.rank = currentRank;
	}
}





















// 내꺼
//	static int strRank = 1;
//
//	public static void main(String[] args) {
//		List<Horse> list = new ArrayList<>();
//
//		list.add(new Horse("1번마"));
//		list.add(new Horse("2번마"));
//		list.add(new Horse("3번마"));
//		list.add(new Horse("4번마"));
//		list.add(new Horse("5번마"));
//		list.add(new Horse("6번마"));
//		list.add(new Horse("7번마"));
//		list.add(new Horse("8번마"));
//		list.add(new Horse("9번마"));
//		list.add(new Horse("10번마"));
//
//		for (Horse horse : list) {
//			horse.start();
//		}
//
//		for (Horse hs : list) {
//			try {
//				hs.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//		Collections.sort(list);
//		System.out.println("경기끝 ....");
//		System.out.println("======================================================");
//		System.out.println();
//		System.out.println(" 경기 결과 ");
//
//		for (Horse horse : list) {
//			System.out.println(horse.getName1() + " " + horse.getRank() + "등");
//		}
//	}
//}
//
//class Horse extends Thread implements Comparable<Horse>{
//   private String name1;
//   int rank;
//   
//   public Horse(String name) {
//      this.name1 = name;
//   }
//   
//   public String getName1() {
//      return name1;
//   }
//
//   public void setName1(String name) {
//      this.name1 = name;
//   }
//
//   public int getRank() {
//      return rank;
//   }
//
//   public void setRank(int rank) {
//      this.rank = rank;
//   }
//
//
//	@Override
//	public void run() {
//		for (int i = 1; i <= 50; i++) {
//			System.out.println("\n" + name1 + " : ");
//			for (int j = 1; j < i; j++) {
//				System.out.print("-");
//			}
//			System.out.print(">");
//
//			for (int j = 50; j > i; j--) {
//				System.out.print("-");
//			}
//
//		
//
//			try {
//				Thread.sleep((int) (Math.random() * 500));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}
//		System.out.println(name1 + " 끝");
//
//		setRank(ThreadTest10.strRank);
//		ThreadTest10.strRank++;
//	}
//
//	@Override
//	public int compareTo(Horse hor) {
//		if (rank > hor.getRank()) {
//			return 1;
//		} else {
//			return -1;
//		}
//	}
