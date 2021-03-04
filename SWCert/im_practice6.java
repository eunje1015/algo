import java.util.Scanner;
import java.io.FileInputStream;

public class im_practice6 {
    static double N;
    static double M;
    static double Answer;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextDouble(); // 회전 바퀴 수
            M = sc.nextDouble(); // 현재 가리키고 있는 징의 일련번호

            Answer = 45.0 * N + ((9.0 * M) / 8);
            Answer -= (9.0 * M);

            if(Answer < 0)
                Answer *= -1;

            if(Answer > 180)
                Answer = 360.0 - Answer;

            System.out.printf("#%d %.1f\n", test_case, Answer);
        }
    }
}
