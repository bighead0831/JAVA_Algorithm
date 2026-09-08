import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int H;
    private static int W;
    private static String[][] field;
    
    private static int posY;
    private static int posX;
    private static int dir;
    
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    private static int C;
    private static String[] commands;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine().trim());
        
		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            followCommands();
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    sb.append(field[i][j]);
                }
                sb.append("\n");
            }
		}
        System.out.print(sb);
	}
    
    private static void move() {
        int ny = posY+dy[dir];
        int nx = posX+dx[dir];
        if(isIn(ny, nx)) {
            if(field[ny][nx].equals(".")) {
                String tank = field[posY][posX];
                field[posY][posX] = ".";
                posY = ny;
            	posX = nx;
                field[posY][posX] = tank;
            }
        }
    }
    
    private static void shoot() {
        boolean isShot = false;
        int ny = posY+dy[dir];
        int nx = posX+dx[dir];
        
        while(isIn(ny, nx) && !isShot) {
            if(field[ny][nx].equals("*")) {
                isShot = true;
                field[ny][nx] = ".";
            } else if(field[ny][nx].equals("#")) {
                isShot = true;
            }
            ny += dy[dir];
            nx += dx[dir];
        }
    }
    
    private static void followCommands() {
        for(int c=0; c<C; c++) {
            switch(commands[c]) {
                case "U":
                    field[posY][posX] = "^";
                    dir=3;
                    move();
                    break;
                case "D":
                    field[posY][posX] = "v";
                    dir=1;
                    move();
                    break;
                case "L":
                    field[posY][posX] = "<";
                    dir=2;
                    move();
                    break;
                case "R":
                    field[posY][posX] = ">";
                    dir=0;
                    move();
                    break;
                case "S":
                    shoot();
                    break;
                default:
                    break;
            }
        }
    }
    
    private static void init() throws IOException {
        posX=-1;
        posY=-1;
        dir=-1;
        
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
        
        field = new String[H][W];
        
        for(int i=0; i<H; i++) {
            String[] oneLine = br.readLine().trim().split("");
        	for(int j=0; j<W; j++) {
            	field[i][j] = oneLine[j];
                if(field[i][j].equals(">")) {
                    posX=j;
                    posY=i;
                    dir=0;
                } else if(field[i][j].equals("v")) {
                    posX=j;
                    posY=i;
                    dir=1;
                } else if(field[i][j].equals("<")) {
                    posX=j;
                    posY=i;
                    dir=2;
                } else if(field[i][j].equals("^")) {
                    posX=j;
                    posY=i;
                    dir=3;
                }
            }
        }
        
        C = Integer.parseInt(br.readLine());
        commands = br.readLine().trim().split("");
    }
    
    private static boolean isIn(int y, int x) {
        return y<H && y>=0 && x<W && x>=0;
    }
}