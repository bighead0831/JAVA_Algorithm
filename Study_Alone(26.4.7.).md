🚀 Java Mastery: Primitive vs Object & Sorting
날짜: 2026년 4월 7일 (직보반 교육 중)

주제: 자바 기본형 배열의 한계와 객체 지향적 설계의 이해

1. 🛑 문제 상황: Arrays.sort()의 컴파일 에러
int[] 배열에 람다식((i1, i2) -> i1 - i2)을 사용하여 커스텀 정렬을 시도했을 때 에러가 발생함.

원인: 자바의 Arrays.sort(T[], Comparator) 메서드는 **객체 배열(T[])**만 인자로 받을 수 있음.

결과: int는 객체가 아닌 '기본형'이므로, 람다식이라는 '똑똑한 명령'을 들을 수 있는 인터페이스가 존재하지 않음.

🏗️ 2. 기본형(Primitive) vs 객체(Object/Reference)
구분	기본형 (int, double 등)	객체 (Integer, String 등)
정체	데이터 그 자체 (값)	데이터를 감싸고 있는 금고 (참조)
메모리	스택(Stack) 영역에 직접 저장	힙(Heap) 영역에 생성, 주소값만 저장
특징	가볍고 빠름, 기능을 가질 수 없음	무겁지만 다양한 메서드와 기능을 가짐
📦 3. 객체 배열 (Object Array)이란?
정의: 실제 값이 아닌, 객체가 들어있는 주소값들의 목록을 담은 배열.

예시: Integer[], String[], User[] 등.

장점: 람다식, 제네릭(Generic) 등 자바의 고차원 기능을 모두 활용할 수 있음.

⚖️ 4. 실전 선택 가이드: int[] vs Integer[]
✅ int[]를 써야 할 때 (성능 우선)

알고리즘 문제 풀이: 메모리 제한이 타이트하고 실행 시간이 중요할 때.

대량의 숫자 처리: 데이터가 수십만 개 이상일 때 (메모리 사용량이 4~6배 적음).

기본 정렬: 단순 오름차순 정렬만 필요할 때 (Arrays.sort(int[]) 활용).

✅ Integer[]를 써야 할 때 (기능 우선)

커스텀 정렬: 람다식을 이용해 복잡한 정렬 조건(내림차순, 길이순 등)을 적용할 때.

컬렉션 사용: List<Integer> 등 자바 컬렉션 프레임워크에 담아야 할 때.

Null 허용: 데이터에 '값이 없음'을 뜻하는 null이 포함될 수 있을 때.

💡 오늘의 깨달음 (Key Takeaway)
"무조건 편리한 기능(객체)만 고집하는 것이 아니라, 상황에 맞는 최적의 도구를 선택하는 것이 실리콘밸리 엔지니어의 핵심 역량이다. 람다를 쓰기 위해 Integer[]를 쓰는 것은 코드를 읽기 좋게 만들지만, 성능이 중요하다면 int[]와 기본 정렬을 사용해야 한다."

🛠️ 리팩토링 팁: 내 스타일(람다) 유지하며 정렬하기
만약 int[]에서 꼭 람다를 쓰고 싶다면 Java Stream을 활용하자!

```Java
answer = Arrays.stream(answer)
               .boxed() // int를 Integer로 변환
               .sorted((a, b) -> a - b) // 람다 정렬
               .mapToInt(i -> i) // 다시 int로
               .toArray();
```

📦 Java Deep Dive: Autoboxing & The Array Mystery
작성일: 2026년 4월 7일 (직보반 교육 중)

기록자: 강민 (Kang Min)

주제: 자바의 자동 형변환 메커니즘과 배열 처리의 한계점 분석

1. 🔄 Autoboxing & Unboxing
자바 컴파일러가 기본형(Primitive)과 래퍼 클래스(Wrapper Class) 사이를 자동으로 변환해주는 편의 기능입니다.

🔹 개념 정의

Autoboxing: int → Integer (기본형을 객체 상자에 담음)

Unboxing: Integer → int (상자에서 기본형 값을 꺼냄)

🔹 발생 상황

컬렉션 사용 시: list.add(10) -> 내부적으로 Integer.valueOf(10) 호출.

연산 수행 시: Integer x = 10; int y = x + 5; -> x.intValue()로 언박싱 후 연산.

⚠️ 주의사항 (Pitfalls)

성능 저하: 반복문 내 과도한 오토박싱은 불필요한 객체를 대량 생성하여 GC(Garbage Collector)의 부담을 가중시킴.

NPE 위험: null인 Integer 객체를 언박싱하려고 하면 NullPointerException 발생.

2. ❓ 왜 배열은 오토박싱(Autoboxing)이 안 될까?
int n = 10; Integer obj = n;은 성공하지만, int[] arr = {1, 2}; Integer[] objArr = arr;는 컴파일 에러가 발생하는 이유를 분석함.

🚫 이유 1: 변환 비용의 가시성 (Performance Cost)

단일 변수의 오토박싱은 매우 가벼운 작업(O(1))이지만, 배열 전체를 변환하는 것은 데이터 개수(N)만큼의 객체를 새로 생성해야 하는 무거운 작업(O(N))임.

자바의 설계 철학: 성능에 큰 영향을 줄 수 있는 무거운 작업을 개발자 몰래 '자동'으로 수행하지 않음. 개발자가 직접 비용을 인지하고 코딩하도록 유도함.

🚫 이유 2: 메모리 구조의 근본적 차이

int[]: 메모리에 4바이트 숫자들이 연속적으로 붙어 있는 구조.

Integer[]: 메모리에 객체의 주소값(Reference)들이 담겨 있고, 각 주소가 실제 객체를 가리키는 구조.

두 배열은 메모리 레이아웃 자체가 완전히 다르므로 단순히 '캐스팅'이나 '자동 변환'이 불가능함.

🚫 이유 3: 타입 계층 구조 (Type Hierarchy)

자바에서 int[]는 Object이기는 하지만, Object[]의 하위 타입은 아님.

따라서 Arrays.sort(T[] a, Comparator c)와 같이 객체 배열(T[])을 요구하는 메서드에 int[]를 전달할 수 없음.

3. 💡 실리콘밸리 엔지니어의 의사결정 (Best Practice)
상황	권장 도구	이유
대량의 숫자 정렬	Arrays.sort(int[])	오토박싱 오버헤드 없이 O(NlogN) 속도로 가장 빠르게 처리 가능.
복잡한 커스텀 정렬	Integer[] + Lambda	성능 손실을 감수하더라도 코드의 가독성과 정렬 조건의 유연함이 중요할 때.
메모리 최적화	int[]	Integer[] 대비 약 4~6배 적은 메모리 사용.
🏁 최종 요약 (Key Takeaway)
"자바에서 int[] 배열이 람다 정렬을 지원하지 않는 것은 결함이 아니라, 시스템의 성능을 보호하기 위한 의도적인 설계이다. 성능이 중요하다면 기본형 배열 전용 메서드를 사용하고, 유연함이 중요하다면 명시적으로 객체화(Boxing)하여 사용하자!"