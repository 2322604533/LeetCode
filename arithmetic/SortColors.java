package zeus.arithmetic;

public class SortColors {

	public static void sortColors(int[] nums) {
		int len = nums.length;
		if (len < 2) return ;

		// zero = 0,i = zero,two = len;
		int zero = 0, i = 0, two = len;
		while (i < two) {
			if (nums[i] == 0) {
				swap(nums,i,zero);
				zero++;i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				two--;
				swap(nums, i, two);
			}
		}
		
	}
	
	private static void swap(int[] nums, int value1, int value2) {
		// TODO Auto-generated method stub
		int temp = nums[value1];
		nums[value1] = nums[value2];
		nums[value2] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,0,2,1,1,0,1,2};
		sortColors(nums);
		for (int value : nums) {
			System.out.print(value+",");
		}
	}

}
