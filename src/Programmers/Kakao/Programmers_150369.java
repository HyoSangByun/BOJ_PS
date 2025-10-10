package Programmers.Kakao;

public class Programmers_150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0; // 현재 트럭의 배달 용량 상태
        int p = 0; // 현재 트럭의 수거 용량 상태

        for(int i = n - 1; i >= 0; i--) { //가장 먼 집부터
            d -= deliveries[i];
            p -= pickups[i];

            //i번째 집까지 아직 해결되지 않은 배달/수거가 얼마나 남았는가를 d,p에 누적

            while(d < 0 || p <0) {
                d += cap;
                p += cap;
                answer += (i+1)*2; //왕복
            }
        }

        return answer;
    }
}
