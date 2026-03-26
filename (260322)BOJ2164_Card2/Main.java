import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 입력 받기 (자연수 N)
        int N = Integer.parseInt(br.readLine()); // 자연수 하나(N)만 받기 때문에 StringTokenizer 불필요 
        /* StringTokenizer는 여러 개의 입력을 한 줄에서 받을 때 유용하지만, 여기서는 한 줄에 하나의 숫자만 입력받으므로 필요하지 않음 */
        
        Queue<Integer> q = new LinkedList<>(); // 큐 생성
        // 추천하는 방식
        for (int i = 1; i <= N; i++)
            q.add(i); // 1부터 N까지의 카드를 큐에 추가

        while(q.size() > 1) { // 큐에 카드가 하나 남을 때까지 반복
            q.poll(); // 맨 위에 있는 카드 제거
            q.add(q.poll()); // 그 다음 카드를 맨 아래로 이동
        }
        System.out.println(q.poll()); // 마지막으로 남은 카드 출력
        br.close(); // 리소스 누수 방지 차원에서 BufferedReader 닫기
    }
}
