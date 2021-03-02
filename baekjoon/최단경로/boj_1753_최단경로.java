import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int end, weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight= weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight; //weight 오름차순 기준
    }
}

public class Main{
    private static final int INF = 100_000_000;
    private static int v, e, k;
    static List<Node>[] list;
    static int[] dist;


    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            // 리스트에 그래프 정보를 초기화
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[start].add(new Node(end, weight));
        }
        // 다익스트라 알고리즘
        dijkstra(k);


        StringBuilder sb = new StringBuilder();
        //출력 부분
        for(int i = 1; i <= v; i++) {
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> prq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];

        prq.add(new Node(start, 0));
        dist[start] = 0;

        while(!prq.isEmpty()){

            Node curNode = prq.poll();

            int cur = curNode.end;
            if(visited[cur] == true) continue;
            visited[cur] = true;

            for(Node node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    prq.add(new Node(node.end, dist[node.end]));

                }

            }

        }

    }
}