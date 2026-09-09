import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int[] price; // price information: {1D, 1M, 3M, 1Y}
    private static int[] plan; // paln using pool information: {0, Jan, Feb, Mar, ..., Nov, Dec}
    
    private static boolean[] useOk; // useOk one of months
    private static int minCost;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            spend(1, 0);
            sb.append("#").append(test_case).append(" ")
                .append(minCost).append("\n");
		}
        System.out.println(sb);
	}
    
    private static void spend(int month, int sumPrice) {
        if(minCost <= sumPrice) return; // Pruning
        if(month>12) {
            minCost = sumPrice;
            return;
        }
        
        if(plan[month]==0 || useOk[month])
            spend(month+1, sumPrice);
        
        // use Day Subscribtion
        spend(month+1, sumPrice+plan[month]*price[0]);
        
        // use 1Month Subscribtion
        spend(month+1, sumPrice+price[1]);
        
        // use 3Month Subscribtion
        for(int i=0; i<3; i++) {
            if(month+i<13)
            	useOk[month+i] = true;
        }
        spend(month+1, sumPrice+price[2]);
         for(int i=0; i<3; i++) {
            if(month+i<13)
            	useOk[month+i] = false;
        }
        
    }
    
    private static void init() throws IOException {
        price = new int[4]; // 1D, 1M, 3M, 1Y
        plan = new int[13]; // Year Plan of Visiting Swimming Pool
        
        useOk = new boolean[13];
        
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<4; i++)
            price[i] = Integer.parseInt(st.nextToken());

        minCost = price[3]; // pay subscribtion of year only one time 
        
        st = new StringTokenizer(br.readLine().trim());
        for(int i=1; i<=12; i++)
            plan[i] = Integer.parseInt(st.nextToken());
    }
}