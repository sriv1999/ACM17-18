package northAmericanQualifier;

import java.io.IOException;
import java.util.Scanner;

public class ProgressiveScramble {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n > 0) {
			String status = in.next();
			if (status.equals("e")) {
				String line = in.nextLine();
				char[] encr = new char[line.length()];
				for (int i = 0; i < line.length(); i++) {
					encr[i] = line.charAt(i);
				}
				int[] v = new int[encr.length];
				for (int i = 0; i < encr.length; i++) {
					if (encr[i] == ' ')
						v[i] = 0;
					else
						v[i] = encr[i] - 96;
				}
				int[] u = new int[v.length];
				u[0] = v[0];
				for (int i = 1; i < v.length; i++) {
					u[i] = u[i-1] + v[i];
					u[i] %= 27;
				}
				for (int i = 1; i < u.length; i++) {
					if (u[i] == 0) {
						System.out.print(" ");
					}
					else
						System.out.print((char)(u[i]+96));
				}
			}
			else if (status.equals("d")) {
				String line2 = in.nextLine();
				char[] decr = new char[line2.length()];
				for (int i = 0; i < line2.length(); i++) {
					decr[i] = line2.charAt(i);
				}
				int[] u = new int[decr.length];
				for (int i = 1; i < u.length; i++) {
					if ((int)decr[i] == 32)
						u[i] = 0;
					else
						u[i] = (int)decr[i] - 96;
				}
				
				for (int i = 1; i < u.length; i++) {
					while (u[i] < u[i-1]) {
						u[i] += 27;
					}
				}
				int[] v = new int[u.length];
				v[0] = u[0];
				for (int i = 1; i < v.length; i++) {
					v[i] = u[i] - u[i-1];
				}
				for (int i = 1; i < v.length; i++) {
					if (v[i] == 0) {
						System.out.print(" ");
					}
					else
						System.out.print((char)(v[i]+96));
				}
			}
			System.out.println();
			n--;
		}
		in.close();
	}

}

