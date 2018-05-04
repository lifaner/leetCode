package com.face;

public class FinalizedEscapeGC {
    public static FinalizedEscapeGC SAVE_HOOK = null;

    public void isSave(){
        System.out.println("yes,i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize function is execute！");
        FinalizedEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizedEscapeGC();
        SAVE_HOOK = null ;
        System.gc();//
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isSave();
        }else{
            System.out.println("no.i am dead");
        }

        SAVE_HOOK = null ;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isSave();
        }else{
            System.out.println("no.i am dead");
        }
    }
}
