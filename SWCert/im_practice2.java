import java.util.Scanner;
import java.io.FileInputStream;
import java.math.*;

class practice2 {
    static int Cx, Cy, R, Sx, Sy;
    static int AnswerN;

    public static void main(String args[]) throws Exception {
        // int T;
        // int pos;

        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        // T = sc.nextInt();
        for (int test_case = 1; test_case <= 3; test_case++) {
            
            Cx = sc.nextInt();
            Cy = sc.nextInt();
            R = sc.nextInt();
            Sx = sc.nextInt();
            Sy = sc.nextInt();

            double width = Math.abs(Sx - Cx);
            double height = Math.abs(Sy - Cy);
            double hypotenuse = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

            if(R >= hypotenuse)
                AnswerN = 1;
            else    
                AnswerN = 0;

            System.out.println("#" + test_case + " " + AnswerN);
        }
    }
}