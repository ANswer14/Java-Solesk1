import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main8 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.print("N : ");
		int N = Integer.parseInt(br.readLine());
		int A = N;
		for (int i = 1; true; i++) {
			// 26 => 2 + 6 = 8 => 68
			//	            60(십의자리 수)    +           8(2 + 6의 1의자리 수)
				A = (A % 10) * 10  + ((A / 10) + (A % 10)) % 10;
				if (N == A) {
					bw.write(""+i+"");
					bw.newLine();
					break;
				}
		}
		br.close();
		bw.close();
	}
}
