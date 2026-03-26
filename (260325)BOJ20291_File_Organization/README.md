🚀 강민님의 Java 정복 & 실리콘밸리 창업을 위한 첫걸음
일시: 2026년 3월 25일 (직보반 D-7)

기록자: 개발 메이트 루키(Rookie)

목표: 백준 Gold 4 달성 & 우테코(Uteco) 합격 가즈아!

1. 🏗️ Java의 뼈대 (Structure)
자바는 C언어보다 엄격한 '객체지향 안전제일주의' 언어입니다.

public class Main: 파일명(Main.java)과 동일해야 하며, 프로그램의 모든 코드는 클래스 내부에 존재해야 합니다.

public static void main(String[] args): 자바 프로그램의 '입구'입니다.

String[] args: 외부에서 넘겨받는 데이터를 담는 주머니입니다.

throws IOException: 자바의 안전벨트입니다. 입출력 시 발생할 수 있는 사고를 대비해 미리 선언합니다. (BufferedReader 사용 시 필수!)

2. 📏 네이밍 컨벤션 (Naming Convention)
실리콘밸리급 협업을 위한 글로벌 표준 약속입니다.

구분	규칙	예시	비고
클래스	PascalCase	FileAnalyzer	대문자로 시작
변수/메서드	camelCase	extensionCount	소문자로 시작
상수	UPPER_SNAKE	MAX_SIZE	전체 대문자
3. ✂️ 문자열 조작 (String Manipulation)
JS의 split보다 더 정교하고 강력한 도구들입니다.

split(regex): 정규 표현식 기반. 마침표(.)로 자를 땐 split("\\.")을 기억할 것!

StringTokenizer: 단순 문자열 분리용. split보다 훨씬 빠름(알고리즘 추천).

StringBuilder: 문자열을 합칠 때 쓰는 '화이트보드'. 반복문 안에서 + 연산을 쓰면 메모리 낭비가 심하므로 필수 사용!

4. 📦 컬렉션 프레임워크 (Collections)
데이터를 효율적으로 관리하기 위한 설계도(Interface)와 제품(Class)의 관계입니다.

💡 다형성(Polymorphism)의 마법

구현체(제품)에 의존하지 않고 **인터페이스(설계도)**에 의존하는 것이 일류 개발자의 습관입니다.

Java
// ❌ 덜 유연한 방식 (클래스에 의존)
TreeMap<String, Integer> map = new TreeMap<>();

// ✅ 일류 개발자 방식 (인터페이스에 의존)
Map<String, Integer> extensionMap = new TreeMap<>();
Map: Key-Value 쌍.

TreeMap: 데이터를 넣으면 자동으로 오름차순 정렬해 주는 기특한 녀석.

getOrDefault(key, 0) + 1: 자바에서 개수를 셀 때 쓰는 마법의 주문.

5. 🛠️ 우테코(Uteco) 통과를 위한 클린 코드 미션
메서드 15라인 이하: 기능을 쪼개고 또 쪼개기.

의미 있는 이름: String s 대신 String extension.

불변성 이해: String은 변하지 않으니, 변화가 많을 땐 StringBuilder.

💌 Rookie의 응원 메시지

"강민님, 2026년 4월 1일 직보반 시작과 함께 이 README.md 파일이 강민님의 성장을 증명하는 첫 번째 페이지가 될 거예요. 군 생활 마무리하며 틈틈이 공부하는 그 성실함이 훗날 실리콘밸리 창업의 가장 큰 자산이 될 겁니다. 모르는 건 언제든 물어보세요, 저는 강민님의 영원한 코치니까요!"