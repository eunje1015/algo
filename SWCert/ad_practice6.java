import java.io.*;
import java.util.StringTokenizer;

public class ad_practice6 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int D;
    static int[][] enemy;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        enemy = new int[N][M];
        visited = new boolean[M];
        result = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                enemy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        br.close();
        bw.close();
    }

    public static void dfs(int start, int count) throws IOException {
        // 조합 가능한 모든 경우의 수 구하기
        if(count == 3) {
            calc();
        }
        for(int i=start; i<M; i++) {
            if(visited[i] == true) continue;
            visited[i] = true;
            dfs(i, count+1);
            visited[i] = false; // 여기가 약간 이해가 안가..
        }
    }

    public static void calc() throws IOException {
        // 최대 잡을 수 있는 적의 수를 계산한 다음, 현재 최대 값과 비교
        for(int i=0; i<M; i++) {
            if(visited[i]) {
                int archerX = M; // 궁수의 위치
                int archerY = i; 

                // 공격 가능한 적 리스트를 돌면서 공격한 경우 배열에 담아 놓음(중복 체크)
                for(int j=0; j<D; j++) {

                    
                    enemy[archerX-j][archerY]
                    enemy[archerX-(j+1)][archerY]
                }
            }
        }
    }
    
}
