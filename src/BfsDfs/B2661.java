package BfsDfs;
import java.util.*;
import java.io.*;

public class B2661 {
    static int N;
    static int[] arr;
    static boolean done = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dfs(0);
    }

    static void dfs(int depth) {
        if (done) return;

        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) sb.append(arr[i]);
            System.out.println(sb.toString());
            done = true;
            return;
        }

        for (int v = 1; v <= 3; v++) {
            arr[depth] = v;

            if (!isGood(depth + 1)) continue; // 나쁘면 다음 숫자 시도

            dfs(depth + 1);
        }
    }

    static boolean isGood(int len) { // len: 현재까지 만든 길이
        for (int k = 1; k <= len / 2; k++) {
            boolean same = true;
            for (int i = 0; i < k; i++) {
                if (arr[len - 1 - i] != arr[len - 1 - i - k]) {
                    same = false;
                    break;
                }
            }
            if (same) return false; // 반복 패턴 발견 -> 나쁜 수열
        }
        return true;
    }
}
