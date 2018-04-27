package com.face;

public class ReferenceCountingGC {
    public Object instance;

    private static final int _1M = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1M];

    public static void main(String[] args) {

        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();
        obj1.instance = obj2;
        obj2.instance = obj2;

        obj1 = null;
        obj2 = null;

        System.gc();

    }
}
