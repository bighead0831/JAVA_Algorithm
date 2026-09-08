import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N; // the number of Foods
    private static int L; // the Limits about Calorie
    
    private static int[][] food;
    private static boolean[] isSelected;
    private static int maxScore;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        
		int T=Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            cook(0, 0, 0);
            sb.append("#").append(test_case).append(" ")
                .append(maxScore)
                .append("\n");
		}
        System.out.print(sb);
	}
    
    private static void cook(int index, int scoreSum, int calorieSum) { // 조합횟수, 합산 점수, 합산 칼로리
        if(calorieSum>L) return;
        if(index==N) {
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }
        
        cook(index+1, scoreSum+food[index][0], calorieSum+food[index][1]); // 선택
        cook(index+1, scoreSum, calorieSum); // 미선택
    }
    
    private static void init() throws IOException {
        maxScore = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
    	N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        isSelected = new boolean[N]; // Array of selected Foods
        food = new int[N][2]; // Food: {Score, Calorie}
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}

/**
 * 시간복잡도: O(2**N)
 * 원리: Optional 부분집합 (재료를 넣거나, 안 넣거나)
 */