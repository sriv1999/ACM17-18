package acmMidAtlantic2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7117 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		String vowels = "aeiouy";
		ArrayList<String> words = new ArrayList<String> ();
		String word = Reader.next();
		while (word.compareTo("===") != 0) {
			words.add(word);
			word = Reader.next();
		}
		
		ArrayList<String> finalWords = new ArrayList<String> ();
		for (String e : words) {
			boolean a = false;
			ArrayList<String> characters = new ArrayList<String> ();
			String w = "";
			for (int i = 0; i < e.length(); i++)
				characters.add(e.substring(i, i+1));
			for (int i = 0; i < characters.size() - 3; i++) {
				if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+1)) && !vowels.contains(characters.get(i+2)) && vowels.contains(characters.get(i+3))) {
					String twoL = characters.get(i+1) + characters.get(i+2);
					if (twoL.equalsIgnoreCase("tr") || twoL.equalsIgnoreCase("br") || twoL.equalsIgnoreCase("st") || twoL.equalsIgnoreCase("sl")
							|| twoL.equalsIgnoreCase("bl") || twoL.equalsIgnoreCase("cr") || twoL.equalsIgnoreCase("ph") || twoL.equalsIgnoreCase("ch"))
						w += characters.get(i) + "-" + characters.get(i+1);
					else
						w += characters.get(i) + characters.get(i+1) + "-";
					if (i == e.length() - 4) {
						a = true;
						w += e.substring(e.length() - 2);
					}
					i += 1;
				}
				else if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+1)) && vowels.contains(characters.get(i+2))) {
					w += characters.get(i) + "-";
				}
				else {
					w += characters.get(i);
				}
			}
			if (e.length() >= 3) {
				if (vowels.contains(e.substring(e.length() - 1)) && !vowels.contains(e.substring(e.length() - 2, e.length() - 1)) && vowels.contains(e.substring(e.length() - 3, e.length() - 2)) && !e.substring(e.length() - 1).equalsIgnoreCase("e")) {
					w += e.substring(e.length() - 3, e.length() - 2) + "-" + e.substring(e.length() - 2);
				}
				else if (!a) {
					w += e.substring(e.length() - 3);
				}
			}
			else {
				w = e;
			}
			finalWords.add(w);
		}
		for (String e : finalWords) {
			System.out.println(e);
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

