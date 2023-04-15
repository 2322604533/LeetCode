package zeus.arithmetic;

/**
 * 最长公共前缀
 * @author 23226
 *
 */
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		//公共前缀比所有的字符串都短,选择出任意一个
		String ans = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for ( ; j < ans.length() && j < strs[i].length(); j++) {
				if (ans.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			ans = ans.substring(0,j);
			if (ans.equals("")) {
				return "";
			}
		}
		return	ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"aa","aaa","abb"};
		System.out.println(longestCommonPrefix(strs));
	
	}

}
