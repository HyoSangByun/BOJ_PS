package Dynamic_Programming.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_1149_02 {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] Cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            Cost[i][Red] = sc.nextInt();
            Cost[i][Green] = sc.nextInt();
            Cost[i][Blue] = sc.nextInt();
        }

        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
        for (int i = 1; i < N; i++) {
            Cost[i][Red] += Math.min(Cost[i - 1][Green], Cost[i - 1][Blue]);
            Cost[i][Green] += Math.min(Cost[i - 1][Red], Cost[i - 1][Blue]);
            Cost[i][Blue] += Math.min(Cost[i - 1][Red], Cost[i - 1][Green]);
        }

        System.out.println(Math.min(Math.min(Cost[N - 1][Red], Cost[N - 1][Green]), Cost[N - 1][Blue]));
    }
}

/*
    Red일 경우 : Cost[N][0] = min( Cost[N-1][1], Cost[N-1][2] ) + Cost[N][0]

    Green일 경우 : Cost[N][1] = min( Cost[N-1][0], Cost[N-1][2] ) + Cost[N][1]

    Blue일 경우 : Cost[N][2] = min( Cost[N-1][0], Cost[N-1][1] ) + Cost[N][2]
 */

// 점화식을 구하면 DP는 사실상 다 푼것이다