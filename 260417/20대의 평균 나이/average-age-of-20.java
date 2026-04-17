import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = 0;
        while(num>=20 && num<30) {
            if(num>=30 && num<20) continue;
            else {
                sum += num;
                cnt++;
            }
            num = Integer.parseInt(br.readLine());
        }
        double avg = (double)sum/cnt;
        System.out.printf("%.2f", avg);

    }
}