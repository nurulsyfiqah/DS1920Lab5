package L5Q6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    char[][] maze = new char[10][20];

    public char[][] genMaze() {
        try {
            Scanner s = new Scanner(new FileInputStream("maze.txt"));
            int x = 0;
            while (s.hasNextLine()) {
                String str = "";
                int y = 0;
                str += s.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    maze[x][y] = str.charAt(i);
                    y++;
                }
                x++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        return maze;
    }

    public int[] start(){
        int x=0,y=0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j]=='S'){
                    x=i;
                    y=j;
                }
            }
        }
        return new int[]{x, y};
    }

    public int[] end(){
        int x=0,y=0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j]=='F'){
                    x=i;
                    y=j;
                }
            }
        }
        return new int[]{x, y};
    }
}
