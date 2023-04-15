package zeus.arithmetic;

public class Jump {
	
	/**
	 * 
	 * @param nums {2,3,1,1,4}
	 * @return
	 */
	public static int jump(int[] nums) {
		//The starting range of the first jump is [0,0]
		int end = 0, steps = 0, maxPosition = 0;
		
		for (int i = 0; i < nums.length-1; i++) {
			//Update the farthest reachable index of this jump.
			maxPosition = Math.max(maxPosition, i + nums[i]);
		
			//if we finish the starting range of this jump,
			//Move on to the starting range of the next jump.
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
	
		return steps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,1,1,4};
		int res = jump(nums);
		System.out.println("res:"+res);
	}

}
