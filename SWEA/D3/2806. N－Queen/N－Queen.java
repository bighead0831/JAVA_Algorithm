import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N;
    private static boolean[] col;
    private static boolean[] mainDiagonal;
    private static boolean[] subDiagonal;
    
    private static int qcase;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            qcase = 0;
            N = Integer.parseInt(br.readLine().trim());
            col = new boolean[N+1];
            mainDiagonal = new boolean[2*N+1];
            subDiagonal = new boolean[2*N+1];
                
            setQueen(1);
            
            sb.append("#").append(test_case).append(" ")
                .append(qcase).append("\n");
		}
        System.out.print(sb);
	}
    
    private static void setQueen(int row) {
        if(row>N) {
            qcase++;
            return;
        }
        
        for(int c=1; c<=N; c++) {
            if(!isAvailable(row, c)) continue;
            col[c] = mainDiagonal[row-c+N] = subDiagonal[row+c] = true;
            setQueen(row+1);
            col[c] = mainDiagonal[row-c+N] = subDiagonal[row+c] = false;
        }
    }
    
    private static boolean isAvailable(int r, int c) {
        return !col[c] && !mainDiagonal[r-c+N] && !subDiagonal[r+c];
    }
}

/**
 * 시간복잡도: O(N!)
 * 원리: backtracking, 가지치기(pruning), 퀸의 위치 인덱스 값의 합 혹은 차를 활용한 연산 최적화
 */