import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11 {
//	무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
//
//	1/1	1/2	1/3	1/4	1/5	…
//	2/1	2/2	2/3	2/4	…	…
//	3/1	3/2	3/3	…	…	…
//	4/1	4/2	…	…	…	…
//	5/1	…	…	…	…	…
//	…	…	…	…	…	…
//	이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
//
//	X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());
		int tool = 0;
		int tool2 = 0;
		int tool3 = 0;
		for (int i = 0;true; i++) {
			
			tool ++;
			tool2 += tool;
			if (tool2 >= X) {
				tool3 = i - 1;
				break;
			}
		}
		
		System.out.println(tool); // 대각선 기준으로 몇번째 줄인지
		System.out.println(tool2); // 대각선 기준으로 몇개째
		System.out.println(tool2 - tool); // tool2보다 한단계 전
		System.out.println(X - (tool2 - tool)); // X 에서 (tool2 - tool1)(tool2보다 한단계 전)을 빼서 그 줄에서 몇번째인지 구함
		if (tool3 % 2 == 1) { // 나눈 이유는  위에서 계산한 도구들은 위에서 아래로 진행되는걸 기준으로 했기 때문에 그와 반대되는 라인은 반대로 넣어햐 하기 때문 - 아래에서 위로 올라감
			bw.write((tool + 1 - (X - (tool2 - tool) )) + "/" + (X - (tool2 - tool))); 
		}else { // 반대방향으로 진행 - 위에서 아래로 내려감
			bw.write((X - (tool2 - tool)) + "/" + (tool + 1 - (X - (tool2 - tool)))); 
		}
		bw.newLine();
		br.close();
		bw.close();
	}
}
