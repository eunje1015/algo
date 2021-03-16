import java.io.*;
import java.util.StringTokenizer;

public class ad_practice7 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int time;
    static int[][] fish;
    static int shark_x;
    static int shark_y;
    static int shark_size = 2;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        fish = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 9) {
                    // 아기 상어
                    shark_x = i;
                    shark_y = j;
                    fish[i][j] = 0;
                }
                else {
                    fish[i][j] = t;
                }
            }
        }

        // 1. 먹을 수 있는 물고기 찾기
        // 2. 먹고 시간, 아기 상어의 위치, 물고기 상태 업데이트 하기
        // 3. 먹을 수 있는 게 없을 때까지 반복
    }

    static public void search() {
        // 거리 상 가장 가까운 물고기를 찾는다.

    }
}
