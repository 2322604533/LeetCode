package Zeus.arithmetic;

public class NextPermutation {
	
	public static void nextPermutation(int[] nums)  {
		if (nums.length == 1 || nums == null) return ;
		// 从后向前找第一次出现邻近升序的对
		int i = nums.length - 2, j = nums.length - 1; 
		while (i >= 0) {
			if (nums[i] < nums[j]) {
				break;
			}
			i--;j--;
		}
		//本身就是最后一个排列
		if (i < 0) {
			reverse(nums,0,nums.length-1);
			return ;
		}
		
		//从[j,end]中(该序列是个降序列),从后下向前找到她邻近的第一个数k
		//使得nums[j] < nums[k]的k值
		int k = 0;
		for (k = nums.length-1; k >= j; k--) {
			if (nums[i] < nums[k]) break;
		}
		
		//得到k,交换i,k
		swap(nums,i,k);
		//nums[i,end]是降序，改为升序
		reverse(nums, j, nums.length-1);
		return ;
	}
	
	private static void reverse(int[] nums, int l, int r) {
		// TODO Auto-generated method stub
		while (l < r) {
			swap(nums,l,r);
			l++;r--;
		}
	}

	private static void swap(int[] nums, int l, int r) {
		// TODO Auto-generated method stub
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,9,7,5,1};
		nextPermutation(nums);
		for (int value : nums) {
			System.out.print(value+",");
		}
	}

}
