public interface List {
    void pushFront(int element);
    void pushBack(int element);
    void insert(int index,int element);
}

//抽象类实现接口   父类覆写两个方法，留下一个子类覆写
abstract class AbstractList implements List{
    protected int size = 0;
    @Override
    public void pushFront(int element) {
        insert(0,element);
    }

    @Override
    public void pushBack(int element) {
        insert(size,element);
    }
}

//子类覆写insert
class ArrayList extends AbstractList implements List {
    int[] array = new int[100];
    @Override
    public void insert(int index, int element) {
        for (int i = size;i < index;i++){
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }
}

class Node{
    int val;
    Node next ;
}
class Linkedlist extends AbstractList implements List {
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
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
            node.next = null;
        }else{
            Node prev = head;
            for (int i = 0;i < index-1;i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }
}