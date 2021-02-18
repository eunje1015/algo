import java.util.Scanner;
import java.io.FileInputStream;

class practice3 {
    static int N, Si, Sj, P, D;
    static int Ai, Aj;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            
            N = sc.nextInt();
            Si = sc.nextInt();
            Sj = sc.nextInt();
            P = sc.nextInt();

            int p_array[][] = new int[P][2];

            for(int k = 0; k < P; k++) {
                p_array[k][0] = sc.nextInt();
                p_array[k][1] = sc.nextInt();
            }

            D = sc.nextInt();
            
            int d_array[][] = new int[D][2];

            for(int k = 0; k < D; k++) {
                d_array[k][0] = sc.nextInt();
                d_array[k][1] = sc.nextInt();
            }

            for(int i = 0; i < d_array.length; i++) {
                int direction = d_array[i][0];
                int count = d_array[i][1];

                for(int j = 0; j < count; j++){
                    Pair p = getPosition(Si, Sj, direction);

                    Si = p.x;
                    Sj = p.y;
                }

                if (Si < 0 || Sj < 0 || Si >= N || Sj >= N || isTrap(p_array, Si, Sj)) {
                    Si = 0;
                    Sj = 0;
                    break;
                }
            }

            Ai = Si;
            Aj = Sj;

            System.out.println("#" + test_case + " " +Ai+" "+Aj);
        }
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Pair getPosition(int startX, int startY, int direction) {
        int x = startX;
        int y = startY;

        switch(direction){
            case 1:
                x -= 1;
                break;
            case 2:
                x -= 1;
                y += 1;
                break;
            case 3:
                y += 1;
                break;
            case 4:
                x += 1;
                y += 1;
                break;
            case 5:
                x += 1;
                break;
            case 6:
                x += 1;
                y -= 1;
                break;
            case 7:
                y -= 1;
                break;
            case 8:
                x -= 1;
                y -= 1;
                break;
            default:
                break;
        }

        Pair p = new Pair(x, y);

        return p;
    }

    public static boolean isTrap(int[][] trap, int i, int j){
        for(int k = 0; k < trap.length; k++){
            if(trap[k][0] == i && trap[k][1] == j)
                return true;
        }
        return false;
    }

}
