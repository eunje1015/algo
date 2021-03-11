/**
 * 백준 14501 퇴사 https://www.acmicpc.net/problem/14501
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class ad_practice4 {
    static int[][] graph;
    static int result;
    static int N;

    public static void dfs(int cur_day, int sum) throws IOException {
        if(cur_day >= N) {
            //끝까지 확인
            result = sum > result ? sum : result;
            return;
        }

        int date = graph[cur_day][0];
        int cost = graph[cur_day][1];

        if(cur_day+1 <= N) {
            dfs(cur_day + 1, sum); // 현재 날짜에 상담하지 않음
        }

        if(cur_day+date <= N) {
            dfs(cur_day + date, sum + cost); // 현재 날짜에 상담 함
        }
    }    
    public static void main(String arg[]) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SCORE\\Documents\\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        graph = new int[N][2];

        for(int i=0; i<N; i++) {
            graph[i][0] = sc.nextInt(); 
            graph[i][1] = sc.nextInt(); 
        }

        dfs(0, 0);

        System.out.println(result);
    }
}