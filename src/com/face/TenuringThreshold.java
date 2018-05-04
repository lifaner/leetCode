package com.face;

public class TenuringThreshold {
    private static final int _1M = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4];
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];
    }

    public void MinorGC(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[3 * _1M];
        System.out.println(allocation1.length);
        allocation2 = new byte[3 * _1M];
        System.out.println();
        allocation3 = new byte[4 * _1M];
    }

    public static void main(String[] args) {
//        TenuringThreshold.testTenuringThreshold();
        TenuringThreshold s = new TenuringThreshold();
        s.MinorGC();
    }
}
