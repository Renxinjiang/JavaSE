import java.util.Arrays;
public class ArrayList extends List{
    private int[] array = new int[10];

    @Override
    public void insert(int index, int element) {
        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = element;
        size++;
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,0,size)));
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.pushFront(2);
        list.pushFront(1);
        list.pushBack(3);
        list.pushBack(4);
        list.insert(2,100);
    }
}
