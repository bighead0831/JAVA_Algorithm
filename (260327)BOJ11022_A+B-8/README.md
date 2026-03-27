[Silver V] A+B - 8 - 11022
문제 링크

📝 문제 개요
두 정수 A와 B를 입력받은 다음, Case #x: A + B = C 형식으로 출력하는 프로그램을 작성한다.

🚀 풀이 전략 (Solving Strategy)
단순한 사칙연산 문제이지만, 대량의 데이터를 처리할 때의 성능 최적화와 출력 형식의 가독성을 고려하여 구현했다.

1. 성능 최적화 (I/O Optimization)

Scanner 대신 BufferedReader 사용: Scanner는 내부적으로 정규표현식을 사용하여 느리지만, BufferedReader는 버퍼를 사용하여 대량의 입력을 훨씬 빠르게 읽어들인다.

StringBuilder 활용: System.out.println을 반복문 안에서 매번 호출하면 I/O 부하가 발생한다. StringBuilder에 결과값을 모았다가 한 번에 출력하여 성능을 개선했다.

2. 문자열 파싱 (String Parsing)

StringTokenizer: 공백으로 구분된 데이터를 효율적으로 분리하기 위해 사용했다. String.split()보다 성능 면에서 우수하다.

3. 클린 코드 (Clean Code)

메서드 분리: main 메서드에서 모든 로직을 처리하지 않고, 출력 형식을 만드는 로직을 별도의 formatResult 메서드로 분리하여 유지보수성과 가독성을 높였다.

💻 코드 (Final Refactored Version)
```
Java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(formatResult(i, a, b)).append("\n");
        }
        
        System.out.print(sb);
    }

    /**
     * 출력 형식을 생성하는 헬퍼 메서드
     */
    private static String formatResult(int caseNum, int a, int b) {
        return String.format("Case #%d: %d + %d = %d", caseNum, a, b, (a + b));
    }
}
```
💡 회고 (Reflecting)
처음에 charAt() 사용을 고민했으나, 입력값의 자릿수가 변할 수 있는 상황(A, B < 10 조건 변경 등)을 고려하여 더 유연한 StringTokenizer를 선택했다.

자바의 객체지향적 특성을 살려 로직을 분리하는 연습을 할 수 있었다.