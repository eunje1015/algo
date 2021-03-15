import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ad_practice6 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int D;
    static int[][] enemy;
    static boolean[] visited;
    static int result;
    static ArrayList<Position> arr_result = new ArrayList<Position>();
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

        bw.write(result+ " ");

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
        int tmp = 0; // 최대 잡을 수 있는 적의 수
        int x_position = N;
        int[][] enemy_tmp = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                enemy_tmp[i][j] = enemy[i][j];
            }
        }

        while(true) {
            if(x_position == 0) break;

            for(int i = 0; i < M; i++) {
                if (visited[i]) { // 아군 한명씩 공격하는 적 체크
                    outer:
                    for(int j=1; j<=D; j++) {
                        // 공격 가능한 적 range
                        int rn1_start = i - (j - 1) > 0 ? i - (j - 1) : 0;
                        int rn1_end = i + (j - 1) > M - 1 ? M - 1 : i + (j - 1);
                        int rn2_start = x_position - 1;
                        int rn2_end = x_position - j > 0 ? x_position - j : 0;

                        for (int n = rn2_start; n >= rn2_end; n--) {
                            for(int k = rn1_start; k <= rn1_end; k++) {
                                // 유효 적인지 체크
                                int x = Math.abs(n - x_position);
                                int y = Math.abs(k - i);
                                if(x+y <= D) {
                                    if(enemy_tmp[n][k] == 1) {
                                        Position enemyPos = new Position(n, k);
                                        if(arr_result.size() == 0) {
                                            // 중복 공격이 될 수 없음
                                            tmp++;
                                            arr_result.add(enemyPos);
                                            if(x_position-1 > n) {
                                                enemy_tmp[n][k] = 0;
                                            }
                                            break outer;
                                        }
                                        if (arr_result.size() > 0) {
                                            Position pos = arr_result.get(0);
                                            if (pos.x == n && pos.y == k) {
                                                break outer;
                                            }
                                        }
                                        if (arr_result.size() > 1) {
                                            Position pos = arr_result.get(1);
                                            if (pos.x == n && pos.y == k) {
                                                break outer;
                                            }
                                        }
                                        // 중복 공격이 없음
                                        tmp++;
                                        arr_result.add(enemyPos);
                                        if (x_position - 1 > n) {
                                            enemy_tmp[n][k] = 0;
                                        }
                                        break outer;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            arr_result.clear();
            x_position--;
        }
        result = tmp > result ? tmp : result;
    }
}
