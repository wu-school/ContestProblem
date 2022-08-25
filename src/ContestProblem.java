import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class ContestProblem { //solution
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("Judges Input File.txt"));
        while(scan.hasNext()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(a+"x"+b+":"+calculatePaths(a,b) + " unique paths");
        }
    }    

    public static long calculatePaths(int x, int y){ 
        //each point on the array is corresponding to a vertex, where [0][0] is the starting point
        //the value in the array is the number of possible paths leading to that vertex from the initial starting point
        
        long[][] grid = new long[x+1][y+1];

        for(int i=0; i<grid.length; i++){
            //the only way to get to any of the verticies in the leftmost column is by moving straight down
            grid[i][0] = 1;
        }
        for(int i=0; i<grid[0].length; i++){
            //the only way to get to any of the verticies on the top row is through a straight line
            grid[0][i] = 1;
        }
        

        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                //for each vertex, the only possible ways to get to the vertex are from its adjacent north vertex or adjacent western vertex
                //thus the number of unique ways to get to the selected vertex is the sum of the number of paths from the origin to the northern and western verticies
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

}
