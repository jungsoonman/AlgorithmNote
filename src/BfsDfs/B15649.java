package BfsDfs;

import java.util.*;
import java.io.*;


public class B15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0);

        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == M) {                 // 길이 M 완성
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {    // 1~N 중 선택
            if (visited[i]) continue;

            visited[i] = true;
            arr[depth] = i;

            dfs(depth + 1);

            visited[i] = false;           // 백트래킹(상태 복구)
        }
    }
}
