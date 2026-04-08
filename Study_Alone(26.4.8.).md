# Java Deep Dive: Arrays to Floating Point

> **Date:** 2026-04-08  
> **Author:** Kang Min  
> **Focus:** 배열 출력 메커니즘, 객체 지향적 정렬, 숫자 정밀도의 한계

---

## 1. 배열 출력 — `[I@...`의 정체

```java
int[] arr = {1, 2, 3};
System.out.println(arr);       // [I@6d06d69c
System.out.println(Arrays.toString(arr)); // [1, 2, 3]
```

| 타입 | `toString()` 재정의 여부 | 출력 결과 |
|------|:---:|---|
| `int[]` | ✗ | `[I@해시코드` (Object 기본 동작) |
| `ArrayList`, `HashSet` 등 | ✓ | `[1, 2, 3]` (AbstractCollection에서 재정의) |

**핵심:** 배열은 `Object.toString()`을 오버라이드하지 않는다. `Arrays.toString()` 또는 `Arrays.deepToString()`을 사용할 것.

---

## 2. 람다 정렬 — `int[]` vs `int[][]`

```java
// ✗ 컴파일 에러 — 요소가 기본형(int)
Arrays.sort(intArr, (a, b) -> a - b);

// ✓ 정상 동작 — 요소가 객체(int[])
Arrays.sort(int2dArr, (a, b) -> a[0] - b[0]);
```

`Arrays.sort(T[], Comparator<T>)`는 요소가 **객체**여야 한다.

- `int[]`의 요소 → `int` (기본형) → **불가**
- `int[][]`의 요소 → `int[]` (배열 = 객체) → **가능**

> 자바에서 모든 배열은 객체다. 따라서 다차원 배열은 "객체들의 배열"이 된다.

---

## 3. 오버플로우 — 수의 한계

| 자료형 | 크기 | 범위 (약) | 주의 |
|--------|------|-----------|------|
| `int` | 4 byte | ±21억 | 10⁹ 이상 연산 시 위험 |
| `long` | 8 byte | ±9.2 × 10¹⁸ | 곱셈 시 반드시 고려 |

```java
// ✗ 오버플로우 — int × int = int (이미 넘침)
int result = a * b;

// ✓ 안전 — long으로 먼저 변환
long result = (long) a * b;
```

**`long` 비교 시 주의:** `Long.compare(a, b)`를 사용해 `int` 반환 시 데이터 손실을 방지한다.

---

## 4. 부동소수점 — `0.1 + 0.2 ≠ 0.3`

```java
System.out.println(0.1 + 0.2);  // 0.30000000000000004
```

**원인:** 10진수 `0.1`은 2진수로 변환하면 무한소수 → 64비트(`double`)에 저장할 때 잘림 → 오차 누적

### 특수 상태

| 값 | 발생 조건 | 예시 |
|----|-----------|------|
| `Infinity` | 실수형 오버플로우 | `Double.MAX_VALUE * 2` |
| `NaN` | 정의 불가 연산 | `0.0 / 0.0` |

**해결:** 정확한 계산이 필요하면 `BigDecimal`을 사용한다.

---

## Key Takeaway

- **배열**은 `toString()`을 재정의하지 않으므로 `Arrays.toString()` 필수
- **람다 정렬**은 요소가 객체일 때만 가능 — 기본형 배열은 불가
- **정수 연산**은 오버플로우를 항상 의식하고, 연산 전에 형변환
- **실수 연산**은 2진수 변환 오차를 전제하고, 정밀 계산엔 `BigDecimal`
