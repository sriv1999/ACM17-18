package acm2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainAB {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int[] nums = new int[20050];
		int[] sum = new int[20050];
		int[][][] list;
		int loops = Reader.nextInt();
		while (loops > 0) {
			int n = Reader.nextInt();
			list = new int[2][300][300];
			for (int i = 1; i <= n; i++) {
				nums[i] = Reader.nextInt();
				sum[i] = sum[i - 1] + nums[i];
			}
			int bound = (int) Math.sqrt(n * 2) + 1;
			for (int i = n; i >= 1; i--) {
				for (int j = bound; j >= 1; j--) {
					if (i + j <= n) {
						list[0][i & 255][j] = sum[(i + j - 1)] - sum[i - 1] + Math.max(list[1][(i + j) & 255][j], list[1][(i + j + 1) & 255][j + 1] + nums[i + j]);
						list[1][i & 255][j] = -sum[i + j - 1] + sum[i - 1] + Math.min(list[0][(i + j) & 255][j], list[0][(i + j + 1) & 255][j + 1] - nums[i + j]);
					}
					else if (i + j == n + 1)
					{
						list[0][i & 255][j] = sum[i + j - 1] - sum[i - 1] + list[1][(i + j) & 255][j];
						list[1][i & 255][j] = sum[i - 1] - sum[i + j - 1] + list[0][(i + j) & 255][j];
					}
				}
			}
			System.out.println(list[0][1][1]);
			loops--;
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
