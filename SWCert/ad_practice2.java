// deque 문제
// 백준 알고리즘 1021 회전하는 큐

// 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

// 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

// 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
// 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
// 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
// 큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. 
// (이 위치는 가장 처음 큐에서의 위치이다.) 
// 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

// 큐의 원소 개수 N / 뽑아내려는 원소 개수 M
// 뽑아내려는 위치 순서대로 

/**
 * Deque 사용법 확인
 * @offer, offerFirst, pollLast, poll, peek, isEmpty
 * 
 * Queue 사용법 확인
 * @add, poll, peek, isEmpty
 * 
 * Math 사용법 확인
 * @abs - 절대값
 * @round - 소수값을 반올림
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Deque;
import java.util.ArrayDeque;
import java.math.*;

class ad_practice2 {
    public static void main(String arg[]) throws Exception {
        System.setIn(new FileInputStream("C:\\sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        //Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int count = 0; // 2, 3 연산 총합

        while(true) {
            if(M == 0) break;

            int m_num = sc.nextInt();
            int tmp = 0;

            while(true) {
                //1번 연산
                int cur_num = deque.poll(); // 큐에서 뽑아냄
    
                if(m_num != cur_num) {
                    //2, 3번 연산
                    //큐에서 나올 때까지 뽑음
                    deque.offer(cur_num); // 뒤에 넣어줌
                    tmp++;
                }
                else if(m_num == cur_num) {
                    //연산 끝
                    count += (tmp > N - tmp) ? (N - tmp) : tmp;
                    N--;
                    break;
                }
            }
            M--;
        }

        System.out.println(count);
    }
}