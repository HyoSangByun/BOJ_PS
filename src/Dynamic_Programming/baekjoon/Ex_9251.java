package Dynamic_Programming.baekjoon;

import java.util.Scanner;

public class Ex_9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArray1 = sc.nextLine().toCharArray();
        char[] charArray2 = sc.nextLine().toCharArray();

        int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];

        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[charArray1.length][charArray2.length]);

        /*
            LCS(Xi, Yj) : LCS(Xi-1, Yj-1) + 1                                  if (Xi == Yj)
            LCS(Xi, Yj) : max( LCS(Xi-1, Yj), LCS(Xi, Yj-1) )         if (Xi != Yj)
         */

    }
}

/*
    char[] str1 = in.nextLine().toCharArray();
        char[] str2 = in.nextLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;

        // 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
        int[][] dp = new int[length_1 + 1][length_2 + 1];

        // 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
        for(int i = 1; i <= length_1; i++) {
            for(int j = 1; j <= length_2; j++) {

                // (i-1)과 (j-1) 번째 문자가 서로 같다면
                if(str1[i - 1] == str2[j - 1]) {
                    // 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Top-Down 때와는 다르게 dp 인덱스가 한 줄씩 추가되었으므로 -1을 하지 않음
        System.out.println(dp[length_1][length_2]);
 */