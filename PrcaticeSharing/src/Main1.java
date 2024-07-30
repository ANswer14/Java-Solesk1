import java.util.Random;


public class Main1 {
//	1.  두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성하시오. 
	public static void main(String[] args) {
		Random r = new Random();
		int dice1 = 0;
		int dice2 = 0;
		
		while (true) {
			dice1 = r.nextInt(6) + 1;
			dice2 = r.nextInt(6) + 1;
			System.out.printf("%d, %d\n", dice1, dice2);
			if (dice1 + dice2 != 5) {
			}else {
				break;
			}
		}
	}
}
