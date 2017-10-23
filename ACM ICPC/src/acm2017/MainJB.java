package acm2017;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MainJB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Pair<Integer, Integer>> p = new ArrayList<Pair<Integer,Integer>>();
		int t = in.nextInt();
		while (t > 0) {
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				p.add(new Pair(a, b));
			}
			long count = 0;
			long ans = 0;
			for (int i = n - 1; i >= 0; i--) {
				String[] line = p[i].split(" ");
				int second = Integer.parseInt(line[1]);
				for (int j = 0; j < second; j++) {
					count += Integer.parseInt(line[0]);
					if (count < 0)
						break;
					ans += count;
				}
			}
			System.out.println(ans);
			t--;
		}
		in.close();
	}

}

class Pair<L, R> {
	private L l;
	private R r;

	public Pair(L l, R r) {
		this.l = l;
		this.r = r;
	}

	public L getL() {
		return l;
	}

	public R getR() {
		return r;
	}

	public void setL(L l) {
		this.l = l;
	}

	public void setR(R r) {
		this.r = r;
	}
}