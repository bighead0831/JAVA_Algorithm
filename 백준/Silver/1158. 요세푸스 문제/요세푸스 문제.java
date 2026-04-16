import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine()); // BufferedReader로 입력받은 한 줄을 StringTokenizer로 분리하기
        int n = Integer.parseInt(st.nextToken()); // 분리한 첫번째 요소는 n (1~n번까지의 사람)
        int k = Integer.parseInt(st.nextToken()); // 분리한 두번째 요소는 k (제거할 사람 순번)

        Queue<Integer> oq = new LinkedList<>(); // 테이블에 앉은 사람들을 나타내는 큐 생성
        Queue<Integer> rq = new LinkedList<>(); // 제거된 사람들(요세푸스 순열) 큐 생성

        for(int i = 1; i <= n; i++)
            oq.add(i); // 1부터 n까지의 사람들을 큐에 추가

        while(!oq.isEmpty()) { // 테이블에 앉은 사람이 남아있는 동안 반복
            for(int i = 1; i < k; i++) // k-1번 사람을 큐의 맨 뒤로 이동
                oq.add(oq.poll()); // 큐의 맨 앞에 있는 사람을 제거하고 다시 큐의 맨 뒤로 추가
            rq.add(oq.poll()); // k번째 사람을 제거하여 요세푸스 순열 큐에 추가
        }

        System.out.print('<'); // 요세푸스 순열의 시작을 알리는 '<' 출력
        for(int i = 0; i < n; i++) {
            System.out.print(rq.poll()); // 제거된 순으로 번호 출력
            if(i != n-1) System.out.print(", "); // 마지막 요소가 아니면 ', ' 출력
        }
        System.out.print('>'); // 요세푸스 순열의 끝을 알리는 '>' 출력
        br.close(); // 리소스 누수 방지 차원에서 BufferedReader 닫기
    }
}