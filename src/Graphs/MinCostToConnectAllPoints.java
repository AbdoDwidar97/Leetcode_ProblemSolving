package Graphs;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class MinCostToConnectAllPoints
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints2(new int[][]{{0,0}, {2,2}, {3,10}, {5,2}, {7,0}}));
    }

    private static class Solution
    {
        public int minCostConnectPoints(int[][] points)
        {
            int minSum = 0;
            int[][] myDistancesGraph = createDistancesGraph(points);
            HashSet<Integer> visitedPoints = new HashSet<>();
            HashSet<String> availPoints = new HashSet<>();
            Queue<Integer> unvisitedPoints = new ArrayDeque<>();

            unvisitedPoints.add(0);

            while (!unvisitedPoints.isEmpty())
            {
                int currentPoint = unvisitedPoints.poll();
                visitedPoints.add(currentPoint);

                if (visitedPoints.size() == points.length) return minSum;

                int[] children = myDistancesGraph[currentPoint];

                for (int j = 0; j < children.length; j++)
                {
                    if (currentPoint != j && !visitedPoints.contains(j))
                    {
                        availPoints.add(currentPoint + " " + j + " " + myDistancesGraph[currentPoint][j]);
                    }
                }

                int minDistance = children[currentPoint];
                int destinationIndex = currentPoint;
                int mSourceIndex = currentPoint;
                for (String edge : availPoints)
                {
                    String[] edgeArr = edge.split(" ");
                    int source = Integer.parseInt(edgeArr[0]);
                    int destination = Integer.parseInt(edgeArr[1]);
                    int distance = Integer.parseInt(edgeArr[2]);

                    if (!visitedPoints.contains(destination) && distance < minDistance)
                    {
                        minDistance = distance;
                        destinationIndex = destination;
                        mSourceIndex = source;
                    }

                }

                unvisitedPoints.add(destinationIndex);
                minSum += minDistance;
                availPoints.remove(mSourceIndex + " " + destinationIndex + " " + minDistance);
            }

            return minSum;
        }

        private int[][] createDistancesGraph (int[][] points)
        {
            int [][] distances = new int[points.length][points.length];

            for (int i = 0; i < points.length; i++)
            {
                for (int j = 0; j < points.length; j++)
                {
                    if (i == j) distances[i][j] = Integer.MAX_VALUE;
                    else
                    {
                        int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                        distances[i][j] = distance;
                    }
                }
            }

            return distances;
        }

        /// -----------------------------------------------------------------------------

        public int minCostConnectPoints2(int[][] points)
        {
            int minSum = 0, currentPointIdx = 0, nextPointIdx = 0;

            int[] minDists = new int[points.length];
            HashSet<Integer> visitedPoints = new HashSet<>();
            visitedPoints.add(0);

            for (int i = 0; i < minDists.length; i++) minDists[i] = Integer.MAX_VALUE;

            while (visitedPoints.size() < points.length)
            {
                int minDist = Integer.MAX_VALUE;
                for (int next = 0; next < minDists.length; next++)
                {
                    if (!visitedPoints.contains(next))
                    {
                        int dist = Math.abs(points[next][0] - points[currentPointIdx][0]) + Math.abs(points[next][1] - points[currentPointIdx][1]);
                        if (dist < minDists[next])
                        {
                            minDists[next] = dist;
                        }
                        if (minDists[next] < minDist)
                        {
                            minDist = minDists[next];
                            nextPointIdx = next;
                        }
                    }
                }

                minSum += minDist;
                currentPointIdx = nextPointIdx;
                visitedPoints.add(currentPointIdx);
            }

            return minSum;
        }
    }
}
