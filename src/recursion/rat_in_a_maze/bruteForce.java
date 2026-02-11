package recursion.rat_in_a_maze;

import java.util.ArrayList;

public class bruteForce
{
    public static void main(String[] args)
    {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ArrayList<String> result = ratInMaze(maze);

        System.out.println(result);
    }

    public static ArrayList<String> ratInMaze(int[][] maze)
    {
        ArrayList<String> pos = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        if(maze[0][0] == 0) return pos;

        int n = maze.length;
        int m = maze.length;
        boolean[][] visited = new boolean[n][m];
        findWays(maze, pos, visited, path, 0, 0);

        return pos;
    }

    public static void findWays(
            int[][] maze,
            ArrayList<String> pos,
            boolean[][] visited,
            StringBuilder path,
            int row, int col
    ){
        if(row == maze.length - 1 && col == maze.length - 1)
        {
            pos.add(path.toString());
            return;
        }

        visited[row][col] = true;

        //down
        if(row + 1 < maze.length && !visited[row + 1][col] && maze[row + 1][col] == 1)
        {
            path.append("D");
            findWays(maze, pos, visited, path, row + 1, col);
            path.deleteCharAt(path.length() - 1);
        }

        //left
        if(col - 1 >= 0 && !visited[row][col - 1] && maze[row][col - 1] == 1)
        {
            path.append("L");
            findWays(maze, pos, visited, path, row, col - 1);
            path.deleteCharAt(path.length() - 1);
        }

        //right
        if(col + 1 < maze.length && !visited[row][col + 1] && maze[row][col + 1] == 1)
        {
            path.append("R");
            findWays(maze, pos, visited, path, row, col + 1);
            path.deleteCharAt(path.length() - 1);
        }

        //up
        if(row - 1 >= 0 && !visited[row - 1][col] && maze[row - 1][col] == 1)
        {
            path.append("U");
            findWays(maze, pos, visited, path, row - 1, col);
            path.deleteCharAt(path.length() - 1);
        }

        visited[row][col] = false;
    }
}
