import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> bookMap = new TreeMap<>(); // Map 인터페이스 안의 TreeMap 클래스 , Key는 String이고 Value는 Integer
        // TreeMap을 사용한 이유: 책 제목 순 자동 사전정렬로 저장

        for(int i=0; i<n; i++) { // bookMap에 책 넣기! key: 책 이름, value: 책 판매량
            String title = br.readLine();
            bookMap.put(title, bookMap.getOrDefault(title, 0)+1); // 책 이름 처음 들어가면 0, 그 이후론 1씩 증가
        }
        String result = getBestSeller(bookMap);

        System.out.println(result);
    }

    public static String getBestSeller(Map<String, Integer> map) {
        String bestseller = "";
        
        int maxSales = 0;

        for(String title : map.keySet()) {
            int currentSales = map.get(title);
            if(currentSales > maxSales) {
                maxSales = currentSales;
                bestseller = title;
            }
        }
        return bestseller;
    }
}