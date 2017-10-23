package acm2017PracticeTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main44 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		float tr = 1;
		float te = 1;
		while (true) {
			tr = (float) Reader.nextDouble();
			te = (float) Reader.nextDouble();
			if (tr == 0 && te == 0) {
				break;
			}
			float result = (float) Math.sqrt(1 - (te * te)/(tr * tr));
			System.out.printf("%.3f\n", result);
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

