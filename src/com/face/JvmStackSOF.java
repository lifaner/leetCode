package com.face;

public class JvmStackSOF {

    private int stacklength = 1;

    public void statkLeak(){
        stacklength++;
        statkLeak();
    }

    public static void main(String[] args) {
        JvmStackSOF j = new JvmStackSOF();
        try {
            j.statkLeak();
        } catch (Exception e) {
            System.out.println(j.stacklength);
        }
    }
}
