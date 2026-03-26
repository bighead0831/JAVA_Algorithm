# 📝 BOJ 1158: 요세푸스 문제

> **문제 링크:** [백준 1158번](https://www.acmicpc.net/problem/1158)  
> **학습 날짜:** 2026-03-23  
> **핵심 개념:** `Queue`, `StringBuilder`, `Method Separation`, `Performance Optimization`

---

## 🚀 1. 문제 해결 전략 (Queue 활용)
이 문제는 원형으로 앉아 있는 사람들을 순차적으로 제거하는 시뮬레이션이다. 큐(Queue)의 FIFO 특성을 이용해 원형 구조를 선형적으로 구현했다.

- **핵심 로직:** 1. $K-1$번까지는 큐의 앞에서 빼서 뒤로 다시 넣는다 (`poll()` -> `add()`).
    2. $K$번째 사람은 큐에서 완전히 제거하고 결과에 추가한다.
    3. 큐가 빌 때까지 위 과정을 반복한다.

---

## 🧩 2. 배운 점 & 개선 포인트 (Lessons Learned)
기존 코드에서 더 나은 성능과 가독성을 위해 고민한 지점들이다.

### ✅ StringBuilder를 통한 출력 최적화
- **기존:** `System.out.print()`를 반복문 내에서 여러 번 호출.
- **개선:** `StringBuilder`를 사용해 문자열을 하나로 완성한 뒤 한 번만 출력.
- **이유:** 자바의 표준 출력은 시스템 리소스를 많이 소모하므로, 대량의 데이터 출력 시 성능 저하(시간 초과)의 원인이 됨.

### ✅ 메서드 분리와 가독성 (Clean Code)
- **우테코 기준:** 메서드 하나가 너무 많은 일을 하지 않도록 분리 시도.
- **적용:** 로직의 핵심인 '요세푸스 순열 생성' 부분을 별도 메서드로 분리하여 `main` 함수의 가독성을 높임.

### ✅ 불필요한 자료구조 제거
- 제거된 사람들을 담기 위해 별도의 `Queue`를 하나 더 만드는 대신, `StringBuilder`에 직접 담아 메모리 효율성을 높임.

---

## 💻 구현 코드 (My Original Logic)
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> oq = new LinkedList<>(); // 테이블 사람 큐
        
        for(int i = 1; i <= n; i++) oq.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(!oq.isEmpty()) {
            // k-1번 뒤로 이동
            for(int i = 1; i < k; i++) {
                oq.add(oq.poll());
            }
            // k번째 사람 제거
            sb.append(oq.poll());
            
            if(!oq.isEmpty()) sb.append(", ");
        }

        sb.append('>');
        System.out.println(sb.toString());
        br.close();
    }
}
```

---

## 💻 구현 코드 (Improved Logic)
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-with-resources로 자원 관리
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String result = getJosephusSequence(n, k);
            System.out.println(result);
        }
    }

    private static String getJosephusSequence(int n, int k) {
        Queue<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) people.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!people.isEmpty()) {
            // K-1번 뒤로 보내기
            for (int i = 0; i < k - 1; i++) {
                people.add(people.poll());
            }

            // K번째 사람 제거 및 결과 추가
            sb.append(people.poll());

            // 쉼표 처리 (마지막 요소가 아닐 때만)
            if (!people.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        return sb.toString();
    }
}
```

---

## 🛠️ 실리콘밸리 꿈을 향한 기록
알고리즘 풀이와 함께 **성능 최적화(I/O)**와 **코드 가독성**을 고민한 흔적을 남긴다.
오늘의 작은 개선이 나중에 대규모 트래픽을 처리하는 창업 아이템의 기초가 될 것이라 믿는다.
