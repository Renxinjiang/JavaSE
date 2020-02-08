package winter_vacation;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @PackageName: winter_vacation
 * @ClassName: Main28
 * @Description:
 * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
 * 例如，有一条路线 routes[0] = [1, 5, 7]，
 * 表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
 *
 * 假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。
 * 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。

 * @author: 呆呆
 * @date: 2020/2/8
 */
public class Main28 {
    /**
     * 我们将每一条公交路线（而不是每一个车站）看成图中的一个点，
     * 如果两条公交路线有交集，那么它们在图中对应的点之间就有一条边。
     * 此外，起点站 S 和终点站 T 也分别是图中的一个点，
     * 如果一条公交路线包含了 S 或 T，那么也需要和 S 或 T 对应的点连一条边。
     * 此时，在这个图上从 S 到 T 的最短路径长度即为答案，我们可以用广度优先搜索来找出最短路径。
     *
     * 在计算两条公交路线是否有交集时，可以用的方法有很多种。
     * 例如将公交路线放在集合中，检查两个集合的交集是否为空；
     * 或者将公交路线中的车站进行递增排序，并使用双指针的方法检查是否有相同的车站。
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();


        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        
        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0)
                targets.add(i);
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) return depth+1;
            for (Integer nei: graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth+1));
                }
            }
        }

        return -1;
    }

    public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
}