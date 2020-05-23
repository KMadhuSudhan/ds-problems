package ds.problems.matrix;
//https://leetcode.com/problems/island-perimeter/
//463. Island Perimeter

public class _463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1) //if its a land
                {
                    //IF:Checking out of bound conditions on all 4 sides. (because even they add up to the perimeter.)
                    //ELSE IF:And if it isnt out of bounds check if it has water on that side.
                    if(i-1<0) count++;
                    else if(grid[i-1][j]==0) count++;

                    if(i+1>=grid.length) count++;
                    else if(grid[i+1][j]==0) count++;

                    if(j+1>=grid[i].length) count++;
                    else if(grid[i][j+1]==0) count++;

                    if(j-1<0) count++;
                    else if(grid[i][j-1]==0) count++;
                }
            }
        }
        return count;
    }
}
