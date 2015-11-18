import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KisoKadai1 {

	public static void main(String[] args) {
		String sx = null;
		String sy = null;
		boolean flag = true;
		int x = 0, y = 0;
		while (flag) {

			System.out.println("たては？");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				sx = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if ( isNumber(sx)) {
				x = Integer.parseInt(sx);
					if ((x==0) || (x > 100)) {
						System.out.println("1~100でたのみます＾＾");
						continue;
					}
				//flag = false;
			} else {
				System.out.println("数値で入力してください。");
				continue;
			}

			System.out.println("よこは？");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				sy = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (isNumber(sy)) {
				y = Integer.parseInt(sy);
				if ((y == 0) || (y > 100)) {
					System.out.println("1~100でたのみます＾＾");
					continue;
				}
				flag = false;
			} else {
				System.out.println("数値で入力してください。");
				continue;
			}

		}

		for (int r = 1; r <= x; r++) {
			for (int c = 1; c <= y; c++) {
				int res = c * r;
				if ((x < 10) && (y < 10)) {

					if (res < 10) {
						System.out.print("  ");
					} else {
						System.out.print(" ");
					}

				} else {

					if (res < 10) {
						System.out.print("    ");
					} else if (res < 100) {
						System.out.print("   ");
					} else if (res < 1000) {
						System.out.print("  ");
					} else {
						System.out.print(" ");
					}

				}

				System.out.print(res);
			}
			System.out.println("");
		}
	}
	//数字か文字かを判断するメソッド
	public static boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}
}
