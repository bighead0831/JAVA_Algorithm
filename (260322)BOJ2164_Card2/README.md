# 📝 BOJ 2164: 카드2

> **문제 링크:** [백준 2164번](https://www.acmicpc.net/problem/2164)  
> **학습 날짜:** 2026-03-23  
> **핵심 개념:** `Queue`, `LinkedList`, `Resource Management`, `Clean Code`

---

## 🚀 1. Queue vs Deque (구조적 이해)
입력을 '양방향 빨대'로 이해했던 직관을 데이터 구조로 명확히 정리함.

| 특징 | Queue (큐) | Deque (데크) |
| :--- | :--- | :--- |
| **방향성** | 단방향 (FIFO) | **양방향 (Double-Ended)** |
| **주요 동작** | 한쪽 끝 삽입, 반대쪽 끝 추출 | **양쪽 끝 어디서든 삽입/추출 가능** |
| **Java 인터페이스** | `Queue<E>` | `Deque<E>` |
| **실생활 비유** | 맛집 줄 서기 | 양방향 통행이 가능한 터널 |

> **💡 핵심 요약:** `LinkedList`는 두 인터페이스를 모두 구현하고 있어, 선언 방식에 따라 필요한 기능을 선택해 사용할 수 있다.

---

## 🧩 2. Queue 메서드 및 효율성
데이터를 추가하고 삭제할 때 발생할 수 있는 예외 상황에 따른 메서드 차이.

- **추가:** `add(e)`는 실패 시 예외를 던지지만, `offer(e)`는 `false`를 반환함. (기존 큐 뒤에 추가됨)
- **삭제:** `poll()`은 첫 번째 요소를 삭제하며 반환함. 
- **Clean Code:** 데이터를 배열에 담았다가 옮기는 $O(N)$의 과정을 생략하고, 반복문을 통해 큐에 직접 삽입하여 메모리와 시간을 최적화함.

---

## ⚠️ 3. 자원 관리 (Resource Management)
`BufferedReader` 사용 시 자원 해제의 중요성과 방식의 차이.

| 구분 | throws IOException | try-with-resources |
| :--- | :--- | :--- |
| **방식** | JVM에 예외 처리를 맡김 | 블록 종료 시 자원을 **자동 반납** |
| **안전성** | 에러 발생 시 close() 미도달 위험 | **어떤 상황에서도 안전하게 자원 해제** |
| **사용 상황** | 빠른 알고리즘 풀이 (PS) | **실무 프로젝트, 안정성 중시 환경** |

> **💡 인사이트:** `br.close()`를 직접 호출하는 습관은 리소스 누수를 막는 훌륭한 습관이며, 실무형 인재로 성장하는 밑거름이 된다.

---

## 💻 구현 코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-with-resources를 사용하면 br.close()를 생략해도 자동 해제됨
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            if (line == null) return;
            int N = Integer.parseInt(line);
            
            Queue<Integer> q = new LinkedList<>();
            
            // 배열을 거치지 않고 직접 큐에 삽입 (Clean Code & Efficiency)
            for (int i = 1; i <= N; i++) {
                q.add(i);
            }

            while (q.size() > 1) {
                q.poll();           // 맨 위 카드 버리기
                q.add(q.poll());    // 그다음 카드를 맨 아래로 이동
            }

            // 최종 결과 출력 (반복문 내 출력을 지양하여 시간 초과 방지)
            System.out.println(q.poll());
        }
    }
}
```
