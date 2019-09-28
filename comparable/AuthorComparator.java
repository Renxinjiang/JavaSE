package comparable;

import java.util.Comparator;

/**
 * @PackageName: comparable
 * @ClassName: AuthorComparator
 * @Description: 作者比较器
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class AuthorComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.author.compareTo(o2.author);
    }
}
