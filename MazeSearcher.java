
// MazeSearcher.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Jan 2021
/* 
   Usage:
      java MazeSearcher maze1.txt    (maze2.txt)
*/

import java.io.*;
import java.util.*;

public class MazeSearcher {
    private static final int[][] STEPS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // (dx, dy)
    // DOWN RIGHT UP LEFT

    public MazeSearcher(Maze maze) {
        ArrayList<Coord> path = new ArrayList<>();
        Coord entry = maze.getStart();
        if (explore(maze, entry.getX(), entry.getY(), path)) {
            maze.printPath(path);
        } else
            System.out.println("No path found");
    } // end of MazeSearcher()

    private boolean explore(Maze maze, int x, int y, ArrayList<Coord> path) {
        // Students: put your code here
        if (!maze.isValidLoc(x, y) || maze.wasVisited(x, y) || maze.isWall(x, y)) {
            return false;
        }
        // this ^^upper^^ if check:
        // 1) Is current point outside?
        // 2) Is current point here yet?
        // 3) Is current point a wall?
        path.add(new Coord(x, y)); // add a new path
        maze.setVisited(x, y);
        if (maze.isExit(x, y)) {
            return true;
        }
        // this ^^upper^^ if check: Is current coordinate a goal?
        for (int[] step : STEPS) {
            Coord coord = getNextCoord(x, y, step);
            if (explore(maze, coord.getX(), coord.getY(), path)) { //
                return true;
            }
        }
        // the ^^upper^^ for loop to get the next coordinate until can go to E
        path.remove(path.size() - 1); // remove this path
        return false; // and return false to create a new path when its cant go to E
    } // end of explore()

    // Students: you can add other functions if you wish
    private Coord getNextCoord(int x, int y, int[] step) {
        return new Coord(x + step[0], y + step[1]);
    }
    // --------------------------------------------

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            System.out.println("Usage: java MazeSearcher <maze textfile>");
        else {
            Maze maze = new Maze(new File(args[0]));
            MazeSearcher dfs = new MazeSearcher(maze);
        }
    }

} // end of MazeSearcher class
