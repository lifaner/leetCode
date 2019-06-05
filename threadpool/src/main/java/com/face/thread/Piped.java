package com.face.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Create by lifan.
 * Date: 2019/6/5.
 * Time: 13:50.
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        int receive = 0;
        try {
            while((receive = System.in.read()) != -1){
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        public void run() {
            int receive = 0;
            try {
                while((receive = in.read()) != -1){
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}