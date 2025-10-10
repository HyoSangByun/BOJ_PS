package Programmers.Kakao;

public class Programmers_150368 {
    int sign = 0;
    int earn = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] arr = new int[emoticons.length];
        comb(arr, 0, users, emoticons);

        answer[0] = sign;
        answer[1] = earn;

        return answer;
    }

    public void comb(int[] arr, int start, int[][] users, int[] emoticons) {
        if(start == arr.length) {
            calculate(arr, users, emoticons);
            return;
        }

        for(int discount = 10; discount <= 40; discount += 10) {
            arr[start] = discount;
            comb(arr, start+1, users, emoticons);
        }
    }

    public void calculate(int[] arr, int[][] users, int[] emoticons) {
        int count = 0;
        int earn_t = 0;

        for(int[] user : users) {
            int a = user[0]; //이모티콘 사는 기준
            int b = user[1]; //구독 사는 기준
            int sum = 0;

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= a) {
                    sum += (emoticons[i]/100) * (100 - arr[i]);
                }
            }

            if(sum >= b) count++;
            else earn_t += sum;
        }

        if(count > sign) {
            sign = count;
            earn = earn_t;
        } else if (count == sign) {
            if( earn_t > earn) {
                earn = earn_t;
            }
        }
    }
}
