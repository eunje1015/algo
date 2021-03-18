import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ad_practice7 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int time = 0;
    static int[][] fish;
    static Shark shark;
    static ArrayList<Fish> edible;
    static class Shark {
        int x;
        int y;
        int size;
        int eat_fish;

        Shark(int x, int y, int size, int eat_fish) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat_fish = eat_fish;
        }
    }

    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int size;
        int distance;

        Fish(int x, int y, int size, int distance) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish fish) {
            if(this.distance == fish.distance) {
                if(this.x == fish.x) {
                    return this.y - fish.y;
                }
                return this.x - fish.x;
            }

            return this.distance - fish.distance;
        }
    }
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
                    shark = new Shark(i, j, 2, 0);
                    fish[i][j] = 0;
                }
                else {
                    fish[i][j] = t;
                }
            }
        }

        // 1. 모든 물고기들의 상어와의 거리를 구한다. (bfs로)
        // 2. 상어가 먹을 수 있는 물고기들은 list에 담는다.
        // 3. list를 정렬하여 거리가 가장 짧고, y가 작고, x가 작은 우선순위대로 먹을 물고기를 정한다
        // 4. 물고기를 먹는다. - 몸집 키우기, 시간 더하기, 상어 좌표 옮기기
        // 5. 반복하여 먹을 수 있는 물고기가 없을 때까지 계산한다.

        while(moveShark()) {

        }

        bw.write(time + " ");

        br.close();
        bw.close();
    }

    public static boolean moveShark() {

        if(!clac()) return false; // 먹을 수 있는 물고기가 없음

        Fish eat = edible.get(0);
        shark.eat_fish++;
        if(shark.size == shark.eat_fish) {
            shark.size++;
            shark.eat_fish = 0;
        }
        shark.x = eat.x;
        shark.y = eat.y;
        
        time += eat.distance;

        fish[eat.x][eat.y] = 0;

        return true;
    }

    public static boolean clac() {
        edible = new ArrayList<>();
        // 먹을 가능성이 있는 물고기들에 대해서 상어와의 거리를 구한다..

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(fish[i][j] > 0 && fish[i][j] < shark.size) {
                    // 먹을 수 있으므로 거리 계산 -> 도달할 수 있는지 체크
                    int dis = distance(i, j);
                    if(dis > 0)
                        edible.add(new Fish(i, j, fish[i][j], dis));
                }
            }
        }

        if(edible.isEmpty())
            return false;
        
        Collections.sort(edible);
        return true;
    }

    public static int distance(int fish_x, int fish_y) {
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[N][N];
        int[] xMove = new int[]{-1,1,0,0};
        int[] yMove = new int[]{0,0,-1,1};

        queue.add(new int[]{shark.x, shark.y});
        visited[shark.x][shark.y] = 1;

        while(true) {
            if(queue.isEmpty()) break;

            int[] tmp = queue.poll();
            
            for(int i=0; i<4; i++) { // 상하좌우 체크
                int x = tmp[0] + xMove[i];
                int y = tmp[1] + yMove[i];

                if(x < 0 || y < 0 || x >= N || y >= N)
                    continue; // 이쪽 방향으론 못감
                
                if(visited[x][y] == 0 && fish[x][y] <= shark.size) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = visited[tmp[0]][tmp[1]] + 1;
                }
            }
        }

        return visited[fish_x][fish_y] - 1;
    }
}
