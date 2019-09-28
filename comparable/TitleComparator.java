package comparable;

import java.util.Comparator;

/**
 * @PackageName: comparable
 * @ClassName: TitleComparator
 * @Description: 书名比较器
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}
