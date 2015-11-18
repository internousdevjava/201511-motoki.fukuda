import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KisoKadai2 {

	public static void main(String[] args) {
		String str = null;
		int num;
		boolean flag = true;
		
		int ans;
		ans = (int)(Math.random() * 100) + 1;
		//System.out.println(ans);
		
		System.out.println("数当てゲーム開始！");
		System.out.println("予想を1~100で入力してください。");

		while (flag) {
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (isNumber(str)) {
				num = Integer.parseInt(str);
				if ((num == 0) || (num > 100)) {
					System.out.println("1~100で入力して下さい！");
					continue;
				}
			} else {
				System.out.println("数値で入力してください。");
				continue;
			}

			if (num < ans) {
				System.out.println("もっと大きいよ！");
				continue;
			} else if (num > ans) {
				System.out.println("もっと小さいよ！");
				continue;
			} else {
				System.out.println("あたりです！！");
				flag = false;
			}

		}	
	}

	public static boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}

}
