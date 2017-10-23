package acm2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MainDB {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		Set<Integer> mg = new TreeSet<Integer> ();
		int loop = Reader.nextInt();
		while (loop > 0) {
			mg.clear();
			int n = Reader.nextInt();
			int count = 1;
			for (int i = 0; i < n; i++) {
				int a = Reader.nextInt();
				if (Collections.frequency(mg, a) != 0) {
					count++;
					mg.clear();
				}
				mg.add(a);
			}
			System.out.println(count);
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
