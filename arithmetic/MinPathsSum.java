package Zeus.arithmetic;

public class MinPathsSum {

	public static int minPathsSum(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		int paths[][] = new int[row][col];
		
		paths[0][0] = grid[0][0];
		
		//init row
		for (int i = 1; i < row; i++) 
			paths[i][0] = paths[i-1][0] + grid[i][0];
		
		
		//init col
		for (int j = 1; j < col; j++) {
			paths[0][j] = paths[0][j-1] + grid[0][j];
		}
		
		/// push to min{paths[j][i]}
		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++)
				paths[i][j] = Math.min(paths[i-1][j], paths[i][j-1]) + grid[i][j];
		
		return paths[row-1][col-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		int res = minPathsSum(grid);
		System.out.println("res:"+res);
	}

}







