package acm2017PracticeTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main48 {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		String[] totalName;
		float[] totalInitialWeights;
		float[] totalFinalWeights;
		while (true) {
			int numTeams = Reader.nextInt();
			if (numTeams == 0) {
				break;
			}
			totalName = new String[2*numTeams];
			totalInitialWeights = new float[2*numTeams];
			totalFinalWeights = new float[2*numTeams];
			for (int i = 0; i < 2*numTeams; i++) {
				Reader.next();
				totalName[i] = Reader.next();
				totalInitialWeights[i] = (float) Reader.nextDouble();
				totalFinalWeights[i] = (float) Reader.nextDouble();
			}
			for (int j = 0; j < totalName.length; j++) {
				for(int k = 0; k < totalName.length - 1; k++) {
					if (totalName[k].compareTo(totalName[k+1]) > 0) {
						String tempName = totalName[k];
						totalName[k] = totalName[k+1];
						totalName[k+1] = tempName;
						
						float tempIntial = totalInitialWeights[k];
						totalInitialWeights[k] = totalInitialWeights[k+1];
						totalInitialWeights[k+1] = tempIntial;
						
						float tempFinal = totalFinalWeights[k];
						totalFinalWeights[k] = totalFinalWeights[k+1];
						totalFinalWeights[k+1] = tempFinal;
					}
				}	
			}
			
			float max = -100000000;
			String tempS = "";
			for  
			 (int i = 0; i < numTeams; i++) {
				float sum = -(totalFinalWeights[2*i] + totalFinalWeights[2*i+1]) + (totalInitialWeights[2*i] + totalInitialWeights[2*i+1]);
				if(sum/(totalInitialWeights[2*i] + totalInitialWeights[2*i+1]) > max) {					
					max = sum/(totalInitialWeights[2*i] + totalInitialWeights[2*i+1]);
					tempS = totalName[2*i];
				}
			}
			max *= 100;
			System.out.print(tempS + " ");
			System.out.printf("%.1f", max);
			System.out.print("%\n");
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

