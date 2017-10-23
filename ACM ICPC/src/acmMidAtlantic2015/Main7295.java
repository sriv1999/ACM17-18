package acmMidAtlantic2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7295 {
	public static void main(String[] args) throws IOException{
		Reader.init(System.in);
		int a;
		int b;
		int c;
		int d;
		while (true) {
			a = Reader.nextInt();
			b = Reader.nextInt();
			c = Reader.nextInt();
			d = Reader.nextInt();
			if (a == -1 && b == -1 && c == -1 && d == -1)
				break;
			
			if (a == -1) {
				if (c - b == d - c) {
					if (b - (c - b) >= 1) {
						System.out.println(b - (c - b));
						continue;
					}
				}
				else if (((double) c)/b == ((double) d)/c) {
					if (((double) b)/(((double) c)/b) >= 1) {
						System.out.println((int) (((double) b)/(((double) c)/b)));
						continue;
					}
				}
			}
			
			else if (b == -1) {
				if (2 * (d - c) == (c - a)) {
					if ((a + c)/2 >= 1) {
						System.out.println((a + c)/2);
						continue;
					}
				}
				else if ((((double) d)/c) * (((double) d)/c) == ((double) c)/a) {
					if (((double) c)/(((double) d)/c) >= 1) {
						System.out.println((int) (((double) c)/(((double) d)/c)));
						continue;
					}
				}
			}
			
			else if (c == -1) {
				if (2 * (b - a) == (d - b)) {
					if ((b + d)/2 >= 1) {
						System.out.println((b + d)/2);
						continue;
					}
				}
				else if ((((double) b)/a) * (((double) b)/a) == (((double) d)/b)) {
					if (((double) d)/(((double) b)/a) >= 1) {
						System.out.println((int) (((double) d)/(((double) b)/a)));
						continue;
					}
				}
			}
			
			else if (d == -1) {
				if (b - a == c - b) {
					if (c + (c - b) >= 1) {
						System.out.println(c + (c - b));
						continue;
					}
				}
				else if (((double) b)/a == ((double) c)/b) {
					if (((double) c) * (((double) c)/b) >= 1) {
						System.out.println((int) (((double) c) * (((double) c)/b)));
						continue;
					}
				}
			}
			System.out.println(-1);
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

