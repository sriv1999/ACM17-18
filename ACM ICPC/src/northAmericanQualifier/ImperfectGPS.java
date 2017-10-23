package northAmericanQualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImperfectGPS {
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(y2 - y1, 2)+Math.pow(x2 - x1, 2));
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int n = Reader.nextInt();
		int t = Reader.nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		double[] ti = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = Reader.nextInt();
			y[i] = Reader.nextInt();
			ti[i] = Reader.nextInt();
		}
		double totalRegular = 0;
		for (int i = 0; i < n - 1; i++) {
			totalRegular += distance(x[i+1], y[i+1], x[i], y[i]);
		}
		double[] xg;
		double[] yg;
		double[] tg;
		int l = 0;
		if (ti[n-1]%t == 0)
			 l = (int)ti[n-1]/t + 1;
		else
			l = (int)ti[n-1]/t + 2;
		xg = new double[l];
		yg = new double[l];
		tg = new double[l];
		xg[0] = x[0];
		yg[0] = y[0];
		tg[0] = 0;
		for (int i = 1; i < l; i++) {
			tg[i] = i*t;
			if (tg[i] > ti[n-1]) {
				tg[i] = ti[n-1];
			}
			for (int j = 0; j < n - 1; j++) {
				if (tg[i] == ti[j]) {
					xg[i] = x[j];
					yg[i] = y[j];
					break;	
				}
				else if (tg[i] == ti[n-1]) {
					xg[i] = x[n-1];
					yg[i] = y[n-1];
					break;
				}
				else if (tg[i] > ti[j] && tg[i] < ti[j+1]) {
					xg[i] = (tg[i] - ti[j])/(ti[j+1] - ti[j]) * (x[j+1] - x[j]) + x[j];
					yg[i] = (tg[i] - ti[j])/(ti[j+1] - ti[j]) * (y[j+1] - y[j]) + y[j];
					break;
				}
			}
		}
		
		double totalGPS = 0;
		for (int i = 0; i < l - 1; i++) {
			totalGPS += distance(xg[i+1], yg[i+1], xg[i], yg[i]);
		}
		System.out.println((totalRegular - totalGPS) / totalRegular * 100.0);
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