import java.io.*;
import java.util.*;

public class reverse {
    public static void main(String[] args) throws IOException {
        //버퍼리더 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        //답변은 StringBuilder
        StringBuilder answer = new StringBuilder(); 
        // 반복문으로 단어 하나씩 훑기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse() + " ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}