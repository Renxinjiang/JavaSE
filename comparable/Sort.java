package comparable;

import java.util.Comparator;
import java.util.List;

/**
 * @PackageName: comparable
 * @ClassName: Sort
 * @Description: 图书排序
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class Sort {
    public static void sort(List<Book> books) {
        for (int i = 1;i < books.size();i++){
            int j = i - 1;
            Book book = books.get(i);
            // books.get(j).compareTo(book) > 0 是 books.get(j) > book
            for (;j >= 0 && books.get(j).compareTo(book) > 0;j--){
                books.set(j+1,books.get(j));
            }
            books.set(j+1,book);
        }
    }

    public static void sort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1;i < books.size();i++){
            int j = i - 1;
            Book book = books.get(i);
            // comparator.compare(books.get(j),book) > 0是 books.get(j) > book
            for (;j >= 0 && comparator.compare(books.get(j),book) > 0;j--){
                books.set(j+1,books.get(j));
            }
            books.set(j+1,book);
        }
    }

}
