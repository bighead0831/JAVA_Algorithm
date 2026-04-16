import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in  );
        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int current = sc.nextInt();
            min = min>current?current:min; // Math.min(min, current);   
            max = max<current?current:max; // Math.max(max, current);  
        }
        System.out.println(min + " " + max);

        sc.close();
    }
}