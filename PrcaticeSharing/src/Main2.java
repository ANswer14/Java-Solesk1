import java.util.Scanner;

//self-number sum
// 어떤 자연수 n에 대해
// d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
// d(91) = 9 + 1 + 91 = 101
//			d(1) = 1 + 1 = 2
// 이 때, n을 d(n)의 제네레이터라고 한다.
// 위의 예에서 91은 101의 제네레이터이다.
// 제네레이터가 없는 숫자들을 self-number라고 하는데 
// 1이상 5000미만의 모든 셀프 넘버들의 합을 구하시오

public class Main2 {
	public static void main(String[] args) {
		// a = 1 ~ 4999의 합
		int a = 0;
		for (int i = 0; i < 5000; i++) {
			a += i;
		}
		int tool = 1000;
		int num = 0;
		int n = 0;
		int sum = 0;
		int sum2 = 0;
		int[] realSum = new int[5000];
		for (int i = 0; i < 5000; i++) {
			n = i + 1;
			sum = n;
		while (true) {
		// 제너레이터로 만들어진 수
		if(tool == 0){
			break;
		}else if(n / tool == 0){
			tool /= 10;
		}else if (n / tool > 0) {
			sum += n / tool;  
			n -= tool * (n / tool);
			tool /= 10;
			}
		}
		tool = 1000;
		// 배열에 수들 담기
		realSum[i] = sum;
		}
		// 배열 중복처리
		for (int k = 0; k < 5000; k++) {
			
			for (int j = 0; j < 5000; j++) {
				if (k == j) {
					continue;
				}else if (realSum[k] == realSum[j]) {
					realSum[j] = 0;
				}
			}
		}
		// 제너레이터로 만들어진 수들중 <= 5000 들의 합
		for (int j = 0; j < realSum.length; j++) {
			if (realSum[j] < 5000) {
				sum2 += realSum[j];
			}
		}
		// a에서 셀프 넘버들을 제외한 수들을 빼서 셀프 넘버들의 합 구하기
		System.out.println(a - sum2);
	}
}
