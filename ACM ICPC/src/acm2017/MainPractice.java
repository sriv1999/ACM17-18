package acm2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainPractice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		String[] output = new String[cases];
		int numCase = 1;
		while (numCase <= cases){
			String[] line = in.nextLine().split(" ");
			BigInteger a = new BigInteger(line[0]);
			BigInteger b = new BigInteger(line[1]);
			System.out.println();
			System.out.println("Case " + numCase + ":");
			System.out.println(a.toString() + " + " + b.toString() + " = " + a.add(b).toString());
			System.out.println();
			numCase++;
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
