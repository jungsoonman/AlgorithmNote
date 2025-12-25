package Implementation;
import java.util.*;
import java.io.*;

public class B14719 {



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 사용 안 해도 됨
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1; i < W - 1; i++) { // 양 끝은 물이 고일 수 없음
            int leftMax = 0;
            for (int l = 0; l <= i; l++) {
                leftMax = Math.max(leftMax, height[l]);
            }

            int rightMax = 0;
            for (int r = i; r < W; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }

            int water = Math.min(leftMax, rightMax) - height[i];
            if (water > 0) ans += water;
        }

        System.out.println(ans);
    }


}
