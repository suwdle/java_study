package java_study;
import java.io.*;
import java.util.*;
 
public class queue{
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	// 문자열 분리 
			
			switch(st.nextToken()) {	
			
				case "push":
					//push 케이스일 경우 입력받은 정수를 큐에 넣어준다
					q.offer(Integer.parseInt(st.nextToken()));	
					break;
				
				case "pop" :
					//pop 케이스일 경우 가장 앞에 있는 정수를 빼고, 그 수를 출력하지만, 없다면 -1을 출력한다
					Integer item = q.poll();	
					if(item == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(item).append('\n');
					}
					break;
					
				case "size":
					
					sb.append(q.size()).append('\n');
					break;
					
				case "empty":
					if(q.isEmpty()) {
						sb.append(1).append('\n');
					}
					else {
						sb.append(0).append('\n');
					}
					break;
					
				case "front":
					//가장 앞에 있는 정수를 출력한다. 없다면 -1 출력
					Integer ite = q.peek();
					if(ite == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(ite).append('\n');
					}
					break;
					
				case "back":
					//가장 뒤에 있는 정수를 출력한다. 없다면 -1 출력
					Integer it = q.peekLast();	 
					if(it == null) {
						sb.append(-1).append('\n');
					}
					else {
						sb.append(it).append('\n');
					}
					break;
			}
		}
		System.out.println(sb);
	}
}