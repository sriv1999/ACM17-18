package acmMidAtlantic2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}
	
	public static int min(int a, int b) {
		if (a < b)
			return a;
		return b;
	}
	public static void main(String[] args) throws IOException {
		Reader.init(System.in); 
		while (true) {
			int n = Reader.nextInt();
			if (n == -1)
				break;
			int[] x1 = new int[n];
			int[] y1 = new int[n];
			int[] x2 = new int[n];
			int[] y2 = new int[n];
			for (int i = 0; i < n; i++) {
				x1[i] = Reader.nextInt();
				y1[i] = Reader.nextInt();
				x2[i] = Reader.nextInt();
				y2[i] = Reader.nextInt();
			}
			/*for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = 0;
					if (x1[i] > x1[j]) {
						temp = x1[j];
						x1[j] = x1[i];
						x1[i] = temp;
						temp = x2[j];
						x2[j] = x2[i];
						x2[i] = temp;
						temp = y1[j];
						y1[j] = y1[i];
						y1[i] = temp;
						temp = y2[j];
						y2[j] = y2[i];
						y2[i] = temp;
					}
				}
			}*/
			int[] values = new int[n];
			for (int i = 0; i < n; i++) {
				values[i] = 1;
			}
			int[] x1Int = new int[n];
			int[] y1Int = new int[n];
			int[] x2Int = new int[n];
			int[] y2Int = new int[n];
			x1Int[0] = x1[0];
			y1Int[0] = y1[0];
			x2Int[0] = x2[0];
			y2Int[0] = y2[0];
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (x1[i] < x2Int[j] && x1[i] > x1Int[j] && y1[i] > y1Int[j] && y1[i] < y2Int[j] && values[j] >= values[i]) {
						x1Int[i] = x1[i];
						x2Int[i] = min(x2[i], x2[j]);
						y1Int[i] = max(y1[i], y1[j]);
						y2Int[i] = min(y2[i], y2[j]);
						values[i] = values[j] + 1;
					}
					else if (x1Int[j] > x1[i] && x1Int[j] < x2[i] && values[j] >= values[i]) {
						x1Int[i] = max(x1[i], x1[j]);
						x2Int[i] = min(x2[i], x2[j]);
						y1Int[i] = max(y1[i], y1[j]);
						y2Int[i] = min(y2[i], y2[j]);
						values[i] = values[j] + 1;
					}
				}
			}
			int max = 0;
			for (int e : values) {
				System.out.println(e);
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
