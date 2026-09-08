import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N; // 재료의 수
    private static int M; // 조합금지 수
    
    private static int[][] noMix; // 조합금지 케이스 배열
    
    private static int mixCnt; // 조합가능 수
    
    private static boolean[] isSelected; // 조합에서 선택한 재료 배열
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
			init();
            mix(1);
            
            sb.append("#").append(test_case).append(" ")
                .append(mixCnt)
                .append("\n");
		}
        System.out.print(sb);
	}
    
    private static void mix(int idx) {
        if(idx>N) { // 모든 재료를 선택하였을 때 최종 검사
            for(int i=0; i<M; i++) {
                if(isSelected[noMix[i][0]] && isSelected[noMix[i][1]]) // 조합불가한 햄버거는 바로 리턴
                    return;
            }
            mixCnt++; // 모든 조건 통과시 카운트
            return;
        }
        
        // 현재 재료를 버거에 포함시킬 경우
        isSelected[idx] = true;
        mix(idx+1);

        // 현재 재료를 버거에 미포함시킬 경우
        isSelected[idx] = false;
        mix(idx+1);
    }
    
    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        mixCnt = 0;
        isSelected = new boolean[N+1];
        
        noMix = new int[M][2];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            noMix[i][0] = Integer.parseInt(st.nextToken());
            noMix[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}

/**
 * 시간복잡도: O(2**N x M)
 * 원리: 완전탐색(브루트포스)
 */