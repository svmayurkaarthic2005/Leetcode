import java.util.*;

// 337. House Robber III
// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

// Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

// Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
// Input: root = [3,2,3,null,3,null,1]
// Output: 7
// Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

public class HouseRobberIII {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode nodes[] = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (!s.equals("-"))
                nodes[i] = new TreeNode(Integer.parseInt(s));
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null)
                continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n)
                nodes[i].left = nodes[left];
            if (right < n)
                nodes[i].right = nodes[right];
        }
        System.out.println(houseRobber(nodes[0]));
    }

    public static int houseRobber(TreeNode root) {
        int dp[] = dfs(root);
        return Math.max(dp[0], dp[1]);

    }

    public static int[] dfs(TreeNode root) {
        if (root == null)
            return new int[2];
        int left_tree[] = dfs(root.left);
        int right_tree[] = dfs(root.right);

        int dp[] = new int[2];
        dp[0] = root.data + left_tree[1] + right_tree[1];
        dp[1] = Math.max(left_tree[0], left_tree[1]) + Math.max(right_tree[0], right_tree[1]);
        return dp;

        /*
         * rob
         * A[]=SkipB+SkipC
         * skip rob
         * skipA[]= Math.max(B[rob],B[skip])+Math.max(C[rob],C[skip])
         * 
         * 
         */
    }
}
