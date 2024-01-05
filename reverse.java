import java.io.*;
import java.util.*;

public class reverse {
    public static void main(String[] args) throws IOException {
        //버퍼리더 만들기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문장 개수 입력
        int n = Integer.parseInt(br.readLine()); 
        //답변은 StringBuilder
        StringBuilder output = new StringBuilder(); 
        // 반복문으로 단어 하나씩 훑기
        for (int i = 0; i < n; i++) {
            //for 문이 한번 돌 때 문장 하나씩 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            //문장의 단어 개수만큼
            while (st.hasMoreTokens()) {
                // 새로운 StringBuilder에 단어 하나 저장 후 output에 reverse해서 저장
                StringBuilder sb = new StringBuilder(st.nextToken());
                output.append(sb.reverse() + " ");
            }
            output.append("\n");
        }
        System.out.print(output);
    }
}