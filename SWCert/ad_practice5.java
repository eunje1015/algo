import java.util.StringTokenizer;
import java.util.Vector;
import java.io.*;

public class ad_practice5 {
    static int N;
    static Vector<Integer>[] vec;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        vec = new Vector[N];
        for(int i=0; i<N; i++) { 
        	vec[i]=new Vector<Integer>();
        }

        visited = new boolean[N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            vec[s-1].add(e-1);
            vec[e-1].add(s-1); // 이걸 해줘야 되네...........
        }

        dfs(0);

        int result = 0;

        for(int i=1; i<N; i++) {
            if(visited[i] == true) {
                result++;   
            }
        }

        bw.write("" + result); // 꼭 이렇게 해야 출력됨

        br.close();
        bw.close();
    }

    public static void dfs(int start) throws IOException{
        visited[start] = true;
        
        for(int i=0; i<vec[start].size(); i++) {
            int node = vec[start].get(i);
            if(!visited[node]) {
                dfs(node);
            }
        }
    }
    
}
