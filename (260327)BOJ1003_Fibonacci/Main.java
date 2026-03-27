import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int [6][2]; // 2^6 > 40

            int chk = 0;
            while(true) {
                if(n!=0 && n!=1) {
                    n = n/2;
                    chk++;
                } else  {
                    break;
                }
            }


        }
    }
}

// 작성중.... 어렵다