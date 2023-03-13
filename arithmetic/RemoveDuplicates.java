package Zeus.arithmetic;

public class RemoveDuplicates {
	/**
	 * 返回非重复项	
	 * @param nums {0,0,1,1,1,2,2,3,3,4}
	 * @return	9
	 */
	public static int removeDuplicates(int[] nums) {
		 int len = nums.length;
		 
		 if (len <= 2) return len;
		 
		 int slow = 2, fast = 2;
		 
		 while (fast < len) {
			 if (nums[slow-2] != nums[fast]) {
				 nums[slow] = nums[fast];
				 slow++;
			 }
			 fast++;
		 }
		 return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,1,1,1,2,2,3,3,4};
		int k = removeDuplicates(nums);
		System.out.println("k : "+k);
		for (int i = 0; i < k; i++)
			System.out.print(nums[i]+",");
	}

}
