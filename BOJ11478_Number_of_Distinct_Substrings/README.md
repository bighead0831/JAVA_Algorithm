# BOJ 11478 - 서로 다른 부분 문자열의 개수

## 📌 문제 정보

| 항목 | 내용 |
|------|------|
| 문제 번호 | [11478](https://www.acmicpc.net/problem/11478) |
| 난이도 | Silver 3 |
| 분류 | 문자열, 자료 구조 |
| 시간 제한 | 1초 |
| 메모리 제한 | 512MB |

---

## 📝 문제 설명

문자열 S가 주어졌을 때, **S의 서로 다른 부분 문자열의 개수**를 구한다.

- 부분 문자열: S에서 연속된 일부분 (길이 ≥ 1)
- 중복되는 부분 문자열은 하나로 취급

**예시**  
`ababc`의 부분 문자열 → `a, b, c, ab, ba, bc, aba, bab, abc, abab, babc, ababc` = **12개**

---

## 💡 풀이 접근

### 핵심 아이디어

1. **이중 반복문**으로 가능한 모든 부분 문자열을 추출
2. **HashSet**을 이용해 중복을 자동으로 제거
3. 최종 HashSet의 크기가 곧 서로 다른 부분 문자열의 개수

### 부분 문자열 추출 방법

```
문자열: "ababc" (길이 5)

i=0 기준: a / ab / aba / abab / ababc
i=1 기준:  b /  ba /  bab /  babc
i=2 기준:       a /   ab /   abc
i=3 기준:            b /    bc
i=4 기준:                   c
```

- **외부 반복문 `i`** : 부분 문자열의 시작 인덱스
- **내부 반복문 `j`** : 부분 문자열의 끝 인덱스 (exclusive)
- `substring(i, j)` 로 각 구간의 부분 문자열 추출

---

## ✅ 최종 코드

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> set = new HashSet<>(); // 중복 제거를 위한 HashSet

        for (int i = 0; i < s.length(); i++) {          // 시작 인덱스
            for (int j = i + 1; j <= s.length(); j++) { // 끝 인덱스
                String tempS = s.substring(i, j);        // 부분 문자열 추출
                set.add(tempS);                          // HashSet에 추가 (중복 자동 제거)
            }
        }

        System.out.println(set.size()); // 서로 다른 부분 문자열의 개수 출력
    }
}
```

---

## 🔑 핵심 개념 정리

### 1. `String.substring(int begin, int end)`

| 항목 | 내용 |
|------|------|
| 기능 | 문자열의 `begin` 이상 `end` 미만 구간을 잘라서 반환 |
| begin | 시작 인덱스 (포함) |
| end | 끝 인덱스 (미포함, exclusive) |
| 예시 | `"ababc".substring(0, 3)` → `"aba"` |

### 2. `HashSet<String>`

| 항목 | 내용 |
|------|------|
| 특징 | 중복 원소를 허용하지 않음 |
| 시간 복잡도 | `add()`, `contains()` 평균 O(1) |
| 활용 | 동일한 부분 문자열이 여러 번 등장해도 자동으로 하나만 유지 |

> `HashSet`은 내부적으로 해시 함수를 사용하므로, 같은 문자열은 항상 같은 해시값을 가져 중복이 제거된다.

### 3. 이중 반복문을 통한 부분 문자열 완전 탐색

길이 N인 문자열의 가능한 부분 문자열 수:

$$\frac{N \times (N+1)}{2}$$

- N = 1,000일 때 최대 **500,500개**의 부분 문자열 탐색
- 중복을 제외하면 실제 HashSet 크기는 이보다 작음

---

## ⏱ 시간 복잡도

| 구분 | 복잡도 |
|------|--------|
| 부분 문자열 추출 | O(N²) |
| HashSet 삽입 (문자열 비교 포함) | O(N) per insert |
| 전체 | **O(N³)** (최악) |

> 입력 길이가 최대 1,000이므로 최대 약 10억 연산이지만, 실제로는 substring 연산이 짧은 경우가 많아 제한 시간 내에 통과 가능하다.

---

## 🔄 다른 풀이 방향 (참고)

| 방법 | 특징 |
|------|------|
| **HashSet (현재 풀이)** | 구현 간단, O(N³) |
| **Suffix Array + LCP** | O(N log N), 고급 문자열 알고리즘 |
| **Trie (트라이)** | 부분 문자열을 트리로 관리, 메모리 사용 많음 |

