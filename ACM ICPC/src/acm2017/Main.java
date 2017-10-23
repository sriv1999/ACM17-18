package acm2017;

import java.util.Scanner;

public class Main {
	static int a[] = new int[100010];
	static int b[] = new int[100010];
	static int posa[] = new int[100010];
	static int posb[] = new int[100010];
	static int pa[] = new int[100010];
	static int p;

	public static void solve(int pos, int l, int r, int fa) {
		if (l > r)
			return;
		if (a[pos] == b[l]) {
			pa[a[pos]] = fa;
			p++;
			solve(pos+1, l+1, r, a[pos]);
			if (p - pos <= r - l) {
				int tmp = p;
				pa[a[tmp]] = fa;
				p++;
				solve(tmp + 1, 1 + tmp - pos + 1, r, a[tmp]);
			}
		}
		else {
			pa[a[pos]]=fa;
	        p++;
	        int len1=posa[b[l]]-pos-1;
	        solve(pos+1,posb[a[pos]]+1,posb[a[pos]]+len1,a[pos]);
	        pa[b[l]]=fa;
	        p++;
	        solve(posa[b[l]]+1,l+1,posb[a[pos]]-1,b[l]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while (t > 0) {
			int n = in.nextInt();
			for (int i = 1; i < n; i++) {
				a[i] = in.nextInt();
				posa[a[i]] = i;
			}
			for(int i=1;i<=n;++i) {
	            b[i] = in.nextInt();
	            posb[b[i]]=i;
			}
			p=1;
	        solve(1,1,n,0);
	        for(int i=1;i<=n;++i){
	            if(i>1) 
	            		System.out.printf(" ");
	            System.out.printf("%d",pa[i]);
	        }
	        System.out.printf("\n");
	        t--;
		}
		in.close();
	}

}
