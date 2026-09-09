import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N;
    private static int ALL_ONES;
    private static int cnt;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine().trim());

            // N=4일때 -> (1<<4)-1 = 15 (이진수: 1111)
            // 1은 채워진 수
            ALL_ONES = (1<<N)-1;
            
            setQueen(0, 0, 0);
            
            sb.append("#").append(test_case).append(" ")
                .append(cnt).append("\n");
		}
        System.out.print(sb);
	}
    
    private static void setQueen(int cols, int mainDiag, int subDiag) {
        if(cols == ALL_ONES) { // 모든 열에 퀸이 다 채워진 경우
            cnt++;
            return;
        }
        // 현재 행에서 퀸을 놓을 수 있는 모든 위치 (1인 비트가 가능한 위치)
        int available = ALL_ONES & ~(cols | mainDiag | subDiag);
        
        while(available > 0) {
            // 가장 오른쪽 1(가능한 위치) 추출
            int p = available & -available;
            
            // 다음 행으로 이동(대각선은 1비트씩 시프트)
            setQueen(cols | p, (mainDiag | p) << 1, (subDiag | p) >> 1);
            
            // 처리한 위치 비트 제거
            available = available & (available-1);
            
        }
    }
}

/**
 * 시간복잡도: O(N!)
 * 원리: 비트마스킹!! 
 */