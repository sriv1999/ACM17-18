package acm2017PracticeTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main49 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		double ans;
		double result;
		while (true) {
			ans = 0;
			double w1 = (double) Reader.nextDouble();
			double h1 = (double) Reader.nextDouble();
			double w2 = (double) Reader.nextDouble();
			double h2 = (double) Reader.nextDouble();
			double x = (double) Reader.nextDouble();
			double y = (double) Reader.nextDouble();
			if (w1 == h1 && w1 == 0) {
				break;
			}
			ans = (double) ((w2*y) + (0.5*w2*h2));
			ans /= (w1 - w2);
			if (ans + y + 0.5*h2 > h1) {
				double resultBound = 0;
				double tempH = (double) (ans - (h1 - y - 0.5*h2));
				double tempB = tempH / ans * w2;
				resultBound = (double) ((0.5 * w2 * ans) - (0.5*tempH*tempB));
				resultBound /= (h1 * w1 - h2 * w2);
				resultBound *= 100.0;
				System.out.printf("%.1f", resultBound);
				System.out.print("%\n");
			}
			else {
				result = (double) (0.5 * w2 * ans);
				result /= (h1 * w1 - h2 * w2);
				result *= 100.0;
				System.out.printf("%.1f", result);
				System.out.print("%\n");
			}
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


