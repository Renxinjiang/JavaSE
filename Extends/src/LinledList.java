import java.util.Arrays;

class Node{
    int val;
    Node next;
}
public class LinledList extends List{
    private Node head = null;

    @Override
    public void insert(int index, int element) {
        Node node = new Node();
        node.val = element;
        if (index > size || index < 0){
            System.out.println("下标不合法");
        }
        if (index == 0){
            node.next = head;
            head = node;
        }else if (index == size){
            Node last = head;
            while (last.next != null){
                last = last.next;
            }
            last.next = node;
            node.next = null;
        }else{
            Node prev = head;
            for (int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
        // 1. 把链表中的值复制到一个数组中,方便打印
        int[] array = new int[size];
        Node cur = head;
        int i = 0;
        while (cur != null){
            array[i] = cur.val;
            i++;
            cur = cur.next;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        LinledList list = new LinledList();
        list.pushFront(2);
        list.pushFront(1);
        list.pushBack(3);
        list.pushBack(4);
        list.insert(2,100);
    }
}
