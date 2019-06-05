package face.suanfa;

/**
 * Create by lifan.
 * Date: 2019/5/30.
 * Time: 16:11.
 */
public class OneDirectionList<T> {

    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void add(T t) {
        //根据参数创建一个节点
        Node<T> node = new Node<T>(t);
        //当链表为空时，记录head节点
        if(head == null) {
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }

    public void reverse(){
        Node<T> curr = head.next;

        head.next = null;

        while(curr != null){
            Node<T> next = curr.next;

            curr.next = head;
            head = curr;
            curr = next;
        }
    }

    public void getAll(){
        Node<T> curr = head;
        while(curr != null){
            System.out.println(curr.t);
            curr = curr.next;
        }
    }



    public static void main(String[] args) {
        OneDirectionList<Integer> list = new OneDirectionList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.getAll();
        list.reverse();
        list.getAll();
//        Integer i = 1;
//        i += (i << 15) ^ 0xffffcd7d;
//
//        System.out.println(Integer.toBinaryString(-1));

    }

    static class Node<T>{
        Node<T> next;
        T t;

        Node(T t) {
            this.t = t;
        }

    }

}


