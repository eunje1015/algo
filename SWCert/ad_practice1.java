// Q1. 일련번호 (논리 구현 문제)
// 알파벳 개수 N
// 문자열 두 개
// 두 개 사이에 몇 개의 제품이 생산되었는 지 개수 출력
// ex) abcd, abdc, acbd, acdb, adbc, adcb ...

import java.util.Scanner;
import java.io.FileInputStream;

class ad_practice1 {
    public static void main(String arg[]) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        long result = 0;
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String firstStr = sc.next();
            String secondStr = sc.next();

            // adbc , bdca
            // a로 시작하는 일련번호는 a가 1번째 알파벳이므로 (1-1) * 3! + 1 에 생산된 제품임
            // ad로 시작하는 일련번호는 d가 4번째 알파벳이므로 (4-1) * 2! 인 줄 알앗는데, 앞에 a가 d보다 앞이므로 (4-1-1) * 2! 임 
            // adb로 시작하는 일련번호는 b가 2번째 알파벳이고 d보다 앞이고 a보다 뒤이므로  (2-1-1) * 1!
            // 따라서, 1 + 4 + 0 으로 5번째 숫자임

            // 첫번째 문자의 순서 구하기
            // 97부터 a
            long firstIdx = 1;

            for(int i = 0 ; i < N - 1; i++) {
                char ch = firstStr.charAt(i);

                int pos = (int)ch - 96; // 알파벳의 순서
                int num = N - i - 1; // 남은 알파벳 개수

                int base = (pos - 1) - getCount(firstStr, i);
                
                firstIdx += base * factorial(num);
            }

            // 두번째 문자의 순서 구하기
            long secondIdx = 1;

            for (int i = 0; i < N - 1; i++) {
                char ch = secondStr.charAt(i);

                int pos = (int) ch - 96; // 알파벳의 순서
                int num = N - i - 1; // 남은 알파벳 개수

                int base = (pos - 1) - getCount(secondStr, i);

                secondIdx += base * factorial(num);
            }

            // 두 문자의 차이값 구하기
            long diff = firstIdx > secondIdx ? firstIdx - secondIdx : secondIdx - firstIdx;
            result = diff - 1;

            System.out.println("#" + test_case + " " + result);
        }

    }

    public static int factorial(int num) {
        int fac = 1;
        for (int i = num; i > 0; i--) {
            fac *= i;
        }

        return fac;
    }

    public static int getCount(String str, int idx) {
        int result = 0;
        int nowIdx = (int)(str.charAt(idx)) - 96;
        for(int i = 0; i < idx; i++){
            char c = str.charAt(i);
            if(((int)c - 96) < nowIdx) result++;
        }
        return result;
    }

}