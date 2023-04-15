package zeus.arithmetic;

public class SearchInsert {
	/**
	 * 给定一个排序数组和一个目标值，
	 * 在数组中找到目标值，并返回其索引。
	 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 如此查找效率低,考虑是数组,试试二分查找
	 *	for (int i = 0; i < nums.length; i++) {
	 *		//如果target存在于nums中
	 *		if (nums[i] == target) {
	 *			return i;
	 *		}
	 *	}
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int nums[], int target) {
		//为什么不是nums.length-1?因为target可能是插入的最后一个元素
		int len = nums.length;			
		//特殊判断
		if (nums[len-1] < target) return len;
		
		int left = 0;
		int right = len-1;
		//在区间nums[left...right]中找到1个大于target的元素下标
		while (left < right) {
			int mid = (left+right)/2;
			if (nums[mid] < target) {
				//下一轮搜索区间是[mid+1,right]
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	public static void main(String args[]) {
		int[] nums = {1,3,4,7,9};
		int res = searchInsert(nums, 6);
		System.out.println(res);
		for (int value : nums) {
			System.out.print(value+",");
		}
	}
}










