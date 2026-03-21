# 📝 BOJ 10818: 최소, 최대

> **문제 링크:** [백준 10818번](https://www.acmicpc.net/problem/10818)  
> **학습 날짜:** 2026-03-21  
> **핵심 개념:** `BufferedReader`, `StringTokenizer`, `IOException`

---

## 🚀 1. Scanner vs BufferedReader
자바의 입출력 방식에 따른 성능 차이
-> 100만 개 이상의 데이터를 처리할 때는 **BufferedReader** 사용이 필수적!

| 특징 | Scanner | BufferedReader |
| :--- | :--- | :--- |
| **속도** | 느림 (데이터 많으면 위험) | **압도적으로 빠름 (PS 권장)** |
| **버퍼 크기** | 1KB (작음) | **8KB (대용량 처리에 유리)** |
| **편의성** | 높음 (형변환 자동) | 낮음 (String만 반환, 직접 변환 필요) |
| **스레드 안전** | No | **Yes (Thread-safe)** |
| **입력 방식** | 정규 표현식 기반 파싱 | 단순 문자열 읽기 (Reading) |

> **💡 핵심 요약:** `Scanner`는 편리하지만 정규식 분석 과정에서 비용이 많이 든다. 반면 `BufferedReader`는 버퍼를 이용해 한꺼번에 읽어오기 때문에 속도가 매우 빠르다.

---

## 🧩 2. StringTokenizer 활용
`BufferedReader.readLine()`은 한 줄을 통째로 읽어오기 때문에, 공백으로 구분된 숫자들을 하나씩 꺼내기 위해 `StringTokenizer`를 사용한다.

- `split(" ")`보다 `StringTokenizer`가 성능상 우위에 있어 알고리즘 풀이에서 선호한다.

---

## ⚠️ 3. 자바 예외 처리 (Checked Exception)
자바는 입출력 시 발생할 수 있는 오류를 예방하기 위해 `IOException` 처리를 강제한다.

| 구분 | throws (책임 전가) | try-catch (직접 해결) |
| :--- | :--- | :--- |
| **방식** | 호출한 곳으로 예외를 던짐 | 에러 발생 지점에서 직접 처리 |
| **장점** | 코드가 간결하고 로직 집중 가능 | 프로그램 비정상 종료 방지 및 복구 가능 |
| **단점** | 예외 발생 시 프로그램 종료 | 코드가 길어지고 가독성 저하 |
| **사용 상황** | 알고리즘 문제 풀이 (PS) | 실무 프로젝트, 사용자 대화형 앱 |

---

## 💻 구현 코드
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 N은 읽어서 넘김 (st.hasMoreTokens()로 대체 가능)
        int n = Integer.parseInt(br.readLine());
        
        // 두 번째 줄의 숫자들을 토큰화
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            if (current < min) min = current;
            if (current > max) max = current;
        }

        System.out.println(min + " " + max);
        br.close();
    }
}