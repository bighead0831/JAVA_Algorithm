import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> extensionMap = new TreeMap<>();
        
        for(int i=0; i<n; i++) {
            String file = br.readLine();
            StringTokenizer st = new StringTokenizer(file, "."); // StringTokenizer에서는 정규식 안 써도 됨.("\\." -> ".")
            st.nextToken(); // 파일명 버리기
            String extension = st.nextToken(); // 확장자 저장

            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1); // 각 확장자 매핑 및 개수 카운팅
        }

        StringBuilder sb = new StringBuilder();
        for(String key : extensionMap.keySet()) {
            sb.append(key).append(" ").append(extensionMap.get(key)).append("\n");
            // key를 먼저 보여주고, key의 값을 보여주기. (append함수를 통해 문자열 합치기)
        }
        System.out.println(sb.toString());
    }
}