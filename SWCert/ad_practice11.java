import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ad_practice11 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R;
    static int C;
    static String[][] map;
    static int result = 0;
    static ArrayList<String> str_arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++){
                st = new StringTokenizer(br.readLine(), " ");
                map[i][j] = st.nextToken();
            }
        }


        br.close();
        bw.close();
    }
    public static void dfs(int hr, int hc, int cnt, ArrayList<String> arr) {
        int[] rMove = new int[]{-1, 1, 0, 0};
        int[] cMove = new int[]{0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int next_r = hr+rMove[i];
            int next_c = hc+cMove[i];

            if(next_r < 0 || next_c < 0 || next_r >= R || next_c >= C) {
                // 가지 못함
                continue;
            }

            String s = map[next_r][next_c];
            if(alpa(s, arr)) { // s가 처음 나오는 알파벳이면
                result = cnt+1 > result ? cnt+1 : result;
                dfs(next_r, next_c, cnt+1, arr);
            }
        }
    }

    public static boolean alpa(String s, ArrayList<String> arr) {
        str_arr = new ArrayList<>();

        for()
    }
}
