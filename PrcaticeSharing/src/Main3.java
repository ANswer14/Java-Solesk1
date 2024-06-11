import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String input = k.next();
		System.out.println(input.replace("c=", "c").replace("c-", "1").replace("dz=", "2").replace("d-", "3").replace("lj", "4").replace("nj", "5").replace("s=", "6")
				.replace("z=", "7").length());
	}
}