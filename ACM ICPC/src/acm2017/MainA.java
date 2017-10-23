package acm2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainA {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int loops = Reader.nextInt();
		for (int i = 0; i < loops; i++) {
			//{x, y, a, b}
			int x = Reader.nextInt();
			int y = Reader.nextInt();
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int count = 0;
			while (count < loops) {
				if ((a == x && x == 1) || (b == y && y == 1)) {
					System.out.printf("%s\n", "INF");
					count++;
					break;
				}
				if ((x == 2 && y== 2 && (a >= 2 || b >= 2))) {
					System.out.printf("%s\n", "INF");
					count++;
					break;
				}
				int total = 0;
				while (a >= x || b >= y) {
					if (a >= x) {
						a -= x;
					}
					else if (b >= y) {
						b -= y;
					}
					else
						continue;
					a++;
					b++;
					total++;
				}
				System.out.printf("%d\n", total);
				count++;
				break;
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
