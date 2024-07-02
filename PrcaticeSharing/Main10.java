import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long firstTool = B;
		String answer = "";
		long tool = 0;
		while (true) {
			tool = B;
			if (tool > N) {
				tool = B / firstTool;
				break;
			}
			B *= firstTool;
		}
//			100001011000001110110000000
//			11100100111000011100000000
//			67108864
//			100000000000000000000000000
//			60466175 36
		long tool2 = N / tool;	
			while (true) {
				if (firstTool > 10 && tool2 >= 10) {
					if (tool2 == 10) {
						answer += "A";
					}else if (tool2 == 11) {
						answer += "B";
					}else if (tool2 == 12) {
						answer += "C";
					}else if (tool2 == 13) {
						answer += "D";
					}else if (tool2 == 14) {
						answer += "E";
					}else if (tool2 == 15) {
						answer += "F";
					}else if (tool2 == 16) {
						answer += "G";
					}else if (tool2 == 17) {
						answer += "H";
					}else if (tool2 == 18) {
						answer += "I";
					}else if (tool2 == 19) {
						answer += "J";
					}else if (tool2 == 20) {
						answer += "K";
					}else if (tool2 == 21) {
						answer += "L";
					}else if (tool2 == 22) {
						answer += "M";
					}else if (tool2 == 23) {
						answer += "N";
					}else if (tool2 == 24) {
						answer += "O";
					}else if (tool2 == 25) {
						answer += "P";
					}else if (tool2 == 26) {
						answer += "Q";
					}else if (tool2 == 27) {
						answer += "R";
					}else if (tool2 == 28) {
						answer += "S";
					}else if (tool2 == 29) {
						answer += "T";
					}else if (tool2 == 30) {
						answer += "U";
					}else if (tool2 == 31) {
						answer += "V";
					}else if (tool2 == 32) {
						answer += "W";
					}else if (tool2 == 33) {
						answer += "X";
					}else if (tool2 == 34) {
						answer += "Y";
					}else if (tool2 == 35) {
						answer += "Z";
					}
				}else {
				answer += (tool2);
				}
				
				N -= (tool2) * tool;
				if (tool == 1) {
					break;
				}
				tool /= firstTool;
			}
		
		bw.write(answer);
		bw.flush();
		br.close();
		bw.close();
	}
	
}
