import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ad_practice9 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int K;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        bw.write(result + " ");

        br.close();
        bw.close();
    }

    static public void bfs(int s, int des) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        
        queue.add(new int[]{s, 0});
        visited[s] = true;

        while(true) {
            if(queue.isEmpty()) break;

            int[] tmp = queue.poll();
            int now = tmp[0];
            int cnt = tmp[1];

            for(int i=0; i<3; i++) {
                int next = 0;

                if(i == 0) {
                    next = now-1;
                }
                else if(i == 1) {
                    next = now+1;
                }
                else {
                    next = now*2;
                }

                if(next == des) {
                    cnt++;
                    result = cnt;
                    return;
                }

                if(next > 0 && next < visited.length && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cnt+1});
                }
            }
        }

    }
}
