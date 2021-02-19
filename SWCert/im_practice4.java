import java.util.Scanner;
import java.io.FileInputStream;

public class im_practice4 {
    static int N, Answer1, Answer2;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();

            int matrix[][] = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            Answer1 = 0;
            Answer2 = 0;

            for(int i = 1; i < N-1; i++) {
                for(int j = 1; j < N-1; j++) {
                    int num = matrix[i][j];

                    //난수 확인                    
                    if(matrix[i-1][j-1] > num && matrix[i-1][j] > num && matrix[i-1][j+1] > num && matrix[i][j+1] > num
                        && matrix[i+1][j-1] > num && matrix[i+1][j] > num && matrix[i][j-1] > num && matrix[i+1][j+1] > num) {
                            Answer2++;
                    }
                    if(matrix[i-1][j-1] < num && matrix[i-1][j] < num && matrix[i-1][j+1] < num && matrix[i][j+1] < num
                        && matrix[i+1][j-1] < num && matrix[i+1][j] < num && matrix[i][j-1] < num && matrix[i+1][j+1] < num) {
                            Answer1++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + Answer1 + " " + Answer2);
        }
    }
}
