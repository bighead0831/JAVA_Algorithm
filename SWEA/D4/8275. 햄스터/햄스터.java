import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N; // 케이지 수
    private static int X; // 한 케이지당 햄스터 최대 수용량
    private static int M; // 경근이 기록 횟수
    
    private static int[][] records;
    
    private static int[] hamsters;
    private static int[] bestHamsters;
    
    private static int maxSum;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            dfs(1, 0);
            
            sb.append("#").append(test_case).append(" ");
            
            if(maxSum == -1)
                sb.append(maxSum);
            else
                for(int i=1; i<bestHamsters.length; i++)
                    sb.append(bestHamsters[i]).append(" ");
            sb.append("\n");
		}
        System.out.print(sb);
	}
    
    private static void dfs(int cageIdx, int sum) {
        if(cageIdx>N) {
            if(checkRecords()) {
                if(sum>maxSum) {
                    maxSum = sum;
                    for(int i=1; i<=N; i++) {
                        bestHamsters[i] = hamsters[i];
                    }
                }
            }
            return;
        }
        
        for(int i=0; i<=X; i++) { // 각 케이지에 들어가는 햄스터수
            hamsters[cageIdx] = i;
            dfs(cageIdx+1, sum+i);
        }
    }
    
    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        records = new int[M][3];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            records[i][0] = Integer.parseInt(st.nextToken());
            records[i][1] = Integer.parseInt(st.nextToken());
            records[i][2] = Integer.parseInt(st.nextToken());
        }
        
        hamsters = new int[N+1];
        bestHamsters = new int[N+1];
        maxSum = -1;
    }
    
    private static boolean checkRecords() {
        for(int i=0; i<M; i++) {
            int sum = 0;
            for(int j=records[i][0]; j<=records[i][1]; j++)
                sum += hamsters[j];
            
            if(sum!=records[i][2]) return false;
        }
        return true;
    }
}