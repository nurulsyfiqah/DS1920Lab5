package L5Q6;
import java.util.Stack;

public class Q6Maze {

    static Maze b = new Maze();
    static char[][] maze = b.genMaze();
    final static int startX = b.start()[0], startY = b.start()[1];
    final static int endX = b.end()[0] , endY = b.end()[1];
    private static final int N = maze.length;
    private static final int M = maze[0].length;
    static Q6Stack<MazePosition> s = new Q6Stack<MazePosition>();

    int n = N, m = M;

    private static boolean[][] visited = new boolean[N][M];

    public static void main(String[] args)
    {

        System.out.println("The original maze is ");
        Maze c = new Maze();
        char[][] oriMaze = b.genMaze();
        for (int i = 0; i < oriMaze.length; i++){
            for (int j = 0; j < oriMaze[i].length; j++){
                System.out.print(oriMaze[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("The Solution is");

        //unvisited = true
        setVisited(true);
        if (isReachable(maze)){
            print();
        }
        else
            System.out.println("BOOOO! You didnt meet the end\n");

    }

    private static void setVisited(boolean b){
        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[i].length; j++){
                visited[i][j] = b;
            }
        }
    }

    public static void swap(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
                if(visited[i][j]==false && maze[i][j]!='S' && maze[i][j]!='F'){
                    maze[i][j]='.';
                }
            }
        }
    }

    public static void print(){
        swap();
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isReachable(char[][] maze){
        // Initial.
        int i = startX, j = startY;

        // Coordinates of end
        int fx, fy;
        fx = endX;
        fy = endY;

        MazePosition temp = new MazePosition(i, j);

        s.push(temp);

        while (!s.isEmpty()){

            // Pop the top node and move to the
            // north, east,south,west or retract
            // back
            temp = s.peek();
            int d = temp.getDir();
            i = temp.getX();
            j = temp.getY();

            // Increment the direction and
            // push the node in the stack again.
            temp.setDir(temp.getDir() + 1);
            s.pop();
            s.push(temp);

            // If we reach the F
            // return true
            if (i == fx && j == fy){
                return true;
            }

            if (d == 0){
                // north
                if (i - 1 >= 0 && maze[i - 1][j] != '#' && visited[i - 1][j]){
                    MazePosition temp1 = new MazePosition(i - 1, j);
                    visited[i - 1][j] = false;
                    s.push(temp1);
                }
            }
            else if (d == 1){
                // west
                if (j - 1 >= 0 && maze[i][j - 1] != '#' && visited[i][j - 1]){
                    MazePosition temp1 = new MazePosition(i, j - 1);
                    visited[i][j - 1] = false;
                    s.push(temp1);
                }
            }
            else if (d == 2){
                // south
                if (i + 1 < N && maze[i + 1][j] != '#' && visited[i + 1][j])
                {
                    MazePosition temp1 = new MazePosition(i + 1, j);
                    visited[i + 1][j] = false;
                    s.push(temp1);
                }
            }
            else if (d == 3){
                // east
                if (j + 1 < M && maze[i][j + 1] != '#' && visited[i][j + 1]){
                    MazePosition temp1 = new MazePosition(i, j + 1);
                    visited[i][j + 1] = false;
                    s.push(temp1);
                }
            }

            // backtracking
            else{
                visited[temp.getX()][temp.getY()] = true;
                s.pop();
            }
        }

        // If the stack is empty and
        // no path is found return false.
        return false;
    }

    static class MazePosition{
        private int x, y;
        private int dir;

        public MazePosition(int i, int j){
            this.x = i;
            this.y = j;

            // default = north
            this.dir = 0;
        }

        public int getX(){
            return x;
        }

        public void setX(int x){
            this.x = x;
        }

        public int getY(){
            return y;
        }

        public void setY(int y){
            this.y = y;
        }

        public int getDir(){
            return dir;
        }

        public void setDir(int dir){
            this.dir = dir;
        }
    }

}
