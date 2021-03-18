import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ad_practice8 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Iland> iland_list = new ArrayList<>();
    static int[][] bridge;
    static int result;

    static class Iland {
        Integer[] r;
        Integer[] c;

        Iland(Integer r[], Integer c[]) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //0. 섬을 만들자
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        int[][] clone_map = cloneMap(map);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (clone_map[i][j] == 1) {
                    col.clear();
                    row.clear();

                    searchIland(i, j, col, row, clone_map);
                    Integer[] c = col.toArray(new Integer[col.size()]);
                    Integer[] r = row.toArray(new Integer[row.size()]);
                    Iland il = new Iland(r, c);
                    iland_list.add(il);
                }
            }
        }
        
        //1. 섬들 사이에 연결할 수 있는 모든 다리를 구한다. 가 아니라 각 섬을 연결하는 최소 다리만 구하면 됨..
        makeBridge();

        //2. 연결 후 최소값 구하기
        calcMin();

        bw.write(result+" ");
        
        br.close();
        bw.close();
    }
    static public void calcMin() {
        // 연결해보기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);


        
        for(int i = 0; i < iland_list.size(); i++) {
            queue.add(i);


        }
        //queue.add(e)

        // 연결이 되면, 최소값과 비교
    }

    static public void makeBridge() {
        int size = iland_list.size();
        bridge = new int[size][size];

        for(int i = 0; i < iland_list.size(); i++) {
            Iland il1 = iland_list.get(i);
            for(int j = i+1; j < iland_list.size(); j++) {
                Iland il2 = iland_list.get(j);

                if(bridge[j][i] > 0) continue;

                // column 비교
                for(Integer column_il1 : il1.c) {
                    for(Integer column_il2 : il2.c) {
                        if(column_il1 == column_il2) {
                            // 다리 있음
                            int len = 0;
                            if(il1.c[0] > il2.c[0])
                                len = il2.c[0] - il1.c[il1.c.length-1];
                            else
                                len = il1.c[0] - il2.c[il2.c.length-1];

                            if(len > 1) {
                                bridge[i][j] = bridge[i][j] < len ? len : bridge[i][j];
                            }
                        }
                    }
                }

                //row 비교
                for (Integer row_il1 : il1.r) {
                    for (Integer row_il2 : il2.r) {
                        if (row_il1 == row_il2) {
                            // 다리 있음
                            int len = 0;
                            if (il1.r[0] > il2.r[0])
                                len = il2.r[0] - il1.r[il1.r.length-1];
                            else
                                len = il1.r[0] - il2.r[il2.r.length-1];

                            if (len > 1) {
                                bridge[i][j] = bridge[i][j] < len ? len : bridge[i][j];
                            }
                        }
                    }
                }
            }
        }
    }

    static public int[][] cloneMap(int[][] map) {
        int[][] clone = new int[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                clone[i][j] = map[i][j];
            }
        }
        return clone;
    }

    static public void searchIland(int x, int y, ArrayList<Integer> col, ArrayList<Integer> row, int[][] clonemap) {
        col.add(x);
        row.add(y);
        clonemap[x][y] = 0;

        int[] rMove = new int[]{1, 0};
        int[] cMove = new int[]{0, 1};

        for(int i = 0; i < 2; i++) {
            // 하/좌 확인
            int ro = x + rMove[i];
            int co = y + cMove[i];

            if(ro < 0 || co < 0 || ro >= M || co >= N)
                continue;

            if(clonemap[co][ro] == 1) {
                searchIland(co, ro, col, row, clonemap);
            }
        }
    }
}
