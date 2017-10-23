package northAmericanQualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OddGnome {
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int nGroups = Reader.nextInt();
		while (nGroups > 0) {
			int numGnomes = Reader.nextInt();
			int[] gnomes = new int[numGnomes];
			for (int i = 0; i < numGnomes; i++) {
				gnomes[i] = Reader.nextInt();
			}
			for (int i = 1; i < numGnomes - 1; i++) {
				if (gnomes[i] > gnomes[i-1] && gnomes[i] > gnomes[i+1]) {
					if (gnomes[i+1] > gnomes[i-1]) {
						System.out.println(i+1);
						break;
					}
				}
				else if (gnomes[i] < gnomes[i-1] && gnomes[i] < gnomes[i+1]) {
					System.out.println(i+1);
					break;
				}
			}
			nGroups--;
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


