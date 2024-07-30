
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

//지민이는 파티에 가서 이야기 하는 것을 좋아한다. 파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다. 
//지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다. 당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 
//되도록이면 과장해서 이야기하려고 한다. 하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다. 
//따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다. 당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 
//또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다. 지민이는 이런 일을 모두 피해야 한다.
//
//사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 그리고 각 파티에 오는 사람들의 번호가 주어진다. 지민이는 모든 파티에 참가해야 한다. 
//이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
//
//둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다. 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다. 사람들의 번호는 1부터 N까지의 수로 주어진다.
//
//셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
//
//N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수, 각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.
//

public class Main12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수
		//////////////////////////////////////////////////////// 첫째줄
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int knower = Integer.parseInt(st2.nextToken()); // 진실을 아는 사람의 수
		int[] knowerNo = new int[knower];
		for (int i = 0; st2.hasMoreTokens(); i++) {
			knowerNo[i] = Integer.parseInt(st2.nextToken()); // 진실을 아는 사람들의 번호
		}
		
		StringTokenizer[] stk = new StringTokenizer[M];
		/////////////////////////////////////////////////////// 둘째줄
		ArrayList<int[]> arl = new ArrayList<int[]>();			// 파티에 가는 사람들의 번호를 담은 배열을 담을 컬렉션
		ArrayList<int[]> tool = new ArrayList<int[]>();			// 밑의 count 배열을 담을 도구(파티의 수 만큼 요소가 있음)
		
		int ans = 0;											// 지민이가 파티에 갈 수 있는 횟수
		int[] person = new int[M];
		for (int i = 0; i < M; i++) {
			stk[i] = new StringTokenizer(br.readLine());
			person[i] = Integer.parseInt(stk[i].nextToken());	// 파티에 가는 사람 수
			int[] personNo = new int[person[i]];
			for (int j = 0; j < person[i]; j++) {
			personNo[j] = Integer.parseInt(stk[i].nextToken()); // 파티에 가는 사람들의 번호들
				
			}
			arl.add(personNo);									// arl의 한 요소에 사람들의 번호들을 가진 배열을 추가										
		}
		System.out.println(arl);
		HashSet<Integer> infector = new HashSet<Integer>();		// 임의로 진실을 아는 사람과 접촉한 사람들의 번호를 담는 컬렉션을 감염자 Set이라 하겠다
		
		
		
		// personNo 중 knowerNo인 사람이 있으면 그 배열속 모든 personNo 감염
		if (knower == 0) {
			ans = M; 						// 만약 진실을 아는이가 아무도 없다고 주어졌으면 지민이는 모든 파티에 갈 수 있다
		}else {
		for (int i = 0; i < knower; i++) {	// 진실을 아는 사람의 수 만큼 반복
			for (int j = 0; j < M; j++) {	// 파티 수 만큼 반복
				
					
				for (int q = 0; q < M; q++) { // 파티 수 만큼 반복(파티 수 만큼 두 번 반복해야 처음 감염자가 아닌 2차 감염자, ...N차 감염자와 접촉했을 때를 계산 가능)
					
					for (int j2 = 0; j2 < person[q]; j2++) { // 그 파티의 사람 수만큼 반복(진실을 아는사람이 있는지 알려면 다 봐야함)
						
						if (arl.get(q)[j2] == knowerNo[i] || infector.contains(arl.get(q)[j2])) { // 만약 그 파티의 사람이 진실을 아는사람이거나 감염자라면
							for (int k = 0; k < person[q]; k++) {				// 그 파티의 사람 수 만큼 반복
							infector.add(arl.get(q)[k]);						// 감염자 컬렉션에 그 파티에 있는 모든 사람을 넣음(감염자 컬렉션은 HashSet이기 때문에 중복값을 넣어도 효과 X => 알아서 중복처리 해줌)
							}
						}
						
					}
				}
			}
		}
		System.out.println("infector" + infector);							// 현재 진실을 아는 사람들(감염자 포함) (중복처리 O)
		
		for (int i = 0; i < M; i++) {										// 파티 수 만큼 반복
			int[] count = new int[person[i]];								// count배열은 그 파티의 사람 수 만큼 요소를 가짐
			for (int j = 0; j < person[i]; j++) {							// 그 파티의 사람 수 만큼 반복 => 그 파티의 사람중에 감염자가 있으면 count배열에 0값을, 아니면 1값을 넣을것임
				
				if (infector.contains(arl.get(i)[j])) {			
					count[j] = 0;
				}else {
					count[j] = 1;
				}
			}
			tool.add(count);												// 위의 작업을 한 count 배열을 tool이라는 임의의 list에 담아줌
		}
		
a:		for (int i = 0; i < M; i++) {										// 파티 수 만큼 반복
			for (int j = 0; j < person[i]; j++) {							// 그 파티의 사람 수 만큼 반복
				System.out.println("tool" + tool.get(i)[j]);				
				
				if (tool.get(i)[j] == 0) {									// 만약 i번째 파티의 j번째 사람이(count배열의 값) 0이라는 값(감염자와 접촉)을 가지면 그 파티는 건너뜀, 
					continue a;
				}
			}
			
			ans ++;															// 만약 한 파티의 count 배열의 값이 1이라면 감염자와 접촉한 사람이 X => 지민이가 갈 수 있는 파티 수 + 1
			System.out.println("answer" + ans); 
		}

					
		}
		
	bw.append("" +ans);
	bw.flush();
	bw.close();
	br.close();
	}
}









//출력
//첫째 줄에 문제의 정답을 출력한다.
//
//예제 입력 1 
//4 3
//0
//2 1 2
//1 3
//3 2 3 4
//예제 출력 1 
//3
//예제 입력 2 
//4 1
//1 1
//4 1 2 3 4
//예제 출력 2 
//0
//예제 입력 3 
//4 1
//0
//4 1 2 3 4
//예제 출력 3 
//1
//예제 입력 4 
//4 5
//1 1
//1 1
//1 2
//1 3
//1 4
//2 4 1
//예제 출력 4 
//2
//예제 입력 5 
//10 9
//4 1 2 3 4
//2 1 5
//2 2 6
//1 7
//1 8
//2 7 8
//1 9
//1 10
//2 3 10
//1 4
//예제 출력 5 
//4
//예제 입력 6 
//8 5
//3 1 2 7
//2 3 4
//1 5
//2 5 6
//2 6 8
//1 8
//예제 출력 6 
//5
//예제 입력 7 
//3 4
//1 3
//1 1
//1 2
//2 1 2
//3 1 2 3
//예제 출력 7 
//0
