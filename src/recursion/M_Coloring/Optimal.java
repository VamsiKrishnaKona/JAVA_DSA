package recursion.M_Coloring;

import java.util.ArrayList;

public class Optimal
{
    public static void main(String[] args)
    {
        int[][] edges = {
                {0, 1},{1, 3},{2, 3},{3, 0},{0, 2}
        };

        int v = 4;
        int m = 3;

        boolean value = graphColoring(v, edges, m);

        System.out.println(value);
    }

    static boolean graphColoring(int v, int[][] edges, int m)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < v ; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < edges.length ; i++)
        {
            //graph[edges[i][0]].add(edges[i][1]);
            graph.get(edges[i][0]).add(edges[i][1]);
            //graph[edges[i][1]].add(edges[i][0]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int[] colorsPainted = new int[v];

        return solve(v, graph, colorsPainted, m, 0);
    }

    static boolean solve(int v, ArrayList<ArrayList<Integer>> graph, int[] colorsPainted, int m, int node)
    {
        if(node == v) return true;

        for(int i = 1 ; i <= m ; i++)
        {
            if(isSafe(graph, colorsPainted, i, node))
            {
                colorsPainted[node] = i;
                if(solve(v, graph, colorsPainted, m, node + 1))
                {
                    return true;
                }
                colorsPainted[node] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(ArrayList<ArrayList<Integer>> graph, int[] colorsPainted, int color, int node)
    {
        for(int i : graph.get(node))
        {
            if(colorsPainted[i] == color)
            {
                return false;
            }
        }
        return true;
    }
}
