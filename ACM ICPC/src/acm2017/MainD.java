package acm2017;

import java.util.Scanner;

public class MainD {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t, n, m, x, y;
		int[] al, ar, bl, br;
		
		t = in.nextInt();
		while (t > 0) {
			n = in.nextInt();
			m = in.nextInt();
			x = in.nextInt();
			y = in.nextInt();
			al = new int[105];
			ar = new int[105];
			bl = new int[105];
			br = new int[105];
			for (int i = 0; i < x; i++) {
				al[i] = in.nextInt();
				ar[i] = in.nextInt();
			}
			for (int i = 0; i < y; i++) {
				bl[i] = in.nextInt();
				br[i] = in.nextInt();
			}
			int count = 0;
			for (int i = 0; i < x; i++) {
				if (ar[i] - al[i] + 1 < m)
					continue;
				for (int j = 0; j < y; j++) {
					if (br[j] - bl[j] + 1 < m)
						continue;
					int r = Math.min(ar[i], br[j]);
					int l = Math.max(al[i], bl[j]);
					if (r - l + 1 >= m)
						count += r - l - m + 2;
				}
			}
			System.out.println(count);
			t--;
		}
		in.close();
	}

}
