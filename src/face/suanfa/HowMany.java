package face.suanfa;

public class HowMany {

    private int jiSuan(int n){

        if(n<=0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return jiSuan(n-1) + jiSuan(n-2);
    }

    public static void main(String[] args) {
        HowMany hm = new HowMany();
        int i = hm.jiSuan(9);
        System.out.println(i);
    }

}
