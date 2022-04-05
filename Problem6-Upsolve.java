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
			int[] a = new int[n];
			int sz = 0;
			for(int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				sz = Math.max(sz, a[i]); // save the highest number
			}
			
			// create a boolean array that will have a value of true if visited
			boolean[] visited = new boolean[sz+1];
			Arrays.fill(visited, false);
			
			// 'mp' hashmap -> for storing the highest frequency
			HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
			
			// 'state' hashmap -> for storing the order
			HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
			
			int mx = 0;
			
			for(int i = 0; i < n; i++) {
				
				// count the number of consecutive occurrences of the current element
				int id = i;
				while(a[id] == a[i] && id < n) {
					id++;
					if(id == n) {
						break;
					}
				}
				
				// update the highest consecutive frequency of the current element
				mp.put(a[i], Math.max(mp.getOrDefault(a[i], 1), id - i));
				
				// if the highest consecutive frequency of the current element is
				// greater than the stored maximum frequency, then update it
				// also, make sure to mark the current element as visited to save
				// its order because the same segment might appear again (in this case
				// we need to choose the segment which appeared first in the sequence)
				// the second condition checks if the another element has the same frequency
				// but the value is different so in this case we need to include it in the final answer
				if((mp.get(a[i]) > mx) || (mp.get(a[i]) == mx && !visited[a[i]])) {
					mx = mp.get(a[i]);
					state.put(a[i], i);
					visited[a[i]] = true;
				}
				
				// skip the elements a[i], ..., a[id-1]
				i = id - 1;
			}
			
			for(int i = 0; i < n; i++) {
				
				// blocks with consecutive same elements
				int id = i;
				while(a[id] == a[i] && id < n) {
					id++;
					if(id == n) {
						break;
					}
				}
				
				// output only the element with the highest consecutive frequency
				// note: don't forget to check if the current starting index of
				// this segment is equal to what has been stored earlier (state)
				if(state.containsKey(a[i])) {
					if(mp.get(a[i]) == mx && state.get(a[i]) == i) {
						System.out.print(a[i] + " ");
					}
				}
				
				// skip the elements a[i], ..., a[id-1]
				i = id - 1;
			}
			System.out.println();
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
