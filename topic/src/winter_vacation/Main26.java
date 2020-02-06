package winter_vacation;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main26
 * @Description:
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * @author: 呆呆
 * @date: 2020/2/6
 */
public class Main26 {
    public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    int max = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            //从每个节点开始搜索
            max = Math.max(max, loop(matrix, Integer.MIN_VALUE, dp, i, j));
        }
    }
    return max;
}
    /**
     * 记忆化搜索
     * @param mat  数据矩阵
     * @param pre  路径中的前一个结点数字
     * @param dp   保存从每个结点开始搜索的最长升序序列的长度
     * @param i    当前位置
     * @param j    当前位置
     * @return
     */
    private int loop(int[][] mat, int pre, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] <= pre) {  //停止搜索条件
            return 0;
        }
        if (dp[i][j] != 0) {  //如果有数据，直接返回
            return dp[i][j];
        }
        int max = 0;  //进行搜索
        max = Math.max(max, loop(mat, mat[i][j], dp, i - 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i + 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j - 1));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j + 1));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}