import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str0 = br.readLine();
        StringTokenizer nums_of_sets = new StringTokenizer(str0); // nums_of_sets 안에 문자열 2개 저장
        int a = Integer.parseInt(nums_of_sets.nextToken());
        int b = Integer.parseInt(nums_of_sets.nextToken());

        // 공백으로 원소가 구분된 집합A를 해시셋set1에 넣기
        String str1 = br.readLine();
        StringTokenizer setsNum_1 = new StringTokenizer(str1);
        HashSet<Integer> set1 = new HashSet<>();
        for(int i=0; i<a; i++)
            set1.add(Integer.parseInt(setsNum_1.nextToken()));

        // 공백으로 원소가 구분된 집합B를 해시셋set2에 넣기
        String str2 = br.readLine();
        StringTokenizer setsNum_2 = new StringTokenizer(str2);
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0; i<b; i++)
            set2.add(Integer.parseInt(setsNum_2.nextToken()));

        // set1 원소 중 set2와 중복된 것을 뺀 차집합ds1
        HashSet<Integer> ds1 = new HashSet<>(set1);
        ds1.removeAll(set2);

        // set2 원소 중 set1과 중복된 것을 뺀 차집합ds2
        HashSet<Integer> ds2 = new HashSet<>(set2);
        ds2.removeAll(set1);

        // 차집합ds1과 차집합ds2 원소 갯수 덧셈 (대칭 차집합)
        int result = ds1.size() + ds2.size();

        // 결과 출력
        System.out.println(result);
    }
}