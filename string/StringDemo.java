package string;

import java.util.*;

/**
 * @PackageName: string
 * @ClassName: CommonMethod
 * @Description:
 * https://leetcode-cn.com/problems/subdomain-visit-count/
 * @author: 呆呆
 * @date: 2019/10/17
 */
public class StringDemo {
    /**
     * 思路：
     * 每次遍历数组中的一个元素
     * 1.将元素先切分成数字与后面的域名
     * 2.将切出来String类型的数组转为int型
     * 3.将第一次切分出来的域名按级切分开
     *    切成单独的的单词，再用点拼接成一级一级域名
     * 4.用Map<String,Integer>统计次数
     * 5.遍历Map的Key-Value，拼接
     */
    public List<String> subdomainVisits(String[] cpdomains){
        Map<String,Integer> map = new HashMap<>();
        for (String i : cpdomains){
            //900 google.mail.com
            //用空格切开数字与域名
            String[] a = i.split(" ");
            int count = Integer.valueOf(a[0]);
            String domain = a[1];

            //用.切开每个单词，用\\转义
            String[] b = domain.split("\\.");
            for (int j = 0;j < b.length;j++){
                String[] c = Arrays.copyOfRange(b,j,b.length);
                //join()是静态方法，要通过类名调用
                //用.拼接
                String subdomain = String.join(".",c);
                int oldCount = map.getOrDefault(subdomain,0);
                map.put(subdomain,oldCount + count);
            }
        }
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String,Integer> e : map.entrySet()){
            String domain = e.getKey();
            int count = e.getValue();
            String s = String.format("%d %s",count,domain);
            ret.add(s);
        }
        return ret;
    }
}
