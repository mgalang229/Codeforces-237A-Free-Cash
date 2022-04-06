import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
//		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver { 
		Solver() {
			
			// input
			int n = in.nextInt();
			int[] h = new int[n];
			int[] m = new int[n];
			for(int i = 0; i < n; i++) {
				h[i] = in.nextInt();
				m[i] = in.nextInt();
			}
			
			// find the longest segment with same consecutive time
			int mx = 0;
			for(int i = 0; i < n; i++) {
				int id = i;
				while(h[id] == h[i] && m[id] == m[i] && id < n) {
					id++;
					if(id == n) {
						break;
					}
				}
				mx = Math.max(mx, id - i);
				i = id - 1;
			}
			
			// output
			System.out.println(mx);
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
