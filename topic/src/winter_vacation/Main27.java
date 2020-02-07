package winter_vacation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main27
 * @Description:
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author: 呆呆
 * @date: 2020/2/7
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }
}
public class Main27 {
    /**
     * 1.广度优先遍历：每层保留最右边结点
     * BFS用两个队列同步记录层数和节点，
     * 只有当队列为空或者队列下一个节点与当前节点不在同一层时，我们可以看到
     */
    /**
     * 2.深度优先遍历：每次先遍历右子树
     * DFS，先遍历右子树，再考虑左子树，
     * 只有当遍历的层数是第一次出现，我们添加到结果中。
     * 由于先右子树遍历，再左子树遍历，因此确保了每一层最先遍历的都是这层的最右边节点。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root,res);
        //dfs(root,res,0);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        if(root == null) return;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue1.add(root);
        queue2.add(0);
        while(!queue1.isEmpty()) {
            TreeNode cur = queue1.poll();
            int gene = queue2.poll();
            if(queue2.isEmpty() || queue2.peek() != gene){
                res.add(cur.val);
            }
            if(cur.left != null) {
                queue1.add(cur.left);
                queue2.add(gene + 1);
            }
            if(cur.right != null) {
                queue1.add(cur.right);
                queue2.add(gene + 1);
            }
        }
    }

    private void dfs(TreeNode root, List<Integer> res, int deep) {
        if(root == null) return;
        if(deep >= res.size()) { //只有当深度deep 不小于res的大小(即已经看到的层数)时，我们认为这个是新一层的最右边
            res.add(root.val);
        }
        if(root.right != null) dfs(root.right, res, deep + 1);//先右后左
        if(root.left != null) dfs(root.left, res, deep + 1);
    }
}
