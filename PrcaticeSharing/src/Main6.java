import java.util.Scanner;

//**음료수를 구매할 수 있는 자판기가 있다.**
//
//**너는 10만원짜리 수표하나를(수표로도 계산 가능한 자판기) 가지고 있다.**
//
//**파워에이드는 3750원/포카리 2970원/물 1770원 세종류가 있는데 1번을 누르면 원하는 상품 구매 갯수를 입력받아 지불금액과 차액이 나오도록 해주고 2번을 누르면 남은 돈의 액수를 오만원권, 만원권, 천원권, 500원 동전, 100원 동전, 10원 동전 각 몇 개로 변환되는 출력된다.**
//
//**3번은 자판기가 종료됩니다 출력되면서 3초 뒤에 자동종료**
public class Main6 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int select = 0;
		int realMoney = 100000;
		int actualMoney = 0;
		int count = 0;
		int powerAde = 3750;
		int pokari = 2970;
		int water = 1770;
		int tool = 0;
		String[] won = { "50000원", "10000원", "1000원", "500원", "100원", "10원" };
		while (true) {
			System.out.print("|1. 물건 구매|2. 거스름돈 정리|3. 종료|\n");
			System.out.print("선택>");
			select = k.nextInt();
		if (select == 1) {
			while (true) {
				System.out.println("|1. 파워에이드 : 3750원|2. 포카리 : 2970원| 3. 물 : 1770원|");
				System.out.print("선택>");
				select = k.nextInt();
				
				if (select == 1) {
					while (true) {
						System.out.print("몇 개를 구매하시겠습니까?\n");
						System.out.print("개수 입력 : ");
						count = k.nextInt();
						if (count > 0) {
							realMoney -= count * powerAde;
							System.out.printf("지불금액 : %,d\n"
									+ "차액 : %,d\n", count * powerAde, realMoney);
							break;
						}else {
							System.err.println("오류");
						}
						
					}
					break;
				}else if (select == 2) {
					while (true) {
						System.out.print("몇 개를 구매하시겠습니까?");
						System.out.print("개수 입력 : ");
						count = k.nextInt();
						if (count > 0) {
							realMoney -= count * pokari;
							System.out.printf("지불금액 : %,d\n"
									+ "차액 : %,d\n", count * pokari, realMoney);
							break;
						}else {
							System.err.println("오류");
						}
						
					}
					
					break;
				}else if (select == 3) {
					while (true) {
						System.out.print("몇 개를 구매하시겠습니까?");
						System.out.print("개수 입력 : ");
						count = k.nextInt();
						if (count > 0) {
							realMoney -= count * water;
							System.out.printf("지불금액 : %,d\n"
									+ "차액 : %,d\n", count * water, realMoney);
							break;
						}else {
							System.err.println("오류");
						}
						
					}
					
					break;
				}else {
					System.err.println("오류");
				}
			} 
		}else if (select == 2) {
			actualMoney = realMoney;
			tool = 50000;
//			2번을 누르면 남은 돈의 액수를 오만원권, 만원권, 천원권, 500원 동전, 100원 동전, 10원 동전 각 몇 개로 변환
			for (int i = 0; true; i++) {
				
			if (i == 0 || i == 3) {
				System.out.printf("%s : %d장(개)\n",won[i], actualMoney / tool);
				actualMoney -= actualMoney / tool * tool;
				tool /= 5;
			}else if (i == 1 || i == 4 || i == 5) {
				System.out.printf("%s : %d장(개)\n", won[i], actualMoney / tool);
				actualMoney -= actualMoney / tool * tool;
				tool /= 10;
			}else if (i == 2) {
				System.out.printf("%s : %d장(개)\n", won[i], actualMoney / tool);
				actualMoney -= actualMoney / tool * tool;
				tool /= 2;
				
			}else {
				break;
			}
			}
		}else if (select == 3) {
			System.out.println("자판기가 3초 후에 종료됩니다");
			try {
				Thread.sleep(1000);
				System.out.println("1");
				Thread.sleep(1000);
				System.out.println("2");
				Thread.sleep(1000);
				System.out.println("3");
				System.out.println("종료");
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("오류");
		}
		}
	}
}
