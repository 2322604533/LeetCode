package zeus.arithmetic;

public class UniquePaths {
	
	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m,int n) {
		if (m <= 0 || n <= 0) return 0;
		
		int[][] paths = new int[m][n];
		
		// init paths[][]
		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;	//row
		}
		
		for (int j = 0; j < n; j++) {
			paths[0][j] = 1;	//col
		}
		
		// push to paths[i][j] = paths[i-1][j] + paths[i][j-1]
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
				
		}
		
		return paths[m-1][n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = uniquePaths(7, 3);
		System.out.println("res:"+res);
	}

}
