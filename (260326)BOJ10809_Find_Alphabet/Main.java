import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Map<Character, Integer> alphabet = new TreeMap<>(); // 알파벳 순서대로 정렬하기 위해 TreeMap 사용
        for(char c = 'a'; c <= 'z'; c++) 
            alphabet.put(c, -1); // 트리맵 alphabet -1로 초기화

        for(int i=0; i<s.length(); i++) {
            char ca = s.charAt(i);
            if(alphabet.get(ca) == -1)
                alphabet.put(ca, alphabet.get(ca)+1+i);
        }

        // a부터 z까지 결과 출력
        String result = "";
        for(char c = 'a'; c<='z'; c++)
            result = result + alphabet.get(c) + " ";
        System.out.println(result);
    }
}

// O(n)