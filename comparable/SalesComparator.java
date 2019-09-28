package comparable;

import java.util.Comparator;

/**
 * @PackageName: comparable
 * @ClassName: SalesComparator
 * @Description: 销量比较器
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class SalesComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.sales - o2.sales;
    }
}
