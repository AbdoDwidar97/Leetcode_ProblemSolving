package Graphs;
import java.util.*;

public class NetworkDelayTime
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }

    private static class Solution
    {
        class Node
        {
            int node;
            int distance;

            public Node(){}
            public Node(int node, int distance)
            {
                this.node = node;
                this.distance = distance;
            }

            public int getNode() {
                return node;
            }

            public void setNode(int node) {
                this.node = node;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }
        }

        public int networkDelayTime(int[][] times, int n, int k)
        {
            int[][] graph = createGraph(times, n);
            PriorityQueue<Node> dist = new PriorityQueue<>(new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)
                {
                    if (o1.distance > o2.distance) return 1;
                    else if (o1.distance < o2.distance) return -1;
                    return 0;
                }
            });

            for (int i = 0; i < n; i++)
            {
                if (i == k - 1) dist.add(new Node(i, 0));
                else dist.add(new Node(i, Integer.MAX_VALUE));
            }

            Node currentNode = dist.poll();

            while (!dist.isEmpty())
            {
                Node[] distances = dist.toArray(new Node[dist.size()]);

                for (Node next : distances)
                {
                    if (graph[currentNode.node][next.node] >= 0)
                    {
                        Node nextNode = new Node(next.node, Math.min(next.distance, currentNode.distance + graph[currentNode.node][next.node]));
                        dist.remove(next);
                        dist.add(nextNode);
                    }
                }

                currentNode = dist.poll();
                if (currentNode.distance == Integer.MAX_VALUE) return -1;
            }

            return currentNode.distance;
        }

        private int[][] createGraph(int[][] times, int n)
        {
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    graph[i][j] = -1;
                }
            }

            for (int[] edge : times)
            {
                int source = edge[0] - 1;
                int target = edge[1] - 1;

                graph[source][target] = edge[2];
            }

            return graph;
        }
    }
}
