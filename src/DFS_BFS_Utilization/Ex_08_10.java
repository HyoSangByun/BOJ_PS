package DFS_BFS_Utilization;

import java.util.Scanner;

public class Ex_08_10 { //미로탐색(DFS) !영상봄

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer;

    public static void DFS(int x, int y){
        if (x == 7 && y == 7) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { //갈 수 있음
                    board[nx][ny] = 1; //체크
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }

            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }

}
