package comparable;

import java.util.Comparator;

/**
 * @PackageName: comparable
 * @ClassName: CommentComparator
 * @Description: 评论比较器
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class CommentComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.comment - o2.comment;
    }
}
