package Programmers.Kakao;

public class Programmers_150365 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] dir = {"d", "l", "r", "u"};
    String answer = "impossible";
    boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x, y, r, c, k, 0, "");
        return answer;
    }

    void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, String path) {
        if (found) return; // 이미 정답 찾았으면 중단

        int dist = Math.abs(x - r) + Math.abs(y - c); // 현재 위치 → 목적지까지의 최소 이동거리
        int remain = k - depth; // 앞으로 남은 이동횟수

        // 가지치기
        if (dist > remain || (remain - dist) % 2 != 0) return;

        if (depth == k) {
            if (x == r && y == c) {
                answer = path;
                found = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

            dfs(n, m, nx, ny, r, c, k, depth + 1, path + dir[i]);
            if (found) return; // 첫 번째 사전순 경로면 바로 종료
        }
    }
}
