import java.util.Scanner;


public class Main7 {
	// N입력 받아오기
	public static int N() {
		Scanner k = new Scanner(System.in);
		System.out.print("N입력 : ");
		int N = k.nextInt();
		return N <=23 && N >= 0 ? N : N();
	}
	
	// N으로 계산하기
	public static int calc(int N) {
		
		int count = 0;
		for (int h = 0; h <= N; h++) {
			
			for (int m = 0; m < 60; m++) {
				
				for (int s = 0; s < 60; s++) {
					if (h == 3 || h == 13 || h == 23) {
						count ++;
					}else if (m == 3 || m == 13 || m == 23 || m < 40 && m >= 30 || m == 43 || m == 53) {
						count ++;
					}else if (s == 3 || s == 13 || s == 23 || s < 40 && s >= 30 || s == 43 || s == 53) {
						count ++;
					}
					
				}
			}
			
		}
		return count;
	}
	
	// 계산한 값 출력
	public static void printResult(int calc) {
		System.out.println("count " + calc);
	}
	
	// 메소드들 모으기
	public static void start() {
		printResult(calc(N()));
	}
	
	// 실행
	public static void main(String[] args) {
		start();
	}
}




