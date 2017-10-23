package acm2017;

import java.io.*;
import java.util.StringTokenizer;

public class MainJ {

	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int loop, n, a;
		loop = Reader.nextInt();
		while (loop > 0) {
			int result = 0;
			n = Reader.nextInt();
			for (int i = 0; i < n; i++) {
				a = Reader.nextInt();
				if (a != 0)
					result++;
				result = Math.max(result,  a);
			}
			System.out.println(result);
			loop--;
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



