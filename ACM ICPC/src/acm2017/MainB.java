package acm2017;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainB {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
		int t, n;
		int[] h = new int[510];
		int[] c = new int[510];
		long[] dp;
		t = Reader.nextInt();
		while (t > 0) {
			dp = new long[50010];
			n = Reader.nextInt();
			for (int i = 0; i < n; i++) {
				h[i] = Reader.nextInt();
				c[i] = Reader.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 50000; j != 0; j--) {
					if (j < c[i])
						break;
					dp[j] = Math.max(dp[j], dp[j - c[i]] + h[i]);
				}
			}
			long ans = 0;
			for (int i = 1; i <= 50000; i++)
				ans = Math.max(ans,  dp[i]*dp[i] - dp[i]*i - (long)i*i);
			out.println(ans);
			t--;
		}

	}

}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}




