package com.face.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by lifan.
 * Date: 2019/5/27.
 * Time: 11:26.
 *
 * @description 两个线程分别打印26个英文字母的元音（a, e, i, o, u）和辅音（其他），按字母序输出
 */
public class SortCode {

    public static AtomicInteger curr = new AtomicInteger(97);

    public static void main(String[] args) {
        new YuanThread(curr).start();
        new FuThread(curr).start();
    }

}
