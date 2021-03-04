import java.util.Scanner;
import java.io.FileInputStream;

public class im_practice8 {
    static long Answer;
    static int N;

// 문자열 관련 함수
// str1.equals(str2)
// str1.subString(0,3)
// str1.charAt(0)
// str1.length()
// Integer.toString(num)
// Integer.toString(num, 2) // 2진수
// Integer.parseInt(str1)
// 정렬
// Import.util.Arrays;
// Arrays.sort() // 오름차순

    public static void main(String args[]) throws Exception {
        int test_case, T;

        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            String answerString = "";
            for(int i=0; i<N; i++) {
                String str = Integer.toString(arr[i], 2); // 2진수로 변환

                int zero = 7 - str.length();
                for(int j=0; j<zero; j++) {
                    str = "0" + str;
                }

                answerString += str;
            }

            Answer = Long.parseLong(answerString, 2);

            System.out.println("#" + test_case + " " + Answer);
        }
    }
}
