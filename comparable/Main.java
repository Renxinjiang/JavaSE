package comparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @PackageName: comparable
 * @ClassName: BookSort
 * @Description:
 * 1. 图书类，自然顺序按isbn从小到大
 * 2. 设计比较器（按书名、作者、价格、销量、评论数）
 * 3. 排序并打印
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("00123456","AAA","Abook",30,60,20));
        books.add(new Book("00523456","BBB","Bbook",60,80,28));
        books.add(new Book("00623456","EEE","Ebook",50,20,69));
        books.add(new Book("00323456","KKK","Kbook",200,10,23));
        books.add(new Book("00223456","ZZZ","Zbook",40,90,70));
        books.add(new Book("00423456","GGG","Gbook",10,50,20));

        List<Book> copy;
        // 按自然顺序（ISBN）排序
        System.out.println("按 ISBN 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy);
        System.out.println(copy);

        // 按书名排序
        System.out.println("按 书名 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new TitleComparator());
        System.out.println(copy);

        // 按作者排序
        System.out.println("按 作者 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new AuthorComparator());
        System.out.println(copy);

        // 按价格排序-从小到大
        System.out.println("按 价格-从小到大 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new PriceComparator(true));
        System.out.println(copy);

        // 按价格排序-从大到小
        System.out.println("按 价格-从大到小 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new PriceComparator(false));
        System.out.println(copy);

        // 按销量排序
        System.out.println("按 销量 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new SalesComparator());
        System.out.println(copy);

        // 按评论数排序
        System.out.println("按 评论量 排序：");
        copy = new ArrayList<>(books);
        Sort.sort(copy, new CommentComparator());
        System.out.println(copy);
    }

}

