package face.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Create by lifan.
 * Date: 2019/5/29.
 * Time: 9:52.
 */
public class ErFenfa {

    public static int getIndex(int[] x,int left, int right, int target){

        if(left <= right) {
            int index = (right + left) / 2;
            if (x[index] == target) {
                return index;
            } else if (x[index] > target) {
                return getIndex(x, left, index-1, target);
            } else {
                return getIndex(x, index+1, right, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<byte[]> x = new CopyOnWriteArrayList();
        for(int i=0; i < 1000; i++){
            byte[] b = new byte[1024*1024];
            x.add(b);
        }
//        int index = ErFenfa.getIndex(arr, 0, arr.length, 188);
//        System.out.println( index );
        for(byte[] i: x){
            x.remove(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("==============");

    }

}
