//문제
//옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
//
//길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
//
//S = A[0] × B[0] + ... + A[N-1] × B[N-1]
//
//S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
//
//S의 최솟값을 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
//
//출력
//첫째 줄에 S의 최솟값을 출력한다.
//예제 입력 1 
//5
//1 1 1 6 0
//2 7 8 3 1
//
//예제 출력 1 
//18
import java.util.Scanner;
public class Main4 {
	public static void main(String[] args) {
///////////////////////////////////// 입력
		Scanner k =new Scanner(System.in);
		int N = k.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = k.nextInt();
		}
		int[] B = new int [N];
		for (int i = 0; i < B.length; i++) {
			B[i] = k.nextInt();
		}
		k.close();
/////////////////////////////////////// 계산
		int[] C = new int[B.length];
		int[] E = new int[B.length];
		int count = 0;
		int t = 0;
		int tool = 0;
		int sum = 0;
		// B 배열의 인덱스 하나가 다른 인덱스의 값보다 작을때마다 +1해서 C배열에 담기
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (i == j){
					continue;
				}else if (B[i] < B[j]) {
					count ++;
				}
			}
			C[i] = count;
			count = 0;
		}
		// 오름차순 정렬 bubble sort
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length - 1; j++) {
				if (A[j] > A[j + 1]) {
					t = A[j];
					A[j] = A[j + 1];
					A[j + 1] = t;
				}
			}
		}
		// E에 A담기
		for (int i = 0; i < A.length; i++) {
			E[i] = A[i];
		}
		// A에 C와 E를 이용해 재배열
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
					if (C[i] == C[j]) {
						tool ++;
				}
			}
			A[i] = E[C[i] + tool];
			tool = 0;
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
		
				
		}
	
}
