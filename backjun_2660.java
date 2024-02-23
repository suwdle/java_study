import java.io.*;
import java.util.*;

public class Main {
    // 정적 변수 선언 (처음에 없이 했다가 컴파일 오류 생겨서 추가)
    static int N;
    static List<List<Integer>> l = new ArrayList<>();
    static int[] point;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회원의 수 입력
        N = Integer.parseInt(br.readLine());
        // 포인트 배열 만들기
        point = new int[N+1];
        
        for(int i = 0; i<=N; i++)
            l.add(new ArrayList<>());
        
        // 줄마다 두개의 회원번호를 받아서 리스트에 저장한다
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A == -1 && B == -1)
                break;

            l.get(A).add(B);
            l.get(B).add(A);
        }
        // bfs 수행
        bfs_cal();

        // 누가 최저점을 가지고 있는지 검사
        int c = 0;
        for(int i = 1; i<=N; i++){
            if(point[i] == min)
                c++;
        }
        
        System.out.println(min + " "+ c);
        for(int i = 1; i<=N; i++)
            if(point[i] == min)
                System.out.print(i+" ");
        System.out.println();
    }
    // bfs 가져와서 점수 비교통해 최저점 찾기
    static void bfs_cal(){
        // 정점 (회원) 수만큼 bfs 수행
        for(int i = 1; i<=N; i++){
            int val = bfs(i);

            point[i] = val;
            min = Math.min(min, val);
        }
    }
    // 너비우선 탐색하며 
    static int bfs(int v){
        boolean[] visited = new boolean[N+1];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, 0));
        visited[v] = true;
        int c = 0;
        
        // 큐에 남은 회원이 없을 때까지 반복
        while(!q.isEmpty()){
            // 큐의 최상위 노드
            Node vertex = q.poll();
            // 웹에서 서치로 찾아본 부분
            // 탐색 중인 정점의 점수를 계산해준다
            for(int i = 0; i<l.get(vertex.v).size(); i++){
                int nextV = l.get(vertex.v).get(i);

                if(visited[nextV])
                    continue;
                // 이전에 방문하지 않은 정점일 경우, visited를 true로 바꾼 후 점수를 1점 올린다
                visited[nextV] = true;
                q.offer(new Node(nextV, vertex.c+1));
            }

            c = vertex.c;
        }

        return c;
    }
}
// 노드에는 정점 번호와 점수를 저장해준다
class Node{
    int v, c;

    Node(int v, int c){
        this.v = v;
        this.c = c;
    }
}