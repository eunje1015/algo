import java.util.Scanner;
import java.io.FileInputStream;

public class im_practice5 {
    static int L, Answer;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        String S;

        for (int test_case = 1; test_case <= T; test_case++) {

            L = sc.nextInt();
            S = sc.next();

            Answer = 0;

            for(int i = 0; i < L-2; i++) {
                int count = 0;
                int pos = 1;
                char curChar = S.charAt(i);
                char startC = curChar;
                char endC = S.charAt(i+2);
                char nextC = S.charAt(i+1);

                if(curChar == endC) {
                    // 회문임
                    count = 3;
                    while(true) {
                        if(i == 0) break;
                        if(i+2 == L-1) break;
                        
                        startC = S.charAt(i-pos);
                        endC = S.charAt(i+2+pos);

                        if(startC == endC) {
                            //회문임
                            count += 2;
                            pos++;
                        }
                        else
                            break;
                    }

                    if(count > Answer) Answer = count;
                }
                else if(curChar == nextC) {
                    while (true) {
                        if (i == 0)
                            break;
                        if (i + pos == L - 1)
                            break;

                        startC = S.charAt(i - pos);
                        nextC = S.charAt(i + 1 + pos);

                        if (startC == nextC) {
                            // 회문임
                            count += 2;
                            pos++;
                        } else
                            break;
                    }
                    if(count >= 2) count += 2;
                    if (count > Answer) Answer = count;
                }
            }

            System.out.println("#" + test_case + " " + Answer);
        }
    }
}
