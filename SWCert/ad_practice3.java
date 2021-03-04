import java.util.Scanner;
import java.util.StringTokenizer;
// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Map;
import java.io.*;

public class ad_practice3 {
    static int[] card;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Scanner sc = new Scanner(System.in);

        // 1번 방법 - 시간 초과
        // int N = sc.nextInt();

        // int[] card = new int[N];
        // for(int i = 0; i < N; i++){
        //     card[i] = sc.nextInt();
        // }
        // Arrays.sort(card);
        // int begin_idx = 0; // 가지고 있는 카드 탐색 시작 점

        // int M = sc.nextInt();
        
        // HashMap<Integer, Integer> target = new HashMap<>();

        // for (int i = 0; i < M; i++) {
        //     target.put(i, sc.nextInt());
        // }

        // //ArrayList<Integer> valueList = new ArrayList<>(target.values());
        // List<Map.Entry<Integer, Integer>> target_ent = new ArrayList<Map.Entry<Integer, Integer>>(target.entrySet());
        // Collections.sort(target_ent, new Comparator<Map.Entry<Integer, Integer>>() {
        //     @Override
        //     public int compare(Map.Entry<Integer, Integer> i1, Map.Entry<Integer, Integer> i2) { 
        //         return i1.getValue().compareTo(i2.getValue());
        //     }
        // });

        // int[] answers = new int[M];
        // for(Map.Entry<Integer, Integer> en : target_ent) {
        //     int targetNumber = en.getValue();
        //     int targetIndex = en.getKey();

        //     int answer = 0;
        //     for(int i = begin_idx; i < card.length; i++) {
        //         if( targetNumber < card[i] ) {
        //             begin_idx = i;
        //             break;
        //         }

        //         if( targetNumber == card[i] ) answer++;
        //     }

        //     answers[targetIndex] = answer;
        // }

        // for(int i = 0; i < answers.length; i++) {
        //     System.out.println(answers[i] + " ");
        // }

        // 2번 방법 - 시간 초과
        // int[] num = new int[20000001]; // -10000000 ~ 10000000 사이
        // int N = sc.nextInt();

        // for(int i = 0; i < N; i++) {
        //     int card_idx = sc.nextInt();
        //     num[card_idx+10000000]++;
        // }
        
        // int M = sc.nextInt();
        // for(int i = 0; i < M; i++) {
        //     int m_idx = sc.nextInt();
        //     System.out.println(num[m_idx+10000000]+" ");
        // }

        // 3번 방법 - 이분 탐색
        int N = Integer.parseInt(br.readLine());
        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int upper = findUpper(target, 0, N-1);
            int lower = findLower(target, 0, N-1);

            int answer = upper - lower;

            bw.write(answer + " ");
            //System.out.println(answer + " ");
        }

        bw.flush();
    }

    static int findLower(int target, int start, int end) 
    {
        while(true)
        {
            if(start >= end) break;

            int center = (start + end) / 2;

            if(card[center] >= target)
                end = center;
            else
                start = center + 1;
        }

        return end;
    }
    static int findUpper(int target, int start, int end)
    {
        while(true)
        {
            if(start >= end) break;

            int center = (start + end) / 2;

            if(card[center] > target)
                end = center;
            else
                start = center + 1;
        }

        if(card[end] == target) end++;
        return end;
    }
}
