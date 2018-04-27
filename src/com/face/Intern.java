package com.face;

public class Intern {

    public static boolean inPool(String s) {
        String s2 = s.intern();
        if (s2 == s)
            return true;
        return false;
    }

    public static void main(String[] args) {

        System.out.println(inPool(new String("ja") +"va"));

//        String s2 = new StringBuilder("jax").append("va").toString();
//        s2.intern();
//        String s4 = "jaxva";
//        System.out.println(s4 == s2);
//        String s1 = new StringBuilder("ja").append("va").toString();
//        s1.intern();
//        String s3 = "java";
//        System.out.println(s3 == s1);
    }
}
