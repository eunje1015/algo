import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ad_practice10 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bfs(S, G);

        if(result == 0)
            bw.write("use the stairs");
        else
            bw.write(result+" ");

        br.close();
        bw.close();
    }

    public static void bfs(int S, int G) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];

        queue.add(new int[]{S, 0});
        visited[S] = true;

        while(true) {
            if(queue.isEmpty()) break;

            int[] q = queue.poll();
            int floor = q[0];
            int cnt = q[1];

            for(int i=0; i<2; i++) {
                int next_floor = 0;
                if(i == 0) {
                    //위로
                    next_floor = floor + U;
                }
                else if(i == 1) {
                    //아래로
                    next_floor = floor - D;
                }

                if(next_floor == G) {
                    //목적지 도착
                    result = cnt+1;
                    return;
                }

                if(next_floor > 0 && next_floor < visited.length && !visited[next_floor]) {
                    visited[next_floor] = true;
                    queue.add(new int[]{next_floor, cnt+1});
                }
            }
        }
    }
}
