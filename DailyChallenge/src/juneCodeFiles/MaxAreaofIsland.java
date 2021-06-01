package juneCodeFiles;

class Solution {
    public int dfs(int[][] grid, boolean[][] visited, int current_x, int current_y){
        if(current_x<0 || current_x>=grid.length || current_y<0 || current_y>=grid[0].length || visited[current_x][current_y] || grid[current_x][current_y]==0)
            return 0;
        
        int l_dist = 0;
        int r_dist = 0;
        int top_dist = 0;
        int bottom_dist = 0;
        
        visited[current_x][current_y]=true;
        
        l_dist =
            dfs(grid, visited, current_x-1, current_y);
        r_dist = 
            dfs(grid, visited, current_x+1, current_y);
        top_dist = 
            dfs(grid, visited, current_x, current_y-1);
        bottom_dist= 
            dfs(grid, visited, current_x, current_y+1);
        
        return 1+l_dist+r_dist+top_dist+bottom_dist;
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max_area_island=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int current_area = dfs(grid, visited,i ,j);
                    max_area_island = current_area>max_area_island?current_area:max_area_island;
                }
            }
        }
        
        return max_area_island;
    }
}

public class MaxAreaofIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		int[][] grid1 = new int[][] {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
				
		System.out.println(s.maxAreaOfIsland(grid1));
		
		int[][] grid2 = new int[][] {{0,0,0,0,0,0,0,0}};
		System.out.println(s.maxAreaOfIsland(grid2));
	}

}
