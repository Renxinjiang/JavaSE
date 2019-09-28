package comparable;

import java.util.Comparator;

/**
 * @PackageName: comparable
 * @ClassName: Book
 * @Description:
 * 1. 图书类，自然顺序按isbn从小到大
 * 2. 设计比较器（按书名、作者、价格、销量、评论数）
 * 3. 排序并打印
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class Book implements Comparable<Book>{
    String ISBN;
    String author;
    String title;
    int price;
    int sales;
    int comment;

    //alt+insert
    //shift 全选

    public Book(String ISBN, String author, String title, int price, int sales, int comment) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.price = price;
        this.sales = sales;
        this.comment = comment;
    }

    @Override
    public int compareTo(Book o) {
        return ISBN.compareTo(o.ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", comments=" + comment +
                '}'+'\n';
    }
}
