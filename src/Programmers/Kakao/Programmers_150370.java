package Programmers.Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answers = new ArrayList<>();

        // 약관 종류와 유효기간(개월) 저장
        for (String s : terms) {
            String[] arr = s.split(" ");
            map.put(arr[0], Integer.valueOf(arr[1]));
        }

        // 오늘 날짜 숫자화
        String[] todayArr = today.split("\\.");
        int todayNum = Integer.parseInt(todayArr[0] + todayArr[1] + todayArr[2]);

        int index = 1;
        for (String s : privacies) {
            String[] arr = s.split(" ");
            String startDay = arr[0];
            String type = arr[1];

            String[] dayArr = startDay.split("\\.");
            int year = Integer.parseInt(dayArr[0]);
            int month = Integer.parseInt(dayArr[1]);
            int day = Integer.parseInt(dayArr[2]);

            // 유효기간 추가 (개월)
            int addMonths = map.get(type);
            int totalMonths = year * 12 + month + addMonths;
            year = (totalMonths - 1) / 12;
            month = (totalMonths - 1) % 12 + 1;

            // 하루 빼기
            day--;
            if (day == 0) {
                month--;
                if (month == 0) {
                    month = 12;
                    year--;
                }
                day = 28; // 문제 조건상 모든 달은 28일까지 존재
            }

            // 만료일 숫자화
            String y = String.format("%04d", year);
            String m = String.format("%02d", month);
            String d = String.format("%02d", day);
            int expireNum = Integer.parseInt(y + m + d);

            // 오늘 날짜와 비교
            if (todayNum > expireNum) answers.add(index);
            index++;
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
