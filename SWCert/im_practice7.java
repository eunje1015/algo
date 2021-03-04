import java.util.Scanner;
import java.io.FileInputStream;

public class im_practice7 {
    static int Answer;
    static int N;
    public static void main(String args[]) throws Exception {
        int test_case, T;

        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(test_case = 1; test_case <= T; test_case++) {
            Answer = 0;

            N = sc.nextInt();
            char map[][] = new char[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 현재 장소가 기지국
                    if(map[i][j] == 'B')
                        continue;

                    // 상하좌우 기지국 체크
                    if(i-1 >= 0 && map[i-1][j] == 'B')
                        continue;
                    if(j-1 >= 0 && map[i][j-1] == 'B')
                        continue;
                    if(i+1 < N && map[i+1][j] == 'B')
                        continue;
                    if(j+1 < N && map[i][j+1] == 'B')
                        continue;

                    Answer++;
                }
            }
            System.out.println("#" + test_case+" "+Answer);
        }
    }
}
