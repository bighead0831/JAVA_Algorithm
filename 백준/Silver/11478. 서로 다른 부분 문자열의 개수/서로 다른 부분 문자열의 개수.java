import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> set = new HashSet<>(); // 중복되는 문자열이 있을 수 있으니 HashSet 활용

        for(int i=0; i<s.length(); i++) { // 문자열 쪼개는 지점 뒤로 이동
            for(int j=i+1; j<=s.length(); j++) { // 쪼개는 문자열 길이 증가
                String tempS = s.substring(i, j); // 문자열 s를 쪼개기 (substring 함수)
                if(!set.contains(tempS)) set.add(tempS); // 쪼갠 문자열 tempS가 해시셋 set에 미포함이면 추가
            }
        }

        System.out.println(set.size()); // 서로 다른 부분 문자열 개수 출력
    }
}