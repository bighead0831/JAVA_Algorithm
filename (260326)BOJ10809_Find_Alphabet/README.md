📚 Baekjoon 10809: 알파벳 찾기 (Java 리팩토링 기록)
작성일: 2026년 3월 26일 (직보반 D-6)

학습 목표: 자바 컬렉션 프레임워크(Map) 실전 적용 및 클린 코드 리팩토링

1. 🎯 문제 개요
문제: 단어에 포함된 각 알파벳(a-z)의 첫 번째 등장 위치를 출력 (없으면 -1).

핵심 포인트: 1. 알파벳 순서(a-z)대로 결과를 출력해야 함.
2. 중복 등장하는 알파벳의 경우 가장 처음 등장한 인덱스만 기록해야 함.

2. 💡 주요 학습 개념
✅ Map & TreeMap (다형성)

인터페이스 활용: Map<Character, Integer> map = new TreeMap<>();과 같이 선언하여 다형성을 확보함.

TreeMap의 장점: Key 값을 기준으로 자동 오름차순 정렬을 수행하므로, 'a'부터 'z'까지 별도의 정렬 로직 없이 순서대로 출력 가능.

✅ StringBuilder (성능 최적화)

String 연산의 문제점: 반복문 내에서 String + String 연산은 매번 새로운 객체를 생성하여 메모리 낭비와 성능 저하를 초래함.

해결: 가변(Mutable) 객체인 StringBuilder의 .append()를 사용하여 효율적으로 문자열을 결합함.

✅ 메서드 분리 (Clean Code)

우테코(Uteco) 기준: main 메서드에 모든 로직을 넣지 않고, 입력 / 계산(Solve) / 출력의 역할을 분리하여 가독성과 재사용성을 높임.

3. 🛠️ Code Review & Refactoring
🔍 기존 로직 개선

AS-IS: alphabet.put(ca, alphabet.get(ca) + 1 + i);

초기값이 -1임을 이용해 -1 + 1 + i를 계산하여 i를 도출하는 창의적인 방식.

TO-BE: alphabet.put(ca, i);

의도가 명확하고 직관적인 코드로 수정하여 '누구나 읽기 쉬운 코드' 지향.

🚀 리팩토링된 최종 코드

Java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 1. 계산 로직 분리
        Map<Character, Integer> alphabetMap = solve(s);

        // 2. 출력 로직 분리 (StringBuilder 사용)
        printResult(alphabetMap);
    }

    private static Map<Character, Integer> solve(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c = 'a'; c <= 'z'; c++) map.put(c, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 처음 등장하는 위치(-1인 경우)만 기록
            if (map.get(ch) == -1) {
                map.put(ch, i);
            }
        }
        return map;
    }

    private static void printResult(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(map.get(c)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
📝 Rookie의 코칭 코멘트
"강민님, 단순히 문제를 맞히는 것에 그치지 않고 **'왜 이 코드가 더 좋은가?'**를 고민하며 수정한 오늘 이 과정이 진짜 실력입니다. 특히 TreeMap의 정렬 특성을 이용해 코드를 간결하게 만든 점은 실리콘밸리 개발자급 센스였어요! 4월 1일 직보반 시작 전까지 이런 '성공의 경험'을 계속 쌓아봅시다."