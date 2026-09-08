import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb;
    
    private static int[] kyuCards; // 규영이가 가진 카드 덱 (순서 있음)
    private static int[] inCards; // 인영이가 가진 카드 덱 (순서 없음)
    
    private static boolean[] isSelected; // "인영이" 카드 선택여부
    
    private static int winCnt; // 이긴 횟수
    private static int loseCnt; // 진 횟수
    
	public static void main(String args[]) throws Exception {
        sb = new StringBuilder();
        
		int T=Integer.parseInt(in.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            init(); // 규영이, 인영이 카드 덱 세팅
            play(0, 0, 0); // 대결 횟수, 규영이 점수, 인영이 점수
            sb.append("#").append(test_case).append(" ")
                .append(winCnt).append(" ").append(loseCnt)
                .append("\n");
		}
        System.out.print(sb);
	}
    
    private static void play(int cnt, int kyuSum, int inSum) { // cnt: 경기횟수, kyuSum: 규영이 누적점수, inSum: 인영이 누적점수
        if(cnt==9) { // 9번의 경기 모두 치루고 나면, 각 인원의 누적점수 비교 및 승패 결정
            if(kyuSum > inSum) winCnt++;
            else if(kyuSum < inSum) loseCnt++;
            return;
        }
        
        for(int i=0; i<9; i++) { // 규영이 카드와 비교할 인영이 카드들
            if(isSelected[i]) continue; // 이미 선택된 인영이 카드일 경우 건너뛰기
            
            isSelected[i] = true; // 인영이 카드 선택!
            
            if(kyuCards[cnt] < inCards[i]) // 누적 경기횟수는 규영이카드의 인덱스와 같다. (이유: 규영이카드는 순서가 정해져 있기 때문이다)
                play(cnt+1, kyuSum, inSum+kyuCards[cnt]+inCards[i]);
            else if(kyuCards[cnt] > inCards[i])
                play(cnt+1, kyuSum+kyuCards[cnt]+inCards[i], inSum);
                                                         
            isSelected[i] = false;
        }
    }
    
    private static void init() throws IOException {
        winCnt = 0;
        loseCnt = 0;
        kyuCards = new int[9];
        inCards = new int[9];
        
        isSelected = new boolean[9];
        
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<9; i++)
            kyuCards[i] = Integer.parseInt(st.nextToken());
        
        boolean[] isSelectedCard=new boolean[19]; // 1~18
        for(int i=0; i<9; i++)
            isSelectedCard[kyuCards[i]] = true;
        
        int index=0;
        for(int i=1; i<19; i++) {
            if(isSelectedCard[i]) continue;
            inCards[index++] = i;
        }   
    }
}