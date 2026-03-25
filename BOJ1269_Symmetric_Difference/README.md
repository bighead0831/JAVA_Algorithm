🚀 Road to Silicon Valley: Set Operations (2026.03.25)
"효율적인 자료구조 선택이 알고리즘의 성능을 결정한다"
오늘의 성과: BOJ 1269 (대칭 차집합) 해결 및 클린 코드 리팩토링(Refactoring) 연습

📅 Today I Learned
1. HashSet의 강력함 ($O(1)$의 마법)

특징: 중복을 허용하지 않으며, 데이터 존재 여부를 확인(contains)하거나 추가/삭제하는 데 걸리는 시간 복잡도가 **O(1)**임.

학습 내용: 데이터가 20만 개 이상일 때, 일반적인 배열이나 리스트(O(N))를 쓰면 시간 초과가 나지만, HashSet을 쓰면 순식간에 해결 가능함을 확인.

2. Java의 다형성 (Interface vs Implementation)

HashSet<Integer> set = new HashSet<>() 대신 **Set<Integer> set = new HashSet<>()**처럼 인터페이스를 타입으로 사용하는 습관의 중요성 이해.

이는 나중에 구현체를 TreeSet 등으로 바꿔도 나머지 코드를 수정할 필요가 없게 만드는 **'유연한 설계'**의 기초임.

3. 수학적 사고를 이용한 최적화

대칭 차집합 $|A \Delta B|$를 구하는 두 가지 방법:

(A−B)∪(B−A) : 직관적이지만 집합을 새로 생성하고 삭제하는 과정이 필요함.

∣A∣+∣B∣−2∣A∩B∣ : 집합을 수정하지 않고 교집합의 개수만 세면 되므로 메모리와 성능 면에서 유리함.

🔍 코드 분석: 나의 코드 vs 루키의 코드
🔹 나의 코드 (First Approach)

특징: 문제의 정의에 충실한 직관적인 구현. removeAll 메서드를 활용하여 직접 차집합을 구함.

장점: 코드가 읽기 쉽고 논리 흐름이 명확함.

난관: new HashSet<>(set1)과 같이 **객체를 새로 생성(Deep Copy)**하는 과정에서 메모리 점유율이 높아질 수 있음.

🔸 루키의 코드 (Refactored Approach)
```java
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력부 분리
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        Set<Integer> setA = readSet(reader, sizeA);
        Set<Integer> setB = readSet(reader, sizeB);

        // 2. 대칭 차집합 계산 (교집합 개수를 빼는 방식이 더 효율적일 수 있음)
        int intersectionCount = countIntersection(setA, setB);
        
        // (A - B) + (B - A) 는 결국 (전체 합 - 교집합 * 2) 와 같습니다.
        int result = (setA.size() + setB.size()) - (2 * intersectionCount);

        System.out.println(result);
    }

    /**
     * 입력을 받아 Set을 생성하는 헬퍼 메서드
     */
    private static Set<Integer> readSet(BufferedReader reader, int size) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        return set;
    }

    /**
     * 두 집합의 교집합 원소 개수를 구하는 메서드
     */
    private static int countIntersection(Set<Integer> setA, Set<Integer> setB) {
        int count = 0;
        for (Integer num : setA) {
            if (setB.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
```

특징: 1. 메서드 분리: 입력(readSet)과 계산(countIntersection) 로직을 분리하여 main 함수를 간결하게 유지 (우테코 스타일).
2. 메모리 최적화: 새로운 집합을 생성하지 않고, 기존 집합을 순회하며 contains로 교집합 개수만 카운트.
3. 추상화: HashSet 대신 Set 인터페이스를 사용하여 객체지향적 설계 적용.

🚧 난관과 해결 (Troubleshooting)
난관 (Problem)	해결법 (Solution)
자바의 Set에는 인덱스([i]) 접근이 없어 당황함	for-each 구문(for (int num : set))을 사용하여 모든 원소를 순회함
객체 대입(set2 = set1) 시 원본이 같이 변하는 문제	new HashSet<>(set1)을 통해 새로운 공간에 복사하거나, 원본을 건드리지 않는 로직으로 변경함
🎯 앞으로의 목표
[ ] Map 자료구조 입문: Key-Value 쌍으로 데이터를 관리하는 HashMap 공부하기.

[ ] 클린 코드 습관화: 메서드 하나가 15라인을 넘지 않도록 쪼개는 연습 반복하기.

[ ] 전역 D-Day 관리: 6월 30일 전역 전까지 매일 1커밋(Commit) 유지하기.

Rookie's Comment:
"강민님, 오늘 HashSet을 활용해 문제를 푼 것은 단순한 정답을 넘어 **'엔지니어링'**을 시작하신 거예요. 특히 '참조(Reference)'의 개념을 이해하고 객체 복사 문제를 해결한 건 정말 큰 수확입니다! 내일은 이 Set의 형제 격인 Map을 활용해서 '숫자 카드' 문제를 한번 정복해 볼까요? 오늘 정말 고생 많으셨습니다. 충성! 🫡"