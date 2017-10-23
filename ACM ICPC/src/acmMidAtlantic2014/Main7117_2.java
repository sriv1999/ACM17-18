package acmMidAtlantic2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main7117_2 {

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
			String eTemp = e;
			ArrayList<String> characters = new ArrayList<String> ();
			String w = "";
			eTemp += "bbbbbbbb";
			for (int i = 0; i < eTemp.length(); i++)
				characters.add(eTemp.substring(i, i+1));
			for (int i = 0; i < characters.size() - 5; i++) {
				String threeL = characters.get(i+2) + characters.get(i+3);
				String threeL2 = characters.get(i+1) + characters.get(i+2);
				String temp1 = characters.get(i+1) + threeL;
				String temp2 = threeL + characters.get(i+4);
				if(i == characters.size() - 8)
				{
					break;
				}
				if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+1)) && vowels.contains(characters.get(i+2))) 
				{
					if (!(i+2 == characters.size() - 9 && characters.get(i+2).equalsIgnoreCase("e"))) {
						if (!(characters.get(i+1).equalsIgnoreCase("q") && characters.get(i+2).equalsIgnoreCase("u")))
							w += characters.get(i) + "-";
					}
				}
				else if (vowels.contains(characters.get(i)) && vowels.contains(characters.get(i+3)) && (threeL2.equalsIgnoreCase("qu") || threeL2.equalsIgnoreCase("tr") || threeL2.equalsIgnoreCase("br") || threeL2.equalsIgnoreCase("st") || threeL2.equalsIgnoreCase("sl")
						|| threeL2.equalsIgnoreCase("bl") || threeL2.equalsIgnoreCase("cr") || threeL2.equalsIgnoreCase("ph") || threeL2.equalsIgnoreCase("ch"))) {
					if (!(i+3 == characters.size() - 9 && characters.get(i+3).equalsIgnoreCase("e")))
						w += characters.get(i) + "-";
				}
				else if (vowels.contains(characters.get(i)) && temp1.equalsIgnoreCase("str") && vowels.contains(characters.get(i+4))) {
					if (!(i+4 == characters.size() - 9 && characters.get(i+4).equalsIgnoreCase("e")))
						w += characters.get(i) + "-";
				}
				else if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+1)) && (threeL.equalsIgnoreCase("qu") ||  threeL.equalsIgnoreCase("tr") || threeL.equalsIgnoreCase("br") || threeL.equalsIgnoreCase("st") || threeL.equalsIgnoreCase("sl")
						|| threeL.equalsIgnoreCase("bl") || threeL.equalsIgnoreCase("cr") || threeL.equalsIgnoreCase("ph") || threeL.equalsIgnoreCase("ch")) && vowels.contains(characters.get(i+4))) 
				{
					w += characters.get(i) +  characters.get(i+1) + "-";
					i ++;
				}
				else if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+3)) && (threeL2.equalsIgnoreCase("qu") || threeL2.equalsIgnoreCase("tr") || threeL2.equalsIgnoreCase("br") || threeL2.equalsIgnoreCase("st") || threeL2.equalsIgnoreCase("sl")
						|| threeL2.equalsIgnoreCase("bl") || threeL2.equalsIgnoreCase("cr") || threeL2.equalsIgnoreCase("ph") || threeL2.equalsIgnoreCase("ch")) && vowels.contains(characters.get(i+4))) 
				{
					w += characters.get(i) +  threeL2 + "-";
					i += 2;
				}
				else if(vowels.contains(characters.get(i)) && vowels.contains(characters.get(i+5)) && !vowels.contains(characters.get(i+1)) && temp2.equalsIgnoreCase("str")) 
				{
					w += characters.get(i) + characters.get(i+1) + "-str";
					i += 4;
				}
				else if (vowels.contains(characters.get(i)) && vowels.contains(characters.get(i+5)) && !vowels.contains(characters.get(i+4)) && temp1.equalsIgnoreCase("str")) 
				{
					w += characters.get(i) + "str-" + characters.get(i+1);
					i += 4;
				}
				else if (vowels.contains(characters.get(i)) && !vowels.contains(characters.get(i+1)) && !vowels.contains(characters.get(i+2)) && vowels.contains(characters.get(i+3))) 
				{
					String twoL = characters.get(i+1) + characters.get(i+2);
					if (twoL.equalsIgnoreCase("tr") || twoL.equalsIgnoreCase("br") || twoL.equalsIgnoreCase("st") || twoL.equalsIgnoreCase("sl")
							|| twoL.equalsIgnoreCase("bl") || twoL.equalsIgnoreCase("cr") || twoL.equalsIgnoreCase("ph") || twoL.equalsIgnoreCase("ch"))
						w += characters.get(i) + "-" + characters.get(i+1);
					else
						w += characters.get(i) + characters.get(i+1) + "-";
					i += 1;
				}
				else if(vowels.contains(characters.get(i)) && characters.get(i+1).equalsIgnoreCase("q") && characters.get(i+2).equalsIgnoreCase("u") && vowels.contains(characters.get(i+3)))
				{
					w += characters.get(i) + "-";
				}
				else if(vowels.contains(characters.get(i)) && temp1.equalsIgnoreCase("str") && vowels.contains(characters.get(i+4))) {
					w += characters.get(i) + "-";
				}
				else 
				{
					w += characters.get(i);
				}
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

