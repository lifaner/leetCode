package com.face;

public class JavaJvmStackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeadByThread() {
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaJvmStackOOM j = new JavaJvmStackOOM();
        j.stackLeadByThread();
    }
}
