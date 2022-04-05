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
			int p = in.nextInt();
			String[] c = new String[p];
			for(int i = 0; i < p; i++) {
				c[i] = in.next();
			}
			String s = in.nextLine();
			for(int i = 0; i < p; i++) {
				int cnt = 0;
				for(int j = 0; j + c[i].length() <= s.length(); j++) {
					String str = s.substring(j, j + c[i].length());
					// don't forget to ignore the case of the letters
					if(str.equalsIgnoreCase(c[i])) {
						cnt++;
					}
				}
				System.out.println(c[i] + " " + cnt);
			}
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
				} catch (IOException e) {
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
