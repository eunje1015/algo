import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int N;
    static int AnswerN;
    public static void main(String args[]) throws Exception {
        //int T;
        //int pos;

        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        //T = sc.nextInt();
        for(int test_case = 1; test_case <= 3; test_case++) {
            AnswerN = 0;

            N = sc.nextInt();

            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    String tmp = sc.next();
                    int num = 0;
                    if(tmp.charAt(0) == 'B')
                        num = 1;
                    map[i][j] = num;
                }
            }

            //구현
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 0){
                        continue;
                    }
                    else{
                        AnswerN++;
                    }

                    if(map[i-1][j] == 0 || map[i][j-1] == 0 || 
                        map[i][j+1] == 0 || map[i+1][j] == 0) continue;
                    
                    int building = 0;
                    for(int k = 0; k < N; k++){ 
                        if(map[i][k] == 1 && k != j){
                            building++;
                        }
                        if(map[k][j] == 1 && k != i){
                            building++;
                        }
                    }
                    AnswerN += building;
                }
            }

            System.out.println("#"+test_case+" "+ AnswerN);
        }
    }
}

