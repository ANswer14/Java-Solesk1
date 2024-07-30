import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


//평균은 넘겠지 스페셜 저지다국어
// 
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	277165	122210	81354	40.378%
//문제
//대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
//
//입력
//첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
//
//둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
//
//출력
//각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다. 정답과 출력값의 절대/상대 오차는 10-3이하이면 정답이다.
//
//예제 입력 1 
//5
//5 50 50 70 80 100
//7 100 95 90 80 70 60 50
//3 70 90 80
//3 70 90 81
//9 100 99 98 97 96 95 94 93 91
//예제 출력 1 
//40.000%
//57.143%
//33.333%
//66.667%
//55.556%
public class Main14 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		ArrayList<int[]> arl = new ArrayList<int[]>();
		ArrayList<Integer> student = new ArrayList<Integer>();
		ArrayList<Double> superiorPercent = new ArrayList<Double>();
		StringTokenizer[] st = new StringTokenizer[test];
		int sum = 0;
		double std = 0;
		double superior = 0;
		double tool = 0;
		for (int i = 0; i < test; i++) {
			st[i] = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st[i].nextToken());
			int[] score = new int[people];
			for (int j = 0; j < people; j++) {
				score[j] = Integer.parseInt(st[i].nextToken());
			}
			student.add(people);
			arl.add(score);
		}
		br.close();
		
		for (int i = 0; i < test; i++) {
			for (int j = 0; j < student.get(i); j++) {
				sum += arl.get(i)[j];
			}
			std = (double)sum / student.get(i);
			for (int j = 0; j < student.get(i); j++) {
				if (arl.get(i)[j] > std) {
					superior ++;
				}
			}
			tool =  Math.round(superior / student.get(i) * 100 * 1000) / 1000.0;
			superiorPercent.add(tool);
			System.out.printf("%.03f%%\r\n", superiorPercent.get(i));
			sum = 0;
			superior = 0;
		}
		
		
	}
}
