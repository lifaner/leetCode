package leetcode.array;

/**
 * 买卖股票的最佳时机 II
 * Create by lifan.
 * Date: 2018/7/18.
 * Time: 11:03.
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int lirun = 0;
        int ru = -1;//买入下标
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                ru = i - 1;//可以买入
                lirun += prices[i] - prices[ru];
                continue;
            }
            if (ru == -1) continue;
            if (prices[i] > prices[i - 1]) {
                lirun += prices[i] - prices[i - 1];
            } else {
                ru = -1;
            }
        }
        return lirun;
    }

    public static int maxProfit1(int[] prices) {
        int lirun = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                lirun += prices[i] - prices[i - 1];
            }
        }
        return lirun;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        long start = System.currentTimeMillis();
        int lirun = maxProfit1(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start));
        System.out.println(lirun);
    }

}
