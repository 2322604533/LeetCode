package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	
	// 递归
	public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	
	inorder(root,res);
		
		return res;
	}

	private void inorder(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		if (root == null) return ;
		
		inorder(root.left, res);
		res.add(root.val);
		inorder(root.right, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
