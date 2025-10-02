package Programmers.Kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_258712 {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;

        Map<String, Integer> indexMap = new HashMap<>();
        for(int i =0; i < N; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] map = new int[N][N];
        int[][] degree = new int[N][3];

        for(String s : gifts) {
            String[] temp = s.split(" ");
            int sender = indexMap.get(temp[0]);
            int catcher = indexMap.get(temp[1]);
            map[sender][catcher]++;
            degree[sender][0]++;
            degree[catcher][1]++;
        }

        for(int i =0; i < N; i++) {
            degree[i][2] = degree[i][0] - degree[i][1];
        }

        int[] answer = new int[N];


        /*
         * boolean[][] ch = new boolean[N][N];
         * 기존 풀이인데 밑의 방식으로 최적화 가능
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( i == j) continue;
                if ( map[i][j] > map[j][i]) answer[i]++;
                if ( map[i][j] == map[j][i] && !ch[j][i] && !ch[i][j]) {
                    if(degree[i][2] < degree[j][2]) {
                        ch[j][i] = true;
                        ch[i][j] = true;
                        answer[j]++;
                    } else if (degree[j][2] < degree[i][2]) {
                        ch[j][i] = true;
                        ch[i][j] = true;
                        answer[i]++;
                    }
                }
            }
        }
        */
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (map[i][j] > map[j][i]) {
                    answer[i]++;
                } else if (map[j][i] > map[i][j]) {
                    answer[j]++;
                } else {
                    if (degree[i][2] > degree[j][2]) {
                        answer[i]++;
                    } else if (degree[j][2] > degree[i][2]) {
                        answer[j]++;
                    }
                }
            }
        }
        return Arrays.stream(answer).max().getAsInt();
    }
}
