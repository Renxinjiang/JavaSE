public class Main {
    private static List getArrayList(){
        return new ArrayList();
    }
    private static List getLinkedList(){
        return new Linkedlist();
    }

    private static void fill(List list){
        list.pushBack(0);
        list.pushBack(1);
    }
    public static void main(String[] args) {
        // list1 是一个 List 接口类型的引用，指向一个 ArrayList 类类型的对象
        List list1 = new ArrayList();
        List list2 = getArrayList();
        List list3 = new Linkedlist();
        List list4 = getLinkedList();
        fill(list1);
        fill(list2);

    }
}
