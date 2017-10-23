package acm2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainH {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int loops = Integer.parseInt(in.nextLine());
		int[][] lines = new int[loops][4];
		for (int i = 0; i < loops; i++) {
			String current = in.nextLine();
			String[] currentLine = current.split(" ");
			//{x, y, a, b}
			lines[i][0] = Integer.parseInt(currentLine[0]);
			lines[i][1] = Integer.parseInt(currentLine[1]);
			lines[i][2] = Integer.parseInt(currentLine[2]);
			lines[i][3] = Integer.parseInt(currentLine[3]);		
			}
		in.close();
		for (int j = 0; j < loops; j++) {
			System.out.println(lines[j][2] + " " + (lines[j][1] + lines[j][3]));
			System.out.println(lines[j][0] + " " + (lines[j][1] + lines[j][3]));
		}
	}

}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
