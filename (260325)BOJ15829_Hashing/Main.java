import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine()); // 문자열의 길이
        String str = br.readLine(); // 문자열
        long r = 31; // 문제에 주어진 상수
        long M = 1234567891; // 문제에 주어진 상수

        long result = 0; // overflow 대비를 위해 64비트 단위값인 long으로 바꾸기! int는 32비트라 약 21억까지만 수용가능...
        long x = 1;
        for(int i=0; i<L; i++) {
            int var = str.charAt(i)-'a'+1;
            result += (var*x)%M;
            x = (x*r)%M;
            result %= M;
        }

        System.out.println(result);
    }
}