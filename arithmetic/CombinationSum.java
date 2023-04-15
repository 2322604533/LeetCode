package zeus.arithmetic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int candidates[], int target) {
		
		List<List<Integer>> resList = new ArrayList<>();
		
		int len = candidates.length;

		if (len == 0) return resList;
		
		
		// 排序是减枝的前提,因此将其排序
		Arrays.sort(candidates);
		
		Deque<Integer> pathDeque = new ArrayDeque<>();
		
		dfs(candidates,0,len,target,pathDeque,resList);
		
		return resList;
	}
	

	private static void dfs(int[] candidates, int beign, int len, int target, Deque<Integer> pathDeque,
			List<List<Integer>> resList) {
		// TODO Auto-generated method stub
	
		for (int i = beign; i < len; i++ ) {
			if (target - candidates[i] < 0) break;
			
			pathDeque.addLast(candidates[i]);
			
			dfs(candidates, i, len, target - candidates[i], pathDeque, resList);
			
			pathDeque.removeLast();
		}
		
		// 由于进入更深层的时候,小于0的部分被剪掉
		if (target == 0) {
			resList.add(new ArrayList<>(pathDeque));
			return ;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,6,7};
		List<List<Integer>> lists = combinationSum(nums, 7);
		
		for (List<Integer> list : lists) {
			System.out.println("list:"+list);
		}
	}

}
